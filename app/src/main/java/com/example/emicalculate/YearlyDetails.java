package com.example.emicalculate;

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
import java.util.Calendar;

public class YearlyDetails extends Fragment {
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
        View inflate = layoutInflater.inflate(R.layout.fragment_yearly_details, viewGroup, false);
        new Preference(getContext());
        Calendar.getInstance();
        RecyclerView recyclerView2 = inflate.findViewById(R.id.detailListView);
        recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        FontFamily fontFamily = FontFamily.TIMES_ROMAN;
        myOnCreate();
        arrayList = new ArrayList<>();
        double d2 = aa;
        double d3 = ff;
        String str2 = "TAG";
        Log.e(str2, "onCreateView: " + d3);
        Log.e(str2, "onCreateView: d2:" + d2);
        int i = abc / 12;
        Log.e(str2, "onCreateView: i=" + i);
        double d4 = bb * 12.0d;
        Log.e(str2, "onCreateView:d4 ==" + d4);
        int i2 = (int) d2;
        long currentTimeMillis = System.currentTimeMillis();
        new DetailModel();
        double d5 = 0.0d;
        while (d5 < ((double) i)) {
            int i3 = i2;
            double d6 = d3 / 100.0d;
            Log.e(str2, "onCreateView: d6::" + d6);
            if (hh == 1.0d) {
                d = i3;
                Double.isNaN(d);
            } else {
                d = i3;
            }
            double d7 = d * d6;
            double d8 = d4 - d7;
            double d9 = d3;
            double d10 = (gg * d7) / 100.0d;
            int i4 = i;
            String str3 = str2;
            double d11 = d8 + d7 + d10;
            double d12 = d4;
            double d13 = i3;
            Double.isNaN(d13);
            int i5 = (int) (d13 - d8);
            if (i5 < 0) {
                i5 = 0;
            }
            Log.d("ADVANCE-EMI", "onCreate: " + d11 + " ,, " + d10 + ",  " + d8);
            if (gg == 0.0d) {
                detailModel = new DetailModel(Math.round(d5 + 1.0d) + "", Global.doubleToString(d8), Global.doubleToString(d7), Global.doubleToString(i5));
            } else {
                detailModel = new DetailModel(Math.round(d5 + 1.0d) + "", Global.doubleToString(d11), Global.doubleToString(d10), Global.doubleToString(i5));
            }
            arrayList.add(detailModel);
            d5 += 1.0d;
            i2 = i5;
            d4 = d12;
            d3 = d9;
            str2 = str3;
            i = i4;
        }
        Log.e("C_TAG", "Native" + (System.currentTimeMillis() - currentTimeMillis));
        recyclerView.setAdapter(new DetailAdapter(getActivity(), arrayList, bundle));
        return inflate;
    }

    private void myOnCreate() {
        Bundle extras = getActivity().getIntent().getExtras();
        bundle = extras;
        aa = extras.getDouble("val_loan_amount");
        ff = bundle.getDouble("val_interest");
        abc = bundle.getInt("val_period");
        Log.e("TAG", "myOnCreate:abc :: " + abc);
        bb = bundle.getDouble("val_monthly_emi");
        cc = bundle.getDouble("val_total_interest");
        Log.e("TAG", "myOnCreate:ccccccc " + cc);
        ee = bundle.getDouble("val_total_payment");
        Log.e("TAG", "myOnCreate:ccccccc " + ee);
        gg = bundle.getDouble("gst");
        hh = bundle.getInt("is_reduce");
        Log.e("TAG", "myOnCreate: " + hh);
        bundle.getInt("gst_pro_fee");
    }

    public void onBackPressed() {
        try {
           requireActivity().finish();
        } catch (Exception unused) {
        }
    }}