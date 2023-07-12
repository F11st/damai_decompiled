package com.taobao.weex.common;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXRequest {
    public static final int DEFAULT_TIMEOUT_MS = 3000;
    public String body;
    public String instanceId;
    public String method;
    public Map<String, String> paramMap;
    public int timeoutMs = 3000;
    public String url;
}
