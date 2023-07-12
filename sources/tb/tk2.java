package tb;

import android.database.Cursor;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.db.annotation.Table;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class tk2<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DbManager a;
    private final String b;
    private final String c;
    private uk d;
    private Class<T> e;
    private Constructor<T> f;
    private volatile boolean g;
    private final LinkedHashMap<String, uk> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tk2(DbManager dbManager, Class<T> cls) throws Throwable {
        this.a = dbManager;
        this.e = cls;
        Constructor<T> constructor = cls.getConstructor(new Class[0]);
        this.f = constructor;
        constructor.setAccessible(true);
        Table table = (Table) cls.getAnnotation(Table.class);
        this.b = table.name();
        this.c = table.onCreated();
        LinkedHashMap<String, uk> b = uk2.b(cls);
        this.h = b;
        for (uk ukVar : b.values()) {
            if (ukVar.g()) {
                this.d = ukVar;
                return;
            }
        }
    }

    public T a() throws Throwable {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1320086611") ? (T) ipChange.ipc$dispatch("-1320086611", new Object[]{this}) : this.f.newInstance(new Object[0]);
    }

    public LinkedHashMap<String, uk> b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1994435792") ? (LinkedHashMap) ipChange.ipc$dispatch("-1994435792", new Object[]{this}) : this.h;
    }

    public DbManager c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1777029324") ? (DbManager) ipChange.ipc$dispatch("1777029324", new Object[]{this}) : this.a;
    }

    public Class<T> d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "967213664") ? (Class) ipChange.ipc$dispatch("967213664", new Object[]{this}) : this.e;
    }

    public uk e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1347350989") ? (uk) ipChange.ipc$dispatch("1347350989", new Object[]{this}) : this.d;
    }

    public String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1941873957") ? (String) ipChange.ipc$dispatch("-1941873957", new Object[]{this}) : this.b;
    }

    public String g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-721736593") ? (String) ipChange.ipc$dispatch("-721736593", new Object[]{this}) : this.c;
    }

    boolean h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1928446738") ? ((Boolean) ipChange.ipc$dispatch("1928446738", new Object[]{this})).booleanValue() : this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-962162288")) {
            ipChange.ipc$dispatch("-962162288", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.g = z;
        }
    }

    public boolean j() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404480535")) {
            return ((Boolean) ipChange.ipc$dispatch("-404480535", new Object[]{this})).booleanValue();
        }
        if (h()) {
            return true;
        }
        DbManager dbManager = this.a;
        Cursor execQuery = dbManager.execQuery("SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='" + this.b + "'");
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext() && execQuery.getInt(0) > 0) {
                    i(true);
                    return true;
                }
            } finally {
            }
        }
        return false;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1557653624") ? (String) ipChange.ipc$dispatch("-1557653624", new Object[]{this}) : this.b;
    }
}
