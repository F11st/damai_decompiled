package com.taobao.opentracing.api;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Logger {
    void debugLog(Span span, String str);

    void finishSpan(Span span);

    void releaseLog(Span span, String str);

    void startSpan(Span span);
}
