package com.example.user.myapplication;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radioGroup;
    Button button;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    int mora_gamer = -1;
    String[] MoraString ={"剪刀","石頭","布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.button);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        mora_gamer = 0;
                        break;
                    case R.id.radioButton2:
                        mora_gamer = 1;
                        break;
                    case R.id.radioButton3:
                        mora_gamer = 2;
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals(" "))
                    textView.setText("請選擇玩家名稱");
                else if (mora_gamer == -1)
                    textView.setText("請選擇出拳的種類");
                else {
                    textView6.setText(editText.getText());
                    textView8.setText(MoraString[mora_gamer]);
                    int mora_computer = (int) (Math.random() * 3);
                    textView9.setText(MoraString[mora_computer]);
                    if ((mora_gamer == 0 && mora_computer == 1) || (mora_gamer == 1 && mora_computer == 2) || (mora_gamer == 2 && mora_computer == 0)) {
                        textView7.setText("電腦");
                        textView.setText("可惜，電腦獲勝了");
                    } else if (mora_computer == mora_gamer) {
                        textView7.setText("平局");
                        textView.setText("平局!在試一場看看");
                    } else {
                        textView7.setText(editText.getText());
                        textView.setText("恭喜你獲勝了");
                    }
                }
            }
        });
    }
}
