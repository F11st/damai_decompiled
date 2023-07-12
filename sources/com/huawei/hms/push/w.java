package com.huawei.hms.push;

import com.youku.upsplayer.util.YKUpsConvert;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class w {
    public static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};

    public static String a(byte[] bArr) {
        return bArr == null ? "" : new String(bArr, x.a);
    }
}
