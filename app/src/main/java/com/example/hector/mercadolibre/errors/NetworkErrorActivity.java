package com.example.hector.mercadolibre.errors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.hector.mercadolibre.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NetworkErrorActivity extends AppCompatActivity {
    @BindView(R.id.no_connection_button) Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_error);
        ButterKnife.bind(this);

        mButton.setOnClickListener(view -> onBackPressed());
    }
}
