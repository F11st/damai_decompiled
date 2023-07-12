package com.taobao.monitor.procedure;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IProcedure {
    public static final IProcedure DEFAULT = new C6809a();

    IProcedure addBiz(String str, Map<String, Object> map);

    IProcedure addBizAbTest(String str, Map<String, Object> map);

    IProcedure addBizStage(String str, Map<String, Object> map);

    IProcedure addProperty(String str, Object obj);

    IProcedure addPropertyIfAbsent(String str, Object obj);

    IProcedure addStatistic(String str, Object obj);

    @Deprecated
    IProcedure addSubTask(String str, long j, long j2);

    IProcedure begin();

    IProcedure end();

    IProcedure end(boolean z);

    IProcedure event(String str, Map<String, Object> map);

    boolean isAlive();

    IProcedure onSubTaskBegin(String str);

    IProcedure onSubTaskFail(String str, String str2, Map<String, Object> map);

    IProcedure onSubTaskSuccess(String str, Map<String, Object> map);

    IProcedure parent();

    IProcedure stage(String str, long j);

    IProcedure stageIfAbsent(String str, long j);

    String topic();

    String topicSession();
}
