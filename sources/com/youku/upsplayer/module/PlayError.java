package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.adapter.URIAdapter;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayError {
    @JSONField(name = "code")
    public int code;
    @JSONField(name = URIAdapter.LINK)
    public String link;
    @JSONField(name = "note")
    public String note;
}
