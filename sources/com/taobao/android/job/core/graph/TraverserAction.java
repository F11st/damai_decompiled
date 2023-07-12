package com.taobao.android.job.core.graph;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface TraverserAction<T, R> {
    void onNewLevel(int i);

    void onNewPath(int i);

    void onNode(Node<T, R> node);
}
