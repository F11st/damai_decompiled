package tb;

import android.database.Cursor;
import cn.damai.common.db.ex.DbException;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class da2<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final tk2<T> a;
    private q13 b;
    private List<C9038a> c;
    private int d = 0;
    private int e = 0;

    /* compiled from: Taobao */
    /* renamed from: tb.da2$a */
    /* loaded from: classes4.dex */
    public static class C9038a {
        private static transient /* synthetic */ IpChange $ipChange;
        private String a;
        private boolean b;

        public C9038a(String str) {
            this.a = str;
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "334735790")) {
                return (String) ipChange.ipc$dispatch("334735790", new Object[]{this});
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(this.a);
            sb.append("\"");
            sb.append(this.b ? " DESC" : " ASC");
            return sb.toString();
        }
    }

    private da2(tk2<T> tk2Var) {
        this.a = tk2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> da2<T> e(tk2<T> tk2Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1353045590") ? (da2) ipChange.ipc$dispatch("1353045590", new Object[]{tk2Var}) : new da2<>(tk2Var);
    }

    public da2<T> a(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1827511")) {
            return (da2) ipChange.ipc$dispatch("1827511", new Object[]{this, str, str2, obj});
        }
        this.b.a(str, str2, obj);
        return this;
    }

    public long b() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378641646")) {
            return ((Long) ipChange.ipc$dispatch("-378641646", new Object[]{this})).longValue();
        }
        if (this.a.j()) {
            g40 a = n("count(\"" + this.a.e().d() + "\") as count").a();
            if (a != null) {
                return a.b(AdUtConstants.XAD_UT_ARG_COUNT);
            }
            return 0L;
        }
        return 0L;
    }

    public List<T> c() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469090494")) {
            return (List) ipChange.ipc$dispatch("-1469090494", new Object[]{this});
        }
        ArrayList arrayList = null;
        if (this.a.j()) {
            Cursor execQuery = this.a.c().execQuery(toString());
            if (execQuery != null) {
                try {
                    arrayList = new ArrayList();
                    while (execQuery.moveToNext()) {
                        arrayList.add(jq.b(this.a, execQuery));
                    }
                } finally {
                }
            }
            return arrayList;
        }
        return null;
    }

    public T d() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826349884")) {
            return (T) ipChange.ipc$dispatch("1826349884", new Object[]{this});
        }
        if (this.a.j()) {
            k(1);
            Cursor execQuery = this.a.c().execQuery(toString());
            if (execQuery != null) {
                try {
                    if (execQuery.moveToNext()) {
                        return (T) jq.b(this.a, execQuery);
                    }
                } finally {
                }
            }
            return null;
        }
        return null;
    }

    public int f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1087787307") ? ((Integer) ipChange.ipc$dispatch("1087787307", new Object[]{this})).intValue() : this.d;
    }

    public int g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-47081897") ? ((Integer) ipChange.ipc$dispatch("-47081897", new Object[]{this})).intValue() : this.e;
    }

    public List<C9038a> h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-142984873") ? (List) ipChange.ipc$dispatch("-142984873", new Object[]{this}) : this.c;
    }

    public tk2<T> i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "150142991") ? (tk2) ipChange.ipc$dispatch("150142991", new Object[]{this}) : this.a;
    }

    public q13 j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "355641798") ? (q13) ipChange.ipc$dispatch("355641798", new Object[]{this}) : this.b;
    }

    public da2<T> k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685049396")) {
            return (da2) ipChange.ipc$dispatch("-1685049396", new Object[]{this, Integer.valueOf(i)});
        }
        this.d = i;
        return this;
    }

    public da2<T> l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488997692")) {
            return (da2) ipChange.ipc$dispatch("-488997692", new Object[]{this, Integer.valueOf(i)});
        }
        this.e = i;
        return this;
    }

    public da2<T> m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770309643")) {
            return (da2) ipChange.ipc$dispatch("770309643", new Object[]{this, str});
        }
        if (this.c == null) {
            this.c = new ArrayList(5);
        }
        this.c.add(new C9038a(str));
        return this;
    }

    public h40 n(String... strArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-102045138") ? (h40) ipChange.ipc$dispatch("-102045138", new Object[]{this, strArr}) : new h40(this, strArr);
    }

    public da2<T> o(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449223623")) {
            return (da2) ipChange.ipc$dispatch("449223623", new Object[]{this, str, str2, obj});
        }
        this.b = q13.c(str, str2, obj);
        return this;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905354929")) {
            return (String) ipChange.ipc$dispatch("-905354929", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(jn1.MUL);
        sb.append(" FROM ");
        sb.append("\"");
        sb.append(this.a.f());
        sb.append("\"");
        q13 q13Var = this.b;
        if (q13Var != null && q13Var.d() > 0) {
            sb.append(" WHERE ");
            sb.append(this.b.toString());
        }
        List<C9038a> list = this.c;
        if (list != null && list.size() > 0) {
            sb.append(" ORDER BY ");
            for (C9038a c9038a : this.c) {
                sb.append(c9038a.toString());
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.d > 0) {
            sb.append(" LIMIT ");
            sb.append(this.d);
            sb.append(" OFFSET ");
            sb.append(this.e);
        }
        return sb.toString();
    }
}
