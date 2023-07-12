package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;
import tb.x02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KMutableProperty2Impl<D, E, V> extends KProperty2Impl<D, E, V> implements KMutableProperty2<D, E, V> {
    private final x02.C9895b<C8257a<D, E, V>> n;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.KMutableProperty2Impl$a */
    /* loaded from: classes3.dex */
    public static final class C8257a<D, E, V> extends KPropertyImpl.Setter<V> implements KMutableProperty2.Setter<D, E, V> {
        @NotNull
        private final KMutableProperty2Impl<D, E, V> h;

        public C8257a(@NotNull KMutableProperty2Impl<D, E, V> kMutableProperty2Impl) {
            b41.i(kMutableProperty2Impl, "property");
            this.h = kMutableProperty2Impl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ wt2 invoke(Object obj, Object obj2, Object obj3) {
            p(obj, obj2, obj3);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.AbstractC8261a
        @NotNull
        /* renamed from: o */
        public KMutableProperty2Impl<D, E, V> m() {
            return this.h;
        }

        public void p(D d, E e, V v) {
            m().set(d, e, v);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2) {
        super(kDeclarationContainerImpl, str, str2);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        x02.C9895b<C8257a<D, E, V>> b = x02.b(new Function0<C8257a<D, E, V>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty2Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty2Impl.C8257a<D, E, V> invoke() {
                return new KMutableProperty2Impl.C8257a<>(KMutableProperty2Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }

    @Override // kotlin.reflect.KMutableProperty2
    public void set(D d, E e, V v) {
        getSetter().call(d, e, v);
    }

    @Override // kotlin.reflect.KMutableProperty2, kotlin.reflect.KMutableProperty
    @NotNull
    /* renamed from: t */
    public C8257a<D, E, V> getSetter() {
        C8257a<D, E, V> invoke = this.n.invoke();
        b41.h(invoke, "_setter()");
        return invoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(propertyDescriptor, "descriptor");
        x02.C9895b<C8257a<D, E, V>> b = x02.b(new Function0<C8257a<D, E, V>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty2Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty2Impl.C8257a<D, E, V> invoke() {
                return new KMutableProperty2Impl.C8257a<>(KMutableProperty2Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }
}
