package com.google.common.collect;

import java.util.List;
import tb.du1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class CartesianList$1 extends ImmutableList<Object> {
    final /* synthetic */ j this$0;
    final /* synthetic */ int val$index;

    CartesianList$1(j jVar, int i) {
        this.val$index = i;
    }

    @Override // java.util.List
    public Object get(int i) {
        du1.n(i, size());
        return ((List) j.a(this.this$0).get(i)).get(j.b(this.this$0, this.val$index, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return j.a(this.this$0).size();
    }
}
