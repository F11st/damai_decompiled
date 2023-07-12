package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.upsplayer.util.YKUpsConvert;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PreVideoStream {
    @JSONField(name = "audio_lang")
    public String audio_lang;
    @JSONField(name = "height")
    public int height;
    @JSONField(name = "logo")
    public String logo;
    @JSONField(name = "milliseconds_video")
    public int milliseconds_video;
    @JSONField(name = YKUpsConvert.SEGS)
    public PreVideoSegs[] segs;
    @JSONField(name = "size")
    public int size;
    @JSONField(name = "stream_type")
    public String stream_type;
    @JSONField(name = "width")
    public int width;
}
