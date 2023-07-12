package tb;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class je {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";
    private final TreeSet<he> a = new TreeSet<>();
    private final he b = he.b(0);
    private final Random c = new Random();
    private long d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class a {
        static je a = new je();
    }

    public static je a() {
        return a.a;
    }

    public synchronized void b(he heVar) {
        he pollLast;
        if (heVar != null) {
            int i = heVar.b;
            if (i < 524288) {
                this.d += i;
                this.a.add(heVar);
                while (this.d > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    if (this.c.nextBoolean()) {
                        pollLast = this.a.pollFirst();
                    } else {
                        pollLast = this.a.pollLast();
                    }
                    this.d -= pollLast.b;
                }
            }
        }
    }

    public synchronized he c(int i) {
        if (i >= 524288) {
            return he.b(i);
        }
        he heVar = this.b;
        heVar.b = i;
        he ceiling = this.a.ceiling(heVar);
        if (ceiling == null) {
            ceiling = he.b(i);
        } else {
            Arrays.fill(ceiling.a, (byte) 0);
            ceiling.c = 0;
            this.a.remove(ceiling);
            this.d -= ceiling.b;
        }
        return ceiling;
    }

    public he d(byte[] bArr, int i) {
        he c = c(i);
        System.arraycopy(bArr, 0, c.a, 0, i);
        c.c = i;
        return c;
    }
}
