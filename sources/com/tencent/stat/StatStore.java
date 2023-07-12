package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.StatConfig;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.User;
import com.tencent.stat.event.Event;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.youku.arch.v3.core.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StatStore {
    Handler handler;
    private StatStoreHelper helper;
    private static StatLogger logger = StatCommonHelper.getLogger();
    private static StatStore instance = null;
    volatile int numStoredEvents = 0;
    User user = null;
    private HashMap<String, String> kvMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class StatStoreHelper extends SQLiteOpenHelper {
        private static String DATABASE_NAME = "tencent_analysis.db";
        private static int DATABASE_VERSION = 3;

        public StatStoreHelper(Context context) {
            super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, DATABASE_VERSION);
        }

        private void upgradeEventsToVer3(SQLiteDatabase sQLiteDatabase) {
            Cursor query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            ArrayList<StoredEvent> arrayList = new ArrayList();
            while (query.moveToNext()) {
                arrayList.add(new StoredEvent(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            for (StoredEvent storedEvent : arrayList) {
                contentValues.put("content", StatCommonHelper.encode(storedEvent.content));
                sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(storedEvent.id)});
            }
        }

        private void upgradeUserToVer3(SQLiteDatabase sQLiteDatabase) {
            String str;
            Cursor query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            ContentValues contentValues = new ContentValues();
            if (query.moveToNext()) {
                str = query.getString(0);
                query.getInt(1);
                query.getString(2);
                query.getLong(3);
                contentValues.put("uid", StatCommonHelper.encode(str));
            } else {
                str = null;
            }
            if (str != null) {
                sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
            sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
            sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            StatLogger statLogger = StatStore.logger;
            statLogger.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
            if (i == 1) {
                sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
                upgradeUserToVer3(sQLiteDatabase);
                upgradeEventsToVer3(sQLiteDatabase);
            }
            if (i == 2) {
                upgradeUserToVer3(sQLiteDatabase);
                upgradeEventsToVer3(sQLiteDatabase);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class StoredEvent {
        String content;
        long id;
        int send_count;
        int status;

        public StoredEvent(long j, String str, int i, int i2) {
            this.id = j;
            this.content = str;
            this.status = i;
            this.send_count = i2;
        }
    }

    private StatStore(Context context) {
        this.handler = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            StatLogger statLogger = logger;
            statLogger.w("Launch store thread:" + handlerThread);
            this.handler = new Handler(handlerThread.getLooper());
            Context applicationContext = context.getApplicationContext();
            StatStoreHelper statStoreHelper = new StatStoreHelper(applicationContext);
            this.helper = statStoreHelper;
            statStoreHelper.getWritableDatabase();
            this.helper.getReadableDatabase();
            getUser(applicationContext);
            loadConfig();
            loadKeyValues();
            this.handler.post(new Runnable() { // from class: com.tencent.stat.StatStore.1
                @Override // java.lang.Runnable
                public void run() {
                    StatStore.this.loadUnsentEventCount();
                }
            });
        } catch (Throwable th) {
            logger.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void directDeleteEvents(List<StoredEvent> list) {
        logger.i("Delete " + list.size() + " sent events in thread:" + Thread.currentThread());
        try {
            try {
                try {
                    this.helper.getWritableDatabase().beginTransaction();
                    Iterator<StoredEvent> it = list.iterator();
                    while (it.hasNext()) {
                        this.numStoredEvents -= this.helper.getWritableDatabase().delete("events", "event_id = ?", new String[]{Long.toString(it.next().id)});
                    }
                    this.helper.getWritableDatabase().setTransactionSuccessful();
                    this.numStoredEvents = (int) DatabaseUtils.queryNumEntries(this.helper.getReadableDatabase(), "events");
                    this.helper.getWritableDatabase().endTransaction();
                } catch (Throwable th) {
                    try {
                        this.helper.getWritableDatabase().endTransaction();
                    } catch (SQLiteException e) {
                        logger.e((Exception) e);
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                logger.e((Exception) e2);
                this.helper.getWritableDatabase().endTransaction();
            }
        } catch (SQLiteException e3) {
            logger.e((Exception) e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void directUpdateEvents(List<StoredEvent> list, int i) {
        int update;
        logger.i("Update " + list.size() + " sending events to status:" + i + " in thread:" + Thread.currentThread());
        try {
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", Integer.toString(i));
                    this.helper.getWritableDatabase().beginTransaction();
                    for (StoredEvent storedEvent : list) {
                        if (storedEvent.send_count + 1 > StatConfig.getMaxSendRetryCount()) {
                            this.numStoredEvents -= this.helper.getWritableDatabase().delete("events", "event_id=?", new String[]{Long.toString(storedEvent.id)});
                        } else {
                            contentValues.put("send_count", Integer.valueOf(storedEvent.send_count + 1));
                            logger.i("Update event:" + storedEvent.id + " for content:" + contentValues);
                            if (this.helper.getWritableDatabase().update("events", contentValues, "event_id=?", new String[]{Long.toString(storedEvent.id)}) <= 0) {
                                logger.e("Failed to update db, error code:" + Integer.toString(update));
                            }
                        }
                    }
                    this.helper.getWritableDatabase().setTransactionSuccessful();
                    this.numStoredEvents = (int) DatabaseUtils.queryNumEntries(this.helper.getReadableDatabase(), "events");
                    this.helper.getWritableDatabase().endTransaction();
                } catch (SQLiteException e) {
                    logger.e((Exception) e);
                    this.helper.getWritableDatabase().endTransaction();
                }
            } catch (Throwable th) {
                try {
                    this.helper.getWritableDatabase().endTransaction();
                } catch (SQLiteException e2) {
                    logger.e((Exception) e2);
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            logger.e((Exception) e3);
        }
    }

    public static StatStore getInstance() {
        return instance;
    }

    public static StatStore getInstance(Context context) {
        if (instance == null) {
            instance = new StatStore(context);
        }
        return instance;
    }

    private void loadKeyValues() {
        Cursor cursor = null;
        try {
            try {
                cursor = this.helper.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    this.kvMap.put(cursor.getString(0), cursor.getString(1));
                }
            } catch (SQLiteException e) {
                logger.e((Exception) e);
                if (cursor == null) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUnsentEventCount() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        this.helper.getWritableDatabase().update("events", contentValues, "status=?", new String[]{Long.toString(2L)});
        this.numStoredEvents = (int) DatabaseUtils.queryNumEntries(this.helper.getReadableDatabase(), "events");
        StatLogger statLogger = logger;
        statLogger.i("Total " + this.numStoredEvents + " unsent events.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void peekEvents(List<StoredEvent> list, int i) {
        Cursor cursor = null;
        try {
            try {
                cursor = this.helper.getReadableDatabase().query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, UTDataCollectorNodeColumn.EVENT_ID, Integer.toString(i));
                while (cursor.moveToNext()) {
                    list.add(new StoredEvent(cursor.getLong(0), StatCommonHelper.decode(cursor.getString(1)), cursor.getInt(2), cursor.getInt(3)));
                }
            } catch (SQLiteException e) {
                logger.e((Exception) e);
                if (cursor == null) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    void deleteEvents(final List<StoredEvent> list) {
        try {
            if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
                directDeleteEvents(list);
            } else {
                this.handler.post(new Runnable() { // from class: com.tencent.stat.StatStore.3
                    @Override // java.lang.Runnable
                    public void run() {
                        StatStore.this.directDeleteEvents(list);
                    }
                });
            }
        } catch (SQLiteException e) {
            logger.e((Exception) e);
        }
    }

    void directStoreEvent(Event event, StatDispatchCallback statDispatchCallback) {
        if (StatConfig.getMaxStoreEventCount() <= 0) {
            return;
        }
        if (this.numStoredEvents > StatConfig.getMaxStoreEventCount()) {
            logger.warn("Too many events stored in db.");
            this.numStoredEvents -= this.helper.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
        }
        ContentValues contentValues = new ContentValues();
        String encode = StatCommonHelper.encode(event.toJsonString());
        contentValues.put("content", encode);
        contentValues.put("send_count", "0");
        contentValues.put("status", Integer.toString(1));
        contentValues.put("timestamp", Long.valueOf(event.getTimestamp()));
        if (this.helper.getWritableDatabase().insert("events", null, contentValues) != -1) {
            this.numStoredEvents++;
            if (statDispatchCallback != null) {
                statDispatchCallback.onDispatchSuccess();
                return;
            }
            return;
        }
        logger.error("Failed to store event:" + encode);
    }

    public int getNumStoredEvents() {
        return this.numStoredEvents;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[Catch: all -> 0x0194, TryCatch #0 {all -> 0x0194, blocks: (B:6:0x001a, B:9:0x0030, B:11:0x004e, B:15:0x0063, B:17:0x006d, B:18:0x006f, B:20:0x0075, B:22:0x0078, B:24:0x007d, B:36:0x00a3, B:38:0x00a9, B:46:0x00e3, B:48:0x010d, B:51:0x0123, B:54:0x0131, B:56:0x013b, B:58:0x0141, B:60:0x0155, B:40:0x00c1, B:42:0x00c7, B:44:0x00cd, B:28:0x0088, B:30:0x008e, B:33:0x009b), top: B:75:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7 A[Catch: all -> 0x0194, TryCatch #0 {all -> 0x0194, blocks: (B:6:0x001a, B:9:0x0030, B:11:0x004e, B:15:0x0063, B:17:0x006d, B:18:0x006f, B:20:0x0075, B:22:0x0078, B:24:0x007d, B:36:0x00a3, B:38:0x00a9, B:46:0x00e3, B:48:0x010d, B:51:0x0123, B:54:0x0131, B:56:0x013b, B:58:0x0141, B:60:0x0155, B:40:0x00c1, B:42:0x00c7, B:44:0x00cd, B:28:0x0088, B:30:0x008e, B:33:0x009b), top: B:75:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d A[Catch: all -> 0x0194, TryCatch #0 {all -> 0x0194, blocks: (B:6:0x001a, B:9:0x0030, B:11:0x004e, B:15:0x0063, B:17:0x006d, B:18:0x006f, B:20:0x0075, B:22:0x0078, B:24:0x007d, B:36:0x00a3, B:38:0x00a9, B:46:0x00e3, B:48:0x010d, B:51:0x0123, B:54:0x0131, B:56:0x013b, B:58:0x0141, B:60:0x0155, B:40:0x00c1, B:42:0x00c7, B:44:0x00cd, B:28:0x0088, B:30:0x008e, B:33:0x009b), top: B:75:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123 A[Catch: all -> 0x0194, TryCatch #0 {all -> 0x0194, blocks: (B:6:0x001a, B:9:0x0030, B:11:0x004e, B:15:0x0063, B:17:0x006d, B:18:0x006f, B:20:0x0075, B:22:0x0078, B:24:0x007d, B:36:0x00a3, B:38:0x00a9, B:46:0x00e3, B:48:0x010d, B:51:0x0123, B:54:0x0131, B:56:0x013b, B:58:0x0141, B:60:0x0155, B:40:0x00c1, B:42:0x00c7, B:44:0x00cd, B:28:0x0088, B:30:0x008e, B:33:0x009b), top: B:75:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.stat.common.User getUser(android.content.Context r22) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.StatStore.getUser(android.content.Context):com.tencent.stat.common.User");
    }

    void loadConfig() {
        this.handler.post(new Runnable() { // from class: com.tencent.stat.StatStore.6
            @Override // java.lang.Runnable
            public void run() {
                Cursor cursor = null;
                try {
                    try {
                        cursor = StatStore.this.helper.getReadableDatabase().query(Constants.CONFIG, null, null, null, null, null, null);
                        while (cursor.moveToNext()) {
                            int i = cursor.getInt(0);
                            String string = cursor.getString(1);
                            String string2 = cursor.getString(2);
                            int i2 = cursor.getInt(3);
                            StatConfig.OnlineConfig onlineConfig = new StatConfig.OnlineConfig(i);
                            onlineConfig.type = i;
                            onlineConfig.props = new JSONObject(string);
                            onlineConfig.md5sum = string2;
                            onlineConfig.version = i2;
                            StatConfig.setConfig(onlineConfig);
                        }
                    } catch (Exception e) {
                        StatStore.logger.e(e);
                        if (cursor == null) {
                            return;
                        }
                    }
                    cursor.close();
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadEvents(final int i) {
        this.handler.post(new Runnable() { // from class: com.tencent.stat.StatStore.7
            @Override // java.lang.Runnable
            public void run() {
                if (StatStore.this.numStoredEvents == 0) {
                    return;
                }
                StatStore.logger.i("Load " + Integer.toString(StatStore.this.numStoredEvents) + " unsent events");
                ArrayList arrayList = new ArrayList();
                final ArrayList<StoredEvent> arrayList2 = new ArrayList();
                final int i2 = i;
                if (i2 == -1 || i2 > StatConfig.getMaxLoadEventCount()) {
                    i2 = StatConfig.getMaxLoadEventCount();
                }
                StatStore.this.numStoredEvents -= i2;
                StatStore.this.peekEvents(arrayList2, i2);
                StatStore.logger.i("Peek " + Integer.toString(arrayList2.size()) + " unsent events.");
                if (arrayList2.isEmpty()) {
                    return;
                }
                StatStore.this.directUpdateEvents(arrayList2, 2);
                for (StoredEvent storedEvent : arrayList2) {
                    arrayList.add(storedEvent.content);
                }
                StatDispatcher.getInstance().send(arrayList, new StatDispatchCallback() { // from class: com.tencent.stat.StatStore.7.1
                    @Override // com.tencent.stat.StatDispatchCallback
                    public void onDispatchFailure() {
                        StatStore.this.numStoredEvents += i2;
                        StatStore.this.updateEvents(arrayList2, 1);
                    }

                    @Override // com.tencent.stat.StatDispatchCallback
                    public void onDispatchSuccess() {
                        StatStore.this.deleteEvents(arrayList2);
                        int i3 = i;
                        if (i3 != -1) {
                            i3 -= arrayList2.size();
                        }
                        if (i3 == -1 || i3 > 0) {
                            StatStore.this.loadEvents(i3);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void storeCfg(final StatConfig.OnlineConfig onlineConfig) {
        if (onlineConfig == null) {
            return;
        }
        try {
            this.handler.post(new Runnable() { // from class: com.tencent.stat.StatStore.5
                /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x00c7  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
                /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 246
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.StatStore.AnonymousClass5.run():void");
                }
            });
        } catch (Exception e) {
            logger.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void storeEvent(final Event event, final StatDispatchCallback statDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            try {
                if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
                    directStoreEvent(event, statDispatchCallback);
                } else {
                    this.handler.post(new Runnable() { // from class: com.tencent.stat.StatStore.4
                        @Override // java.lang.Runnable
                        public void run() {
                            StatStore.this.directStoreEvent(event, statDispatchCallback);
                        }
                    });
                }
            } catch (SQLiteException e) {
                logger.e((Exception) e);
            }
        }
    }

    void updateEvents(final List<StoredEvent> list, final int i) {
        try {
            if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
                directUpdateEvents(list, i);
            } else {
                this.handler.post(new Runnable() { // from class: com.tencent.stat.StatStore.2
                    @Override // java.lang.Runnable
                    public void run() {
                        StatStore.this.directUpdateEvents(list, i);
                    }
                });
            }
        } catch (SQLiteException e) {
            logger.e((Exception) e);
        }
    }
}
