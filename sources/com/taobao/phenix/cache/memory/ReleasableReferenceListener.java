package com.taobao.phenix.cache.memory;

import tb.m12;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ReleasableReferenceListener {
    void onReferenceDowngrade2Passable(m12 m12Var);

    void onReferenceReleased(m12 m12Var);
}
