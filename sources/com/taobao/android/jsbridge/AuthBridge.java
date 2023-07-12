package com.taobao.android.jsbridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.taobao.android.sso.R;
import com.taobao.android.sso.v2.launch.SsoLogin;
import com.taobao.android.sso.v2.result.ResultActivity;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AuthBridge extends WVApiPlugin {
    private static final String APDIDTOKEN_IS_NULL = "1005";
    private static final String CONTEXT_IS_NOT_ACTIVITY = "1004";
    private static final String GET_ALIPAY_TOKEN_FAIL = "1003";
    private BroadcastReceiver mAlipaySsoTokenReceiver;
    private BroadcastReceiver mLoginReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.jsbridge.AuthBridge$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass3 implements DataCallback<String> {
        final /* synthetic */ Context a;
        final /* synthetic */ WVCallBackContext b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.jsbridge.AuthBridge$3$1  reason: invalid class name */
        /* loaded from: classes12.dex */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ String val$apdidToken;

            AnonymousClass1(String str) {
                this.val$apdidToken = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                final boolean z;
                TLogAdapter.e("jsbridge", "start launch alipay");
                try {
                    SsoLogin.getAlipaySsoToken((Activity) AnonymousClass3.this.a, DataProviderFactory.getDataProvider().getAlipaySsoDesKey(), this.val$apdidToken, DataProviderFactory.getDataProvider().getContext().getPackageName(), ResultActivity.class.getName());
                    z = true;
                } catch (Exception e) {
                    TLogAdapter.e("jsbridge", "launch alipay fail" + e.getMessage());
                    z = false;
                }
                MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.android.jsbridge.AuthBridge.3.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TLogAdapter.e("jsbridge", "start launch alipay result" + z);
                        boolean z2 = z;
                        if (!z2) {
                            if (z2) {
                                return;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            AuthBridge.this.fail(anonymousClass3.b, "1003");
                            return;
                        }
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("alipay_sso_token");
                        AuthBridge.this.mAlipaySsoTokenReceiver = new BroadcastReceiver() { // from class: com.taobao.android.jsbridge.AuthBridge.3.1.1.1
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) {
                                if (intent != null && AnonymousClass3.this.b != null) {
                                    if (intent.getBooleanExtra("result", false)) {
                                        WVResult wVResult = new WVResult();
                                        wVResult.addData("ssoToken", intent.getStringExtra("ssoToken"));
                                        wVResult.addData("desKey", intent.getStringExtra("desKey"));
                                        wVResult.addData("uuid", intent.getStringExtra("uuid"));
                                        AnonymousClass3.this.b.success(wVResult);
                                    } else {
                                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                        AuthBridge.this.fail(anonymousClass32.b, intent.getStringExtra("errorCode"));
                                    }
                                }
                                LocalBroadcastManager.getInstance(AnonymousClass3.this.a.getApplicationContext()).unregisterReceiver(AuthBridge.this.mAlipaySsoTokenReceiver);
                            }
                        };
                        LocalBroadcastManager.getInstance(AnonymousClass3.this.a.getApplicationContext()).registerReceiver(AuthBridge.this.mAlipaySsoTokenReceiver, intentFilter);
                    }
                });
            }
        }

        AnonymousClass3(Context context, WVCallBackContext wVCallBackContext) {
            this.a = context;
            this.b = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.callback.DataCallback
        /* renamed from: a */
        public void result(String str) {
            if (TextUtils.isEmpty(str)) {
                AuthBridge.this.fail(this.b, "1005");
            } else {
                BackgroundExecutor.execute(new AnonymousClass1(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements DataCallback<String> {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // com.ali.user.mobile.callback.DataCallback
        /* renamed from: a */
        public void result(String str) {
            if (TextUtils.isEmpty(str)) {
                AuthBridge.toast();
                return;
            }
            try {
                SsoLogin.launchAlipay(this.a, DataProviderFactory.getDataProvider().getAlipaySsoDesKey(), str, DataProviderFactory.getDataProvider().getContext().getPackageName(), DataProviderFactory.getDataProvider().getResultActivityPath());
            } catch (Throwable th) {
                th.printStackTrace();
                AuthBridge.toast();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            try {
                iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LoginAction.NOTIFY_ALIPAY_SSO_FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LoginAction.NOTIFY_ALIPAY_SSO_CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private synchronized void alipay(WVCallBackContext wVCallBackContext) {
        if (this.mContext instanceof Activity) {
            registerBroadcast(wVCallBackContext);
            alipayAuth((Activity) this.mContext);
        } else {
            wVCallBackContext.error();
        }
    }

    public static void alipayAuth(Activity activity) {
        AlipayInfo.getInstance().getApdidToken(new a(activity));
    }

    private synchronized void checkIfExist(WVCallBackContext wVCallBackContext) {
        if (SsoLogin.isSupportAliaySso()) {
            wVCallBackContext.success();
        } else {
            wVCallBackContext.error();
        }
    }

    private synchronized void checkIfTaobaoExist(WVCallBackContext wVCallBackContext) {
        try {
            if (SsoLogin.isSupportTBAuthBind(this.mContext)) {
                wVCallBackContext.success();
            } else {
                wVCallBackContext.error();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            wVCallBackContext.error();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWhenReceiveSuccess(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            wVCallBackContext.success();
        }
        unregisterLoginReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWhenReceivedCancel(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            wVCallBackContext.error();
        }
        unregisterLoginReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fail(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("code", str);
            wVCallBackContext.error(wVResult);
        }
    }

    private synchronized void getAlipaySsoToken(String str, WVCallBackContext wVCallBackContext) {
        Context context = wVCallBackContext.getWebview().getContext();
        if (context instanceof Activity) {
            AlipayInfo.getInstance().getApdidToken(new AnonymousClass3(context, wVCallBackContext));
        } else {
            fail(wVCallBackContext, "1004");
        }
    }

    private void registerBroadcast(final WVCallBackContext wVCallBackContext) {
        this.mLoginReceiver = new BroadcastReceiver() { // from class: com.taobao.android.jsbridge.AuthBridge.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null) {
                    return;
                }
                String action = intent.getAction();
                LoginAction loginAction = null;
                try {
                    loginAction = LoginAction.valueOf(action);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                if (loginAction == null) {
                    return;
                }
                int i = b.a[loginAction.ordinal()];
                if (i == 1) {
                    AuthBridge.this.doWhenReceiveSuccess(wVCallBackContext);
                } else if (i == 2) {
                    AuthBridge.this.doWhenReceivedCancel(wVCallBackContext);
                } else if (i == 3 || i == 4 || i == 5) {
                    AuthBridge.this.doWhenReceivedCancel(wVCallBackContext);
                }
            }
        };
        LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
    }

    private synchronized void taobao(WVCallBackContext wVCallBackContext) {
        if (this.mContext instanceof Activity) {
            registerBroadcast(wVCallBackContext);
            SsoLogin.launchTao((Activity) this.mContext, SsoLogin.getSsoRemoteParam(), DataProviderFactory.getDataProvider().getResultActivityPath());
        } else {
            wVCallBackContext.error();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void toast() {
        try {
            Toast.makeText(DataProviderFactory.getApplicationContext(), DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error), 0).show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void unregisterLoginReceiver() {
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("bridgeAlipaySSOLogin".equals(str)) {
            UserTrackAdapter.sendUT("bridgeAlipaySSOLogin");
            alipay(wVCallBackContext);
            return true;
        } else if ("bridgeAlipaySupported".equals(str)) {
            checkIfExist(wVCallBackContext);
            UserTrackAdapter.sendUT("bridgeAlipaySupported");
            return true;
        } else if ("bridgeTaobaoSSOLogin".equals(str)) {
            taobao(wVCallBackContext);
            UserTrackAdapter.sendUT("bridgeTaobaoSSOLogin");
            return true;
        } else if ("bridgeTaobaoSupported".equals(str)) {
            checkIfTaobaoExist(wVCallBackContext);
            UserTrackAdapter.sendUT("bridgeTaobaoSupported");
            return true;
        } else if ("getAlipaySsoToken".equals(str)) {
            getAlipaySsoToken(str2, wVCallBackContext);
            return true;
        } else {
            return false;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        super.onDestroy();
        unregisterLoginReceiver();
    }
}
