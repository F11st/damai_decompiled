package cn.damai;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.damai.common.util.ToastUtil;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.ui.WebConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.TBSsoLogin;
import com.taobao.android.sso.v2.launch.ILoginListener;
import com.taobao.android.sso.v2.launch.SsoLogin;
import com.taobao.android.sso.v2.launch.exception.SSOException;
import com.taobao.android.sso.v2.launch.model.ISsoRemoteParam;
import com.taobao.login4android.constants.LoginEnvType;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ResultActivity extends Activity implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private BroadcastReceiver a;
    private boolean b = true;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements ISsoRemoteParam {
        private static transient /* synthetic */ IpChange $ipChange;

        a(ResultActivity resultActivity) {
        }

        @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
        public String getApdid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1860578376") ? (String) ipChange.ipc$dispatch("1860578376", new Object[]{this}) : AlipayInfo.getInstance().getApdid();
        }

        @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
        public String getAppKey() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1957677148") ? (String) ipChange.ipc$dispatch("1957677148", new Object[]{this}) : DataProviderFactory.getDataProvider().getAppkey();
        }

        @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
        public String getAtlas() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "960610147") ? (String) ipChange.ipc$dispatch("960610147", new Object[]{this}) : DataProviderFactory.getDataProvider().getEnvType() == LoginEnvType.DEV.getSdkEnvType() ? "daily" : "";
        }

        @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
        public String getDeviceId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "672384431")) {
                return (String) ipChange.ipc$dispatch("672384431", new Object[]{this});
            }
            return null;
        }

        @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
        public String getTtid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "229134265") ? (String) ipChange.ipc$dispatch("229134265", new Object[]{this}) : DataProviderFactory.getDataProvider().getTTID();
        }

        @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
        public String getUmidToken() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2125163742") ? (String) ipChange.ipc$dispatch("2125163742", new Object[]{this}) : AppInfo.getInstance().getUmidToken();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        LoginParam loginParam;
        Map<String, String> map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317346634")) {
            ipChange.ipc$dispatch("-317346634", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i == 257) {
            if ((i2 != 258 && i2 != 0) || intent == null || (loginParam = (LoginParam) intent.getSerializableExtra(WebConstant.SSO_LOGIN_PARAM)) == null || (map = loginParam.externParams) == null || !"continueLogin".equals(map.get(LoginConstant.EXT_ACTION))) {
                return;
            }
            TBSsoLogin.e(this, loginParam);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598997173")) {
            ipChange.ipc$dispatch("-598997173", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.a = new BroadcastReceiver() { // from class: cn.damai.ResultActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-686529584")) {
                    ipChange2.ipc$dispatch("-686529584", new Object[]{this, context, intent});
                } else if (LoginResActions.LOGIN_SUCCESS_ACTION.equals(intent.getAction())) {
                    ResultActivity.this.finish();
                } else if (LoginResActions.LOGIN_FAIL_ACTION.equals(intent.getAction())) {
                    ResultActivity.this.finish();
                } else if (LoginResActions.LOGIN_NETWORK_ERROR.equals(intent.getAction())) {
                    ResultActivity.this.finish();
                } else if (LoginResActions.WEB_ACTIVITY_CANCEL.equals(intent.getAction())) {
                    ResultActivity.this.finish();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LoginResActions.LOGIN_SUCCESS_ACTION);
        intentFilter.addAction(LoginResActions.LOGIN_FAIL_ACTION);
        intentFilter.addAction(LoginResActions.LOGIN_NETWORK_ERROR);
        intentFilter.addAction(LoginResActions.WEB_ACTIVITY_CANCEL);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.a, intentFilter);
        SsoLogin.handleResultIntent(this, getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852781237")) {
            ipChange.ipc$dispatch("-1852781237", new Object[]{this});
            return;
        }
        super.onDestroy();
        if (this.a != null) {
            LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.a);
        }
    }

    @Override // com.taobao.android.sso.v2.launch.ILoginListener
    public void onFail(SSOException sSOException) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070000162")) {
            ipChange.ipc$dispatch("-1070000162", new Object[]{this, sSOException});
            return;
        }
        if (this.b) {
            ToastUtil.i("您已取消淘宝授权登录");
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233257960")) {
            ipChange.ipc$dispatch("-1233257960", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    @Override // com.taobao.android.sso.v2.launch.ILoginListener
    public void onSuccess(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "256869983")) {
            ipChange.ipc$dispatch("256869983", new Object[]{this, intent});
            return;
        }
        UserTrackAdapter.sendUT("TaobaoAuth_CallbackSucess");
        TBSsoLogin.c(this, intent.getExtras(), new a(this));
    }
}
