package com.youku.arch.beast.messenger.data;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Data {
    @JSONField(name = "msgType")
    public int msgType = 2;
    @JSONField(name = "content")
    public Content content = new Content();
}
