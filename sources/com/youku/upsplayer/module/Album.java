package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.uc.webview.export.cyclone.StatAction;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Album {
    @JSONField(name = "id")
    public int id;
    @JSONField(name = "next_id")
    public String next_id;
    @JSONField(name = "next_title")
    public String next_title;
    @JSONField(name = "owner_id")
    public int owner_id;
    @JSONField(name = StatAction.KEY_TOTAL)
    public int total;
}
