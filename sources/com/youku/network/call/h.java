package com.youku.network.call;

import android.os.Handler;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class h implements MtopCallback.MtopFinishListener {
    private com.youku.network.a a;
    private Handler b;
    private com.youku.network.a.c c;
    private com.youku.network.d d;

    public h(com.youku.network.a aVar, Handler handler, com.youku.network.a.b bVar) {
        this.a = aVar;
        this.b = handler;
        this.c = (com.youku.network.a.c) bVar;
    }

    public h(com.youku.network.a aVar, com.youku.network.a.b bVar) {
        this(aVar, null, bVar);
    }

    private void a() {
        com.youku.network.a aVar = this.a;
        if (aVar != null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.youku.network.call.MTopListener$1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.youku.network.a aVar2;
                        com.youku.network.d dVar;
                        aVar2 = h.this.a;
                        dVar = h.this.d;
                        aVar2.a(dVar);
                    }
                });
            } else {
                aVar.a(this.d);
            }
        }
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        this.d = this.c.a((com.youku.network.a.c) mtopFinishEvent.getMtopResponse());
        a();
    }
}
