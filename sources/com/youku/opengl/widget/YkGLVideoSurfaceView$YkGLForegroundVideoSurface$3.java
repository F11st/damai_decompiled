package com.youku.opengl.widget;

import com.youku.opengl.widget.l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$3 implements Runnable {
    final /* synthetic */ l.a this$1;
    final /* synthetic */ com.youku.opengl.filter.b val$filter;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$3(l.a aVar, com.youku.opengl.filter.b bVar) {
        this.this$1 = aVar;
        this.val$filter = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        m mVar;
        h hVar;
        k kVar2;
        com.youku.opengl.filter.c cVar = new com.youku.opengl.filter.c();
        cVar.a(new com.youku.opengl.filter.e());
        cVar.a(this.val$filter);
        kVar = this.this$1.f;
        if (kVar != null) {
            kVar2 = this.this$1.f;
            cVar.a(kVar2);
        }
        mVar = this.this$1.c;
        cVar.a(mVar);
        this.this$1.b = cVar;
        hVar = this.this$1.e;
        hVar.a(this.this$1.b);
    }
}
