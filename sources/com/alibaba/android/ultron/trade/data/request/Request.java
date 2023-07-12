package com.alibaba.android.ultron.trade.data.request;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class Request implements Cloneable {
    public static final String K_EXPARAMS = "exParams";
    private String mApiName;
    private String mApiVersion;
    private int mBizId;
    private String mDomain;
    private String mUnitStrategy;
    private boolean mUseWua;
    private boolean mNeedEcode = true;
    private boolean mNeedSession = true;
    private boolean mPostMethod = true;
    private Map<String, String> mParams = new HashMap();
    private Map<String, String> mHeaders = new HashMap();

    public static Request newInstance() {
        return new Request();
    }

    private void processExparams(Map<String, String> map, String str) {
        JSONObject jSONObject;
        if (map == null || str == null) {
            return;
        }
        String str2 = map.get(K_EXPARAMS);
        if (TextUtils.isEmpty(str2)) {
            map.put(K_EXPARAMS, str);
            return;
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = JSON.parseObject(str2);
            try {
                jSONObject2 = JSON.parseObject(str);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.putAll(jSONObject2);
        map.put(K_EXPARAMS, jSONObject.toJSONString());
    }

    public Request appendHeaders(Map<String, String> map) {
        if (this.mHeaders != null) {
            if (map != null && !map.isEmpty()) {
                this.mHeaders.putAll(map);
            }
        } else {
            this.mHeaders = map;
        }
        return this;
    }

    public Request appendParams(Map<String, String> map) {
        if (this.mParams != null && map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    String key = entry.getKey();
                    if (K_EXPARAMS.equals(key)) {
                        processExparams(this.mParams, entry.getValue());
                    } else {
                        this.mParams.put(key, entry.getValue());
                    }
                }
            }
        } else {
            this.mParams = map;
        }
        return this;
    }

    public String getApiName() {
        return this.mApiName;
    }

    public String getApiVersion() {
        return this.mApiVersion;
    }

    public int getBizId() {
        return this.mBizId;
    }

    public String getDomain() {
        return this.mDomain;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public String getUnitStrategy() {
        return this.mUnitStrategy;
    }

    public boolean isNeedEcode() {
        return this.mNeedEcode;
    }

    public boolean isNeedSession() {
        return this.mNeedSession;
    }

    public boolean isPostMethod() {
        return this.mPostMethod;
    }

    public boolean isUseWua() {
        return this.mUseWua;
    }

    public void mergeRequest(Request request) {
        if (request != null) {
            if (!TextUtils.isEmpty(request.mDomain)) {
                this.mDomain = request.mDomain;
            }
            if (!TextUtils.isEmpty(request.mApiName)) {
                this.mApiName = request.mApiName;
            }
            if (!TextUtils.isEmpty(request.mApiVersion)) {
                this.mApiVersion = request.mApiVersion;
            }
            if (!TextUtils.isEmpty(request.mUnitStrategy)) {
                this.mUnitStrategy = request.mUnitStrategy;
            }
            appendParams(request.getParams());
            appendHeaders(request.getHeaders());
            this.mPostMethod = request.mPostMethod;
            this.mBizId = request.mBizId;
            this.mUseWua = request.mUseWua;
            this.mNeedEcode = request.mNeedEcode;
            this.mNeedSession = request.mNeedSession;
        }
    }

    public Request setApiName(String str) {
        this.mApiName = str;
        return this;
    }

    public Request setApiVersion(String str) {
        this.mApiVersion = str;
        return this;
    }

    public Request setBizId(int i) {
        this.mBizId = i;
        return this;
    }

    public Request setDomain(String str) {
        this.mDomain = str;
        return this;
    }

    public Request setHeaders(Map<String, String> map) {
        this.mHeaders = map;
        return this;
    }

    public Request setNeedEcode(boolean z) {
        this.mNeedEcode = z;
        return this;
    }

    public Request setNeedSession(boolean z) {
        this.mNeedSession = z;
        return this;
    }

    public Request setParams(Map<String, String> map) {
        this.mParams = map;
        return this;
    }

    public Request setPostMethod(boolean z) {
        this.mPostMethod = z;
        return this;
    }

    public Request setUnitStrategy(String str) {
        this.mUnitStrategy = str;
        return this;
    }

    public Request setUseWua(boolean z) {
        this.mUseWua = z;
        return this;
    }

    /* renamed from: clone */
    public Request m105clone() {
        try {
            Request request = (Request) super.clone();
            request.setParams(new HashMap(this.mParams));
            request.setHeaders(new HashMap(this.mHeaders));
            return request;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return newInstance();
        }
    }
}
