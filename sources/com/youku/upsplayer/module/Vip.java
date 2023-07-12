package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.live.dago.liveplayback.widget.PluginName;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Vip {
    @JSONField(name = "acc_open")
    public boolean acc_open;
    @JSONField(name = "acc_support")
    public boolean acc_support;
    @JSONField(name = PluginName.AD)
    public boolean ad;
    @JSONField(name = "adExperience")
    public boolean adExperience;
    @JSONField(name = "clarity1080Experience")
    public boolean clarity1080Experience;
    @JSONField(name = "contentExperience")
    public boolean contentExperience;
    @JSONField(name = "desc_ad")
    public VipErrorInfo desc_ad;
    @JSONField(name = "dolby")
    public boolean dolby;
    @JSONField(name = "hd3")
    public boolean hd3;
    @JSONField(name = URIAdapter.LINK)
    public String link;
    @JSONField(name = "note")
    public String note;
    @JSONField(name = Constants.Value.ORIGINAL)
    public boolean original;
    @JSONField(name = "reason")
    public String reason;
    @JSONField(name = FeatureManager.FEATURE_KEY_SUBTITLE)
    public boolean subtitle;
}
