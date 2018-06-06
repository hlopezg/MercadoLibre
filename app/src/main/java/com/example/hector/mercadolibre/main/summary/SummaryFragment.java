package com.example.hector.mercadolibre.main.summary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.models.Payment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SummaryFragment extends Fragment  {
    @BindView(R.id.amount_textview) TextView mTextViewAmount;
    @BindView(R.id.payment_method_textview) TextView mTextViewPaymentMethod;
    @BindView(R.id.card_issuers_textview) TextView mTextViewCardIssuers;
    @BindView(R.id.installment_textview) TextView mTextViewInstallment;

    private int amout;
    private String paymentMethod;
    private String issuers;
    private String payerCost;

    public static SummaryFragment newInstance(Payment payment) {
        SummaryFragment cardIssuersFragment = new SummaryFragment();
        Bundle args = new Bundle();
        args.putInt("amount", payment.getAmount());
        args.putString("payment_method", payment.getPaymentMethod().getName());
        args.putString("issuers", payment.getCardIssuers().getName());
        args.putString("payer_cost", payment.getPayerCost().getRecommendedMessage());
        cardIssuersFragment.setArguments(args);
        return cardIssuersFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            amout = getArguments().getInt("amount");
            paymentMethod = getArguments().getString("payment_method");
            issuers = getArguments().getString("issuers");
            payerCost = getArguments().getString("payer_cost");
        }
    }

    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_summary, container, false);

        ButterKnife.bind(this, viewRoot);

        mTextViewAmount.setText(String.valueOf(amout));
        mTextViewPaymentMethod.setText(paymentMethod);
        mTextViewCardIssuers.setText(issuers);
        mTextViewInstallment.setText(payerCost);

        return viewRoot;
    }
}
