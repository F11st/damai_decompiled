package com.ut.mini.behavior.edgecomputing.node;

import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BaseNodeHelper {
    private static BaseNodeHelper mInstance;
    private Map<String, String> bizArgFieldsMap;
    private Set<String> mArgFields;

    private BaseNodeHelper() {
        HashSet hashSet = new HashSet();
        this.mArgFields = hashSet;
        hashSet.add(UTDataCollectorNodeColumn.BIZ_AGR1);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR2);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR3);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR4);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR5);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR6);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR7);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR8);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR9);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGR10);
        this.mArgFields.add(UTDataCollectorNodeColumn.BIZ_AGRS);
        this.mArgFields.add(UTDataCollectorNodeColumn.SYS_ARG1);
        this.mArgFields.add(UTDataCollectorNodeColumn.SYS_ARG2);
        this.mArgFields.add(UTDataCollectorNodeColumn.SYS_ARG3);
        this.mArgFields.add(UTDataCollectorNodeColumn.SYS_ARG4);
        this.mArgFields.add(UTDataCollectorNodeColumn.SYS_ARG5);
        this.mArgFields.add(UTDataCollectorNodeColumn.SYS_ARGS);
        this.bizArgFieldsMap = Collections.synchronizedMap(new HashMap());
    }

    public static BaseNodeHelper getInstance() {
        if (mInstance == null) {
            synchronized (BaseNodeHelper.class) {
                if (mInstance == null) {
                    mInstance = new BaseNodeHelper();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String stringNotNull(String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putArgFields(Map<String, Object> map, Map<String, String> map2) {
        Map<String, String> map3 = this.bizArgFieldsMap;
        if (map3 == null || map3.size() == 0) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : this.bizArgFieldsMap.entrySet()) {
                map.put(entry.getValue(), stringNotNull(map2.get(entry.getKey())));
            }
        } catch (Throwable unused) {
        }
    }

    public void setArgFieldsMap(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                this.bizArgFieldsMap.clear();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (this.mArgFields.contains(value) && !yh2.f(key)) {
                        this.bizArgFieldsMap.put(key, value);
                    }
                }
                return;
            } catch (Throwable unused) {
                this.bizArgFieldsMap.clear();
                return;
            }
        }
        this.bizArgFieldsMap.clear();
    }
}
