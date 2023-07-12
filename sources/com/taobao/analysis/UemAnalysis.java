package com.taobao.analysis;

import androidx.annotation.Keep;
import java.util.List;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class UemAnalysis {
    private static IFullTraceAnalysis sAnalysisDelegate;

    public static void end(String str, String str2, String str3, String str4) {
        IFullTraceAnalysis iFullTraceAnalysis = sAnalysisDelegate;
        if (iFullTraceAnalysis != null) {
            iFullTraceAnalysis.end(str, str2, str3, str4);
        }
    }

    public static void forceCommit(String str, String str2) {
        IFullTraceAnalysis iFullTraceAnalysis = sAnalysisDelegate;
        if (iFullTraceAnalysis != null) {
            iFullTraceAnalysis.forceCommit(str, str2);
        }
    }

    public static String getFalcoId() {
        IFullTraceAnalysis iFullTraceAnalysis = sAnalysisDelegate;
        return iFullTraceAnalysis != null ? iFullTraceAnalysis.getFalcoId() : "";
    }

    @Deprecated
    public static String getTraceId() {
        return getFalcoId();
    }

    public static void registerStages(String str, List<String> list) {
        IFullTraceAnalysis iFullTraceAnalysis = sAnalysisDelegate;
        if (iFullTraceAnalysis != null) {
            iFullTraceAnalysis.registerStages(str, list);
        }
    }

    static void setAnalysisDelegate(IFullTraceAnalysis iFullTraceAnalysis) {
        sAnalysisDelegate = iFullTraceAnalysis;
    }

    public static void start(String str, String str2, String str3, String str4) {
        IFullTraceAnalysis iFullTraceAnalysis = sAnalysisDelegate;
        if (iFullTraceAnalysis != null) {
            iFullTraceAnalysis.start(str, str2, str3, str4);
        }
    }
}
