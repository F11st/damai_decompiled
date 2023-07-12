package com.meizu.cloud.pushsdk.c.g;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.k */
/* loaded from: classes10.dex */
public final class C5991k {
    private static C5990j a;
    private static long b;

    private C5991k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C5990j a() {
        synchronized (C5991k.class) {
            C5990j c5990j = a;
            if (c5990j != null) {
                a = c5990j.f;
                c5990j.f = null;
                b -= 2048;
                return c5990j;
            }
            return new C5990j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(C5990j c5990j) {
        if (c5990j.f != null || c5990j.g != null) {
            throw new IllegalArgumentException();
        }
        if (c5990j.d) {
            return;
        }
        synchronized (C5991k.class) {
            long j = b;
            if (j + 2048 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            b = j + 2048;
            c5990j.f = a;
            c5990j.c = 0;
            c5990j.b = 0;
            a = c5990j;
        }
    }
}
