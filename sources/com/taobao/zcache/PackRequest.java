package com.taobao.zcache;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class PackRequest {
    private Error error;
    private final String info;
    private final String name;
    private String traceId;

    public PackRequest(String str) {
        this.traceId = null;
        this.error = null;
        this.name = str;
        this.info = null;
    }

    public Error getError() {
        return this.error;
    }

    public String getInfo() {
        return this.info;
    }

    public String getName() {
        return this.name;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public PackRequest(String str, String str2) {
        this.traceId = null;
        this.error = null;
        this.name = str;
        this.info = str2;
    }
}
