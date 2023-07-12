package com.uc.webview.export.internal.interfaces;

import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface IMimeTypeMap {
    String getExtensionFromMimeType(String str);

    String getFileExtensionFromUrlEx(String str);

    String getMimeTypeFromExtension(String str);

    boolean hasExtension(String str);

    boolean hasMimeType(String str);
}
