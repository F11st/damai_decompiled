package tb;

import anet.channel.util.ALog;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class fv0 {
    private static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            return mac.doFinal(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String b(byte[] bArr, byte[] bArr2) {
        try {
            return zh2.b(a(bArr, bArr2));
        } catch (Throwable th) {
            ALog.e("awcn.HMacUtil", "hmacSha1Hex", null, "result", "", th);
            return "";
        }
    }
}
