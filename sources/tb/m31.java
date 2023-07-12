package tb;

import java.util.NoSuchElementException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class m31 extends i31 {
    private final int a;
    private final int b;
    private boolean c;
    private int d;

    public m31(int i, int i2, int i3) {
        this.a = i3;
        this.b = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // tb.i31
    public int nextInt() {
        int i = this.d;
        if (i == this.b) {
            if (this.c) {
                this.c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.d = this.a + i;
        }
        return i;
    }
}
