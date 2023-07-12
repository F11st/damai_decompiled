package com.taobao.android.job.core.graph;

import androidx.annotation.VisibleForTesting;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Nodes {
    private Nodes() {
    }

    @VisibleForTesting(otherwise = 3)
    public static <T, R> Node<T, R> create(T t) {
        return new Node<>(t);
    }
}
