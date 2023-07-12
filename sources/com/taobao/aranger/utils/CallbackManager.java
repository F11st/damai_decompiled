package com.taobao.aranger.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Keep;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.intf.IProxyRecover;
import com.taobao.aranger.intf.ProcessStateListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.z01;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CallbackManager {
    private static final String f = "CallbackManager";
    private static volatile CallbackManager g;
    private final ConcurrentHashMap<String, C6697b> a;
    private final CopyOnWriteArrayList<ProcessStateListener> b;
    private final ProcessStateReceiver c = new ProcessStateReceiver();
    private final IntentFilter d;
    IProxyRecover e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes11.dex */
    public class ProcessStateReceiver extends BroadcastReceiver {
        private ProcessStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @Keep
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(Constants.PARAM_PROCESS_NAME);
            if (Constants.ACTION_DISCONNECT.equals(intent.getAction())) {
                Iterator it = CallbackManager.this.b.iterator();
                while (it.hasNext()) {
                    try {
                        ((ProcessStateListener) it.next()).onProcessStop(stringExtra);
                    } catch (Throwable th) {
                        z01.c(CallbackManager.f, "[onReceive][onProcessStop]", th, new Object[0]);
                    }
                }
                return;
            }
            Iterator it2 = CallbackManager.this.b.iterator();
            while (it2.hasNext()) {
                try {
                    ((ProcessStateListener) it2.next()).onProcessStart(stringExtra);
                } catch (Throwable th2) {
                    z01.c(CallbackManager.f, "[onReceive][onProcessStart]", th2, new Object[0]);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.aranger.utils.CallbackManager$b */
    /* loaded from: classes11.dex */
    private static class C6697b {
        private final Object a;

        C6697b(boolean z, Object obj) {
            if (z) {
                this.a = new WeakReference(obj);
            } else {
                this.a = obj;
            }
        }

        Object a() {
            Object obj = this.a;
            return obj instanceof WeakReference ? ((WeakReference) obj).get() : obj;
        }
    }

    private CallbackManager() {
        IntentFilter intentFilter = new IntentFilter();
        this.d = intentFilter;
        this.a = new ConcurrentHashMap<>();
        this.b = new CopyOnWriteArrayList<>();
        intentFilter.addAction(Constants.ACTION_CONNECT);
        intentFilter.addAction(Constants.ACTION_DISCONNECT);
    }

    public static CallbackManager e() {
        if (g == null) {
            synchronized (CallbackManager.class) {
                if (g == null) {
                    g = new CallbackManager();
                }
            }
        }
        return g;
    }

    public void c(String str, Object obj, boolean z) {
        this.a.putIfAbsent(str, new C6697b(z, obj));
    }

    public Object d(String str) {
        C6697b c6697b = this.a.get(str);
        if (c6697b == null) {
            return null;
        }
        Object a = c6697b.a();
        if (a == null) {
            this.a.remove(str);
        }
        return a;
    }

    public void f(ProcessStateListener processStateListener) {
        synchronized (this.b) {
            if (this.b.isEmpty()) {
                ARanger.getContext().registerReceiver(this.c, this.d);
            }
            this.b.add(processStateListener);
        }
    }

    public void g(String str) {
        this.a.remove(str);
    }

    public void h() {
        this.e = null;
    }

    public void i(IProxyRecover iProxyRecover) {
        this.e = iProxyRecover;
    }

    public void j(ProcessStateListener processStateListener) {
        synchronized (this.b) {
            this.b.remove(processStateListener);
            if (this.b.isEmpty()) {
                ARanger.getContext().unregisterReceiver(this.c);
            }
        }
    }
}
