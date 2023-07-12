package tb;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class nf2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private List<t71> b;

    /* compiled from: Taobao */
    /* renamed from: tb.nf2$a */
    /* loaded from: classes4.dex */
    static /* synthetic */ class C9472a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ColumnDbType.values().length];
            a = iArr;
            try {
                iArr[ColumnDbType.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ColumnDbType.REAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ColumnDbType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ColumnDbType.BLOB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public nf2() {
    }

    public void a(t71 t71Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731917181")) {
            ipChange.ipc$dispatch("1731917181", new Object[]{this, t71Var});
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(t71Var);
    }

    public void b(List<t71> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875306409")) {
            ipChange.ipc$dispatch("1875306409", new Object[]{this, list});
            return;
        }
        List<t71> list2 = this.b;
        if (list2 == null) {
            this.b = list;
        } else {
            list2.addAll(list);
        }
    }

    public SQLiteStatement c(SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580003372")) {
            return (SQLiteStatement) ipChange.ipc$dispatch("580003372", new Object[]{this, sQLiteDatabase});
        }
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(this.a);
        if (this.b != null) {
            for (int i = 1; i < this.b.size() + 1; i++) {
                Object a = wk.a(this.b.get(i - 1).b);
                if (a == null) {
                    compileStatement.bindNull(i);
                } else {
                    int i2 = C9472a.a[tk.a(a.getClass()).getColumnDbType().ordinal()];
                    if (i2 == 1) {
                        compileStatement.bindLong(i, ((Number) a).longValue());
                    } else if (i2 == 2) {
                        compileStatement.bindDouble(i, ((Number) a).doubleValue());
                    } else if (i2 == 3) {
                        compileStatement.bindString(i, a.toString());
                    } else if (i2 != 4) {
                        compileStatement.bindNull(i);
                    } else {
                        compileStatement.bindBlob(i, (byte[]) a);
                    }
                }
            }
        }
        return compileStatement;
    }

    public String[] d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246640536")) {
            return (String[]) ipChange.ipc$dispatch("246640536", new Object[]{this});
        }
        List<t71> list = this.b;
        if (list != null) {
            String[] strArr = new String[list.size()];
            for (int i = 0; i < this.b.size(); i++) {
                Object a = wk.a(this.b.get(i).b);
                strArr[i] = a == null ? null : a.toString();
            }
            return strArr;
        }
        return null;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-331908351") ? (String) ipChange.ipc$dispatch("-331908351", new Object[]{this}) : this.a;
    }

    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280676203")) {
            ipChange.ipc$dispatch("-280676203", new Object[]{this, str});
        } else {
            this.a = str;
        }
    }

    public nf2(String str) {
        this.a = str;
    }
}
