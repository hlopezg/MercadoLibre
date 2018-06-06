package com.example.hector.mercadolibre.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.Utilities.Constants;
import com.example.hector.mercadolibre.models.Installment;
import com.example.hector.mercadolibre.models.PayerCost;
import com.example.hector.mercadolibre.retrofit.PaymentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PaymentInstallmentPresenter implements PaymentMVP.PaymentInstallmentPresenter, Callback<List<Installment>> {
    private PaymentMVP.PaymentInstallmentView view;

    private PaymentService createPaymentService(Context context){
        final String BASE_URL = context.getString(R.string.server_path);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(PaymentService.class);
    }

    @Override
    public void setView(PaymentMVP.PaymentInstallmentView view) {
        this.view = view;
    }

    @Override
    public void getInstallment(Context context, int amount, String paymentMethodId, String issuerId) {
        PaymentService paymentService = createPaymentService(context);

        Call<List<Installment>> call = paymentService.getInstallment(Constants.PUBLIC_KEY, amount, paymentMethodId, issuerId);
        call.enqueue(this);
    }


    @Override
    public void onResponse(@NonNull Call<List<Installment>> call, @NonNull Response<List<Installment>> response) {
        List<Installment> installmentList = response.body();
        if(installmentList != null && installmentList.size() > 0 && installmentList.get(0).getPayer_costs().size() > 0){
            List<PayerCost> payerCostList = installmentList.get(0).getPayer_costs();
            if(view != null){
                view.onSuccesfullGetInstallment(payerCostList);
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<List<Installment>> call, @NonNull Throwable t) {
        if(view != null)
            view.onFailureGetInstallment();
    }
}
