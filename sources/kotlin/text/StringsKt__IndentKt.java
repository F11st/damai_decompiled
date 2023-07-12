package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StringsKt__IndentKt extends h {
    private static final Function1<String, String> b(final String str) {
        return str.length() == 0 ? new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull String str2) {
                b41.i(str2, "line");
                return str2;
            }
        } : new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull String str2) {
                b41.i(str2, "line");
                return str + str2;
            }
        };
    }

    private static final int c(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!a.c(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    @NotNull
    public static final String d(@NotNull String str, @NotNull String str2) {
        String invoke;
        b41.i(str, "<this>");
        b41.i(str2, "newIndent");
        List<String> i0 = StringsKt__StringsKt.i0(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : i0) {
            if (!g.s((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.k.q(arrayList, 10));
        for (String str3 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str3)));
        }
        Integer num = (Integer) kotlin.collections.k.h0(arrayList2);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * i0.size());
        Function1<String, String> b = b(str2);
        int i2 = kotlin.collections.k.i(i0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : i0) {
            int i3 = i + 1;
            if (i < 0) {
                kotlin.collections.k.p();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == i2) && g.s(str4)) {
                str4 = null;
            } else {
                String N0 = q.N0(str4, intValue);
                if (N0 != null && (invoke = b.invoke(N0)) != null) {
                    str4 = invoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i3;
        }
        String sb = ((StringBuilder) kotlin.collections.k.X(arrayList3, new StringBuilder(length), StringUtils.LF, null, null, 0, null, null, 124, null)).toString();
        b41.h(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    @NotNull
    public static String e(@NotNull String str) {
        b41.i(str, "<this>");
        return d(str, "");
    }
}
