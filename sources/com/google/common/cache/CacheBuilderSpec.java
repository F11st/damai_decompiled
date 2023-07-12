package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public final class CacheBuilderSpec {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2);
    }
}
