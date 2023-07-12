package com.uc.webview.export.internal.android;

import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.h */
/* loaded from: classes11.dex */
final class C7223h extends WebBackForwardList {

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.android.h$a */
    /* loaded from: classes11.dex */
    class C7224a extends WebHistoryItem {
        C7224a(android.webkit.WebHistoryItem webHistoryItem) {
            this.mItem = webHistoryItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7223h(android.webkit.WebBackForwardList webBackForwardList) {
        this.mList = webBackForwardList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.uc.webview.export.WebBackForwardList
    public final WebHistoryItem createItem(android.webkit.WebHistoryItem webHistoryItem) {
        return new C7224a(webHistoryItem);
    }
}
