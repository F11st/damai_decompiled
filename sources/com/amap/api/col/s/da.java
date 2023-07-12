package com.amap.api.col.s;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class da extends br {
    protected Context a;
    protected bv b;
    protected byte[] c;

    public da(Context context, bv bvVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = bvVar;
        q();
    }

    private byte[] A() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            Context context = this.a;
            bv bvVar = this.b;
            byte[] a = bn.a(context, bvVar != null && "navi".equals(bvVar.b()));
            byteArrayOutputStream.write(a(a));
            byteArrayOutputStream.write(a);
            byte[] a2 = bw.a(d());
            if (a2 != null && a2.length > 0) {
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a3 = bw.a(j());
            if (a3 != null && a3.length > 0) {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                ci.a(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    ci.a(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ci.a(th3, "bre", "gred");
                }
            }
        }
    }

    private static byte[] B() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                ci.a(th, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    ci.a(th2, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ci.a(th3, "bre", "grrd");
                }
            }
        }
    }

    private byte[] C() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] b = b();
            if (b != null && b.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] a = bn.a(b);
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                ci.a(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ci.a(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    ci.a(th4, "bre", "gred");
                }
            }
        }
    }

    private static byte[] a(byte[] bArr) {
        return bw.a(bArr.length);
    }

    private static byte[] z() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bw.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                ci.a(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    ci.a(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ci.a(th3, "bre", "gbh");
                }
            }
        }
    }

    public abstract byte[] b();

    protected String d() {
        return "2.1";
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> e() {
        String f = bk.f(this.a);
        String a = bn.a();
        String a2 = bn.a(this.a, a, "key=".concat(String.valueOf(f)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    @Override // com.amap.api.col.s.df
    public final byte[] g() {
        byte[] bArr = this.c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(z());
            byteArrayOutputStream.write(A());
            byteArrayOutputStream.write(B());
            byteArrayOutputStream.write(C());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.c = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                ci.a(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    ci.a(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ci.a(th3, "bre", "geb");
                }
            }
        }
    }

    public final String j() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.d(), this.b.b());
    }
}
