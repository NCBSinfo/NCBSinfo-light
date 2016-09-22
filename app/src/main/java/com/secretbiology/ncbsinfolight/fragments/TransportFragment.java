package com.secretbiology.ncbsinfolight.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.secretbiology.ncbsinfolight.R;
import com.secretbiology.ncbsinfolight.adapters.TransportAdapter;
import com.secretbiology.ncbsinfolight.models.TransportModel;
import com.secretbiology.ncbsinfolight.utils.ScrollUpRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * NCBSinfo © 2016, Secret Biology
 * https://github.com/NCBSinfo/NCBSinfo
 * Created by Rohit Suratekar on 05-09-16.
 */
public class TransportFragment extends Fragment {

    ScrollUpRecyclerView recyclerView;
    List<TransportModel> transportList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transport, container, false);
        recyclerView = (ScrollUpRecyclerView) rootView.findViewById(R.id.transport_recyclerView);
        transportList.add(new TransportModel(R.drawable.icon_shuttle, "Shuttle"));
        transportList.add(new TransportModel(R.drawable.icon_shuttle, "Buggy"));

        TransportAdapter adapter = new TransportAdapter(transportList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new TransportAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i("TAG", position + "");
            }
        });

        return rootView;
    }
}
