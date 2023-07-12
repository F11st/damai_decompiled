package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.dx;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fn {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private fs f369a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f370a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f373a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f374a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f371a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f372a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private fq f368a = new fq();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(InputStream inputStream, fs fsVar, Context context) {
        this.f370a = new BufferedInputStream(inputStream);
        this.f369a = fsVar;
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.nio.ByteBuffer a() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fn.a():java.nio.ByteBuffer");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f370a.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void c() {
        String str;
        StringBuilder sb;
        boolean z = false;
        this.f373a = false;
        fl m896a = m896a();
        if ("CONN".equals(m896a.m888a())) {
            dx.C7640f a = dx.C7640f.a(m896a.m892a());
            if (a.m827a()) {
                this.f369a.a(a.m826a());
                z = true;
            }
            if (a.c()) {
                dx.C7636b m825a = a.m825a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(m825a.m852a(), (String) null);
                this.f369a.a(flVar);
            }
            AbstractC7535b.m586a("[Slim] CONN: host = " + a.m828b());
        }
        if (!z) {
            AbstractC7535b.m586a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f374a = this.f369a.m903a();
        while (!this.f373a) {
            fl m896a2 = m896a();
            this.f369a.c();
            short m890a = m896a2.m890a();
            if (m890a != 1) {
                if (m890a != 2) {
                    if (m890a != 3) {
                        str = "[Slim] unknow blob type " + ((int) m896a2.m890a());
                        AbstractC7535b.m586a(str);
                    } else {
                        try {
                            this.f369a.b(this.f368a.a(m896a2.m892a(), this.f369a));
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m896a2.a());
                            sb.append("; Id=");
                            sb.append(m896a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            AbstractC7535b.m586a(str);
                        }
                    }
                } else if ("SECMSG".equals(m896a2.m888a()) && ((m896a2.a() == 2 || m896a2.a() == 3) && TextUtils.isEmpty(m896a2.m894b()))) {
                    try {
                        this.f369a.b(this.f368a.a(m896a2.m893a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m896a2.a()).toString(), m896a2.g()).h), this.f369a));
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(m896a2.a());
                        sb.append("; Id=");
                        sb.append(m896a2.e());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        AbstractC7535b.m586a(str);
                    }
                } else if (m896a2.a() == 10) {
                    m896a2.b(10);
                    m896a2.f364a.f893a = C7787w.a(this.a);
                    m896a2.f364a.f895b = bj.e(this.a);
                    m896a2.f364a.f892a = System.currentTimeMillis();
                    AbstractC7535b.c("rcv blob from chid 10");
                }
            }
            this.f369a.a(m896a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m896a() {
        int i;
        try {
            ByteBuffer a = a();
            i = a.position();
            try {
                a.flip();
                a.position(8);
                fl frVar = i == 8 ? new fr() : fl.a(a.slice());
                AbstractC7535b.c("[Slim] Read {cmd=" + frVar.m888a() + ";chid=" + frVar.a() + ";len=" + i + "}");
                return frVar;
            } catch (IOException e) {
                e = e;
                if (i == 0) {
                    i = this.f371a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f371a.array();
                if (i > 128) {
                    i = 128;
                }
                sb.append(ai.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e.getMessage());
                AbstractC7535b.m586a(sb.toString());
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m897a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f373a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f373a = true;
    }
}
