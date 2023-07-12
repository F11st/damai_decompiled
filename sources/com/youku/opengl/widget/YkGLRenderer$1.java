package com.youku.opengl.widget;

import com.youku.opengl.a.C8013a;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YkGLRenderer$1 implements Runnable {
    final /* synthetic */ C8034h this$0;
    final /* synthetic */ InterfaceC8029c val$listener;

    YkGLRenderer$1(C8034h c8034h, InterfaceC8029c interfaceC8029c) {
        this.this$0 = c8034h;
        this.val$listener = interfaceC8029c;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        arrayList = this.this$0.m;
        arrayList.add(this.val$listener);
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "addSurfaceListener() - added listener:" + this.val$listener);
        }
        this.val$listener.a();
        InterfaceC8029c interfaceC8029c = this.val$listener;
        int[] iArr = this.this$0.b;
        interfaceC8029c.a(iArr[0], iArr[1]);
    }
}
