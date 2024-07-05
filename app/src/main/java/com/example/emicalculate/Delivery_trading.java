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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Delivery_trading extends Fragment {

    /* access modifiers changed from: private */
    public EditText edtBuy;
    /* access modifiers changed from: private */
    public EditText edtQuantity;
    /* access modifiers changed from: private */
    public EditText edtSell;
    public Float mBuyAmt;
    public int mCheckedId;
    public Integer mQuantity;
    public int mRadioPosition;
    public Float mSellAmt;
    public int mStatePosition;
    Button Calculate;
    ImageView delivery_back;
    LinearLayout fullinfo;
    boolean isCalculated = false;
    Button reset;
    private TextView InvestAmount;
    private float brokerage;
    private float brokerage1;
    private float clearing;
    private float exchange;
    private float gst;
    private float netProfit;
    private RadioButton radioBse;
    private RadioGroup radioGroup;
    private RadioButton radioNse;
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

    @SuppressLint({"WrongViewCast", "ResourceType", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_trading, container, false);


        edtBuy = view.findViewById(R.id.edt_buy);
        edtSell = view.findViewById(R.id.edt_sell);
        edtQuantity = view.findViewById(R.id.edt_quantity);
        spinStates = view.findViewById(R.id.spinner_state_delivery);
        radioGroup = view.findViewById(R.id.delivery_radio);
        radioNse = view.findViewById(R.id.radio_nse);
        radioBse = view.findViewById(R.id.radio_bse);
        txtTurnover = view.findViewById(R.id.txt_turnover1);
        txtBrokerage = view.findViewById(R.id.txt_brokerage1);
        txtStamp = view.findViewById(R.id.txt_stamp1);
        txtStt = view.findViewById(R.id.txt_stt1);
        txtExchange = view.findViewById(R.id.txt_exchange1);
        txtGst = view.findViewById(R.id.txt_gst1);
        txtSebi = view.findViewById(R.id.txt_sebi1);
        txtTotalTax = view.findViewById(R.id.txt_total_tax1);
        InvestAmount = view.findViewById(R.id.InvestAmount);
        txtNetProfit = view.findViewById(R.id.txt_net_profit);
        Calculate = view.findViewById(R.id.btn_calculate);
        reset = view.findViewById(R.id.btn_reset);
        fullinfo = view.findViewById(R.id.fullinfo);
        delivery_back = view.findViewById(R.id.delivery_back);

        fullinfo.setVisibility(View.INVISIBLE);

        delivery_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });
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
        @SuppressLint("ResourceType") ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(requireActivity(), R.array.States, 17367048);
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

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void setResult() {
        if (this.edtBuy.getText().toString().isEmpty()) {
            edtBuy.setError("Enter Buy Price");
        } else if (this.edtSell.getText().toString().isEmpty()) {
            edtSell.setError("Enter sell Price");
        } else if (this.edtQuantity.getText().toString().isEmpty()) {
            edtQuantity.setError("Enter Quantity");
        } else {
            boolean isNullFloat = isNullFloat(mBuyAmt, mSellAmt);
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
            turnover = (this.mBuyAmt.floatValue() * ((float) mQuantity.intValue())) + (this.mSellAmt.floatValue() * ((float) mQuantity.intValue()));
            Log.e("TAG", "setResult: i22222222222222222222 1");
            brokerage1 = 0.0f;
            float f = turnover;
            double d = f;
            sttTotal = (int) (0.001d * d);
            if (indexOfChild == 0) {
                exchange = (float) (d * 3.25E-5d);
            } else {
                exchange = (float) (d * 3.0E-5d);
            }
            clearing = 0.0f;
            gst = (this.exchange + 0.0f) * 0.18f;
            sebi = (f / 1.0E7f) * 10.0f;
            if (this.mStatePosition == 0) {
                float f2 = (float) (((double) f) * 5.0E-5d);
                stampDuty = f2;
                if (f2 < 50.0f) {
                    stampDuty1 = f2;
                } else {
                    stampDuty1 = 50.0f;
                }
            } else if (this.mStatePosition == 1) {
                if (this.mRadioPosition == 1) {
                    stampDuty1 = (float) (((double) f) * 1.0E-4d);
                } else {
                    stampDuty1 = (float) (((double) f) * 2.0E-5d);
                }
            } else if (this.mStatePosition == 2) {
                if (this.mRadioPosition == 1) {
                    stampDuty1 = (float) (((double) f) * 1.0E-4d);
                    Log.e("TAG", "setResult:1.0E-4d:: " + stampDuty1);
                } else {
                    stampDuty1 = (float) (((double) f) * 2.0E-5d);
                    Log.e("TAG", "setResult:1.0E-4d:: " + stampDuty1);
                }
            } else if (this.mStatePosition == 3) {
                stampDuty1 = (float) (((double) f) * 3.0E-5d);
            } else if (this.mStatePosition == 4) {
                if (this.mRadioPosition == 1) {
                    stampDuty1 = (float) (((double) f) * 1.0E-4d);
                } else {
                    stampDuty1 = (float) (((double) f) * 2.0E-5d);
                }
            } else if (this.mStatePosition == 5) {
                if (this.mRadioPosition == 1) {
                    stampDuty1 = (float) (((double) f) * 1.0E-4d);
                } else {
                    stampDuty1 = (float) (((double) f) * 2.0E-5d);
                }
            } else if (this.mStatePosition == 6) {
                int i = mRadioPosition;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            stampDuty1 = (float) (((double) f) * 1.1999999999999999E-5d);
                        } else {
                            stampDuty1 = (float) (((double) f) * 2.3999999999999997E-5d);
                        }
                    } else {
                        stampDuty1 = (float) (((double) f) * 1.2E-4d);
                    }
                } else {
                    stampDuty1 = (float) (((double) f) * 3.0E-5d);
                }
            } else if (this.mStatePosition == 7) {
                stampDuty1 = (float) (((double) f) * 6.0E-5d);
            } else if (this.mStatePosition == 8) {
                float f3 = (float) (((double) f) * 2.0E-5d);
                stampDuty = f3;
                if (f3 < 1000.0f) {
                    stampDuty1 = f3;
                } else {
                    stampDuty1 = 1000.0f;
                }
            } else if (this.mStatePosition == 9) {
                if (this.mRadioPosition == 1) {
                    stampDuty1 = (float) (((double) f) * 1.0E-4d);
                } else {
                    stampDuty1 = (float) (((double) f) * 2.0E-5d);
                }
            } else {
                stampDuty1 = 0.0f;
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