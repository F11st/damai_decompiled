package tb;

import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class u51 {
    @NotNull
    private static final hp0 a = new hp0("java.lang.Class");

    public static final /* synthetic */ hp0 a() {
        return a;
    }

    @NotNull
    public static final TypeProjection b(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull q51 q51Var) {
        b41.i(typeParameterDescriptor, "typeParameter");
        b41.i(q51Var, RichTextNode.ATTR);
        if (q51Var.e() == TypeUsage.SUPERTYPE) {
            return new zq2(xf2.b(typeParameterDescriptor));
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    @NotNull
    public static final q51 c(@NotNull TypeUsage typeUsage, boolean z, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        b41.i(typeUsage, "<this>");
        return new q51(typeUsage, null, z, typeParameterDescriptor == null ? null : kotlin.collections.d0.c(typeParameterDescriptor), null, 18, null);
    }

    public static /* synthetic */ q51 d(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            typeParameterDescriptor = null;
        }
        return c(typeUsage, z, typeParameterDescriptor);
    }
}
