package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$4 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ com.youku.media.a val$videoPlayer;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$4(l.a aVar, com.youku.media.a aVar2) {
        this.this$1 = aVar;
        this.val$videoPlayer = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        m mVar2;
        com.youku.media.b bVar;
        k kVar;
        k kVar2;
        n nVar;
        m mVar3;
        n nVar2;
        this.this$1.d.a(this.val$videoPlayer);
        mVar = this.this$1.c;
        mVar.a(this.this$1.d.h());
        mVar2 = this.this$1.c;
        mVar2.a(this.val$videoPlayer);
        bVar = l.this.e;
        if (bVar != null) {
            nVar = l.this.b;
            if (nVar != null) {
                mVar3 = this.this$1.c;
                nVar2 = l.this.b;
                mVar3.b(nVar2.h());
            }
        }
        kVar = this.this$1.f;
        if (kVar != null) {
            kVar2 = this.this$1.f;
            kVar2.a(this.val$videoPlayer);
        }
    }
}
