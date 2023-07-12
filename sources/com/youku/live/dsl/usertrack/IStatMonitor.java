package com.youku.live.dsl.usertrack;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IStatMonitor {
    void commit(String str, String str2, Map<String, String> map, Map<String, Double> map2);

    void commitFail(String str, String str2, String str3, String str4);

    void commitFail(String str, String str2, String str3, String str4, String str5);

    void commitSuccess(String str, String str2);

    void commitSuccess(String str, String str2, String str3);

    void register(String str, String str2, List<MonitorMeasure> list, List<MonitorDimension> list2);
}
