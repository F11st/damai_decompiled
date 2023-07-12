package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoPresent;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Uploader {
    @JSONField(name = "avatar")
    public Avatar avatar;
    @JSONField(name = ShopInfoPresent.ACTION_TO_AUTH)
    public boolean certification;
    @JSONField(name = "fan_count")
    public int fan_count;
    @JSONField(name = "homepage")
    public String homepage;
    @JSONField(name = "reason")
    public String reason;
    @JSONField(name = "show_brand")
    public boolean show_brand;
    @JSONField(name = "subscription")
    public int subscription;
    @JSONField(name = "uid")
    public String uid;
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "zpd_url")
    public String zpd_url;
}
