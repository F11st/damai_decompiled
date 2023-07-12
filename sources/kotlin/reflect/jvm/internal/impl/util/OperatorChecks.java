package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.in1;
import tb.k50;
import tb.ke1;
import tb.ni1;
import tb.x1;
import tb.z71;
import tb.zw2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class OperatorChecks extends x1 {
    @NotNull
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    @NotNull
    private static final List<Checks> a;

    static {
        List j;
        List<Checks> j2;
        ni1 ni1Var = in1.GET;
        ke1.C9350b c9350b = ke1.C9350b.INSTANCE;
        Check[] checkArr = {c9350b, new zw2.C10036a(1)};
        ni1 ni1Var2 = in1.SET;
        Check[] checkArr2 = {c9350b, new zw2.C10036a(2)};
        ni1 ni1Var3 = in1.GET_VALUE;
        C8559b c8559b = C8559b.INSTANCE;
        C8558a c8558a = C8558a.INSTANCE;
        ni1 ni1Var4 = in1.CONTAINS;
        zw2.C10039d c10039d = zw2.C10039d.INSTANCE;
        ReturnsCheck.ReturnsBoolean returnsBoolean = ReturnsCheck.ReturnsBoolean.INSTANCE;
        ni1 ni1Var5 = in1.ITERATOR;
        zw2.C10038c c10038c = zw2.C10038c.INSTANCE;
        j = C8214m.j(in1.INC, in1.DEC);
        j2 = C8214m.j(new Checks(ni1Var, checkArr, (Function1) null, 4, (k50) null), new Checks(ni1Var2, checkArr2, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$1
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
                if ((!kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.a(r4) && r4.getVarargElementType() == null) == true) goto L4;
             */
            @Override // kotlin.jvm.functions.Function1
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.String invoke(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4) {
                /*
                    r3 = this;
                    java.lang.String r0 = "$this$$receiver"
                    tb.b41.i(r4, r0)
                    java.util.List r4 = r4.getValueParameters()
                    java.lang.String r0 = "valueParameters"
                    tb.b41.h(r4, r0)
                    java.lang.Object r4 = kotlin.collections.C8212k.d0(r4)
                    kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
                    r0 = 1
                    r1 = 0
                    if (r4 != 0) goto L1a
                L18:
                    r0 = 0
                    goto L2b
                L1a:
                    boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.a(r4)
                    if (r2 != 0) goto L28
                    tb.z71 r4 = r4.getVarargElementType()
                    if (r4 != 0) goto L28
                    r4 = 1
                    goto L29
                L28:
                    r4 = 0
                L29:
                    if (r4 != r0) goto L18
                L2b:
                    kotlin.reflect.jvm.internal.impl.util.OperatorChecks r4 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
                    if (r0 != 0) goto L32
                    java.lang.String r4 = "last parameter should not have a default value or be a vararg"
                    goto L33
                L32:
                    r4 = 0
                L33:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$1.invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):java.lang.String");
            }
        }), new Checks(ni1Var3, new Check[]{c9350b, c8559b, new zw2.C10036a(2), c8558a}, (Function1) null, 4, (k50) null), new Checks(in1.SET_VALUE, new Check[]{c9350b, c8559b, new zw2.C10036a(3), c8558a}, (Function1) null, 4, (k50) null), new Checks(in1.PROVIDE_DELEGATE, new Check[]{c9350b, c8559b, new zw2.C10037b(2), c8558a}, (Function1) null, 4, (k50) null), new Checks(in1.INVOKE, new Check[]{c9350b}, (Function1) null, 4, (k50) null), new Checks(ni1Var4, new Check[]{c9350b, c10039d, c8559b, returnsBoolean}, (Function1) null, 4, (k50) null), new Checks(ni1Var5, new Check[]{c9350b, c10038c}, (Function1) null, 4, (k50) null), new Checks(in1.NEXT, new Check[]{c9350b, c10038c}, (Function1) null, 4, (k50) null), new Checks(in1.HAS_NEXT, new Check[]{c9350b, c10038c, returnsBoolean}, (Function1) null, 4, (k50) null), new Checks(in1.RANGE_TO, new Check[]{c9350b, c10039d, c8559b}, (Function1) null, 4, (k50) null), new Checks(in1.EQUALS, new Check[]{ke1.C9349a.INSTANCE}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2
            private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
                return (declarationDescriptor instanceof ClassDescriptor) && AbstractC8271b.a0((ClassDescriptor) declarationDescriptor);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final String invoke(@NotNull FunctionDescriptor functionDescriptor) {
                boolean z;
                b41.i(functionDescriptor, "$this$$receiver");
                OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
                DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
                b41.h(containingDeclaration, "containingDeclaration");
                boolean z2 = true;
                if (!invoke$isAny(containingDeclaration)) {
                    Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
                    b41.h(overriddenDescriptors, "overriddenDescriptors");
                    if (!overriddenDescriptors.isEmpty()) {
                        for (FunctionDescriptor functionDescriptor2 : overriddenDescriptors) {
                            DeclarationDescriptor containingDeclaration2 = functionDescriptor2.getContainingDeclaration();
                            b41.h(containingDeclaration2, "it.containingDeclaration");
                            if (invoke$isAny(containingDeclaration2)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        z2 = false;
                    }
                }
                if (z2) {
                    return null;
                }
                return "must override ''equals()'' in Any";
            }
        }), new Checks(in1.COMPARE_TO, new Check[]{c9350b, ReturnsCheck.ReturnsInt.INSTANCE, c10039d, c8559b}, (Function1) null, 4, (k50) null), new Checks(in1.BINARY_OPERATION_NAMES, new Check[]{c9350b, c10039d, c8559b}, (Function1) null, 4, (k50) null), new Checks(in1.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{c9350b, c10038c}, (Function1) null, 4, (k50) null), new Checks(j, new Check[]{c9350b}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$3
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final String invoke(@NotNull FunctionDescriptor functionDescriptor) {
                boolean m;
                b41.i(functionDescriptor, "$this$$receiver");
                ReceiverParameterDescriptor dispatchReceiverParameter = functionDescriptor.getDispatchReceiverParameter();
                if (dispatchReceiverParameter == null) {
                    dispatchReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
                }
                OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
                boolean z = false;
                if (dispatchReceiverParameter != null) {
                    z71 returnType = functionDescriptor.getReturnType();
                    if (returnType == null) {
                        m = false;
                    } else {
                        z71 type = dispatchReceiverParameter.getType();
                        b41.h(type, "receiver.type");
                        m = TypeUtilsKt.m(returnType, type);
                    }
                    if (m) {
                        z = true;
                    }
                }
                if (z) {
                    return null;
                }
                return "receiver must be a supertype of the return type";
            }
        }), new Checks(in1.ASSIGNMENT_OPERATIONS, new Check[]{c9350b, ReturnsCheck.ReturnsUnit.INSTANCE, c10039d, c8559b}, (Function1) null, 4, (k50) null), new Checks(in1.COMPONENT_REGEX, new Check[]{c9350b, c10038c}, (Function1) null, 4, (k50) null));
        a = j2;
    }

    private OperatorChecks() {
    }

    @Override // tb.x1
    @NotNull
    public List<Checks> b() {
        return a;
    }
}
