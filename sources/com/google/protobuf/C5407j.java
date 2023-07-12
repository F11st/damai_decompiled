package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.taobao.weex.annotation.JSMethod;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;
import tb.gn1;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.google.protobuf.j */
/* loaded from: classes10.dex */
public final class C5407j {
    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(JSMethod.NOT_SET);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        } else if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        } else if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            return obj instanceof MessageLite ? obj == ((MessageLite) obj).getDefaultInstanceForType() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void c(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                c(sb, i, str, obj2);
            }
            return;
        }
        sb.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.c((String) obj));
            sb.append(jn1.QUOTE);
        } else if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.a((ByteString) obj));
            sb.append(jn1.QUOTE);
        } else if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            d((GeneratedMessageLite) obj, sb, i + 2);
            sb.append(StringUtils.LF);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append("}");
        } else {
            sb.append(": ");
            sb.append(obj.toString());
        }
    }

    private static void d(MessageLite messageLite, StringBuilder sb, int i) {
        Method[] declaredMethods;
        Map.Entry<GeneratedMessageLite.C5380d, Object> next;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith(gn1.TYPE_OPEN_URL_METHOD_GET)) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst(gn1.TYPE_OPEN_URL_METHOD_GET, "");
            boolean z = true;
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList")) {
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get(gn1.TYPE_OPEN_URL_METHOD_GET + replaceFirst);
                if (method2 != null) {
                    c(sb, i, a(str2), GeneratedMessageLite.o(method2, messageLite, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    if (hashMap.containsKey(gn1.TYPE_OPEN_URL_METHOD_GET + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str3 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method3 = (Method) hashMap.get(gn1.TYPE_OPEN_URL_METHOD_GET + replaceFirst);
                Method method4 = (Method) hashMap.get("has" + replaceFirst);
                if (method3 != null) {
                    Object o = GeneratedMessageLite.o(method3, messageLite, new Object[0]);
                    if (method4 == null) {
                        if (b(o)) {
                            z = false;
                        }
                    } else {
                        z = ((Boolean) GeneratedMessageLite.o(method4, messageLite, new Object[0])).booleanValue();
                    }
                    if (z) {
                        c(sb, i, a(str3), o);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.AbstractC5379c) {
            Iterator<Map.Entry<GeneratedMessageLite.C5380d, Object>> j = ((GeneratedMessageLite.AbstractC5379c) messageLite).d.j();
            while (j.hasNext()) {
                c(sb, i, jn1.ARRAY_START_STR + next.getKey().getNumber() + jn1.ARRAY_END_STR, j.next().getValue());
            }
        }
        C5417m c5417m = ((GeneratedMessageLite) messageLite).b;
        if (c5417m != null) {
            c5417m.d(sb, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(messageLite, sb, 0);
        return sb.toString();
    }
}
