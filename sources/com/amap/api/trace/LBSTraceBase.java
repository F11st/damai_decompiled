package com.amap.api.trace;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener);

    void setLocationInterval(long j);

    void setTraceStatusInterval(int i);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}
