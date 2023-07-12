package com.uc.webview.export;

import android.graphics.Bitmap;
import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class WebHistoryItem {
    public android.webkit.WebHistoryItem mItem = null;

    public Bitmap getFavicon() {
        return this.mItem.getFavicon();
    }

    public String getOriginalUrl() {
        return this.mItem.getOriginalUrl();
    }

    public String getTitle() {
        return this.mItem.getTitle();
    }

    public String getUrl() {
        return this.mItem.getUrl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public synchronized WebHistoryItem m583clone() {
        return null;
    }
}
