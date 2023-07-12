package com.youku.network.call;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.network.C7980b;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.b */
/* loaded from: classes13.dex */
public class C7988b {
    private C7987a a;
    private C7989c b;

    public C7988b(C7987a c7987a) {
        this.a = c7987a;
    }

    private C8004d b() {
        if (C7980b.a) {
            return null;
        }
        C8004d a = C8004d.a();
        a.a(AVFSCacheConstants.AVFS_ERROR_FILE_READ);
        return a;
    }

    public C8004d a() {
        C8004d b = b();
        return b != null ? b : this.b.a();
    }

    public void a(InterfaceC7974a interfaceC7974a) {
        C8004d b = b();
        if (b == null) {
            this.b.a(interfaceC7974a);
        } else if (interfaceC7974a != null) {
            interfaceC7974a.a(b);
        }
    }

    public void a(C7984c c7984c) {
        this.a.a(c7984c);
        this.b = new C7989c(this.a);
    }

    public void b(InterfaceC7974a interfaceC7974a) {
        C8004d b = b();
        if (b == null) {
            this.b.b(interfaceC7974a);
        } else if (interfaceC7974a != null) {
            interfaceC7974a.a(b);
        }
    }
}
