package com.alipay.sdk.m.x;

import java.util.Iterator;
import java.util.Stack;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.x.f */
/* loaded from: classes10.dex */
public class C4364f {
    public Stack<C4354e> a = new Stack<>();

    public void a(C4354e c4354e) {
        this.a.push(c4354e);
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public C4354e c() {
        return this.a.pop();
    }

    public void a() {
        if (b()) {
            return;
        }
        Iterator<C4354e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }
}
