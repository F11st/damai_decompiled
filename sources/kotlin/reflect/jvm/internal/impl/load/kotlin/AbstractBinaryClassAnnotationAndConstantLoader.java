package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b71;
import tb.er2;
import tb.eu2;
import tb.fx1;
import tb.gx1;
import tb.hj;
import tb.hp0;
import tb.jj;
import tb.jx1;
import tb.ne1;
import tb.ni1;
import tb.r10;
import tb.t61;
import tb.w61;
import tb.w71;
import tb.y71;
import tb.yj0;
import tb.z61;
import tb.z71;
import tb.ze2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {
    @NotNull
    private final KotlinClassFinder a;
    @NotNull
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, a<A, C>> b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a<A, C> {
        @NotNull
        private final Map<ne1, List<A>> a;
        @NotNull
        private final Map<ne1, C> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Map<ne1, ? extends List<? extends A>> map, @NotNull Map<ne1, ? extends C> map2) {
            b41.i(map, "memberAnnotations");
            b41.i(map2, "propertyConstants");
            this.a = map;
            this.b = map2;
        }

        @NotNull
        public final Map<ne1, List<A>> a() {
            return this.a;
        }

        @NotNull
        public final Map<ne1, C> b() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c implements KotlinJvmBinaryClass.MemberVisitor {
        final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
        final /* synthetic */ HashMap<ne1, List<A>> b;
        final /* synthetic */ HashMap<ne1, C> c;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public final class a extends b implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
            final /* synthetic */ c d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull c cVar, ne1 ne1Var) {
                super(cVar, ne1Var);
                b41.i(cVar, "this$0");
                b41.i(ne1Var, SocialOperation.GAME_SIGNATURE);
                this.d = cVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, @NotNull hj hjVar, @NotNull SourceElement sourceElement) {
                b41.i(hjVar, "classId");
                b41.i(sourceElement, "source");
                ne1 e = ne1.Companion.e(a(), i);
                List<A> list = this.d.b.get(e);
                if (list == null) {
                    list = new ArrayList<>();
                    this.d.b.put(e, list);
                }
                return this.d.a.n(hjVar, sourceElement, list);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class b implements KotlinJvmBinaryClass.AnnotationVisitor {
            @NotNull
            private final ne1 a;
            @NotNull
            private final ArrayList<A> b;
            final /* synthetic */ c c;

            public b(@NotNull c cVar, ne1 ne1Var) {
                b41.i(cVar, "this$0");
                b41.i(ne1Var, SocialOperation.GAME_SIGNATURE);
                this.c = cVar;
                this.a = ne1Var;
                this.b = new ArrayList<>();
            }

            @NotNull
            protected final ne1 a() {
                return this.a;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull hj hjVar, @NotNull SourceElement sourceElement) {
                b41.i(hjVar, "classId");
                b41.i(sourceElement, "source");
                return this.c.a.n(hjVar, sourceElement, this.b);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public void visitEnd() {
                if (!this.b.isEmpty()) {
                    this.c.b.put(this.a, this.b);
                }
            }
        }

        c(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<ne1, List<A>> hashMap, HashMap<ne1, C> hashMap2) {
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
            this.b = hashMap;
            this.c = hashMap2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationVisitor visitField(@NotNull ni1 ni1Var, @NotNull String str, @Nullable Object obj) {
            C p;
            b41.i(ni1Var, "name");
            b41.i(str, SocialConstants.PARAM_APP_DESC);
            ne1.a aVar = ne1.Companion;
            String b2 = ni1Var.b();
            b41.h(b2, "name.asString()");
            ne1 a2 = aVar.a(b2, str);
            if (obj != null && (p = this.a.p(str, obj)) != null) {
                this.c.put(a2, p);
            }
            return new b(this, a2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
        @Nullable
        public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(@NotNull ni1 ni1Var, @NotNull String str) {
            b41.i(ni1Var, "name");
            b41.i(str, SocialConstants.PARAM_APP_DESC);
            ne1.a aVar = ne1.Companion;
            String b2 = ni1Var.b();
            b41.h(b2, "name.asString()");
            return new a(this, aVar.d(b2, str));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class d implements KotlinJvmBinaryClass.AnnotationVisitor {
        final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
        final /* synthetic */ ArrayList<A> b;

        d(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, ArrayList<A> arrayList) {
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
            this.b = arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull hj hjVar, @NotNull SourceElement sourceElement) {
            b41.i(hjVar, "classId");
            b41.i(sourceElement, "source");
            return this.a.n(hjVar, sourceElement, this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        public void visitEnd() {
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        b41.i(storageManager, "storageManager");
        b41.i(kotlinClassFinder, "kotlinClassFinder");
        this.a = kotlinClassFinder;
        this.b = storageManager.createMemoizedFunction(new Function1<KotlinJvmBinaryClass, a<? extends A, ? extends C>>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$storage$1
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final AbstractBinaryClassAnnotationAndConstantLoader.a<A, C> invoke(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
                AbstractBinaryClassAnnotationAndConstantLoader.a<A, C> o;
                b41.i(kotlinJvmBinaryClass, "kotlinClass");
                o = this.this$0.o(kotlinJvmBinaryClass);
                return o;
            }
        });
    }

    private final int c(gx1 gx1Var, MessageLite messageLite) {
        if (messageLite instanceof ProtoBuf$Function) {
            if (jx1.d((ProtoBuf$Function) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf$Property) {
            if (jx1.e((ProtoBuf$Property) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf$Constructor) {
            gx1.a aVar = (gx1.a) gx1Var;
            if (aVar.g() == ProtoBuf$Class.Kind.ENUM_CLASS) {
                return 2;
            }
            if (aVar.i()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException(b41.r("Unsupported message: ", messageLite.getClass()));
        }
        return 0;
    }

    private final List<A> d(gx1 gx1Var, ne1 ne1Var, boolean z, boolean z2, Boolean bool, boolean z3) {
        List<A> g;
        List<A> g2;
        KotlinJvmBinaryClass f = f(gx1Var, l(gx1Var, z, z2, bool, z3));
        if (f == null) {
            g2 = m.g();
            return g2;
        }
        List<A> list = this.b.invoke(f).a().get(ne1Var);
        if (list == null) {
            g = m.g();
            return g;
        }
        return list;
    }

    static /* synthetic */ List e(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, gx1 gx1Var, ne1 ne1Var, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.d(gx1Var, ne1Var, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final KotlinJvmBinaryClass f(gx1 gx1Var, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass != null) {
            return kotlinJvmBinaryClass;
        }
        if (gx1Var instanceof gx1.a) {
            return s((gx1.a) gx1Var);
        }
        return null;
    }

    private final ne1 h(MessageLite messageLite, NameResolver nameResolver, er2 er2Var, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        if (messageLite instanceof ProtoBuf$Constructor) {
            ne1.a aVar = ne1.Companion;
            w61.b b2 = b71.INSTANCE.b((ProtoBuf$Constructor) messageLite, nameResolver, er2Var);
            if (b2 == null) {
                return null;
            }
            return aVar.b(b2);
        } else if (messageLite instanceof ProtoBuf$Function) {
            ne1.a aVar2 = ne1.Companion;
            w61.b e = b71.INSTANCE.e((ProtoBuf$Function) messageLite, nameResolver, er2Var);
            if (e == null) {
                return null;
            }
            return aVar2.b(e);
        } else if (messageLite instanceof ProtoBuf$Property) {
            GeneratedMessageLite.c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> cVar = JvmProtoBuf.propertySignature;
            b41.h(cVar, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fx1.a((GeneratedMessageLite.ExtendableMessage) messageLite, cVar);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i = b.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i == 1) {
                if (jvmPropertySignature.hasGetter()) {
                    ne1.a aVar3 = ne1.Companion;
                    JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                    b41.h(getter, "signature.getter");
                    return aVar3.c(nameResolver, getter);
                }
                return null;
            } else if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return j((ProtoBuf$Property) messageLite, nameResolver, er2Var, true, true, z);
            } else if (jvmPropertySignature.hasSetter()) {
                ne1.a aVar4 = ne1.Companion;
                JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                b41.h(setter, "signature.setter");
                return aVar4.c(nameResolver, setter);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    static /* synthetic */ ne1 i(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, er2 er2Var, AnnotatedCallableKind annotatedCallableKind, boolean z, int i, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.h(messageLite, nameResolver, er2Var, annotatedCallableKind, (i & 16) != 0 ? false : z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final ne1 j(ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, er2 er2Var, boolean z, boolean z2, boolean z3) {
        GeneratedMessageLite.c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> cVar = JvmProtoBuf.propertySignature;
        b41.h(cVar, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fx1.a(protoBuf$Property, cVar);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            w61.a c2 = b71.INSTANCE.c(protoBuf$Property, nameResolver, er2Var, z3);
            if (c2 == null) {
                return null;
            }
            return ne1.Companion.b(c2);
        } else if (z2 && jvmPropertySignature.hasSyntheticMethod()) {
            ne1.a aVar = ne1.Companion;
            JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
            b41.h(syntheticMethod, "signature.syntheticMethod");
            return aVar.c(nameResolver, syntheticMethod);
        } else {
            return null;
        }
    }

    static /* synthetic */ ne1 k(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, er2 er2Var, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.j(protoBuf$Property, nameResolver, er2Var, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final KotlinJvmBinaryClass l(gx1 gx1Var, boolean z, boolean z2, Boolean bool, boolean z3) {
        gx1.a h;
        String y;
        if (z) {
            if (bool != null) {
                if (gx1Var instanceof gx1.a) {
                    gx1.a aVar = (gx1.a) gx1Var;
                    if (aVar.g() == ProtoBuf$Class.Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder = this.a;
                        hj d2 = aVar.e().d(ni1.f("DefaultImpls"));
                        b41.h(d2, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                        return w71.b(kotlinClassFinder, d2);
                    }
                }
                if (bool.booleanValue() && (gx1Var instanceof gx1.b)) {
                    SourceElement c2 = gx1Var.c();
                    z61 z61Var = c2 instanceof z61 ? (z61) c2 : null;
                    t61 b2 = z61Var == null ? null : z61Var.b();
                    if (b2 != null) {
                        KotlinClassFinder kotlinClassFinder2 = this.a;
                        String f = b2.f();
                        b41.h(f, "facadeClassName.internalName");
                        y = o.y(f, r10.DIR, '.', false, 4, null);
                        hj m = hj.m(new hp0(y));
                        b41.h(m, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
                        return w71.b(kotlinClassFinder2, m);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + gx1Var + ')').toString());
            }
        }
        if (z2 && (gx1Var instanceof gx1.a)) {
            gx1.a aVar2 = (gx1.a) gx1Var;
            if (aVar2.g() == ProtoBuf$Class.Kind.COMPANION_OBJECT && (h = aVar2.h()) != null && (h.g() == ProtoBuf$Class.Kind.CLASS || h.g() == ProtoBuf$Class.Kind.ENUM_CLASS || (z3 && (h.g() == ProtoBuf$Class.Kind.INTERFACE || h.g() == ProtoBuf$Class.Kind.ANNOTATION_CLASS)))) {
                return s(h);
            }
        }
        if ((gx1Var instanceof gx1.b) && (gx1Var.c() instanceof z61)) {
            SourceElement c3 = gx1Var.c();
            Objects.requireNonNull(c3, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            z61 z61Var2 = (z61) c3;
            KotlinJvmBinaryClass c4 = z61Var2.c();
            return c4 == null ? w71.b(this.a, z61Var2.a()) : c4;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor n(hj hjVar, SourceElement sourceElement, List<A> list) {
        if (ze2.INSTANCE.a().contains(hjVar)) {
            return null;
        }
        return m(hjVar, sourceElement, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a<A, C> o(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new c(this, hashMap, hashMap2), g(kotlinJvmBinaryClass));
        return new a<>(hashMap, hashMap2);
    }

    private final List<A> q(gx1 gx1Var, ProtoBuf$Property protoBuf$Property, PropertyRelatedElement propertyRelatedElement) {
        boolean K;
        List<A> g;
        List<A> g2;
        List<A> g3;
        Boolean d2 = yj0.IS_CONST.d(protoBuf$Property.getFlags());
        b41.h(d2, "IS_CONST.get(proto.flags)");
        boolean booleanValue = d2.booleanValue();
        boolean f = b71.f(protoBuf$Property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            ne1 k = k(this, protoBuf$Property, gx1Var.b(), gx1Var.d(), false, true, false, 40, null);
            if (k == null) {
                g3 = m.g();
                return g3;
            }
            return e(this, gx1Var, k, true, false, Boolean.valueOf(booleanValue), f, 8, null);
        }
        ne1 k2 = k(this, protoBuf$Property, gx1Var.b(), gx1Var.d(), true, false, false, 48, null);
        if (k2 == null) {
            g2 = m.g();
            return g2;
        }
        K = StringsKt__StringsKt.K(k2.a(), "$delegate", false, 2, null);
        if (K != (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD)) {
            g = m.g();
            return g;
        }
        return d(gx1Var, k2, true, true, Boolean.valueOf(booleanValue), f);
    }

    private final KotlinJvmBinaryClass s(gx1.a aVar) {
        SourceElement c2 = aVar.c();
        y71 y71Var = c2 instanceof y71 ? (y71) c2 : null;
        if (y71Var == null) {
            return null;
        }
        return y71Var.a();
    }

    @Nullable
    protected byte[] g(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        b41.i(kotlinJvmBinaryClass, "kotlinClass");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadCallableAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        List<A> g;
        b41.i(gx1Var, "container");
        b41.i(messageLite, "proto");
        b41.i(annotatedCallableKind, "kind");
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return q(gx1Var, (ProtoBuf$Property) messageLite, PropertyRelatedElement.PROPERTY);
        }
        ne1 i = i(this, messageLite, gx1Var.b(), gx1Var.d(), annotatedCallableKind, false, 16, null);
        if (i == null) {
            g = m.g();
            return g;
        }
        return e(this, gx1Var, i, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadClassAnnotations(@NotNull gx1.a aVar) {
        b41.i(aVar, "container");
        KotlinJvmBinaryClass s = s(aVar);
        if (s != null) {
            ArrayList arrayList = new ArrayList(1);
            s.loadClassAnnotations(new d(this, arrayList), g(s));
            return arrayList;
        }
        throw new IllegalStateException(b41.r("Class for loading annotations is not found: ", aVar.a()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        b41.i(gx1Var, "container");
        b41.i(protoBuf$EnumEntry, "proto");
        ne1.a aVar = ne1.Companion;
        String string = gx1Var.b().getString(protoBuf$EnumEntry.getName());
        String c2 = ((gx1.a) gx1Var).e().c();
        b41.h(c2, "container as ProtoContai…Class).classId.asString()");
        return e(this, gx1Var, aVar.a(string, jj.b(c2)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        List<A> g;
        b41.i(gx1Var, "container");
        b41.i(messageLite, "proto");
        b41.i(annotatedCallableKind, "kind");
        ne1 i = i(this, messageLite, gx1Var.b(), gx1Var.d(), annotatedCallableKind, false, 16, null);
        if (i != null) {
            return e(this, gx1Var, ne1.Companion.e(i, 0), false, false, null, false, 60, null);
        }
        g = m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadPropertyBackingFieldAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property) {
        b41.i(gx1Var, "container");
        b41.i(protoBuf$Property, "proto");
        return q(gx1Var, protoBuf$Property, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @Nullable
    public C loadPropertyConstant(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull z71 z71Var) {
        C c2;
        b41.i(gx1Var, "container");
        b41.i(protoBuf$Property, "proto");
        b41.i(z71Var, "expectedType");
        KotlinJvmBinaryClass f = f(gx1Var, l(gx1Var, true, true, yj0.IS_CONST.d(protoBuf$Property.getFlags()), b71.f(protoBuf$Property)));
        if (f == null) {
            return null;
        }
        ne1 h = h(protoBuf$Property, gx1Var.b(), gx1Var.d(), AnnotatedCallableKind.PROPERTY, f.getClassHeader().d().d(DeserializedDescriptorResolver.Companion.a()));
        if (h == null || (c2 = this.b.invoke(f).b().get(h)) == null) {
            return null;
        }
        return eu2.d(z71Var) ? t(c2) : c2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadPropertyDelegateFieldAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property) {
        b41.i(gx1Var, "container");
        b41.i(protoBuf$Property, "proto");
        return q(gx1Var, protoBuf$Property, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadTypeAnnotations(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull NameResolver nameResolver) {
        int q;
        b41.i(protoBuf$Type, "proto");
        b41.i(nameResolver, "nameResolver");
        Object extension = protoBuf$Type.getExtension(JvmProtoBuf.typeAnnotation);
        b41.h(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) extension;
        q = n.q(iterable, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            b41.h(protoBuf$Annotation, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(r(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, @NotNull NameResolver nameResolver) {
        int q;
        b41.i(protoBuf$TypeParameter, "proto");
        b41.i(nameResolver, "nameResolver");
        Object extension = protoBuf$TypeParameter.getExtension(JvmProtoBuf.typeParameterAnnotation);
        b41.h(extension, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) extension;
        q = n.q(iterable, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            b41.h(protoBuf$Annotation, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(r(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadValueParameterAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i, @NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        List<A> g;
        b41.i(gx1Var, "container");
        b41.i(messageLite, "callableProto");
        b41.i(annotatedCallableKind, "kind");
        b41.i(protoBuf$ValueParameter, "proto");
        ne1 i2 = i(this, messageLite, gx1Var.b(), gx1Var.d(), annotatedCallableKind, false, 16, null);
        if (i2 != null) {
            return e(this, gx1Var, ne1.Companion.e(i2, i + c(gx1Var, messageLite)), false, false, null, false, 60, null);
        }
        g = m.g();
        return g;
    }

    @Nullable
    protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor m(@NotNull hj hjVar, @NotNull SourceElement sourceElement, @NotNull List<A> list);

    @Nullable
    protected abstract C p(@NotNull String str, @NotNull Object obj);

    @NotNull
    protected abstract A r(@NotNull ProtoBuf$Annotation protoBuf$Annotation, @NotNull NameResolver nameResolver);

    @Nullable
    protected abstract C t(@NotNull C c2);
}
