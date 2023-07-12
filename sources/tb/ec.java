package tb;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.C8212k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.C8306a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ec extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, fn<?>> {
    @NotNull
    private final ModuleDescriptor c;
    @NotNull
    private final NotFoundClasses d;
    @NotNull
    private final a6 e;

    /* compiled from: Taobao */
    /* renamed from: tb.ec$a */
    /* loaded from: classes3.dex */
    public static final class C9091a implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        @NotNull
        private final HashMap<ni1, fn<?>> a = new HashMap<>();
        final /* synthetic */ ClassDescriptor c;
        final /* synthetic */ List<AnnotationDescriptor> d;
        final /* synthetic */ SourceElement e;

        /* compiled from: Taobao */
        /* renamed from: tb.ec$a$a */
        /* loaded from: classes3.dex */
        public static final class C9092a implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
            private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor a;
            final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor b;
            final /* synthetic */ C9091a c;
            final /* synthetic */ ni1 d;
            final /* synthetic */ ArrayList<AnnotationDescriptor> e;

            C9092a(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, C9091a c9091a, ni1 ni1Var, ArrayList<AnnotationDescriptor> arrayList) {
                this.b = annotationArgumentVisitor;
                this.c = c9091a;
                this.d = ni1Var;
                this.e = arrayList;
                this.a = annotationArgumentVisitor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visit(@Nullable ni1 ni1Var, @Nullable Object obj) {
                this.a.visit(ni1Var, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ni1 ni1Var, @NotNull hj hjVar) {
                b41.i(ni1Var, "name");
                b41.i(hjVar, "classId");
                return this.a.visitAnnotation(ni1Var, hjVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull ni1 ni1Var) {
                b41.i(ni1Var, "name");
                return this.a.visitArray(ni1Var);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitClassLiteral(@NotNull ni1 ni1Var, @NotNull ij ijVar) {
                b41.i(ni1Var, "name");
                b41.i(ijVar, "value");
                this.a.visitClassLiteral(ni1Var, ijVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnd() {
                this.b.visitEnd();
                this.c.a.put(this.d, new d6((AnnotationDescriptor) C8212k.q0(this.e)));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnum(@NotNull ni1 ni1Var, @NotNull hj hjVar, @NotNull ni1 ni1Var2) {
                b41.i(ni1Var, "name");
                b41.i(hjVar, "enumClassId");
                b41.i(ni1Var2, "enumEntryName");
                this.a.visitEnum(ni1Var, hjVar, ni1Var2);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.ec$a$b */
        /* loaded from: classes3.dex */
        public static final class C9093b implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
            @NotNull
            private final ArrayList<fn<?>> a = new ArrayList<>();
            final /* synthetic */ ni1 c;
            final /* synthetic */ ec d;
            final /* synthetic */ ClassDescriptor e;

            /* compiled from: Taobao */
            /* renamed from: tb.ec$a$b$a */
            /* loaded from: classes3.dex */
            public static final class C9094a implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
                private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor a;
                final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor b;
                final /* synthetic */ C9093b c;
                final /* synthetic */ ArrayList<AnnotationDescriptor> d;

                C9094a(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, C9093b c9093b, ArrayList<AnnotationDescriptor> arrayList) {
                    this.b = annotationArgumentVisitor;
                    this.c = c9093b;
                    this.d = arrayList;
                    this.a = annotationArgumentVisitor;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visit(@Nullable ni1 ni1Var, @Nullable Object obj) {
                    this.a.visit(ni1Var, obj);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ni1 ni1Var, @NotNull hj hjVar) {
                    b41.i(ni1Var, "name");
                    b41.i(hjVar, "classId");
                    return this.a.visitAnnotation(ni1Var, hjVar);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull ni1 ni1Var) {
                    b41.i(ni1Var, "name");
                    return this.a.visitArray(ni1Var);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitClassLiteral(@NotNull ni1 ni1Var, @NotNull ij ijVar) {
                    b41.i(ni1Var, "name");
                    b41.i(ijVar, "value");
                    this.a.visitClassLiteral(ni1Var, ijVar);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitEnd() {
                    this.b.visitEnd();
                    this.c.a.add(new d6((AnnotationDescriptor) C8212k.q0(this.d)));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitEnum(@NotNull ni1 ni1Var, @NotNull hj hjVar, @NotNull ni1 ni1Var2) {
                    b41.i(ni1Var, "name");
                    b41.i(hjVar, "enumClassId");
                    b41.i(ni1Var2, "enumEntryName");
                    this.a.visitEnum(ni1Var, hjVar, ni1Var2);
                }
            }

            C9093b(ni1 ni1Var, ec ecVar, ClassDescriptor classDescriptor) {
                this.c = ni1Var;
                this.d = ecVar;
                this.e = classDescriptor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visit(@Nullable Object obj) {
                this.a.add(C9091a.this.c(this.c, obj));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull hj hjVar) {
                b41.i(hjVar, "classId");
                ArrayList arrayList = new ArrayList();
                ec ecVar = this.d;
                SourceElement sourceElement = SourceElement.NO_SOURCE;
                b41.h(sourceElement, "NO_SOURCE");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor m = ecVar.m(hjVar, sourceElement, arrayList);
                b41.f(m);
                return new C9094a(m, this, arrayList);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitClassLiteral(@NotNull ij ijVar) {
                b41.i(ijVar, "value");
                this.a.add(new g71(ijVar));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnd() {
                ValueParameterDescriptor b = a70.b(this.c, this.e);
                if (b != null) {
                    HashMap hashMap = C9091a.this.a;
                    ni1 ni1Var = this.c;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<? extends fn<?>> c = kk.c(this.a);
                    z71 type = b.getType();
                    b41.h(type, "parameter.type");
                    hashMap.put(ni1Var, constantValueFactory.b(c, type));
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnum(@NotNull hj hjVar, @NotNull ni1 ni1Var) {
                b41.i(hjVar, "enumClassId");
                b41.i(ni1Var, "enumEntryName");
                this.a.add(new xe0(hjVar, ni1Var));
            }
        }

        C9091a(ClassDescriptor classDescriptor, List<AnnotationDescriptor> list, SourceElement sourceElement) {
            this.c = classDescriptor;
            this.d = list;
            this.e = sourceElement;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final fn<?> c(ni1 ni1Var, Object obj) {
            fn<?> c = ConstantValueFactory.INSTANCE.c(obj);
            return c == null ? lf0.Companion.a(b41.r("Unsupported annotation argument: ", ni1Var)) : c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable ni1 ni1Var, @Nullable Object obj) {
            if (ni1Var != null) {
                this.a.put(ni1Var, c(ni1Var, obj));
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ni1 ni1Var, @NotNull hj hjVar) {
            b41.i(ni1Var, "name");
            b41.i(hjVar, "classId");
            ArrayList arrayList = new ArrayList();
            ec ecVar = ec.this;
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            b41.h(sourceElement, "NO_SOURCE");
            KotlinJvmBinaryClass.AnnotationArgumentVisitor m = ecVar.m(hjVar, sourceElement, arrayList);
            b41.f(m);
            return new C9092a(m, this, ni1Var, arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "name");
            return new C9093b(ni1Var, ec.this, this.c);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull ni1 ni1Var, @NotNull ij ijVar) {
            b41.i(ni1Var, "name");
            b41.i(ijVar, "value");
            this.a.put(ni1Var, new g71(ijVar));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
            this.d.add(new C8306a(this.c.getDefaultType(), this.a, this.e));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull ni1 ni1Var, @NotNull hj hjVar, @NotNull ni1 ni1Var2) {
            b41.i(ni1Var, "name");
            b41.i(hjVar, "enumClassId");
            b41.i(ni1Var2, "enumEntryName");
            this.a.put(ni1Var, new xe0(hjVar, ni1Var2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses, @NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        b41.i(moduleDescriptor, "module");
        b41.i(notFoundClasses, "notFoundClasses");
        b41.i(storageManager, "storageManager");
        b41.i(kotlinClassFinder, "kotlinClassFinder");
        this.c = moduleDescriptor;
        this.d = notFoundClasses;
        this.e = new a6(moduleDescriptor, notFoundClasses);
    }

    private final ClassDescriptor w(hj hjVar) {
        return FindClassInModuleKt.c(this.c, hjVar, this.d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    @Nullable
    protected KotlinJvmBinaryClass.AnnotationArgumentVisitor m(@NotNull hj hjVar, @NotNull SourceElement sourceElement, @NotNull List<AnnotationDescriptor> list) {
        b41.i(hjVar, "annotationClassId");
        b41.i(sourceElement, "source");
        b41.i(list, "result");
        return new C9091a(w(hjVar), list, sourceElement);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    @Nullable
    /* renamed from: u */
    public fn<?> p(@NotNull String str, @NotNull Object obj) {
        boolean K;
        b41.i(str, SocialConstants.PARAM_APP_DESC);
        b41.i(obj, "initializer");
        K = StringsKt__StringsKt.K("ZBCS", str, false, 2, null);
        if (K) {
            int intValue = ((Integer) obj).intValue();
            int hashCode = str.hashCode();
            if (hashCode == 66) {
                if (str.equals("B")) {
                    obj = Byte.valueOf((byte) intValue);
                }
                throw new AssertionError(str);
            } else if (hashCode == 67) {
                if (str.equals("C")) {
                    obj = Character.valueOf((char) intValue);
                }
                throw new AssertionError(str);
            } else if (hashCode == 83) {
                if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                    obj = Short.valueOf((short) intValue);
                }
                throw new AssertionError(str);
            } else {
                if (hashCode == 90 && str.equals("Z")) {
                    obj = Boolean.valueOf(intValue != 0);
                }
                throw new AssertionError(str);
            }
        }
        return ConstantValueFactory.INSTANCE.c(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    @NotNull
    /* renamed from: v */
    public AnnotationDescriptor r(@NotNull ProtoBuf$Annotation protoBuf$Annotation, @NotNull NameResolver nameResolver) {
        b41.i(protoBuf$Annotation, "proto");
        b41.i(nameResolver, "nameResolver");
        return this.e.a(protoBuf$Annotation, nameResolver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    @Nullable
    /* renamed from: x */
    public fn<?> t(@NotNull fn<?> fnVar) {
        fn<?> es2Var;
        b41.i(fnVar, "constant");
        if (fnVar instanceof re) {
            es2Var = new or2(((re) fnVar).b().byteValue());
        } else if (fnVar instanceof nc2) {
            es2Var = new js2(((nc2) fnVar).b().shortValue());
        } else if (fnVar instanceof q31) {
            es2Var = new bs2(((q31) fnVar).b().intValue());
        } else if (!(fnVar instanceof gc1)) {
            return fnVar;
        } else {
            es2Var = new es2(((gc1) fnVar).b().longValue());
        }
        return es2Var;
    }
}
