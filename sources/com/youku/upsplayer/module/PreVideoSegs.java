package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.upsplayer.util.YKUpsConvert;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PreVideoSegs {
    @JSONField(name = "cdn_url")
    public String cdn_url;
    @JSONField(name = YKUpsConvert.FILEID)
    public String fileid;
    @JSONField(name = "key")
    public String key;
    @JSONField(name = "rtmp_url")
    public String rtmp_url;
    @JSONField(name = "size")
    public int size;
    @JSONField(name = "total_milliseconds_video")
    public int total_milliseconds_video;
}
