package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"", "Landroid/util/Half;", "toHalf", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(short s) {
        Half valueOf = Half.valueOf(s);
        b41.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(float f) {
        Half valueOf = Half.valueOf(f);
        b41.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(@NotNull String str) {
        b41.i(str, "<this>");
        Half valueOf = Half.valueOf(str);
        b41.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(double d) {
        Half valueOf = Half.valueOf((float) d);
        b41.h(valueOf, "valueOf(this)");
        return valueOf;
    }
}
