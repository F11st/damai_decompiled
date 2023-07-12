package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fn;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaPropertyInitializerEvaluator {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements JavaPropertyInitializerEvaluator {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator
        @Nullable
        public fn<?> getInitializerConstant(@NotNull JavaField javaField, @NotNull PropertyDescriptor propertyDescriptor) {
            b41.i(javaField, "field");
            b41.i(propertyDescriptor, "descriptor");
            return null;
        }
    }

    @Nullable
    fn<?> getInitializerConstant(@NotNull JavaField javaField, @NotNull PropertyDescriptor propertyDescriptor);
}
