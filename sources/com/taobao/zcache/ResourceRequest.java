package com.taobao.zcache;

import androidx.annotation.Keep;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class ResourceRequest {
    private final Map<String, String> header;
    private String md5;
    private final String referrer;
    private String traceId;
    private final String url;

    public ResourceRequest(String str) {
        this.traceId = null;
        this.md5 = null;
        this.url = str;
        this.referrer = null;
        this.header = null;
    }

    private static String getReferrerFromHeader(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.containsKey("Referer")) {
            return map.get("Referer");
        }
        if (map.containsKey("referer")) {
            return map.get("referer");
        }
        return null;
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getMD5() {
        return this.md5;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMD5(String str) {
        this.md5 = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public ResourceRequest(String str, String str2) {
        this.traceId = null;
        this.md5 = null;
        this.url = str;
        this.referrer = str2;
        this.header = null;
    }

    public ResourceRequest(String str, Map<String, String> map) {
        this.traceId = null;
        this.md5 = null;
        this.url = str;
        this.header = map;
        this.referrer = getReferrerFromHeader(map);
    }
}
