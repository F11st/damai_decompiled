package com.meizu.cloud.pushsdk.c.g;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class k {
    private static j a;
    private static long b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        synchronized (k.class) {
            j jVar = a;
            if (jVar != null) {
                a = jVar.f;
                jVar.f = null;
                b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        if (jVar.f != null || jVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.d) {
            return;
        }
        synchronized (k.class) {
            long j = b;
            if (j + 2048 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            b = j + 2048;
            jVar.f = a;
            jVar.c = 0;
            jVar.b = 0;
            a = jVar;
        }
    }
}
