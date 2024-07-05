package com.example.emicalculate;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emicalculate.model.DetailModel;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    public float aa;
    private final Activity activity;
    public float bb;
    public Bundle bundle;
    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private final ArrayList<DetailModel> detailList;

    public DetailAdapter(Activity activity2, ArrayList<DetailModel> arrayList, Bundle bundle2) {
        activity = activity2;
        detailList = arrayList;
        bundle = bundle2;
    }

    public int getItemCount() {
        return detailList.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        Activity activity2;
        LinearLayout linearLayout;
        if (viewHolder instanceof DetailViewHolder) {
            DetailViewHolder detailViewHolder = (DetailViewHolder) viewHolder;
            if (i % 2 != 1) {
                linearLayout = detailViewHolder.relativeLayout1;
                activity2 = activity;
                i2 = R.color.data;
            } else {
                linearLayout = detailViewHolder.relativeLayout1;
                activity2 = activity;
                i2 = R.color.black;
            }
            linearLayout.setBackgroundColor(ContextCompat.getColor(activity2, i2));
            DetailModel detailModel = detailList.get(i);
            detailViewHolder.tvMonths_lv.setText(detailModel.getDetail_months());
            detailViewHolder.tvPrincipal_lv.setText(detailModel.getDetail_principal());
            detailViewHolder.tvInterest_lv.setText(detailModel.getDetail_interest());
            detailViewHolder.tvBalance_lv.setText(detailModel.getDetail_balance());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DetailViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_lv_row, viewGroup, false));
    }
    public class DetailViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout relativeLayout1;
        public TextView tvBalance_lv;
        public TextView tvInterest_lv;
        public TextView tvMonths_lv;
        public TextView tvPrincipal_lv;

        public DetailViewHolder(View view) {
            super(view);
            relativeLayout1 = view.findViewById(R.id.relativeLayout1);
            tvMonths_lv = view.findViewById(R.id.tvMonths_lv);
            tvPrincipal_lv = view.findViewById(R.id.tvPrincipal_lv);
            tvInterest_lv = view.findViewById(R.id.tvInterest_lv);
            tvBalance_lv = view.findViewById(R.id.tvBalance_lv);
        }
    }
}
