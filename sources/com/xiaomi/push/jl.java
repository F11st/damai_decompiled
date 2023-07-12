package com.xiaomi.push;

import com.xiaomi.push.jb;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jl extends jb {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;
    private static int e = 10485760;
    private static int f = 104857600;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a extends jb.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.jb.a, com.xiaomi.push.jh
        public jf a(jp jpVar) {
            jl jlVar = new jl(jpVar, ((jb.a) this).f799a, this.b);
            int i = ((jb.a) this).a;
            if (i != 0) {
                jlVar.b(i);
            }
            return jlVar;
        }
    }

    public jl(jp jpVar, boolean z, boolean z2) {
        super(jpVar, z, z2);
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    /* renamed from: a */
    public jd mo1103a() {
        byte a2 = a();
        int mo1100a = mo1100a();
        if (mo1100a <= c) {
            return new jd(a2, mo1100a);
        }
        throw new jg(3, "Thrift list size " + mo1100a + " out of range!");
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    /* renamed from: a */
    public je mo1104a() {
        byte a2 = a();
        byte a3 = a();
        int mo1100a = mo1100a();
        if (mo1100a <= b) {
            return new je(a2, a3, mo1100a);
        }
        throw new jg(3, "Thrift map size " + mo1100a + " out of range!");
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    /* renamed from: a */
    public jj mo1105a() {
        byte a2 = a();
        int mo1100a = mo1100a();
        if (mo1100a <= d) {
            return new jj(a2, mo1100a);
        }
        throw new jg(3, "Thrift set size " + mo1100a + " out of range!");
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    /* renamed from: a */
    public String mo1107a() {
        int mo1100a = mo1100a();
        if (mo1100a > e) {
            throw new jg(3, "Thrift string size " + mo1100a + " out of range!");
        } else if (((jf) this).a.b() >= mo1100a) {
            try {
                String str = new String(((jf) this).a.mo1114a(), ((jf) this).a.a(), mo1100a, "UTF-8");
                ((jf) this).a.a(mo1100a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new iz("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            return a(mo1100a);
        }
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    /* renamed from: a */
    public ByteBuffer mo1108a() {
        int mo1100a = mo1100a();
        if (mo1100a > f) {
            throw new jg(3, "Thrift binary size " + mo1100a + " out of range!");
        }
        c(mo1100a);
        if (((jf) this).a.b() >= mo1100a) {
            ByteBuffer wrap = ByteBuffer.wrap(((jf) this).a.mo1114a(), ((jf) this).a.a(), mo1100a);
            ((jf) this).a.a(mo1100a);
            return wrap;
        }
        byte[] bArr = new byte[mo1100a];
        ((jf) this).a.b(bArr, 0, mo1100a);
        return ByteBuffer.wrap(bArr);
    }
}
