package com.example.hector.mercadolibre.main.cardissuers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hector.mercadolibre.R;
import com.example.hector.mercadolibre.models.CardIssuers;
import com.squareup.picasso.Picasso;

import java.util.List;

class CardIssuersRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<CardIssuers> cardIssuersList;
    private final OnCardIssuersInteractionListener mListener;
    private final Context context;

    static class ViewHolder2 extends RecyclerView.ViewHolder {
        final ImageView mIcon;
        final TextView mTextView;
        ViewHolder2(View view) {
            super(view);
            mTextView = view.findViewById(R.id.profileItem_TextView);
            mIcon = view.findViewById(R.id.iconProfileItem_ImaveVIew);
        }
    }

    public CardIssuersRecyclerViewAdapter(Context context, List<CardIssuers> cardIssuersList, OnCardIssuersInteractionListener mListener) {
        this.context = context;
        this.cardIssuersList = cardIssuersList;
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
            Picasso.with(context).load(cardIssuersList.get(holder.getAdapterPosition()).getThumbnail()).resize(64, 64).into(viewHolder2.mIcon);
        viewHolder2.mTextView.setText(cardIssuersList.get(holder.getAdapterPosition()).getName());
        viewHolder2.itemView.setOnClickListener(view -> mListener.itemSelected(cardIssuersList.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return cardIssuersList.size();
    }
}