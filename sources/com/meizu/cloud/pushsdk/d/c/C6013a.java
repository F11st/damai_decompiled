package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.C6000b;
import com.meizu.cloud.pushsdk.d.a.C6001c;
import com.meizu.cloud.pushsdk.d.f.C6031d;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.c.a */
/* loaded from: classes10.dex */
public class C6013a {
    private final List<C6000b> a;
    private final long b;
    private final String c;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC6014a<T extends AbstractC6014a<T>> {
        private List<C6000b> a = new LinkedList();
        private long b = System.currentTimeMillis();
        private String c = C6032e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C6013a(AbstractC6014a<?> abstractC6014a) {
        C6031d.a(((AbstractC6014a) abstractC6014a).a);
        C6031d.a(((AbstractC6014a) abstractC6014a).c);
        C6031d.a(!((AbstractC6014a) abstractC6014a).c.isEmpty(), "eventId cannot be empty");
        this.a = ((AbstractC6014a) abstractC6014a).a;
        this.b = ((AbstractC6014a) abstractC6014a).b;
        this.c = ((AbstractC6014a) abstractC6014a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C6001c a(C6001c c6001c) {
        c6001c.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        c6001c.a("ts", Long.toString(b()));
        return c6001c;
    }

    public List<C6000b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
