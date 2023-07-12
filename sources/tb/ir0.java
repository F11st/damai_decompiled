package tb;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ir0 extends LinearGradient {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ir0(float f, float f2, float f3, float f4, @NotNull int[] iArr, @Nullable float[] fArr, @NotNull Shader.TileMode tileMode) {
        super(f, f2, f3, f4, iArr, fArr, tileMode);
        b41.i(iArr, "colors");
        b41.i(tileMode, "tile");
    }
}
