package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.dx;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    int f362a;

    /* renamed from: a  reason: collision with other field name */
    private dx.C7635a f363a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.ao f364a;

    /* renamed from: a  reason: collision with other field name */
    String f365a;

    /* renamed from: a  reason: collision with other field name */
    private short f366a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f367b;
    private static String b = gy.a(5) + "-";
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f361a = new byte[0];

    public fl() {
        this.f366a = (short) 2;
        this.f367b = f361a;
        this.f365a = null;
        this.f364a = null;
        this.f363a = new dx.C7635a();
        this.f362a = 1;
    }

    fl(dx.C7635a c7635a, short s, byte[] bArr) {
        this.f366a = (short) 2;
        this.f367b = f361a;
        this.f365a = null;
        this.f364a = null;
        this.f363a = c7635a;
        this.f366a = s;
        this.f367b = bArr;
        this.f362a = 2;
    }

    @Deprecated
    public static fl a(gn gnVar, String str) {
        int i;
        fl flVar = new fl();
        try {
            i = Integer.parseInt(gnVar.k());
        } catch (Exception e) {
            AbstractC7535b.m586a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        flVar.a(i);
        flVar.a(gnVar.j());
        flVar.c(gnVar.m());
        flVar.b(gnVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gnVar.mo926a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            AbstractC7535b.m586a("Blob setPayload err： " + e2.getMessage());
        }
        return flVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static fl a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            dx.C7635a c7635a = new dx.C7635a();
            c7635a.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new fl(c7635a, s, bArr);
        } catch (Exception e) {
            AbstractC7535b.m586a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public int a() {
        return this.f363a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m888a() {
        return this.f363a.m787c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo889a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f366a);
        byteBuffer.putShort((short) this.f363a.a());
        byteBuffer.putInt(this.f367b.length);
        int position = byteBuffer.position();
        this.f363a.m851a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f363a.a());
        byteBuffer.position(position + this.f363a.a());
        byteBuffer.put(this.f367b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m890a() {
        return this.f366a;
    }

    public void a(int i) {
        this.f363a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f363a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f363a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f363a.b(str2);
    }

    public void a(String str) {
        this.f363a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f363a.c(str);
        this.f363a.m782a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f363a.d(str2);
    }

    public void a(short s) {
        this.f366a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f363a.c(0);
            this.f367b = bArr;
            return;
        }
        this.f363a.c(1);
        this.f367b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m891a() {
        return this.f363a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m892a() {
        return fm.a(this, this.f367b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m893a(String str) {
        if (this.f363a.e() == 1) {
            return fm.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f367b));
        }
        if (this.f363a.e() == 0) {
            return fm.a(this, this.f367b);
        }
        AbstractC7535b.m586a("unknow cipher = " + this.f363a.e());
        return fm.a(this, this.f367b);
    }

    public int b() {
        return this.f363a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m894b() {
        return this.f363a.m789d();
    }

    public void b(int i) {
        com.xiaomi.push.service.ao aoVar = new com.xiaomi.push.service.ao();
        this.f364a = aoVar;
        aoVar.a = i;
    }

    public void b(String str) {
        this.f365a = str;
    }

    public int c() {
        return this.f363a.b() + 8 + this.f367b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m895c() {
        return this.f363a.m793f();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf(m80.DINAMIC_PREFIX_AT);
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f363a.a(parseLong);
            this.f363a.a(substring);
            this.f363a.b(substring2);
        } catch (Exception e) {
            AbstractC7535b.m586a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m791e = this.f363a.m791e();
        if ("ID_NOT_AVAILABLE".equals(m791e)) {
            return null;
        }
        if (this.f363a.g()) {
            return m791e;
        }
        String d = d();
        this.f363a.e(d);
        return d;
    }

    public String f() {
        return this.f365a;
    }

    public String g() {
        if (this.f363a.m786b()) {
            return Long.toString(this.f363a.m781a()) + m80.DINAMIC_PREFIX_AT + this.f363a.m783a() + "/" + this.f363a.m785b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.bd.a(e()) + "; cmd=" + m888a() + "; type=" + ((int) m890a()) + "; from=" + g() + " ]";
    }
}
