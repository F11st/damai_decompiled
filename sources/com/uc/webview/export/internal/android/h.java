package com.uc.webview.export.internal.android;

import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class h extends WebBackForwardList {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends WebHistoryItem {
        a(android.webkit.WebHistoryItem webHistoryItem) {
            this.mItem = webHistoryItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(android.webkit.WebBackForwardList webBackForwardList) {
        this.mList = webBackForwardList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.uc.webview.export.WebBackForwardList
    public final WebHistoryItem createItem(android.webkit.WebHistoryItem webHistoryItem) {
        return new a(webHistoryItem);
    }
}
