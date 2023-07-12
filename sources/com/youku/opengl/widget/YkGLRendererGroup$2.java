package com.youku.opengl.widget;

import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLRendererGroup$2 implements Runnable {
    final /* synthetic */ i this$0;
    final /* synthetic */ e val$renderer;

    YkGLRendererGroup$2(i iVar, e eVar) {
        this.this$0 = iVar;
        this.val$renderer = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        arrayList = this.this$0.e;
        arrayList.remove(this.val$renderer);
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRendererGroup", "removeRenderer() - removed render:" + this.val$renderer);
        }
    }
}
