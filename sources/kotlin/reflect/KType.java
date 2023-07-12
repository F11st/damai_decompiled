package kotlin.reflect;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KType extends KAnnotatedElement {
    @NotNull
    List<k71> getArguments();

    @Nullable
    KClassifier getClassifier();

    boolean isMarkedNullable();
}
