package com.taobao.analysis.v3;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface FalcoBusinessSpan extends FalcoSpan {
    void dataParseStart(Long l);

    void networkRequestStart(Long l);

    void preProcessStart(Long l);

    void viewRenderEnd(Long l);

    void viewRenderStart(Long l);
}
