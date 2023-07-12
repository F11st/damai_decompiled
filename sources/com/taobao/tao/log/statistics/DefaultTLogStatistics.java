package com.taobao.tao.log.statistics;

import android.util.Log;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultTLogStatistics implements ITLogStatistics {
    private static final String TAG = "DefaultTLogStatistics";

    @Override // com.taobao.tao.log.statistics.ITLogStatistics
    public void event(String str, Map<String, String> map) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = map != null ? map.toString() : "";
        Log.i(TAG, String.format("TLog UT: eventName=%s, data=%s", objArr));
    }
}
