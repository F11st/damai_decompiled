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
public final class ds2 implements Collection<cs2>, KMappedMarker {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class a implements Iterator<cs2>, KMappedMarker {
        @NotNull
        private final long[] a;
        private int b;

        public a(@NotNull long[] jArr) {
            b41.i(jArr, "array");
            this.a = jArr;
        }

        public long a() {
            int i = this.b;
            long[] jArr = this.a;
            if (i < jArr.length) {
                this.b = i + 1;
                return cs2.b(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ cs2 next() {
            return cs2.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<cs2> a(long[] jArr) {
        return new a(jArr);
    }
}
