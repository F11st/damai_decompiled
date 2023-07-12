package com.uploader.implement.a;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alipay.sdk.m.k.C4226b;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.HashSet;
import java.util.Set;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.a.c */
/* loaded from: classes11.dex */
public class C7367c {
    private static volatile boolean v;
    private static volatile boolean w;
    private static final byte[] x = new byte[0];
    final boolean a;
    long b;
    long c;
    String d;
    String e;
    int f;
    int g;
    String h;
    String i;
    String j;
    long k;
    long l;
    long m;
    long n;
    long o;
    String p;
    String q;
    int r;
    long s;
    int t;
    private C7367c u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7367c(boolean z, C7367c c7367c) {
        this.a = z;
        this.u = c7367c;
    }

    private Set<String> b() {
        HashSet hashSet = new HashSet();
        hashSet.add(C4226b.l);
        hashSet.add("token");
        hashSet.add(YKUpsConvert.FILEID);
        hashSet.add(TbAuthConstants.IP);
        hashSet.add("port");
        hashSet.add("ret");
        hashSet.add("errorcode");
        hashSet.add("subcode");
        hashSet.add("errormsg");
        hashSet.add("retrytimes");
        if (!this.a) {
            hashSet.add(AgooConstants.MESSAGE_ENCRYPTED);
        }
        return hashSet;
    }

    private Set<String> c() {
        HashSet hashSet = new HashSet();
        hashSet.add("connecttime");
        hashSet.add("costtime");
        hashSet.add("size");
        hashSet.add("speed");
        hashSet.add("totaltime");
        hashSet.add("md5time");
        hashSet.add("upstream");
        hashSet.add("downstream");
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a() {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploader.implement.a.C7367c.a():java.lang.String");
    }
}
