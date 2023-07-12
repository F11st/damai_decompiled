package anet.channel.security;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ISecurity {
    public static final String CIPHER_ALGORITHM_AES128 = "ASE128";
    public static final String SIGN_ALGORITHM_HMAC_SHA1 = "HMAC_SHA1";

    byte[] decrypt(Context context, String str, String str2, byte[] bArr);

    byte[] getBytes(Context context, String str);

    boolean isSecOff();

    boolean saveBytes(Context context, String str, byte[] bArr);

    String sign(Context context, String str, String str2, String str3);
}
