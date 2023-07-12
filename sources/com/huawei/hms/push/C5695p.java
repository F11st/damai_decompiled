package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.push.p */
/* loaded from: classes10.dex */
public class C5695p extends Thread {
    public Context a;
    public C5690k b;

    public C5695p(Context context, C5690k c5690k) {
        this.a = context;
        this.b = c5690k;
    }

    public static Intent a(Context context, C5690k c5690k) {
        if (c5690k == null) {
            return null;
        }
        Intent b = C5696q.b(context, c5690k.d());
        if (c5690k.n() != null) {
            try {
                Intent parseUri = Intent.parseUri(c5690k.n(), 0);
                parseUri.setSelector(null);
                StringBuilder sb = new StringBuilder();
                sb.append("Intent.parseUri(msg.intentUri, 0), action:");
                sb.append(parseUri.getAction());
                HMSLog.d("PushSelfShowLog", sb.toString());
                return C5696q.a(context, c5690k.d(), parseUri).booleanValue() ? parseUri : b;
            } catch (Exception e) {
                HMSLog.w("PushSelfShowLog", "intentUri error," + e.toString());
                return b;
            }
        }
        if (c5690k.a() != null) {
            Intent intent = new Intent(c5690k.a());
            if (C5696q.a(context, c5690k.d(), intent).booleanValue()) {
                b = intent;
            }
        }
        b.setPackage(c5690k.d());
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
            C5694o.a(this.a, this.b);
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString());
        }
    }

    public final boolean b(Context context, C5690k c5690k) {
        if ("cosa".equals(c5690k.i()) && a(context, c5690k) == null) {
            HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
            return true;
        }
        return false;
    }

    public final boolean a(Context context) {
        return C5696q.c(context, this.b.d());
    }
}
