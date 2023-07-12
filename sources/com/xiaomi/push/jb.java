package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jb extends jf {
    private static final jk a = new jk();

    /* renamed from: a  reason: collision with other field name */
    protected int f794a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f795a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f796a;
    protected boolean b;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f797b;
    protected boolean c;

    /* renamed from: c  reason: collision with other field name */
    private byte[] f798c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private byte[] h;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.jb$a */
    /* loaded from: classes11.dex */
    public static class C7681a implements jh {
        protected int a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f799a;
        protected boolean b;

        public C7681a() {
            this(false, true);
        }

        public C7681a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C7681a(boolean z, boolean z2, int i) {
            this.f799a = false;
            this.b = true;
            this.f799a = z;
            this.b = z2;
            this.a = i;
        }

        @Override // com.xiaomi.push.jh
        public jf a(jp jpVar) {
            jb jbVar = new jb(jpVar, this.f799a, this.b);
            int i = this.a;
            if (i != 0) {
                jbVar.b(i);
            }
            return jbVar;
        }
    }

    public jb(jp jpVar, boolean z, boolean z2) {
        super(jpVar);
        this.f795a = false;
        this.b = true;
        this.c = false;
        this.f796a = new byte[1];
        this.f797b = new byte[2];
        this.f798c = new byte[4];
        this.d = new byte[8];
        this.e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f795a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return ((jf) this).a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.jf
    public byte a() {
        if (((jf) this).a.b() < 1) {
            a(this.e, 0, 1);
            return this.e[0];
        }
        byte b = ((jf) this).a.mo1114a()[((jf) this).a.a()];
        ((jf) this).a.a(1);
        return b;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public double mo1099a() {
        return Double.longBitsToDouble(mo1101a());
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public int mo1100a() {
        byte[] bArr = this.g;
        int i = 0;
        if (((jf) this).a.b() >= 4) {
            bArr = ((jf) this).a.mo1114a();
            i = ((jf) this).a.a();
            ((jf) this).a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public long mo1101a() {
        byte[] bArr = this.h;
        int i = 0;
        if (((jf) this).a.b() >= 8) {
            bArr = ((jf) this).a.mo1114a();
            i = ((jf) this).a.a();
            ((jf) this).a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jc mo1102a() {
        byte a2 = a();
        return new jc("", a2, a2 == 0 ? (short) 0 : mo1109a());
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jd mo1103a() {
        return new jd(a(), mo1100a());
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public je mo1104a() {
        return new je(a(), a(), mo1100a());
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jj mo1105a() {
        return new jj(a(), mo1100a());
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jk mo1106a() {
        return a;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public String mo1107a() {
        int mo1100a = mo1100a();
        if (((jf) this).a.b() >= mo1100a) {
            try {
                String str = new String(((jf) this).a.mo1114a(), ((jf) this).a.a(), mo1100a, "UTF-8");
                ((jf) this).a.a(mo1100a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new iz("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(mo1100a);
    }

    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            ((jf) this).a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new iz("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo1108a() {
        int mo1100a = mo1100a();
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

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public short mo1109a() {
        byte[] bArr = this.f;
        int i = 0;
        if (((jf) this).a.b() >= 2) {
            bArr = ((jf) this).a.mo1114a();
            i = ((jf) this).a.a();
            ((jf) this).a.a(2);
        } else {
            a(this.f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public void mo1110a() {
    }

    @Override // com.xiaomi.push.jf
    public void a(byte b) {
        byte[] bArr = this.f796a;
        bArr[0] = b;
        ((jf) this).a.mo1113a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public void mo1111a(int i) {
        byte[] bArr = this.f798c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        ((jf) this).a.mo1113a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.jf
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        ((jf) this).a.mo1113a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.jf
    public void a(jc jcVar) {
        a(jcVar.a);
        a(jcVar.f801a);
    }

    @Override // com.xiaomi.push.jf
    public void a(jd jdVar) {
        a(jdVar.a);
        mo1111a(jdVar.f802a);
    }

    @Override // com.xiaomi.push.jf
    public void a(je jeVar) {
        a(jeVar.a);
        a(jeVar.b);
        mo1111a(jeVar.f803a);
    }

    @Override // com.xiaomi.push.jf
    public void a(jk jkVar) {
    }

    @Override // com.xiaomi.push.jf
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo1111a(bytes.length);
            ((jf) this).a.mo1113a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new iz("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo1111a(limit);
        ((jf) this).a.mo1113a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.jf
    public void a(short s) {
        byte[] bArr = this.f797b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((jf) this).a.mo1113a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.jf
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo1112a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.jf
    public void b() {
    }

    public void b(int i) {
        this.f794a = i;
        this.c = true;
    }

    @Override // com.xiaomi.push.jf
    public void c() {
        a((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        if (i < 0) {
            throw new iz("Negative length: " + i);
        } else if (this.c) {
            int i2 = this.f794a - i;
            this.f794a = i2;
            if (i2 >= 0) {
                return;
            }
            throw new iz("Message length exceeded: " + i);
        }
    }

    @Override // com.xiaomi.push.jf
    public void d() {
    }

    @Override // com.xiaomi.push.jf
    public void e() {
    }

    @Override // com.xiaomi.push.jf
    public void f() {
    }

    @Override // com.xiaomi.push.jf
    public void g() {
    }

    @Override // com.xiaomi.push.jf
    public void h() {
    }

    @Override // com.xiaomi.push.jf
    public void i() {
    }

    @Override // com.xiaomi.push.jf
    public void j() {
    }
}
