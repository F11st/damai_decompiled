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
public final class nr2 implements Collection<mr2>, KMappedMarker {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class a implements Iterator<mr2>, KMappedMarker {
        @NotNull
        private final byte[] a;
        private int b;

        public a(@NotNull byte[] bArr) {
            b41.i(bArr, "array");
            this.a = bArr;
        }

        public byte a() {
            int i = this.b;
            byte[] bArr = this.a;
            if (i < bArr.length) {
                this.b = i + 1;
                return mr2.b(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ mr2 next() {
            return mr2.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<mr2> a(byte[] bArr) {
        return new a(bArr);
    }
}
