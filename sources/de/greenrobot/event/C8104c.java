package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: de.greenrobot.event.c */
/* loaded from: classes3.dex */
final class C8104c {
    private static final List<C8104c> d = new ArrayList();
    Object a;
    C8108g b;
    C8104c c;

    private C8104c(Object obj, C8108g c8108g) {
        this.a = obj;
        this.b = c8108g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C8104c a(C8108g c8108g, Object obj) {
        List<C8104c> list = d;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                C8104c remove = list.remove(size - 1);
                remove.a = obj;
                remove.b = c8108g;
                remove.c = null;
                return remove;
            }
            return new C8104c(obj, c8108g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(C8104c c8104c) {
        c8104c.a = null;
        c8104c.b = null;
        c8104c.c = null;
        List<C8104c> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(c8104c);
            }
        }
    }
}
