package com.taobao.android.job.core.graph;

import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StringTraverserAction<T, R> implements TraverserAction<T, R> {
    private final StringBuilder builder;

    public StringTraverserAction(StringBuilder sb) {
        this.builder = sb;
    }

    @Override // com.taobao.android.job.core.graph.TraverserAction
    public void onNewLevel(int i) {
        this.builder.append(StringUtils.LF);
    }

    @Override // com.taobao.android.job.core.graph.TraverserAction
    public void onNewPath(int i) {
        StringBuilder sb = this.builder;
        sb.append(StringUtils.LF);
        sb.append("Path #");
        sb.append(i);
    }

    @Override // com.taobao.android.job.core.graph.TraverserAction
    public void onNode(Node<T, R> node) {
        StringBuilder sb = this.builder;
        sb.append(node);
        sb.append(node.getInComingNodes());
        sb.append(" ");
    }
}
