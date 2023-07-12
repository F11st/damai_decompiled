package org.apache.commons.text.similarity;

import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FuzzyScore {
    private final Locale locale;

    public FuzzyScore(Locale locale) {
        if (locale != null) {
            this.locale = locale;
            return;
        }
        throw new IllegalArgumentException("Locale must not be null");
    }

    public Integer fuzzyScore(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            String lowerCase = charSequence.toString().toLowerCase(this.locale);
            String lowerCase2 = charSequence2.toString().toLowerCase(this.locale);
            int i = Integer.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < lowerCase2.length(); i4++) {
                char charAt = lowerCase2.charAt(i4);
                boolean z = false;
                while (i3 < lowerCase.length() && !z) {
                    if (charAt == lowerCase.charAt(i3)) {
                        i2++;
                        if (i + 1 == i3) {
                            i2 += 2;
                        }
                        z = true;
                        i = i3;
                    }
                    i3++;
                }
            }
            return Integer.valueOf(i2);
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    public Locale getLocale() {
        return this.locale;
    }
}
