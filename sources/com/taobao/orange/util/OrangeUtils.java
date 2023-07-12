package com.taobao.orange.util;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.model.IndexDO;
import com.taobao.orange.model.NameSpaceDO;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeUtils {
    private static final String TAG = "OrangeUtils";

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String encodeQueryParams(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append("=");
                    sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), str).replace(jn1.PLUS, "%20"));
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (UnsupportedEncodingException unused) {
        }
        return sb.toString();
    }

    public static String formatIndexDO(IndexDO indexDO) {
        if (indexDO == null) {
            return null;
        }
        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(IndexDO.class, new String[0]);
        simplePropertyPreFilter.getExcludes().add("mergedNamespaces");
        return JSON.toJSONString(indexDO, simplePropertyPreFilter, SerializerFeature.PrettyFormat);
    }

    public static String formatNamespaceDO(NameSpaceDO nameSpaceDO) {
        if (nameSpaceDO == null) {
            return null;
        }
        return JSON.toJSONString(nameSpaceDO, new SimplePropertyPreFilter(NameSpaceDO.class, "name", "version", "resourceId", "candidates"), SerializerFeature.PrettyFormat);
    }

    public static String formatOperateSymbols(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                sb.append(list.get(i));
            } else {
                sb.append("|");
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    public static String getCurFormatTime() {
        return getEncodeValue(String.valueOf(System.currentTimeMillis() + (GlobalOrange.reqTimestampOffset * 1000)));
    }

    public static String getDecodeValue(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public static String getEncodeValue(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public static long hash(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int length = str.length();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            j = (j * 31) + charArray[i];
        }
        return j & AbsPerformance.LONG_NIL;
    }

    public static long parseLong(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Exception e) {
            OLog.e(TAG, "parseLong", e, new Object[0]);
            return 0L;
        }
    }

    public static List<String> randomListFromSet(Set<String> set) {
        int nextInt;
        ArrayList arrayList = new ArrayList();
        int size = set.size();
        if (size > 2) {
            Random random = new Random();
            int nextInt2 = random.nextInt(size);
            do {
                nextInt = random.nextInt(size);
            } while (nextInt == nextInt2);
            int i = 0;
            for (String str : set) {
                if (i == nextInt2 || i == nextInt) {
                    arrayList.add(str);
                    if (arrayList.size() == 2) {
                        break;
                    }
                }
                i++;
            }
        } else {
            arrayList.addAll(set);
        }
        return arrayList;
    }

    public static <T> Map<String, T> sortMapByKey(Map<String, T> map, final boolean z) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.taobao.orange.util.OrangeUtils.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                if (z) {
                    return str.compareTo(str2);
                }
                return str2.compareTo(str);
            }
        });
        treeMap.putAll(map);
        return treeMap;
    }
}
