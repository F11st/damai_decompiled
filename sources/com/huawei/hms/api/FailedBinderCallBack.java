package com.huawei.hms.api;

import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FailedBinderCallBack {
    public static final String CALLER_ID = "callId";
    private static FailedBinderCallBack a;
    private static Map<Long, BinderCallBack> b = new ConcurrentHashMap();
    private static final Object c = new Object();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface BinderCallBack {
        void binderCallBack(int i);
    }

    private FailedBinderCallBack() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10000;
        for (Long l : b.keySet()) {
            if (time >= l.longValue()) {
                b.remove(l);
            }
        }
    }

    public static FailedBinderCallBack getInstance() {
        synchronized (c) {
            if (a == null) {
                a = new FailedBinderCallBack();
            }
        }
        return a;
    }

    public BinderCallBack getCallBack(Long l) {
        Map<Long, BinderCallBack> map = b;
        if (map == null) {
            HMSLog.e("FailedBinderCallBack", "binderCallBackMap is null");
            return null;
        }
        return map.remove(l);
    }

    public void setCallBack(Long l, BinderCallBack binderCallBack) {
        a(l, binderCallBack);
    }

    private void a(Long l, BinderCallBack binderCallBack) {
        if (b == null) {
            HMSLog.e("FailedBinderCallBack", "binderCallBackMap is null");
            return;
        }
        a();
        b.put(l, binderCallBack);
    }
}
