package com.uc.webview.export.internal.interfaces;

import android.content.Context;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface IPreloadManager {
    public static final String SIR_COMMON_TYPE = "common";

    WebResourceResponse getPreloadResource(String str, String str2, String str3);

    void setContext(Context context);
}
