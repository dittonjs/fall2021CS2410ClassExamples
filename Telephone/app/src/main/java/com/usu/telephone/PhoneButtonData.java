package com.usu.telephone;


public class PhoneButtonData {
    public enum ButtonType {
        NUMBER,
        CALL,
        CLEAR,
    }

    public String text;
    public int row;
    public int col;
    public int colSpan;
    public ButtonType buttonType;

    public PhoneButtonData(String text, int row, int col, int colSpan, ButtonType buttonType) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.buttonType = buttonType;
    }

    public PhoneButtonData(String text, int row, int col, int colSpan) {
        this(text, row, col, colSpan, ButtonType.NUMBER);
    }
}
