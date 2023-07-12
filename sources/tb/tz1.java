package tb;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class tz1 implements SourceElement {
    @NotNull
    private final Annotation a;

    public tz1(@NotNull Annotation annotation) {
        b41.i(annotation, "annotation");
        this.a = annotation;
    }

    @NotNull
    public final Annotation a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        b41.h(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }
}
