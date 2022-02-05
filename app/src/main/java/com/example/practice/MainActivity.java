package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText editText;
    TextView txtView;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPlus;
    Button btnDot;
    Button btnSub;
    Button btnMultiply;
    Button btnDivide;
    Button btnDelete;
    Button btnClear;
    Button btnEquals;

    private final String Zero = "0";
    private String Symbol = "";
    private String firstNumb = null;
    String Dot = "";

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnNumb0:
                String txt = editText.getText().toString();
                if(txt.equals("0")) {
                    editText.setText("0");
                }
                else {
                    txt = txt + "0";
                    editText.setText(txt);
                }break;
            case R.id.btnNumb1:
                addText("1");
                break;
            case R.id.btnNumb2:
                addText("2");
                break;
            case R.id.btnNumb3:
                addText("3");
                break;
            case R.id.btnNumb4:
                addText("4");
                break;
            case R.id.btnNumb5:
                addText("5");
                break;
            case R.id.btnNumb6:
                addText("6");
                break;
            case R.id.btnNumb7:
                addText("7");
                break;
            case R.id.btnNumb8:
                addText("8");
                break;
            case R.id.btnNumb9:
                addText("9");
                break;
            case R.id.btnNumbClear:
                editText.setText("0");
                txtView.setText("");
                firstNumb = null;
                break;
            case R.id.btnNumbPlus:
                function("+");
                break;
            case R.id.btnNumbSub:
                function("-");
                break;
            case R.id.btnNumbMultiply:
                function("*");
                break;
            case R.id.btnNumbDivide:
                function("/");
                break;
            case R.id.btnDelete:
                String text = editText.getText().toString();
                if(text.length() == 1){
                    editText.setText("0");
                    txtView.setText("");
                    Symbol = "";
                }
                else {
                    StringBuffer newString = new StringBuffer(text);
                    newString.deleteCharAt(text.length()-1);
                    text = String.valueOf(newString);
                    editText.setText(text);
                }

                break;
            case R.id.btnNumbEquals:
                equals();
                break;
            case R.id.btnNumbDot:
                if(Dot.equals("")) {
                    addText(".");
                    Dot = ".";
                }
                break;
        }
    }

    public void addText(String numb) {
        String txt = editText.getText().toString();
        if(!txt.equals("0")) {
            //txt = numb;
            txt = txt + numb;
            editText.setText(txt);
        }
        else {
            editText.setText(numb);
        }
    }

    public void function(String func) {
        if(Symbol.equals("")){
            firstNumb = editText.getText().toString();
            switch (func){
                case "+":
                    Symbol = "+";
                    txtView.setText("+");
                    editText.setText("");
                    break;
                case "-":
                    Symbol = "-";
                    txtView.setText("-");
                    editText.setText("");
                    break;
                case "/":
                    Symbol = "/";
                    txtView.setText("/");
                    editText.setText("");
                    break;
                case "*":
                    Symbol = "*";
                    txtView.setText("x");
                    editText.setText("");
                    break;
            }
        }
        else {

            switch (func) {
                case "+":
                    equals();
                    firstNumb = editText.getText().toString();
                    Symbol = "+";
                    txtView.setText("+");
                    editText.setText("");
                    break;
                case "-":
                    equals();
                    Symbol = "-";
                    firstNumb = editText.getText().toString();
                    txtView.setText("-");
                    editText.setText("");
                    break;
                case "/":
                    equals();
                    firstNumb = editText.getText().toString();
                    Symbol = "/";
                    txtView.setText("/");
                    editText.setText("");
                    break;
                case "*":
                    equals();
                    firstNumb = editText.getText().toString();
                    Symbol = "*";
                    txtView.setText("x");
                    editText.setText("");
                    break;
            }
        }
    }

    public void equals() {
        if(Symbol.equals("")) {
           Toast.makeText(this, "Select a function!!", Toast.LENGTH_SHORT).show();
        }
        else {
            double Numb1 = Double.parseDouble(firstNumb);
            String temp = editText.getText().toString();
            double Numb2;
            if(temp.equals(""))
            {
                Numb2 = 0;
            }
            else
            {
                Numb2 = Double.parseDouble(temp);
            }
            switch(Symbol)
            {
                case "+":
                    Numb2 = Numb2 + Numb1;
                    editText.setText(String.valueOf(Numb2));
                    break;
                case "-":
                    Numb2 = Numb1 - Numb2;
                    editText.setText(String.valueOf(Numb2));
                    break;
                case "*":
                    Numb2 = Numb2 * Numb1;
                    editText.setText(String.valueOf(Numb2));
                    break;
                case "/":
                    if(Numb2 == 0) {
                        Toast.makeText(this, "Undefined", Toast.LENGTH_SHORT).show();
                    }
                    else{
                         Numb2 = Numb1/Numb2;
                         editText.setText(String.valueOf(Numb2));
                    }
                    break;
            }

        }
        Symbol = "";
        txtView.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTxt);

        btn0 = findViewById(R.id.btnNumb0);
        btn1 = findViewById(R.id.btnNumb1);
        btn2 = findViewById(R.id.btnNumb2);
        btn3 = findViewById(R.id.btnNumb3);
        btn4 = findViewById(R.id.btnNumb4);
        btn6 = findViewById(R.id.btnNumb6);
        btn5 = findViewById(R.id.btnNumb5);
        btn7 = findViewById(R.id.btnNumb7);
        btn8 = findViewById(R.id.btnNumb8);
        btn9 = findViewById(R.id.btnNumb9);
        btnPlus = findViewById(R.id.btnNumbPlus);
        btnDot = findViewById(R.id.btnNumbDot);
        btnSub = findViewById(R.id.btnNumbSub);
        btnMultiply = findViewById(R.id.btnNumbMultiply);
        btnDivide = findViewById(R.id.btnNumbDivide);
        btnDelete = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnNumbClear);
        btnEquals = findViewById(R.id.btnNumbEquals);
        txtView = findViewById(R.id.textView);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnDot.setOnClickListener(this);



    }

}