package com.huawei.hms.opendevice;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class a {
    public static String a(byte[] bArr) {
        return HexUtil.byteArray2HexStr(bArr);
    }

    public static byte[] a(String str) {
        return HexUtil.hexStr2ByteArray(str);
    }
}
