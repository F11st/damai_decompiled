package com.uc.webview.export;

import com.taobao.weex.ui.module.WXModalUIModule;
import com.uc.webview.export.annotations.Api;
import java.io.InputStream;
import java.util.Map;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class WebResourceResponse {
    private String a;
    private String b;
    private InputStream c;
    private String d = WXModalUIModule.OK;
    private int e = 200;
    private Map<String, String> f;

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        this.a = str;
        this.b = str2;
        this.c = inputStream;
    }

    public InputStream getData() {
        return this.c;
    }

    public String getEncoding() {
        return this.b;
    }

    public String getMimeType() {
        return this.a;
    }

    public String getReasonPhrase() {
        return this.d;
    }

    public Map<String, String> getResponseHeaders() {
        return this.f;
    }

    public int getStatusCode() {
        return this.e;
    }

    public void setData(InputStream inputStream) {
        this.c = inputStream;
    }

    public void setEncoding(String str) {
        this.b = str;
    }

    public void setMimeType(String str) {
        this.a = str;
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.f = map;
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        this.d = str;
        this.e = i;
    }
}
