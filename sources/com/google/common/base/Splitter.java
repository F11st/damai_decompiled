package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class Splitter {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }
}
