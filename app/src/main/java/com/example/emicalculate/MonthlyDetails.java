package com.example.emicalculate;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.emicalculate.model.DetailModel;
import com.example.emicalculate.model.Global;

import java.util.ArrayList;

public class MonthlyDetails extends Fragment {
    public double aa;
    public int abc;
    public ArrayList<DetailModel> arrayList;
    public ImageView back;
    public double bb;
    public Bundle bundle = new Bundle();
    public Calendar calendar;
    public double cc;
    public double dd;
    public double ee;
    public double ff;
    public double gg;
    public double hh;
    public Preference preference;
    public RecyclerView recyclerView;
    public ImageView share;
    public String str;

    public enum FontFamily {
        COURIER,
        HELVETICA,
        TIMES_ROMAN,
        SYMBOL,
        ZAPFDINGBATS,
        UNDEFINED
    }

    public void onCreate(Bundle bundle2) {
        super.onCreate(bundle2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle2) {
        double d;
        DetailModel detailModel;
        View inflate = layoutInflater.inflate(R.layout.fragment_monthly_details, viewGroup, false);
        new Preference(getContext());
        Calendar.getInstance();
        RecyclerView recyclerView2 = inflate.findViewById(R.id.detailListView);
       recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        FontFamily fontFamily = FontFamily.TIMES_ROMAN;
        myOnCreate();
       arrayList = new ArrayList<>();
        double d2 =aa;
        double d3 =ff;
        int i =abc;
        double d4 =bb;
        int i2 = (int) d2;
        long currentTimeMillis = System.currentTimeMillis();
        new DetailModel();
        double d5 = 0.0d;
        while (d5 < ((double) i)) {
            double d6 = (d3 / 100.0d) / 12.0d;
            if (this.hh == 1.0d) {
                d = i2;
                Double.isNaN(d);
            } else {
                d = i2;
            }
            double d7 = d * d6;
            double d8 = d4 - d7;
            double d9 = d3;
            double d10 = (this.gg * d7) / 100.0d;
            int i3 = i;
            double d11 = d4;
            double d12 = d8 + d7 + d10;
            long j = currentTimeMillis;
            double d13 = i2;
            Double.isNaN(d13);
            int i4 = (int) (d13 - d8);
            if (i4 < 0) {
                i4 = 0;
            }
            Log.e("TAG", "onCreateView: month ::" + d5);
            Log.d("ADVANCE-EMI", "onCreate: " + d12 + " ,, " + d10 + ",  " + d8);
            if (this.gg == 0.0d) {
                detailModel = new DetailModel(Math.round(d5 + 1.0d) + "", Global.doubleToString(d8), Global.doubleToString(d7), Global.doubleToString(i4));
            } else {
                detailModel = new DetailModel(Math.round(d5 + 1.0d) + "", Global.doubleToString(d12), Global.doubleToString(d10), Global.doubleToString(i4));
            }
           arrayList.add(detailModel);
            d5 += 1.0d;
            i2 = i4;
            d3 = d9;
            currentTimeMillis = j;
            i = i3;
            d4 = d11;
        }
        Log.e("C_TAG", "Native" + (System.currentTimeMillis() - currentTimeMillis));
       recyclerView.setAdapter(new DetailAdapter(getActivity(),arrayList,bundle));
        return inflate;
    }

    private void myOnCreate() {
        Bundle extras = getActivity().getIntent().getExtras();
       bundle = extras;
       aa = extras.getDouble("val_loan_amount");
       ff =bundle.getDouble("val_interest");
       abc =bundle.getInt("val_period");
       bb =bundle.getDouble("val_monthly_emi");
       cc =bundle.getDouble("val_total_interest");
        Log.e("TAG", "myOnCreate:ccccccc " +cc);
       ee =bundle.getDouble("val_total_payment");
        Log.e("TAG", "myOnCreate:ccccccc " +ee);
       gg =bundle.getDouble("gst");
       hh = bundle.getInt("is_reduce");
        Log.e("TAG", "myOnCreate: " +hh);
       bundle.getInt("gst_pro_fee");
    }

    public void onBackPressed() {
        try {
            requireActivity().finish();
        } catch (Exception unused) {
        }
    }


}