package com.taobao.weex.bridge;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EventResult {
    private Object result;
    private boolean success = false;

    public Object getResult() {
        return this.result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void onCallback(Object obj) {
        this.success = true;
        this.result = obj;
    }
}
