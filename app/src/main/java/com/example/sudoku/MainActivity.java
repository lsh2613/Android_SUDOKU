package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BoardGenerator board = new BoardGenerator();
    CustomButton clickedCustomButton=null;
    TableLayout numberPad;
    CustomButton[][] buttons;
    int valueBefore;

    public void onClickNum1(View view) {
        clickedCustomButton.set(1);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum2(View view) {
        clickedCustomButton.set(2);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum3(View view) {
        clickedCustomButton.set(3);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum4(View view) {
        clickedCustomButton.set(4);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum5(View view) {
        clickedCustomButton.set(5);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum6(View view) {
        clickedCustomButton.set(6);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum7(View view) {
        clickedCustomButton.set(7);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum8(View view) {
        clickedCustomButton.set(8);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickNum9(View view) {
        clickedCustomButton.set(9);
        numberPad.setVisibility(View.INVISIBLE);
        unsetConflict();
        setConflict();
        isComplete();

    }
    public void onClickDelete(View view) {
        clickedCustomButton.set(0);
        unsetConflict();
        numberPad.setVisibility(View.INVISIBLE);
    }

    public void onClickCancel(View view) {
        numberPad.setVisibility(View.INVISIBLE);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new CustomButton[9][9];

        TableLayout table = (TableLayout) findViewById(R.id.tableLayout);
        numberPad = (TableLayout) findViewById(R.id.numberpad);
        numberPad.setVisibility(View.INVISIBLE);

        /**
         * 화면에 띄우기 위한 dialog_memo 인플레이터
         */
//        ConstraintLayout container = (ConstraintLayout)findViewById(R.id.constraintLayout);
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.dialog_memo, container,true);
//
//        TableLayout dialogMemo = (TableLayout)container.findViewById(R.id.memo);
//        dialogMemo.setVisibility(View.INVISIBLE);


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
                        valueBefore = clickedCustomButton.value;
                    }
                });

                /**
                 * 버튼 길게 클릭 시 메모 visible
                 */

                buttons[i][j].setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
//                        dialogMemo.setVisibility(View.VISIBLE);
                        return true;
                    }
                });

                int number = board.get(i, j);

                if (Math.random() <= 0.99) {
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
//        테스트용
//        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout);
//        TableRow childAt = (TableRow)tl.getChildAt(0);
//        View virtualChildAt = childAt.getVirtualChildAt(0);
//        virtualChildAt.setBackgroundColor(Color.rgb(255,0,0));

        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout);

        int row = clickedCustomButton.row;
        int col = clickedCustomButton.col;
        int clickedValue = clickedCustomButton.value;
        int flag=0;

        /**
         * 행에 대해
         */
        for (int i = 0; i < 9; i++) {
            TableRow tableRow = (TableRow) tl.getChildAt(row);
            CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(i);
            if (clickedValue == customButton.value) {
                flag++;
                customButton.setBackgroundColor(Color.rgb(255, 0, 0));
                customButton.setAlpha(0.99f);

            }
        }

        /**
         * 열에 대해
         */
        for (int i = 0; i < 9; i++) {
            TableRow tableRow = (TableRow) tl.getChildAt(i);
            CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(col);
            if (clickedValue == customButton.value) {
                flag++;
                customButton.setBackgroundColor(Color.rgb(255, 0, 0));
                customButton.setAlpha(0.99f);

            }
        }

        /**
         * 같은 박스에 대해
         */
        int boxRow = row / 3;
        int boxCol = col / 3;

        for (int i = 0; i < 3; i++) {
            TableRow tableRow = (TableRow) tl.getChildAt(boxRow*3+i);
            for (int j = 0; j < 3; j++) {
                CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(boxCol*3+j);
                if (clickedValue == customButton.value) {
                    flag++;
                    customButton.setBackgroundColor(Color.rgb(255, 0, 0));
                    customButton.setAlpha(0.99f);
                }
            }
        }

        /**
         * 선택된 버튼도 위 검증으로 인해 컬러변경이 3번 이루어지기 때문에 해당 부분은 흰색으로
         */
        if (flag == 3) {
            TableRow tableRow = (TableRow) tl.getChildAt(row);
            CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(col);
            customButton.setBackgroundColor(Color.rgb(255, 255, 255));
        }

    }



    // No conflict
    public void unsetConflict() {
        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout);

        int row = clickedCustomButton.row;
        int col = clickedCustomButton.col;

        /**
         * 행에 대해
         */
        for (int i = 0; i < 9; i++) {
            TableRow tableRow = (TableRow) tl.getChildAt(row);
            CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(i);
            if (valueBefore==customButton.value){
                customButton.setBackgroundColor(Color.rgb(255,255,255));
                clickedCustomButton.setBackgroundColor(Color.rgb(255, 255, 255));
                customButton.setAlpha(1f);
            }
        }

        /**
         * 열에 대해
         */
        for (int i = 0; i < 9; i++) {
            TableRow tableRow = (TableRow) tl.getChildAt(i);
            CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(col);
            if (valueBefore==customButton.value){
                customButton.setBackgroundColor(Color.rgb(255,255,255));
                clickedCustomButton.setBackgroundColor(Color.rgb(255, 255, 255));
                customButton.setAlpha(1f);
            }
        }

        /**
         * 같은 박스에 대해
         */
        int boxRow = row / 3;
        int boxCol = col / 3;

        for (int i = 0; i < 3; i++) {
            TableRow tableRow = (TableRow) tl.getChildAt(boxRow*3+i);
            for (int j = 0; j < 3; j++) {
                CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(boxCol*3+j);
                if (valueBefore==customButton.value){
                    customButton.setBackgroundColor(Color.rgb(255, 255, 255));
                    clickedCustomButton.setBackgroundColor(Color.rgb(255, 255, 255));
                    customButton.setAlpha(1f);
                }

            }

        }
    }
    public void isComplete() {
        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout);

        int cntOfWhite=0;
        int cntOf1 = 0;
        int cntOf2 = 0;
        int cntOf3 = 0;
        int cntOf4 = 0;
        int cntOf5 = 0;
        int cntOf6 = 0;
        int cntOf7 = 0;
        int cntOf8 = 0;
        int cntOf9 = 0;

        for (int i = 0; i < 9; i++) {
            TableRow tableRow = (TableRow) tl.getChildAt(i);
            for (int j = 0; j < 9; j++) {
                CustomButton customButton = (CustomButton) tableRow.getVirtualChildAt(j);
                int value = customButton.getValue();
                if (customButton.getAlpha()==1f)
                    cntOfWhite++;
                switch (value) {
                    case 1:
                        cntOf1++;
                        break;
                    case 2:
                        cntOf2++;
                        break;
                    case 3:
                        cntOf3++;
                        break;
                    case 4:
                        cntOf4++;
                        break;
                    case 5:
                        cntOf5++;
                        break;
                    case 6:
                        cntOf6++;
                        break;
                    case 7:
                        cntOf7++;
                        break;
                    case 8:
                        cntOf8++;
                        break;
                    case 9:
                        cntOf9++;
                        break;
                }
            }
        }
        //todo 성공 창 xml로 띄우고 더이상 버튼 못 만지게 하는 기능 추가
        if (cntOfWhite == 80 && cntOf1 == 9 && cntOf2 == 9 && cntOf3 == 9 && cntOf4 == 9
                && cntOf5 == 9 && cntOf6 == 9 && cntOf7 == 9 && cntOf8 == 9 && cntOf9 == 9) {
            Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show();
        }
    }

}

