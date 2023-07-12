package com.taobao.weex.bridge;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface WXValidateProcessor {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WXComponentValidateResult {
        public boolean isSuccess;
        public String replacedComponent;
        public JSONObject validateInfo;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WXModuleValidateResult {
        public boolean isSuccess;
        public JSONObject validateInfo;
    }

    boolean needValidate(String str);

    WXComponentValidateResult onComponentValidate(WXSDKInstance wXSDKInstance, String str, WXComponent wXComponent);

    WXModuleValidateResult onModuleValidate(WXSDKInstance wXSDKInstance, String str, String str2, JSONArray jSONArray, JSONObject jSONObject);
}
