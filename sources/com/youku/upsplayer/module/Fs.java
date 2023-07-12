package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Fs {
    @JSONField(name = "codec")
    public String codec;
    @JSONField(name = "discontinue_num")
    public Long discontinue_num;
    @JSONField(name = "drm_type")
    public String drm_type;
    @JSONField(name = "sequence_num")
    public Long sequence_num;
    @JSONField(name = "slice_duration")
    public long slice_duration;
    @JSONField(name = "slice_pos")
    public long slice_pos;
    @JSONField(name = "slice_size")
    public long slice_size;
    @JSONField(name = "slice_url")
    public String slice_url;
    @JSONField(name = "stream_type")
    public String stream_type;
}
