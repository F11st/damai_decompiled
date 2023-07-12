package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.youku.upsplayer.util.YKUpsConvert;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Stream {
    @JSONField(name = "audio_lang")
    public String audio_lang;
    @JSONField(name = "c_render_type")
    public String c_render_type;
    @JSONField(name = "channel_type")
    public String channel_type;
    @JSONField(name = "codec")
    public String codec;
    @JSONField(name = "drm_type")
    public String drm_type;
    @JSONField(name = "encryptR_server")
    public String encryptR_server;
    @JSONField(name = "fs")
    public Fs fs;
    @JSONField(name = "fs_error")
    public FsError fs_error;
    @JSONField(name = "height")
    public int height;
    @JSONField(name = "logo")
    public String logo;
    @JSONField(name = "m3u8_url")
    public String m3u8_url;
    @JSONField(name = AdUtConstants.XAD_UT_ARG_MEDIA_TYPE)
    public String media_type;
    @JSONField(name = "milliseconds_audio")
    public int milliseconds_audio;
    @JSONField(name = "milliseconds_video")
    public int milliseconds_video;
    @JSONField(name = "pw_url")
    public String pw_url;
    @JSONField(name = YKUpsConvert.SEGS)
    public Segs[] segs;
    @JSONField(name = "size")
    public long size;
    @JSONField(name = "spd")
    public String spd;
    @JSONField(name = "stream_ext")
    public StreamExt stream_ext;
    @JSONField(name = "stream_type")
    public String stream_type;
    @JSONField(name = "subtitle_lang")
    public String subtitle_lang;
    @JSONField(name = "transfer_mode")
    public String transfer_mode;
    @JSONField(name = "width")
    public int width;
}
