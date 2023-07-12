package com.taobao.weex.adapter;

import android.content.Context;
import com.taobao.weex.common.WXPerformance;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWXUserTrackAdapter {
    public static final String COUNTER = "counter";
    public static final String DOM_MODULE = "domModule";
    public static final String INIT_FRAMEWORK = "initFramework";
    public static final String INVOKE_MODULE = "invokeModule";
    public static final String JS_BRIDGE = "jsBridge";
    public static final String JS_DOWNLOAD = "jsDownload";
    public static final String JS_FRAMEWORK = "jsFramework";
    public static final String LOAD = "load";
    public static final String MODULE_NAME = "weex";
    public static final String MONITOR_ARG = "arg";
    public static final String MONITOR_ERROR_CODE = "errCode";
    public static final String MONITOR_ERROR_MSG = "errMsg";
    public static final String STREAM_MODULE = "streamModule";

    void commit(Context context, String str, String str2, WXPerformance wXPerformance, Map<String, Serializable> map);
}
