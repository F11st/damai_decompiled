package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0086\b¨\u0006\u0002"}, d2 = {"", "htmlEncode", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StringKt {
    @NotNull
    public static final String htmlEncode(@NotNull String str) {
        b41.i(str, "<this>");
        String htmlEncode = TextUtils.htmlEncode(str);
        b41.h(htmlEncode, "htmlEncode(this)");
        return htmlEncode;
    }
}
