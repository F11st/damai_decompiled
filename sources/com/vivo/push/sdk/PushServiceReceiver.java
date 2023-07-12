package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.p;
import com.vivo.push.util.r;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    private static HandlerThread a;
    private static Handler b;
    private static a c = new a();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements Runnable {
        private Context a;
        private String b;

        a() {
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.a = ContextDelegate.getContext(context);
            aVar.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo a = r.a(this.a);
            if (!(a != null ? a.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.a.getPackageName() + ": 无网络  by " + this.b);
                Context context = this.a;
                p.a(context, "触发静态广播:无网络(" + this.b + "," + this.a.getPackageName() + jn1.BRACKET_END_STR);
                return;
            }
            p.d("PushServiceReceiver", this.a.getPackageName() + ": 执行开始出发动作: " + this.b);
            Context context2 = this.a;
            p.a(context2, "触发静态广播(" + this.b + "," + this.a.getPackageName() + jn1.BRACKET_END_STR);
            e.a().a(this.a);
            if (ClientConfigManagerImpl.getInstance(this.a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.a).initialize();
            } catch (VivoPushException e) {
                e.printStackTrace();
                Context context3 = this.a;
                p.a(context3, " 初始化异常 error= " + e.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                a = handlerThread;
                handlerThread.start();
                b = new Handler(a.getLooper());
            }
            p.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + b);
            a.a(c, context2, action);
            b.removeCallbacks(c);
            b.postDelayed(c, 2000L);
        }
    }
}
