package com.youku.playerservice.axp.modules.postprocessing;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PostProcessionItem {
    @JSONField(name = "appPostProcessingAlgorithm")
    public String algorithm;
    @JSONField(name = "appPostProcessingDefaultExtend")
    public String defaultExtend;
    @JSONField(name = "appPostProcessingExtend")
    public String extend;
    @JSONField(name = "appPostProcessingSwitch")
    public String switchItem;
    @JSONField(name = "appPostProcessingType")
    public String type;

    public String toString() {
        return "PostProcessionItem{type='" + this.type + "', default_extend='" + this.defaultExtend + "', algorithm='" + this.algorithm + "', extend='" + this.extend + "'}";
    }
}
