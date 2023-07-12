package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.C7481e;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7525r;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    private static HandlerThread a;
    private static Handler b;
    private static RunnableC7500a c = new RunnableC7500a();

    /* compiled from: Taobao */
    /* renamed from: com.vivo.push.sdk.PushServiceReceiver$a */
    /* loaded from: classes11.dex */
    static class RunnableC7500a implements Runnable {
        private Context a;
        private String b;

        RunnableC7500a() {
        }

        static /* synthetic */ void a(RunnableC7500a runnableC7500a, Context context, String str) {
            runnableC7500a.a = ContextDelegate.getContext(context);
            runnableC7500a.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo a = C7525r.a(this.a);
            if (!(a != null ? a.isConnectedOrConnecting() : false)) {
                C7523p.d("PushServiceReceiver", this.a.getPackageName() + ": 无网络  by " + this.b);
                Context context = this.a;
                C7523p.a(context, "触发静态广播:无网络(" + this.b + "," + this.a.getPackageName() + jn1.BRACKET_END_STR);
                return;
            }
            C7523p.d("PushServiceReceiver", this.a.getPackageName() + ": 执行开始出发动作: " + this.b);
            Context context2 = this.a;
            C7523p.a(context2, "触发静态广播(" + this.b + "," + this.a.getPackageName() + jn1.BRACKET_END_STR);
            C7481e.a().a(this.a);
            if (ClientConfigManagerImpl.getInstance(this.a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.a).initialize();
            } catch (VivoPushException e) {
                e.printStackTrace();
                Context context3 = this.a;
                C7523p.a(context3, " 初始化异常 error= " + e.getMessage());
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
            C7523p.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + b);
            RunnableC7500a.a(c, context2, action);
            b.removeCallbacks(c);
            b.postDelayed(c, 2000L);
        }
    }
}
