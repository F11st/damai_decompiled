package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class n {
    @Nullable
    static m a;
    static long b;

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(m mVar) {
        if (mVar.f == null && mVar.g == null) {
            if (mVar.d) {
                return;
            }
            synchronized (n.class) {
                long j = b;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                b = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                mVar.f = a;
                mVar.c = 0;
                mVar.b = 0;
                a = mVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m b() {
        synchronized (n.class) {
            m mVar = a;
            if (mVar != null) {
                a = mVar.f;
                mVar.f = null;
                b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return mVar;
            }
            return new m();
        }
    }
}
