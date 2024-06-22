package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class Intraday_trading extends Fragment {
    Button Calculate;
    ImageView intraday_back;
    private TextView InvestAmount;
    private float brokerage;
    private float brokerage1;
    private float clearing;
    /* access modifiers changed from: private */
    public EditText edtBuy;
    /* access modifiers changed from: private */
    public EditText edtQuantity;
    /* access modifiers changed from: private */
    public EditText edtSell;
    CardView fullinfo;
    private float exchange;

    private float gst;
    boolean isCalculated = false;
    public Float mBuyAmt;
    public int mCheckedId;
    public Integer mQuantity;
    public int mRadioPosition;
    public Float mSellAmt;
    public int mStatePosition;
    private float netProfit;
    private RadioButton radioBse;
    private RadioGroup radioGroup;
    private RadioButton radioNse;
    Button reset;
    private float sebi;
    private Spinner spinBrokers;
    private Spinner spinStates;
    private Spinner spinTrade;
    private float stampDuty;
    private float stampDuty1;
    private int states;
    private int sttTotal;
    private float totalTax;
    private float turnover;
    private TextView txtBreakeven;
    private TextView txtBrokerage;
    private TextView txtClearing;
    private TextView txtExchange;
    private TextView txtGst;
    private TextView txtNetProfit;
    private TextView txtSebi;
    private TextView txtStamp;
    private TextView txtStt;
    private TextView txtTotalTax;
    private TextView txtTurnover;

    @SuppressLint({"MissingInflatedId", "WrongViewCast", "CutPasteId", "ResourceType"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intraday_trading, container, false);
        Spinner spinnerState = view.findViewById(R.id.spinner_state);
        intraday_back = view.findViewById(R.id.intraday_back);
        edtBuy = view.findViewById(R.id.edt_price);
        edtSell = view.findViewById(R.id.edt_sell_price);
        edtQuantity = view.findViewById(R.id.edt_quantity);
        spinStates = view.findViewById(R.id.spinner_state);
        radioGroup = view.findViewById(R.id.inraday_radio);
        radioNse = view.findViewById(R.id.radio_nse);
        radioBse = view.findViewById(R.id.radio_bse);
        txtTurnover = view.findViewById(R.id.edt_turnover);
        txtBrokerage = view.findViewById(R.id.edt_brokerage);
        txtStamp = view.findViewById(R.id.edt_stamp_duty);
        txtStt = view.findViewById(R.id.edt_stt_total);
        txtExchange = view.findViewById(R.id.edt_exchange_txn_charge);
        txtGst = view.findViewById(R.id.edt_gst);
        txtSebi = view.findViewById(R.id.edt_sebi_turnover_fees);
        txtTotalTax = view.findViewById(R.id.edt_total_tax_charges);
        InvestAmount = view.findViewById(R.id.edt_investment_amount);
        txtNetProfit = view.findViewById(R.id.edt_net_profit);
        Calculate = view.findViewById(R.id.btn_intraday_calculate);
        reset = view.findViewById(R.id.btn_intraday_reset);
        fullinfo = view.findViewById(R.id.resultduration);
        intraday_back = view.findViewById(R.id.intraday_back);
        intraday_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });

        fullinfo.setVisibility(View.INVISIBLE);
        Calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                setResult();
                fullinfo.setVisibility(View.VISIBLE);

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                edtBuy.setText("");
                edtSell.setText("");
                edtQuantity.setText("");
                fullinfo.setVisibility(View.INVISIBLE);
                if (someCondition()) {  // Replace someCondition() with your actual condition
                }
            }

            private boolean someCondition() {
                String loanAmount = edtBuy.getText().toString();
                return loanAmount.isEmpty() || loanAmount.equals("0");

            }
        });
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(requireActivity(), R.array.States, 17367048);
        createFromResource.setDropDownViewResource(17367049);
        spinStates.setAdapter(createFromResource);
        spinStates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                mStatePosition = i;
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mCheckedId = i;
            }
        });
        edtBuy.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    try {
                        mBuyAmt = Float.valueOf(Float.parseFloat(editable.toString()));
                    } catch (Exception unused) {
                        mBuyAmt = null;
                    }
                } else {
                    mBuyAmt = null;
                }
            }
        });
        edtSell.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    try {
                        mSellAmt = Float.valueOf(Float.parseFloat(editable.toString()));
                    } catch (Exception unused) {
                        mSellAmt = null;
                    }
                } else {
                    mSellAmt = null;
                }
            }
        });
        edtQuantity.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    try {
                        mQuantity = Integer.valueOf(Integer.parseInt(editable.toString()));
                    } catch (Exception unused) {
                        mQuantity = null;
                    }
                } else {
                    mQuantity = null;
                }
            }
        });
        return view;
    }

    public void setResult() {
        if (this.edtBuy.getText().toString().isEmpty()) {
            edtBuy.setError("Enter Buy Price");
        } else if (this.edtSell.getText().toString().isEmpty()) {
            edtSell.setError("Enter sell Price");
        } else if (this.edtQuantity.getText().toString().isEmpty()) {
            edtQuantity.setError("Enter Quantity");
        } else {
            boolean isNullFloat = isNullFloat(this.mBuyAmt, mSellAmt);
            if (this.mQuantity == null) {
                isNullFloat = true;
            }
            if (isNullFloat) {
                resetResult(this.txtTurnover, txtBrokerage, txtStt, txtExchange, txtClearing, txtGst, txtSebi, txtStamp, txtTotalTax);
                resetNetProfit(this.txtNetProfit);
                return;
            }
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            mCheckedId = checkedRadioButtonId;
            RadioGroup radioGroup2 = radioGroup;
            int indexOfChild = radioGroup2.indexOfChild(radioGroup2.findViewById(checkedRadioButtonId));
            float floatValue = (this.mBuyAmt.floatValue() * ((float) mQuantity.intValue())) + (this.mSellAmt.floatValue() * ((float) mQuantity.intValue()));
            turnover = floatValue;
            float f = (float) (((double) floatValue) * 1.0E-4d);
            brokerage = f;
            if (f < 40.0f) {
                brokerage1 = f;
            } else {
                brokerage1 = 40.0f;
            }
            sttTotal = (int) (((double) (this.mSellAmt.floatValue() * ((float) mQuantity.intValue()))) * 2.5E-4d);
            if (indexOfChild == 0) {
                exchange = (float) (((double) turnover) * 3.25E-5d);
            } else {
                exchange = (float) (((double) turnover) * 3.0E-5d);
            }
            clearing = 0.0f;
            gst = (this.brokerage1 + exchange) * 0.18f;
            float f2 = turnover;
            sebi = (f2 / 1.0E7f) * 10.0f;
            switch (this.mStatePosition) {
                case 0:
                    float f3 = (float) (((double) f2) * 5.0E-5d);
                    stampDuty = f3;
                    if (f3 < 50.0f) {
                        stampDuty1 = f3;
                        break;
                    } else {
                        stampDuty1 = 50.0f;
                        break;
                    }
                case 1:
                    if (this.mRadioPosition == 1) {
                        stampDuty1 = (float) (((double) f2) * 1.0E-4d);
                        break;
                    } else {
                        stampDuty1 = (float) (((double) f2) * 2.0E-5d);
                        break;
                    }
                case 2:
                    if (this.mRadioPosition == 1) {
                        stampDuty1 = (float) (((double) f2) * 1.0E-4d);
                        Log.e("TAG", "setResult:1.0E-4d:: " + stampDuty1);
                        break;
                    } else {
                        stampDuty1 = (float) (((double) f2) * 2.0E-5d);
                        Log.e("TAG", "setResult:1.0E-4d:: " + stampDuty1);
                        break;
                    }
                case 3:
                    stampDuty1 = (float) (((double) f2) * 3.0E-5d);
                    break;
                case 4:
                    if (this.mRadioPosition == 1) {
                        stampDuty1 = (float) (((double) f2) * 1.0E-4d);
                        break;
                    } else {
                        stampDuty1 = (float) (((double) f2) * 2.0E-5d);
                        break;
                    }
                case 5:
                    if (this.mRadioPosition == 1) {
                        stampDuty1 = (float) (((double) f2) * 1.0E-4d);
                        break;
                    } else {
                        stampDuty1 = (float) (((double) f2) * 2.0E-5d);
                        break;
                    }
                case 6:
                    int i = mRadioPosition;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                stampDuty1 = (float) (((double) f2) * 1.1999999999999999E-5d);
                                break;
                            } else {
                                stampDuty1 = (float) (((double) f2) * 2.3999999999999997E-5d);
                                break;
                            }
                        } else {
                            stampDuty1 = (float) (((double) f2) * 1.2E-4d);
                            break;
                        }
                    } else {
                        stampDuty1 = (float) (((double) f2) * 3.0E-5d);
                        break;
                    }
                case 7:
                    stampDuty1 = (float) (((double) f2) * 6.0E-5d);
                    break;
                case 8:
                    float f4 = (float) (((double) f2) * 2.0E-5d);
                    stampDuty = f4;
                    if (f4 < 1000.0f) {
                        stampDuty1 = f4;
                        break;
                    } else {
                        stampDuty1 = 1000.0f;
                        break;
                    }
                case 9:
                    if (this.mRadioPosition == 1) {
                        stampDuty1 = (float) (((double) f2) * 1.0E-4d);
                        break;
                    } else {
                        stampDuty1 = (float) (((double) f2) * 2.0E-5d);
                        break;
                    }
                default:
                    stampDuty1 = 0.0f;
                    break;
            }
            txtTurnover.setText(String.format("%.2f", Float.valueOf(this.turnover)) + " ₹");
            txtBrokerage.setText(String.format("%.2f", Float.valueOf(this.brokerage1)) + " ₹");
            txtStt.setText(this.sttTotal + " ₹");
            txtExchange.setText(String.format("%.2f", Float.valueOf(this.exchange)) + " ₹");
            txtGst.setText(String.format("%.2f", Float.valueOf(this.gst)) + " ₹");
            txtSebi.setText(String.format("%.2f", Float.valueOf(this.sebi)) + " ₹");
            txtStamp.setText(String.format("%.2f", Float.valueOf(this.stampDuty1)) + " ₹");
            float parseFloat = Float.parseFloat(String.format("%.2f", Float.valueOf(this.brokerage1)));
            float parseFloat2 = Float.parseFloat(String.valueOf(this.sttTotal));
            float parseFloat3 = Float.parseFloat(String.format("%.2f", Float.valueOf(this.exchange)));
            float parseFloat4 = Float.parseFloat(String.format("%.2f", Float.valueOf(this.clearing)));
            float parseFloat5 = parseFloat + parseFloat2 + parseFloat3 + parseFloat4 + Float.parseFloat(String.format("%.2f", Float.valueOf(this.gst))) + Float.parseFloat(String.format("%.2f", Float.valueOf(this.sebi))) + Float.parseFloat(String.format("%.2f", Float.valueOf(this.stampDuty1)));
            totalTax = parseFloat5;
            txtTotalTax.setText(String.format("%.2f", Float.valueOf(parseFloat5)) + " ₹");
            mQuantity.intValue();
            netProfit = ((float) (Math.round(this.mSellAmt.floatValue() * ((float) mQuantity.intValue())) - Math.round(this.mBuyAmt.floatValue() * ((float) mQuantity.intValue())))) - totalTax;
            txtNetProfit.setText("Net Profit :   " + String.format("%.2f", Float.valueOf(this.netProfit)) + " ₹");
            InvestAmount.setText((((float) (Integer.parseInt(this.edtBuy.getText().toString()) * Integer.parseInt(this.edtQuantity.getText().toString()))) + parseFloat5) + " ₹");
            fullinfo.setVisibility(View.VISIBLE);
            isCalculated = true;
        }
    }

    private void resetResult(TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null) {
                textView.setText("0");
            }
        }
    }

    private void resetNetProfit(TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null) {
                textView.setText("Net Profit:   0");
            }
        }
    }

    private boolean isNullFloat(Float... fArr) {
        for (Float f : fArr) {
            if (f == null) {
                return true;
            }
        }
        return false;
    }


}


