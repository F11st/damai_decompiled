package tb;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class u73 extends s43 {
    Map<String, String> o;
    private String p;
    String q;
    String r;
    byte[] s;
    byte[] t;
    boolean u;
    String v;
    Map<String, String> w;
    boolean x;

    public u73(Context context, com.loc.u1 u1Var) {
        super(context, u1Var);
        this.o = null;
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = null;
        this.x = false;
    }

    @Override // tb.s43
    public final byte[] O() {
        return this.s;
    }

    @Override // tb.s43
    public final byte[] P() {
        return this.t;
    }

    @Override // tb.s43
    public final boolean R() {
        return this.u;
    }

    @Override // tb.s43
    public final String S() {
        return this.v;
    }

    @Override // tb.s43
    protected final boolean T() {
        return this.x;
    }

    public final void U(Map<String, String> map) {
        this.w = map;
    }

    public final void V(String str) {
        this.v = str;
    }

    public final void W(Map<String, String> map) {
        this.o = map;
    }

    public final void X(boolean z) {
        this.u = z;
    }

    public final void Y(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(s43.N(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.t = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void Z(String str) {
        this.q = str;
    }

    public final void a0(boolean z) {
        this.x = z;
    }

    @Override // com.loc.bl
    public final Map<String, String> b() {
        return this.o;
    }

    public final void b0(byte[] bArr) {
        this.s = bArr;
    }

    public final void c0(String str) {
        this.r = str;
    }

    public final void d0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.p = "";
        } else {
            this.p = str;
        }
    }

    @Override // com.loc.bl
    public final String j() {
        return this.q;
    }

    @Override // tb.o83, com.loc.bl
    public final String m() {
        return this.r;
    }

    @Override // tb.s43, com.loc.bl
    public final Map<String, String> q() {
        return this.w;
    }

    @Override // com.loc.bl
    public final String s() {
        return this.p;
    }

    @Override // com.loc.bl
    public final String t() {
        return "loc";
    }
}
