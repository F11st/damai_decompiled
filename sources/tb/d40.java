package tb;

import android.database.Cursor;
import android.text.TextUtils;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class d40 implements DbManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HashMap<Class<?>, tk2<?>> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tk2<?> tk2Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509562991")) {
            ipChange.ipc$dispatch("-509562991", new Object[]{this, tk2Var});
        } else if (tk2Var.j()) {
        } else {
            synchronized (tk2.class) {
                if (!tk2Var.j()) {
                    execNonQuery(cn.damai.common.db.db.sqlite.a.a(tk2Var));
                    String g = tk2Var.g();
                    if (!TextUtils.isEmpty(g)) {
                        execNonQuery(g);
                    }
                    tk2Var.i(true);
                    DbManager.TableCreateListener f = getDaoConfig().f();
                    if (f != null) {
                        f.onTableCreated(this, tk2Var);
                    }
                }
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void addColumn(Class<?> cls, String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026621086")) {
            ipChange.ipc$dispatch("-1026621086", new Object[]{this, cls, str});
            return;
        }
        tk2 table = getTable(cls);
        uk ukVar = table.b().get(str);
        if (ukVar != null) {
            execNonQuery("ALTER TABLE \"" + table.f() + "\" ADD COLUMN \"" + ukVar.d() + "\" " + ukVar.a() + " " + ukVar.e());
        }
    }

    protected void b(Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100280875")) {
            ipChange.ipc$dispatch("2100280875", new Object[]{this, cls});
            return;
        }
        synchronized (this.a) {
            this.a.remove(cls);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void dropDb() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515650975")) {
            ipChange.ipc$dispatch("-515650975", new Object[]{this});
            return;
        }
        Cursor execQuery = execQuery("SELECT name FROM sqlite_master WHERE type='table' AND name<>'sqlite_sequence'");
        if (execQuery != null) {
            while (execQuery.moveToNext()) {
                try {
                    String string = execQuery.getString(0);
                    execNonQuery("DROP TABLE " + string);
                } catch (Throwable th) {
                    try {
                        throw new DbException(th);
                    } finally {
                        y01.a(execQuery);
                    }
                }
            }
            synchronized (this.a) {
                for (tk2<?> tk2Var : this.a.values()) {
                    tk2Var.i(false);
                }
                this.a.clear();
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void dropTable(Class<?> cls) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "108558432")) {
            ipChange.ipc$dispatch("108558432", new Object[]{this, cls});
            return;
        }
        tk2 table = getTable(cls);
        if (table.j()) {
            execNonQuery("DROP TABLE \"" + table.f() + "\"");
            table.i(false);
            b(cls);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public <T> tk2<T> getTable(Class<T> cls) throws DbException {
        tk2<T> tk2Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401351633")) {
            return (tk2) ipChange.ipc$dispatch("1401351633", new Object[]{this, cls});
        }
        synchronized (this.a) {
            tk2Var = (tk2<T>) this.a.get(cls);
            if (tk2Var == null) {
                tk2Var = new tk2<>(this, cls);
                this.a.put(cls, tk2Var);
            }
        }
        return tk2Var;
    }
}
