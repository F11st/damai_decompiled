package com.ut.mini.behavior.data;

import com.alibaba.analytics.core.model.LogField;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DataKey {
    private Map<String, String> mDataKeyMap;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SingletonHolder {
        private static DataKey instance = new DataKey();

        private SingletonHolder() {
        }
    }

    public static DataKey getInstance() {
        return SingletonHolder.instance;
    }

    public String getDataKey(String str) {
        String str2 = this.mDataKeyMap.get(str);
        return (str2 == null || str2.length() == 0) ? str : str2;
    }

    private DataKey() {
        HashMap hashMap = new HashMap();
        hashMap.put("eid", LogField.EVENTID.toString());
        hashMap.put("pg", LogField.PAGE.toString());
        hashMap.put("arg1", LogField.ARG1.toString());
        hashMap.put("arg2", LogField.ARG2.toString());
        hashMap.put(UTDataCollectorNodeColumn.ARG3, LogField.ARG3.toString());
        this.mDataKeyMap = Collections.unmodifiableMap(hashMap);
    }
}
