package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class v7 extends mc2 {
    @NotNull
    private final short[] a;
    private int b;

    public v7(@NotNull short[] sArr) {
        b41.i(sArr, "array");
        this.a = sArr;
    }

    @Override // tb.mc2
    public short a() {
        try {
            short[] sArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
