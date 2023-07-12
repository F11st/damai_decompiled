package org.apache.commons.text.similarity;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LevenshteinDetailedDistance implements EditDistance<LevenshteinResults> {
    private static final LevenshteinDetailedDistance DEFAULT_INSTANCE = new LevenshteinDetailedDistance();
    private final Integer threshold;

    public LevenshteinDetailedDistance() {
        this(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
        if (r18 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        r4 = r4 + 1;
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
        r3 = r3 + 1;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
        if (r18 != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.apache.commons.text.similarity.LevenshteinResults findDetailedResults(java.lang.CharSequence r15, java.lang.CharSequence r16, int[][] r17, boolean r18) {
        /*
            int r0 = r16.length()
            int r1 = r15.length()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        Lc:
            if (r0 < 0) goto L8c
            if (r1 < 0) goto L8c
            r6 = -1
            if (r1 != 0) goto L15
            r7 = -1
            goto L1b
        L15:
            r7 = r17[r0]
            int r8 = r1 + (-1)
            r7 = r7[r8]
        L1b:
            if (r0 != 0) goto L1f
            r8 = -1
            goto L25
        L1f:
            int r8 = r0 + (-1)
            r8 = r17[r8]
            r8 = r8[r1]
        L25:
            if (r0 <= 0) goto L32
            if (r1 <= 0) goto L32
            int r9 = r0 + (-1)
            r9 = r17[r9]
            int r10 = r1 + (-1)
            r9 = r9[r10]
            goto L33
        L32:
            r9 = -1
        L33:
            if (r7 != r6) goto L3a
            if (r8 != r6) goto L3a
            if (r9 != r6) goto L3a
            goto L8c
        L3a:
            r10 = r17[r0]
            r10 = r10[r1]
            if (r1 <= 0) goto L58
            if (r0 <= 0) goto L58
            int r11 = r1 + (-1)
            r12 = r15
            char r11 = r15.charAt(r11)
            int r13 = r0 + (-1)
            r14 = r16
            char r13 = r14.charAt(r13)
            if (r11 != r13) goto L5b
        L53:
            int r1 = r1 + (-1)
            int r0 = r0 + (-1)
            goto Lc
        L58:
            r12 = r15
            r14 = r16
        L5b:
            int r11 = r10 + (-1)
            r13 = 1
            if (r11 != r7) goto L64
            if (r10 > r9) goto L64
            if (r10 <= r8) goto L68
        L64:
            if (r9 != r6) goto L74
            if (r8 != r6) goto L74
        L68:
            int r1 = r1 + (-1)
            if (r18 == 0) goto L70
        L6c:
            int r4 = r4 + 1
            r6 = 0
            goto L85
        L70:
            int r3 = r3 + 1
            r6 = 1
            goto L84
        L74:
            if (r11 != r8) goto L7a
            if (r10 > r9) goto L7a
            if (r10 <= r7) goto L7e
        L7a:
            if (r9 != r6) goto L83
            if (r7 != r6) goto L83
        L7e:
            int r0 = r0 + (-1)
            if (r18 == 0) goto L6c
            goto L70
        L83:
            r6 = 0
        L84:
            r13 = 0
        L85:
            if (r13 != 0) goto Lc
            if (r6 != 0) goto Lc
            int r5 = r5 + 1
            goto L53
        L8c:
            org.apache.commons.text.similarity.LevenshteinResults r0 = new org.apache.commons.text.similarity.LevenshteinResults
            int r1 = r4 + r3
            int r1 = r1 + r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r0.<init>(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.similarity.LevenshteinDetailedDistance.findDetailedResults(java.lang.CharSequence, java.lang.CharSequence, int[][], boolean):org.apache.commons.text.similarity.LevenshteinResults");
    }

    public static LevenshteinDetailedDistance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static LevenshteinResults limitedCompare(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        int i3;
        boolean z;
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (i >= 0) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            int i4 = -1;
            int i5 = 0;
            if (length == 0) {
                return length2 <= i ? new LevenshteinResults(Integer.valueOf(length2), Integer.valueOf(length2), 0, 0) : new LevenshteinResults(-1, 0, 0, 0);
            } else if (length2 == 0) {
                return length <= i ? new LevenshteinResults(Integer.valueOf(length), 0, Integer.valueOf(length), 0) : new LevenshteinResults(-1, 0, 0, 0);
            } else {
                int i6 = 1;
                if (length > length2) {
                    i3 = charSequence.length();
                    i2 = length2;
                    z = true;
                    charSequence4 = charSequence;
                    charSequence3 = charSequence2;
                } else {
                    i2 = length;
                    i3 = length2;
                    z = false;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
                int i7 = i2 + 1;
                int[] iArr = new int[i7];
                int[] iArr2 = new int[i7];
                int[][] iArr3 = (int[][]) Array.newInstance(int.class, i3 + 1, i7);
                for (int i8 = 0; i8 <= i2; i8++) {
                    iArr3[0][i8] = i8;
                }
                for (int i9 = 0; i9 <= i3; i9++) {
                    iArr3[i9][0] = i9;
                }
                int min = Math.min(i2, i) + 1;
                for (int i10 = 0; i10 < min; i10++) {
                    iArr[i10] = i10;
                }
                int i11 = Integer.MAX_VALUE;
                Arrays.fill(iArr, min, i7, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int i12 = 1;
                while (i12 <= i3) {
                    char charAt = charSequence4.charAt(i12 - 1);
                    iArr2[i5] = i12;
                    int max = Math.max(i6, i12 - i);
                    int min2 = i12 > i11 - i ? i2 : Math.min(i2, i12 + i);
                    if (max > min2) {
                        return new LevenshteinResults(Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i5));
                    }
                    if (max > 1) {
                        iArr2[max - 1] = i11;
                    }
                    while (max <= min2) {
                        int i13 = max - 1;
                        if (charSequence3.charAt(i13) == charAt) {
                            iArr2[max] = iArr[i13];
                        } else {
                            iArr2[max] = Math.min(Math.min(iArr2[i13], iArr[max]), iArr[i13]) + 1;
                        }
                        iArr3[i12][max] = iArr2[max];
                        max++;
                    }
                    i12++;
                    i4 = -1;
                    i5 = 0;
                    i6 = 1;
                    i11 = Integer.MAX_VALUE;
                    int[] iArr4 = iArr2;
                    iArr2 = iArr;
                    iArr = iArr4;
                }
                if (iArr[i2] <= i) {
                    return findDetailedResults(charSequence3, charSequence4, iArr3, z);
                }
                return new LevenshteinResults(-1, 0, 0, 0);
            }
        }
        throw new IllegalArgumentException("Threshold must not be negative");
    }

    private static LevenshteinResults unlimitedCompare(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        int i2;
        boolean z;
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            char c = 0;
            if (length == 0) {
                return new LevenshteinResults(Integer.valueOf(length2), Integer.valueOf(length2), 0, 0);
            }
            if (length2 == 0) {
                return new LevenshteinResults(Integer.valueOf(length), 0, Integer.valueOf(length), 0);
            }
            if (length > length2) {
                i2 = charSequence.length();
                i = length2;
                z = true;
                charSequence4 = charSequence;
                charSequence3 = charSequence2;
            } else {
                i = length;
                i2 = length2;
                z = false;
                charSequence3 = charSequence;
                charSequence4 = charSequence2;
            }
            int i3 = i + 1;
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[][] iArr3 = (int[][]) Array.newInstance(int.class, i2 + 1, i3);
            for (int i4 = 0; i4 <= i; i4++) {
                iArr3[0][i4] = i4;
            }
            for (int i5 = 0; i5 <= i2; i5++) {
                iArr3[i5][0] = i5;
            }
            for (int i6 = 0; i6 <= i; i6++) {
                iArr[i6] = i6;
            }
            int i7 = 1;
            while (true) {
                int[] iArr4 = iArr2;
                iArr2 = iArr;
                iArr = iArr4;
                if (i7 <= i2) {
                    char charAt = charSequence4.charAt(i7 - 1);
                    iArr[c] = i7;
                    for (int i8 = 1; i8 <= i; i8++) {
                        int i9 = i8 - 1;
                        iArr[i8] = Math.min(Math.min(iArr[i9] + 1, iArr2[i8] + 1), iArr2[i9] + (charSequence3.charAt(i9) == charAt ? 0 : 1));
                        iArr3[i7][i8] = iArr[i8];
                    }
                    i7++;
                    c = 0;
                } else {
                    return findDetailedResults(charSequence3, charSequence4, iArr3, z);
                }
            }
        } else {
            throw new IllegalArgumentException("Strings must not be null");
        }
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public LevenshteinDetailedDistance(Integer num) {
        if (num != null && num.intValue() < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        this.threshold = num;
    }

    @Override // org.apache.commons.text.similarity.EditDistance, org.apache.commons.text.similarity.SimilarityScore
    public LevenshteinResults apply(CharSequence charSequence, CharSequence charSequence2) {
        Integer num = this.threshold;
        if (num != null) {
            return limitedCompare(charSequence, charSequence2, num.intValue());
        }
        return unlimitedCompare(charSequence, charSequence2);
    }
}
