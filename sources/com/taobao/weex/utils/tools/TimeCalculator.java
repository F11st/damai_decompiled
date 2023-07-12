package com.taobao.weex.utils.tools;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TimeCalculator {
    public static final String PLATFORM_ANDROID = "Android";
    public static final String TIMELINE_TAG = "timeline";
    private CopyOnWriteArrayList<LogDetail> a = new CopyOnWriteArrayList<>();

    public TimeCalculator(WXSDKInstance wXSDKInstance) {
    }

    public void addLog(LogDetail logDetail) {
        if (WXEnvironment.isPerf()) {
            this.a.add(logDetail);
        }
    }

    public LogDetail createLogDetail(String str) {
        LogDetail logDetail = new LogDetail();
        logDetail.name(str);
        addLog(logDetail);
        return logDetail;
    }

    public void println() {
        if (WXEnvironment.isPerf()) {
            Iterator<LogDetail> it = this.a.iterator();
            while (it.hasNext()) {
                Log.e(TIMELINE_TAG, JSON.toJSONString(it.next()));
            }
        }
    }
}
