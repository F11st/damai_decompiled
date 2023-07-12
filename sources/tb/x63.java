package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.efs.sdk.base.a.e.InterfaceC4792c;
import com.efs.sdk.base.a.h.b.C4802b;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.Constants;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class x63 implements InterfaceC4792c {
    private static void b(l01 l01Var) {
        if (l01Var == null || TextUtils.isEmpty(l01Var.c)) {
            return;
        }
        for (String str : l01Var.c.split("`")) {
            String[] split = str.split("=");
            if (split.length >= 2) {
                if (split[0].equalsIgnoreCase("retcode")) {
                    l01Var.d(split[1]);
                } else {
                    ((Map) l01Var.d).put(split[0], split[1]);
                }
            }
        }
    }

    @Override // com.efs.sdk.base.a.e.InterfaceC4792c
    @NonNull
    public final l01 a(j43 j43Var, boolean z) {
        l01 l01Var;
        n73 n73Var;
        try {
            n73Var = n73.C9462a.a;
            a53 a53Var = n73Var.a;
            String valueOf = String.valueOf(System.currentTimeMillis());
            String a = n43.a(a53Var.b + a53Var.c + valueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = a53Var.a;
            if (str.startsWith("http")) {
                sb.append(str);
            } else {
                sb.append(str);
            }
            sb.append("?chk=");
            sb.append(a.substring(a.length() - 8));
            sb.append("&vno=");
            sb.append(valueOf);
            sb.append("&uuid=");
            sb.append(a53Var.c);
            sb.append("&app=");
            sb.append(a53Var.b);
            sb.append("&zip=gzip");
            String sb2 = sb.toString();
            int i = 0;
            byte[] bArr = new byte[0];
            int i2 = j43Var.a.c;
            if (i2 == 0) {
                bArr = j43Var.c;
                i = bArr.length;
            } else if (1 == i2) {
                bArr = z43.g(j43Var.d.getPath());
                i = bArr.length;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
            hashMap.put(Constants.Protocol.CONTENT_LENGTH, String.valueOf(i));
            C4802b c = new C4802b(sb2).c(hashMap);
            c.a.c = bArr;
            l01Var = c.a().b();
            b(l01Var);
        } catch (Throwable th) {
            l01Var = 0 == 0 ? new l01() : null;
            w63.c("efs.wa.send", "get file size error", th);
        }
        if (!l01Var.a) {
            w63.a(com.efs.sdk.base.Constants.TAG, "wa upload fail, resp is " + l01Var.toString());
            return l01Var;
        }
        w63.a(com.efs.sdk.base.Constants.TAG, "wa upload succ, " + l01Var.toString());
        z43.i(j43Var.d);
        return l01Var;
    }
}
