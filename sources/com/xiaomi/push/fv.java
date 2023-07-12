package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.Date;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fv implements fz {
    final /* synthetic */ fu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(fu fuVar) {
        this.a = fuVar;
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        AbstractC7535b.c("[Slim] " + this.a.f392a.format(new Date()) + " Connection started (" + this.a.f389a.hashCode() + jn1.BRACKET_END_STR);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        AbstractC7535b.c("[Slim] " + this.a.f392a.format(new Date()) + " Connection closed (" + this.a.f389a.hashCode() + jn1.BRACKET_END_STR);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        AbstractC7535b.c("[Slim] " + this.a.f392a.format(new Date()) + " Reconnection failed due to an exception (" + this.a.f389a.hashCode() + jn1.BRACKET_END_STR);
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        AbstractC7535b.c("[Slim] " + this.a.f392a.format(new Date()) + " Connection reconnected (" + this.a.f389a.hashCode() + jn1.BRACKET_END_STR);
    }
}
