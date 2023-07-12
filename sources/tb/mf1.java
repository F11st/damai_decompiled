package tb;

import java.util.List;
import kotlin.collections.C8212k;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class mf1 {
    private static final void a(StringBuilder sb, z71 z71Var) {
        sb.append(g(z71Var));
    }

    @NotNull
    public static final String b(@NotNull FunctionDescriptor functionDescriptor, boolean z, boolean z2) {
        String b;
        b41.i(functionDescriptor, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (functionDescriptor instanceof ConstructorDescriptor) {
                b = "<init>";
            } else {
                b = functionDescriptor.getName().b();
                b41.h(b, "name.asString()");
            }
            sb.append(b);
        }
        sb.append(jn1.BRACKET_START_STR);
        ReceiverParameterDescriptor extensionReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            z71 type = extensionReceiverParameter.getType();
            b41.h(type, "it.type");
            a(sb, type);
        }
        for (ValueParameterDescriptor valueParameterDescriptor : functionDescriptor.getValueParameters()) {
            z71 type2 = valueParameterDescriptor.getType();
            b41.h(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(jn1.BRACKET_END_STR);
        if (z) {
            if (w60.c(functionDescriptor)) {
                sb.append("V");
            } else {
                z71 returnType = functionDescriptor.getReturnType();
                b41.f(returnType);
                b41.h(returnType, "returnType!!");
                a(sb, returnType);
            }
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String c(FunctionDescriptor functionDescriptor, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return b(functionDescriptor, z, z2);
    }

    @Nullable
    public static final String d(@NotNull CallableDescriptor callableDescriptor) {
        b41.i(callableDescriptor, "<this>");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (d70.E(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || classDescriptor.getName().g()) {
            return null;
        }
        CallableDescriptor original = callableDescriptor.getOriginal();
        SimpleFunctionDescriptor simpleFunctionDescriptor = original instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor) original : null;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return lf1.a(signatureBuildingComponents, classDescriptor, c(simpleFunctionDescriptor, false, false, 3, null));
    }

    public static final boolean e(@NotNull CallableDescriptor callableDescriptor) {
        FunctionDescriptor k;
        b41.i(callableDescriptor, "f");
        if (callableDescriptor instanceof FunctionDescriptor) {
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
            if (b41.d(functionDescriptor.getName().b(), "remove") && functionDescriptor.getValueParameters().size() == 1 && !SpecialBuiltinMembers.h((CallableMemberDescriptor) callableDescriptor)) {
                List<ValueParameterDescriptor> valueParameters = functionDescriptor.getOriginal().getValueParameters();
                b41.h(valueParameters, "f.original.valueParameters");
                z71 type = ((ValueParameterDescriptor) C8212k.q0(valueParameters)).getType();
                b41.h(type, "f.original.valueParameters.single().type");
                c71 g = g(type);
                c71.C8993d c8993d = g instanceof c71.C8993d ? (c71.C8993d) g : null;
                if ((c8993d != null ? c8993d.i() : null) == JvmPrimitiveType.INT && (k = BuiltinMethodsWithSpecialGenericSignature.k(functionDescriptor)) != null) {
                    List<ValueParameterDescriptor> valueParameters2 = k.getOriginal().getValueParameters();
                    b41.h(valueParameters2, "overridden.original.valueParameters");
                    z71 type2 = ((ValueParameterDescriptor) C8212k.q0(valueParameters2)).getType();
                    b41.h(type2, "overridden.original.valueParameters.single().type");
                    c71 g2 = g(type2);
                    DeclarationDescriptor containingDeclaration = k.getContainingDeclaration();
                    b41.h(containingDeclaration, "overridden.containingDeclaration");
                    return b41.d(DescriptorUtilsKt.j(containingDeclaration), C8277c.C8278a.mutableCollection.j()) && (g2 instanceof c71.C8992c) && b41.d(((c71.C8992c) g2).i(), "java/lang/Object");
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @NotNull
    public static final String f(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "<this>");
        o51 o51Var = o51.INSTANCE;
        ip0 j = DescriptorUtilsKt.i(classDescriptor).j();
        b41.h(j, "fqNameSafe.toUnsafe()");
        hj o = o51Var.o(j);
        if (o == null) {
            return w60.b(classDescriptor, null, 2, null);
        }
        String f = t61.b(o).f();
        b41.h(f, "byClassId(it).internalName");
        return f;
    }

    @NotNull
    public static final c71 g(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return (c71) w60.e(z71Var, d71.INSTANCE, vq2.DEFAULT, uq2.INSTANCE, null, null, 32, null);
    }
}
