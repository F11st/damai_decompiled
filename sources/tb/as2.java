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
public final class as2 implements Collection<zr2>, KMappedMarker {

    /* compiled from: Taobao */
    /* renamed from: tb.as2$a */
    /* loaded from: classes3.dex */
    private static final class C8925a implements Iterator<zr2>, KMappedMarker {
        @NotNull
        private final int[] a;
        private int b;

        public C8925a(@NotNull int[] iArr) {
            b41.i(iArr, "array");
            this.a = iArr;
        }

        public int a() {
            int i = this.b;
            int[] iArr = this.a;
            if (i < iArr.length) {
                this.b = i + 1;
                return zr2.b(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ zr2 next() {
            return zr2.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<zr2> a(int[] iArr) {
        return new C8925a(iArr);
    }
}
