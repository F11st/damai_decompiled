package com.youku.alixplayer.opensdk.utils;

import android.util.SparseArray;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ListUtils {
    public static int getCount(List<?> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(SparseArray<?> sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }
}
