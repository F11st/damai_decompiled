package tb;

import anet.channel.security.ISecurity;
import anet.channel.security.ISecurityFactory;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class aa2 {
    private static volatile ISecurityFactory a;

    /* compiled from: Taobao */
    /* renamed from: tb.aa2$a */
    /* loaded from: classes.dex */
    static class C8902a implements ISecurityFactory {
        C8902a() {
        }

        @Override // anet.channel.security.ISecurityFactory
        public ISecurity createNonSecurity(String str) {
            return new tk1(str);
        }

        @Override // anet.channel.security.ISecurityFactory
        public ISecurity createSecurity(String str) {
            return new z92(str);
        }
    }

    public static ISecurityFactory a() {
        if (a == null) {
            a = new C8902a();
        }
        return a;
    }
}
