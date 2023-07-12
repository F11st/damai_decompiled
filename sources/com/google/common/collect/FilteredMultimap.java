package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
interface FilteredMultimap<K, V> extends Multimap<K, V> {
    Predicate<? super Map.Entry<K, V>> entryPredicate();

    Multimap<K, V> unfiltered();
}
