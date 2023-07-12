package com.youku.alixplayer.opensdk.statistics.data;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ExtraMap extends LinkedHashMap<String, String> {
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

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public String put(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && (str2.contains(";") || str2.contains("="))) {
            TLogUtil.vpmLog("ExtraMap value is fail:" + str2);
            str2 = null;
        }
        return (String) super.put((ExtraMap) str, str2);
    }
}
