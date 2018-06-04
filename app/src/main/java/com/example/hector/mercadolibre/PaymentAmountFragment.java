package com.example.hector.mercadolibre;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentAmountFragment extends Fragment {
    @BindView(R.id.amount_input) TextInputEditText mTextInputEditTextAmountInput;
    @BindView(R.id.amount_input_button) Button mButtonAmountInput;
    private MainActivityListener mListener;

    public static PaymentAmountFragment newInstance() {
        return new PaymentAmountFragment();
    }

    public PaymentAmountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_payment_amount, container, false);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this, rootView);

        mButtonAmountInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = Integer.valueOf(mTextInputEditTextAmountInput.getText().toString());
                mListener.goToPaymentMethod(amount);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivityListener) {
            mListener = (MainActivityListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MainActivityListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
