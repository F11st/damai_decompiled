package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.ALBiometricsRuntime;
import com.alibaba.security.biometrics.component.C3772e;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.logic.C3775a;
import com.alibaba.security.biometrics.logic.a.C3776a;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.manager.ALBiometricsManager;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.biometrics.transition.TransitionMode;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3807d;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.tools.flexible.Flexible;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsActivity extends BaseBioNavigatorActivity {
    public static final String a = "ALBiometricsActivity";
    public static final String b = "KEY_LAST_PID";
    private ALBiometricsParams v;
    private ALBiometricsEventListener w;
    private ALBiometricsConfig x;

    public static void a(Context context, ALBiometricsManager aLBiometricsManager) {
        Intent intent = new Intent(context, ALBiometricsActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(ALBiometricsKeys.KEY_FACE_PARAMS, aLBiometricsManager.getParams());
        ALBiometricsConfig alBiometricsConfig = aLBiometricsManager.getAlBiometricsConfig();
        if (alBiometricsConfig != null) {
            BaseBioNavigatorActivity.u = aLBiometricsManager.getAlBiometricsConfig().getTransitionMode();
        } else {
            BaseBioNavigatorActivity.u = TransitionMode.NULL;
        }
        intent.putExtra(ALBiometricsKeys.KEY_BIO_CONFIG, alBiometricsConfig);
        intent.putExtra(ALBiometricsKeys.KEY_BIO_PARAMS_BUNDLE, aLBiometricsManager.getParamsBundle());
        ALBiometricsRuntime.mALBiometricsEventListener = new WeakReference<>(aLBiometricsManager.getEventListener());
        context.startActivity(intent);
        if (context instanceof Activity) {
            BaseBioNavigatorActivity.a((Activity) context, BaseBioNavigatorActivity.u);
        }
    }

    private void b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", str);
        hashMap.put("pid", String.valueOf(Process.myPid()));
        a(TrackLog.createBioActivityEnterLog(C3811h.a((Object) hashMap), str2));
    }

    private void c(String str, String str2) {
        a(TrackLog.createStartEndLog(str, str2, System.currentTimeMillis(), "-1", "-10414", "-10414"));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3800a.a(a, configuration.orientation == 1 ? "竖屏" : "横屏");
        C3800a.a(a, "width:" + C3807d.a(this, configuration.screenWidthDp) + "\nheight:" + C3807d.a(this, configuration.screenHeightDp));
        if (GetCacheDataManager.getInstance().getUseHwMagicWindow() && configuration.orientation == 1 && C3807d.d(this)) {
            ((C3775a) C3772e.a(C3775a.class)).a(GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW, "EnvironmentComponent", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity, com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3800a.a(a, "bio activity enter:" + b());
        WeakReference<ALBiometricsEventListener> weakReference = ALBiometricsRuntime.mALBiometricsEventListener;
        this.w = weakReference != null ? weakReference.get() : null;
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(ALBiometricsKeys.KEY_FACE_PARAMS)) {
            this.v = (ALBiometricsParams) intent.getSerializableExtra(ALBiometricsKeys.KEY_FACE_PARAMS);
        }
        if (this.v == null) {
            this.v = new ALBiometricsParams();
        }
        String b2 = b();
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", b2);
        hashMap.put("pid", String.valueOf(Process.myPid()));
        a(TrackLog.createBioActivityEnterLog(C3811h.a((Object) hashMap), "bio activity enter"));
        ALBiometricsEventListener aLBiometricsEventListener = this.w;
        if (aLBiometricsEventListener == null) {
            a(ALBiometricsRuntime.mALBiometricsEventListener != null ? "ALBiometricsRuntime.mALBiometricsEventListener.get() is null " : "ALBiometricsRuntime.mALBiometricsEventListener is null", a(bundle) ? "The process to restart" : "");
            a(TrackLog.createStartEndLog(this.v.mVerifyType, a(bundle) ? "true" : "false", System.currentTimeMillis(), "-1", "-10414", "-10414"));
            finish();
            return;
        }
        aLBiometricsEventListener.onBiometricsStart();
        this.x = (ALBiometricsConfig) intent.getSerializableExtra(ALBiometricsKeys.KEY_BIO_CONFIG);
        if (ALBiometricsJni.isLoaded()) {
            ALBiometricsJni.initialToken(this.v.secToken);
            ALBiometricsJni.bhL(1, "");
        } else {
            a("ALBiometricsJni load fail", (String) null);
        }
        C3772e.a(this, this.v, this.x, this.w);
        ALBiometricsActivityParentView aLBiometricsActivityParentView = new ALBiometricsActivityParentView(this, this.v);
        Flexible.setContentView(this, aLBiometricsActivityParentView);
        Window window = getWindow();
        if (window != null && Build.VERSION.SDK_INT > 28) {
            try {
                View decorView = window.getDecorView();
                decorView.getClass().getMethod("setForceDarkAllowed", Boolean.TYPE).invoke(decorView, Boolean.FALSE);
            } catch (Throwable unused) {
                C3800a.b();
            }
        }
        ((C3775a) C3772e.a(C3775a.class)).a(aLBiometricsActivityParentView);
        C3829a.C3830a.a.a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity, com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C3800a.a(a, "bio activity exit");
        a(TrackLog.createBioActivityExitLog("bio activity exit"));
        C3772e.c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (C3772e.a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3772e.b();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } catch (Throwable unused) {
        }
        C3776a c3776a = ((C3775a) C3772e.a(C3775a.class)).d;
        if (c3776a == null || i != 1010) {
            return;
        }
        if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
            C3776a.f();
        } else {
            c3776a.b(false);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C3772e.a();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(b, Process.myPid());
    }

    private static boolean a(Bundle bundle) {
        return (bundle == null || bundle.getInt(b, 0) == Process.myPid()) ? false : true;
    }

    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity
    protected final boolean a() {
        ALBiometricsParams aLBiometricsParams = this.v;
        return aLBiometricsParams != null && aLBiometricsParams.stepResult;
    }

    private void a(String str, String str2) {
        a(TrackLog.createSdkExceptionLog(str, str2, a));
    }

    private void a(String str) {
        a(TrackLog.createBioActivityExitLog(str));
    }

    private void a(TrackLog trackLog) {
        ALBiometricsParams aLBiometricsParams = this.v;
        if (aLBiometricsParams != null) {
            trackLog.setVerifyToken(aLBiometricsParams.mVerifyToken);
        }
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        C3829a.C3830a.a.a(trackLog);
        C3829a.C3830a.a.a(false);
    }
}
