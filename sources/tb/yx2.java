package tb;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yx2 extends ContextWrapper {
    private WeakReference<Context> a;

    public yx2(Context context) {
        super(context.getApplicationContext());
        this.a = new WeakReference<>(context);
    }

    public Context a() {
        WeakReference<Context> weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            return context.getResources();
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            return context.getTheme();
        }
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            Context a = a();
            if (a != null) {
                return a.registerReceiver(broadcastReceiver, intentFilter);
            }
            return super.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivities(intentArr);
        } else {
            super.startActivities(intentArr);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            Context a = a();
            if (a != null) {
                a.unregisterReceiver(broadcastReceiver);
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused2) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        try {
            Context a = a();
            if (a != null) {
                return a.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            }
            return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivities(intentArr, bundle);
        } else {
            super.startActivities(intentArr, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        WeakReference<Context> weakReference = this.a;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivity(intent, bundle);
        } else {
            super.startActivity(intent, bundle);
        }
    }
}
