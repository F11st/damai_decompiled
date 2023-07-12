package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class fd2 extends gu2 implements SimpleTypeMarker, TypeArgumentListMarker {
    public fd2() {
        super(null);
    }

    @NotNull
    public abstract fd2 j(boolean z);

    @NotNull
    public abstract fd2 k(@NotNull Annotations annotations);

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            kotlin.text.g.g(sb, jn1.ARRAY_START_STR, DescriptorRenderer.c(DescriptorRenderer.DEBUG_TEXT, it.next(), null, 2, null), "] ");
        }
        sb.append(c());
        if (!b().isEmpty()) {
            kotlin.collections.k.X(b(), sb, AVFSCacheConstants.COMMA_SEP, jn1.L, jn1.G, 0, null, null, 112, null);
        }
        if (d()) {
            sb.append("?");
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
