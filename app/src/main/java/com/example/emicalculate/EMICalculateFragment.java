package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.emicalculate.model.Global;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;


public class EMICalculateFragment extends Fragment {

    private EditText edtPrincipal, edtInterest, edtTenure;
    private TextView edtTotalInterest, edtTotalPayment, edtMonthlyEMI, edtTotalPrincipal;
    private RadioButton tvYears, tvMonths;
    private PieChart pieChart;
    Button Details;
    int monthOrYear = 2;
    double doubleValue;
    double imonth;
    CardView resultduration;

    LinearLayout layoutchart;
    Button resetButton;
    RadioGroup date;
    Button btnCalculate;
    ImageView backemi;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_e_m_i_calculate, container, false);
        edtPrincipal = view.findViewById(R.id.edt_principal);
        edtInterest = view.findViewById(R.id.edt_interest);
        edtTenure = view.findViewById(R.id.edt_tenure);
        edtTotalInterest = view.findViewById(R.id.edt_t_interest);
        Details = view.findViewById(R.id.showdetail);

        edtTotalPayment = view.findViewById(R.id.edt_t_payment);
        edtMonthlyEMI = view.findViewById(R.id.edt_monthly_emi);
        edtTotalPrincipal = view.findViewById(R.id.edt_total_principal);
        tvYears = view.findViewById(R.id.tv_years);
        tvMonths = view.findViewById(R.id.tv_months);
        pieChart = view.findViewById(R.id.chart);
        resultduration=view.findViewById(R.id.resultduration);
        layoutchart=view.findViewById(R.id.layoutchart);
        btnCalculate = view.findViewById(R.id.btn_business_calculate);
        resetButton =view. findViewById(R.id.btn_business_reset);
        date=view.findViewById(R.id.date);
        backemi=view.findViewById(R.id.backemi);
        // Set an OnClickListener for the reset button
        Details.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               Detail();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();
            }
        });
        backemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEMI();
                resultduration.setVisibility(View.VISIBLE);
                pieChart.setVisibility(View.VISIBLE);
                layoutchart.setVisibility(View.VISIBLE);

            }
        });
        resultduration.setVisibility(View.INVISIBLE);
        pieChart.setVisibility(View.INVISIBLE);
        layoutchart.setVisibility(View.INVISIBLE);
        return view;
    }


    private void resetAll() {

        resultduration.setVisibility(View.INVISIBLE);
        pieChart.setVisibility(View.INVISIBLE);
        layoutchart.setVisibility(View.INVISIBLE);
        edtPrincipal.setText("");
        edtInterest.setText("");
        edtTenure.setText("");
        date.clearCheck();
    }

    private void calculateEMI() {
        if (edtPrincipal.getText().toString().isEmpty() || edtInterest.getText().toString().isEmpty() || edtTenure.getText().toString().isEmpty()) {

            return;
        }

        double principal = Double.parseDouble(edtPrincipal.getText().toString());
        double annualInterestRate = Double.parseDouble(edtInterest.getText().toString());
        int tenure = Integer.parseInt(edtTenure.getText().toString());

        boolean isYears = tvYears.isChecked();
        if (!isYears) {
            tenure = tenure / 12; // Convert months to years
        }

        double monthlyInterestRate = (annualInterestRate / 12) / 100;
        int numberOfMonths = tenure * 12;

        double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) /
                (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);

        double totalPayment = emi * numberOfMonths;
        double totalInterest = totalPayment - principal;

        edtMonthlyEMI.setText(String.format("%.2f", emi));
        edtTotalInterest.setText(String.format("%.2f", totalInterest));
        edtTotalPayment.setText(String.format("%.2f", totalPayment));
        edtTotalPrincipal.setText(String.format("%.2f", principal));

        setPieChartData(principal, totalInterest);
    }

    private void setPieChartData(double principal, double interest) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry((float) principal, "Principal"));
        entries.add(new PieEntry((float) interest, "Interest"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(new int[]{R.color.colorPrimary, R.color.colorAccent}, getContext());
        PieData data = new PieData(dataSet);
        dataSet.setValueTextColors(Collections.singletonList(Color.WHITE));
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Emi calculate");
        pieChart.setExtraOffsets(22,10,5,5);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setCenterTextSize(6f);
        pieChart.animateY(2000, Easing.EaseOutCubic);
        pieChart.setData(data);
        pieChart.invalidate(); // refresh
    }
    public void Detail() {
        Intent intent = new Intent(requireActivity(), DetailsActivity.class);
        intent.putExtra("val_loan_amount", doubleValue);
        intent.putExtra("val_interest", Double.parseDouble(edtInterest.getText().toString()));
        intent.putExtra("val_period", getMonth());
        intent.putExtra("val_monthly_emi", Global.stringToDouble(edtMonthlyEMI.getText().toString()));
        intent.putExtra("val_total_interest", Global.stringToDouble(edtTotalInterest.getText().toString()));
        Log.e("TAG", "Detail:total_interest_result " + edtTotalInterest.getText().toString());
        intent.putExtra("val_total_payment", Global.stringToDouble(edtTotalPayment.getText().toString()));
        Log.e("TAG", "Detail:total_payment_result " + edtTotalPayment.getText().toString());
        intent.putExtra("gst", 0.0d);
        intent.putExtra("is_reduce", 1.0d);
        intent.putExtra("gst_pro_fee", 0.0d);
        startActivity(intent);
    }
    private int getMonth() {
        if (TextUtils.isEmpty(edtTenure.getText().toString())) {
            return 0;
        }
        imonth = monthOrYear == 2 ? Integer.parseInt(edtTenure.getText().toString()) * 12 : Integer.parseInt(edtTenure.getText().toString());
        Log.e("TAG", "getMonth: imonth:" + imonth);
        return (int) imonth;
    }

}
