package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8220r;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class n2 {
    @NotNull
    public static final n2 INSTANCE = new n2();
    @JvmField
    public static boolean a;

    /* compiled from: Taobao */
    /* renamed from: tb.n2$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C9459a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AbstractTypeCheckerContext.LowerCapturedTypePolicy.values().length];
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private n2() {
    }

    private final Boolean a(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (j.isIntegerLiteralType(simpleTypeMarker) || j.isIntegerLiteralType(simpleTypeMarker2)) {
            if (j.isIntegerLiteralType(simpleTypeMarker) && j.isIntegerLiteralType(simpleTypeMarker2)) {
                return Boolean.TRUE;
            }
            if (j.isIntegerLiteralType(simpleTypeMarker)) {
                if (c(j, abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2, false)) {
                    return Boolean.TRUE;
                }
            } else if (j.isIntegerLiteralType(simpleTypeMarker2) && (b(j, simpleTypeMarker) || c(j, abstractTypeCheckerContext, simpleTypeMarker2, simpleTypeMarker, true))) {
                return Boolean.TRUE;
            }
            return null;
        }
        return null;
    }

    private static final boolean b(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        boolean z2;
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker);
        if (typeConstructor instanceof IntersectionTypeConstructorMarker) {
            Collection<KotlinTypeMarker> supertypes = typeSystemContext.supertypes(typeConstructor);
            if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                for (KotlinTypeMarker kotlinTypeMarker : supertypes) {
                    SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
                    if (asSimpleType != null && typeSystemContext.isIntegerLiteralType(asSimpleType)) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (z2) {
                return true;
            }
        }
        return false;
    }

    private static final boolean c(TypeSystemContext typeSystemContext, AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z) {
        boolean z2;
        Collection<KotlinTypeMarker> possibleIntegerTypes = typeSystemContext.possibleIntegerTypes(simpleTypeMarker);
        if (!(possibleIntegerTypes instanceof Collection) || !possibleIntegerTypes.isEmpty()) {
            for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
                if (b41.d(typeSystemContext.typeConstructor(kotlinTypeMarker), typeSystemContext.typeConstructor(simpleTypeMarker2)) || (z && q(INSTANCE, abstractTypeCheckerContext, simpleTypeMarker2, kotlinTypeMarker, false, 8, null))) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x0128, code lost:
        if (r10 != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Boolean d(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext r15, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r16, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r17) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.n2.d(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):java.lang.Boolean");
    }

    private final List<SimpleTypeMarker> e(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        String Z;
        AbstractTypeCheckerContext.AbstractC8531a r;
        List<SimpleTypeMarker> g;
        List<SimpleTypeMarker> e;
        List<SimpleTypeMarker> g2;
        TypeSystemContext j = abstractTypeCheckerContext.j();
        List<SimpleTypeMarker> fastCorrespondingSupertypes = j.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes == null) {
            if (!j.isClassTypeConstructor(typeConstructorMarker) && j.isClassType(simpleTypeMarker)) {
                g2 = C8214m.g();
                return g2;
            } else if (j.isCommonFinalClassConstructor(typeConstructorMarker)) {
                if (j.areEqualTypeConstructors(j.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                    SimpleTypeMarker captureFromArguments = j.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
                    if (captureFromArguments != null) {
                        simpleTypeMarker = captureFromArguments;
                    }
                    e = C8213l.e(simpleTypeMarker);
                    return e;
                }
                g = C8214m.g();
                return g;
            } else {
                fastCorrespondingSupertypes = new xd2<>();
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
                            SimpleTypeMarker captureFromArguments2 = j.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                            if (captureFromArguments2 == null) {
                                captureFromArguments2 = pop;
                            }
                            if (j.areEqualTypeConstructors(j.typeConstructor(captureFromArguments2), typeConstructorMarker)) {
                                fastCorrespondingSupertypes.add(captureFromArguments2);
                                r = AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE;
                            } else if (j.argumentsCount(captureFromArguments2) == 0) {
                                r = AbstractTypeCheckerContext.AbstractC8531a.C8533b.INSTANCE;
                            } else {
                                r = abstractTypeCheckerContext.r(captureFromArguments2);
                            }
                            if (!(!b41.d(r, AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE))) {
                                r = null;
                            }
                            if (r != null) {
                                TypeSystemContext j2 = abstractTypeCheckerContext.j();
                                for (KotlinTypeMarker kotlinTypeMarker : j2.supertypes(j2.typeConstructor(pop))) {
                                    h.add(r.a(abstractTypeCheckerContext, kotlinTypeMarker));
                                }
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
            }
        }
        return fastCorrespondingSupertypes;
    }

    private final List<SimpleTypeMarker> f(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return t(abstractTypeCheckerContext, e(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker));
    }

    private final boolean g(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        TypeSystemContext j = abstractTypeCheckerContext.j();
        KotlinTypeMarker p = abstractTypeCheckerContext.p(abstractTypeCheckerContext.q(kotlinTypeMarker));
        KotlinTypeMarker p2 = abstractTypeCheckerContext.p(abstractTypeCheckerContext.q(kotlinTypeMarker2));
        n2 n2Var = INSTANCE;
        Boolean d = n2Var.d(abstractTypeCheckerContext, j.lowerBoundIfFlexible(p), j.upperBoundIfFlexible(p2));
        if (d == null) {
            Boolean c = abstractTypeCheckerContext.c(p, p2, z);
            if (c == null) {
                return n2Var.r(abstractTypeCheckerContext, j.lowerBoundIfFlexible(p), j.upperBoundIfFlexible(p2));
            }
            return c.booleanValue();
        }
        boolean booleanValue = d.booleanValue();
        abstractTypeCheckerContext.c(p, p2, z);
        return booleanValue;
    }

    private final TypeParameterMarker k(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        int argumentsCount = typeSystemContext.argumentsCount(kotlinTypeMarker);
        if (argumentsCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i);
                boolean z = true;
                if (!(!typeSystemContext.isStarProjection(argument))) {
                    argument = null;
                }
                KotlinTypeMarker type = argument == null ? null : typeSystemContext.getType(argument);
                if (type != null) {
                    z = (typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(type)) && typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker2))) ? false : false;
                    if (b41.d(type, kotlinTypeMarker2) || (z && b41.d(typeSystemContext.typeConstructor(type), typeSystemContext.typeConstructor(kotlinTypeMarker2)))) {
                        break;
                    }
                    TypeParameterMarker k = k(typeSystemContext, type, kotlinTypeMarker2);
                    if (k != null) {
                        return k;
                    }
                }
                if (i2 >= argumentsCount) {
                    break;
                }
                i = i2;
            }
            return typeSystemContext.getParameter(typeSystemContext.typeConstructor(kotlinTypeMarker), i);
        }
        return null;
    }

    private final boolean l(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        String Z;
        AbstractTypeCheckerContext.AbstractC8531a abstractC8531a;
        TypeSystemContext j = abstractTypeCheckerContext.j();
        TypeConstructorMarker typeConstructor = j.typeConstructor(simpleTypeMarker);
        if (j.isClassTypeConstructor(typeConstructor)) {
            return j.isNothingConstructor(typeConstructor);
        }
        if (j.isNothingConstructor(j.typeConstructor(simpleTypeMarker))) {
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
                    if (j.isClassType(pop)) {
                        abstractC8531a = AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE;
                    } else {
                        abstractC8531a = AbstractTypeCheckerContext.AbstractC8531a.C8533b.INSTANCE;
                    }
                    if (!(!b41.d(abstractC8531a, AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE))) {
                        abstractC8531a = null;
                    }
                    if (abstractC8531a == null) {
                        continue;
                    } else {
                        TypeSystemContext j2 = abstractTypeCheckerContext.j();
                        for (KotlinTypeMarker kotlinTypeMarker : j2.supertypes(j2.typeConstructor(pop))) {
                            SimpleTypeMarker a2 = abstractC8531a.a(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (j.isNothingConstructor(j.typeConstructor(a2))) {
                                abstractTypeCheckerContext.e();
                                return true;
                            }
                            h.add(a2);
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

    private final boolean m(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        return typeSystemContext.isDenotable(typeSystemContext.typeConstructor(kotlinTypeMarker)) && !typeSystemContext.isDynamic(kotlinTypeMarker) && !typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) && b41.d(typeSystemContext.typeConstructor(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)), typeSystemContext.typeConstructor(typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker)));
    }

    private final boolean n(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        SimpleTypeMarker simpleTypeMarker3;
        SimpleTypeMarker simpleTypeMarker4;
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker);
        if (asDefinitelyNotNullType == null || (simpleTypeMarker3 = typeSystemContext.original(asDefinitelyNotNullType)) == null) {
            simpleTypeMarker3 = simpleTypeMarker;
        }
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType2 = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2);
        if (asDefinitelyNotNullType2 == null || (simpleTypeMarker4 = typeSystemContext.original(asDefinitelyNotNullType2)) == null) {
            simpleTypeMarker4 = simpleTypeMarker2;
        }
        if (typeSystemContext.typeConstructor(simpleTypeMarker3) != typeSystemContext.typeConstructor(simpleTypeMarker4)) {
            return false;
        }
        if (typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker) || !typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
            return !typeSystemContext.isMarkedNullable(simpleTypeMarker) || typeSystemContext.isMarkedNullable(simpleTypeMarker2);
        }
        return false;
    }

    public static /* synthetic */ boolean q(n2 n2Var, AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return n2Var.p(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    private final boolean r(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        int q;
        boolean z;
        int q2;
        TypeConstructorMarker typeConstructorMarker;
        TypeConstructorMarker typeConstructorMarker2;
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (a) {
            if (!j.isSingleClassifierType(simpleTypeMarker) && !j.isIntersection(j.typeConstructor(simpleTypeMarker))) {
                abstractTypeCheckerContext.m(simpleTypeMarker);
            }
            if (!j.isSingleClassifierType(simpleTypeMarker2)) {
                abstractTypeCheckerContext.m(simpleTypeMarker2);
            }
        }
        if (a2.INSTANCE.d(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2)) {
            n2 n2Var = INSTANCE;
            Boolean a2 = n2Var.a(abstractTypeCheckerContext, j.lowerBoundIfFlexible(simpleTypeMarker), j.upperBoundIfFlexible(simpleTypeMarker2));
            if (a2 == null) {
                TypeConstructorMarker typeConstructor = j.typeConstructor(simpleTypeMarker2);
                if ((j.areEqualTypeConstructors(j.typeConstructor(simpleTypeMarker), typeConstructor) && j.parametersCount(typeConstructor) == 0) || j.isAnyConstructor(j.typeConstructor(simpleTypeMarker2))) {
                    return true;
                }
                List<SimpleTypeMarker> j2 = n2Var.j(abstractTypeCheckerContext, simpleTypeMarker, typeConstructor);
                int i = 10;
                q = C8215n.q(j2, 10);
                ArrayList<SimpleTypeMarker> arrayList = new ArrayList(q);
                for (SimpleTypeMarker simpleTypeMarker3 : j2) {
                    SimpleTypeMarker asSimpleType = j.asSimpleType(abstractTypeCheckerContext.p(simpleTypeMarker3));
                    if (asSimpleType != null) {
                        simpleTypeMarker3 = asSimpleType;
                    }
                    arrayList.add(simpleTypeMarker3);
                }
                int size = arrayList.size();
                if (size != 0) {
                    if (size != 1) {
                        ArgumentList argumentList = new ArgumentList(j.parametersCount(typeConstructor));
                        int parametersCount = j.parametersCount(typeConstructor);
                        if (parametersCount > 0) {
                            int i2 = 0;
                            z = false;
                            while (true) {
                                int i3 = i2 + 1;
                                z = z || j.getVariance(j.getParameter(typeConstructor, i2)) != TypeVariance.OUT;
                                if (z) {
                                    typeConstructorMarker = typeConstructor;
                                } else {
                                    q2 = C8215n.q(arrayList, i);
                                    List<? extends KotlinTypeMarker> arrayList2 = new ArrayList<>(q2);
                                    for (SimpleTypeMarker simpleTypeMarker4 : arrayList) {
                                        TypeArgumentMarker argumentOrNull = j.getArgumentOrNull(simpleTypeMarker4, i2);
                                        KotlinTypeMarker kotlinTypeMarker = null;
                                        if (argumentOrNull == null) {
                                            typeConstructorMarker2 = typeConstructor;
                                        } else {
                                            typeConstructorMarker2 = typeConstructor;
                                            if (!(j.getVariance(argumentOrNull) == TypeVariance.INV)) {
                                                argumentOrNull = null;
                                            }
                                            if (argumentOrNull != null) {
                                                kotlinTypeMarker = j.getType(argumentOrNull);
                                            }
                                        }
                                        KotlinTypeMarker kotlinTypeMarker2 = kotlinTypeMarker;
                                        if (kotlinTypeMarker2 == null) {
                                            throw new IllegalStateException(("Incorrect type: " + simpleTypeMarker4 + ", subType: " + simpleTypeMarker + ", superType: " + simpleTypeMarker2).toString());
                                        }
                                        arrayList2.add(kotlinTypeMarker2);
                                        typeConstructor = typeConstructorMarker2;
                                    }
                                    typeConstructorMarker = typeConstructor;
                                    argumentList.add(j.asTypeArgument(j.intersectTypes(arrayList2)));
                                }
                                if (i3 >= parametersCount) {
                                    break;
                                }
                                i2 = i3;
                                typeConstructor = typeConstructorMarker;
                                i = 10;
                            }
                        } else {
                            z = false;
                        }
                        if (z || !INSTANCE.o(abstractTypeCheckerContext, argumentList, simpleTypeMarker2)) {
                            if (!arrayList.isEmpty()) {
                                for (SimpleTypeMarker simpleTypeMarker5 : arrayList) {
                                    if (INSTANCE.o(abstractTypeCheckerContext, j.asArgumentList(simpleTypeMarker5), simpleTypeMarker2)) {
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        return true;
                    }
                    return INSTANCE.o(abstractTypeCheckerContext, j.asArgumentList((SimpleTypeMarker) C8212k.P(arrayList)), simpleTypeMarker2);
                }
                return INSTANCE.l(abstractTypeCheckerContext, simpleTypeMarker);
            }
            boolean booleanValue = a2.booleanValue();
            AbstractTypeCheckerContext.d(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2, false, 4, null);
            return booleanValue;
        }
        return false;
    }

    private final boolean s(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        TypeParameterMarker typeParameter;
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        if (asSimpleType instanceof CapturedTypeMarker) {
            CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) asSimpleType;
            if (!typeSystemContext.isOldCapturedType(capturedTypeMarker) && typeSystemContext.isStarProjection(typeSystemContext.projection(typeSystemContext.typeConstructor(capturedTypeMarker))) && typeSystemContext.captureStatus(capturedTypeMarker) == CaptureStatus.FOR_SUBTYPING) {
                TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(kotlinTypeMarker2);
                TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker = typeConstructor instanceof TypeVariableTypeConstructorMarker ? (TypeVariableTypeConstructorMarker) typeConstructor : null;
                return (typeVariableTypeConstructorMarker == null || (typeParameter = typeSystemContext.getTypeParameter(typeVariableTypeConstructorMarker)) == null || !typeSystemContext.hasRecursiveBounds(typeParameter, typeConstructorMarker)) ? false : true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> t(AbstractTypeCheckerContext abstractTypeCheckerContext, List<? extends SimpleTypeMarker> list) {
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = j.asArgumentList((SimpleTypeMarker) next);
            int size = j.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(j.asFlexibleType(j.getType(j.get(asArgumentList, i))) == null)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    @Nullable
    public final TypeVariance h(@NotNull TypeVariance typeVariance, @NotNull TypeVariance typeVariance2) {
        b41.i(typeVariance, "declared");
        b41.i(typeVariance2, "useSite");
        TypeVariance typeVariance3 = TypeVariance.INV;
        if (typeVariance == typeVariance3) {
            return typeVariance2;
        }
        if (typeVariance2 == typeVariance3 || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    public final boolean i(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(kotlinTypeMarker, "a");
        b41.i(kotlinTypeMarker2, "b");
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        n2 n2Var = INSTANCE;
        if (n2Var.m(j, kotlinTypeMarker) && n2Var.m(j, kotlinTypeMarker2)) {
            KotlinTypeMarker p = abstractTypeCheckerContext.p(abstractTypeCheckerContext.q(kotlinTypeMarker));
            KotlinTypeMarker p2 = abstractTypeCheckerContext.p(abstractTypeCheckerContext.q(kotlinTypeMarker2));
            SimpleTypeMarker lowerBoundIfFlexible = j.lowerBoundIfFlexible(p);
            if (!j.areEqualTypeConstructors(j.typeConstructor(p), j.typeConstructor(p2))) {
                return false;
            }
            if (j.argumentsCount(lowerBoundIfFlexible) == 0) {
                return j.hasFlexibleNullability(p) || j.hasFlexibleNullability(p2) || j.isMarkedNullable(lowerBoundIfFlexible) == j.isMarkedNullable(j.lowerBoundIfFlexible(p2));
            }
        }
        return q(n2Var, abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, false, 8, null) && q(n2Var, abstractTypeCheckerContext, kotlinTypeMarker2, kotlinTypeMarker, false, 8, null);
    }

    @NotNull
    public final List<SimpleTypeMarker> j(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        String Z;
        AbstractTypeCheckerContext.AbstractC8531a abstractC8531a;
        b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(simpleTypeMarker, "subType");
        b41.i(typeConstructorMarker, "superConstructor");
        TypeSystemContext j = abstractTypeCheckerContext.j();
        if (j.isClassType(simpleTypeMarker)) {
            return INSTANCE.f(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        if (!j.isClassTypeConstructor(typeConstructorMarker) && !j.isIntegerLiteralTypeConstructor(typeConstructorMarker)) {
            return INSTANCE.e(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        xd2<SimpleTypeMarker> xd2Var = new xd2();
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
                    if (j.isClassType(pop)) {
                        xd2Var.add(pop);
                        abstractC8531a = AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE;
                    } else {
                        abstractC8531a = AbstractTypeCheckerContext.AbstractC8531a.C8533b.INSTANCE;
                    }
                    if (!(!b41.d(abstractC8531a, AbstractTypeCheckerContext.AbstractC8531a.C8534c.INSTANCE))) {
                        abstractC8531a = null;
                    }
                    if (abstractC8531a != null) {
                        TypeSystemContext j2 = abstractTypeCheckerContext.j();
                        for (KotlinTypeMarker kotlinTypeMarker : j2.supertypes(j2.typeConstructor(pop))) {
                            h.add(abstractC8531a.a(abstractTypeCheckerContext, kotlinTypeMarker));
                        }
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
        ArrayList arrayList = new ArrayList();
        for (SimpleTypeMarker simpleTypeMarker2 : xd2Var) {
            n2 n2Var = INSTANCE;
            b41.h(simpleTypeMarker2, AdvanceSetting.NETWORK_TYPE);
            C8220r.v(arrayList, n2Var.f(abstractTypeCheckerContext, simpleTypeMarker2, typeConstructorMarker));
        }
        return arrayList;
    }

    public final boolean o(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, @NotNull SimpleTypeMarker simpleTypeMarker) {
        int i;
        int i2;
        boolean i3;
        int i4;
        b41.i(abstractTypeCheckerContext, "<this>");
        b41.i(typeArgumentListMarker, "capturedSubArguments");
        b41.i(simpleTypeMarker, "superType");
        TypeSystemContext j = abstractTypeCheckerContext.j();
        TypeConstructorMarker typeConstructor = j.typeConstructor(simpleTypeMarker);
        int size = j.size(typeArgumentListMarker);
        int parametersCount = j.parametersCount(typeConstructor);
        if (size == parametersCount && size == j.argumentsCount(simpleTypeMarker)) {
            if (parametersCount > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    TypeArgumentMarker argument = j.getArgument(simpleTypeMarker, i5);
                    if (!j.isStarProjection(argument)) {
                        KotlinTypeMarker type = j.getType(argument);
                        TypeArgumentMarker typeArgumentMarker = j.get(typeArgumentListMarker, i5);
                        j.getVariance(typeArgumentMarker);
                        TypeVariance typeVariance = TypeVariance.INV;
                        KotlinTypeMarker type2 = j.getType(typeArgumentMarker);
                        n2 n2Var = INSTANCE;
                        TypeVariance h = n2Var.h(j.getVariance(j.getParameter(typeConstructor, i5)), j.getVariance(argument));
                        if (h == null) {
                            return abstractTypeCheckerContext.n();
                        }
                        if (!(h == typeVariance && (n2Var.s(j, type2, type, typeConstructor) || n2Var.s(j, type, type2, typeConstructor)))) {
                            i = abstractTypeCheckerContext.a;
                            if (i <= 100) {
                                i2 = abstractTypeCheckerContext.a;
                                abstractTypeCheckerContext.a = i2 + 1;
                                int i7 = C9459a.$EnumSwitchMapping$0[h.ordinal()];
                                if (i7 == 1) {
                                    i3 = n2Var.i(abstractTypeCheckerContext, type2, type);
                                } else if (i7 == 2) {
                                    i3 = q(n2Var, abstractTypeCheckerContext, type2, type, false, 8, null);
                                } else if (i7 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    i3 = q(n2Var, abstractTypeCheckerContext, type, type2, false, 8, null);
                                }
                                i4 = abstractTypeCheckerContext.a;
                                abstractTypeCheckerContext.a = i4 - 1;
                                if (!i3) {
                                    return false;
                                }
                            } else {
                                throw new IllegalStateException(b41.r("Arguments depth is too high. Some related argument: ", type2).toString());
                            }
                        }
                    }
                    if (i6 >= parametersCount) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean p(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        b41.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(kotlinTypeMarker, "subType");
        b41.i(kotlinTypeMarker2, "superType");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (abstractTypeCheckerContext.f(kotlinTypeMarker, kotlinTypeMarker2)) {
            return g(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, z);
        }
        return false;
    }
}
