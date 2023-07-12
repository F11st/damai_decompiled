package com.taobao.analysis;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IFullTraceAnalysis {
    void end(String str, String str2, String str3, String str4);

    void forceCommit(String str, String str2);

    String getFalcoId();

    @Deprecated
    String getTraceId();

    void registerStages(String str, List<String> list);

    void start(String str, String str2, String str3, String str4);
}
