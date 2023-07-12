package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: okio.n */
/* loaded from: classes2.dex */
public final class C8856n {
    @Nullable
    static C8855m a;
    static long b;

    private C8856n() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(C8855m c8855m) {
        if (c8855m.f == null && c8855m.g == null) {
            if (c8855m.d) {
                return;
            }
            synchronized (C8856n.class) {
                long j = b;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                b = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                c8855m.f = a;
                c8855m.c = 0;
                c8855m.b = 0;
                a = c8855m;
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C8855m b() {
        synchronized (C8856n.class) {
            C8855m c8855m = a;
            if (c8855m != null) {
                a = c8855m.f;
                c8855m.f = null;
                b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return c8855m;
            }
            return new C8855m();
        }
    }
}
