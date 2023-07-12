package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class h7 extends dd {
    @NotNull
    private final boolean[] a;
    private int b;

    public h7(@NotNull boolean[] zArr) {
        b41.i(zArr, "array");
        this.a = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // tb.dd
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
