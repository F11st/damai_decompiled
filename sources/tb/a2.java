package tb;

import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a2 {
    @NotNull
    public static final a2 INSTANCE = new a2();

    private a2() {
    }

    private final boolean c(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (j.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (j.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (abstractTypeCheckerContext.o() && j.isStubType(simpleTypeMarker)) {
            return true;
        }
        return j.areEqualTypeConstructors(j.typeConstructor(simpleTypeMarker), typeConstructorMarker);
    }

    private final boolean e(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (n2.a) {
            if (!j.isSingleClassifierType(simpleTypeMarker) && !j.isIntersection(j.typeConstructor(simpleTypeMarker))) {
                abstractTypeCheckerContext.m(simpleTypeMarker);
            }
            if (!j.isSingleClassifierType(simpleTypeMarker2)) {
                abstractTypeCheckerContext.m(simpleTypeMarker2);
            }
        }
        if (j.isMarkedNullable(simpleTypeMarker2) || j.isDefinitelyNotNullType(simpleTypeMarker)) {
            return true;
        }
        if ((simpleTypeMarker instanceof CapturedTypeMarker) && j.isProjectionNotNull((CapturedTypeMarker) simpleTypeMarker)) {
            return true;
        }
        a2 a2Var = INSTANCE;
        if (a2Var.a(abstractTypeCheckerContext, simpleTypeMarker, AbstractTypeCheckerContext.AbstractC8531a.C8533b.INSTANCE)) {
            return true;
        }
        if (j.isDefinitelyNotNullType(simpleTypeMarker2) || a2Var.a(abstractTypeCheckerContext, simpleTypeMarker2, AbstractTypeCheckerContext.AbstractC8531a.C8535d.INSTANCE) || j.isClassType(simpleTypeMarker)) {
            return false;
        }
        return a2Var.b(abstractTypeCheckerContext, simpleTypeMarker, j.typeConstructor(simpleTypeMarker2));
    }

    public final boolean a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull AbstractTypeCheckerContext.AbstractC8531a abstractC8531a) {
        String Z;
        b41.i(abstractTypeCheckerContext, "<this>");
        b41.i(simpleTypeMarker, "type");
        b41.i(abstractC8531a, "supertypesPolicy");
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (!((j.isClassType(simpleTypeMarker) && !j.isMarkedNullable(simpleTypeMarker)) || j.isDefinitelyNotNullType(simpleTypeMarker))) {
            abstractTypeCheckerContext.k();
            ArrayDeque<SimpleTypeMarker> h = abstractTypeCheckerContext.h();
            b41.f(h);
            Set<SimpleTypeMarker> i = abstractTypeCheckerContext.i();
            b41.f(i);
            h.push(simpleTypeMarker);
            while (!h.isEmpty()) {
                if (i.size() <= 1000) {
                    SimpleTypeMarker pop = h.pop();
                    b41.h(pop, "current");
                    if (i.add(pop)) {
                        AbstractTypeCheckerContext.AbstractC8531a abstractC8531a2 = j.isMarkedNullable(pop) ? AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE : abstractC8531a;
                        if (!(!b41.d(abstractC8531a2, AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE))) {
                            abstractC8531a2 = null;
                        }
                        if (abstractC8531a2 == null) {
                            continue;
                        } else {
                            TypeSystemContext j2 = abstractTypeCheckerContext.j();
                            for (KotlinTypeMarker kotlinTypeMarker : j2.supertypes(j2.typeConstructor(pop))) {
                                SimpleTypeMarker a = abstractC8531a2.a(abstractTypeCheckerContext, kotlinTypeMarker);
                                if ((j.isClassType(a) && !j.isMarkedNullable(a)) || j.isDefinitelyNotNullType(a)) {
                                    abstractTypeCheckerContext.e();
                                } else {
                                    h.add(a);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Too many supertypes for type: ");
                    sb.append(simpleTypeMarker);
                    sb.append(". Supertypes = ");
                    Z = CollectionsKt___CollectionsKt.Z(i, null, null, null, 0, null, null, 63, null);
                    sb.append(Z);
                    throw new IllegalStateException(sb.toString().toString());
                }
            }
            abstractTypeCheckerContext.e();
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        String Z;
        b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(simpleTypeMarker, "start");
        b41.i(typeConstructorMarker, "end");
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (INSTANCE.c(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker)) {
            return true;
        }
        abstractTypeCheckerContext.k();
        ArrayDeque<SimpleTypeMarker> h = abstractTypeCheckerContext.h();
        b41.f(h);
        Set<SimpleTypeMarker> i = abstractTypeCheckerContext.i();
        b41.f(i);
        h.push(simpleTypeMarker);
        while (!h.isEmpty()) {
            if (i.size() <= 1000) {
                SimpleTypeMarker pop = h.pop();
                b41.h(pop, "current");
                if (i.add(pop)) {
                    AbstractTypeCheckerContext.AbstractC8531a abstractC8531a = j.isMarkedNullable(pop) ? AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE : AbstractTypeCheckerContext.AbstractC8531a.C8533b.INSTANCE;
                    if (!(!b41.d(abstractC8531a, AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE))) {
                        abstractC8531a = null;
                    }
                    if (abstractC8531a == null) {
                        continue;
                    } else {
                        TypeSystemContext j2 = abstractTypeCheckerContext.j();
                        for (KotlinTypeMarker kotlinTypeMarker : j2.supertypes(j2.typeConstructor(pop))) {
                            SimpleTypeMarker a = abstractC8531a.a(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (INSTANCE.c(abstractTypeCheckerContext, a, typeConstructorMarker)) {
                                abstractTypeCheckerContext.e();
                                return true;
                            }
                            h.add(a);
                        }
                        continue;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many supertypes for type: ");
                sb.append(simpleTypeMarker);
                sb.append(". Supertypes = ");
                Z = CollectionsKt___CollectionsKt.Z(i, null, null, null, 0, null, null, 63, null);
                sb.append(Z);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        abstractTypeCheckerContext.e();
        return false;
    }

    public final boolean d(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(simpleTypeMarker, "subType");
        b41.i(simpleTypeMarker2, "superType");
        return e(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2);
    }
}
