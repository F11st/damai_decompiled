package com.taobao.opentracing.api;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface SpanContext {
    Iterable<Map.Entry<String, String>> baggageItems();

    String toSpanId();

    String toTraceId();
}
