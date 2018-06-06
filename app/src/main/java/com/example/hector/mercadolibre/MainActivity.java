package com.example.hector.mercadolibre;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hector.mercadolibre.errors.NetworkErrorActivity;
import com.example.hector.mercadolibre.main.amount.PaymentAmountFragment;
import com.example.hector.mercadolibre.main.cardissuers.CardIssuersFragment;
import com.example.hector.mercadolibre.main.installment.InstallmentFragment;
import com.example.hector.mercadolibre.main.method.PaymentMethodFragment;
import com.example.hector.mercadolibre.main.summary.SummaryFragment;
import com.example.hector.mercadolibre.models.CardIssuers;
import com.example.hector.mercadolibre.models.PayerCost;
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
    public void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
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
        showProgressLayout(getString(R.string.loading));
        payment.setAmount(amount);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.getBackStackEntryCount();
        Fragment fragment = PaymentMethodFragment.newInstance();
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame_activate_static, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToCardIssuers(PaymentMethod paymentMethod) {
        showProgressLayout(getString(R.string.loading));
        payment.setPaymentMethod(paymentMethod);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.getBackStackEntryCount();
        Fragment fragment = CardIssuersFragment.newInstance(paymentMethod.getId());
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame_activate_static, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToInstallment(CardIssuers cardIssuers) {
        showProgressLayout(getString(R.string.loading));
        payment.setCardIssuers(cardIssuers);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.getBackStackEntryCount();
        Fragment fragment = InstallmentFragment.newInstance(payment.getAmount(), payment.getPaymentMethod().getId(), String.valueOf(cardIssuers.getId()));
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame_activate_static, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToSummary(PayerCost payerCost) {
        payment.setPayerCost(payerCost);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentManager.getBackStackEntryCount();
        Fragment fragment = SummaryFragment.newInstance(payment);
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame_activate_static, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void goToNoNetwork() {
        Intent intent = new Intent(this, NetworkErrorActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int backStackCount = fragmentManager.getBackStackEntryCount();
        if (backStackCount == 0) {
            super.onBackPressed();
        }else
            fragmentManager.popBackStackImmediate();
    }
}