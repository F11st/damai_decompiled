package com.efs.sdk.base.a.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.a.b.C4770a;
import com.efs.sdk.base.a.c.a.C4783c;
import com.efs.sdk.base.a.d.C4786a;
import java.io.File;
import org.apache.commons.lang3.time.DateUtils;
import tb.q33;
import tb.r33;
import tb.w63;
import tb.x53;
import tb.z43;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.b.c */
/* loaded from: classes10.dex */
public final class HandlerC4774c extends Handler implements Runnable {
    public boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.efs.sdk.base.a.b.c$a */
    /* loaded from: classes10.dex */
    public static class C4775a {
        private static final HandlerC4774c a = new HandlerC4774c((byte) 0);
    }

    private HandlerC4774c() {
        super(r33.a.getLooper());
        this.a = true;
        sendEmptyMessageDelayed(2, DateUtils.MILLIS_PER_MINUTE);
    }

    /* synthetic */ HandlerC4774c(byte b) {
        this();
    }

    public static HandlerC4774c a() {
        return C4775a.a;
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
        C4770a unused;
        unused = C4770a.C4772b.a;
        File g = q33.g(C4786a.a().c, C4786a.a().a);
        if (g.exists()) {
            for (File file : z43.k(g)) {
                if (C4770a.c(file.getName())) {
                    C4770a.e(file);
                }
            }
        }
        C4783c a = C4783c.a();
        String str = a.e.f.containsKey("disk_bytes") ? a.e.f.get("disk_bytes") : "4194304";
        long parseLong = Long.parseLong(TextUtils.isEmpty(str) ? "4194304" : str);
        long j = z43.j(q33.g(C4786a.a().c, C4786a.a().a)) + z43.j(q33.e(C4786a.a().c, C4786a.a().a));
        boolean z = j < parseLong;
        this.a = z;
        if (!z) {
            w63.b("efs.cache", "Cache Limited! curr " + j + "byte, max " + parseLong + " byte.", null);
        }
        sendEmptyMessageDelayed(2, 600000L);
    }
}
