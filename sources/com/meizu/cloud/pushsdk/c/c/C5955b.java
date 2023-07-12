package com.meizu.cloud.pushsdk.c.c;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.c.g.C5982b;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5983c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.b */
/* loaded from: classes10.dex */
public class C5955b extends AbstractC5970j {
    private static final C5964g a = C5964g.a(IRequestConst.CONTENT_TYPE_POST);
    private final List<String> b;
    private final List<String> c;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$a */
    /* loaded from: classes10.dex */
    public static final class C5956a {
        private final List<String> a = new ArrayList();
        private final List<String> b = new ArrayList();

        public C5956a a(String str, String str2) {
            this.a.add(C5961f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.b.add(C5961f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public C5955b a() {
            return new C5955b(this.a, this.b);
        }

        public C5956a b(String str, String str2) {
            this.a.add(C5961f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.b.add(C5961f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    private C5955b(List<String> list, List<String> list2) {
        this.b = C5974m.a(list);
        this.c = C5974m.a(list2);
    }

    private long a(InterfaceC5983c interfaceC5983c, boolean z) {
        C5982b c5982b = z ? new C5982b() : interfaceC5983c.b();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                c5982b.b(38);
            }
            c5982b.b(this.b.get(i));
            c5982b.b(61);
            c5982b.b(this.c.get(i));
        }
        if (z) {
            long a2 = c5982b.a();
            c5982b.j();
            return a2;
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public C5964g a() {
        return a;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public void a(InterfaceC5983c interfaceC5983c) {
        a(interfaceC5983c, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public long b() {
        return a((InterfaceC5983c) null, true);
    }
}
