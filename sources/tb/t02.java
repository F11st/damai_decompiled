package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class t02 implements KotlinJvmBinaryClass {
    @NotNull
    public static final a Factory = new a(null);
    @NotNull
    private final Class<?> a;
    @NotNull
    private final KotlinClassHeader b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @Nullable
        public final t02 a(@NotNull Class<?> cls) {
            b41.i(cls, "klass");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.a aVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.a();
            uz1.INSTANCE.b(cls, aVar);
            KotlinClassHeader i = aVar.i();
            if (i == null) {
                return null;
            }
            return new t02(cls, i, null);
        }
    }

    private t02(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.a = cls;
        this.b = kotlinClassHeader;
    }

    public /* synthetic */ t02(Class cls, KotlinClassHeader kotlinClassHeader, k50 k50Var) {
        this(cls, kotlinClassHeader);
    }

    @NotNull
    public final Class<?> a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof t02) && b41.d(this.a, ((t02) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public KotlinClassHeader getClassHeader() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public hj getClassId() {
        return ReflectClassUtilKt.a(this.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public String getLocation() {
        String y;
        String name = this.a.getName();
        b41.h(name, "klass.name");
        y = kotlin.text.o.y(name, '.', r10.DIR, false, 4, null);
        return b41.r(y, ".class");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, @Nullable byte[] bArr) {
        b41.i(annotationVisitor, "visitor");
        uz1.INSTANCE.b(this.a, annotationVisitor);
    }

    @NotNull
    public String toString() {
        return t02.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor, @Nullable byte[] bArr) {
        b41.i(memberVisitor, "visitor");
        uz1.INSTANCE.i(this.a, memberVisitor);
    }
}
