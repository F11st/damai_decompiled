package tb;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class n53 {
    public static boolean a(byte[] bArr) {
        String str;
        if (bArr != null) {
            byte[] bArr2 = null;
            try {
                c73 c73Var = new c73();
                c73Var.b.put("Content-Type", "application/octet-stream");
                c73Var.b.put("aps_c_src", Base64.encodeToString(c73.a().getBytes(), 2));
                c73Var.b.put("aps_c_key", Base64.encodeToString(c73.b().getBytes(), 2));
                c73Var.c = bArr;
                if (l53.a) {
                    str = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                } else {
                    str = (l53.b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                }
                c73Var.a = str;
                d73 a = q63.c().a(c73Var);
                if (a != null && a.a == 200) {
                    bArr2 = a.c;
                }
                if (bArr2 != null) {
                    return "true".equals(new String(bArr2, StandardCharsets.UTF_8));
                }
                return false;
            } catch (Exception e) {
                b73.a(e);
                return false;
            }
        }
        return false;
    }
}
