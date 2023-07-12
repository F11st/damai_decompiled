package com.taobao.slide.task;

import com.taobao.slide.api.SlideLoad;
import com.taobao.slide.api.SlideSubscriber;
import com.taobao.slide.model.ResultDO;
import java.util.Map;
import tb.hh1;
import tb.m42;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DispatchTask implements Runnable {
    private static final String TAG = "Dispatch";
    private Map<String, ResultDO> notifyResults;
    private SlideSubscriber subscriber;

    public DispatchTask(SlideSubscriber slideSubscriber, Map<String, ResultDO> map) {
        this.subscriber = slideSubscriber;
        this.notifyResults = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            for (Map.Entry<String, ResultDO> entry : this.notifyResults.entrySet()) {
                hh1.a(hh1.POINT_NOTIFY, String.format("%s:%s", entry.getValue().name, entry.getValue().version));
                if (SlideLoad.f) {
                    m42.c(TAG, "dispatch ", entry.getValue().toString());
                }
            }
            m42.g(TAG, "onNotify", this.notifyResults.keySet().toString());
            this.subscriber.f(this.notifyResults);
        } catch (Throwable th) {
            m42.d(TAG, "run", th, new Object[0]);
        }
    }
}
