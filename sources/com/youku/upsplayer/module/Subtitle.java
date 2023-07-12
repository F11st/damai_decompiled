package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Subtitle {
    @JSONField(name = "copyright_key")
    public String copyright_key;
    @JSONField(name = "drm_type")
    public String drm_type;
    @JSONField(name = "encryptR_server")
    public String encryptR_server;
    @JSONField(name = "subtitle_info")
    public String[] subtitle_info;
    @JSONField(name = "subtitle_info_code")
    public String[] subtitle_info_code;
    @JSONField(name = "subtitle_lang")
    public String subtitle_lang;
    @JSONField(name = "url")
    public String url;
    @JSONField(name = "vid")
    public String vid;
}
