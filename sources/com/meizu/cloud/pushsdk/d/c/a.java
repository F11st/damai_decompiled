package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.f.d;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    private final List<com.meizu.cloud.pushsdk.d.a.b> a;
    private final long b;
    private final String c;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC0262a<T extends AbstractC0262a<T>> {
        private List<com.meizu.cloud.pushsdk.d.a.b> a = new LinkedList();
        private long b = System.currentTimeMillis();
        private String c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0262a<?> abstractC0262a) {
        d.a(((AbstractC0262a) abstractC0262a).a);
        d.a(((AbstractC0262a) abstractC0262a).c);
        d.a(!((AbstractC0262a) abstractC0262a).c.isEmpty(), "eventId cannot be empty");
        this.a = ((AbstractC0262a) abstractC0262a).a;
        this.b = ((AbstractC0262a) abstractC0262a).b;
        this.c = ((AbstractC0262a) abstractC0262a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.d.a.b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
