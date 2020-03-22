package com.example.myfood;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserRecyclerViewAdapter  extends RecyclerView.Adapter<UserRecyclerViewAdapter.RecyclerViewViewHolder> {

   private ArrayList<UserRecyclerViewItem> arrayList;
   private OnItemClickListener mListener;

   public interface OnItemClickListener{
        void onItemClick(int position);
        void onQuantityPlus(int position);
        void onQuantityMinus(int position);
   }

   public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
   }

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public TextView quantity;
        public Button plusQuantity;
        public Button minusQuantity;

        public RecyclerViewViewHolder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            quantity = itemView.findViewById(R.id.count);
            plusQuantity = itemView.findViewById(R.id.plus);
            minusQuantity = itemView.findViewById(R.id.minus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener !=null){
                        int position =getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            plusQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener !=null){
                        int position =getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onQuantityPlus(position);
                        }
                    }
                }
            });

            minusQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener !=null){
                        int position =getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onQuantityMinus(position);
                        }
                    }
                }
            });


        }
    }

    public UserRecyclerViewAdapter(ArrayList<UserRecyclerViewItem> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);

        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view, mListener);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        UserRecyclerViewItem recyclerViewItem = arrayList.get(position);

        holder.imageView.setImageResource(recyclerViewItem.getImageResource());
        holder.textView1.setText(recyclerViewItem.getText1());
        holder.textView2.setText(recyclerViewItem.getText2());
        holder.quantity.setText(recyclerViewItem.getCount());
    }

    @Override
    public int getItemCount() {
        return  arrayList.size();
    }


}
