package com.xiaomi.push;

import com.xiaomi.push.dx;
import com.xiaomi.push.fw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fu implements gi {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private fw f389a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f392a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f388a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fz f390a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f391a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements gb, gj {

        /* renamed from: a  reason: collision with other field name */
        String f393a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f394a;

        a(boolean z) {
            this.f394a = true;
            this.f394a = z;
            this.f393a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.gb
        public void a(fl flVar) {
            StringBuilder sb;
            String str;
            if (fu.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                str = flVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                sb.append(" Blob [");
                sb.append(flVar.m888a());
                sb.append(",");
                sb.append(flVar.a());
                sb.append(",");
                sb.append(com.xiaomi.push.service.bd.a(flVar.e()));
                str = jn1.ARRAY_END_STR;
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            if (flVar == null || flVar.a() != 99999) {
                return;
            }
            String m888a = flVar.m888a();
            fl flVar2 = null;
            if (!this.f394a) {
                if ("BIND".equals(m888a)) {
                    com.xiaomi.channel.commonutils.logger.b.m586a("build binded result for loopback.");
                    dx.d dVar = new dx.d();
                    dVar.a(true);
                    dVar.c("login success.");
                    dVar.b("success");
                    dVar.a("success");
                    fl flVar3 = new fl();
                    flVar3.a(dVar.m852a(), (String) null);
                    flVar3.a((short) 2);
                    flVar3.a(99999);
                    flVar3.a("BIND", (String) null);
                    flVar3.a(flVar.e());
                    flVar3.b((String) null);
                    flVar3.c(flVar.g());
                    flVar2 = flVar3;
                } else if (!"UBND".equals(m888a) && "SECMSG".equals(m888a)) {
                    fl flVar4 = new fl();
                    flVar4.a(99999);
                    flVar4.a("SECMSG", (String) null);
                    flVar4.c(flVar.g());
                    flVar4.a(flVar.e());
                    flVar4.a(flVar.m890a());
                    flVar4.b(flVar.f());
                    flVar4.a(flVar.m893a(com.xiaomi.push.service.bg.a().a(String.valueOf(99999), flVar.g()).h), (String) null);
                    flVar2 = flVar4;
                }
            }
            if (flVar2 != null) {
                for (Map.Entry<gb, fw.a> entry : fu.this.f389a.m911a().entrySet()) {
                    if (fu.this.f388a != entry.getKey()) {
                        entry.getValue().a(flVar2);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.gb
        public void a(gn gnVar) {
            StringBuilder sb;
            String str;
            if (fu.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                sb.append(" PKT ");
                str = gnVar.mo926a();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fu.this.f392a.format(new Date()));
                sb.append(this.f393a);
                sb.append(" PKT [");
                sb.append(gnVar.k());
                sb.append(",");
                sb.append(gnVar.j());
                str = jn1.ARRAY_END_STR;
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        }

        @Override // com.xiaomi.push.gj
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo906a(gn gnVar) {
            return true;
        }
    }

    public fu(fw fwVar) {
        this.f389a = null;
        this.f389a = fwVar;
        a();
    }

    private void a() {
        this.f388a = new a(true);
        this.b = new a(false);
        fw fwVar = this.f389a;
        a aVar = this.f388a;
        fwVar.a(aVar, aVar);
        fw fwVar2 = this.f389a;
        a aVar2 = this.b;
        fwVar2.b(aVar2, aVar2);
        this.f390a = new fv(this);
    }
}
