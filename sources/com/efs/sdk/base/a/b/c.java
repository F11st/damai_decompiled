package com.efs.sdk.base.a.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.a.b.a;
import java.io.File;
import org.apache.commons.lang3.time.DateUtils;
import tb.q33;
import tb.r33;
import tb.w63;
import tb.x53;
import tb.z43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class c extends Handler implements Runnable {
    public boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private static final c a = new c((byte) 0);
    }

    private c() {
        super(r33.a.getLooper());
        this.a = true;
        sendEmptyMessageDelayed(2, DateUtils.MILLIS_PER_MINUTE);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c a() {
        return a.a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            x53.a(this);
            return;
        }
        w63.b("efs.cache", "disk listener not support command: " + message.what, null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.a.b.a unused;
        unused = a.b.a;
        File g = q33.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a);
        if (g.exists()) {
            for (File file : z43.k(g)) {
                if (com.efs.sdk.base.a.b.a.c(file.getName())) {
                    com.efs.sdk.base.a.b.a.e(file);
                }
            }
        }
        com.efs.sdk.base.a.c.a.c a2 = com.efs.sdk.base.a.c.a.c.a();
        String str = a2.e.f.containsKey("disk_bytes") ? a2.e.f.get("disk_bytes") : "4194304";
        long parseLong = Long.parseLong(TextUtils.isEmpty(str) ? "4194304" : str);
        long j = z43.j(q33.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a)) + z43.j(q33.e(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a));
        boolean z = j < parseLong;
        this.a = z;
        if (!z) {
            w63.b("efs.cache", "Cache Limited! curr " + j + "byte, max " + parseLong + " byte.", null);
        }
        sendEmptyMessageDelayed(2, 600000L);
    }
}
