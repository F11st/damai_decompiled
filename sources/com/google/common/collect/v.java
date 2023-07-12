package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class v<E> extends o<E> implements Set<E> {
    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    protected boolean standardEquals(@NullableDecl Object obj) {
        return Sets.a(this, obj);
    }

    protected int standardHashCode() {
        return Sets.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.h(this, (Collection) du1.p(collection));
    }
}
