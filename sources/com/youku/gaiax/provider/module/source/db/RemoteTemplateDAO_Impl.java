package com.youku.gaiax.provider.module.source.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RemoteTemplateDAO_Impl implements RemoteTemplateDAO {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<YKTemplateEntity> __insertionAdapterOfYKTemplateEntity;

    public RemoteTemplateDAO_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfYKTemplateEntity = new EntityInsertionAdapter<YKTemplateEntity>(roomDatabase) { // from class: com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `yk_template_v2` (`template_id`,`template_version`,`template_biz`,`template_platform`,`template_desc`,`template_resource_url`,`template_local_url`,`template_priority`,`template_support_min_version`,`template_support_max_version`,`template_createtime`,`template_modifytime`,`template_create_empid`,`template_modify_empid`,`template_release_status`,`template_ext_info`,`template_fileType`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, YKTemplateEntity yKTemplateEntity) {
                if (yKTemplateEntity.getTemplate_id() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, yKTemplateEntity.getTemplate_id());
                }
                supportSQLiteStatement.bindLong(2, yKTemplateEntity.getTemplate_version());
                if (yKTemplateEntity.getTemplate_biz() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, yKTemplateEntity.getTemplate_biz());
                }
                if (yKTemplateEntity.getTemplate_platform() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, yKTemplateEntity.getTemplate_platform());
                }
                if (yKTemplateEntity.getTemplate_desc() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, yKTemplateEntity.getTemplate_desc());
                }
                if (yKTemplateEntity.getTemplate_resource_url() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, yKTemplateEntity.getTemplate_resource_url());
                }
                if (yKTemplateEntity.getTemplate_local_url() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, yKTemplateEntity.getTemplate_local_url());
                }
                if (yKTemplateEntity.getTemplate_priority() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, yKTemplateEntity.getTemplate_priority());
                }
                supportSQLiteStatement.bindLong(9, yKTemplateEntity.getTemplate_support_min_version());
                supportSQLiteStatement.bindLong(10, yKTemplateEntity.getTemplate_support_max_version());
                if (yKTemplateEntity.getTemplate_createtime() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, yKTemplateEntity.getTemplate_createtime());
                }
                if (yKTemplateEntity.getTemplate_modifytime() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, yKTemplateEntity.getTemplate_modifytime());
                }
                if (yKTemplateEntity.getTemplate_create_empid() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, yKTemplateEntity.getTemplate_create_empid());
                }
                if (yKTemplateEntity.getTemplate_modify_empid() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, yKTemplateEntity.getTemplate_modify_empid());
                }
                if (yKTemplateEntity.getTemplate_release_status() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, yKTemplateEntity.getTemplate_release_status());
                }
                if (yKTemplateEntity.getTemplate_ext_info() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, yKTemplateEntity.getTemplate_ext_info());
                }
                if (yKTemplateEntity.getTemplate_fileType() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, yKTemplateEntity.getTemplate_fileType());
                }
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType   FROM yk_template_v2 ", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new YKTemplateEntity(query.isNull(0) ? null : query.getString(0), query.getInt(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : query.getString(6), query.isNull(7) ? null : query.getString(7), query.getLong(8), query.getLong(9), query.isNull(10) ? null : query.getString(10), query.isNull(11) ? null : query.getString(11), query.isNull(12) ? null : query.getString(12), query.isNull(13) ? null : query.getString(13), query.isNull(14) ? null : query.getString(14), query.isNull(15) ? null : query.getString(15), query.isNull(16) ? null : query.getString(16)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getAllTemplatesWithStatusAndAppVersion(String str, long j, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType FROM yk_template_v2 WHERE template_release_status=? AND template_support_min_version<=? AND template_support_max_version>=? AND template_platform=? GROUP BY template_id", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        acquire.bindLong(3, j);
        if (str2 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new YKTemplateEntity(query.isNull(0) ? null : query.getString(0), query.getInt(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : query.getString(6), query.isNull(7) ? null : query.getString(7), query.getLong(8), query.getLong(9), query.isNull(10) ? null : query.getString(10), query.isNull(11) ? null : query.getString(11), query.isNull(12) ? null : query.getString(12), query.isNull(13) ? null : query.getString(13), query.isNull(14) ? null : query.getString(14), query.isNull(15) ? null : query.getString(15), query.isNull(16) ? null : query.getString(16)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getTemplateWithStatus(String str, int i, String str2, String str3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=? AND template_version=? AND template_biz=? AND template_release_status=?", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, i);
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        if (str3 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new YKTemplateEntity(query.isNull(0) ? null : query.getString(0), query.getInt(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : query.getString(6), query.isNull(7) ? null : query.getString(7), query.getLong(8), query.getLong(9), query.isNull(10) ? null : query.getString(10), query.isNull(11) ? null : query.getString(11), query.isNull(12) ? null : query.getString(12), query.isNull(13) ? null : query.getString(13), query.isNull(14) ? null : query.getString(14), query.isNull(15) ? null : query.getString(15), query.isNull(16) ? null : query.getString(16)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getTemplateWithStatusAndAppVersion(String str, String str2, String str3, long j, String str4) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=? AND template_biz=? AND template_release_status=? AND template_support_min_version<=? AND template_support_max_version>=? AND template_platform=?", 6);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        if (str3 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str3);
        }
        acquire.bindLong(4, j);
        acquire.bindLong(5, j);
        if (str4 == null) {
            acquire.bindNull(6);
        } else {
            acquire.bindString(6, str4);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new YKTemplateEntity(query.isNull(0) ? null : query.getString(0), query.getInt(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : query.getString(6), query.isNull(7) ? null : query.getString(7), query.getLong(8), query.getLong(9), query.isNull(10) ? null : query.getString(10), query.isNull(11) ? null : query.getString(11), query.isNull(12) ? null : query.getString(12), query.isNull(13) ? null : query.getString(13), query.isNull(14) ? null : query.getString(14), query.isNull(15) ? null : query.getString(15), query.isNull(16) ? null : query.getString(16)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getTemplatesWithStatusAndAppVersion(String str, String str2, String str3, long j, String str4) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=? AND template_biz=? AND template_release_status=? AND template_support_min_version<=? AND template_support_max_version>=? AND template_platform=?", 6);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        if (str3 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str3);
        }
        acquire.bindLong(4, j);
        acquire.bindLong(5, j);
        if (str4 == null) {
            acquire.bindNull(6);
        } else {
            acquire.bindString(6, str4);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new YKTemplateEntity(query.isNull(0) ? null : query.getString(0), query.getInt(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : query.getString(6), query.isNull(7) ? null : query.getString(7), query.getLong(8), query.getLong(9), query.isNull(10) ? null : query.getString(10), query.isNull(11) ? null : query.getString(11), query.isNull(12) ? null : query.getString(12), query.isNull(13) ? null : query.getString(13), query.isNull(14) ? null : query.getString(14), query.isNull(15) ? null : query.getString(15), query.isNull(16) ? null : query.getString(16)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public void insert(YKTemplateEntity yKTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfYKTemplateEntity.insert((EntityInsertionAdapter<YKTemplateEntity>) yKTemplateEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
