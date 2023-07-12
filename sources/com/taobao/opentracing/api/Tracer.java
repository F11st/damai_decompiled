package com.taobao.opentracing.api;

import com.taobao.opentracing.api.propagation.Format;
import com.taobao.opentracing.api.tag.Tag;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Tracer {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface SpanBuilder {
        SpanBuilder addReference(String str, SpanContext spanContext);

        SpanBuilder asChildOf(Span span);

        SpanBuilder asChildOf(SpanContext spanContext);

        Span start();

        SpanBuilder withStartTimestamp(long j);

        <T> SpanBuilder withTag(Tag<T> tag, T t);

        SpanBuilder withTag(String str, Number number);

        SpanBuilder withTag(String str, String str2);

        SpanBuilder withTag(String str, boolean z);
    }

    SpanBuilder buildSpan(String str);

    <C> SpanContext extract(Format<C> format, C c);

    <C> void inject(SpanContext spanContext, Format<C> format, C c);

    Logger logger();

    void registerLogger(Logger logger);
}
