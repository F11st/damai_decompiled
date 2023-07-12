package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public interface PatternCompiler {
    b compile(String str);

    boolean isPcreLike();
}
