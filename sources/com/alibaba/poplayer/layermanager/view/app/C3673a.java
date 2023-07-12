package com.alibaba.poplayer.layermanager.view.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.MotionEvent;
import com.alibaba.poplayer.layermanager.C3657b;
import com.alibaba.poplayer.layermanager.view.Canvas;
import com.alibaba.poplayer.layermanager.view.app.AppLayerNotify;
import tb.dt1;
import tb.fw2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.layermanager.view.app.a */
/* loaded from: classes8.dex */
public class C3673a implements AppLayerNotify.AppBackgroundNotify {
    public static final String TAG = "a";
    private MutableContextWrapper a;
    private AppLayer b;
    private Canvas c;
    private C3674b d;
    private AppLayerNotify e;
    private int f;

    public C3673a(C3657b c3657b, Application application) {
        this.f = 0;
        this.a = new MutableContextWrapper(application);
        this.f = fw2.d(application.getResources());
        Canvas canvas = new Canvas(this.a);
        this.c = canvas;
        c3657b.f(canvas);
        AppLayer appLayer = new AppLayer(this.a);
        this.b = appLayer;
        appLayer.d(this.c);
        this.d = new C3674b(this);
        this.e = new AppLayerNotify(application, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MotionEvent motionEvent) {
        Canvas canvas;
        try {
            if (!this.b.c() || (canvas = this.c) == null || canvas.all().isEmpty() || this.c.getVisibility() != 0 || this.c.getParent() == null) {
                return false;
            }
            return this.c.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            dt1.c("dispatchTouchEvent.error", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f;
    }

    public void c() {
        if (this.c.getVisibility() != 8) {
            dt1.b("%s.hideCanvas", TAG);
            this.c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Activity activity) {
        this.e.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Activity activity) {
        if (this.c.all().size() > 0 && !this.b.c()) {
            h(activity);
        }
        this.e.f();
    }

    public void f() {
        dt1.b("%s.removeLayer", TAG);
        this.e.g();
        this.d.d();
        this.b.a();
    }

    public void g() {
        if (this.c.getVisibility() != 0) {
            dt1.b("%s.showCanvas", TAG);
            this.c.setVisibility(0);
        }
    }

    public void h(Activity activity) {
        if (this.b.c()) {
            return;
        }
        this.d.b(activity);
        dt1.b("%s.showLayerWithActivity.", TAG);
        if (this.c.getParent() == null) {
            this.b.d(this.c);
        }
        g();
        this.b.e();
    }

    public void i(Context context) {
        this.a.setBaseContext(context);
    }

    @Override // com.alibaba.poplayer.layermanager.view.app.AppLayerNotify.AppBackgroundNotify
    public void onKeepInBackground() {
        dt1.b("%s.onKeepInBackground", TAG);
        this.b.a();
    }

    @Override // com.alibaba.poplayer.layermanager.view.app.AppLayerNotify.AppBackgroundNotify
    public void onQuicklyIntoBackground() {
        dt1.b("%s.onQuicklyIntoBackground", TAG);
        c();
    }
}
