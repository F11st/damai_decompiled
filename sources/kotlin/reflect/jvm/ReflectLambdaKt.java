package kotlin.reflect.jvm;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.C8263a;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b71;
import tb.er2;
import tb.x61;
import tb.y61;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ReflectLambdaKt {
    @ExperimentalReflectionOnLambdas
    @Nullable
    public static final <R> KFunction<R> a(@NotNull Function<? extends R> function) {
        b41.i(function, "$this$reflect");
        Metadata metadata = (Metadata) function.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] d1 = metadata.d1();
            if (d1.length == 0) {
                d1 = null;
            }
            if (d1 != null) {
                Pair<y61, ProtoBuf$Function> j = b71.j(d1, metadata.d2());
                y61 component1 = j.component1();
                ProtoBuf$Function component2 = j.component2();
                x61 x61Var = new x61(metadata.mv(), (metadata.xi() & 8) != 0);
                Class<?> cls = function.getClass();
                ProtoBuf$TypeTable typeTable = component2.getTypeTable();
                b41.h(typeTable, "proto.typeTable");
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) zv2.h(cls, component2, component1, new er2(typeTable), x61Var, ReflectLambdaKt$reflect$descriptor$1.INSTANCE);
                if (simpleFunctionDescriptor != null) {
                    return new KFunctionImpl(C8263a.INSTANCE, simpleFunctionDescriptor);
                }
            }
        }
        return null;
    }
}
