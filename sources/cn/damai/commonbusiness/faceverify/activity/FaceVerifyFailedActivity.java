package cn.damai.commonbusiness.faceverify.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager;
import cn.damai.im.AliMeUtil;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FaceVerifyFailedActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private String idCard;
    private String idType;
    private String scene;
    private String userName;

    private void goBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880658728")) {
            ipChange.ipc$dispatch("-880658728", new Object[]{this});
            return;
        }
        DMFaceVerifyManager.n().r();
        xr.c("faceVerify", Boolean.FALSE);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752088937")) {
            ipChange.ipc$dispatch("-752088937", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.idCard = extras.getString("idCard");
            this.idType = extras.getString("idType");
            this.userName = extras.getString(ALBiometricsKeys.KEY_USERNAME);
            this.scene = extras.getString("scene");
        }
        TextView textView = (TextView) findViewById(R$id.realname_error_left_btn);
        TextView textView2 = (TextView) findViewById(R$id.realname_error_right_btn);
        findViewById(R$id.realname_title_back).setOnClickListener(this);
        ((TextView) findViewById(R$id.mine_base_header_title)).setText("采集失败");
        ((TextView) findViewById(R$id.realname_error_status)).setText("采集失败");
        ((TextView) findViewById(R$id.realname_error_msg)).setText("请确保是本人证件，且扫脸拍摄清晰");
        textView2.setText("重新认证");
        textView.setText("联系客服");
        textView2.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    public static final void startFaceVerifyFailedActivity(Context context, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009526929")) {
            ipChange.ipc$dispatch("2009526929", new Object[]{context, str, str2, str3, str4});
            return;
        }
        Intent intent = new Intent(context, FaceVerifyFailedActivity.class);
        intent.putExtra("idCard", str);
        intent.putExtra("idType", str2);
        intent.putExtra(ALBiometricsKeys.KEY_USERNAME, str3);
        intent.putExtra("scene", str4);
        context.startActivity(intent);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1359963441")) {
            ipChange.ipc$dispatch("-1359963441", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1825304133") ? ((Integer) ipChange.ipc$dispatch("-1825304133", new Object[]{this})).intValue() : R$layout.realname_faceverify_failed_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683115296")) {
            ipChange.ipc$dispatch("1683115296", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007827723")) {
            ipChange.ipc$dispatch("2007827723", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975780174")) {
            ipChange.ipc$dispatch("-975780174", new Object[]{this});
            return;
        }
        hideBaseLayout();
        init();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929599961")) {
            ipChange.ipc$dispatch("-1929599961", new Object[]{this});
            return;
        }
        super.onBackPressed();
        goBack();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594831384")) {
            ipChange.ipc$dispatch("594831384", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.realname_error_right_btn) {
            DMFaceVerifyManager.n().x(this, this.idCard, this.idType, this.userName, null, this.scene);
            finish();
        } else if (id == R$id.realname_error_left_btn) {
            AliMeUtil.k(this, AliMeUtil.FROM_REALNAME_AUTH);
        } else if (id == R$id.realname_title_back) {
            goBack();
            finish();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1369301425")) {
            ipChange.ipc$dispatch("-1369301425", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392044518")) {
            ipChange.ipc$dispatch("1392044518", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1312478447")) {
            return (String) ipChange.ipc$dispatch("1312478447", new Object[]{this});
        }
        return null;
    }
}
