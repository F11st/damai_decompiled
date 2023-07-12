package com.youku.network.call;

import android.os.Handler;
import com.taobao.tao.remotebusiness.IRemoteListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class f implements IRemoteListener {
    private com.youku.network.a a;
    private Handler b;
    private com.youku.network.a.c c;
    private com.youku.network.d d;

    public f(com.youku.network.a aVar, Handler handler, com.youku.network.a.b bVar) {
        this.a = aVar;
        this.b = handler;
        this.c = (com.youku.network.a.c) bVar;
    }

    public f(com.youku.network.a aVar, com.youku.network.a.b bVar) {
        this(aVar, null, bVar);
    }

    private void a() {
        com.youku.network.a aVar = this.a;
        if (aVar != null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.youku.network.call.MTopBusinessListener$1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.youku.network.a aVar2;
                        com.youku.network.d dVar;
                        aVar2 = f.this.a;
                        dVar = f.this.d;
                        aVar2.a(dVar);
                    }
                });
            } else {
                aVar.a(this.d);
            }
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        this.d = this.c.a((com.youku.network.a.c) mtopResponse);
        a();
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        this.d = this.c.a((com.youku.network.a.c) mtopResponse);
        a();
    }
}
