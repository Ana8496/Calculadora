package com.inmamesayanasousaysergio.calculadora;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private Operaciones operaciones;
    private boolean error = false;
    private TextView m;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operaciones = new Operaciones();

        m = findViewById(R.id.m);
        m.setVisibility(View.INVISIBLE);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("0");
    }

    public void oneBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("1");
    }

    public void twoBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("2");
    }

    public void threeBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("3");
    }

    public void fourBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("4");
    }

    public void fiveBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("5");
    }

    public void sixBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("6");
    }

    public void sevenBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("7");
    }

    public void eightBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("8");
    }

    public void nineBTN(View view) {
        if(error == true) {
            display.setText("");
            error = false;
        }
        updateText("9");
    }

    public void ceBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos- 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void cBTN(View view) {
        display.setText("");
    }

    public void exponentBTN(View view) {
        operaciones.setOp('e');
        operaciones.setNum1(Float.parseFloat(display.getText().toString()));
        display.setText("");
    }

    public void divideBTN(View view) {
        operaciones.setOp('/');
        operaciones.setNum1(Float.parseFloat(display.getText().toString()));
        display.setText("");
    }

    public void multiplyBTN(View view) {
        operaciones.setOp('*');
        operaciones.setNum1(Float.parseFloat(display.getText().toString()));
        display.setText("");
    }

    public void addBTN(View view) {
        operaciones.setOp('+');
        operaciones.setNum1(Float.parseFloat(display.getText().toString()));
        display.setText("");
    }

    public void subtractBTN(View view) {
        operaciones.setOp('-');
        operaciones.setNum1(Float.parseFloat(display.getText().toString()));
        display.setText("");
    }

    public void pointBTN(View view) {
        updateText(".");
    }

    public void equalBTN(View view) {
        operaciones.setNum2(Float.parseFloat(display.getText().toString()));
        if((operaciones.getOp()) == '/' && operaciones.getNum2() == 0) {
            error = true;
            display.setText("No se puede dividir entre cero");
        } else {
            operaciones.realizarOperacion();
            display.setText(String.valueOf(operaciones.getNum1()));
            display.setSelection(display.getText().length());
        }
    }

    public void msBTN(View view) {
        m.setVisibility(View.VISIBLE);
        operaciones.setM(Float.parseFloat(display.getText().toString()));
    }

    public void mrBTN(View view) {
        m.setVisibility(View.INVISIBLE);
        display.setText(String.valueOf(operaciones.getM()));
        display.setSelection(display.getText().length());
    }

    public void rBTN(View view) {
        Intent intent=new Intent();
        intent.setClass(this, this.getClass());
        //llamamos a la actividad
        this.startActivity(intent);
        //finalizamos la actividad actual
        this.finish();
    }

}