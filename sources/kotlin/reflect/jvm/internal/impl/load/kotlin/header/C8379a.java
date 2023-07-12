package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hj;
import tb.hp0;
import tb.ij;
import tb.ni1;
import tb.o61;
import tb.x61;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a */
/* loaded from: classes3.dex */
public class C8379a implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final boolean i = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<hj, KotlinClassHeader.Kind> j;
    private int[] a = null;
    private String b = null;
    private int c = 0;
    private String d = null;
    private String[] e = null;
    private String[] f = null;
    private String[] g = null;
    private KotlinClassHeader.Kind h = null;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$b */
    /* loaded from: classes3.dex */
    private static abstract class AbstractC8381b implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> a = new ArrayList();

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "enumEntryName";
            } else if (i == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        protected abstract void b(@NotNull String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(@Nullable Object obj) {
            if (obj instanceof String) {
                this.a.add((String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull hj hjVar) {
            if (hjVar == null) {
                a(3);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(@NotNull ij ijVar) {
            if (ijVar == null) {
                a(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            b((String[]) this.a.toArray(new String[0]));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(@NotNull hj hjVar, @NotNull ni1 ni1Var) {
            if (hjVar == null) {
                a(0);
            }
            if (ni1Var == null) {
                a(1);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c */
    /* loaded from: classes3.dex */
    private class C8382c implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c$a */
        /* loaded from: classes3.dex */
        public class C8383a extends AbstractC8381b {
            C8383a() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.C8379a.AbstractC8381b
            protected void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                C8379a.this.e = strArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c$b */
        /* loaded from: classes3.dex */
        public class C8384b extends AbstractC8381b {
            C8384b() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.C8379a.AbstractC8381b
            protected void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                C8379a.this.f = strArr;
            }
        }

        private C8382c() {
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor b() {
            return new C8383a();
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor c() {
            return new C8384b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable ni1 ni1Var, @Nullable Object obj) {
            if (ni1Var == null) {
                return;
            }
            String b = ni1Var.b();
            if ("k".equals(b)) {
                if (obj instanceof Integer) {
                    C8379a.this.h = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                }
            } else if ("mv".equals(b)) {
                if (obj instanceof int[]) {
                    C8379a.this.a = (int[]) obj;
                }
            } else if ("xs".equals(b)) {
                if (obj instanceof String) {
                    C8379a.this.b = (String) obj;
                }
            } else if ("xi".equals(b)) {
                if (obj instanceof Integer) {
                    C8379a.this.c = ((Integer) obj).intValue();
                }
            } else if (IRequestConst.PN.equals(b) && (obj instanceof String)) {
                C8379a.this.d = (String) obj;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ni1 ni1Var, @NotNull hj hjVar) {
            if (ni1Var == null) {
                a(6);
            }
            if (hjVar == null) {
                a(7);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull ni1 ni1Var) {
            if (ni1Var == null) {
                a(2);
            }
            String b = ni1Var.b();
            if ("d1".equals(b)) {
                return b();
            }
            if ("d2".equals(b)) {
                return c();
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull ni1 ni1Var, @NotNull ij ijVar) {
            if (ni1Var == null) {
                a(0);
            }
            if (ijVar == null) {
                a(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull ni1 ni1Var, @NotNull hj hjVar, @NotNull ni1 ni1Var2) {
            if (ni1Var == null) {
                a(3);
            }
            if (hjVar == null) {
                a(4);
            }
            if (ni1Var2 == null) {
                a(5);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$d */
    /* loaded from: classes3.dex */
    private class C8385d implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$d$a */
        /* loaded from: classes3.dex */
        public class C8386a extends AbstractC8381b {
            C8386a() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.C8379a.AbstractC8381b
            protected void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                C8379a.this.e = strArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$d$b */
        /* loaded from: classes3.dex */
        public class C8387b extends AbstractC8381b {
            C8387b() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.C8379a.AbstractC8381b
            protected void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                C8379a.this.f = strArr;
            }
        }

        private C8385d() {
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor b() {
            return new C8386a();
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor c() {
            return new C8387b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable ni1 ni1Var, @Nullable Object obj) {
            if (ni1Var == null) {
                return;
            }
            String b = ni1Var.b();
            if ("version".equals(b)) {
                if (obj instanceof int[]) {
                    C8379a.this.a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(b)) {
                C8379a.this.b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ni1 ni1Var, @NotNull hj hjVar) {
            if (ni1Var == null) {
                a(6);
            }
            if (hjVar == null) {
                a(7);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull ni1 ni1Var) {
            if (ni1Var == null) {
                a(2);
            }
            String b = ni1Var.b();
            if (!"data".equals(b) && !"filePartClassNames".equals(b)) {
                if ("strings".equals(b)) {
                    return c();
                }
                return null;
            }
            return b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull ni1 ni1Var, @NotNull ij ijVar) {
            if (ni1Var == null) {
                a(0);
            }
            if (ijVar == null) {
                a(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull ni1 ni1Var, @NotNull hj hjVar, @NotNull ni1 ni1Var2) {
            if (ni1Var == null) {
                a(3);
            }
            if (hjVar == null) {
                a(4);
            }
            if (ni1Var2 == null) {
                a(5);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(hj.m(new hp0("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(hj.m(new hp0("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(hj.m(new hp0("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(hj.m(new hp0("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(hj.m(new hp0("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    private boolean j() {
        KotlinClassHeader.Kind kind = this.h;
        return kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Nullable
    public KotlinClassHeader i() {
        if (this.h == null || this.a == null) {
            return null;
        }
        x61 x61Var = new x61(this.a, (this.c & 8) != 0);
        if (!x61Var.h()) {
            this.g = this.e;
            this.e = null;
        } else if (j() && this.e == null) {
            return null;
        }
        return new KotlinClassHeader(this.h, x61Var, this.e, this.g, this.f, this.b, this.c, this.d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull hj hjVar, @NotNull SourceElement sourceElement) {
        KotlinClassHeader.Kind kind;
        if (hjVar == null) {
            a(0);
        }
        if (sourceElement == null) {
            a(1);
        }
        if (hjVar.b().equals(o61.METADATA_FQ_NAME)) {
            return new C8382c();
        }
        if (i || this.h != null || (kind = j.get(hjVar)) == null) {
            return null;
        }
        this.h = kind;
        return new C8385d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }
}
