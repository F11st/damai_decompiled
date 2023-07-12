package com.youku.danmaku.engine.danmaku.parser;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDataSource<T> {
    public static final String SCHEME_FILE_TAG = "file";
    public static final String SCHEME_HTTPS_TAG = "https";
    public static final String SCHEME_HTTP_TAG = "http";

    T data();

    void release();
}
