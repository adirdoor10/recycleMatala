package com.example.recyclevapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private final RecycleViewInterface recycleViewInterface;
    private ArrayList<DataModel> dataSet;
    private OnItemClickListener itemClickListener;

    public CustomeAdapter(RecycleViewInterface recycleViewInterface, ArrayList<DataModel> dataSet) {
        this.recycleViewInterface = recycleViewInterface;
        this.dataSet = dataSet;
    }

    public interface OnItemClickListener {
        void onItemClick(DataModel dataModel);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
            textViewDescription = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recycleViewInterface!= null){
                        int pos=getAdapterPosition();
                        if(pos!= RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }

    public void setFilteredList(List<DataModel> filteredList) {
        this.dataSet = new ArrayList<>(filteredList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        return new MyViewHolder(view, recycleViewInterface); // Pass recycleViewInterface here
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        DataModel currentItem = dataSet.get(position);
        holder.textViewName.setText(currentItem.getName());
        holder.textViewDescription.setText(currentItem.getVersion());
        holder.imageView.setImageResource(currentItem.getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
