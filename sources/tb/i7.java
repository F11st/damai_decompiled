package tb;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class i7 extends me {
    @NotNull
    private final byte[] a;
    private int b;

    public i7(@NotNull byte[] bArr) {
        b41.i(bArr, "array");
        this.a = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // tb.me
    public byte nextByte() {
        try {
            byte[] bArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
