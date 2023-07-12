package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.c */
/* loaded from: classes3.dex */
public class C8447c {
    private static final C8447c b = new C8447c(true);
    private final Map<C8448a, GeneratedMessageLite.C8441c<?, ?>> a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.c$a */
    /* loaded from: classes3.dex */
    private static final class C8448a {
        private final Object a;
        private final int b;

        C8448a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C8448a) {
                C8448a c8448a = (C8448a) obj;
                return this.a == c8448a.a && this.b == c8448a.b;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    C8447c() {
        this.a = new HashMap();
    }

    public static C8447c c() {
        return b;
    }

    public static C8447c d() {
        return new C8447c();
    }

    public final void a(GeneratedMessageLite.C8441c<?, ?> c8441c) {
        this.a.put(new C8448a(c8441c.b(), c8441c.d()), c8441c);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.C8441c<ContainingType, ?> b(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.C8441c<ContainingType, ?>) this.a.get(new C8448a(containingtype, i));
    }

    private C8447c(boolean z) {
        this.a = Collections.emptyMap();
    }
}
