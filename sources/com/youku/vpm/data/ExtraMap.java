package com.youku.vpm.data;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ExtraMap extends LinkedHashMap<String, String> {
    private String mMonitorPoint;

    public ExtraMap(String str) {
        this.mMonitorPoint = str;
    }

    public boolean contains(String... strArr) {
        for (String str : strArr) {
            if (str.equals(this.mMonitorPoint)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public String put(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.contains(";") || str2.contains("=")) {
            return null;
        }
        return (String) super.put((ExtraMap) str, str2);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : entrySet()) {
            String value = entry.getValue();
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(value)) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append(";");
            }
        }
        return stringBuffer.toString();
    }
}
