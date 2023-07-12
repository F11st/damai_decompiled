package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.lm;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface SyntheticJavaPartsProvider {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();
        @NotNull
        private static final lm b;

        static {
            List g;
            g = m.g();
            b = new lm(g);
        }

        private a() {
        }

        @NotNull
        public final lm a() {
            return b;
        }
    }

    void generateConstructors(@NotNull ClassDescriptor classDescriptor, @NotNull List<ClassConstructorDescriptor> list);

    void generateMethods(@NotNull ClassDescriptor classDescriptor, @NotNull ni1 ni1Var, @NotNull Collection<SimpleFunctionDescriptor> collection);

    void generateStaticFunctions(@NotNull ClassDescriptor classDescriptor, @NotNull ni1 ni1Var, @NotNull Collection<SimpleFunctionDescriptor> collection);

    @NotNull
    List<ni1> getMethodNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    List<ni1> getStaticFunctionNames(@NotNull ClassDescriptor classDescriptor);
}
