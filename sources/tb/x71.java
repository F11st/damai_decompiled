package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class x71 implements SourceElement {
    @NotNull
    private final LazyJavaPackageFragment a;

    public x71(@NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        b41.i(lazyJavaPackageFragment, "packageFragment");
        this.a = lazyJavaPackageFragment;
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
        return this.a + ": " + this.a.g().keySet();
    }
}
