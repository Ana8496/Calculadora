package com.inmamesayanasousaysergio.calculadora;

public class Operaciones {

    private char op;
    private float num1;
    private float num2;
    private float m = 0;

    public void realizarOperacion() {
        switch (op)
        {
            case '+':
                num1 = num1 + num2;
                break;
            case '-':
                num1 = num1 - num2;
                break;
            case '*':
                num1 = num1 * num2;
                break;
            case '/':
                num1 = num1 / num2;
                break;
            case 'e':
                num1 = (float) Math.pow(num1, num2);
                break;
        }
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }
}
