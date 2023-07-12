package com.youku.gaiax.js.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/js/utils/Log;", "", "", "isLog", "", "msg", "Ltb/wt2;", "d", "e", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Log {
    @NotNull
    public static final Log INSTANCE = new Log();

    private Log() {
    }

    public final void d(@NotNull String str) {
        b41.i(str, "msg");
        e(str);
    }

    public final void e(@NotNull String str) {
        b41.i(str, "msg");
        int length = str.length() / 1000;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            int i3 = i * 1000;
            int i4 = i2 * 1000;
            if (i4 > str.length()) {
                i4 = str.length();
            }
            String substring = str.substring(i3, i4);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            android.util.Log.e("[GaiaX][JS]", substring);
            if (i == length) {
                return;
            }
            i = i2;
        }
    }

    public final boolean isLog() {
        return b41.d("1", SystemProp.INSTANCE.get("debug.gaiax.js.log", "0"));
    }
}
