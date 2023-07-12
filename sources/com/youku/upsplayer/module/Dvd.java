package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Dvd {
    @JSONField(name = "attachment")
    public Attachment[] attachment;
    @JSONField(name = "audiolang")
    public AudioLang[] audiolang;
    @JSONField(name = "cast_screen_forbid_flag")
    public String cast_screen_forbid_flag;
    @JSONField(name = "head")
    public String head;
    @JSONField(name = "notsharing")
    public String notsharing;
    @JSONField(name = "package_type")
    public String[] package_type;
    @JSONField(name = "point")
    public Point[] point;
    @JSONField(name = "tail")
    public String tail;
    @JSONField(name = "threed")
    public String threed;
    @JSONField(name = "video_features")
    public String[] video_features;
}
