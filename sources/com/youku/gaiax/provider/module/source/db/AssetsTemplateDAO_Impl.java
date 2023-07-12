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
public final class AssetsTemplateDAO_Impl implements AssetsTemplateDAO {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<YKAssetsTemplateEntity> __insertionAdapterOfYKAssetsTemplateEntity;

    public AssetsTemplateDAO_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfYKAssetsTemplateEntity = new EntityInsertionAdapter<YKAssetsTemplateEntity>(roomDatabase) { // from class: com.youku.gaiax.provider.module.source.db.AssetsTemplateDAO_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `yk_assets_template_v1` (`template_id`,`template_biz`,`template_local_url`,`template_app_version`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, YKAssetsTemplateEntity yKAssetsTemplateEntity) {
                if (yKAssetsTemplateEntity.getTemplate_id() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, yKAssetsTemplateEntity.getTemplate_id());
                }
                if (yKAssetsTemplateEntity.getTemplate_biz() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, yKAssetsTemplateEntity.getTemplate_biz());
                }
                if (yKAssetsTemplateEntity.getTemplate_local_url() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, yKAssetsTemplateEntity.getTemplate_local_url());
                }
                supportSQLiteStatement.bindLong(4, yKAssetsTemplateEntity.getTemplate_app_version());
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.youku.gaiax.provider.module.source.db.AssetsTemplateDAO
    public List<YKAssetsTemplateEntity> getAllTemplatesWithAppVersion(long j) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id, template_biz, template_local_url, template_app_version FROM yk_assets_template_v1 WHERE template_app_version==?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new YKAssetsTemplateEntity(query.isNull(0) ? null : query.getString(0), query.isNull(1) ? null : query.getString(1), query.isNull(2) ? null : query.getString(2), query.getLong(3)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.AssetsTemplateDAO
    public List<YKAssetsTemplateEntity> getTemplate(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id, template_biz, template_local_url, template_app_version FROM yk_assets_template_v1 WHERE template_biz==? AND template_id=?", 2);
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
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new YKAssetsTemplateEntity(query.isNull(0) ? null : query.getString(0), query.isNull(1) ? null : query.getString(1), query.isNull(2) ? null : query.getString(2), query.getLong(3)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.AssetsTemplateDAO
    public void insert(YKAssetsTemplateEntity yKAssetsTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfYKAssetsTemplateEntity.insert((EntityInsertionAdapter<YKAssetsTemplateEntity>) yKAssetsTemplateEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
