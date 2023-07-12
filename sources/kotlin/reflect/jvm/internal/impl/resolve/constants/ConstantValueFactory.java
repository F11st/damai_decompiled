package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ai2;
import tb.b41;
import tb.dm1;
import tb.ed;
import tb.fd2;
import tb.fi;
import tb.fn;
import tb.gc1;
import tb.kk0;
import tb.nc0;
import tb.nc2;
import tb.q31;
import tb.re;
import tb.y7;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ConstantValueFactory {
    @NotNull
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    private ConstantValueFactory() {
    }

    private final y7 a(List<?> list, final PrimitiveType primitiveType) {
        List<Object> A0;
        A0 = CollectionsKt___CollectionsKt.A0(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : A0) {
            fn<?> c = c(obj);
            if (c != null) {
                arrayList.add(c);
            }
        }
        return new y7(arrayList, new Function1<ModuleDescriptor, z71>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final z71 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
                b41.i(moduleDescriptor, "module");
                fd2 O = moduleDescriptor.getBuiltIns().O(PrimitiveType.this);
                b41.h(O, "module.builtIns.getPrimi…KotlinType(componentType)");
                return O;
            }
        });
    }

    @NotNull
    public final y7 b(@NotNull List<? extends fn<?>> list, @NotNull final z71 z71Var) {
        b41.i(list, "value");
        b41.i(z71Var, "type");
        return new y7(list, new Function1<ModuleDescriptor, z71>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final z71 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
                b41.i(moduleDescriptor, AdvanceSetting.NETWORK_TYPE);
                return z71.this;
            }
        });
    }

    @Nullable
    public final fn<?> c(@Nullable Object obj) {
        List<Boolean> Z;
        List<Double> T;
        List<Float> U;
        List<Character> S;
        List<Long> W;
        List<Integer> V;
        List<Short> Y;
        List<Byte> R;
        if (obj instanceof Byte) {
            return new re(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new nc2(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new q31(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new gc1(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new fi(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new kk0(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new nc0(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new ed(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new ai2((String) obj);
        }
        if (obj instanceof byte[]) {
            R = ArraysKt___ArraysKt.R((byte[]) obj);
            return a(R, PrimitiveType.BYTE);
        } else if (obj instanceof short[]) {
            Y = ArraysKt___ArraysKt.Y((short[]) obj);
            return a(Y, PrimitiveType.SHORT);
        } else if (obj instanceof int[]) {
            V = ArraysKt___ArraysKt.V((int[]) obj);
            return a(V, PrimitiveType.INT);
        } else if (obj instanceof long[]) {
            W = ArraysKt___ArraysKt.W((long[]) obj);
            return a(W, PrimitiveType.LONG);
        } else if (obj instanceof char[]) {
            S = ArraysKt___ArraysKt.S((char[]) obj);
            return a(S, PrimitiveType.CHAR);
        } else if (obj instanceof float[]) {
            U = ArraysKt___ArraysKt.U((float[]) obj);
            return a(U, PrimitiveType.FLOAT);
        } else if (obj instanceof double[]) {
            T = ArraysKt___ArraysKt.T((double[]) obj);
            return a(T, PrimitiveType.DOUBLE);
        } else if (obj instanceof boolean[]) {
            Z = ArraysKt___ArraysKt.Z((boolean[]) obj);
            return a(Z, PrimitiveType.BOOLEAN);
        } else if (obj == null) {
            return new dm1();
        } else {
            return null;
        }
    }
}
