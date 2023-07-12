package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.c.AbstractC5970j;
import com.meizu.cloud.pushsdk.c.c.C5964g;
import com.meizu.cloud.pushsdk.c.d.InterfaceC5975a;
import com.meizu.cloud.pushsdk.c.f.C5980a;
import com.meizu.cloud.pushsdk.c.g.AbstractC5986f;
import com.meizu.cloud.pushsdk.c.g.C5982b;
import com.meizu.cloud.pushsdk.c.g.C5987g;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5983c;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5992l;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.e.b */
/* loaded from: classes10.dex */
public class C5977b extends AbstractC5970j {
    private final AbstractC5970j a;
    private InterfaceC5983c b;
    private HandlerC5979d c;

    public C5977b(AbstractC5970j abstractC5970j, InterfaceC5975a interfaceC5975a) {
        this.a = abstractC5970j;
        if (interfaceC5975a != null) {
            this.c = new HandlerC5979d(interfaceC5975a);
        }
    }

    private InterfaceC5992l a(InterfaceC5992l interfaceC5992l) {
        return new AbstractC5986f(interfaceC5992l) { // from class: com.meizu.cloud.pushsdk.c.e.b.1
            long a = 0;
            long b = 0;

            @Override // com.meizu.cloud.pushsdk.c.g.AbstractC5986f, com.meizu.cloud.pushsdk.c.g.InterfaceC5992l
            public void a(C5982b c5982b, long j) throws IOException {
                super.a(c5982b, j);
                if (this.b == 0) {
                    this.b = C5977b.this.b();
                }
                this.a += j;
                if (C5977b.this.c != null) {
                    C5977b.this.c.obtainMessage(1, new C5980a(this.a, this.b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public C5964g a() {
        return this.a.a();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public void a(InterfaceC5983c interfaceC5983c) throws IOException {
        if (this.b == null) {
            this.b = C5987g.a(a((InterfaceC5992l) interfaceC5983c));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public long b() throws IOException {
        return this.a.b();
    }
}
