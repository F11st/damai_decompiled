package com.uc.webview.export.extension;

import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.interfaces.InvokeObject;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public abstract class IOfflineResourceClient implements InvokeObject {
    public static final int RESOURCE_TYPE_AOT_CACHE = 3;
    public static final int RESOURCE_TYPE_AOT_COVERAGE = 2;
    public static final int RESOURCE_TYPE_AOT_SCRIPT = 1;

    public WebResourceResponse getResource(int i, String str) {
        return null;
    }

    @Override // com.uc.webview.export.internal.interfaces.InvokeObject
    public Object invoke(int i, Object[] objArr) {
        return null;
    }
}
