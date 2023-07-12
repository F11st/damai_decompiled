package com.alibaba.motu.tbrest.data;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestDataQueue<T> {
    private final Object[] elements;
    private final int maxSize;
    private int next = 0;
    private int count = 0;

    public RestDataQueue(int i) {
        this.elements = new Object[i];
        this.maxSize = i;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.maxSize;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        Object[] objArr = this.elements;
        int i = this.next - this.count;
        int i2 = this.maxSize;
        return (T) objArr[(i + i2) % i2];
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        int i = this.next;
        int i2 = this.count;
        int i3 = this.maxSize;
        int i4 = ((i - i2) + i3) % i3;
        Object[] objArr = this.elements;
        T t = (T) objArr[i4];
        objArr[i4] = null;
        this.count = i2 - 1;
        return t;
    }

    public T push(T t) {
        Object[] objArr = this.elements;
        int i = this.next;
        T t2 = (T) objArr[i];
        objArr[i] = t;
        int i2 = i + 1;
        this.next = i2;
        int i3 = this.maxSize;
        this.next = i2 % i3;
        int i4 = this.count;
        if (i4 < i3) {
            this.count = i4 + 1;
        }
        return t2;
    }

    public int size() {
        return this.count;
    }
}
