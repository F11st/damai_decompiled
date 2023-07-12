package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FunctionsKt {
    @NotNull
    private static final Function1<Object, Boolean> a;
    @NotNull
    private static final Function3<Object, Object, Object, wt2> b;

    static {
        FunctionsKt$IDENTITY$1 functionsKt$IDENTITY$1 = new Function1<Object, Object>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$IDENTITY$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object invoke(@Nullable Object obj) {
                return obj;
            }
        };
        a = new Function1<Object, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_TRUE$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable Object obj) {
                return Boolean.TRUE;
            }
        };
        FunctionsKt$ALWAYS_NULL$1 functionsKt$ALWAYS_NULL$1 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_NULL$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@Nullable Object obj) {
                return null;
            }
        };
        FunctionsKt$DO_NOTHING$1 functionsKt$DO_NOTHING$1 = new Function1<Object, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(Object obj) {
                invoke2(obj);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
            }
        };
        FunctionsKt$DO_NOTHING_2$1 functionsKt$DO_NOTHING_2$1 = new Function2<Object, Object, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(Object obj, Object obj2) {
                invoke2(obj, obj2);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj, @Nullable Object obj2) {
            }
        };
        b = new Function3<Object, Object, Object, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_3$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ wt2 invoke(Object obj, Object obj2, Object obj3) {
                invoke2(obj, obj2, obj3);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
            }
        };
    }

    @NotNull
    public static final <T> Function1<T, Boolean> a() {
        return (Function1<T, Boolean>) a;
    }

    @NotNull
    public static final Function3<Object, Object, Object, wt2> b() {
        return b;
    }
}
