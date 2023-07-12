package tb;

import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class n21 {
    @Nullable
    public static final Object a(@Nullable Object obj, @NotNull CallableMemberDescriptor callableMemberDescriptor) {
        z71 e;
        Class<?> i;
        Method f;
        b41.i(callableMemberDescriptor, "descriptor");
        return (((callableMemberDescriptor instanceof PropertyDescriptor) && q21.d((VariableDescriptor) callableMemberDescriptor)) || (e = e(callableMemberDescriptor)) == null || (i = i(e)) == null || (f = f(i, callableMemberDescriptor)) == null) ? obj : f.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (tb.q21.c(r0) != true) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
        if (g(r6) == false) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <M extends java.lang.reflect.Member> kotlin.reflect.jvm.internal.calls.Caller<M> b(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.Caller<? extends M> r5, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6, boolean r7) {
        /*
            java.lang.String r0 = "$this$createInlineClassAwareCallerIfNeeded"
            tb.b41.i(r5, r0)
            java.lang.String r0 = "descriptor"
            tb.b41.i(r6, r0)
            boolean r0 = tb.q21.a(r6)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L64
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r3 = "descriptor.valueParameters"
            tb.b41.h(r0, r3)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L27
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L27
        L25:
            r0 = 0
            goto L4c
        L27:
            java.util.Iterator r0 = r0.iterator()
        L2b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L25
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r3
            java.lang.String r4 = "it"
            tb.b41.h(r3, r4)
            tb.z71 r3 = r3.getType()
            java.lang.String r4 = "it.type"
            tb.b41.h(r3, r4)
            boolean r3 = tb.q21.c(r3)
            if (r3 == 0) goto L2b
            r0 = 1
        L4c:
            if (r0 != 0) goto L64
            tb.z71 r0 = r6.getReturnType()
            if (r0 == 0) goto L5a
            boolean r0 = tb.q21.c(r0)
            if (r0 == r2) goto L64
        L5a:
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r0 != 0) goto L65
            boolean r0 = g(r6)
            if (r0 == 0) goto L65
        L64:
            r1 = 1
        L65:
            if (r1 == 0) goto L6d
            tb.m21 r0 = new tb.m21
            r0.<init>(r6, r5, r7)
            r5 = r0
        L6d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.n21.b(kotlin.reflect.jvm.internal.calls.Caller, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, boolean):kotlin.reflect.jvm.internal.calls.Caller");
    }

    public static /* synthetic */ Caller c(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return b(caller, callableMemberDescriptor, z);
    }

    @NotNull
    public static final Method d(@NotNull Class<?> cls, @NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(cls, "$this$getBoxMethod");
        b41.i(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, callableMemberDescriptor).getReturnType());
            b41.h(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final z71 e(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            return dispatchReceiverParameter.getType();
        }
        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            return classDescriptor.getDefaultType();
        }
        return null;
    }

    @NotNull
    public static final Method f(@NotNull Class<?> cls, @NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(cls, "$this$getUnboxMethod");
        b41.i(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            b41.h(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final boolean g(CallableMemberDescriptor callableMemberDescriptor) {
        z71 e = e(callableMemberDescriptor);
        return e != null && q21.c(e);
    }

    @Nullable
    public static final Class<?> h(@Nullable DeclarationDescriptor declarationDescriptor) {
        if ((declarationDescriptor instanceof ClassDescriptor) && q21.b(declarationDescriptor)) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            Class<?> p = zv2.p(classDescriptor);
            if (p != null) {
                return p;
            }
            throw new KotlinReflectionInternalError("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + DescriptorUtilsKt.h((ClassifierDescriptor) declarationDescriptor) + ')');
        }
        return null;
    }

    @Nullable
    public static final Class<?> i(@NotNull z71 z71Var) {
        b41.i(z71Var, "$this$toInlineClass");
        return h(z71Var.c().getDeclarationDescriptor());
    }
}
