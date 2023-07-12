package com.youku.opengl.widget;

import com.youku.opengl.filter.C8020b;
import com.youku.opengl.filter.C8021c;
import com.youku.opengl.filter.C8023e;
import com.youku.opengl.widget.C8040l;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLVideoSurfaceView$YkGLForegroundVideoSurface$3 implements Runnable {
    final /* synthetic */ C8040l.C8041a this$1;
    final /* synthetic */ C8020b val$filter;

    YkGLVideoSurfaceView$YkGLForegroundVideoSurface$3(C8040l.C8041a c8041a, C8020b c8020b) {
        this.this$1 = c8041a;
        this.val$filter = c8020b;
    }

    @Override // java.lang.Runnable
    public void run() {
        C8039k c8039k;
        C8042m c8042m;
        C8034h c8034h;
        C8039k c8039k2;
        C8021c c8021c = new C8021c();
        c8021c.a(new C8023e());
        c8021c.a(this.val$filter);
        c8039k = this.this$1.f;
        if (c8039k != null) {
            c8039k2 = this.this$1.f;
            c8021c.a(c8039k2);
        }
        c8042m = this.this$1.c;
        c8021c.a(c8042m);
        this.this$1.b = c8021c;
        c8034h = this.this$1.e;
        c8034h.a(this.this$1.b);
    }
}
