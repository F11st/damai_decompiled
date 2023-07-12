package com.airbnb.lottie.parser.moshi;

import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.moshi.a */
/* loaded from: classes17.dex */
final class C2921a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append(jn1.ARRAY_START);
                sb.append(iArr2[i2]);
                sb.append(jn1.ARRAY_END);
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }
}
