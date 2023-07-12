package com.youku.opengl.widget;

import android.os.Handler;
import com.youku.opengl.a.C8013a;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.youku.opengl.widget.g */
/* loaded from: classes13.dex */
public class C8033g {
    private final Handler a;
    private ArrayList<InterfaceC8028b> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final C8032f c8032f) {
        final ArrayList arrayList;
        synchronized (this.b) {
            arrayList = (ArrayList) this.b.clone();
        }
        this.a.post(new Runnable() { // from class: com.youku.opengl.widget.YkGLEventDispatcher$1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC8028b interfaceC8028b = (InterfaceC8028b) it.next();
                    if (C8013a.b) {
                        C8013a.a("YkGLEventDispatcher", "dispatchEvent() - notifying listener:" + interfaceC8028b);
                    }
                    interfaceC8028b.a(c8032f);
                    if (C8013a.b) {
                        C8013a.a("YkGLEventDispatcher", "dispatchEvent() - notified listener:" + interfaceC8028b);
                    }
                }
            }
        });
    }
}
