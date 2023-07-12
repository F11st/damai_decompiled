package com.taobao.monitor.impl.data.windowevent;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.taobao.monitor.impl.data.windowevent.WindowCallbackProxy;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import java.lang.reflect.Proxy;
import tb.b0;
import tb.ca0;
import tb.ho2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements WindowCallbackProxy.DispatchEventListener {
    private WindowEventDispatcher a;
    private WindowCallbackProxy b;
    private final Activity c;

    public a(Activity activity) {
        this.a = null;
        this.c = activity;
        IDispatcher a = b0.a(b0.WINDOW_EVENT_DISPATCHER);
        if (a instanceof WindowEventDispatcher) {
            this.a = (WindowEventDispatcher) a;
        }
    }

    public a a() {
        Window window;
        Window.Callback callback;
        Activity activity = this.c;
        if (activity != null && (window = activity.getWindow()) != null && this.b == null && (callback = window.getCallback()) != null) {
            this.b = new WindowCallbackProxy(callback);
            try {
                window.setCallback((Window.Callback) Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{Window.Callback.class}, this.b));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.b.a(this);
        }
        return this;
    }

    public void b() {
        WindowCallbackProxy windowCallbackProxy = this.b;
        if (windowCallbackProxy != null) {
            windowCallbackProxy.b(this);
            this.b = null;
        }
    }

    @Override // com.taobao.monitor.impl.data.windowevent.WindowCallbackProxy.DispatchEventListener
    public void dispatchKeyEvent(KeyEvent keyEvent) {
        if (ca0.c(this.a)) {
            return;
        }
        this.a.f(this.c, keyEvent, ho2.a());
    }

    @Override // com.taobao.monitor.impl.data.windowevent.WindowCallbackProxy.DispatchEventListener
    public void dispatchTouchEvent(MotionEvent motionEvent) {
        if (ca0.c(this.a)) {
            return;
        }
        this.a.g(this.c, motionEvent, ho2.a());
    }
}
