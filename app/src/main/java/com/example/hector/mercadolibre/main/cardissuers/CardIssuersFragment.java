package com.example.hector.mercadolibre.main.cardissuers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hector.mercadolibre.MainActivityListener;
import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.models.CardIssuers;
import com.example.hector.mercadolibre.presenter.PaymentCardIssuersPresenter;
import com.example.hector.mercadolibre.presenter.PaymentMVP;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardIssuersFragment extends Fragment implements OnCardIssuersInteractionListener, PaymentMVP.PaymentCardIssuersView {
    @BindView(R.id.card_issuers_recyclerview) RecyclerView mRecyclerViewCardIssuers;

    private PaymentMVP.PaymentCardIssuersPresenter cardIssuersPresenter;
    private FragmentActivity fragmentActivity;
    private MainActivityListener mListener;

    private String paymentMethodId;

    public static CardIssuersFragment newInstance(String paymentMethodId) {
        CardIssuersFragment cardIssuersFragment = new CardIssuersFragment();
        Bundle args = new Bundle();
        args.putString("paymentMethodId", paymentMethodId);
        cardIssuersFragment.setArguments(args);
        return cardIssuersFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            paymentMethodId = getArguments().getString("paymentMethodId");
        }
    }

    public CardIssuersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_card_issuers, container, false);

        ButterKnife.bind(this, viewRoot);

        cardIssuersPresenter = new PaymentCardIssuersPresenter();
        cardIssuersPresenter.getCardIssuers(getContext(), paymentMethodId);

        return viewRoot;
    }

    private void setRecyclerView(List<CardIssuers> cardIssuersList){
        if(fragmentActivity != null){
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(fragmentActivity);
            mRecyclerViewCardIssuers.setLayoutManager(layoutManager);
            mRecyclerViewCardIssuers.setAdapter(new CardIssuersRecyclerViewAdapter(fragmentActivity, cardIssuersList, this));
            mRecyclerViewCardIssuers.setHasFixedSize(true);

            DividerItemDecoration horizontalDecoration = new DividerItemDecoration(fragmentActivity, DividerItemDecoration.VERTICAL);
            Drawable horizontalDivider = ContextCompat.getDrawable(fragmentActivity, R.drawable.horizontal_divider);
            if (horizontalDivider != null) {
                horizontalDecoration.setDrawable(horizontalDivider);
                mRecyclerViewCardIssuers.addItemDecoration(horizontalDecoration);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        cardIssuersPresenter.setView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivityListener) {
            mListener = (MainActivityListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MainActivityListener");
        }

        if(context instanceof FragmentActivity){
            fragmentActivity = (FragmentActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        fragmentActivity = null;
    }

    @Override
    public void itemSelected(CardIssuers cardIssuers) {
        if(mListener != null)
            mListener.goToInstallment();
    }

    @Override
    public void onSuccesfullGetCardIssuers(List<CardIssuers> cardIssuersList) {
        setRecyclerView(cardIssuersList);
        mListener.hideProgressLayout();
    }

    @Override
    public void onFailureGetCardIssuers() {
        mListener.hideProgressLayout();
    }
}
