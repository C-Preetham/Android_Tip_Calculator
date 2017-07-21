package com.revannthco.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageButton;
public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tp;
    TextView tt;
    TextView totalA;
    ImageButton ib1,ib2,ib3;
    float finalbillamt=0;
    float tippercent=0;
    float initialbill=0;
    float tipamt=0;
    float DEFAULT_P=15;
    float BAD_P=10;
    float EXCELLENT_P=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.etBamount);
        tp=(TextView)findViewById(R.id.tvll1);
        tt=(TextView)findViewById(R.id.tvll2);
        totalA=(TextView)findViewById(R.id.Result);
        ib1=(ImageButton)findViewById(R.id.ibBad);
        ib2=(ImageButton)findViewById(R.id.ibGood);
        ib3=(ImageButton)findViewById(R.id.ibExcellent);

        setValues();
    }



    public void onClick(View view)
    {
        switch(view.getId()){
            case R.id.ibBad:
                tippercent=BAD_P;
                break;
            case R.id.ibGood:
                tippercent=DEFAULT_P;
                break;
            case R.id.ibExcellent:
                tippercent=EXCELLENT_P;
                break;

        }
        calculateFinal();
        setValues();
    }

    public void setValues()
    {
            tp.setText(getString(R.string.main_msg_tippercent,tippercent));
        tt.setText(getString(R.string.main_msg_tiptotal,tipamt));
        totalA.setText(getString(R.string.main_msg_billtotalresult,finalbillamt));

    }
    public void onTextChanged()
    {
        calculateFinal();
        setValues();
    }
    private void calculateFinal()
    {
        if(tippercent==0)
            tippercent=DEFAULT_P;
        if(!et.getText().toString().equals("")&&!et.getText().toString().equals("."))
            initialbill=Float.valueOf(et.getText().toString());
        else
            finalbillamt=0;
        tipamt=(tippercent*initialbill)/100;
        finalbillamt=initialbill+tipamt;

    }



}

