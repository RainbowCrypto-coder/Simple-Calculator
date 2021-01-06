package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

 public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnMinus, btnMultiply, btnDivide, btnEqual, btnClear, btnDot, btnBrackets, btnPercentage, btnPlus;
    TextView tvInput, tvOutput;
    String process;
    boolean checkBracket = false;
    private Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClean);
        btnDot = findViewById(R.id.btnDot);
        btnBrackets = findViewById(R.id.btnBrackets);
        btnPercentage = findViewById(R.id.btnPercent);
        btnPlus = findViewById(R.id.btnPlus);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "9");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "-");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "÷");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "x");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + ".");
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                tvInput.setText(process + "%");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                process = tvInput.getText().toString();
                process = process.replaceAll("x", "^");
                process = process.replaceAll("%", "/100");
                process = process.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                }
                catch (Exception e){
                    finalResult = "0";
                }
                tvOutput.setText(finalResult);
            }
        });
        btnBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                if (checkBracket == true){
                    process = tvInput.getText().toString();
                    tvInput.setText(process + ")");
                    checkBracket = false;
                }
                else {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + "(");
                    checkBracket = true;
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrate(40);
                tvInput.setText("");
                tvOutput.setText("");
            }
        });
    }
     public void Vibrate (long millisecound){
         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
             ((Vibrator)getSystemService(VIBRATOR_SERVICE))
                     .vibrate(VibrationEffect.createOneShot(millisecound, VibrationEffect.DEFAULT_AMPLITUDE));
         }
         else {
             ((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(millisecound);
         }
     }

 }