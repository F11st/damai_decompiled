package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class p7 extends i31 {
    @NotNull
    private final int[] a;
    private int b;

    public p7(@NotNull int[] iArr) {
        b41.i(iArr, "array");
        this.a = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // tb.i31
    public int nextInt() {
        try {
            int[] iArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
