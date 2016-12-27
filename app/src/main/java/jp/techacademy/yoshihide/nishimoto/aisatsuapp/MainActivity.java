package jp.techacademy.yoshihide.nishimoto.aisatsuapp;

import android.app.TimePickerDialog;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 2 && hourOfDay <= 9) {
                            mTextView.setText("おはよう");
                        } else if (hourOfDay >= 10 && hourOfDay <= 17) {
                            mTextView.setText("こんにちは");
                        } else if (hourOfDay >= 18 || hourOfDay <= 1) {
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                0, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}