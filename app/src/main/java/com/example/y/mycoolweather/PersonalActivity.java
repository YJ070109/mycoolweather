package com.example.y.mycoolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.y.mycoolweather.util.AnalysisUtils;

public class PersonalActivity extends AppCompatActivity {


    private ImageView iv_head_icon;
    private TextView tv_user_name;
    private LinearLayout ll_head;
    private RelativeLayout rl_setting;
    //private Context mContext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        ll_head = (LinearLayout) findViewById(R.id.ll_head);
        iv_head_icon = (ImageView) findViewById(R.id.iv_head_icon);
        tv_user_name = (TextView) findViewById(R.id.tv_user_name);
        rl_setting = (RelativeLayout) findViewById(R.id.rl_setting);
        setLoginParams(AnalysisUtils.readLoginStatus(this));

        ll_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AnalysisUtils.readLoginStatus(PersonalActivity.this)) {
                    Intent intent = new Intent(PersonalActivity.this, UserInfoActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(PersonalActivity.this, LoginActivity.class);
                    startActivityForResult(intent, 1);
                }
            }
        });
        rl_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AnalysisUtils.readLoginStatus(PersonalActivity.this)) {
                    Intent intent = new Intent(PersonalActivity.this, SettingActivity.class);
                    startActivityForResult(intent, 1);
                } else {
                    Toast.makeText(PersonalActivity.this, "您还未登录，请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 这个方法用在onViewCreated()，每次初始化这个界面都会启动
     * 通过登录后留在此页面并且立刻刷新用户名会在MainActivity的onActivityResult中处理
     **/
    private void setLoginParams(boolean isLogin) {
        if (isLogin) {
            tv_user_name.setText(AnalysisUtils.readLoginUserName(PersonalActivity.this));
        } else {
            tv_user_name.setText("点击登录");
        }
    }
}
