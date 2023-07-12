package kotlin.reflect.jvm.internal;

import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b71;
import tb.d70;
import tb.p70;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KPropertyImplKt {
    public static final /* synthetic */ Caller a(KPropertyImpl.a aVar, boolean z) {
        return c(aVar, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.calls.Caller<?> c(final kotlin.reflect.jvm.internal.KPropertyImpl.a<?, ?> r7, final boolean r8) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImplKt.c(kotlin.reflect.jvm.internal.KPropertyImpl$a, boolean):kotlin.reflect.jvm.internal.calls.Caller");
    }

    @Nullable
    public static final Object d(@NotNull KPropertyImpl.a<?, ?> aVar) {
        b41.i(aVar, "$this$boundReceiver");
        return aVar.m().m();
    }

    public static final boolean e(PropertyDescriptor propertyDescriptor) {
        DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
        b41.h(containingDeclaration, "containingDeclaration");
        if (d70.x(containingDeclaration)) {
            DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
            return !(d70.C(containingDeclaration2) || d70.t(containingDeclaration2)) || ((propertyDescriptor instanceof p70) && b71.f(((p70) propertyDescriptor).getProto()));
        }
        return false;
    }
}
