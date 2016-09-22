package com.secretbiology.ncbsinfolight.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.secretbiology.ncbsinfolight.R;
import com.secretbiology.ncbsinfolight.models.TransportModel;

import java.util.List;

/**
 * NCBSinfo © 2016, Secret Biology
 * https://github.com/NCBSinfo/NCBSinfo
 * Created by Rohit Suratekar on 05-09-16.
 */
public class TransportAdapter extends RecyclerView.Adapter<TransportAdapter.MyViewHolder> {

    private List<TransportModel> entryList;
    View currentview;
    private ClickListener myClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public ImageView icon;

        public Context context;
        public LinearLayout layout;

        public MyViewHolder(View view) {
            super(view);
            currentview = view;
            title = (TextView) view.findViewById(R.id.transport_title);
            icon = (ImageView) view.findViewById(R.id.transport_icon);
            layout = (LinearLayout) view.findViewById(R.id.transport_layout);
            layout.setOnClickListener(this);
            context = view.getContext();

        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getLayoutPosition(), v);
        }
    }

    public void setOnItemClickListener(ClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }


    public TransportAdapter(List<TransportModel> entryList) {
        this.entryList = entryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transport_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TransportModel entry = entryList.get(position);
        holder.icon.setImageResource(entry.getIcon());
        holder.title.setText(entry.getName());
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);


    }


}

