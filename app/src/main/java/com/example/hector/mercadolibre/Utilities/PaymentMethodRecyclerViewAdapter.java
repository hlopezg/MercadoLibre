package com.example.hector.mercadolibre.Utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hector.mercadolibre.OnPaymentMethodInteractionListener;
import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.models.PaymentMethod;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PaymentMethodRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PaymentMethod> paymentMethodList;
    private final OnPaymentMethodInteractionListener mListener;
    private Context context;

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView mIcon;
        TextView mTextView;
        ViewHolder2(View view) {
            super(view);
            mTextView = view.findViewById(R.id.profileItem_TextView);
            mIcon = view.findViewById(R.id.iconProfileItem_ImaveVIew);
        }
    }

    public PaymentMethodRecyclerViewAdapter(Context context, List<PaymentMethod> paymentMethodList, OnPaymentMethodInteractionListener mListener) {
        this.context = context;
        this.paymentMethodList = paymentMethodList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_item, parent, false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder2 viewHolder2 = (ViewHolder2)holder;
        if(context != null)
            Picasso.with(context).load(paymentMethodList.get(holder.getAdapterPosition()).getThumbnail()).resize(64, 64).into(viewHolder2.mIcon);
        viewHolder2.mTextView.setText(paymentMethodList.get(holder.getAdapterPosition()).getName());
        viewHolder2.itemView.setOnClickListener(view -> mListener.itemSelected(paymentMethodList.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return paymentMethodList.size();
    }
}