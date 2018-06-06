package com.example.hector.mercadolibre.main.installment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.models.PayerCost;

import java.util.List;

class InstallmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<PayerCost> payerCostList;
    private final OnInstallmentInteractionListener mListener;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mIcon;
        final TextView mTextView;
        ViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.profileItem_TextView);
            mIcon = view.findViewById(R.id.iconProfileItem_ImaveVIew);
        }
    }

    InstallmentRecyclerViewAdapter(List<PayerCost> payerCostList, OnInstallmentInteractionListener mListener) {
        this.payerCostList = payerCostList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.mTextView.setText(payerCostList.get(holder.getAdapterPosition()).getRecommendedMessage());
        viewHolder.itemView.setOnClickListener(view -> mListener.itemSelected(payerCostList.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return payerCostList.size();
    }
}