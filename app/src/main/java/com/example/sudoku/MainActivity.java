package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    BoardGenerator board = new BoardGenerator();
    CustomButton clickedCustomButton=null;

    public void onClickNum1(View view) {
        clickedCustomButton.set(1);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum2(View view) {
        clickedCustomButton.set(2);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum3(View view) {
        clickedCustomButton.set(3);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum4(View view) {
        clickedCustomButton.set(4);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum5(View view) {
        clickedCustomButton.set(5);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum6(View view) {
        clickedCustomButton.set(6);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum7(View view) {
        clickedCustomButton.set(7);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum8(View view) {
        clickedCustomButton.set(8);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickNum9(View view) {
        clickedCustomButton.set(9);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }
    public void onClickDelete(View view) {
        clickedCustomButton.set(0);
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }

    public void onClickCancel(View view) {
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);
        numberPad.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout table = (TableLayout) findViewById(R.id.tableLayout);
        CustomButton[][] buttons = new CustomButton[9][9];
        TableLayout numberPad = (TableLayout) findViewById(R.id.numberPad);

        numberPad.setVisibility(View.INVISIBLE);

        for (int i = 0; i < 9; i++) {
            TableRow tableRow = new TableRow(this);

            for (int j = 0; j < 9; j++) {
                buttons[i][j] = new CustomButton(this, i, j);

                /**
                 * 버튼 클릭 시 넘버패드 visible ㄱㄱ
                 */
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clickedCustomButton = (CustomButton) view;
                        numberPad.setVisibility(View.VISIBLE);
                    }
                });

                int number = board.get(i, j);

                if (Math.random() <= 0.65) {
                    buttons[i][j].set(number);
                }

                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1.0f);

                int left = 5;
                int top = 5;
                int right = 5;
                int bottom = 5;

                if (i == 3 || i == 6) {
                    top = 35;
                }
                if (j == 3 || j == 6) {
                    left = 20;
                }

                layoutParams.setMargins(left, top, right, bottom);
                buttons[i][j].setLayoutParams(layoutParams);
                tableRow.addView(buttons[i][j]);
            }
            table.addView(tableRow);

        }
    }

    // Conflict
    public void setConflict() {

    }

    // No conflict
    public void unsetConflict() {

    }


}

