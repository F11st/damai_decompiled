package com.alient.gaiax.container.util;

import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/alient/gaiax/container/util/UrlUtil;", "", "", "urlStr", "paramName", "getParamValue", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class UrlUtil {
    @NotNull
    public static final UrlUtil INSTANCE = new UrlUtil();

    private UrlUtil() {
    }

    @Nullable
    public final String getParamValue(@NotNull String str, @NotNull String str2) {
        int Z;
        List t0;
        int Z2;
        b41.i(str, "urlStr");
        b41.i(str2, "paramName");
        int i = 0;
        if (str.length() > 0) {
            Z = StringsKt__StringsKt.Z(str, "?", 0, false, 6, null);
            if (Z >= 0) {
                str = str.substring(Z + 1);
                b41.h(str, "(this as java.lang.String).substring(startIndex)");
            }
            t0 = StringsKt__StringsKt.t0(str, new String[]{"&"}, false, 0, 6, null);
            Object[] array = t0.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            String r = b41.r(str2, "=");
            int length = strArr.length;
            while (i < length) {
                String str3 = strArr[i];
                i++;
                Z2 = StringsKt__StringsKt.Z(str3, r, 0, false, 6, null);
                if (Z2 == 0) {
                    int length2 = r.length();
                    Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                    String substring = str3.substring(length2);
                    b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                    return substring;
                }
            }
            return null;
        }
        return null;
    }
}
