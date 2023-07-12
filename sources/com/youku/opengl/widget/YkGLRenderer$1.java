package com.youku.opengl.widget;

import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLRenderer$1 implements Runnable {
    final /* synthetic */ h this$0;
    final /* synthetic */ c val$listener;

    YkGLRenderer$1(h hVar, c cVar) {
        this.this$0 = hVar;
        this.val$listener = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        arrayList = this.this$0.m;
        arrayList.add(this.val$listener);
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "addSurfaceListener() - added listener:" + this.val$listener);
        }
        this.val$listener.a();
        c cVar = this.val$listener;
        int[] iArr = this.this$0.b;
        cVar.a(iArr[0], iArr[1]);
    }
}
