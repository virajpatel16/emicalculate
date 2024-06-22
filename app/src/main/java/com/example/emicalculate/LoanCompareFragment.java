package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class LoanCompareFragment extends Fragment {

    ImageView loan_back;

    EditText amount1EditText, amount2EditText, interestRate1EditText, interestRate2EditText, tenure1EditText, tenure2EditText;
    TextView monthlyEmi1TextView, monthlyEmi2TextView, emiDifferenceTextView, edt_interest_payble1, edt_interest_payble2, edt_total_payble1, edt_total_payble2, edt_interest_difrence, edt_payment_diffrence;
    Button btn_loan_calculate, btn_loan_reset;
    RadioGroup dateRadioGroup;
    LinearLayout resultloancompare;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loan_compare, container, false);
        amount1EditText = view.findViewById(R.id.amount1EditText);
        amount2EditText = view.findViewById(R.id.amount2EditText);
        interestRate1EditText = view.findViewById(R.id.interestRate1EditText);
        interestRate2EditText = view.findViewById(R.id.interestRate2EditText);
        tenure1EditText = view.findViewById(R.id.tenure1EditText);
        tenure2EditText = view.findViewById(R.id.tenure2EditText);
        btn_loan_calculate = view.findViewById(R.id.btn_loan_calculate);
        loan_back=view.findViewById(R.id.loan_back);
        btn_loan_reset = view.findViewById(R.id.btn_loan_reset);
        // Initialize TextViews for displaying results
        monthlyEmi1TextView = view.findViewById(R.id.edt_monthly_emi1);
        monthlyEmi2TextView = view.findViewById(R.id.edt_monthly_emi2);
        emiDifferenceTextView = view.findViewById(R.id.edt_emi_difrence);
        edt_interest_payble1 = view.findViewById(R.id.edt_interest_payble1);
        edt_interest_payble2 = view.findViewById(R.id.edt_interest_payble2);
        resultloancompare = view.findViewById(R.id.resultloancompare);
        edt_total_payble1 = view.findViewById(R.id.edt_total_payble1);
        edt_total_payble2 = view.findViewById(R.id.edt_total_payble2);
        edt_interest_difrence = view.findViewById(R.id.edt_interest_difrence);
        edt_payment_diffrence = view.findViewById(R.id.edt_payment_diffrence);

        dateRadioGroup = view.findViewById(R.id.dateRadioGroup);


        loan_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });
        btn_loan_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            calculateLoanComparison();
                resultloancompare.setVisibility(View.VISIBLE);

            }
        });
        btn_loan_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();


            }
        });

        resultloancompare.setVisibility(View.INVISIBLE);
        return view;

    }


    @SuppressLint("DefaultLocale")
    private void calculateLoanComparison() {
        // Get values from EditText fields
        double amount1 = Double.parseDouble(amount1EditText.getText().toString());
        double amount2 = Double.parseDouble(amount2EditText.getText().toString());
        double interestRate1 = Double.parseDouble(interestRate1EditText.getText().toString());
        double interestRate2 = Double.parseDouble(interestRate2EditText.getText().toString());
        double tenure1 = Double.parseDouble(tenure1EditText.getText().toString());
        double tenure2 = Double.parseDouble(tenure2EditText.getText().toString());

        // Calculate EMIs for both loans
        double emi1 = calculateEMI(amount1, interestRate1, tenure1);
        double emi2 = calculateEMI(amount2, interestRate2, tenure2);

        // Display monthly EMIs
        monthlyEmi1TextView.setText(String.format("%.2f", emi1));
        monthlyEmi2TextView.setText(String.format("%.2f", emi2));


        // Calculate and display the difference between EMIs
        double emiDifference = Math.abs(emi1 - emi2);

        emiDifferenceTextView.setText(String.format("%.2f", emiDifference));

        // Calculate and display interest payable for both loans
        double interestPayable1 = (emi1 * tenure1 * 12) - amount1;
        double interestPayable2 = (emi2 * tenure2 * 12) - amount2;
        edt_interest_payble1.setText(String.format("%.2f", interestPayable1));
        edt_interest_payble2.setText(String.format("%.2f", interestPayable2));


        // Calculate total payable amount for both loans
        double totalPayable1 = emi1 * tenure1 * 12;
        double totalPayable2 = emi2 * tenure2 * 12;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        edt_total_payble1.setText(decimalFormat.format(totalPayable1));
        edt_total_payble2.setText(decimalFormat.format(totalPayable2));


        // Calculate the difference in interest payable
        double interestDifference = Math.abs(interestPayable1 - interestPayable2);
        edt_interest_difrence.setText(decimalFormat.format(interestDifference));

        // Calculate the difference in total payable amount
        double paymentDifference = Math.abs(totalPayable1 - totalPayable2);
        edt_payment_diffrence.setText(decimalFormat.format(paymentDifference));
    }

    // Method to calculate EMI
    private double calculateEMI(double loanAmount, double annualInterestRate, double tenureYears) {
        // Convert annual interest rate to monthly interest rate
        double monthlyInterestRate = annualInterestRate / (12 * 100);

        // Convert tenure from years to months
        double tenureMonths = tenureYears * 12;

        // Calculate EMI using the formula
        double emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureMonths))
                / (Math.pow(1 + monthlyInterestRate, tenureMonths) - 1);

        return emi;
    }
    private void resetAll() {
        amount1EditText.setText("");
        amount1EditText.setText("");
        amount2EditText.setText("");
        interestRate1EditText.setText("");
        interestRate2EditText.setText("");
        tenure1EditText.setText("");
        monthlyEmi1TextView.setText("");
        monthlyEmi2TextView.setText("");
        emiDifferenceTextView.setText("");
        edt_interest_payble1.setText("");
        edt_interest_payble2.setText("");
        edt_total_payble1.setText("");
        edt_total_payble2.setText("");
        edt_interest_difrence.setText("");
        resultloancompare.setVisibility(View.INVISIBLE);
        edt_payment_diffrence.setText("");
        dateRadioGroup.clearCheck();
    }
}