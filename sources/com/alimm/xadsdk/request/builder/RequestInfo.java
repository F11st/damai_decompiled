package com.alimm.xadsdk.request.builder;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.AdSdkManager;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RequestInfo implements Serializable {
    private static final int DEFAULT_RETRY_TIMES = 0;
    private static final int DEFAULT_TIME_OUT = 5000;
    private int mAdType;
    private Map<String, String> mExtraParams;
    private boolean mNeedAddCookie;
    private boolean mUsePostMethod = false;
    private int mTimeout = 5000;
    private int mRetryTimes = 0;
    private boolean mIsMainThreadCallback = true;
    private Context mContext = AdSdkManager.getInstance().getAppContext();

    public RequestInfo addExtraParams(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.mExtraParams == null) {
                this.mExtraParams = new ConcurrentHashMap(16);
            }
            this.mExtraParams.put(str, str2);
        }
        return this;
    }

    public RequestInfo addExtraParams(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            if (this.mExtraParams == null) {
                this.mExtraParams = new ConcurrentHashMap(16);
            }
            this.mExtraParams.putAll(map);
        }
        return this;
    }

    public int getAdType() {
        return this.mAdType;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Map<String, String> getExtraParams() {
        return this.mExtraParams;
    }

    public int getRetryTimes() {
        return this.mRetryTimes;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public boolean isMainThreadCallback() {
        return this.mIsMainThreadCallback;
    }

    public boolean isNeedAddCookie() {
        return this.mNeedAddCookie;
    }

    public boolean isUsePostMethod() {
        return this.mUsePostMethod;
    }

    public RequestInfo setAdType(int i) {
        this.mAdType = i;
        return this;
    }

    public RequestInfo setMainThreadCallback(boolean z) {
        this.mIsMainThreadCallback = z;
        return this;
    }

    public RequestInfo setNeedAddCookie(boolean z) {
        this.mNeedAddCookie = z;
        return this;
    }

    public RequestInfo setRetryTimes(int i) {
        this.mRetryTimes = i;
        return this;
    }

    public RequestInfo setTimeout(int i) {
        this.mTimeout = i;
        return this;
    }

    public RequestInfo setUsePostMethod(boolean z) {
        this.mUsePostMethod = z;
        return this;
    }
}
