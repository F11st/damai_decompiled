package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Pay {
    @JSONField(name = "can_play")
    public boolean can_play;
    @JSONField(name = "discount_price")
    private float discount_price;
    @JSONField(name = "duration")
    public int duration;
    @JSONField(name = "h5_caseurl")
    public String h5_caseurl;
    @JSONField(name = "price")
    public float price;
}
