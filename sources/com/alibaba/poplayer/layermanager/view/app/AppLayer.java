package com.alibaba.poplayer.layermanager.view.app;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;
import com.alibaba.poplayer.layermanager.view.Canvas;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tb.dt1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppLayer {
    public static final int LENGTH_ALWAYS = 0;
    private static final String l = "AppLayer";
    private Toast a;
    private Context b;
    private int c;
    private int d;
    private Object f;
    private Method g;
    private Method h;
    private WindowManager.LayoutParams i;
    private boolean e = false;
    private Handler j = new Handler();
    private Runnable k = new Runnable() { // from class: com.alibaba.poplayer.layermanager.view.app.AppLayer.1
        @Override // java.lang.Runnable
        public void run() {
            AppLayer.this.a();
        }
    };

    public AppLayer(Context context) {
        this.c = 0;
        this.d = -1;
        this.b = context;
        if (this.a == null) {
            this.a = new Toast(this.b);
        }
        this.c = 0;
        this.d = 16973824;
    }

    private void b() {
        try {
            Field declaredField = this.a.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.a);
            this.f = obj;
            this.g = obj.getClass().getMethod("show", new Class[0]);
            this.h = this.f.getClass().getMethod("hide", new Class[0]);
            Field declaredField2 = this.f.getClass().getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) declaredField2.get(this.f);
            this.i = layoutParams;
            layoutParams.flags = 56;
            int i = this.d;
            if (i != -1) {
                layoutParams.windowAnimations = i;
            }
            Field declaredField3 = this.f.getClass().getDeclaredField("mNextView");
            declaredField3.setAccessible(true);
            declaredField3.set(this.f, this.a.getView());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.a.setGravity(119, 0, 0);
    }

    public void a() {
        if (this.e) {
            dt1.b("%s.hide", l);
            try {
                this.h.invoke(this.f, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.e = false;
        }
    }

    public boolean c() {
        return this.e;
    }

    public void d(Canvas canvas) {
        this.a.setView(canvas);
    }

    public void e() {
        if (this.e) {
            return;
        }
        if (this.a.getView() == null) {
            dt1.b("%s.show error.", l);
            return;
        }
        dt1.b("%s.show", l);
        b();
        try {
            this.g.invoke(this.f, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.e = true;
        int i = this.c;
        if (i > 0) {
            this.j.postDelayed(this.k, i * 1000);
        }
    }
}
