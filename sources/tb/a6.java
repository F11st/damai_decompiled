package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue;
import org.jetbrains.annotations.NotNull;
import tb.lf0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a6 {
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final NotFoundClasses b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf$Annotation.Argument.Value.Type.values().length];
            iArr[ProtoBuf$Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public a6(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses) {
        b41.i(moduleDescriptor, "module");
        b41.i(notFoundClasses, "notFoundClasses");
        this.a = moduleDescriptor;
        this.b = notFoundClasses;
    }

    private final boolean b(fn<?> fnVar, z71 z71Var, ProtoBuf$Annotation.Argument.Value value) {
        n31 h;
        ProtoBuf$Annotation.Argument.Value.Type type = value.getType();
        int i = type == null ? -1 : a.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 10) {
            ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null && !kotlin.reflect.jvm.internal.impl.builtins.b.j0(classDescriptor)) {
                return false;
            }
        } else if (i != 13) {
            return b41.d(fnVar.a(this.a), z71Var);
        } else {
            if ((fnVar instanceof y7) && ((y7) fnVar).b().size() == value.getArrayElementList().size()) {
                z71 k = c().k(z71Var);
                b41.h(k, "builtIns.getArrayElementType(expectedType)");
                y7 y7Var = (y7) fnVar;
                h = kotlin.collections.m.h(y7Var.b());
                if (!(h instanceof Collection) || !((Collection) h).isEmpty()) {
                    Iterator<Integer> it = h.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((i31) it).nextInt();
                        ProtoBuf$Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                        b41.h(arrayElement, "value.getArrayElement(i)");
                        if (!b(y7Var.b().get(nextInt), k, arrayElement)) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(b41.r("Deserialized ArrayValue should have the same number of elements as the original array value: ", fnVar).toString());
            }
        }
        return true;
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.b c() {
        return this.a.getBuiltIns();
    }

    private final Pair<ni1, fn<?>> d(ProtoBuf$Annotation.Argument argument, Map<ni1, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = map.get(pi1.b(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        ni1 b = pi1.b(nameResolver, argument.getNameId());
        z71 type = valueParameterDescriptor.getType();
        b41.h(type, "parameter.type");
        ProtoBuf$Annotation.Argument.Value value = argument.getValue();
        b41.h(value, "proto.value");
        return new Pair<>(b, g(type, value, nameResolver));
    }

    private final ClassDescriptor e(hj hjVar) {
        return FindClassInModuleKt.c(this.a, hjVar, this.b);
    }

    private final fn<?> g(z71 z71Var, ProtoBuf$Annotation.Argument.Value value, NameResolver nameResolver) {
        fn<?> f = f(z71Var, value, nameResolver);
        if (!b(f, z71Var, value)) {
            f = null;
        }
        if (f == null) {
            lf0.a aVar = lf0.Companion;
            return aVar.a("Unexpected argument value: actual type " + value.getType() + " != expected type " + z71Var);
        }
        return f;
    }

    @NotNull
    public final AnnotationDescriptor a(@NotNull ProtoBuf$Annotation protoBuf$Annotation, @NotNull NameResolver nameResolver) {
        Map i;
        int q;
        int e;
        int a2;
        b41.i(protoBuf$Annotation, "proto");
        b41.i(nameResolver, "nameResolver");
        ClassDescriptor e2 = e(pi1.a(nameResolver, protoBuf$Annotation.getId()));
        i = kotlin.collections.x.i();
        if (protoBuf$Annotation.getArgumentCount() != 0 && !kf0.r(e2) && d70.t(e2)) {
            Collection<ClassConstructorDescriptor> constructors = e2.getConstructors();
            b41.h(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) kotlin.collections.k.r0(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                b41.h(valueParameters, "constructor.valueParameters");
                q = kotlin.collections.n.q(valueParameters, 10);
                e = kotlin.collections.w.e(q);
                a2 = ty1.a(e, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a2);
                for (Object obj : valueParameters) {
                    linkedHashMap.put(((ValueParameterDescriptor) obj).getName(), obj);
                }
                List<ProtoBuf$Annotation.Argument> argumentList = protoBuf$Annotation.getArgumentList();
                b41.h(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf$Annotation.Argument argument : argumentList) {
                    b41.h(argument, AdvanceSetting.NETWORK_TYPE);
                    Pair<ni1, fn<?>> d = d(argument, linkedHashMap, nameResolver);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
                i = kotlin.collections.x.r(arrayList);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.a(e2.getDefaultType(), i, SourceElement.NO_SOURCE);
    }

    @NotNull
    public final fn<?> f(@NotNull z71 z71Var, @NotNull ProtoBuf$Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        fn<?> fiVar;
        int q;
        b41.i(z71Var, "expectedType");
        b41.i(value, "value");
        b41.i(nameResolver, "nameResolver");
        Boolean d = yj0.IS_UNSIGNED.d(value.getFlags());
        b41.h(d, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = d.booleanValue();
        ProtoBuf$Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : a.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                return booleanValue ? new or2(intValue) : new re(intValue);
            case 2:
                fiVar = new fi((char) value.getIntValue());
                break;
            case 3:
                short intValue2 = (short) value.getIntValue();
                return booleanValue ? new js2(intValue2) : new nc2(intValue2);
            case 4:
                int intValue3 = (int) value.getIntValue();
                if (booleanValue) {
                    fiVar = new bs2(intValue3);
                    break;
                } else {
                    fiVar = new q31(intValue3);
                    break;
                }
            case 5:
                long intValue4 = value.getIntValue();
                return booleanValue ? new es2(intValue4) : new gc1(intValue4);
            case 6:
                fiVar = new kk0(value.getFloatValue());
                break;
            case 7:
                fiVar = new nc0(value.getDoubleValue());
                break;
            case 8:
                fiVar = new ed(value.getIntValue() != 0);
                break;
            case 9:
                fiVar = new ai2(nameResolver.getString(value.getStringValue()));
                break;
            case 10:
                fiVar = new g71(pi1.a(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                break;
            case 11:
                fiVar = new xe0(pi1.a(nameResolver, value.getClassId()), pi1.b(nameResolver, value.getEnumValueId()));
                break;
            case 12:
                ProtoBuf$Annotation annotation = value.getAnnotation();
                b41.h(annotation, "value.annotation");
                fiVar = new d6(a(annotation, nameResolver));
                break;
            case 13:
                List<ProtoBuf$Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                b41.h(arrayElementList, "value.arrayElementList");
                q = kotlin.collections.n.q(arrayElementList, 10);
                ArrayList arrayList = new ArrayList(q);
                for (ProtoBuf$Annotation.Argument.Value value2 : arrayElementList) {
                    fd2 i = c().i();
                    b41.h(i, "builtIns.anyType");
                    b41.h(value2, AdvanceSetting.NETWORK_TYPE);
                    arrayList.add(f(i, value2, nameResolver));
                }
                return new DeserializedArrayValue(arrayList, z71Var);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + z71Var + ')').toString());
        }
        return fiVar;
    }
}
