package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class u<E> extends o<E> implements Queue<E> {
    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // com.google.common.collect.o, com.google.common.collect.t
    protected abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    @CanIgnoreReturnValue
    public abstract boolean offer(E e);

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E remove() {
        return delegate().remove();
    }

    protected boolean standardOffer(E e) {
        try {
            return add(e);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    protected E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    protected E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
