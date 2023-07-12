package tb;

import java.util.NoSuchElementException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class di extends ai {
    private final int a;
    private final int b;
    private boolean c;
    private int d;

    public di(char c, char c2, int i) {
        this.a = i;
        this.b = c2;
        boolean z = true;
        if (i <= 0 ? b41.k(c, c2) < 0 : b41.k(c, c2) > 0) {
            z = false;
        }
        this.c = z;
        this.d = z ? c : c2;
    }

    @Override // tb.ai
    public char a() {
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
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
