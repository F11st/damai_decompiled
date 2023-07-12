package com.uc.webview.export.cyclone.update;

import android.text.TextUtils;
import anet.channel.request.a;
import com.uc.webview.export.cyclone.update.Utils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class UrlRequest {
    private static final int DEFAULT_TIME_OUT_MILLIS = 5000;
    private static final String TAG = "UrlRequest";
    private BodyHandler mBodyHandler;
    private Utils.LogHelper mLog;
    private String mUrl;
    private boolean mCheckLastModifed = false;
    private int mConnectTimeOut = 5000;
    private int mReadTimeOut = 5000;
    private Map<String, String> mHeaders = null;
    private int mResponseCode = 0;
    private long mContentLength = 0;
    private long mLastModified = 0;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface BodyHandler {
        void onBodyReceived(InputStream inputStream);
    }

    public UrlRequest(String str, BodyHandler bodyHandler, Utils.LogHelper logHelper) {
        this.mUrl = str;
        this.mBodyHandler = bodyHandler;
        this.mLog = logHelper;
    }

    private HttpURLConnection createUrlConnection(String str, URL url, boolean z) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url, str).openConnection();
        if (z) {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestMethod(a.c.HEAD);
        } else {
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
        }
        httpURLConnection.setConnectTimeout(this.mConnectTimeOut);
        httpURLConnection.setReadTimeout(this.mReadTimeOut);
        Map<String, String> map = this.mHeaders;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return httpURLConnection;
    }

    private void printLog(String str) {
        printLog(str, null);
    }

    private boolean startHeadRequest(String str, URL url) {
        HttpURLConnection httpURLConnection;
        printLog("startHeadRequest url:" + str + ", ref:" + url);
        try {
            httpURLConnection = createUrlConnection(str, url, true);
            try {
                httpURLConnection.connect();
                this.mResponseCode = httpURLConnection.getResponseCode();
                if (!isResponseOk()) {
                    printLog("startHeadRequest failed, error httpCode:" + this.mResponseCode);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused) {
                    }
                    return false;
                } else if (isResponseRedirect()) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        printLog("startHeadRequest failed, location is empty");
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused2) {
                        }
                        return false;
                    }
                    boolean startHeadRequest = startHeadRequest(headerField, new URL(url, str));
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    return startHeadRequest;
                } else {
                    long contentLength = httpURLConnection.getContentLength();
                    this.mContentLength = contentLength;
                    if (contentLength <= 0) {
                        printLog("startHeadRequest failed, invalid size:" + this.mContentLength);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                        return false;
                    }
                    if (this.mCheckLastModifed) {
                        this.mLastModified = httpURLConnection.getLastModified();
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused5) {
                    }
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    printLog("startHeadRequest failed", th);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused6) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused7) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    private boolean startNormalRequest(String str) {
        printLog("startNormalRequest url:" + str);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection createUrlConnection = createUrlConnection(str, null, false);
            createUrlConnection.connect();
            this.mResponseCode = createUrlConnection.getResponseCode();
            if (!isResponseOk()) {
                printLog("startNormalRequest failed, error httpCode:" + this.mResponseCode);
                try {
                    createUrlConnection.disconnect();
                } catch (Throwable unused) {
                }
                return false;
            }
            this.mContentLength = createUrlConnection.getContentLength();
            if (this.mCheckLastModifed) {
                this.mLastModified = createUrlConnection.getLastModified();
            }
            this.mBodyHandler.onBodyReceived(createUrlConnection.getInputStream());
            try {
                createUrlConnection.disconnect();
                return true;
            } catch (Throwable unused2) {
                return true;
            }
        } catch (Throwable th) {
            try {
                printLog("startNormalRequest failed", th);
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                }
                throw th2;
            }
        }
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public long getLastModified() {
        return this.mLastModified;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public boolean isResponseOk() {
        int i = this.mResponseCode;
        return i >= 200 && i <= 303;
    }

    public boolean isResponseRedirect() {
        switch (this.mResponseCode) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public UrlRequest setCheckLastModified(boolean z) {
        this.mCheckLastModifed = z;
        return this;
    }

    public UrlRequest setConnectTimeOut(int i) {
        this.mConnectTimeOut = i;
        return this;
    }

    public UrlRequest setHeader(String str, String str2) {
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap();
        }
        this.mHeaders.put(str, str2);
        return this;
    }

    public UrlRequest setReadTimeOut(int i) {
        this.mReadTimeOut = i;
        return this;
    }

    public boolean start() {
        return this.mBodyHandler == null ? startHeadRequest(this.mUrl, null) : startNormalRequest(this.mUrl);
    }

    private void printLog(String str, Throwable th) {
        Utils.LogHelper logHelper = this.mLog;
        if (logHelper != null) {
            logHelper.print(TAG, str, th);
        }
    }
}
