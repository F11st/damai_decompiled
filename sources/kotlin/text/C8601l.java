package kotlin.text;

import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.text.l */
/* loaded from: classes3.dex */
public class C8601l extends C8600k {
    @NotNull
    public static StringBuilder g(@NotNull StringBuilder sb, @NotNull String... strArr) {
        b41.i(sb, "<this>");
        b41.i(strArr, "value");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }
}
