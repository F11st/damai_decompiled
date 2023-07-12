package com.youku.gaiax.impl.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/impl/utils/TraceId;", "", "", "generateTraceId", "globalTraceId", "I", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TraceId {
    @NotNull
    public static final TraceId INSTANCE = new TraceId();
    private static int globalTraceId = 100000;

    private TraceId() {
    }

    public final int generateTraceId() {
        int i = globalTraceId;
        globalTraceId = i + 1;
        return i;
    }
}
