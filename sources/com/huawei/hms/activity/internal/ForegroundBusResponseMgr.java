package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ForegroundBusResponseMgr {
    private static final ForegroundBusResponseMgr INSTANCE = new ForegroundBusResponseMgr();
    private final Map<String, BusResponseCallback> callbackMap = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return INSTANCE;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.callbackMap) {
            busResponseCallback = this.callbackMap.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.callbackMap) {
            if (!this.callbackMap.containsKey(str)) {
                this.callbackMap.put(str, busResponseCallback);
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.callbackMap) {
            this.callbackMap.remove(str);
        }
    }
}
