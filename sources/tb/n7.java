package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class n7 extends kc0 {
    @NotNull
    private final double[] a;
    private int b;

    public n7(@NotNull double[] dArr) {
        b41.i(dArr, "array");
        this.a = dArr;
    }

    @Override // tb.kc0
    public double a() {
        try {
            double[] dArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return dArr[i];
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
