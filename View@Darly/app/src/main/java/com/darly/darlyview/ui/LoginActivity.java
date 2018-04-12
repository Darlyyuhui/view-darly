package com.darly.darlyview.ui;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darly.common.NetUtils;
import com.darly.common.ToastApp;
import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.darlyview.common.SystemLoginInfo;
import com.darly.darlyview.wedget.grav.GravView;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.button.DSubButton;
import com.darly.dview.widget.clearedit.ClearEditText;

/**
 * @TODO:登录页面展示
 */
@ContentBinder(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements View.OnClickListener, OnCheckedChangeListener {
    @ViewsBinder(R.id.id_login_guide)
    CheckBox idLoginGuide;
    @ViewsBinder(R.id.id_login_set)
    TextView idLoginSet;
    @ViewsBinder(R.id.id_login_btn)
    DSubButton idLoginBtn;
    @ViewsBinder(R.id.id_login_name)
    ClearEditText idLoginName;
    @ViewsBinder(R.id.id_login_password)
    ClearEditText idLoginPassword;
    @ViewsBinder(R.id.id_login_login)
    LinearLayout id_login_login;
    @ViewsBinder(R.id.id_login_grav)
    GravView id_login_grav;

    @Override
    protected void initView(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        //添加登录界面动画效果
        id_login_login.setAnimation(AnimationUtils.loadAnimation(this,R.anim.login_up));
        idLoginBtn.setmButtonBackground(R.drawable.btn_login);
    }

    @Override
    public void loadData() {
        setUpLoginAnim();
        setUsernameAndPassword();
        if (!NetUtils.isNetworkAvailable(LoginActivity.this)) {
            if (SystemLoginInfo.getParamer("user") != null && !SystemLoginInfo.getParamer("user").equals("")) {
                ToastApp.showToast(R.string.loginoffline);
            } else {
                ToastApp.showToast(R.string.netnotavailable);
                idLoginBtn.setEnabled(false);
            }
        }
        idLoginName.setJoinEdit(idLoginPassword);
        SpannableString nams = new SpannableString("请输入账户名");//定义hint的值
        AbsoluteSizeSpan namass = new AbsoluteSizeSpan(16, true);//设置字体大小 true表示单位是sp
        nams.setSpan(namass, 0, nams.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        idLoginName.setHint(new SpannedString(nams));
        SpannableString ss = new SpannableString("请输入密码");//定义hint的值
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(16, true);//设置字体大小 true表示单位是sp
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        idLoginPassword.setHint(new SpannedString(ss));

        idLoginBtn.setViewInit("登录", "登录中", idLoginName, idLoginPassword);    //, mSettings, mTakePic);

        idLoginSet.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        idLoginSet.getPaint().setAntiAlias(true);//抗锯齿
        idLoginSet.setText(R.string.loginset);
        idLoginSet.setTextColor(getResources().getColor(R.color.color_login_guide));
        idLoginGuide.setText(R.string.loginpass);
        idLoginGuide.setTextColor(getResources().getColor(R.color.color_login_guide));

        if (ActivityManager.isUserAMonkey()) {
            idLoginName.setEnabled(false);
            idLoginPassword.setEnabled(false);
        }
    }

    @Override
    public void initListener() {
        idLoginBtn.setOnClickListener(this);
        idLoginSet.setOnClickListener(this);
        idLoginGuide.setOnCheckedChangeListener(this);
    }

    private void setUsernameAndPassword() {
        if (idLoginName == null || idLoginPassword == null)
            return;
        String username = SystemLoginInfo.getParamer("user");
        String password = SystemLoginInfo.getParamer("pass");
        idLoginName.setText(username);

        if (SystemLoginInfo.getboolean("mark")) {
            idLoginPassword.setText(password);
            idLoginGuide.setChecked(true);
        } else {
            idLoginPassword.setText(null);
            idLoginGuide.setChecked(false);
        }
    }

    private void setUpLoginAnim() {
        Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.login_up);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
            }
        });
    }
    public String getUserName() {
        return idLoginName.getText().toString().trim();
    }

    public String getPassword() {
        return idLoginPassword.getText().toString().trim();
    }

    @Override
    public void onClick(View v) {
        SystemLoginInfo.setParamer("user",getUserName());
        SystemLoginInfo.setParamer("pass",getPassword());
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SystemLoginInfo.setParamer("mark",isChecked);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        id_login_grav.stop();
    }
}
