package tb;

import java.util.NoSuchElementException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class dc1 extends bc1 {
    private final long a;
    private final long b;
    private boolean c;
    private long d;

    public dc1(long j, long j2, long j3) {
        this.a = j3;
        this.b = j2;
        boolean z = true;
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i <= 0 ? i2 < 0 : i2 > 0) {
            z = false;
        }
        this.c = z;
        this.d = z ? j : j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // tb.bc1
    public long nextLong() {
        long j = this.d;
        if (j == this.b) {
            if (this.c) {
                this.c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.d = this.a + j;
        }
        return j;
    }
}
