package tb;

import java.util.Iterator;
import kotlin.collections.C8214m;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class k21<T> implements Iterator<i21<? extends T>>, KMappedMarker {
    @NotNull
    private final Iterator<T> a;
    private int b;

    /* JADX WARN: Multi-variable type inference failed */
    public k21(@NotNull Iterator<? extends T> it) {
        b41.i(it, "iterator");
        this.a = it;
    }

    @Override // java.util.Iterator
    @NotNull
    /* renamed from: a */
    public final i21<T> next() {
        int i = this.b;
        this.b = i + 1;
        if (i < 0) {
            C8214m.p();
        }
        return new i21<>(i, this.a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
