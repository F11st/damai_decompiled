package com.alibaba.motu.tbrest.rest;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestReqDataBuildResult {
    String mPostUrl;
    Map<String, Object> postReqData;

    public Map<String, Object> getPostReqData() {
        return this.postReqData;
    }

    public String getReqUrl() {
        return this.mPostUrl;
    }

    public void setPostReqData(Map<String, Object> map) {
        this.postReqData = map;
    }

    public void setReqUrl(String str) {
        this.mPostUrl = str;
    }
}
