package com.youku.opengl.widget;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class g {
    private final Handler a;
    private ArrayList<b> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final f fVar) {
        final ArrayList arrayList;
        synchronized (this.b) {
            arrayList = (ArrayList) this.b.clone();
        }
        this.a.post(new Runnable() { // from class: com.youku.opengl.widget.YkGLEventDispatcher$1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (com.youku.opengl.a.a.b) {
                        com.youku.opengl.a.a.a("YkGLEventDispatcher", "dispatchEvent() - notifying listener:" + bVar);
                    }
                    bVar.a(fVar);
                    if (com.youku.opengl.a.a.b) {
                        com.youku.opengl.a.a.a("YkGLEventDispatcher", "dispatchEvent() - notified listener:" + bVar);
                    }
                }
            }
        });
    }
}
