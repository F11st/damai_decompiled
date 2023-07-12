package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
    @Override // com.google.common.collect.FilteredMultimap
    SetMultimap<K, V> unfiltered();
}
