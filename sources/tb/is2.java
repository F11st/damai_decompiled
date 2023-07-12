package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: classes3.dex */
public final class is2 implements Collection<hs2>, KMappedMarker {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class a implements Iterator<hs2>, KMappedMarker {
        @NotNull
        private final short[] a;
        private int b;

        public a(@NotNull short[] sArr) {
            b41.i(sArr, "array");
            this.a = sArr;
        }

        public short a() {
            int i = this.b;
            short[] sArr = this.a;
            if (i < sArr.length) {
                this.b = i + 1;
                return hs2.b(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ hs2 next() {
            return hs2.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<hs2> a(short[] sArr) {
        return new a(sArr);
    }
}
