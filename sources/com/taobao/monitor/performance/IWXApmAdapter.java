package com.taobao.monitor.performance;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWXApmAdapter {
    void addBiz(String str, Map<String, Object> map);

    void addBizAbTest(String str, Map<String, Object> map);

    void addBizStage(String str, Map<String, Object> map);

    void addProperty(String str, Object obj);

    void addStatistic(String str, double d);

    void onEnd();

    void onEvent(String str, Object obj);

    void onStage(String str, long j);

    void onStart();

    void onStart(String str);

    void onStop();
}
