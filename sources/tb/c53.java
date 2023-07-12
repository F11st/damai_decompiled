package tb;

import android.util.Base64;
import com.alibaba.security.common.d.AbstractC3806c;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class c53 {
    public static String a(String str, String str2) {
        Cipher cipher = Cipher.getInstance(AbstractC3806c.a);
        cipher.init(2, b(str2));
        return new String(cipher.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
    }

    private static Key b(String str) {
        return SecretKeyFactory.getInstance(AbstractC3806c.a).generateSecret(new DESKeySpec(Base64.decode(str, 0)));
    }
}
