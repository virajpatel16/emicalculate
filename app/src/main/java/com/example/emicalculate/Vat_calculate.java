package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


public class Vat_calculate extends Fragment {
    private TextView Net_price_TV;
    private TextView Vat_price_TV;
    private EditText amount_ET;
    private final ArrayList<String> name = new ArrayList<>();
    private float netprice;
    private float original;
    private TextView original_costTV;
    private RadioButton other;
    private RadioButton p1;
    private RadioButton p12;
    private RadioButton p4;
    private RadioButton p5;
    private float rate = 12.5f;
    private EditText rate_ET;
    private final int rbset = 0;
    private CardView resultSection;
    private Spinner vatSpinner;
    private float vatprice;
    private final boolean isCalculated = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_vat_calculate, container, false);
        initView(view);

   return view;

    }
    @SuppressLint("WrongViewCast")
    private View initView(View view) {
        amount_ET = view.findViewById(R.id.amount);
        resultSection=view.findViewById(R.id.resultSection);
        rate_ET = view.findViewById(R.id.rate_of_vat);
        vatSpinner = view.findViewById(R.id.mode_vat_spinner);
        original_costTV = view.findViewById(R.id.originalCost);
        Vat_price_TV = view.findViewById(R.id.vatPrice);
        Net_price_TV = view.findViewById(R.id.netPrice);

        p1 = view.findViewById(R.id.percent_1);
        p4 = view.findViewById(R.id.percent_4);
        p5 = view.findViewById(R.id.percent_5);
        p12 = view.findViewById(R.id.percent_12);
        other = view.findViewById(R.id.other);

        p1.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
        p4.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
        p5.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
        p12.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
        other.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));



        resultSection.setVisibility(View.INVISIBLE);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = 1.0f;
                p1.setChecked(true);
                p4.setChecked(false);
                p5.setChecked(false);
                p12.setChecked(false);
                other.setChecked(false);
                rate_ET.setVisibility(View.INVISIBLE);
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = 4.0f;
                p1.setChecked(false);
                p4.setChecked(true);
                p5.setChecked(false);
                p12.setChecked(false);
                other.setChecked(false);
                rate_ET.setVisibility(View.INVISIBLE);
            }
        });

        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = 5.0f;
                p1.setChecked(false);
                p4.setChecked(false);
                p5.setChecked(true);
                p12.setChecked(false);
                other.setChecked(false);
                rate_ET.setVisibility(View.INVISIBLE);
            }
        });

        p12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = 12.5f;
                p1.setChecked(false);
                p4.setChecked(false);
                p5.setChecked(false);
                p12.setChecked(true);
                other.setChecked(false);
                rate_ET.setVisibility(View.INVISIBLE);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setChecked(false);
                p4.setChecked(false);
                p5.setChecked(false);
                p12.setChecked(false);
                other.setChecked(true);
                rate_ET.setVisibility(View.VISIBLE);
            }
        });


        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           requireActivity().finish();
            }
        });
        ExtendedFloatingActionButton reset = view.findViewById(R.id.btn_vat_reset);
        ExtendedFloatingActionButton calculate = view.findViewById(R.id.btn_vat_calculate);
        name.add("Add VAT");
        name.add("Remove VAT");
        vatSpinner.setAdapter(new ArrayAdapter<>(requireContext(), R.layout.list, R.id.textlist, name));


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAG", "onClick:rate:: " + rate);
                if (amount_ET.getText().toString().isEmpty()) {
                    amount_ET.setError("Please Enter Amount");
                    return;
                }
                resultSection.setVisibility(View.VISIBLE);
                original = Float.parseFloat(amount_ET.getText().toString());
                if (!rate_ET.getText().toString().isEmpty()) {
                    rate = Float.parseFloat(rate_ET.getText().toString());
                } else {
                    rate_ET.setError("Enter Rate Of VAT");
                }
                if (vatSpinner.getSelectedItem().toString().equals("Add VAT")) {
                    vatprice = (original * rate) / 100.0f;
                    netprice = original + vatprice;
                } else {
                    vatprice = original - (original * (100.0f / (rate + 100.0f)));
                    netprice = original - vatprice;
                }
                original_costTV.setText(String.format("%.2f", original));
                Vat_price_TV.setText(String.format("%.2f", vatprice));
                Net_price_TV.setText(String.format("%.2f", netprice));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount_ET.getText().clear();
                rate_ET.getText().clear();
                resultSection.setVisibility(View.INVISIBLE);

                Toast.makeText(getContext(), "Value is 0", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    public void onRadioButtonClicked(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        int id = view.getId();
        if (id != R.id.other) {
            if (id == R.id.percent_1) {
                if (isChecked) {
                    p4.setChecked(false);
                }
                p5.setChecked(false);
                p12.setChecked(false);
                other.setChecked(false);
                rate = 1.0f;
                rate_ET.setVisibility(View.INVISIBLE);
                return;
            } else if (id == R.id.percent_12) {
                if (isChecked) {
                    p4.setChecked(false);
                }
                p5.setChecked(false);
                p1.setChecked(false);
                other.setChecked(false);
                rate_ET.setVisibility(View.INVISIBLE);
                rate = 12.5f;
                return;
            } else if (id == R.id.percent_4) {
                if (isChecked) {
                    p1.setChecked(false);
                }
                p5.setChecked(false);
                p12.setChecked(false);
                other.setChecked(false);
                rate = 4.0f;
                rate_ET.setVisibility(View.INVISIBLE);
                return;
            } else if (id == R.id.percent_5) {
                if (isChecked) {
                    p4.setChecked(false);
                }
                p12.setChecked(false);
                other.setChecked(false);
                rate_ET.setVisibility(View.INVISIBLE);
                rate = 5.0f;
                return;
            }
        } else {
            if (isChecked) {
                p4.setChecked(false);
            }
            p5.setChecked(false);
            p12.setChecked(false);
            p1.setChecked(false);
            rate_ET.setVisibility(View.VISIBLE);
        }
    }

}