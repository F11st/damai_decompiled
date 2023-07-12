package com.taobao.opentracing.api;

import com.taobao.opentracing.api.tag.Tag;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Span {
    SpanContext context();

    void finish();

    void finish(long j);

    long finishTime();

    String getBaggageItem(String str);

    Span log(long j, String str);

    Span log(long j, Map<String, ?> map);

    Span log(String str);

    Span log(Map<String, ?> map);

    String operationName();

    Span setBaggageItem(String str, String str2);

    Span setOperationName(String str);

    <T> Span setTag(Tag<T> tag, T t);

    Span setTag(String str, Number number);

    Span setTag(String str, String str2);

    Span setTag(String str, boolean z);

    long startTime();

    Map<String, ?> tags();
}
