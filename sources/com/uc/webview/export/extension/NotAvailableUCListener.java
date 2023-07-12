package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public interface NotAvailableUCListener {
    public static final int TYPE_NOT_INSTALLED_UC = 1;
    public static final int TYPE_NOT_SUPPORT_VERSION = 2;

    void onNotAvailableUC(int i);
}
