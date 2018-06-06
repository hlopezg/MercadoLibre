package com.example.hector.mercadolibre.main.installment;

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
import android.widget.TextView;

import com.example.hector.mercadolibre.MainActivityListener;
import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.Utilities.Methods;
import com.example.hector.mercadolibre.models.PayerCost;
import com.example.hector.mercadolibre.presenter.PaymentInstallmentPresenter;
import com.example.hector.mercadolibre.presenter.PaymentMVP;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstallmentFragment extends Fragment implements OnInstallmentInteractionListener, PaymentMVP.PaymentInstallmentView {
    @BindView(R.id.installment_recyclerview) RecyclerView mRecyclerViewInstallment;
    @BindView(R.id.no_data_textview) TextView mTextViewNoData;

    private PaymentMVP.PaymentInstallmentPresenter installmentPresenter;
    private FragmentActivity fragmentActivity;
    private MainActivityListener mListener;

    private String paymentMethodId;
    private String issuerId;
    private int amount;

    public static InstallmentFragment newInstance(int amount, String paymentMethodId, String issuerId) {
        InstallmentFragment cardIssuersFragment = new InstallmentFragment();
        Bundle args = new Bundle();
        args.putInt("amount", amount);
        args.putString("paymentMethodId", paymentMethodId);
        args.putString("issuerId", issuerId);
        cardIssuersFragment.setArguments(args);
        return cardIssuersFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            amount = getArguments().getInt("amount");
            paymentMethodId = getArguments().getString("paymentMethodId");
            issuerId = getArguments().getString("issuerId");
        }
    }

    public InstallmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_installment, container, false);

        ButterKnife.bind(this, viewRoot);

        installmentPresenter = new PaymentInstallmentPresenter();

        if(Methods.isNetworkAvailable(fragmentActivity))
            installmentPresenter.getInstallment(getContext(), amount, paymentMethodId, issuerId);
        else{
            mListener.hideProgressLayout();
            mListener.goToNoNetwork();
        }
        return viewRoot;
    }

    private void setRecyclerView(List<PayerCost> payerCostList){
        if(fragmentActivity != null){
            if(payerCostList.size() == 0){
                mTextViewNoData.setVisibility(View.VISIBLE);
                return;
            }

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(fragmentActivity);
            mRecyclerViewInstallment.setLayoutManager(layoutManager);
            mRecyclerViewInstallment.setAdapter(new InstallmentRecyclerViewAdapter(payerCostList, this));
            mRecyclerViewInstallment.setHasFixedSize(true);

            DividerItemDecoration horizontalDecoration = new DividerItemDecoration(fragmentActivity, DividerItemDecoration.VERTICAL);
            Drawable horizontalDivider = ContextCompat.getDrawable(fragmentActivity, R.drawable.horizontal_divider);
            if (horizontalDivider != null) {
                horizontalDecoration.setDrawable(horizontalDivider);
                mRecyclerViewInstallment.addItemDecoration(horizontalDecoration);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        installmentPresenter.setView(this);
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
    public void onSuccesfullGetInstallment(List<PayerCost> payerCost) {
        setRecyclerView(payerCost);
        if(mListener != null)
            mListener.hideProgressLayout();
    }

    @Override
    public void onFailureGetInstallment() {
        if(mListener != null){
            mListener.toast(getString(R.string.no_data_from_request));
            mListener.hideProgressLayout();
        }
    }

    @Override
    public void itemSelected(PayerCost payerCost) {
        if(mListener != null)
            mListener.goToSummary(payerCost);
    }
}
