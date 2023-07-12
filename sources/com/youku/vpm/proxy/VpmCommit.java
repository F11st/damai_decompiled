package com.youku.vpm.proxy;

import androidx.annotation.NonNull;
import java.util.LinkedHashSet;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VpmCommit {
    public static boolean commitStatistics(@NonNull String str, boolean z, Map<String, String> map, Map<String, Double> map2) {
        boolean z2;
        if (map == null || map2 == null) {
            throw new IllegalArgumentException("vpm dim or val is null");
        }
        if (z) {
            z2 = false;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (map.size() > 0) {
                linkedHashSet.addAll(map.keySet());
            }
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            if (map2.size() > 0) {
                linkedHashSet2.addAll(map2.keySet());
            }
            UtProxy.getInstance().register("vpm", str, linkedHashSet2, linkedHashSet);
            z2 = true;
        }
        UtProxy.getInstance().commit("vpm", str, map, map2);
        return z2;
    }
}
