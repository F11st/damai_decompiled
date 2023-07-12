package tb;

import android.database.Cursor;
import android.text.TextUtils;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.da2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class h40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String[] a;
    private String b;
    private q13 c;
    private da2<?> d;

    /* JADX INFO: Access modifiers changed from: protected */
    public h40(da2<?> da2Var, String[] strArr) {
        this.d = da2Var;
        this.a = strArr;
    }

    public g40 a() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901127995")) {
            return (g40) ipChange.ipc$dispatch("-901127995", new Object[]{this});
        }
        tk2<?> i = this.d.i();
        if (i.j()) {
            b(1);
            Cursor execQuery = i.c().execQuery(toString());
            if (execQuery != null) {
                try {
                    if (execQuery.moveToNext()) {
                        return jq.a(execQuery);
                    }
                } finally {
                }
            }
            return null;
        }
        return null;
    }

    public h40 b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1722956994")) {
            return (h40) ipChange.ipc$dispatch("1722956994", new Object[]{this, Integer.valueOf(i)});
        }
        this.d.k(i);
        return this;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142785586")) {
            return (String) ipChange.ipc$dispatch("-142785586", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        String[] strArr = this.a;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                sb.append(str);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        } else if (!TextUtils.isEmpty(this.b)) {
            sb.append(this.b);
        } else {
            sb.append(jn1.MUL);
        }
        sb.append(" FROM ");
        sb.append("\"");
        sb.append(this.d.i().f());
        sb.append("\"");
        q13 j = this.d.j();
        if (j != null && j.d() > 0) {
            sb.append(" WHERE ");
            sb.append(j.toString());
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" GROUP BY ");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
            q13 q13Var = this.c;
            if (q13Var != null && q13Var.d() > 0) {
                sb.append(" HAVING ");
                sb.append(this.c.toString());
            }
        }
        List<da2.C9038a> h = this.d.h();
        if (h != null && h.size() > 0) {
            for (int i = 0; i < h.size(); i++) {
                sb.append(" ORDER BY ");
                sb.append(h.get(i).toString());
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.d.f() > 0) {
            sb.append(" LIMIT ");
            sb.append(this.d.f());
            sb.append(" OFFSET ");
            sb.append(this.d.g());
        }
        return sb.toString();
    }
}
