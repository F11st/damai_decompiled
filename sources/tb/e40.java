package tb;

import android.app.Application;
import android.content.Context;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.ex.DbException;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class e40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static e40 b;
    public static DbManager c;
    private int a = 21;

    /* compiled from: Taobao */
    /* renamed from: tb.e40$a */
    /* loaded from: classes7.dex */
    public class C9070a implements DbManager.DbUpgradeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Application a;

        C9070a(Application application) {
            this.a = application;
        }

        @Override // cn.damai.common.db.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-26331558")) {
                ipChange.ipc$dispatch("-26331558", new Object[]{this, dbManager, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            try {
                e40.this.b(dbManager, this.a);
            } catch (Exception e) {
                xn2.h(xn2.TICKLET_DB_VERSION_UPGRADE_ERROR_CODE, xn2.TICKLET_DB_VERSION_UPGRADE_ERROR_MSG, e.getMessage());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.e40$b */
    /* loaded from: classes7.dex */
    public class C9071b implements DbManager.TableCreateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9071b(e40 e40Var) {
        }

        @Override // cn.damai.common.db.DbManager.TableCreateListener
        public void onTableCreated(DbManager dbManager, tk2<?> tk2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2139686831")) {
                ipChange.ipc$dispatch("2139686831", new Object[]{this, dbManager, tk2Var});
                return;
            }
            try {
                if (tk2Var.j()) {
                    return;
                }
                xn2.g(xn2.TICKLET_DB_CREAT_TABLE_ERROR_CODE, xn2.TICKLET_DB_CREAT_TABLE_ERROR_MSG, tk2Var.f() + "创建失败");
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
    }

    public static e40 e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648717679")) {
            return (e40) ipChange.ipc$dispatch("-648717679", new Object[0]);
        }
        if (b == null) {
            synchronized (e40.class) {
                if (b == null) {
                    e40 e40Var = new e40();
                    b = e40Var;
                    e40Var.d(mu0.a());
                }
            }
        }
        return b;
    }

    public void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884931922")) {
            ipChange.ipc$dispatch("-1884931922", new Object[]{this, context});
        } else {
            b(c, context);
        }
    }

    public void b(DbManager dbManager, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-910755546")) {
            ipChange.ipc$dispatch("-910755546", new Object[]{this, dbManager, context});
        } else if (context != null) {
            fu1.a(context);
            try {
                if (dbManager.getTable(PerformTable.class).j()) {
                    dbManager.dropTable(PerformTable.class);
                }
                if (dbManager.getTable(UserTicketTable.class).j()) {
                    dbManager.dropTable(UserTicketTable.class);
                }
            } catch (DbException e) {
                cb1.b("DbMainManager", e.getMessage());
                xn2.g(xn2.TICKLET_DB_DELET_TABLE_ERROR_CODE, xn2.TICKLET_DB_DELET_TABLE_ERROR_MSG, e.getMessage());
            }
        }
    }

    public synchronized DbManager c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528162538")) {
            return (DbManager) ipChange.ipc$dispatch("-1528162538", new Object[]{this});
        }
        DbManager dbManager = c;
        if (dbManager == null) {
            return d(mu0.a());
        }
        return dbManager;
    }

    public synchronized DbManager d(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815826137")) {
            return (DbManager) ipChange.ipc$dispatch("-1815826137", new Object[]{this, application});
        }
        if (c == null && application != null) {
            File databasePath = application.getDatabasePath("walletsdk.db");
            if (databasePath != null && databasePath.exists() && databasePath.isFile()) {
                databasePath.delete();
            }
            DbManager.C0492a c0492a = new DbManager.C0492a();
            c0492a.k(this.a);
            c0492a.h("ticketlet.db");
            c0492a.j(new C9070a(application));
            c0492a.l(new C9071b(this));
            c = f40.c(c0492a, application);
        }
        if (c == null) {
            xn2.g(xn2.TICKLET_DB_INIT_ERROR_CODE, xn2.TICKLET_DB_INIT_ERROR_MSG, null);
        }
        return c;
    }
}
