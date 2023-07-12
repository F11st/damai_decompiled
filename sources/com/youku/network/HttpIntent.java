package com.youku.network;

import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class HttpIntent extends Intent {
    public static final String CONNECT_TIMEOUT = "connect_timeout";
    public static final String COOKIE = "cookie";
    public static final String IS_CACHE_DATA = "is_cache_data";
    public static final String IS_IGNORE_ETAG = "is_ignore_etag";
    public static final String IS_SET_COOKIE = "is_set_cookie";
    public static final String METHOD = "method";
    public static final String READ_TIMEOUT = "read_timeout";
    public static final String URI = "uri";

    public HttpIntent(String str) {
        this(str, "GET", false, true);
    }

    public HttpIntent(String str, String str2) {
        this(str, str2, false, true);
    }

    public HttpIntent(String str, String str2, boolean z) {
        this(str, str2, z, true);
    }

    public HttpIntent(String str, String str2, boolean z, boolean z2) {
        putExtra("uri", str);
        putExtra("method", str2);
        putExtra(IS_SET_COOKIE, z);
        putExtra(IS_CACHE_DATA, z2);
        putExtra("connect_timeout", 10000);
        putExtra(READ_TIMEOUT, 10000);
        putExtra(IS_IGNORE_ETAG, false);
    }

    public HttpIntent(String str, boolean z) {
        this(str, "GET", z, true);
    }

    public HttpIntent(String str, boolean z, boolean z2) {
        this(str, "GET", z, z2);
    }

    public HttpIntent(boolean z, String str) {
        this(str, "GET", false, true);
    }

    public HttpIntent setCache(boolean z) {
        putExtra(IS_CACHE_DATA, z);
        return this;
    }

    public HttpIntent setConnectTimeout(int i) {
        putExtra("connect_timeout", i);
        return this;
    }

    public HttpIntent setCookie(String str) {
        putExtra(COOKIE, str);
        return this;
    }

    public HttpIntent setIgnoreEtag(boolean z) {
        putExtra(IS_IGNORE_ETAG, z);
        return this;
    }

    public HttpIntent setReadTimeout(int i) {
        putExtra(READ_TIMEOUT, i);
        return this;
    }
}
