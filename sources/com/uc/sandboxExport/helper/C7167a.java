package com.uc.sandboxExport.helper;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.helper.a */
/* loaded from: classes11.dex */
public final class C7167a {
    private static Method a;
    private static Method b;

    static {
        try {
            C7171d a2 = C7171d.a();
            r0 = C7173f.b() ? Context.class.getDeclaredMethod("bindIsolatedService", Intent.class, Integer.TYPE, String.class, Executor.class, ServiceConnection.class) : null;
            a2.close();
        } catch (Exception unused) {
        } finally {
            a = r0;
        }
    }

    public static boolean a(Context context, Intent intent, ServiceConnection serviceConnection, Handler handler) {
        if (Build.VERSION.SDK_INT < 24) {
            C7169c.a(5, "BindService", "doBindService - bindService A", null);
            return context.bindService(intent, serviceConnection, 65);
        }
        try {
            C7169c.a(5, "BindService", "doBindService - bindServiceByReflection", null);
            if (b == null) {
                b = Context.class.getDeclaredMethod("bindServiceAsUser", Intent.class, ServiceConnection.class, Integer.TYPE, Handler.class, UserHandle.class);
            }
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
            return ((Boolean) b.invoke(context2, intent, serviceConnection, 65, handler, Process.myUserHandle())).booleanValue();
        } catch (Throwable unused) {
            C7169c.a(5, "BindService", "doBindService - bindService B", null);
            return context.bindService(intent, serviceConnection, 65);
        }
    }
}
