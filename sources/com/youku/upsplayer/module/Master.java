package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.alixplayer.config.FeatureManager;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Master {
    @JSONField(name = "h264")
    public String h264;
    @JSONField(name = "h265")
    public String h265;
    @JSONField(name = "language")
    public String language;
    @JSONField(name = "logo")
    public String logo;
    @JSONField(name = FeatureManager.FEATURE_KEY_SUBTITLE)
    public String subtitle;
}
