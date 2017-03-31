package com.jian.android.signtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;

public class MainActivity extends AppCompatActivity implements SecurityCodeView.InputCompleteListener {

    private SecurityCodeView editText;
    private TextView text;
    //private Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListener();

        BmobSMS.initialize(this,"c3afc6b5c969611f04beb79125e3ec2f");

        /*mSend = (Button) findViewById(R.id.send);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BmobSMS.requestSMSCode(MainActivity.this, "13824895510", "仅测试", new RequestSMSCodeListener() {

                    @Override
                    public void done(Integer smsId, BmobException ex) {
                        if(ex == null){

                            Toast.makeText(MainActivity.this,"发送成功",Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(MainActivity.this,"发送失败",Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });*/
    }

    private void setListener() {
        editText.setInputCompleteListener(this);
    }

    private void findViews() {
        editText = (SecurityCodeView) findViewById(R.id.scv_edittext);
        text = (TextView) findViewById(R.id.tv_text);
    }

    @Override
    public void inputComplete() {

        BmobSMS.verifySmsCode(MainActivity.this, "13824895510", editText.getEditContent(), new VerifySMSCodeListener() {

            @Override
            public void done(BmobException ex) {

                if(ex == null){
                    Toast.makeText(MainActivity.this,"验证码输入成功",Toast.LENGTH_SHORT).show();
                }else {
                    text.setText("验证码输入错误");
                    text.setTextColor(Color.RED);
                }
            }
        });

    }

    @Override
    public void deleteContent(boolean isDelete) {
        if (isDelete){
            text.setText("输入验证码表示同意《用户协议》");
            text.setTextColor(Color.BLACK);
        }
    }
}
