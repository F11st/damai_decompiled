package org.apache.commons.text.similarity;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HammingDistance implements EditDistance<Integer> {
    @Override // org.apache.commons.text.similarity.EditDistance, org.apache.commons.text.similarity.SimilarityScore
    public Integer apply(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            if (charSequence.length() == charSequence2.length()) {
                int i = 0;
                for (int i2 = 0; i2 < charSequence.length(); i2++) {
                    if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            }
            throw new IllegalArgumentException("Strings must have the same length");
        }
        throw new IllegalArgumentException("Strings must not be null");
    }
}
