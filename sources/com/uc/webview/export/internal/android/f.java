package com.uc.webview.export.internal.android;

import android.webkit.MimeTypeMap;
import com.uc.webview.export.internal.interfaces.IMimeTypeMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class f implements IMimeTypeMap {
    private MimeTypeMap a = MimeTypeMap.getSingleton();

    @Override // com.uc.webview.export.internal.interfaces.IMimeTypeMap
    public final String getExtensionFromMimeType(String str) {
        return this.a.getExtensionFromMimeType(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IMimeTypeMap
    public final String getFileExtensionFromUrlEx(String str) {
        return MimeTypeMap.getFileExtensionFromUrl(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IMimeTypeMap
    public final String getMimeTypeFromExtension(String str) {
        return this.a.getMimeTypeFromExtension(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IMimeTypeMap
    public final boolean hasExtension(String str) {
        return this.a.hasExtension(str);
    }

    @Override // com.uc.webview.export.internal.interfaces.IMimeTypeMap
    public final boolean hasMimeType(String str) {
        return this.a.hasMimeType(str);
    }
}
