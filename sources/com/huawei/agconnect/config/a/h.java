package com.huawei.agconnect.config.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class h implements d {
    private final Context a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private static String a(String str) {
        try {
            return "agc_" + e.a(a(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr);
    }

    @Override // com.huawei.agconnect.config.a.d
    public String a(String str, String str2) {
        int identifier;
        String a = a(str);
        if (TextUtils.isEmpty(a) || (identifier = this.a.getResources().getIdentifier(a, "string", this.b)) == 0) {
            return str2;
        }
        try {
            return this.a.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return str2;
        }
    }
}
