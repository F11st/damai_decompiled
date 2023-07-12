package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;
import tb.uy2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaModifierListOwner extends JavaElement {
    @NotNull
    uy2 getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isStatic();
}
