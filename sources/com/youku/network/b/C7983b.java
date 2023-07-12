package com.youku.network.b;

import com.youku.network.C7984c;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.youku.network.b.b */
/* loaded from: classes3.dex */
public class C7983b<T> implements InterfaceC7982a<T> {
    @Override // com.youku.network.b.InterfaceC7982a
    public void a(T t) {
        Map<String, String> k = ((C7984c) t).k();
        if (k == null || k.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, String>> it = k.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next == null || next.getKey() == null || next.getValue() == null) {
                it.remove();
            }
        }
    }
}
