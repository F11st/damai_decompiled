package com.youku.opengl.widget;

import com.youku.media.InterfaceC7967a;
import com.youku.media.InterfaceC7968b;
import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$4 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;
    final /* synthetic */ InterfaceC7967a val$videoPlayer;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$4(C8040l.C8041a c8041a, InterfaceC7967a interfaceC7967a) {
        this.this$1 = c8041a;
        this.val$videoPlayer = interfaceC7967a;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8042m c8042m;
        C8042m c8042m2;
        InterfaceC7968b interfaceC7968b;
        C8039k c8039k;
        C8039k c8039k2;
        C8043n c8043n;
        C8042m c8042m3;
        C8043n c8043n2;
        this.this$1.d.a(this.val$videoPlayer);
        c8042m = this.this$1.c;
        c8042m.a(this.this$1.d.h());
        c8042m2 = this.this$1.c;
        c8042m2.a(this.val$videoPlayer);
        interfaceC7968b = C8040l.this.e;
        if (interfaceC7968b != null) {
            c8043n = C8040l.this.b;
            if (c8043n != null) {
                c8042m3 = this.this$1.c;
                c8043n2 = C8040l.this.b;
                c8042m3.b(c8043n2.h());
            }
        }
        c8039k = this.this$1.f;
        if (c8039k != null) {
            c8039k2 = this.this$1.f;
            c8039k2.a(this.val$videoPlayer);
        }
    }
}
