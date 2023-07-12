package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;
import tb.x02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KMutableProperty1Impl<T, V> extends KProperty1Impl<T, V> implements KMutableProperty1<T, V> {
    private final x02.C9895b<C8256a<T, V>> n;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.KMutableProperty1Impl$a */
    /* loaded from: classes3.dex */
    public static final class C8256a<T, V> extends KPropertyImpl.Setter<V> implements KMutableProperty1.Setter<T, V> {
        @NotNull
        private final KMutableProperty1Impl<T, V> h;

        public C8256a(@NotNull KMutableProperty1Impl<T, V> kMutableProperty1Impl) {
            b41.i(kMutableProperty1Impl, "property");
            this.h = kMutableProperty1Impl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ wt2 invoke(Object obj, Object obj2) {
            p(obj, obj2);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.AbstractC8261a
        @NotNull
        /* renamed from: o */
        public KMutableProperty1Impl<T, V> m() {
            return this.h;
        }

        public void p(T t, V v) {
            m().set(t, v);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        x02.C9895b<C8256a<T, V>> b = x02.b(new Function0<C8256a<T, V>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty1Impl.C8256a<T, V> invoke() {
                return new KMutableProperty1Impl.C8256a<>(KMutableProperty1Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void set(T t, V v) {
        getSetter().call(t, v);
    }

    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    @NotNull
    /* renamed from: t */
    public C8256a<T, V> getSetter() {
        C8256a<T, V> invoke = this.n.invoke();
        b41.h(invoke, "_setter()");
        return invoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(propertyDescriptor, "descriptor");
        x02.C9895b<C8256a<T, V>> b = x02.b(new Function0<C8256a<T, V>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty1Impl.C8256a<T, V> invoke() {
                return new KMutableProperty1Impl.C8256a<>(KMutableProperty1Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }
}
