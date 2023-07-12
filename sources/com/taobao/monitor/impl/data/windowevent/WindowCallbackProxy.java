package com.taobao.monitor.impl.data.windowevent;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WindowCallbackProxy implements InvocationHandler {
    private final Window.Callback a;
    final List<DispatchEventListener> b = new ArrayList(2);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface DispatchEventListener {
        void dispatchKeyEvent(KeyEvent keyEvent);

        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowCallbackProxy(Window.Callback callback) {
        this.a = callback;
    }

    public void a(DispatchEventListener dispatchEventListener) {
        this.b.add(dispatchEventListener);
    }

    public void b(DispatchEventListener dispatchEventListener) {
        this.b.remove(dispatchEventListener);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        if ("dispatchTouchEvent".equals(name)) {
            if (objArr != null && objArr.length >= 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof MotionEvent) {
                    for (DispatchEventListener dispatchEventListener : this.b) {
                        dispatchEventListener.dispatchTouchEvent((MotionEvent) obj2);
                    }
                }
            }
        } else if ("dispatchKeyEvent".equals(name) && objArr != null && objArr.length >= 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof KeyEvent) {
                for (DispatchEventListener dispatchEventListener2 : this.b) {
                    dispatchEventListener2.dispatchKeyEvent((KeyEvent) obj3);
                }
            }
        }
        try {
            return method.invoke(this.a, objArr);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}
