package com.ut.mini.behavior;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTEvent;
import com.ut.mini.UTEventTracker;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class UTScrollTracker {
    private static final String TAG = "UTScrollTracker";
    private String mScrollKey = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SingletonHolder {
        private static UTScrollTracker instance = new UTScrollTracker();

        private SingletonHolder() {
        }
    }

    private synchronized void endScroll() {
        Logger.f(TAG, "endScroll scrollKey", this.mScrollKey);
        if (TextUtils.isEmpty(this.mScrollKey)) {
            return;
        }
        UTEventTracker.getInstance().endEvent(UTEventTracker.getInstance().getEventByKey(this.mScrollKey));
        this.mScrollKey = "";
    }

    public static UTScrollTracker getInstance() {
        return SingletonHolder.instance;
    }

    public synchronized void beginScroll(String str, int i, int i2, Map<String, String> map) {
        Logger.f(TAG, "beginScroll scrollKey", str, "scrollX", Integer.valueOf(i), "scrollY", Integer.valueOf(i2), "properties", map);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(this.mScrollKey)) {
            if (this.mScrollKey.equals(str)) {
                Logger.v(TAG, "repeat beginScroll", str);
                return;
            }
            endScroll();
        }
        this.mScrollKey = str;
        UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(str);
        eventByKey.setEventId(UTEventId.SCROLL.getEventId());
        eventByKey.setPageName(str);
        eventByKey.setScrollPosition(i, i2);
        eventByKey.updateProperties(map);
        eventByKey.setToLog(false);
        UTEventTracker.getInstance().beginEvent(eventByKey);
    }

    public synchronized void endScroll(String str, int i, int i2) {
        Logger.f(TAG, "endScroll scrollKey", str, "scrollX", Integer.valueOf(i), "scrollY", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.equals(this.mScrollKey)) {
            Logger.v(TAG, "miss beginScroll scrollKey", str);
            return;
        }
        UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(this.mScrollKey);
        eventByKey.setScrollPosition(i, i2);
        UTEventTracker.getInstance().endEvent(eventByKey);
        this.mScrollKey = "";
    }
}
