package tb;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class zq0 implements GXRegisterCenter.GXIExtensionExpression {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    @NotNull
    public GXIExpression create(@Nullable String str, @Nullable String str2, @NotNull Object obj) {
        b41.i(obj, "value");
        return new yp0(obj);
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    public boolean isTrue(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
        return b41.d(obj, Boolean.TRUE);
    }
}
