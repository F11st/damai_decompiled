package me.ele.altriax.launcher.real.time.data.monitor;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.b30;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BaseMonitor {
    public static final String BIZ_ID = "altriax_real_time_data";
    private ConcurrentHashMap<String, Object> dataMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> innerDataHashMap = new ConcurrentHashMap<>();

    public void addData(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.dataMap.put(str, str2);
        this.innerDataHashMap.put(str, str2);
    }

    public void dataHubPublish() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.innerDataHashMap;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(this.innerDataHashMap.size());
        for (Map.Entry<String, String> entry : this.innerDataHashMap.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        b30.a().c(BIZ_ID, hashMap);
    }

    public Map<String, Object> getDataMap() {
        HashMap hashMap = new HashMap();
        ConcurrentHashMap<String, Object> concurrentHashMap = this.dataMap;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : this.dataMap.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return this.dataMap;
    }

    public <T> void addData(@Nullable String str, @Nullable T t) {
        if (TextUtils.isEmpty(str) || t == null) {
            return;
        }
        this.dataMap.put(str, String.valueOf(t));
        this.innerDataHashMap.put(str, String.valueOf(t));
    }
}
