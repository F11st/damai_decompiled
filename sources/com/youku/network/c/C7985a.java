package com.youku.network.c;

import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.youku.network.c.a */
/* loaded from: classes13.dex */
public class C7985a {
    private static volatile boolean a;
    private static List<InterfaceC7986a> b = new LinkedList();

    /* compiled from: Taobao */
    /* renamed from: com.youku.network.c.a$a */
    /* loaded from: classes13.dex */
    public interface InterfaceC7986a {
    }

    public static void a(InterfaceC7986a interfaceC7986a) {
        if (interfaceC7986a != null) {
            b.remove(interfaceC7986a);
        }
    }
}
