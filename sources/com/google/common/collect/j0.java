package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
abstract class j0<F, T> implements Iterator<T> {
    final Iterator<? extends F> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Iterator<? extends F> it) {
        this.a = (Iterator) du1.p(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
