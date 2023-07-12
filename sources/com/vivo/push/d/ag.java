package com.vivo.push.d;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ag {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.push.l a(com.vivo.push.o r2) {
        /*
            int r0 = r2.b()
            r1 = 20
            if (r0 == r1) goto L80
            r1 = 100
            if (r0 == r1) goto L7a
            r1 = 101(0x65, float:1.42E-43)
            if (r0 == r1) goto L74
            switch(r0) {
                case 0: goto L6d;
                case 1: goto L67;
                case 2: goto L61;
                case 3: goto L5b;
                case 4: goto L55;
                case 5: goto L4f;
                case 6: goto L49;
                case 7: goto L43;
                case 8: goto L3d;
                case 9: goto L37;
                case 10: goto L31;
                case 11: goto L2b;
                case 12: goto L25;
                default: goto L13;
            }
        L13:
            switch(r0) {
                case 2000: goto L6d;
                case 2001: goto L6d;
                case 2002: goto L6d;
                case 2003: goto L6d;
                case 2004: goto L6d;
                case 2005: goto L6d;
                case 2006: goto L1f;
                case 2007: goto L19;
                case 2008: goto L6d;
                case 2009: goto L6d;
                case 2010: goto L6d;
                case 2011: goto L6d;
                case 2012: goto L6d;
                case 2013: goto L6d;
                case 2014: goto L6d;
                case 2015: goto L6d;
                default: goto L16;
            }
        L16:
            r2 = 0
            goto L86
        L19:
            com.vivo.push.d.ai r0 = new com.vivo.push.d.ai
            r0.<init>(r2)
            goto L72
        L1f:
            com.vivo.push.d.a r0 = new com.vivo.push.d.a
            r0.<init>(r2)
            goto L72
        L25:
            com.vivo.push.d.f r0 = new com.vivo.push.d.f
            r0.<init>(r2)
            goto L72
        L2b:
            com.vivo.push.d.ad r0 = new com.vivo.push.d.ad
            r0.<init>(r2)
            goto L72
        L31:
            com.vivo.push.d.d r0 = new com.vivo.push.d.d
            r0.<init>(r2)
            goto L72
        L37:
            com.vivo.push.d.g r0 = new com.vivo.push.d.g
            r0.<init>(r2)
            goto L72
        L3d:
            com.vivo.push.d.l r0 = new com.vivo.push.d.l
            r0.<init>(r2)
            goto L72
        L43:
            com.vivo.push.d.n r0 = new com.vivo.push.d.n
            r0.<init>(r2)
            goto L72
        L49:
            com.vivo.push.d.x r0 = new com.vivo.push.d.x
            r0.<init>(r2)
            goto L72
        L4f:
            com.vivo.push.d.u r0 = new com.vivo.push.d.u
            r0.<init>(r2)
            goto L72
        L55:
            com.vivo.push.d.r r0 = new com.vivo.push.d.r
            r0.<init>(r2)
            goto L72
        L5b:
            com.vivo.push.d.p r0 = new com.vivo.push.d.p
            r0.<init>(r2)
            goto L72
        L61:
            com.vivo.push.d.h r0 = new com.vivo.push.d.h
            r0.<init>(r2)
            goto L72
        L67:
            com.vivo.push.d.aa r0 = new com.vivo.push.d.aa
            r0.<init>(r2)
            goto L72
        L6d:
            com.vivo.push.d.ah r0 = new com.vivo.push.d.ah
            r0.<init>(r2)
        L72:
            r2 = r0
            goto L86
        L74:
            com.vivo.push.d.c r0 = new com.vivo.push.d.c
            r0.<init>(r2)
            goto L72
        L7a:
            com.vivo.push.d.b r0 = new com.vivo.push.d.b
            r0.<init>(r2)
            goto L72
        L80:
            com.vivo.push.d.af r0 = new com.vivo.push.d.af
            r0.<init>(r2)
            goto L72
        L86:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.d.ag.a(com.vivo.push.o):com.vivo.push.l");
    }

    public static z b(com.vivo.push.o oVar) {
        z afVar;
        int b = oVar.b();
        if (b == 20) {
            afVar = new af(oVar);
        } else if (b != 2016) {
            switch (b) {
                case 1:
                    afVar = new aa(oVar);
                    break;
                case 2:
                    afVar = new h(oVar);
                    break;
                case 3:
                    afVar = new p(oVar);
                    break;
                case 4:
                    afVar = new r(oVar);
                    break;
                case 5:
                    afVar = new u(oVar);
                    break;
                case 6:
                    afVar = new x(oVar);
                    break;
                case 7:
                    afVar = new n(oVar);
                    break;
                case 8:
                    afVar = new l(oVar);
                    break;
                case 9:
                    afVar = new g(oVar);
                    break;
                case 10:
                    afVar = new d(oVar);
                    break;
                case 11:
                    afVar = new ad(oVar);
                    break;
                default:
                    return null;
            }
        } else {
            afVar = new k(oVar);
        }
        return afVar;
    }
}
