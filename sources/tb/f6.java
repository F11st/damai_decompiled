package tb;

import cn.damai.common.app.ShareperfenceConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class f6 {
    @NotNull
    public static final Annotations a(@NotNull Annotations annotations, @NotNull Annotations annotations2) {
        b41.i(annotations, ShareperfenceConstants.FIRST);
        b41.i(annotations2, "second");
        return annotations.isEmpty() ? annotations2 : annotations2.isEmpty() ? annotations : new CompositeAnnotations(annotations, annotations2);
    }
}
