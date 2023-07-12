package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.x02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class KProperty1Impl<T, V> extends KPropertyImpl<V> implements KProperty1<T, V> {
    private final x02.C9895b<C8259a<T, V>> l;
    private final Lazy<Field> m;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.KProperty1Impl$a */
    /* loaded from: classes3.dex */
    public static final class C8259a<T, V> extends KPropertyImpl.Getter<V> implements KProperty1.Getter<T, V> {
        @NotNull
        private final KProperty1Impl<T, V> h;

        /* JADX WARN: Multi-variable type inference failed */
        public C8259a(@NotNull KProperty1Impl<T, ? extends V> kProperty1Impl) {
            b41.i(kProperty1Impl, "property");
            this.h = kProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T t) {
            return m().get(t);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.AbstractC8261a
        @NotNull
        /* renamed from: o */
        public KProperty1Impl<T, V> m() {
            return this.h;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Lazy<Field> a;
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        x02.C9895b<C8259a<T, V>> b = x02.b(new Function0<C8259a<T, ? extends V>>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$_getter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty1Impl.C8259a<T, V> invoke() {
                return new KProperty1Impl.C8259a<>(KProperty1Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
        a = C8177b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$delegateField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Field invoke() {
                return KProperty1Impl.this.l();
            }
        });
        this.m = a;
    }

    @Override // kotlin.reflect.KProperty1
    public V get(T t) {
        return p().call(t);
    }

    @Override // kotlin.reflect.KProperty1
    @Nullable
    public Object getDelegate(T t) {
        return n(this.m.getValue(), t);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return get(t);
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl
    @NotNull
    /* renamed from: s */
    public C8259a<T, V> p() {
        C8259a<T, V> invoke = this.l.invoke();
        b41.h(invoke, "_getter()");
        return invoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Lazy<Field> a;
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(propertyDescriptor, "descriptor");
        x02.C9895b<C8259a<T, V>> b = x02.b(new Function0<C8259a<T, ? extends V>>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$_getter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KProperty1Impl.C8259a<T, V> invoke() {
                return new KProperty1Impl.C8259a<>(KProperty1Impl.this);
            }
        });
        b41.h(b, "ReflectProperties.lazy { Getter(this) }");
        this.l = b;
        a = C8177b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KProperty1Impl$delegateField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Field invoke() {
                return KProperty1Impl.this.l();
            }
        });
        this.m = a;
    }
}
