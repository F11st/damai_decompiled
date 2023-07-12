package tb;

import android.text.TextUtils;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class q13 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<String> a = new ArrayList();

    private q13() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    private void b(String str, String str2, String str3, Object obj) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-359708904")) {
            ipChange.ipc$dispatch("-359708904", new Object[]{this, str, str2, str3, obj});
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (this.a.size() > 0) {
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        sb.append("\"");
        sb.append(str2);
        sb.append("\"");
        if (jn1.NOT_EQUAL2.equals(str3)) {
            str3 = "<>";
        } else if (jn1.EQUAL2.equals(str3)) {
            str3 = "=";
        }
        if (obj == null) {
            if ("=".equals(str3)) {
                sb.append(" IS NULL");
            } else if ("<>".equals(str3)) {
                sb.append(" IS NOT NULL");
            } else {
                sb.append(" ");
                sb.append(str3);
                sb.append(" NULL");
            }
        } else {
            sb.append(" ");
            sb.append(str3);
            sb.append(" ");
            ?? r1 = 0;
            ?? arrayList = 0;
            if ("IN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    arrayList = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    arrayList = new ArrayList(length);
                    while (i < length) {
                        arrayList.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (arrayList != 0) {
                    StringBuilder sb2 = new StringBuilder(jn1.BRACKET_START_STR);
                    for (Object obj2 : arrayList) {
                        Object a = wk.a(obj2);
                        if (ColumnDbType.TEXT.equals(tk.b(a.getClass()))) {
                            String obj3 = a.toString();
                            if (obj3.indexOf(39) != -1) {
                                obj3 = obj3.replace("'", "''");
                            }
                            sb2.append("'");
                            sb2.append(obj3);
                            sb2.append("'");
                        } else {
                            sb2.append(a);
                        }
                        sb2.append(",");
                    }
                    sb2.deleteCharAt(sb2.length() - 1);
                    sb2.append(jn1.BRACKET_END_STR);
                    sb.append(sb2.toString());
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else if ("BETWEEN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    r1 = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    int length2 = Array.getLength(obj);
                    r1 = new ArrayList(length2);
                    while (i < length2) {
                        r1.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (r1 != 0) {
                    Iterator it = r1.iterator();
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (it.hasNext()) {
                            Object next2 = it.next();
                            Object a2 = wk.a(next);
                            Object a3 = wk.a(next2);
                            if (ColumnDbType.TEXT.equals(tk.b(a2.getClass()))) {
                                String obj4 = a2.toString();
                                if (obj4.indexOf(39) != -1) {
                                    obj4 = obj4.replace("'", "''");
                                }
                                String obj5 = a3.toString();
                                if (obj5.indexOf(39) != -1) {
                                    obj5 = obj5.replace("'", "''");
                                }
                                sb.append("'");
                                sb.append(obj4);
                                sb.append("'");
                                sb.append(" AND ");
                                sb.append("'");
                                sb.append(obj5);
                                sb.append("'");
                            } else {
                                sb.append(a2);
                                sb.append(" AND ");
                                sb.append(a3);
                            }
                        } else {
                            throw new IllegalArgumentException("value must have tow items.");
                        }
                    } else {
                        throw new IllegalArgumentException("value must have tow items.");
                    }
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else {
                Object a4 = wk.a(obj);
                if (ColumnDbType.TEXT.equals(tk.b(a4.getClass()))) {
                    String obj6 = a4.toString();
                    if (obj6.indexOf(39) != -1) {
                        obj6 = obj6.replace("'", "''");
                    }
                    sb.append("'");
                    sb.append(obj6);
                    sb.append("'");
                } else {
                    sb.append(a4);
                }
            }
        }
        this.a.add(sb.toString());
    }

    public static q13 c(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404675120")) {
            return (q13) ipChange.ipc$dispatch("-1404675120", new Object[]{str, str2, obj});
        }
        q13 q13Var = new q13();
        q13Var.b(null, str, str2, obj);
        return q13Var;
    }

    public q13 a(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938404795")) {
            return (q13) ipChange.ipc$dispatch("938404795", new Object[]{this, str, str2, obj});
        }
        b(this.a.size() == 0 ? null : "AND", str, str2, obj);
        return this;
    }

    public int d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1138494375") ? ((Integer) ipChange.ipc$dispatch("-1138494375", new Object[]{this})).intValue() : this.a.size();
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012328417")) {
            return (String) ipChange.ipc$dispatch("1012328417", new Object[]{this});
        }
        if (this.a.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.a) {
            sb.append(str);
        }
        return sb.toString();
    }
}
