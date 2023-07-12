package com.alimm.xadsdk.base.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdNetworkOptions {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    private static final int DEFAULT_READ_TIMEOUT = 5000;
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private INetAdapter mAdapter;
    private String mData;
    private Map<String, String> mDataParams;
    private Map<String, String> mHeaders;
    private String mJsonBody;
    private Map<String, String> mParams;
    private String mUrl;
    private int mConnectTimeout = 5000;
    private int mReadTimeout = 5000;
    private String mMethod = "GET";
    private String mCharset = "UTF-8";
    private int mRetryTimes = 0;
    private boolean mAutoRedirect = true;

    public void addHeader(String str, String str2) {
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap(16);
        }
        this.mHeaders.put(str, str2);
    }

    public INetAdapter getAdapter() {
        return this.mAdapter;
    }

    public String getCharset() {
        return this.mCharset;
    }

    public int getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public String getData() {
        return this.mData;
    }

    public Map<String, String> getDataParams() {
        return this.mDataParams;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getJsonBody() {
        return this.mJsonBody;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public int getReadTimeout() {
        return this.mReadTimeout;
    }

    public int getRetryTimes() {
        return this.mRetryTimes;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isAutoRedirect() {
        return this.mAutoRedirect;
    }

    public void setAdapter(INetAdapter iNetAdapter) {
        this.mAdapter = iNetAdapter;
    }

    public void setAutoRedirect(boolean z) {
        this.mAutoRedirect = z;
    }

    public void setCharset(String str) {
        this.mCharset = str;
    }

    public void setConnectTimeout(int i) {
        if (i > 0) {
            this.mConnectTimeout = i;
        }
    }

    public void setData(String str) {
        this.mData = str;
    }

    public void setDataParams(Map<String, String> map) {
        this.mDataParams = map;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setJsonBody(String str) {
        this.mJsonBody = str;
    }

    public void setMethod(String str) {
        if (TextUtils.equals("GET", str) || TextUtils.equals("POST", str)) {
            this.mMethod = str;
        }
    }

    public void setParams(Map<String, String> map) {
        this.mParams = map;
    }

    public void setReadTimeout(int i) {
        if (i > 0) {
            this.mReadTimeout = i;
        }
    }

    public void setRetryTimes(int i) {
        this.mRetryTimes = i;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
