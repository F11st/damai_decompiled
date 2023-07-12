package com.taobao.weex.appfram.storage;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWXStorageAdapter {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnResultReceivedListener {
        void onReceived(Map<String, Object> map);
    }

    void close();

    void getAllKeys(OnResultReceivedListener onResultReceivedListener);

    void getItem(String str, OnResultReceivedListener onResultReceivedListener);

    void length(OnResultReceivedListener onResultReceivedListener);

    void removeItem(String str, OnResultReceivedListener onResultReceivedListener);

    void setItem(String str, String str2, OnResultReceivedListener onResultReceivedListener);

    void setItemPersistent(String str, String str2, OnResultReceivedListener onResultReceivedListener);
}
