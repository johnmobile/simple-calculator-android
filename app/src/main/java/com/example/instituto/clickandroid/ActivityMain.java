package com.example.instituto.clickandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ActivityMain extends Activity implements View.OnClickListener{
    TextView tvResult;
    EditText edVal1, edVal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnDivider).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnClean).setOnClickListener(this);

        initObjects();
    }

    private void initObjects(){
        tvResult = (TextView) findViewById(R.id.tvResult);
        edVal1 = (EditText) findViewById(R.id.edVal1);
        edVal2 = (EditText) findViewById(R.id.edVal2);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnClean){
            edVal1.setText("");
            edVal2.setText("");
            tvResult.setText("");
            edVal1.requestFocus();
            return;
        }

        try{
            double val1 = Double.parseDouble(String.valueOf(edVal1.getText()));
            double val2 = Double.parseDouble(String.valueOf(edVal2.getText()));

            switch (v.getId()){
                case R.id.btnPlus:
                    setCalcResult(String.valueOf(val1 + val2));
                    break;
                case R.id.btnMinus:
                    setCalcResult(String.valueOf(val1 - val2));
                    break;
                case R.id.btnDivider:
                    setCalcResult(String.valueOf(val1 / val2));
                    break;
                case R.id.btnMultiply:
                    setCalcResult(String.valueOf(val1 * val2));
                    break;
            }
        } catch (Exception e){
            setCalcResult("Valor inválido");
            return;
        }
    }

    public void setCalcResult(String result){
        tvResult.setText(result);
    }
}
