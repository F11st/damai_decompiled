package kotlin.reflect;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KDeclarationContainer {
    @NotNull
    Collection<KCallable<?>> getMembers();
}
