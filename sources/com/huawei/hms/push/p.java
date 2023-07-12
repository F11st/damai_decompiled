package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class p extends Thread {
    public Context a;
    public k b;

    public p(Context context, k kVar) {
        this.a = context;
        this.b = kVar;
    }

    public static Intent a(Context context, k kVar) {
        if (kVar == null) {
            return null;
        }
        Intent b = q.b(context, kVar.d());
        if (kVar.n() != null) {
            try {
                Intent parseUri = Intent.parseUri(kVar.n(), 0);
                parseUri.setSelector(null);
                StringBuilder sb = new StringBuilder();
                sb.append("Intent.parseUri(msg.intentUri, 0), action:");
                sb.append(parseUri.getAction());
                HMSLog.d("PushSelfShowLog", sb.toString());
                return q.a(context, kVar.d(), parseUri).booleanValue() ? parseUri : b;
            } catch (Exception e) {
                HMSLog.w("PushSelfShowLog", "intentUri error," + e.toString());
                return b;
            }
        }
        if (kVar.a() != null) {
            Intent intent = new Intent(kVar.a());
            if (q.a(context, kVar.d(), intent).booleanValue()) {
                b = intent;
            }
        }
        b.setPackage(kVar.d());
        return b;
    }

    public final boolean b(Context context) {
        if ("cosa".equals(this.b.i())) {
            return a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.a) || b(this.a, this.b)) {
                return;
            }
            o.a(this.a, this.b);
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString());
        }
    }

    public final boolean b(Context context, k kVar) {
        if ("cosa".equals(kVar.i()) && a(context, kVar) == null) {
            HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
            return true;
        }
        return false;
    }

    public final boolean a(Context context) {
        return q.c(context, this.b.d());
    }
}
