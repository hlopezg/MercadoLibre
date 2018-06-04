package com.example.hector.mercadolibre.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.Utilities.Constants;
import com.example.hector.mercadolibre.models.PaymentMethod;
import com.example.hector.mercadolibre.retrofit.PaymentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentMethodPresenter implements PaymentMVP.PaymentMethodPresenter, Callback<List<PaymentMethod>> {
    private PaymentMVP.PaymentMethodView view;

    private PaymentService createPaymentService(Context context){
        final String BASE_URL = context.getString(R.string.server_path);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(PaymentService.class);
    }

    @Override
    public void setView(PaymentMVP.PaymentMethodView view) {
        this.view = view;
    }

    @Override
    public void getPaymentMethod(Context context) {
        PaymentService paymentService = createPaymentService(context);

        Call<List<PaymentMethod>> call = paymentService.getPaymentMethods(Constants.PUBLIC_KEY);
        call.enqueue(this);
    }


    @Override
    public void onResponse(@NonNull Call<List<PaymentMethod>> call, @NonNull Response<List<PaymentMethod>> response) {
        List<PaymentMethod> paymentMethodList = response.body();
        if(view != null)
            view.onSuccesfullGetPaymentMethod(paymentMethodList);
    }

    @Override
    public void onFailure(@NonNull Call<List<PaymentMethod>> call, @NonNull Throwable t) {
        if(view != null)
            view.onFailureGetPaymentMethod();
    }
}
