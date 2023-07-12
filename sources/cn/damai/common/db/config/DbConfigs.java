package cn.damai.common.db.config;

import cn.damai.common.db.DbManager;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gb1;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public enum DbConfigs {
    HTTP(new DbManager.a().h("xUtils_http_cache.db").k(1).i(new DbManager.DbOpenListener() { // from class: cn.damai.common.db.config.DbConfigs.b
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.common.db.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "512905499")) {
                ipChange.ipc$dispatch("512905499", new Object[]{this, dbManager});
            } else {
                dbManager.getDatabase().enableWriteAheadLogging();
            }
        }
    }).j(new DbManager.DbUpgradeListener() { // from class: cn.damai.common.db.config.DbConfigs.a
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.common.db.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1237513475")) {
                ipChange.ipc$dispatch("-1237513475", new Object[]{this, dbManager, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                gb1.c(e.getMessage(), e);
            }
        }
    })),
    COOKIE(new DbManager.a().h("xUtils_http_cookie.db").k(1).i(new DbManager.DbOpenListener() { // from class: cn.damai.common.db.config.DbConfigs.d
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.common.db.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "159817117")) {
                ipChange.ipc$dispatch("159817117", new Object[]{this, dbManager});
            } else {
                dbManager.getDatabase().enableWriteAheadLogging();
            }
        }
    }).j(new DbManager.DbUpgradeListener() { // from class: cn.damai.common.db.config.DbConfigs.c
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.common.db.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "701648571")) {
                ipChange.ipc$dispatch("701648571", new Object[]{this, dbManager, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                gb1.c(e.getMessage(), e);
            }
        }
    }));
    
    private DbManager.a config;

    DbConfigs(DbManager.a aVar) {
        this.config = aVar;
    }

    public DbManager.a getConfig() {
        return this.config;
    }
}
