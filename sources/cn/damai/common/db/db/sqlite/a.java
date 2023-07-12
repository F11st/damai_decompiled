package cn.damai.common.db.db.sqlite;

import cn.damai.common.db.commonutil.util.KeyValue;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;
import tb.nf2;
import tb.q13;
import tb.t71;
import tb.tk2;
import tb.uk;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public final class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final ConcurrentHashMap<tk2<?>, String> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<tk2<?>, String> b = new ConcurrentHashMap<>();

    public static nf2 a(tk2<?> tk2Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974369115")) {
            return (nf2) ipChange.ipc$dispatch("-974369115", new Object[]{tk2Var});
        }
        uk e = tk2Var.e();
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("\"");
        sb.append(tk2Var.f());
        sb.append("\"");
        sb.append(" ( ");
        if (e.f()) {
            sb.append("\"");
            sb.append(e.d());
            sb.append("\"");
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        } else {
            sb.append("\"");
            sb.append(e.d());
            sb.append("\"");
            sb.append(e.a());
            sb.append(" PRIMARY KEY, ");
        }
        for (uk ukVar : tk2Var.b().values()) {
            if (!ukVar.g()) {
                sb.append("\"");
                sb.append(ukVar.d());
                sb.append("\"");
                sb.append(' ');
                sb.append(ukVar.a());
                sb.append(' ');
                sb.append(ukVar.e());
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" )");
        return new nf2(sb.toString());
    }

    public static nf2 b(tk2<?> tk2Var, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060132672")) {
            return (nf2) ipChange.ipc$dispatch("1060132672", new Object[]{tk2Var, obj});
        }
        nf2 nf2Var = new nf2();
        uk e = tk2Var.e();
        Object b2 = e.b(obj);
        if (b2 != null) {
            nf2Var.f("DELETE FROM \"" + tk2Var.f() + "\" WHERE " + q13.c(e.d(), "=", b2));
            return nf2Var;
        }
        throw new DbException("this entity[" + tk2Var.d() + "]'s id value is null");
    }

    public static nf2 c(tk2<?> tk2Var, q13 q13Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023988535")) {
            return (nf2) ipChange.ipc$dispatch("2023988535", new Object[]{tk2Var, q13Var});
        }
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append("\"");
        sb.append(tk2Var.f());
        sb.append("\"");
        if (q13Var != null && q13Var.d() > 0) {
            sb.append(" WHERE ");
            sb.append(q13Var.toString());
        }
        return new nf2(sb.toString());
    }

    public static nf2 d(tk2<?> tk2Var, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400982770")) {
            return (nf2) ipChange.ipc$dispatch("-1400982770", new Object[]{tk2Var, obj});
        }
        nf2 nf2Var = new nf2();
        uk e = tk2Var.e();
        if (obj != null) {
            nf2Var.f("DELETE FROM \"" + tk2Var.f() + "\" WHERE " + q13.c(e.d(), "=", obj));
            return nf2Var;
        }
        throw new DbException("this entity[" + tk2Var.d() + "]'s id value is null");
    }

    public static nf2 e(tk2<?> tk2Var, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-955321650")) {
            return (nf2) ipChange.ipc$dispatch("-955321650", new Object[]{tk2Var, obj});
        }
        List<t71> j = j(tk2Var, obj);
        if (j.size() == 0) {
            return null;
        }
        nf2 nf2Var = new nf2();
        String str = a.get(tk2Var);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ");
            sb.append("\"");
            sb.append(tk2Var.f());
            sb.append("\"");
            sb.append(" (");
            for (t71 t71Var : j) {
                sb.append("\"");
                sb.append(t71Var.a);
                sb.append("\"");
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") VALUES (");
            int size = j.size();
            for (int i = 0; i < size; i++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(jn1.BRACKET_END_STR);
            String sb2 = sb.toString();
            nf2Var.f(sb2);
            nf2Var.b(j);
            a.put(tk2Var, sb2);
        } else {
            nf2Var.f(str);
            nf2Var.b(j);
        }
        return nf2Var;
    }

    public static nf2 f(tk2<?> tk2Var, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091998645")) {
            return (nf2) ipChange.ipc$dispatch("-1091998645", new Object[]{tk2Var, obj});
        }
        List<t71> j = j(tk2Var, obj);
        if (j.size() == 0) {
            return null;
        }
        nf2 nf2Var = new nf2();
        String str = b.get(tk2Var);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("REPLACE INTO ");
            sb.append("\"");
            sb.append(tk2Var.f());
            sb.append("\"");
            sb.append(" (");
            for (t71 t71Var : j) {
                sb.append("\"");
                sb.append(t71Var.a);
                sb.append("\"");
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") VALUES (");
            int size = j.size();
            for (int i = 0; i < size; i++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(jn1.BRACKET_END_STR);
            String sb2 = sb.toString();
            nf2Var.f(sb2);
            nf2Var.b(j);
            b.put(tk2Var, sb2);
        } else {
            nf2Var.f(str);
            nf2Var.b(j);
        }
        return nf2Var;
    }

    public static nf2 g(tk2<?> tk2Var, Object obj, String... strArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2030629385")) {
            return (nf2) ipChange.ipc$dispatch("2030629385", new Object[]{tk2Var, obj, strArr});
        }
        List<t71> j = j(tk2Var, obj);
        HashSet hashSet = null;
        if (j.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        uk e = tk2Var.e();
        Object b2 = e.b(obj);
        if (b2 != null) {
            nf2 nf2Var = new nf2();
            StringBuilder sb = new StringBuilder("UPDATE ");
            sb.append("\"");
            sb.append(tk2Var.f());
            sb.append("\"");
            sb.append(" SET ");
            for (t71 t71Var : j) {
                if (hashSet == null || hashSet.contains(t71Var.a)) {
                    sb.append("\"");
                    sb.append(t71Var.a);
                    sb.append("\"");
                    sb.append("=?,");
                    nf2Var.a(t71Var);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(" WHERE ");
            sb.append(q13.c(e.d(), "=", b2));
            nf2Var.f(sb.toString());
            return nf2Var;
        }
        throw new DbException("this entity[" + tk2Var.d() + "]'s id value is null");
    }

    public static nf2 h(tk2<?> tk2Var, q13 q13Var, KeyValue... keyValueArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330120818")) {
            return (nf2) ipChange.ipc$dispatch("1330120818", new Object[]{tk2Var, q13Var, keyValueArr});
        }
        if (keyValueArr == null || keyValueArr.length == 0) {
            return null;
        }
        nf2 nf2Var = new nf2();
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append("\"");
        sb.append(tk2Var.f());
        sb.append("\"");
        sb.append(" SET ");
        for (KeyValue keyValue : keyValueArr) {
            sb.append("\"");
            sb.append(keyValue.a);
            sb.append("\"");
            sb.append("=?,");
            nf2Var.a(keyValue);
        }
        sb.deleteCharAt(sb.length() - 1);
        if (q13Var != null && q13Var.d() > 0) {
            sb.append(" WHERE ");
            sb.append(q13Var.toString());
        }
        nf2Var.f(sb.toString());
        return nf2Var;
    }

    private static t71 i(Object obj, uk ukVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182155706")) {
            return (t71) ipChange.ipc$dispatch("182155706", new Object[]{obj, ukVar});
        }
        if (ukVar.f()) {
            return null;
        }
        return new t71(ukVar.d(), ukVar.c(obj));
    }

    public static List<t71> j(tk2<?> tk2Var, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386811162")) {
            return (List) ipChange.ipc$dispatch("-386811162", new Object[]{tk2Var, obj});
        }
        Collection<uk> values = tk2Var.b().values();
        ArrayList arrayList = new ArrayList(values.size());
        for (uk ukVar : values) {
            t71 i = i(obj, ukVar);
            if (i != null) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
