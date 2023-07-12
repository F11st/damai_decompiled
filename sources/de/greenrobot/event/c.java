package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class c {
    private static final List<c> d = new ArrayList();
    Object a;
    g b;
    c c;

    private c(Object obj, g gVar) {
        this.a = obj;
        this.b = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(g gVar, Object obj) {
        List<c> list = d;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                c remove = list.remove(size - 1);
                remove.a = obj;
                remove.b = gVar;
                remove.c = null;
                return remove;
            }
            return new c(obj, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(c cVar) {
        cVar.a = null;
        cVar.b = null;
        cVar.c = null;
        List<c> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(cVar);
            }
        }
    }
}
