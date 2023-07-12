package com.youku.playerservice.axp.postprocessing;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PPConfigItem {
    @JSONField(name = "app_post_processing_extend")
    public String extend;
    @JSONField(name = "app_post_processing_min_device_store")
    public String score;
    @JSONField(name = "app_post_processing_mode")
    public String mode = "0";
    @JSONField(name = "app_post_processing_algorithm")
    public String algorithm = "0";
}
