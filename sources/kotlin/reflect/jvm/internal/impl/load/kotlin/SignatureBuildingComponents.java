package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.b90;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SignatureBuildingComponents {
    @NotNull
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() > 1) {
            return qb1.LEVEL_L + str + b90.TokenSEM;
        }
        return str;
    }

    @NotNull
    public final String[] b(@NotNull String... strArr) {
        b41.i(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    @NotNull
    public final Set<String> d(@NotNull String str, @NotNull String... strArr) {
        b41.i(str, "internalName");
        b41.i(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> e(@NotNull String str, @NotNull String... strArr) {
        b41.i(str, "name");
        b41.i(strArr, "signatures");
        return d(h(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final Set<String> f(@NotNull String str, @NotNull String... strArr) {
        b41.i(str, "name");
        b41.i(strArr, "signatures");
        return d(i(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final String g(@NotNull String str) {
        b41.i(str, "name");
        return b41.r("java/util/function/", str);
    }

    @NotNull
    public final String h(@NotNull String str) {
        b41.i(str, "name");
        return b41.r("java/lang/", str);
    }

    @NotNull
    public final String i(@NotNull String str) {
        b41.i(str, "name");
        return b41.r("java/util/", str);
    }

    @NotNull
    public final String j(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        String Z;
        b41.i(str, "name");
        b41.i(list, PushConstants.PARAMS);
        b41.i(str2, "ret");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('(');
        Z = CollectionsKt___CollectionsKt.Z(list, "", null, null, 0, null, new Function1<String, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$jvmDescriptor$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull String str3) {
                String c;
                b41.i(str3, AdvanceSetting.NETWORK_TYPE);
                c = SignatureBuildingComponents.INSTANCE.c(str3);
                return c;
            }
        }, 30, null);
        sb.append(Z);
        sb.append(')');
        sb.append(c(str2));
        return sb.toString();
    }

    @NotNull
    public final String k(@NotNull String str, @NotNull String str2) {
        b41.i(str, "internalName");
        b41.i(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
