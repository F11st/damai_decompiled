package org.apache.commons.text.similarity;

import java.util.HashSet;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class JaccardSimilarity implements SimilarityScore<Double> {
    private Double calculateJaccardSimilarity(CharSequence charSequence, CharSequence charSequence2) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length != 0 && length2 != 0) {
            int i = 0;
            boolean z = false;
            while (i < length) {
                hashSet2.add(String.valueOf(charSequence.charAt(i)));
                for (int i2 = 0; i2 < length2; i2++) {
                    if (!z) {
                        hashSet2.add(String.valueOf(charSequence2.charAt(i2)));
                    }
                    if (charSequence.charAt(i) == charSequence2.charAt(i2)) {
                        hashSet.add(String.valueOf(charSequence.charAt(i)));
                    }
                }
                i++;
                z = true;
            }
            return Double.valueOf(Double.valueOf(hashSet.size()).doubleValue() / Double.valueOf(hashSet2.size()).doubleValue());
        }
        return Double.valueOf(0.0d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.text.similarity.SimilarityScore
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return Double.valueOf(Math.round(calculateJaccardSimilarity(charSequence, charSequence2).doubleValue() * 100.0d) / 100.0d);
        }
        throw new IllegalArgumentException("Input cannot be null");
    }
}
