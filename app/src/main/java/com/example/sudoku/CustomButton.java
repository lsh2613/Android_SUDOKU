package com.example.sudoku;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomButton extends FrameLayout {

    int row;
    int col;
    int value;

    TextView textView;

    public CustomButton(@NonNull Context context) {
        super(context);
    }

    public CustomButton(Context context, int row, int col) {
        super(context);
        this.row=row;
        this.col=col;
        this.textView= new TextView(context);
        textView.setTextSize(44);
        textView.setTextColor(Color.rgb(0,0,255));
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        addView(textView);
        setClickable(true);
        setBackgroundResource(R.drawable.button_selec);
    }

    public void set(int a){
        if(a==0) {
            this.value = 0;
            textView.setText(null);
        }else {
            this.value=a;
            textView.setText(String.valueOf(a));
        }
    }

}