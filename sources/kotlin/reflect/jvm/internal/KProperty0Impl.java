package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.x02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class KProperty0Impl<V> extends KPropertyImpl<V> implements KProperty0<V> {
    private final x02.C9895b<C8258a<V>> l;
    private final Lazy<Object> m;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.KProperty0Impl$a */
    /* loaded from: classes3.dex */
    public static final class C8258a<R> extends KPropertyImpl.Getter<R> implements KProperty0.Getter<R> {
        @NotNull
        private final KProperty0Impl<R> h;

        /* JADX WARN: Multi-variable type inference failed */
        public C8258a(@NotNull KProperty0Impl<? extends R> kProperty0Impl) {
            b41.i(kProperty0Impl, "property");
            this.h = kProperty0Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return m().get();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.AbstractC8261a
        @NotNull
        /* renamed from: o */
        public KProperty0Impl<R> m() {
            return this.h;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Lazy<Object> a;
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(propertyDescriptor, "descriptor");
        x02.C9895b<C8258a<V>> b = x02.b(new Function0<C8258a<? extends V>>() { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$_getter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty0Impl.C8258a<V> invoke() {
                return new KProperty0Impl.C8258a<>(KProperty0Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
        a = C8177b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<Object>() { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$delegateFieldValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Object invoke() {
                KProperty0Impl kProperty0Impl = KProperty0Impl.this;
                return kProperty0Impl.n(kProperty0Impl.l(), KProperty0Impl.this.m());
            }
        });
        this.m = a;
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return p().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object getDelegate() {
        return this.m.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl
    @NotNull
    /* renamed from: s */
    public C8258a<V> p() {
        C8258a<V> invoke = this.l.invoke();
        b41.h(invoke, "_getter()");
        return invoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Lazy<Object> a;
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        x02.C9895b<C8258a<V>> b = x02.b(new Function0<C8258a<? extends V>>() { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$_getter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty0Impl.C8258a<V> invoke() {
                return new KProperty0Impl.C8258a<>(KProperty0Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
        a = C8177b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<Object>() { // from class: kotlin.reflect.jvm.internal.KProperty0Impl$delegateFieldValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Object invoke() {
                KProperty0Impl kProperty0Impl = KProperty0Impl.this;
                return kProperty0Impl.n(kProperty0Impl.l(), KProperty0Impl.this.m());
            }
        });
        this.m = a;
    }
}
