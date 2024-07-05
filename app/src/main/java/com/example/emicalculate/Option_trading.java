package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class Option_trading extends Fragment {

    Button Calculate;
    private TextView InvestAmount;
    ImageView option_back;
    private float brokerage;
    private float brokerage1;
    private float clearing;
    /* access modifiers changed from: private */
    public EditText edtBuy;
    /* access modifiers changed from: private */
    public EditText edtQuantity;
    /* access modifiers changed from: private */
    public EditText edtSell;
    private float exchange;
    LinearLayout fullinfo;
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

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_option_trading, container, false);
        this.edtBuy = view.findViewById(R.id.edt_buy);
        this.edtSell = view. findViewById(R.id.edt_sell);
        this.edtQuantity = view. findViewById(R.id.edt_quantity);
        this.spinStates = view. findViewById(R.id.spinner_state_option);
        this.radioGroup = view.findViewById(R.id.option_radio);
        this.radioNse = view. findViewById(R.id.radio_nse);
        this.radioBse = view. findViewById(R.id.radio_bse);
        this.txtTurnover = view.findViewById(R.id.txt_turnover1);
        this.txtBrokerage = view. findViewById(R.id.txt_brokerage1);
        this.txtStamp = view.findViewById(R.id.txt_stamp1);
        this.txtStt = view.findViewById(R.id.txt_stt1);
        this.txtExchange = view. findViewById(R.id.txt_exchange1);
        this.txtGst = view.findViewById(R.id.txt_gst1);
        this.txtSebi = view.findViewById(R.id.txt_sebi1);
        this.txtTotalTax = view.findViewById(R.id.txt_total_tax1);
        this.InvestAmount = view. findViewById(R.id.InvestAmount);
        this.txtNetProfit = view. findViewById(R.id.txt_net_profit);
        this.Calculate = view. findViewById(R.id.btn_calculate);
        this.reset = view. findViewById(R.id.btn_reset);
        this.fullinfo = view. findViewById(R.id.fullinfo);
        option_back= view.findViewById(R.id.option_back);

        option_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });
        this.Calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult();
                fullinfo.setVisibility(View.VISIBLE);
            }
        });
        this.reset.setOnClickListener(new View.OnClickListener() {
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
        @SuppressLint("ResourceType") ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(requireActivity(), R.array.States, 17367048);
        createFromResource.setDropDownViewResource(17367049);
        this.spinStates.setAdapter(createFromResource);
        this.spinStates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                mStatePosition = i;
            }
        });
        this.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mCheckedId = i;
            }
        });
        this.edtBuy.addTextChangedListener(new TextWatcher() {
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
        this.edtSell.addTextChangedListener(new TextWatcher() {
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
        this.edtQuantity.addTextChangedListener(new TextWatcher() {
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
        fullinfo.setVisibility(View.INVISIBLE);
    return  view;
    }
    public void setResult() {
        if (this.edtBuy.getText().toString().isEmpty()) {
            this.edtBuy.setError("Enter Buy Price");
        } else if (this.edtSell.getText().toString().isEmpty()) {
            this.edtSell.setError("Enter sell Price");
        } else if (this.edtQuantity.getText().toString().isEmpty()) {
            this.edtQuantity.setError("Enter Quantity");
        } else {
            boolean isNullFloat = isNullFloat(this.mBuyAmt, this.mSellAmt);
            if (this.mQuantity == null) {
                isNullFloat = true;
            }
            if (isNullFloat) {
                resetResult(this.txtTurnover, this.txtBrokerage, this.txtStt, this.txtExchange, this.txtClearing, this.txtGst, this.txtSebi, this.txtStamp, this.txtTotalTax);
                resetNetProfit(this.txtNetProfit);
                return;
            }
            int checkedRadioButtonId = this.radioGroup.getCheckedRadioButtonId();
            this.mCheckedId = checkedRadioButtonId;
            RadioGroup radioGroup2 = this.radioGroup;
            int indexOfChild = radioGroup2.indexOfChild(radioGroup2.findViewById(checkedRadioButtonId));
            this.turnover = (this.mBuyAmt.floatValue() * ((float) this.mQuantity.intValue())) + (this.mSellAmt.floatValue() * ((float) this.mQuantity.intValue()));
            this.brokerage1 = 40.0f;
            this.sttTotal = (int) (((double) (this.mSellAmt.floatValue() * ((float) this.mQuantity.intValue()))) * 5.0E-4d);
            if (indexOfChild == 0) {
                this.exchange = (float) (((double) this.turnover) * 5.0E-4d);
            } else {
                this.exchange = 0.0f;
            }
            this.clearing = 0.0f;
            this.gst = (this.brokerage1 + this.exchange) * 0.18f;
            float f = this.turnover;
            this.sebi = (f / 1.0E7f) * 10.0f;
            switch (this.mStatePosition) {
                case 0:
                    float f2 = (float) (((double) f) * 5.0E-5d);
                    this.stampDuty = f2;
                    if (f2 < 50.0f) {
                        this.stampDuty1 = f2;
                        break;
                    } else {
                        this.stampDuty1 = 50.0f;
                        break;
                    }
                case 1:
                    if (this.mRadioPosition == 1) {
                        this.stampDuty1 = (float) (((double) f) * 1.0E-4d);
                        break;
                    } else {
                        this.stampDuty1 = (float) (((double) f) * 2.0E-5d);
                        break;
                    }
                case 2:
                    if (this.mRadioPosition == 1) {
                        this.stampDuty1 = (float) (((double) f) * 1.0E-4d);
                        Log.e("TAG", "setResult:1.0E-4d:: " + this.stampDuty1);
                        break;
                    } else {
                        this.stampDuty1 = (float) (((double) f) * 2.0E-5d);
                        Log.e("TAG", "setResult:1.0E-4d:: " + this.stampDuty1);
                        break;
                    }
                case 3:
                    this.stampDuty1 = (float) (((double) f) * 3.0E-5d);
                    break;
                case 4:
                    if (this.mRadioPosition == 1) {
                        this.stampDuty1 = (float) (((double) f) * 1.0E-4d);
                        break;
                    } else {
                        this.stampDuty1 = (float) (((double) f) * 2.0E-5d);
                        break;
                    }
                case 5:
                    if (this.mRadioPosition == 1) {
                        this.stampDuty1 = (float) (((double) f) * 1.0E-4d);
                        break;
                    } else {
                        this.stampDuty1 = (float) (((double) f) * 2.0E-5d);
                        break;
                    }
                case 6:
                    int i = this.mRadioPosition;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                this.stampDuty1 = (float) (((double) f) * 1.1999999999999999E-5d);
                                break;
                            } else {
                                this.stampDuty1 = (float) (((double) f) * 2.3999999999999997E-5d);
                                break;
                            }
                        } else {
                            this.stampDuty1 = (float) (((double) f) * 1.2E-4d);
                            break;
                        }
                    } else {
                        this.stampDuty1 = (float) (((double) f) * 3.0E-5d);
                        break;
                    }
                case 7:
                    this.stampDuty1 = (float) (((double) f) * 6.0E-5d);
                    break;
                case 8:
                    float f3 = (float) (((double) f) * 2.0E-5d);
                    this.stampDuty = f3;
                    if (f3 < 1000.0f) {
                        this.stampDuty1 = f3;
                        break;
                    } else {
                        this.stampDuty1 = 1000.0f;
                        break;
                    }
                case 9:
                    if (this.mRadioPosition == 1) {
                        this.stampDuty1 = (float) (((double) f) * 1.0E-4d);
                        break;
                    } else {
                        this.stampDuty1 = (float) (((double) f) * 2.0E-5d);
                        break;
                    }
                default:
                    this.stampDuty1 = 0.0f;
                    break;
            }
            this.txtTurnover.setText(String.format("%.2f", Float.valueOf(this.turnover)) + " ₹");
            this.txtBrokerage.setText(String.format("%.2f", Float.valueOf(this.brokerage1)) + " ₹");
            this.txtStt.setText(this.sttTotal + " ₹");
            this.txtExchange.setText(String.format("%.2f", Float.valueOf(this.exchange)) + " ₹");
            this.txtGst.setText(String.format("%.2f", Float.valueOf(this.gst)) + " ₹");
            this.txtSebi.setText(String.format("%.2f", Float.valueOf(this.sebi)) + " ₹");
            this.txtStamp.setText(String.format("%.2f", Float.valueOf(this.stampDuty1)) + " ₹");
            float parseFloat = Float.parseFloat(String.format("%.2f", Float.valueOf(this.brokerage1)));
            float parseFloat2 = Float.parseFloat(String.valueOf(this.sttTotal));
            float parseFloat3 = Float.parseFloat(String.format("%.2f", Float.valueOf(this.exchange)));
            float parseFloat4 = Float.parseFloat(String.format("%.2f", Float.valueOf(this.clearing)));
            float parseFloat5 = parseFloat + parseFloat2 + parseFloat3 + parseFloat4 + Float.parseFloat(String.format("%.2f", Float.valueOf(this.gst))) + Float.parseFloat(String.format("%.2f", Float.valueOf(this.sebi))) + Float.parseFloat(String.format("%.2f", Float.valueOf(this.stampDuty1)));
            this.totalTax = parseFloat5;
            this.txtTotalTax.setText(String.format("%.2f", Float.valueOf(parseFloat5)) + " ₹");
            this.mQuantity.intValue();
            this.netProfit = ((float) (Math.round(this.mSellAmt.floatValue() * ((float) this.mQuantity.intValue())) - Math.round(this.mBuyAmt.floatValue() * ((float) this.mQuantity.intValue())))) - this.totalTax;
            this.txtNetProfit.setText("Net Profit :   " + String.format("%.2f", Float.valueOf(this.netProfit)) + " ₹");
            this.InvestAmount.setText((((float) (Integer.parseInt(this.edtBuy.getText().toString()) * Integer.parseInt(this.edtQuantity.getText().toString()))) + parseFloat5) + " ₹");
            this.fullinfo.setVisibility(View.VISIBLE);
            this.isCalculated = true;
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