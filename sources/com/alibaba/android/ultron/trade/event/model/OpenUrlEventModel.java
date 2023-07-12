package com.alibaba.android.ultron.trade.event.model;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class OpenUrlEventModel implements Serializable {
    String method;
    String pageType;
    JSONObject params;
    String url;

    public String getMethod() {
        return this.method;
    }

    public String getPageType() {
        return this.pageType;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setPageType(String str) {
        this.pageType = str;
    }

    public void setParams(JSONObject jSONObject) {
        this.params = jSONObject;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
