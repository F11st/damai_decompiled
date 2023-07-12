package com.alibaba.emas.publish;

import androidx.annotation.Keep;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes15.dex */
public class EmasPublishRequest {
    public String appVersion;
    public Map<String, String> args;
    public String bizName;
    public EmasPublishCallback callback;
    public String currentVersion;
    public String mtopApiName;
}
