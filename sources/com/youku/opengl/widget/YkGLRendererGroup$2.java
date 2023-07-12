package com.youku.opengl.widget;

import com.youku.opengl.a.C8013a;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLRendererGroup$2 implements Runnable {
    final /* synthetic */ C8035i this$0;
    final /* synthetic */ AbstractC8031e val$renderer;

    YkGLRendererGroup$2(C8035i c8035i, AbstractC8031e abstractC8031e) {
        this.this$0 = c8035i;
        this.val$renderer = abstractC8031e;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        arrayList = this.this$0.e;
        arrayList.remove(this.val$renderer);
        if (C8013a.b) {
            C8013a.a("YkGLRendererGroup", "removeRenderer() - removed render:" + this.val$renderer);
        }
    }
}
