package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.o */
/* loaded from: classes3.dex */
public class C8216o extends C8215n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.o$a */
    /* loaded from: classes3.dex */
    public static final class C8217a<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ Enumeration<T> a;

        C8217a(Enumeration<T> enumeration) {
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
        return new C8217a(enumeration);
    }
}
