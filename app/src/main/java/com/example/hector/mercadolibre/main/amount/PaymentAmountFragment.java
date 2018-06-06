package com.example.hector.mercadolibre.main.amount;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.hector.mercadolibre.MainActivityListener;
import com.example.hector.mercadolibre.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentAmountFragment extends Fragment {
    @BindView(R.id.text_input_layout) TextInputLayout mTextInputLayout;
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
        View rootView = inflater.inflate(R.layout.fragment_payment_amount, container, false);

        ButterKnife.bind(this, rootView);

        mButtonAmountInput.setOnClickListener(view -> {
            String amount = mTextInputEditTextAmountInput.getText().toString();
            if(validate(mTextInputEditTextAmountInput, amount)){
                mListener.goToPaymentMethod(Integer.valueOf(amount));
            }
        });

        return rootView;
    }

    private boolean validate(TextView textView, String text) {
        if(text.isEmpty()){
            textView.setError(getString(R.string.error_must_enter_a_value));
            return false;
        }else if (!TextUtils.isDigitsOnly(text)){
            textView.setError(getString(R.string.error_is_not_a_number));
            return false;
        }else if(Integer.valueOf(text) <= 0){
            textView.setError(getString(R.string.error_value_must_be_greather_than_cero));
            return false;
        }else
            return true;
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
