package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;


public class Gst_calculate extends Fragment {
    EditText initialAmountEditText, gstRateEditText, cgstEditText, sgstEditText;
    TextView gstAmountEditText,netAmountEditText, totalAmountEditText;
    RadioButton addGSTRadioButton, subtractGSTRadioButton;
    DecimalFormat formatter = new DecimalFormat("#,##,###.00");
    TextView txt_cgst_sgst;
    LinearLayout resultduration;
    ExtendedFloatingActionButton btn_business_calculate,btn_business_reset;
ImageView gst_back;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gst_calculate, container, false);
        initialAmountEditText =view. findViewById(R.id.initial_amount_edit_text);
        gstRateEditText = view.findViewById(R.id.gst_rate_edit_text);
        gstAmountEditText = view.findViewById(R.id.gst_amount_edit_text);
        netAmountEditText =view. findViewById(R.id.net_amount_edit_text);
        totalAmountEditText = view.findViewById(R.id.total_gst_involves);
//        cgstEditText = findViewById(R.id.cgst_amount);
//        sgstEditText = findViewById(R.id.Sgst_amount);\
        gst_back=view.findViewById(R.id.gst_back);
        txt_cgst_sgst=view.findViewById(R.id.txt_cgst_sgst);
        addGSTRadioButton = view.findViewById(R.id.add_gst_radio_button);
        resultduration=view.findViewById(R.id.resultduration);
        addGSTRadioButton.setChecked(true);
        subtractGSTRadioButton = view.findViewById(R.id.subtract_gst_radio_button);
        btn_business_calculate=view.findViewById(R.id.btn_business_calculate);
        btn_business_reset=view.findViewById(R.id.btn_business_reset);
        // Set OnClickListener for the Calculate button
        btn_business_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGST();

                resultduration.setVisibility(View.VISIBLE);
            }
        });

        // Set OnClickListener for the Reset button
       view. findViewById(R.id.btn_business_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();

                resultduration.setVisibility(View.INVISIBLE);
            }
        });

        gst_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });


        resultduration.setVisibility(View.INVISIBLE);
   return  view;
    }
    private void calculateGST() {
        // Check if input fields are empty
        if (initialAmountEditText.getText().toString().isEmpty() || gstRateEditText.getText().toString().isEmpty()) {
            Toast.makeText(requireActivity(), "Please enter all inputs", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Retrieve values entered by the user
            double initialAmount = Double.parseDouble(initialAmountEditText.getText().toString());
            double gstRate = Double.parseDouble(gstRateEditText.getText().toString());
            boolean isAddGST = addGSTRadioButton.isChecked(); // Check if user selected "Add GST +"

            // Check if gstRate is zero
            if (initialAmount==0||gstRate == 0) {
                Toast.makeText(requireActivity(), "Input values must be greater than 0", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calculate GST amount based on the GST rate
            double gstAmount = (gstRate / 100) * initialAmount;

            // Calculate CGST and SGST based on the net amount after adding or subtracting GST
            double netAmount = isAddGST ? initialAmount + gstAmount : initialAmount - gstAmount;
            // Calculate CGST and SGST (assuming equal division)
            double cgst = gstAmount / 2;
            double sgst = gstAmount / 2;


            txt_cgst_sgst.setText("(CGST : " +gstRate/2+"% = " +  formatter.format(cgst)+")\n(SGST : " +gstRate/2+"% = " +  formatter.format(sgst) +")");
            // Calculate the total amount including GST
            double totalAmount = isAddGST ? netAmount : initialAmount;

            // Display the calculated values in the respective TextInputEditText fields
            gstAmountEditText.setText(formatter.format(gstAmount));
            netAmountEditText.setText(formatter.format(netAmount));
            totalAmountEditText.setText(formatter.format(totalAmount));
//            cgstEditText.setText(String.format("%.2f", cgst));
//            sgstEditText.setText(String.format("%.2f", sgst));
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (e.g., if input is not a valid number)
            Toast.makeText(requireActivity(), "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // Handle other exceptions
            Toast.makeText(requireActivity(), "An error occurred", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    // Method to reset all input fields
    private void resetFields() {
        initialAmountEditText.setText("");
        gstRateEditText.setText("");
        gstAmountEditText.setText("");
        netAmountEditText.setText("");
        txt_cgst_sgst.setText("(CGST : 0.00% = 0)\n(SGST : 0.00% = 0)");
        addGSTRadioButton.setChecked(true);
        totalAmountEditText.setText("");
        if (someCondition()) {  // Replace someCondition() with your actual condition
            
        }
    }

    private boolean someCondition() {
        String loanAmount = initialAmountEditText.getText().toString();
        return loanAmount.isEmpty() || loanAmount.equals("0");
    }

    // Method to
}