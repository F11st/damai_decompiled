package com.youku.danmaku.engine.danmaku.model.android;

import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ObservableTreeSet<O extends Observable> extends TreeSet<O> implements Observer {
    private Observer mObserver;

    public ObservableTreeSet(Comparator<O> comparator) {
        super(comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.TreeSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((ObservableTreeSet<O>) ((Observable) obj));
    }

    public void setDataChangedListener(Observer observer) {
        this.mObserver = observer;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Observer observer = this.mObserver;
        if (observer != null) {
            observer.update(observable, obj);
        }
    }

    public boolean add(O o) {
        if (o != null) {
            o.addObserver(this);
        }
        return super.add((ObservableTreeSet<O>) o);
    }
}
