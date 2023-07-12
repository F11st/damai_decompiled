package com.taobao.weex.common;

import com.taobao.weex.WXEnvironment;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXJSExceptionInfo {
    private String mBundleUrl;
    private WXErrorCode mErrCode;
    private String mException;
    private Map<String, String> mExtParams;
    private String mFunction;
    private String mInstanceId;
    private String mWeexVersion = WXEnvironment.WXSDK_VERSION;
    private String mJsFrameworkVersion = WXEnvironment.JS_LIB_SDK_VERSION;
    public long time = System.currentTimeMillis();

    public WXJSExceptionInfo(String str, String str2, WXErrorCode wXErrorCode, String str3, String str4, Map<String, String> map) {
        this.mInstanceId = str;
        this.mBundleUrl = str2;
        this.mErrCode = wXErrorCode;
        this.mFunction = str3;
        this.mException = str4;
        this.mExtParams = map;
    }

    public String getBundleUrl() {
        return this.mBundleUrl;
    }

    public WXErrorCode getErrCode() {
        return this.mErrCode;
    }

    public String getException() {
        return this.mException;
    }

    public Map<String, String> getExtParams() {
        return this.mExtParams;
    }

    public String getFunction() {
        return this.mFunction;
    }

    public String getInstanceId() {
        return this.mInstanceId;
    }

    public String getJsFrameworkVersion() {
        return this.mJsFrameworkVersion;
    }

    public String getWeexVersion() {
        return this.mWeexVersion;
    }

    public void setBundleUrl(String str) {
        this.mBundleUrl = str;
    }

    public void setErrCode(WXErrorCode wXErrorCode) {
        this.mErrCode = wXErrorCode;
    }

    public void setException(String str) {
        this.mException = str;
    }

    public void setExtParams(Map<String, String> map) {
        this.mExtParams = map;
    }

    public void setFunction(String str) {
        this.mFunction = str;
    }

    public void setInstanceId(String str) {
        this.mInstanceId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" errCode:");
        WXErrorCode wXErrorCode = this.mErrCode;
        sb.append(wXErrorCode == null ? "unSetErrorCode" : wXErrorCode.getErrorCode());
        sb.append(",function:");
        String str = this.mFunction;
        if (str == null) {
            str = "unSetFuncName";
        }
        sb.append(str);
        sb.append(",exception:");
        String str2 = this.mException;
        if (str2 == null) {
            str2 = "unSetException";
        }
        sb.append(str2);
        return sb.toString();
    }
}
