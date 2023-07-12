package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class o extends n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ Enumeration<T> a;

        a(Enumeration<T> enumeration) {
            this.a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static <T> Iterator<T> s(@NotNull Enumeration<T> enumeration) {
        b41.i(enumeration, "<this>");
        return new a(enumeration);
    }
}
