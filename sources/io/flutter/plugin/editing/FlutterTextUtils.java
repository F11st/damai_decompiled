package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public int getOffsetAfter(CharSequence charSequence, int i) {
        int charCount;
        int length = charSequence.length();
        int i2 = length - 1;
        if (i >= i2) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i);
        int charCount2 = Character.charCount(codePointAt);
        int i3 = i + charCount2;
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i3) == 13) {
                charCount2++;
            }
            return i + charCount2;
        } else if (isRegionalIndicatorSymbol(codePointAt)) {
            if (i3 >= i2 || !isRegionalIndicatorSymbol(Character.codePointAt(charSequence, i3))) {
                return i3;
            }
            int i5 = i;
            while (i5 > 0 && isRegionalIndicatorSymbol(Character.codePointBefore(charSequence, i))) {
                i5 -= Character.charCount(Character.codePointBefore(charSequence, i));
                i4++;
            }
            if (i4 % 2 == 0) {
                charCount2 += 2;
            }
            return i + charCount2;
        } else {
            if (isKeycapBase(codePointAt)) {
                charCount2 += Character.charCount(codePointAt);
            }
            if (codePointAt == 8419) {
                int codePointBefore = Character.codePointBefore(charSequence, i3);
                int charCount3 = i3 + Character.charCount(codePointBefore);
                if (charCount3 < length && isVariationSelector(codePointBefore)) {
                    int codePointAt2 = Character.codePointAt(charSequence, charCount3);
                    if (isKeycapBase(codePointAt2)) {
                        charCount2 += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                    }
                } else if (isKeycapBase(codePointBefore)) {
                    charCount2 += Character.charCount(codePointBefore);
                }
                return i + charCount2;
            }
            if (isEmoji(codePointAt)) {
                boolean z = false;
                int i6 = 0;
                do {
                    if (z) {
                        charCount2 += Character.charCount(codePointAt) + i6 + 1;
                        z = false;
                    }
                    if (isEmojiModifier(codePointAt)) {
                        break;
                    }
                    if (i3 < length) {
                        codePointAt = Character.codePointAt(charSequence, i3);
                        i3 += Character.charCount(codePointAt);
                        if (codePointAt == 8419) {
                            int codePointBefore2 = Character.codePointBefore(charSequence, i3);
                            int charCount4 = i3 + Character.charCount(codePointBefore2);
                            if (charCount4 < length && isVariationSelector(codePointBefore2)) {
                                int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                                if (isKeycapBase(codePointAt3)) {
                                    charCount2 += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                                }
                            } else if (isKeycapBase(codePointBefore2)) {
                                charCount2 += Character.charCount(codePointBefore2);
                            }
                            return i + charCount2;
                        }
                        if (isEmojiModifier(codePointAt)) {
                            charCount = Character.charCount(codePointAt);
                        } else if (!isVariationSelector(codePointAt)) {
                            if (codePointAt == 8205) {
                                codePointAt = Character.codePointAt(charSequence, i3);
                                i3 += Character.charCount(codePointAt);
                                if (i3 < length && isVariationSelector(codePointAt)) {
                                    codePointAt = Character.codePointAt(charSequence, i3);
                                    int charCount5 = Character.charCount(codePointAt);
                                    i3 += Character.charCount(codePointAt);
                                    i6 = charCount5;
                                    z = true;
                                    if (i3 < length || !z) {
                                        break;
                                        break;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            charCount = Character.charCount(codePointAt);
                        }
                        charCount2 += charCount + 0;
                        break;
                    }
                    i6 = 0;
                    if (i3 < length) {
                        break;
                    }
                } while (isEmoji(codePointAt));
            }
            return i + charCount2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0154 A[EDGE_INSN: B:102:0x0154->B:95:0x0154 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getOffsetBefore(java.lang.CharSequence r9, int r10) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.FlutterTextUtils.getOffsetBefore(java.lang.CharSequence, int):int");
    }

    public boolean isEmoji(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmoji(i);
    }

    public boolean isEmojiModifier(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifier(i);
    }

    public boolean isEmojiModifierBase(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifierBase(i);
    }

    public boolean isKeycapBase(int i) {
        return (48 <= i && i <= 57) || i == 35 || i == 42;
    }

    public boolean isRegionalIndicatorSymbol(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsRegionalIndicator(i);
    }

    public boolean isTagSpecChar(int i) {
        return 917536 <= i && i <= 917630;
    }

    public boolean isVariationSelector(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsVariationSelector(i);
    }
}
