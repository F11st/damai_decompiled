package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.c.b.C3750a;
import com.alibaba.security.biometrics.c.c.C3754a;
import com.alibaba.security.biometrics.c.c.C3756c;
import com.alibaba.security.biometrics.transition.TransitionMode;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3823p;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseBioNavigatorActivity extends BaseAlBioActivity {
    private static final String a = "BaseActivity";
    public static final int g = 10002;
    public static final int h = 10004;
    public static final int i = 10005;
    public static final int j = 10009;
    public static final int k = 10010;
    public static final int l = 10012;
    public static final int m = 10013;
    public static final int n = 20002;
    public static final int o = 20003;
    public static final int p = 20004;
    public static final int q = 20005;
    public static final int r = 20006;
    public static final int s = 20007;
    public static final int t = 20008;
    protected static TransitionMode u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TransitionMode.values().length];
            a = iArr;
            try {
                iArr[TransitionMode.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TransitionMode.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TransitionMode.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TransitionMode.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TransitionMode.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a(Activity activity, TransitionMode transitionMode) {
        if (transitionMode == null) {
            activity.overridePendingTransition(0, 0);
            return;
        }
        int i2 = AnonymousClass1.a[transitionMode.ordinal()];
        if (i2 == 1) {
            activity.overridePendingTransition(0, 0);
        } else if (i2 == 2) {
            activity.overridePendingTransition(R.anim.rp_anim_face_right_in, R.anim.rp_anim_face_right_out);
        } else if (i2 == 3) {
            activity.overridePendingTransition(R.anim.rp_anim_face_left_in, R.anim.rp_anim_face_left_out);
        } else if (i2 == 4) {
            activity.overridePendingTransition(R.anim.rp_anim_face_bottom_in, R.anim.rp_anim_face_bottom_out);
        } else if (i2 != 5) {
        } else {
            activity.overridePendingTransition(R.anim.rp_anim_face_top_in, R.anim.rp_anim_face_top_out);
        }
    }

    private void c() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            } else if (C3823p.a() && C3754a.a(this)) {
                C3754a.a(getWindow());
            } else if (C3823p.c() && C3756c.a(this)) {
                C3756c.a(getWindow());
            }
        } catch (Exception unused) {
            C3800a.b();
        }
    }

    private void d() {
        getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            a(this, u);
        } catch (Throwable unused) {
            C3800a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            } else if (C3823p.a() && C3754a.a(this)) {
                C3754a.a(getWindow());
            } else if (C3823p.c() && C3756c.a(this)) {
                C3756c.a(getWindow());
            }
        } catch (Exception unused) {
            C3800a.b();
        }
        setVolumeControlStream(3);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        getWindow().setBackgroundDrawableResource(R.C3735drawable.rpsdk_face_win_bg);
        getWindow().addFlags(128);
        getWindow().setFlags(1024, 1024);
        C3750a.b();
        C3750a.c();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C3750a.b();
        C3750a.c();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
}
