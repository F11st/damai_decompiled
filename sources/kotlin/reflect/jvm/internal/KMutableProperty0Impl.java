package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;
import tb.x02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KMutableProperty0Impl<V> extends KProperty0Impl<V> implements KMutableProperty0<V> {
    private final x02.b<a<V>> n;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a<R> extends KPropertyImpl.Setter<R> implements KMutableProperty0.Setter<R> {
        @NotNull
        private final KMutableProperty0Impl<R> h;

        public a(@NotNull KMutableProperty0Impl<R> kMutableProperty0Impl) {
            b41.i(kMutableProperty0Impl, "property");
            this.h = kMutableProperty0Impl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ wt2 invoke(Object obj) {
            p(obj);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.a
        @NotNull
        /* renamed from: o */
        public KMutableProperty0Impl<R> m() {
            return this.h;
        }

        public void p(R r) {
            m().set(r);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(propertyDescriptor, "descriptor");
        x02.b<a<V>> b = x02.b(new Function0<a<V>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty0Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty0Impl.a<V> invoke() {
                return new KMutableProperty0Impl.a<>(KMutableProperty0Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(V v) {
        getSetter().call(v);
    }

    @Override // kotlin.reflect.KMutableProperty0, kotlin.reflect.KMutableProperty
    @NotNull
    /* renamed from: t */
    public a<V> getSetter() {
        a<V> invoke = this.n.invoke();
        b41.h(invoke, "_setter()");
        return invoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        x02.b<a<V>> b = x02.b(new Function0<a<V>>() { // from class: kotlin.reflect.jvm.internal.KMutableProperty0Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty0Impl.a<V> invoke() {
                return new KMutableProperty0Impl.a<>(KMutableProperty0Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Setter(this) }");
        this.n = b;
    }
}
