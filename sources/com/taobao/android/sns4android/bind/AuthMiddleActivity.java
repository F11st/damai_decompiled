package com.taobao.android.sns4android.bind;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
import com.taobao.android.sns4android.AuthCallback;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import com.taobao.login4android.constants.LoginStatus;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import tb.uj2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AuthMiddleActivity extends Activity {
    private static final String OAUTH_API = "taobao.oauth.code.create";
    public static int OPEN_TAOBAO = 59995;
    public static final String TAG = "login.LoginActivity";
    LinearLayout hiddenLayout;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TLogAdapter.e(AuthMiddleActivity.TAG, "click to destroy");
            AuthMiddleActivity.this.finish();
            LoginStatus.resetLoginFlag();
        }
    }

    private void failCallback(int i, String str) {
        if (SNSBindContext.loginCallback != null) {
            ((AuthCallback) SNSBindContext.loginCallback).onFail(i, str);
        }
    }

    protected void auth() {
        Intent intent = new Intent();
        intent.setAction(uj2.ACTION_CUSTOM);
        intent.setData(Uri.parse("tbopen://m.taobao.com/getway/oauth?&appkey=" + DataProviderFactory.getDataProvider().getAppkey() + "&pluginName=" + OAUTH_API + "&apkSign=" + getApkSignNumber() + "&sign="));
        if (getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            try {
                startActivityForResult(intent, OPEN_TAOBAO);
                return;
            } catch (Throwable unused) {
                failCallback(10006, "start taobao fail");
                finish();
                return;
            }
        }
        failCallback(10006, "taobao uninstalled");
        finish();
    }

    public String getApkSignNumber() {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(DataProviderFactory.getApplicationContext().getPackageManager().getPackageInfo(DataProviderFactory.getApplicationContext().getPackageName(), 64).signatures[0].toByteArray()))).getSerialNumber().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        TLogAdapter.d(TAG, "onActivityResult requestCode = " + i + " resultCode=" + i2);
        this.hiddenLayout.setClickable(true);
        this.hiddenLayout.setLongClickable(true);
        super.onActivityResult(i, i2, intent);
        if (SNSBindContext.activity == null) {
            SNSBindContext.setActivity(this);
        }
        SNSBindContext.onActivityResult(this, i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            failCallback(SNSJsbridge.SYSTEM_ERROR_CODE, SNSJsbridge.SYSTEM_ERROR_MESSAGE);
            finish();
        }
        LinearLayout linearLayout = new LinearLayout(this);
        this.hiddenLayout = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.hiddenLayout);
        this.hiddenLayout.setOnClickListener(new a());
        this.hiddenLayout.setClickable(false);
        this.hiddenLayout.setLongClickable(false);
        SNSBindContext.setActivity(this);
        TLogAdapter.e(TAG, "before mtop call showLogin");
        auth();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
