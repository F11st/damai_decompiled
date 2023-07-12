package com.youku.alixplayer.opensdk.statistics.framework.table;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.statistics.TrackUtil;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class Table {
    private Map<String, String> mDimensions = new LinkedHashMap();
    private Map<String, Double> mMeasures = new LinkedHashMap();

    public Map<String, String> getDimensions() {
        return this.mDimensions;
    }

    public Map<String, Double> getMeasures() {
        return this.mMeasures;
    }

    public void put(String str, String str2) {
        this.mDimensions.put(str, str2);
    }

    public void putString(String str) {
        for (String str2 : str.split(";")) {
            String[] split = str2.split("=", 2);
            if (split.length == 2) {
                String str3 = split[0];
                String str4 = split[1];
                if (this.mDimensions.containsKey(str3) && !TextUtils.isEmpty(str4)) {
                    this.mDimensions.put(str3, str4);
                }
                if (this.mMeasures.containsKey(str3)) {
                    this.mMeasures.put(str3, Double.valueOf(TrackUtil.getDoubleValue(str4)));
                }
            }
        }
    }

    public void put(String str, double d) {
        this.mMeasures.put(str, Double.valueOf(d));
    }
}
