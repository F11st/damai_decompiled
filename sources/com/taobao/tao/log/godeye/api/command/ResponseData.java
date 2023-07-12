package com.taobao.tao.log.godeye.api.command;

import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ResponseData {
    public JSONObject extraData;
    public final String reason;
    public final int responseCode;
    public JSONObject tokenData;

    public ResponseData(int i, String str, JSONObject jSONObject) {
        this.responseCode = i;
        this.reason = str;
        this.extraData = jSONObject;
    }
}
