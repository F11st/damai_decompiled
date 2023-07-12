package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import tb.kh1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PreVideoInfo {
    @JSONField(name = "metaId")
    public String metaId;
    @JSONField(name = "scm")
    public String scm;
    @JSONField(name = kh1.RESOURCE_STREAM)
    public PreVideoStream[] stream;
    @JSONField(name = "text")
    public PreVideoText text;
    @JSONField(name = "trackInfo")
    public String trackInfo;
}
