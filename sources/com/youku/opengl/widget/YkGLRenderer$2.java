package com.youku.opengl.widget;

import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLRenderer$2 implements Runnable {
    final /* synthetic */ h this$0;
    final /* synthetic */ c val$listener;

    YkGLRenderer$2(h hVar, c cVar) {
        this.this$0 = hVar;
        this.val$listener = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        arrayList = this.this$0.m;
        arrayList.remove(this.val$listener);
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "removeSurfaceListener() - removed listener:" + this.val$listener);
        }
    }
}
