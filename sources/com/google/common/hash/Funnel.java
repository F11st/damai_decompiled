package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.Serializable;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public interface Funnel<T> extends Serializable {
    void funnel(T t, PrimitiveSink primitiveSink);
}
