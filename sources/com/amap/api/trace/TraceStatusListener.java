package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface TraceStatusListener {
    void onTraceStatus(List<TraceLocation> list, List<LatLng> list2, String str);
}
