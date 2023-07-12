package org.apache.commons.text.similarity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CosineSimilarity {
    private double dot(Map<CharSequence, Integer> map, Map<CharSequence, Integer> map2, Set<CharSequence> set) {
        long j = 0;
        for (CharSequence charSequence : set) {
            j += map.get(charSequence).intValue() * map2.get(charSequence).intValue();
        }
        return j;
    }

    private Set<CharSequence> getIntersection(Map<CharSequence, Integer> map, Map<CharSequence, Integer> map2) {
        HashSet hashSet = new HashSet(map.keySet());
        hashSet.retainAll(map2.keySet());
        return hashSet;
    }

    public Double cosineSimilarity(Map<CharSequence, Integer> map, Map<CharSequence, Integer> map2) {
        if (map != null && map2 != null) {
            double dot = dot(map, map2, getIntersection(map, map2));
            double d = 0.0d;
            double d2 = 0.0d;
            for (Integer num : map.values()) {
                d2 += Math.pow(num.intValue(), 2.0d);
            }
            double d3 = 0.0d;
            for (Integer num2 : map2.values()) {
                d3 += Math.pow(num2.intValue(), 2.0d);
            }
            if (d2 > 0.0d && d3 > 0.0d) {
                d = dot / (Math.sqrt(d2) * Math.sqrt(d3));
            }
            return Double.valueOf(d);
        }
        throw new IllegalArgumentException("Vectors must not be null");
    }
}
