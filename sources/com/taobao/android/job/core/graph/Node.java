package com.taobao.android.job.core.graph;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class Node<T, R> implements Serializable {
    public static final int STATUS_FAIL = 0;
    public static final int STATUS_SKIP = 1;
    public static final int STATUS_SUCCESS = 2;
    public static final int STATUS_UNSET = -1;
    private Object data;
    private R result;
    private T value;
    private int status = -1;
    private Set<Node<T, R>> inComingEdges = new LinkedHashSet();
    private Set<Node<T, R>> outGoingEdges = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node(T t) {
        this.value = t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addInComingNode(Node<T, R> node) {
        this.inComingEdges.add(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOutGoingNode(Node<T, R> node) {
        this.outGoingEdges.add(node);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Node.class) {
            return false;
        }
        return this.value.equals(((Node) obj).value);
    }

    public Object getData() {
        return this.data;
    }

    public Set<Node<T, R>> getInComingNodes() {
        return this.inComingEdges;
    }

    public Set<Node<T, R>> getOutGoingNodes() {
        return this.outGoingEdges;
    }

    public R getResult() {
        return this.result;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        return 31 + (t == null ? 0 : t.hashCode());
    }

    public boolean isFailed() {
        return this.status == 0;
    }

    public boolean isNotProcessed() {
        return !isProcessed();
    }

    public boolean isProcessed() {
        return this.status != -1;
    }

    public boolean isSkipped() {
        return this.status == 1;
    }

    public boolean isSuccess() {
        return this.status == 2;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setErrored() {
        this.status = 0;
    }

    public void setResult(R r) {
        this.result = r;
    }

    public void setSkipped() {
        this.status = 1;
    }

    public void setSuccess() {
        this.status = 2;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
