package com.youku.opengl.widget;

import android.view.TextureView;
import com.youku.opengl.widget.l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$1 implements Runnable {
    final /* synthetic */ l.a this$1;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$1(l.a aVar) {
        this.this$1 = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        m mVar2;
        m mVar3;
        mVar = this.this$1.c;
        if (mVar != null) {
            mVar2 = this.this$1.c;
            mVar2.a((com.youku.media.a) null);
            mVar3 = this.this$1.c;
            mVar3.b((com.youku.media.b) null);
        }
        if (this.this$1.b != null) {
            this.this$1.b.e();
        }
        this.this$1.d.i();
        this.this$1.d.a((TextureView.SurfaceTextureListener) null);
    }
}
