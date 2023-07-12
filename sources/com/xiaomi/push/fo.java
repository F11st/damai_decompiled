package com.xiaomi.push;

import android.os.Build;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.dx;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fo {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fs f375a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f376a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f379a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f377a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f380b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f378a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(OutputStream outputStream, fs fsVar) {
        this.f376a = new BufferedOutputStream(outputStream);
        this.f375a = fsVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            AbstractC7535b.m586a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f377a.clear();
        int i = c + 8 + 4;
        if (i > this.f377a.capacity() || this.f377a.capacity() > 4096) {
            this.f377a = ByteBuffer.allocate(i);
        }
        this.f377a.putShort((short) -15618);
        this.f377a.putShort((short) 5);
        this.f377a.putInt(c);
        int position = this.f377a.position();
        this.f377a = flVar.mo889a(this.f377a);
        if (!"CONN".equals(flVar.m888a())) {
            if (this.f379a == null) {
                this.f379a = this.f375a.m903a();
            }
            com.xiaomi.push.service.bp.a(this.f379a, this.f377a.array(), true, position, c);
        }
        this.f378a.reset();
        this.f378a.update(this.f377a.array(), 0, this.f377a.position());
        this.f380b.putInt(0, (int) this.f378a.getValue());
        this.f376a.write(this.f377a.array(), 0, this.f377a.position());
        this.f376a.write(this.f380b.array(), 0, 4);
        this.f376a.flush();
        int position2 = this.f377a.position() + 4;
        AbstractC7535b.c("[Slim] Wrote {cmd=" + flVar.m888a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dx.C7639e c7639e = new dx.C7639e();
        c7639e.a(106);
        String model = Build.getMODEL();
        c7639e.a(model);
        c7639e.b(C7786v.m1246a());
        c7639e.c(com.xiaomi.push.service.bv.m1206a());
        c7639e.b(48);
        c7639e.d(this.f375a.m912b());
        c7639e.e(this.f375a.mo910a());
        c7639e.f(Locale.getDefault().toString());
        int i = Build.VERSION.SDK_INT;
        c7639e.c(i);
        byte[] mo918a = this.f375a.m909a().mo918a();
        if (mo918a != null) {
            c7639e.a(dx.C7636b.a(mo918a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(c7639e.m852a(), (String) null);
        a(flVar);
        AbstractC7535b.m586a("[slim] open conn: andver=" + i + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + model + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a(StandOutWindow.ACTION_CLOSE, (String) null);
        a(flVar);
        this.f376a.close();
    }
}
