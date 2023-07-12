package com.taobao.android.riverlogger;

import android.content.Context;
import android.content.pm.PackageManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.inspector.Inspector;
import com.taobao.android.riverlogger.remote.RemoteApiPlugin;
import com.taobao.android.weex_framework.MUSEngine;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RVLLog {
    private static final ConcurrentLinkedQueue<RVLLogInterface> a;
    private static final Lock b;
    private static final AtomicBoolean c;
    private static final AtomicBoolean d;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    interface OpenCallback {
        void finish(boolean z);
    }

    static {
        ConcurrentLinkedQueue<RVLLogInterface> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        a = concurrentLinkedQueue;
        b = new ReentrantLock();
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        d dVar = new d();
        if (dVar.a) {
            concurrentLinkedQueue.add(dVar);
        } else {
            concurrentLinkedQueue.add(b.instance);
        }
    }

    public static a a(RVLLevel rVLLevel, @NonNull String str) {
        return new a(rVLLevel, str);
    }

    private static String b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String charSequence = packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
            String str = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            return charSequence + "/" + str;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void c() {
        if (b.tryLock()) {
            AtomicBoolean atomicBoolean = c;
            if (!atomicBoolean.get()) {
                try {
                    System.loadLibrary("riverlogger");
                    atomicBoolean.set(true);
                } catch (Throwable th) {
                    String replaceAll = th.getMessage().replaceAll("\"", "\\\"");
                    e(RVLLevel.Error, "RiverLogger", "{\"event\":\"loadSO\",\"errorCode\":\"101\", \"errorMsg\":\"" + replaceAll + "\"}");
                }
            }
            b.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(c cVar) {
        Iterator<RVLLogInterface> it = a.iterator();
        while (it.hasNext()) {
            it.next().log(cVar);
        }
    }

    public static void e(RVLLevel rVLLevel, @NonNull String str, @Nullable String str2) {
        c cVar = new c(rVLLevel, str);
        cVar.i = str2;
        Iterator<RVLLogInterface> it = a.iterator();
        while (it.hasNext()) {
            it.next().log(cVar);
        }
    }

    public static void f(RVLLogInterface rVLLogInterface) {
        if (rVLLogInterface != null) {
            a.add(rVLLogInterface);
        }
    }

    public static void g(@Nullable Context context) {
        if (d.compareAndSet(false, true)) {
            try {
                WVPluginManager.registerPlugin("RiverLogger", (Class<? extends WVApiPlugin>) RemoteApiPlugin.class);
            } catch (Exception | NoClassDefFoundError unused) {
            }
            try {
                MUSEngine.registerModule("riverLogger", com.taobao.android.riverlogger.remote.d.class);
            } catch (Exception | NoClassDefFoundError unused2) {
            }
        }
        if (!c.get()) {
            c();
        }
        if (context != null) {
            Inspector.e("AppInfo", b(context));
            com.taobao.android.riverlogger.remote.b.g(context.getSharedPreferences("RiverLogger.ServiceConfig", 0));
        }
    }
}
