package com.jikexuyuan.guessnumber;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editText;
    private TextView textView;
    private int UserValue;
    private int RandomValue;

    //Log输出
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //生成随机数
        RandomValue = (int) (Math.random() * 100);

        //对提交按键的响应

        findViewById(R.id.btn_apply).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.editText);
                textView = (TextView) findViewById(R.id.textViewResult);
                try {
                    //获取用户数
                    UserValue = Integer.parseInt(editText.getText().toString());

                    if (UserValue >= 0 && UserValue < 100) {
                        //比较大小
                        if (UserValue < RandomValue) {
                            textView.setText("小了");
                        } else if (UserValue > RandomValue) {
                            textView.setText("大了");
                        } else {
                            textView.setText("恭喜你猜对了!");
                        }
                    } else {
                        //提示输入错误的信息
                        textView.setText("您输入的数字不在0到100之间,请重新输入");
                    }
                }catch(Exception e){
                    Log.e(TAG,"出错了");
                }
            }
        });

        //对换数字按键的响应

        findViewById(R.id.btn_retry).setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                RandomValue = (int) (Math.random() * 100);
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.setText("换完了,猜吧");
            }
        });
    }
}
