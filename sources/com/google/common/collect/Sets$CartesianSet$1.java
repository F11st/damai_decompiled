package com.google.common.collect;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class Sets$CartesianSet$1 extends ImmutableList<List<Object>> {
    final /* synthetic */ ImmutableList val$axes;

    Sets$CartesianSet$1(ImmutableList immutableList) {
        this.val$axes = immutableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.val$axes.size();
    }

    @Override // java.util.List
    public List<Object> get(int i) {
        return ((ImmutableSet) this.val$axes.get(i)).asList();
    }
}
