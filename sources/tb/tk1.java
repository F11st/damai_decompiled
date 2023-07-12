package tb;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.security.ISecurity;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class tk1 implements ISecurity {
    private String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tk1(String str) {
        this.a = null;
        this.a = str;
    }

    @Override // anet.channel.security.ISecurity
    public byte[] decrypt(Context context, String str, String str2, byte[] bArr) {
        return null;
    }

    @Override // anet.channel.security.ISecurity
    public byte[] getBytes(Context context, String str) {
        return null;
    }

    @Override // anet.channel.security.ISecurity
    public boolean isSecOff() {
        return true;
    }

    @Override // anet.channel.security.ISecurity
    public boolean saveBytes(Context context, String str, byte[] bArr) {
        return false;
    }

    @Override // anet.channel.security.ISecurity
    public String sign(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(this.a) && ISecurity.SIGN_ALGORITHM_HMAC_SHA1.equalsIgnoreCase(str)) {
            return fv0.b(this.a.getBytes(), str3.getBytes());
        }
        return null;
    }
}
