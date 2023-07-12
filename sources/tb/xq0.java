package tb;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class xq0 {
    @NotNull
    public static final xq0 INSTANCE = new xq0();

    private xq0() {
    }

    @Nullable
    public final GXIExpression a(@Nullable String str, @Nullable Object obj) {
        GXRegisterCenter.GXIExtensionExpression j;
        if (obj == null || (j = GXRegisterCenter.Companion.a().j()) == null) {
            return null;
        }
        return j.create(str, null, obj);
    }

    @Nullable
    public final GXIExpression b(@Nullable String str, @NotNull String str2, @Nullable Object obj) {
        GXRegisterCenter.GXIExtensionExpression j;
        b41.i(str2, "key");
        if (obj == null || (j = GXRegisterCenter.Companion.a().j()) == null) {
            return null;
        }
        return j.create(str, str2, obj);
    }

    @Nullable
    public final Boolean c(@Nullable String str, @Nullable Object obj) {
        GXRegisterCenter.GXIExtensionExpression j = GXRegisterCenter.Companion.a().j();
        if (j == null) {
            return null;
        }
        return Boolean.valueOf(j.isTrue(str, null, obj));
    }
}
