package com.example.hector.mercadolibre;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hector.mercadolibre.main.cardissuers.CardIssuersFragment;
import com.example.hector.mercadolibre.models.Payment;
import com.example.hector.mercadolibre.models.PaymentMethod;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityListener {
    @BindView(R.id.progressLayout) RelativeLayout mProgressLayout;
    @BindView(R.id.progressLayoutTextview) TextView mTextViewProgresLayout;

    private Payment payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        payment = new Payment();

        goToPaymentAmount();
    }

    @Override
    public void showProgressLayout(String text) {
        mTextViewProgresLayout.setText(text);
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressLayout() {
        if (mProgressLayout != null) {
            mProgressLayout.setVisibility(View.GONE);
            mTextViewProgresLayout.setText("");
        }
    }

    @Override
    public void goToPaymentAmount() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.getBackStackEntryCount();
        Fragment fragment = PaymentAmountFragment.newInstance();
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame_activate_static, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void goToPaymentMethod(int amount) {
        showProgressLayout("Cargando...");
        payment.setAmount(amount);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.getBackStackEntryCount();
        Fragment fragment = PaymentMethodFragment.newInstance();
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame_activate_static, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void goToCardIssuers(PaymentMethod paymentMethod) {
        showProgressLayout("Cargando...");
        payment.setPaymentMethod(paymentMethod);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.getBackStackEntryCount();
        Fragment fragment = CardIssuersFragment.newInstance(paymentMethod.getId());
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame_activate_static, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void goToInstallment() {

    }
}