package com.example.sudoku;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomButton extends FrameLayout {

    int row;
    int col;
    int value;

    TextView textView;
    TextView memoTextView[][];

//    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    TableLayout memo = (TableLayout) layoutInflater.inflate(R.layout.layout_memo, null);
//    addView(memo);

    public CustomButton(@NonNull Context context) {
        super(context);
    }

    public CustomButton(Context context, int row, int col) {
        super(context);
        this.row=row;
        this.col=col;
        this.textView= new TextView(context);
        textView.setTextSize(50);
        textView.setTextColor(Color.rgb(0,0,255));
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        addView(textView);

        TableLayout tableLayout = new TableLayout(context);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f);

        memoTextView=new TextView[3][3];

        int cnt=0;
        for (int i = 0; i < 3; i++) {

            TableRow tableRow = new TableRow(context);


            for (int j = 0; j < 3; j++) {
                memoTextView[i][j] = new TextView(context);

                memoTextView[i][j].setLayoutParams(layoutParams);

                memoTextView[i][j].setTextColor(Color.rgb(0, 0, 0));
                memoTextView[i][j].setText(String.valueOf(++cnt));
                memoTextView[i][j].setTextSize(15);
                memoTextView[i][j].setTypeface(Typeface.DEFAULT_BOLD);
                memoTextView[i][j].setGravity(Gravity.CENTER);
                memoTextView[i][j].setVisibility(INVISIBLE);

                tableRow.addView(memoTextView[i][j]);
            }
            tableLayout.setLayoutParams(layoutParams);
            tableLayout.addView(tableRow);
        }
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f);
        tableLayout.setLayoutParams(tableLayoutParams);
        addView(tableLayout);

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

    public int getValue() {
        return this.value;
    }

}