package tb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.commonutil.util.KeyValue;
import cn.damai.common.db.db.sqlite.C0497a;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class f40 extends d40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final HashMap<DbManager.C0492a, f40> f = new HashMap<>();
    private SQLiteDatabase b;
    private DbManager.C0492a c;
    private boolean d;
    private Context e;

    private f40(DbManager.C0492a c0492a, Context context) {
        if (c0492a != null) {
            this.e = context;
            this.c = c0492a;
            this.d = c0492a.g();
            this.b = e(c0492a);
            DbManager.DbOpenListener c = c0492a.c();
            if (c != null) {
                c.onDbOpened(this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("daoConfig may not be null");
    }

    private void beginTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12012498")) {
            ipChange.ipc$dispatch("-12012498", new Object[]{this});
        } else if (this.d) {
            if (Build.VERSION.SDK_INT >= 16 && this.b.isWriteAheadLoggingEnabled()) {
                this.b.beginTransactionNonExclusive();
            } else {
                this.b.beginTransaction();
            }
        }
    }

    public static synchronized DbManager c(DbManager.C0492a c0492a, Context context) {
        synchronized (f40.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "114247146")) {
                return (DbManager) ipChange.ipc$dispatch("114247146", new Object[]{c0492a, context});
            }
            if (c0492a == null) {
                c0492a = new DbManager.C0492a();
            }
            HashMap<DbManager.C0492a, f40> hashMap = f;
            f40 f40Var = hashMap.get(c0492a);
            if (f40Var == null) {
                f40Var = new f40(c0492a, context);
                hashMap.put(c0492a, f40Var);
            } else {
                f40Var.c = c0492a;
            }
            SQLiteDatabase sQLiteDatabase = f40Var.b;
            int version = sQLiteDatabase.getVersion();
            int e = c0492a.e();
            if (version != e) {
                if (version != 0) {
                    DbManager.DbUpgradeListener d = c0492a.d();
                    if (d != null) {
                        d.onUpgrade(f40Var, version, e);
                    } else {
                        try {
                            f40Var.dropDb();
                        } catch (DbException e2) {
                            gb1.c(e2.getMessage(), e2);
                        }
                    }
                }
                sQLiteDatabase.setVersion(e);
            }
            return f40Var;
        }
    }

    private long d(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994091118")) {
            return ((Long) ipChange.ipc$dispatch("-994091118", new Object[]{this, str})).longValue();
        }
        Cursor execQuery = execQuery("SELECT seq FROM sqlite_sequence WHERE name='" + str + "' LIMIT 1");
        if (execQuery != null) {
            try {
                r0 = execQuery.moveToNext() ? execQuery.getLong(0) : -1L;
            } finally {
            }
        }
        return r0;
    }

    private SQLiteDatabase e(DbManager.C0492a c0492a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002202280")) {
            return (SQLiteDatabase) ipChange.ipc$dispatch("-1002202280", new Object[]{this, c0492a});
        }
        File a = c0492a.a();
        if (a != null && (a.exists() || a.mkdirs())) {
            return SQLiteDatabase.openOrCreateDatabase(new File(a, c0492a.b()), (SQLiteDatabase.CursorFactory) null);
        }
        return this.e.openOrCreateDatabase(c0492a.b(), 0, null);
    }

    private void endTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103232928")) {
            ipChange.ipc$dispatch("-1103232928", new Object[]{this});
        } else if (this.d) {
            this.b.endTransaction();
        }
    }

    private boolean f(tk2<?> tk2Var, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786603980")) {
            return ((Boolean) ipChange.ipc$dispatch("786603980", new Object[]{this, tk2Var, obj})).booleanValue();
        }
        uk e = tk2Var.e();
        if (e.f()) {
            execNonQuery(C0497a.e(tk2Var, obj));
            long d = d(tk2Var.f());
            if (d == -1) {
                return false;
            }
            e.h(obj, d);
            return true;
        }
        execNonQuery(C0497a.e(tk2Var, obj));
        return true;
    }

    private void g(tk2<?> tk2Var, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640899566")) {
            ipChange.ipc$dispatch("-640899566", new Object[]{this, tk2Var, obj});
            return;
        }
        uk e = tk2Var.e();
        if (e.f()) {
            if (e.b(obj) != null) {
                execNonQuery(C0497a.g(tk2Var, obj, new String[0]));
                return;
            } else {
                f(tk2Var, obj);
                return;
            }
        }
        execNonQuery(C0497a.f(tk2Var, obj));
    }

    private void setTransactionSuccessful() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252512723")) {
            ipChange.ipc$dispatch("-1252512723", new Object[]{this});
        } else if (this.d) {
            this.b.setTransactionSuccessful();
        }
    }

    @Override // cn.damai.common.db.DbManager, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80410641")) {
            ipChange.ipc$dispatch("-80410641", new Object[]{this});
            return;
        }
        HashMap<DbManager.C0492a, f40> hashMap = f;
        if (hashMap.containsKey(this.c)) {
            hashMap.remove(this.c);
            this.b.close();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void delete(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91069292")) {
            ipChange.ipc$dispatch("-91069292", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                tk2 table = getTable(list.get(0).getClass());
                if (!table.j()) {
                    return;
                }
                for (Object obj2 : list) {
                    execNonQuery(C0497a.b(table, obj2));
                }
            } else {
                tk2 table2 = getTable(obj.getClass());
                if (!table2.j()) {
                    return;
                }
                execNonQuery(C0497a.b(table2, obj));
            }
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void deleteById(Class<?> cls, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432975379")) {
            ipChange.ipc$dispatch("1432975379", new Object[]{this, cls, obj});
            return;
        }
        tk2 table = getTable(cls);
        if (table.j()) {
            try {
                beginTransaction();
                execNonQuery(C0497a.d(table, obj));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void execNonQuery(nf2 nf2Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632050052")) {
            ipChange.ipc$dispatch("1632050052", new Object[]{this, nf2Var});
            return;
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = nf2Var.c(this.b);
            sQLiteStatement.execute();
            try {
                sQLiteStatement.releaseReference();
            } catch (Throwable th) {
                gb1.c(th.getMessage(), th);
            }
        } catch (Throwable th2) {
            try {
                throw new DbException(th2);
            } catch (Throwable th3) {
                if (sQLiteStatement != null) {
                    try {
                        sQLiteStatement.releaseReference();
                    } catch (Throwable th4) {
                        gb1.c(th4.getMessage(), th4);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public Cursor execQuery(nf2 nf2Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055090300")) {
            return (Cursor) ipChange.ipc$dispatch("-2055090300", new Object[]{this, nf2Var});
        }
        try {
            return this.b.rawQuery(nf2Var.e(), nf2Var.d());
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public int executeUpdateDelete(nf2 nf2Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948907134")) {
            return ((Integer) ipChange.ipc$dispatch("1948907134", new Object[]{this, nf2Var})).intValue();
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = nf2Var.c(this.b);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            try {
                sQLiteStatement.releaseReference();
            } catch (Throwable th) {
                gb1.c(th.getMessage(), th);
            }
            return executeUpdateDelete;
        } catch (Throwable th2) {
            try {
                throw new DbException(th2);
            } catch (Throwable th3) {
                if (sQLiteStatement != null) {
                    try {
                        sQLiteStatement.releaseReference();
                    } catch (Throwable th4) {
                        gb1.c(th4.getMessage(), th4);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public <T> List<T> findAll(Class<T> cls) throws DbException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "866220969") ? (List) ipChange.ipc$dispatch("866220969", new Object[]{this, cls}) : selector(cls).c();
    }

    @Override // cn.damai.common.db.DbManager
    public <T> T findById(Class<T> cls, Object obj) throws DbException {
        Cursor execQuery;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313042993")) {
            return (T) ipChange.ipc$dispatch("1313042993", new Object[]{this, cls, obj});
        }
        tk2<T> table = getTable(cls);
        if (table.j() && (execQuery = execQuery(da2.e(table).o(table.e().d(), "=", obj).k(1).toString())) != null) {
            try {
                if (execQuery.moveToNext()) {
                    return (T) jq.b(table, execQuery);
                }
            } finally {
            }
        }
        return null;
    }

    @Override // cn.damai.common.db.DbManager
    public List<g40> findDbModelAll(nf2 nf2Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-415257082")) {
            return (List) ipChange.ipc$dispatch("-415257082", new Object[]{this, nf2Var});
        }
        ArrayList arrayList = new ArrayList();
        Cursor execQuery = execQuery(nf2Var);
        if (execQuery != null) {
            while (execQuery.moveToNext()) {
                try {
                    arrayList.add(jq.a(execQuery));
                } finally {
                }
            }
        }
        return arrayList;
    }

    @Override // cn.damai.common.db.DbManager
    public g40 findDbModelFirst(nf2 nf2Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "273072386")) {
            return (g40) ipChange.ipc$dispatch("273072386", new Object[]{this, nf2Var});
        }
        Cursor execQuery = execQuery(nf2Var);
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext()) {
                    return jq.a(execQuery);
                }
                return null;
            } catch (Throwable th) {
                try {
                    throw new DbException(th);
                } finally {
                    y01.a(execQuery);
                }
            }
        }
        return null;
    }

    @Override // cn.damai.common.db.DbManager
    public <T> T findFirst(Class<T> cls) throws DbException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1342292571") ? (T) ipChange.ipc$dispatch("-1342292571", new Object[]{this, cls}) : selector(cls).d();
    }

    @Override // cn.damai.common.db.DbManager
    public DbManager.C0492a getDaoConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-557811063") ? (DbManager.C0492a) ipChange.ipc$dispatch("-557811063", new Object[]{this}) : this.c;
    }

    @Override // cn.damai.common.db.DbManager
    public SQLiteDatabase getDatabase() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "471447161") ? (SQLiteDatabase) ipChange.ipc$dispatch("471447161", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.common.db.DbManager
    public void replace(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41401935")) {
            ipChange.ipc$dispatch("41401935", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                tk2<?> table = getTable(list.get(0).getClass());
                a(table);
                for (Object obj2 : list) {
                    execNonQuery(C0497a.f(table, obj2));
                }
            } else {
                tk2<?> table2 = getTable(obj.getClass());
                a(table2);
                execNonQuery(C0497a.f(table2, obj));
            }
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void save(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204413826")) {
            ipChange.ipc$dispatch("204413826", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                tk2<?> table = getTable(list.get(0).getClass());
                a(table);
                for (Object obj2 : list) {
                    execNonQuery(C0497a.e(table, obj2));
                }
            } else {
                tk2<?> table2 = getTable(obj.getClass());
                a(table2);
                execNonQuery(C0497a.e(table2, obj));
            }
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public boolean saveBindingId(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-518843036")) {
            return ((Boolean) ipChange.ipc$dispatch("-518843036", new Object[]{this, obj})).booleanValue();
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return false;
                }
                tk2<?> table = getTable(list.get(0).getClass());
                a(table);
                for (Object obj2 : list) {
                    if (!f(table, obj2)) {
                        throw new DbException("saveBindingId error, transaction will not commit!");
                    }
                }
            } else {
                tk2<?> table2 = getTable(obj.getClass());
                a(table2);
                z = f(table2, obj);
            }
            setTransactionSuccessful();
            return z;
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void saveOrUpdate(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427695446")) {
            ipChange.ipc$dispatch("427695446", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                tk2<?> table = getTable(list.get(0).getClass());
                a(table);
                for (Object obj2 : list) {
                    g(table, obj2);
                }
            } else {
                tk2<?> table2 = getTable(obj.getClass());
                a(table2);
                g(table2, obj);
            }
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public <T> da2<T> selector(Class<T> cls) throws DbException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1320667108") ? (da2) ipChange.ipc$dispatch("1320667108", new Object[]{this, cls}) : da2.e(getTable(cls));
    }

    @Override // cn.damai.common.db.DbManager
    public void update(Object obj, String... strArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883290839")) {
            ipChange.ipc$dispatch("-883290839", new Object[]{this, obj, strArr});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                tk2 table = getTable(list.get(0).getClass());
                if (!table.j()) {
                    return;
                }
                for (Object obj2 : list) {
                    execNonQuery(C0497a.g(table, obj2, strArr));
                }
            } else {
                tk2 table2 = getTable(obj.getClass());
                if (!table2.j()) {
                    return;
                }
                execNonQuery(C0497a.g(table2, obj, strArr));
            }
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public Cursor execQuery(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471963615")) {
            return (Cursor) ipChange.ipc$dispatch("-1471963615", new Object[]{this, str});
        }
        try {
            return this.b.rawQuery(str, null);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void execNonQuery(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708882593")) {
            ipChange.ipc$dispatch("1708882593", new Object[]{this, str});
            return;
        }
        try {
            this.b.execSQL(str);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public int executeUpdateDelete(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001316123")) {
            return ((Integer) ipChange.ipc$dispatch("1001316123", new Object[]{this, str})).intValue();
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = this.b.compileStatement(str);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            try {
                sQLiteStatement.releaseReference();
            } catch (Throwable th) {
                gb1.c(th.getMessage(), th);
            }
            return executeUpdateDelete;
        } catch (Throwable th2) {
            try {
                throw new DbException(th2);
            } catch (Throwable th3) {
                if (sQLiteStatement != null) {
                    try {
                        sQLiteStatement.releaseReference();
                    } catch (Throwable th4) {
                        gb1.c(th4.getMessage(), th4);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void delete(Class<?> cls) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460417925")) {
            ipChange.ipc$dispatch("460417925", new Object[]{this, cls});
        } else {
            delete(cls, null);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public int update(Class<?> cls, q13 q13Var, KeyValue... keyValueArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438632214")) {
            return ((Integer) ipChange.ipc$dispatch("-1438632214", new Object[]{this, cls, q13Var, keyValueArr})).intValue();
        }
        tk2 table = getTable(cls);
        if (table.j()) {
            try {
                beginTransaction();
                int executeUpdateDelete = executeUpdateDelete(C0497a.h(table, q13Var, keyValueArr));
                setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                endTransaction();
            }
        }
        return 0;
    }

    @Override // cn.damai.common.db.DbManager
    public int delete(Class<?> cls, q13 q13Var) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062621441")) {
            return ((Integer) ipChange.ipc$dispatch("2062621441", new Object[]{this, cls, q13Var})).intValue();
        }
        tk2 table = getTable(cls);
        if (table.j()) {
            try {
                beginTransaction();
                int executeUpdateDelete = executeUpdateDelete(C0497a.c(table, q13Var));
                setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                endTransaction();
            }
        }
        return 0;
    }
}
