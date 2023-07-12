package com.youku.opengl.widget;

import android.view.TextureView;
import com.youku.media.InterfaceC7967a;
import com.youku.media.InterfaceC7968b;
import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$1 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$1(C8040l.C8041a c8041a) {
        this.this$1 = c8041a;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8042m c8042m;
        C8042m c8042m2;
        C8042m c8042m3;
        c8042m = this.this$1.c;
        if (c8042m != null) {
            c8042m2 = this.this$1.c;
            c8042m2.a((InterfaceC7967a) null);
            c8042m3 = this.this$1.c;
            c8042m3.b((InterfaceC7968b) null);
        }
        if (this.this$1.b != null) {
            this.this$1.b.e();
        }
        this.this$1.d.i();
        this.this$1.d.a((TextureView.SurfaceTextureListener) null);
    }
}
