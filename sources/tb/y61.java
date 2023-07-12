package tb;

import com.youku.vpm.track.OnePlayTrack;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8225w;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class y61 implements NameResolver {
    @NotNull
    public static final C9953a Companion = new C9953a(null);
    @NotNull
    private static final String e;
    @NotNull
    private static final List<String> f;
    @NotNull
    private final JvmProtoBuf.StringTableTypes a;
    @NotNull
    private final String[] b;
    @NotNull
    private final Set<Integer> c;
    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> d;

    /* compiled from: Taobao */
    /* renamed from: tb.y61$a */
    /* loaded from: classes3.dex */
    public static final class C9953a {
        private C9953a() {
        }

        public /* synthetic */ C9953a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.y61$b */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C9954b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        List j;
        String Z;
        List<String> j2;
        Iterable<i21> G0;
        int q;
        int e2;
        int a;
        j = C8214m.j('k', 'o', 't', 'l', 'i', 'n');
        Z = CollectionsKt___CollectionsKt.Z(j, "", null, null, 0, null, null, 62, null);
        e = Z;
        j2 = C8214m.j(b41.r(Z, "/Any"), b41.r(Z, "/Nothing"), b41.r(Z, "/Unit"), b41.r(Z, "/Throwable"), b41.r(Z, "/Number"), b41.r(Z, "/Byte"), b41.r(Z, "/Double"), b41.r(Z, "/Float"), b41.r(Z, "/Int"), b41.r(Z, "/Long"), b41.r(Z, "/Short"), b41.r(Z, "/Boolean"), b41.r(Z, "/Char"), b41.r(Z, "/CharSequence"), b41.r(Z, "/String"), b41.r(Z, "/Comparable"), b41.r(Z, "/Enum"), b41.r(Z, "/Array"), b41.r(Z, "/ByteArray"), b41.r(Z, "/DoubleArray"), b41.r(Z, "/FloatArray"), b41.r(Z, "/IntArray"), b41.r(Z, "/LongArray"), b41.r(Z, "/ShortArray"), b41.r(Z, "/BooleanArray"), b41.r(Z, "/CharArray"), b41.r(Z, "/Cloneable"), b41.r(Z, "/Annotation"), b41.r(Z, "/collections/Iterable"), b41.r(Z, "/collections/MutableIterable"), b41.r(Z, "/collections/Collection"), b41.r(Z, "/collections/MutableCollection"), b41.r(Z, "/collections/List"), b41.r(Z, "/collections/MutableList"), b41.r(Z, "/collections/Set"), b41.r(Z, "/collections/MutableSet"), b41.r(Z, "/collections/Map"), b41.r(Z, "/collections/MutableMap"), b41.r(Z, "/collections/Map.Entry"), b41.r(Z, "/collections/MutableMap.MutableEntry"), b41.r(Z, "/collections/Iterator"), b41.r(Z, "/collections/MutableIterator"), b41.r(Z, "/collections/ListIterator"), b41.r(Z, "/collections/MutableListIterator"));
        f = j2;
        G0 = CollectionsKt___CollectionsKt.G0(j2);
        q = C8215n.q(G0, 10);
        e2 = C8225w.e(q);
        a = ty1.a(e2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a);
        for (i21 i21Var : G0) {
            linkedHashMap.put((String) i21Var.d(), Integer.valueOf(i21Var.c()));
        }
    }

    public y61(@NotNull JvmProtoBuf.StringTableTypes stringTableTypes, @NotNull String[] strArr) {
        Set<Integer> E0;
        b41.i(stringTableTypes, "types");
        b41.i(strArr, "strings");
        this.a = stringTableTypes;
        this.b = strArr;
        List<Integer> localNameList = stringTableTypes.getLocalNameList();
        if (localNameList.isEmpty()) {
            E0 = C8203e0.d();
        } else {
            b41.h(localNameList, "");
            E0 = CollectionsKt___CollectionsKt.E0(localNameList);
        }
        this.c = E0;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = a().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
            int range = record.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        wt2 wt2Var = wt2.INSTANCE;
        this.d = arrayList;
    }

    @NotNull
    public final JvmProtoBuf.StringTableTypes a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.d.get(i);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = f;
                int size = list.size() - 1;
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex <= size) {
                    str = list.get(record.getPredefinedIndex());
                }
            }
            str = this.b[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            b41.h(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            b41.h(num, OnePlayTrack.PlayType.BEGIN);
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                b41.h(num2, "end");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    b41.h(str, "string");
                    str = str.substring(num.intValue(), num2.intValue());
                    b41.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            b41.h(replaceCharList, "replaceCharList");
            b41.h(str2, "string");
            str2 = C8604o.y(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = C9954b.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 == 2) {
            b41.h(str3, "string");
            str3 = C8604o.y(str3, '$', '.', false, 4, null);
        } else if (i2 == 3) {
            if (str3.length() >= 2) {
                b41.h(str3, "string");
                str3 = str3.substring(1, str3.length() - 1);
                b41.h(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str4 = str3;
            b41.h(str4, "string");
            str3 = C8604o.y(str4, '$', '.', false, 4, null);
        }
        b41.h(str3, "string");
        return str3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.c.contains(Integer.valueOf(i));
    }
}
