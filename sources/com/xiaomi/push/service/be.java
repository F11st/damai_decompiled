package com.xiaomi.push.service;

import android.text.TextUtils;
import com.ali.user.mobile.rpc.ApiConstants;
import com.xiaomi.push.cv;
import com.xiaomi.push.df;
import com.xiaomi.push.dx;
import com.xiaomi.push.ez;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fx;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.hb;
import com.xiaomi.push.service.bg;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class be {
    private XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(gk gkVar) {
        String c = gkVar.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String[] split = c.split(";");
        com.xiaomi.push.cr a = cv.a().a(fx.a(), false);
        if (a == null || split.length <= 0) {
            return;
        }
        a.a(split);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(gn gnVar) {
        bg.b a;
        String l = gnVar.l();
        String k = gnVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a = bg.a().a(k, l)) == null) {
            return;
        }
        hb.a(this.a, a.f925a, hb.a(gnVar.mo926a()), true, true, System.currentTimeMillis());
    }

    private void c(fl flVar) {
        bg.b a;
        String g = flVar.g();
        String num = Integer.toString(flVar.a());
        if (TextUtils.isEmpty(g) || TextUtils.isEmpty(num) || (a = bg.a().a(num, g)) == null) {
            return;
        }
        hb.a(this.a, a.f925a, flVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fl flVar) {
        if (5 != flVar.a()) {
            c(flVar);
        }
        try {
            b(flVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + flVar.a() + " cmd = " + flVar.m888a() + " packetid = " + flVar.e() + " failure ", e);
        }
    }

    public void a(gn gnVar) {
        if (!"5".equals(gnVar.k())) {
            b(gnVar);
        }
        String k = gnVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            gnVar.l("1");
        }
        if (k.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m586a("Received wrong packet with chid = 0 : " + gnVar.mo926a());
        }
        if (gnVar instanceof gl) {
            gk a = gnVar.a("kick");
            if (a != null) {
                String l = gnVar.l();
                String a2 = a.a("type");
                String a3 = a.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m586a("kicked by server, chid=" + k + " res=" + bg.b.a(l) + " type=" + a2 + " reason=" + a3);
                if (!"wait".equals(a2)) {
                    this.a.a(k, l, 3, a3, a2);
                    bg.a().m1199a(k, l);
                    return;
                }
                bg.b a4 = bg.a().a(k, l);
                if (a4 != null) {
                    this.a.a(a4);
                    a4.a(bg.c.unbind, 3, 0, a3, a2);
                    return;
                }
                return;
            }
        } else if (gnVar instanceof gm) {
            gm gmVar = (gm) gnVar;
            if ("redir".equals(gmVar.b())) {
                gk a5 = gmVar.a("hosts");
                if (a5 != null) {
                    a(a5);
                    return;
                }
                return;
            }
        }
        this.a.m1152b().a(this.a, k, gnVar);
    }

    public void b(fl flVar) {
        StringBuilder sb;
        String m835a;
        String str;
        bg.c cVar;
        int i;
        int i2;
        String m888a = flVar.m888a();
        if (flVar.a() != 0) {
            String num = Integer.toString(flVar.a());
            if (!"SECMSG".equals(flVar.m888a())) {
                if (!"BIND".equals(m888a)) {
                    if ("KICK".equals(m888a)) {
                        dx.g a = dx.g.a(flVar.m892a());
                        String g = flVar.g();
                        String m830a = a.m830a();
                        String m832b = a.m832b();
                        com.xiaomi.channel.commonutils.logger.b.m586a("kicked by server, chid=" + num + " res= " + bg.b.a(g) + " type=" + m830a + " reason=" + m832b);
                        if (!"wait".equals(m830a)) {
                            this.a.a(num, g, 3, m832b, m830a);
                            bg.a().m1199a(num, g);
                            return;
                        }
                        bg.b a2 = bg.a().a(num, g);
                        if (a2 != null) {
                            this.a.a(a2);
                            a2.a(bg.c.unbind, 3, 0, m832b, m830a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                dx.d a3 = dx.d.a(flVar.m892a());
                String g2 = flVar.g();
                bg.b a4 = bg.a().a(num, g2);
                if (a4 == null) {
                    return;
                }
                if (a3.m809a()) {
                    com.xiaomi.channel.commonutils.logger.b.m586a("SMACK: channel bind succeeded, chid=" + flVar.a());
                    a4.a(bg.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String m808a = a3.m808a();
                if ("auth".equals(m808a)) {
                    if ("invalid-sig".equals(a3.m810b())) {
                        com.xiaomi.channel.commonutils.logger.b.m586a("SMACK: bind error invalid-sig token = " + a4.c + " sec = " + a4.h);
                        fj.a(0, ez.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = bg.c.unbind;
                    i = 1;
                    i2 = 5;
                } else if (!"cancel".equals(m808a)) {
                    if ("wait".equals(m808a)) {
                        this.a.a(a4);
                        a4.a(bg.c.unbind, 1, 7, a3.m810b(), m808a);
                    }
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m810b();
                    com.xiaomi.channel.commonutils.logger.b.m586a(str);
                } else {
                    cVar = bg.c.unbind;
                    i = 1;
                    i2 = 7;
                }
                a4.a(cVar, i, i2, a3.m810b(), m808a);
                bg.a().m1199a(num, g2);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m810b();
                com.xiaomi.channel.commonutils.logger.b.m586a(str);
            } else if (!flVar.m891a()) {
                this.a.m1152b().a(this.a, num, flVar);
                return;
            } else {
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(flVar.b());
                sb.append(" errStr = ");
                m835a = flVar.m895c();
            }
        } else if ("PING".equals(m888a)) {
            byte[] m892a = flVar.m892a();
            if (m892a != null && m892a.length > 0) {
                dx.j a5 = dx.j.a(m892a);
                if (a5.m843b()) {
                    bv.a().a(a5.m841a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.m1149a();
            }
            if ("1".equals(flVar.e())) {
                com.xiaomi.channel.commonutils.logger.b.m586a("received a server ping");
            } else {
                fj.b();
            }
            this.a.m1153b();
            return;
        } else if ("SYNC".equals(m888a)) {
            if ("CONF".equals(flVar.m894b())) {
                bv.a().a(dx.b.a(flVar.m892a()));
                return;
            } else if (TextUtils.equals("U", flVar.m894b())) {
                dx.k a6 = dx.k.a(flVar.m892a());
                df.a(this.a).a(a6.m845a(), a6.m848b(), new Date(a6.m844a()), new Date(a6.m847b()), a6.c() * 1024, a6.e());
                fl flVar2 = new fl();
                flVar2.a(0);
                flVar2.a(flVar.m888a(), "UCA");
                flVar2.a(flVar.e());
                XMPushService xMPushService = this.a;
                xMPushService.a(new bt(xMPushService, flVar2));
                return;
            } else if (!TextUtils.equals("P", flVar.m894b())) {
                return;
            } else {
                dx.i a7 = dx.i.a(flVar.m892a());
                fl flVar3 = new fl();
                flVar3.a(0);
                flVar3.a(flVar.m888a(), "PCA");
                flVar3.a(flVar.e());
                dx.i iVar = new dx.i();
                if (a7.m839a()) {
                    iVar.a(a7.m838a());
                }
                flVar3.a(iVar.m852a(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new bt(xMPushService2, flVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                m835a = flVar.e();
            }
        } else if (!ApiConstants.ResultActionType.NOTIFY.equals(flVar.m888a())) {
            return;
        } else {
            dx.h a8 = dx.h.a(flVar.m892a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a8.c());
            sb.append(" desc = ");
            m835a = a8.m835a();
        }
        sb.append(m835a);
        str = sb.toString();
        com.xiaomi.channel.commonutils.logger.b.m586a(str);
    }
}
