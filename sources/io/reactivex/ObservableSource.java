package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ObservableSource<T> {
    void subscribe(@NonNull Observer<? super T> observer);
}
