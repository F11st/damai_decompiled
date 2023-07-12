package tb;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e53 {
    String a;
    String b;
    String c;
    public String d;
    public int e;
    public String f;
    public byte g;
    public String h;
    String i;
    String j;
    public long k = 0;

    public static e53 a() {
        e53 e53Var = new e53();
        e53Var.a = com.efs.sdk.base.a.d.a.a().a;
        e53Var.b = com.efs.sdk.base.a.d.a.a().b;
        e53Var.j = com.efs.sdk.base.a.d.a.a().i;
        e53Var.c = g83.a(com.efs.sdk.base.a.d.a.a().c);
        e53Var.i = String.valueOf(com.efs.sdk.base.a.c.a.c.a().e.a);
        return e53Var;
    }

    public final String b() {
        u23.c();
        String valueOf = String.valueOf(u23.e() / 1000);
        String b = n43.b(v23.b(this.j + valueOf, this.b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.a);
        treeMap.put("sd", b);
        if (!TextUtils.isEmpty(this.d)) {
            treeMap.put("cp", this.d);
        }
        if (this.g != 0) {
            treeMap.put("de", String.valueOf(this.e));
            treeMap.put("type", this.h);
            String str = this.f;
            if (TextUtils.isEmpty(str)) {
                u23.c();
                long e = u23.e();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(e), Integer.valueOf(new Random(e).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.i);
        treeMap.put("os", "android");
        treeMap.put(IRequestConst.SVER, this.i);
        treeMap.put(U4WPKAdapter.KEY_TM, valueOf);
        treeMap.put("ver", this.c);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append("&");
        }
        String a = n43.a(sb2.toString() + this.b);
        sb.append("sign=");
        sb.append(a);
        return n43.c(sb.toString());
    }
}
