package tb;

import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8214m;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class jj {
    @NotNull
    public static final jj INSTANCE = new jj();
    @NotNull
    private static final String a;
    @NotNull
    private static final Map<String, String> b;

    static {
        List j;
        String Z;
        List j2;
        List<String> j3;
        List<String> j4;
        List<String> j5;
        int i = 0;
        j = C8214m.j('k', 'o', 't', 'l', 'i', 'n');
        Z = CollectionsKt___CollectionsKt.Z(j, "", null, null, 0, null, null, 62, null);
        a = Z;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        j2 = C8214m.j("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", UTConstant.Args.UT_SUCCESS_F, "Long", "J", "Double", "D");
        int c = hv1.c(0, j2.size() - 1, 2);
        if (c >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                StringBuilder sb = new StringBuilder();
                String str = a;
                sb.append(str);
                sb.append(r10.DIR);
                sb.append((String) j2.get(i2));
                int i4 = i2 + 1;
                linkedHashMap.put(sb.toString(), j2.get(i4));
                linkedHashMap.put(str + r10.DIR + ((String) j2.get(i2)) + "Array", b41.r(jn1.ARRAY_START_STR, j2.get(i4)));
                if (i2 == c) {
                    break;
                }
                i2 = i3;
            }
        }
        linkedHashMap.put(b41.r(a, "/Unit"), "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        j3 = C8214m.j("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum");
        for (String str2 : j3) {
            a(linkedHashMap, str2, b41.r("java/lang/", str2));
        }
        j4 = C8214m.j("Iterator", "Collection", "List", "Set", "Map", "ListIterator");
        for (String str3 : j4) {
            a(linkedHashMap, b41.r("collections/", str3), b41.r("java/util/", str3));
            a(linkedHashMap, b41.r("collections/Mutable", str3), b41.r("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String r = b41.r("Function", Integer.valueOf(i));
            StringBuilder sb2 = new StringBuilder();
            String str4 = a;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i);
            a(linkedHashMap, r, sb2.toString());
            a(linkedHashMap, b41.r("reflect/KFunction", Integer.valueOf(i)), b41.r(str4, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            }
            i = i5;
        }
        j5 = C8214m.j("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum");
        for (String str5 : j5) {
            a(linkedHashMap, b41.r(str5, ".Companion"), a + "/jvm/internal/" + str5 + "CompanionObject");
        }
        b = linkedHashMap;
    }

    private jj() {
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(a + r10.DIR + str, qb1.LEVEL_L + str2 + b90.TokenSEM);
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String str) {
        String y;
        b41.i(str, "classId");
        String str2 = b.get(str);
        if (str2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(qb1.LEVEL_L);
            y = C8604o.y(str, '.', '$', false, 4, null);
            sb.append(y);
            sb.append(b90.TokenSEM);
            return sb.toString();
        }
        return str2;
    }
}
