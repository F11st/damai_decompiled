package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.e12;
import tb.jn1;
import tb.ni1;
import tb.z71;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ReflectionObjectRenderer {
    @NotNull
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    private static final DescriptorRenderer a = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    private ReflectionObjectRenderer() {
    }

    private final void a(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            z71 type = receiverParameterDescriptor.getType();
            b41.h(type, "receiver.type");
            sb.append(h(type));
            sb.append(".");
        }
    }

    private final void b(StringBuilder sb, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor i = zv2.i(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        a(sb, i);
        boolean z = (i == null || extensionReceiverParameter == null) ? false : true;
        if (z) {
            sb.append(jn1.BRACKET_START_STR);
        }
        a(sb, extensionReceiverParameter);
        if (z) {
            sb.append(jn1.BRACKET_END_STR);
        }
    }

    private final String c(CallableDescriptor callableDescriptor) {
        if (callableDescriptor instanceof PropertyDescriptor) {
            return g((PropertyDescriptor) callableDescriptor);
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return d((FunctionDescriptor) callableDescriptor);
        }
        throw new IllegalStateException(("Illegal callable: " + callableDescriptor).toString());
    }

    @NotNull
    public final String d(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        DescriptorRenderer descriptorRenderer = a;
        ni1 name = functionDescriptor.getName();
        b41.h(name, "descriptor.name");
        sb.append(descriptorRenderer.f(name, true));
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        b41.h(valueParameters, "descriptor.valueParameters");
        CollectionsKt___CollectionsKt.X(valueParameters, sb, AVFSCacheConstants.COMMA_SEP, jn1.BRACKET_START_STR, jn1.BRACKET_END_STR, 0, null, new Function1<ValueParameterDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$renderFunction$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
                ReflectionObjectRenderer reflectionObjectRenderer2 = ReflectionObjectRenderer.INSTANCE;
                b41.h(valueParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
                z71 type = valueParameterDescriptor.getType();
                b41.h(type, "it.type");
                return reflectionObjectRenderer2.h(type);
            }
        }, 48, null);
        sb.append(": ");
        z71 returnType = functionDescriptor.getReturnType();
        b41.f(returnType);
        b41.h(returnType, "descriptor.returnType!!");
        sb.append(reflectionObjectRenderer.h(returnType));
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String e(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "invoke");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        b41.h(valueParameters, "invoke.valueParameters");
        CollectionsKt___CollectionsKt.X(valueParameters, sb, AVFSCacheConstants.COMMA_SEP, jn1.BRACKET_START_STR, jn1.BRACKET_END_STR, 0, null, new Function1<ValueParameterDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$renderLambda$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
                ReflectionObjectRenderer reflectionObjectRenderer2 = ReflectionObjectRenderer.INSTANCE;
                b41.h(valueParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
                z71 type = valueParameterDescriptor.getType();
                b41.h(type, "it.type");
                return reflectionObjectRenderer2.h(type);
            }
        }, 48, null);
        sb.append(" -> ");
        z71 returnType = functionDescriptor.getReturnType();
        b41.f(returnType);
        b41.h(returnType, "invoke.returnType!!");
        sb.append(reflectionObjectRenderer.h(returnType));
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String f(@NotNull KParameterImpl kParameterImpl) {
        b41.i(kParameterImpl, "parameter");
        StringBuilder sb = new StringBuilder();
        int i = e12.$EnumSwitchMapping$0[kParameterImpl.getKind().ordinal()];
        if (i == 1) {
            sb.append("extension receiver parameter");
        } else if (i == 2) {
            sb.append("instance parameter");
        } else if (i == 3) {
            sb.append("parameter #" + kParameterImpl.getIndex() + ' ' + kParameterImpl.getName());
        }
        sb.append(" of ");
        sb.append(INSTANCE.c(kParameterImpl.b().i()));
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String g(@NotNull PropertyDescriptor propertyDescriptor) {
        b41.i(propertyDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(propertyDescriptor.isVar() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, propertyDescriptor);
        DescriptorRenderer descriptorRenderer = a;
        ni1 name = propertyDescriptor.getName();
        b41.h(name, "descriptor.name");
        sb.append(descriptorRenderer.f(name, true));
        sb.append(": ");
        z71 type = propertyDescriptor.getType();
        b41.h(type, "descriptor.type");
        sb.append(reflectionObjectRenderer.h(type));
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String h(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
        return a.g(z71Var);
    }
}
