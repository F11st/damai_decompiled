package com.taobao.tao.powermsg.common;

import java.util.List;
import java.util.Map;
import tb.dm2;
import tb.wt1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IPowerMsgService {
    void countValue(int i, String str, Map<String, Double> map, boolean z, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    List<wt1> getStashMessages(int i, String str);

    void pullMessages(int i, String str, int i2, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    int registerDispatcher(int i, String str, IPowerMsgDispatcher iPowerMsgDispatcher);

    void report(int i, wt1 wt1Var, int i2);

    void sendMessage(int i, wt1 wt1Var, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void sendRequest(int i, String str, int i2, int i3, int i4, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void sendText(int i, dm2 dm2Var, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void setMsgFetchMode(int i, String str, int i2);

    void setSubscribeMode(int i, String str, int i2);

    void subscribe(int i, String str, String str2, String str3, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void subscribe(int i, String str, String str2, String str3, String str4, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void subscribeDirectly(int i, String str, String str2, String str3, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void unSubscribe(int i, String str, String str2, String str3, IPowerMsgCallback iPowerMsgCallback, Object... objArr);

    void unSubscribe(int i, String str, String str2, String str3, String str4, IPowerMsgCallback iPowerMsgCallback, Object... objArr);
}
