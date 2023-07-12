package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ZPdPayInfo {
    @JSONField(name = "coprice")
    public String coprice;
    @JSONField(name = "duration")
    public int duration;
    @JSONField(name = "oriprice")
    public String oriprice;
    @JSONField(name = "paytype")
    public String[] paytype;
    @JSONField(name = Constants.Value.PLAY)
    public int play;
}
