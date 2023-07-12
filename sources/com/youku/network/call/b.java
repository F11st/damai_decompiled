package com.youku.network.call;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    private a a;
    private c b;

    public b(a aVar) {
        this.a = aVar;
    }

    private com.youku.network.d b() {
        if (com.youku.network.b.a) {
            return null;
        }
        com.youku.network.d a = com.youku.network.d.a();
        a.a(AVFSCacheConstants.AVFS_ERROR_FILE_READ);
        return a;
    }

    public com.youku.network.d a() {
        com.youku.network.d b = b();
        return b != null ? b : this.b.a();
    }

    public void a(com.youku.network.a aVar) {
        com.youku.network.d b = b();
        if (b == null) {
            this.b.a(aVar);
        } else if (aVar != null) {
            aVar.a(b);
        }
    }

    public void a(com.youku.network.c cVar) {
        this.a.a(cVar);
        this.b = new c(this.a);
    }

    public void b(com.youku.network.a aVar) {
        com.youku.network.d b = b();
        if (b == null) {
            this.b.b(aVar);
        } else if (aVar != null) {
            aVar.a(b);
        }
    }
}
