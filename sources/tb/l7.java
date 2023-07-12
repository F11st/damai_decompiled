package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class l7 extends ai {
    @NotNull
    private final char[] a;
    private int b;

    public l7(@NotNull char[] cArr) {
        b41.i(cArr, "array");
        this.a = cArr;
    }

    @Override // tb.ai
    public char a() {
        try {
            char[] cArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return cArr[i];
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
