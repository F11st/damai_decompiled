package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.hp0;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaPackage extends JavaAnnotationOwner, JavaElement {
    @NotNull
    Collection<JavaClass> getClasses(@NotNull Function1<? super ni1, Boolean> function1);

    @NotNull
    hp0 getFqName();

    @NotNull
    Collection<JavaPackage> getSubPackages();
}
