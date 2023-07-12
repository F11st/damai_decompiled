package tb;

import android.content.Context;
import com.loc.C5846l;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class s43 extends o83 {
    protected Context l;
    protected com.loc.u1 m;
    protected byte[] n;

    public s43(Context context, com.loc.u1 u1Var) {
        if (context != null) {
            this.l = context.getApplicationContext();
        }
        this.m = u1Var;
        A();
    }

    private static byte[] J() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(com.loc.v1.p("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                y33.e(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    y33.e(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    y33.e(th3, "bre", "gbh");
                }
            }
        }
    }

    private byte[] K() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (R()) {
                Context context = this.l;
                boolean T = T();
                com.loc.u1 u1Var = this.m;
                byte[] f = com.loc.o1.f(context, T, u1Var != null && "navi".equals(u1Var.a()));
                byteArrayOutputStream.write(N(f));
                byteArrayOutputStream.write(f);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] p = com.loc.v1.p(Q());
            if (p == null || p.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(N(p));
                byteArrayOutputStream.write(p);
            }
            byte[] p2 = com.loc.v1.p(S());
            if (p2 == null || p2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(N(p2));
                byteArrayOutputStream.write(p2);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                y33.e(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    y33.e(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    y33.e(th3, "bre", "gred");
                }
            }
        }
    }

    private byte[] L() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O = O();
            if (O != null && O.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(N(O));
                byteArrayOutputStream.write(O);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                y33.e(th, "bre", "grrd");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                y33.e(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    y33.e(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    y33.e(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] M() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] P = P();
            if (P != null && P.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] g = com.loc.o1.g(P);
                byteArrayOutputStream.write(N(g));
                byteArrayOutputStream.write(g);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                y33.e(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                y33.e(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    y33.e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    y33.e(th4, "bre", "gred");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] N(byte[] bArr) {
        return com.loc.v1.o(bArr.length);
    }

    public abstract byte[] O();

    public abstract byte[] P();

    protected String Q() {
        return "2.1";
    }

    public boolean R() {
        return true;
    }

    public String S() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.m.f(), this.m.a());
    }

    protected boolean T() {
        return false;
    }

    @Override // com.loc.bl
    public Map<String, String> q() {
        String j = C5846l.j(this.l);
        String a = com.loc.o1.a();
        String c = com.loc.o1.c(this.l, a, "key=".concat(String.valueOf(j)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", j);
        hashMap.put("scode", c);
        return hashMap;
    }

    @Override // com.loc.bl
    public final byte[] r() {
        byte[] bArr = this.n;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(J());
            byteArrayOutputStream.write(K());
            byteArrayOutputStream.write(L());
            byteArrayOutputStream.write(M());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.n = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                y33.e(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    y33.e(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    y33.e(th3, "bre", "geb");
                }
            }
        }
    }
}
