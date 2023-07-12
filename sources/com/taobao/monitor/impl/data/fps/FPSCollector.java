package com.taobao.monitor.impl.data.fps;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import java.lang.ref.WeakReference;
import tb.C8934b0;
import tb.ca0;
import tb.ho2;
import tb.lu0;

/* compiled from: Taobao */
@TargetApi(16)
/* loaded from: classes11.dex */
public class FPSCollector implements ViewTreeObserver.OnDrawListener, WindowEventDispatcher.OnEventListener {
    private long a = ho2.a();
    public int b = 0;
    public int c = 0;
    private long d = 0;
    private int e = 0;
    private int f = 0;
    private long g;
    private FPSDispatcher h;
    private WindowEventDispatcher i;
    private final WeakReference<Activity> j;

    public FPSCollector(Activity activity) {
        this.j = new WeakReference<>(activity);
        b();
        a(activity);
    }

    private void a(Activity activity) {
        final View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.monitor.impl.data.fps.FPSCollector.1
            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnDrawListener(FPSCollector.this);
                }
            }
        });
    }

    private void b() {
        IDispatcher b = ca0.b(C8934b0.ACTIVITY_FPS_DISPATCHER);
        if (b instanceof FPSDispatcher) {
            this.h = (FPSDispatcher) b;
        }
        IDispatcher b2 = ca0.b(C8934b0.WINDOW_EVENT_DISPATCHER);
        if (b2 instanceof WindowEventDispatcher) {
            WindowEventDispatcher windowEventDispatcher = (WindowEventDispatcher) b2;
            this.i = windowEventDispatcher;
            windowEventDispatcher.addListener(this);
        }
    }

    public void c() {
        Window window;
        View decorView;
        if (!ca0.c(this.i)) {
            this.i.removeListener(this);
        }
        Activity activity = this.j.get();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.getViewTreeObserver().removeOnDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        long a = ho2.a();
        long j = a - this.a;
        if (a - this.g > 2000) {
            return;
        }
        if (j > 16) {
            this.c++;
            if (j > 700) {
                this.b++;
            }
        }
        if (j < 200) {
            long j2 = this.d + j;
            this.d = j2;
            int i = this.f + 1;
            this.f = i;
            if (j > 32) {
                this.e++;
            }
            if (j2 > 1000) {
                if (i > 60) {
                    this.f = 60;
                }
                if (!ca0.c(this.h)) {
                    this.h.f(this.f, this.e, this.b, this.c, null);
                }
                this.d = 0L;
                this.f = 0;
                this.e = 0;
                this.b = 0;
                this.c = 0;
            }
        }
        this.a = a;
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
        lu0.o = ho2.a();
        if (motionEvent.getAction() == 2) {
            this.g = ho2.a();
        }
    }
}
