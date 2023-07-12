package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class f42 implements JavaSourceElementFactory {
    @NotNull
    public static final f42 INSTANCE = new f42();

    /* compiled from: Taobao */
    /* renamed from: tb.f42$a */
    /* loaded from: classes3.dex */
    public static final class C9125a implements JavaSourceElement {
        @NotNull
        private final g02 a;

        public C9125a(@NotNull g02 g02Var) {
            b41.i(g02Var, "javaElement");
            this.a = g02Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        @NotNull
        /* renamed from: a */
        public g02 getJavaElement() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        @NotNull
        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            b41.h(sourceFile, "NO_SOURCE_FILE");
            return sourceFile;
        }

        @NotNull
        public String toString() {
            return C9125a.class.getName() + ": " + getJavaElement();
        }
    }

    private f42() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    @NotNull
    public JavaSourceElement source(@NotNull JavaElement javaElement) {
        b41.i(javaElement, "javaElement");
        return new C9125a((g02) javaElement);
    }
}
