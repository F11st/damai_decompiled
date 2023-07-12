package com.ut.mini.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.analytics.utils.ILogger;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogAdapter implements ILogger {
    private boolean isNoClassDefFoundError = false;
    private HashMap<String, Integer> mTlogMap;

    public LogAdapter() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        this.mTlogMap = hashMap;
        hashMap.put("V", 5);
        this.mTlogMap.put("D", 4);
        this.mTlogMap.put("I", 3);
        this.mTlogMap.put(ExifInterface.LONGITUDE_WEST, 2);
        this.mTlogMap.put(ExifInterface.LONGITUDE_EAST, 1);
        this.mTlogMap.put("L", 0);
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public int getLogLevel() {
        String logLevel = AdapterForTLog.getLogLevel("Analytics");
        if (this.mTlogMap.containsKey(logLevel)) {
            try {
                return this.mTlogMap.get(logLevel).intValue();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public boolean isValid() {
        if (this.isNoClassDefFoundError) {
            return false;
        }
        try {
            return AdapterForTLog.isValid();
        } catch (Throwable unused) {
            Log.d("Analytics", "java.lang.NoClassDefFoundError: Failed resolution of: Lcom/taobao/tlog/adapter/AdapterForTLog");
            this.isNoClassDefFoundError = true;
            return false;
        }
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public void logd(String str, String str2) {
        AdapterForTLog.logd(str, str2);
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public void loge(String str, String str2) {
        AdapterForTLog.loge(str, str2);
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public void logi(String str, String str2) {
        AdapterForTLog.logi(str, str2);
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public void logw(String str, String str2) {
        AdapterForTLog.logw(str, str2);
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public void loge(String str, String str2, Throwable th) {
        AdapterForTLog.loge(str, str2, th);
    }

    @Override // com.alibaba.analytics.utils.ILogger
    public void logw(String str, String str2, Throwable th) {
        AdapterForTLog.logw(str, str2, th);
    }
}
