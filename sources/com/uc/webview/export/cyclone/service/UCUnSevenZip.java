package com.uc.webview.export.cyclone.service;

import android.content.Context;
import com.uc.webview.export.cyclone.Constant;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public interface UCUnSevenZip extends UCServiceInterface {
    public static final int SZ_ERROR_OPEN_OUTPUT_EOF = 7;
    public static final int SZ_OK = 0;

    int deccompress(Context context, String str, String str2);

    int deccompress(Context context, String str, String str2, String str3);

    String failedFilePath();
}
