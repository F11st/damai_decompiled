package com.uc.webview.export;

import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class WebBackForwardList {
    public android.webkit.WebBackForwardList mList = null;

    public WebHistoryItem createItem(android.webkit.WebHistoryItem webHistoryItem) {
        return null;
    }

    public synchronized int getCurrentIndex() {
        return this.mList.getCurrentIndex();
    }

    public synchronized WebHistoryItem getCurrentItem() {
        android.webkit.WebHistoryItem currentItem = this.mList.getCurrentItem();
        if (currentItem == null) {
            return null;
        }
        return createItem(currentItem);
    }

    public synchronized WebHistoryItem getItemAtIndex(int i) {
        android.webkit.WebHistoryItem itemAtIndex = this.mList.getItemAtIndex(i);
        if (itemAtIndex == null) {
            return null;
        }
        return createItem(itemAtIndex);
    }

    public synchronized int getSize() {
        return this.mList.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public synchronized WebBackForwardList m582clone() {
        return null;
    }
}
