package com.youku.phone.xcdnengine.utils;

import android.util.Log;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class KVString {
    private static final String TAG = "XcdnEngine";
    private String kvString;
    private HashMap<String, String> mKVMap = new HashMap<>();

    public KVString(String str) {
        this.kvString = str;
    }

    public KVString Parse(String str, String str2) {
        String[] split;
        for (String str3 : this.kvString.split(str)) {
            if (str3 != null && str3.length() > 0) {
                String[] split2 = str3.split(str2);
                if (split2.length != 2) {
                    Log.e(TAG, "parse error: " + str3);
                } else {
                    this.mKVMap.put(split2[0], split2[1]);
                }
            }
        }
        return this;
    }

    public Integer getIntegerValue(String str) {
        int i = 0;
        String stringValue = getStringValue(str);
        if (stringValue != null) {
            try {
                return Integer.valueOf(Integer.parseInt(stringValue));
            } catch (Exception e) {
                Log.e(TAG, str + "get value error " + e.getMessage());
                return i;
            }
        }
        return i;
    }

    public Long getLongValue(String str) {
        long j = 0L;
        String stringValue = getStringValue(str);
        if (stringValue != null) {
            try {
                return Long.valueOf(Long.parseLong(stringValue));
            } catch (Exception e) {
                Log.e(TAG, str + "get value error " + e.getMessage());
                return j;
            }
        }
        return j;
    }

    public String getStringValue(String str) {
        if (str == null) {
            return null;
        }
        return this.mKVMap.get(str);
    }
}
