package com.youku.network.c;

import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class a {
    private static volatile boolean a;
    private static List<InterfaceC0395a> b = new LinkedList();

    /* compiled from: Taobao */
    /* renamed from: com.youku.network.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0395a {
    }

    public static void a(InterfaceC0395a interfaceC0395a) {
        if (interfaceC0395a != null) {
            b.remove(interfaceC0395a);
        }
    }
}
