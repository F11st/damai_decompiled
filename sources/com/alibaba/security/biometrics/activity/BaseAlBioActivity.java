package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.alibaba.security.biometrics.component.e;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.common.d.i;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseAlBioActivity extends Activity {
    public static final String c = "BaseBroadcastsActivity";
    protected RestartBiometricsBroadcast d;
    protected FinishBiometricsBroadcast e;
    protected a f;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    protected class FinishBiometricsBroadcast extends BroadcastReceiver {
        protected FinishBiometricsBroadcast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BaseAlBioActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    protected class RestartBiometricsBroadcast extends BroadcastReceiver {
        protected RestartBiometricsBroadcast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final int i = 0;
            if (intent != null && TextUtils.equals(intent.getAction(), ALBiometricsKeys.KEY_ACTION_RESTART_BIOMETRICS)) {
                Bundle bundleExtra = intent.getBundleExtra("data");
                final String str = null;
                if (bundleExtra != null) {
                    i = bundleExtra.getInt(ALBiometricsKeys.KEY_ERROR_DETECT_K, GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
                    str = bundleExtra.getString(ALBiometricsKeys.KEY_ERROR_DETECT_MSG_K, null);
                }
                if (BaseAlBioActivity.this.a()) {
                    BaseAlBioActivity.this.f.post(new Runnable() { // from class: com.alibaba.security.biometrics.activity.BaseAlBioActivity.RestartBiometricsBroadcast.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((com.alibaba.security.biometrics.logic.a) e.a(com.alibaba.security.biometrics.logic.a.class)).a(i, "RestartBiometricsBroadcast", str);
                            com.alibaba.security.biometrics.logic.a.a aVar = ((com.alibaba.security.biometrics.logic.a) e.a(com.alibaba.security.biometrics.logic.a.class)).d;
                            if (aVar != null) {
                                aVar.c = 0;
                            }
                        }
                    });
                } else {
                    BaseAlBioActivity.this.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a extends Handler {
        private final BaseAlBioActivity a;

        public a(BaseAlBioActivity baseAlBioActivity) {
            super(Looper.getMainLooper());
            this.a = baseAlBioActivity;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
        }
    }

    private void c() {
        if (this.d == null) {
            this.d = new RestartBiometricsBroadcast();
            i.a(this).a(this.d, new IntentFilter(ALBiometricsKeys.KEY_ACTION_RESTART_BIOMETRICS));
        }
        if (this.e == null) {
            this.e = new FinishBiometricsBroadcast();
            i.a(this).a(this.e, new IntentFilter(ALBiometricsKeys.KEY_ACTION_FINISH_BIOMETRICS));
        }
    }

    private void d() {
        if (this.d != null) {
            i.a(this).a(this.d);
            this.d = null;
        }
        if (this.e != null) {
            i.a(this).a(this.e);
            this.e = null;
        }
    }

    public final void a(Runnable runnable) {
        this.f.removeCallbacks(runnable);
    }

    protected boolean a() {
        return false;
    }

    public final void b(Runnable runnable) {
        this.f.postDelayed(runnable, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new a(this);
        if (this.d == null) {
            this.d = new RestartBiometricsBroadcast();
            i.a(this).a(this.d, new IntentFilter(ALBiometricsKeys.KEY_ACTION_RESTART_BIOMETRICS));
        }
        if (this.e == null) {
            this.e = new FinishBiometricsBroadcast();
            i.a(this).a(this.e, new IntentFilter(ALBiometricsKeys.KEY_ACTION_FINISH_BIOMETRICS));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            i.a(this).a(this.d);
            this.d = null;
        }
        if (this.e != null) {
            i.a(this).a(this.e);
            this.e = null;
        }
    }

    private static void a(Window window) {
        if (window != null && Build.VERSION.SDK_INT > 28) {
            try {
                View decorView = window.getDecorView();
                decorView.getClass().getMethod("setForceDarkAllowed", Boolean.TYPE).invoke(decorView, Boolean.FALSE);
            } catch (Throwable unused) {
                com.alibaba.security.common.c.a.b();
            }
        }
    }

    public final String b() {
        return getResources().getConfiguration().orientation == 1 ? "竖屏" : "横屏";
    }
}
