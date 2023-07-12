package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.x02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class KProperty2Impl<D, E, V> extends KPropertyImpl<V> implements KProperty2<D, E, V> {
    private final x02.b<a<D, E, V>> l;
    private final Lazy<Field> m;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a<D, E, V> extends KPropertyImpl.Getter<V> implements KProperty2.Getter<D, E, V> {
        @NotNull
        private final KProperty2Impl<D, E, V> h;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull KProperty2Impl<D, E, ? extends V> kProperty2Impl) {
            b41.i(kProperty2Impl, "property");
            this.h = kProperty2Impl;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D d, E e) {
            return m().get(d, e);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.a
        @NotNull
        /* renamed from: o */
        public KProperty2Impl<D, E, V> m() {
            return this.h;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2) {
        super(kDeclarationContainerImpl, str, str2, CallableReference.NO_RECEIVER);
        Lazy<Field> a2;
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        x02.b<a<D, E, V>> b = x02.b(new Function0<a<D, E, ? extends V>>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$_getter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty2Impl.a<D, E, V> invoke() {
                return new KProperty2Impl.a<>(KProperty2Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
        a2 = b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$delegateField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Field invoke() {
                return KProperty2Impl.this.l();
            }
        });
        this.m = a2;
    }

    @Override // kotlin.reflect.KProperty2
    public V get(D d, E e) {
        return p().call(d, e);
    }

    @Override // kotlin.reflect.KProperty2
    @Nullable
    public Object getDelegate(D d, E e) {
        return n(this.m.getValue(), d);
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return get(d, e);
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl
    @NotNull
    /* renamed from: s */
    public a<D, E, V> p() {
        a<D, E, V> invoke = this.l.invoke();
        b41.h(invoke, "_getter()");
        return invoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Lazy<Field> a2;
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(propertyDescriptor, "descriptor");
        x02.b<a<D, E, V>> b = x02.b(new Function0<a<D, E, ? extends V>>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$_getter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty2Impl.a<D, E, V> invoke() {
                return new KProperty2Impl.a<>(KProperty2Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
        a2 = b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty2Impl$delegateField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Field invoke() {
                return KProperty2Impl.this.l();
            }
        });
        this.m = a2;
    }
}
