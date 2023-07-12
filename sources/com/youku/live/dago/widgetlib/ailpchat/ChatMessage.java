package com.youku.live.dago.widgetlib.ailpchat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ChatMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    public JSONObject dataDictionary;
    public String msgId;
    public String msgType;
    public String powerMsgId;
    public String roomId;
    public String subType;
    public String topic;

    public String toString() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1371126486") ? (String) ipChange.ipc$dispatch("-1371126486", new Object[]{this}) : JSON.toJSONString(this);
    }
}
