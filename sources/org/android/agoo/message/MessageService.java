package org.android.agoo.message;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MessageService {
    private static final String ACCS_SPACE_NAME = "accs_message";
    private static final String ADD_MESSAGE = "accs.add_agoo_message";
    private static final String BODY_CODE = "body_code";
    private static final String CREATE_TIME = "create_time";
    private static final String DATABASE_NAME = "message_accs_db";
    private static final int DATABASE_VERSION = 3;
    private static final String DEAL_MESSAGE = "accs.dealMessage";
    private static final String ID = "id";
    private static final String MESSAGE = "message";
    private static final String MESSAGE_TARGET_TIME = "target_time";
    private static final String MESSAGE_TARGET_TIME_INTERVAL = "interval";
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";
    private static final int NOTICE = 1;
    private static final String NOTIFY = "notify";
    private static final String REPORT = "report";
    private static final String SPACE_NAME = "message";
    private static final String STATE = "state";
    private static final String TAG = "MessageService";
    private static final String TYPE = "type";
    private static Context mContext;
    private static Map<String, Integer> messageStores;
    private volatile SQLiteOpenHelper sqliteOpenHelper = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class MessageDBHelper extends SQLiteOpenHelper {
        public MessageDBHelper(Context context) {
            super(context, MessageService.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        }

        private String createmMessageTableSQL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table accs_message");
            stringBuffer.append(jn1.BRACKET_START_STR);
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state text,");
            stringBuffer.append("message text,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        private String getCreateBodyCodeIndexSQL() {
            return "CREATE INDEX body_code_index ON message(body_code)";
        }

        private String getCreateIdIndexSQL() {
            return "CREATE INDEX id_index ON message(id)";
        }

        private String getCreateTableSQL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table message");
            stringBuffer.append(jn1.BRACKET_START_STR);
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state integer,");
            stringBuffer.append("body_code integer,");
            stringBuffer.append("report long,");
            stringBuffer.append("target_time long,");
            stringBuffer.append("interval integer,");
            stringBuffer.append("type text,");
            stringBuffer.append("message text,");
            stringBuffer.append("notify integer,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (AdapterUtilityImpl.checkIsWritable(super.getWritableDatabase().getPath(), 102400)) {
                return super.getWritableDatabase();
            }
            return null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL(getCreateTableSQL());
                    sQLiteDatabase.execSQL(getCreateIdIndexSQL());
                    sQLiteDatabase.execSQL(getCreateBodyCodeIndexSQL());
                    sQLiteDatabase.execSQL(createmMessageTableSQL());
                } catch (Throwable th) {
                    ALog.e(MessageService.TAG, "messagedbhelper create", th, new Object[0]);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                } catch (Throwable th) {
                    try {
                        ALog.e(MessageService.TAG, "messagedbhelper create", th, new Object[0]);
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(createmMessageTableSQL());
                            return;
                        } catch (Throwable th2) {
                            ALog.e(MessageService.TAG, "MessageService onUpgrade is error", th2, new Object[0]);
                            return;
                        }
                    } catch (Throwable th3) {
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(createmMessageTableSQL());
                        } catch (Throwable th4) {
                            ALog.e(MessageService.TAG, "MessageService onUpgrade is error", th4, new Object[0]);
                        }
                        throw th3;
                    }
                }
            }
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                sQLiteDatabase.execSQL(createmMessageTableSQL());
            } catch (Throwable th5) {
                ALog.e(MessageService.TAG, "MessageService onUpgrade is error", th5, new Object[0]);
            }
        }
    }

    public static final boolean checkPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private MsgDO createMsg(String str, String str2) {
        boolean z;
        ALog.Level level = ALog.Level.I;
        if (ALog.isPrintLog(level)) {
            ALog.i(TAG, "msgRecevie,message--->[" + str + jn1.ARRAY_END_STR + ",utdid=" + AdapterUtilityImpl.getDeviceId(mContext), new Object[0]);
        }
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "message==null");
            if (ALog.isPrintLog(level)) {
                ALog.i(TAG, "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(mContext), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            new Bundle();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString("i");
                    String string3 = jSONObject.getString("b");
                    long j = jSONObject.getLong("f");
                    if (!jSONObject.isNull("ext")) {
                        str3 = jSONObject.getString("ext");
                    }
                    int i2 = length - 1;
                    msgDO.msgIds = string2;
                    msgDO.extData = str3;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = "11";
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = "12";
                    } else if (j == -1) {
                        msgDO.errorCode = "13";
                    } else if (!checkPackage(mContext, string)) {
                        ALog.d(TAG, "ondata checkpackage is del,pack=" + string, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "deletePack", string);
                        msgDO.removePacks = string;
                    } else {
                        String string4 = getFlag(j, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!mContext.getPackageName().equals(string)) {
                            z = true;
                        } else if (TextUtils.equals(Integer.toString(0), string4) || TextUtils.equals(Integer.toString(4), string4)) {
                            z = false;
                        } else {
                            msgDO.errorCode = "15";
                            ALog.e(TAG, "error encrypted: " + string4, new Object[0]);
                        }
                        msgDO.agooFlag = z;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e(TAG, "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    private static Bundle getFlag(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString("report", "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString("notify", "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    private String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append(StringUtils.LF);
            }
        }
        return stringBuffer.toString();
    }

    public void addAccsMessage(String str, String str2, String str3) {
        Cursor cursor;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "addAccsMessage sqlite3--->[" + str + ",message=" + str2 + ",state=" + str3 + jn1.ARRAY_END_STR, new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                SQLiteDatabase writableDatabase = this.sqliteOpenHelper.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        writableDatabase.close();
                        return;
                    }
                    return;
                }
                try {
                    Cursor rawQuery = writableDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
                    if (rawQuery != null && rawQuery.moveToFirst() && rawQuery.getInt(0) > 0) {
                        rawQuery.close();
                        rawQuery.close();
                        writableDatabase.close();
                        return;
                    }
                    writableDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    writableDatabase.close();
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "addAccsMessage error,e--->[" + th + jn1.ARRAY_END_STR + ",ex=" + getStackMsg(th), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addAccsMessageFailed", th.toString());
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void addMessage(String str, String str2, String str3, int i) {
        addMessage(str, str2, str3, 1, -1L, -1, i);
    }

    public void deleteCacheMessage() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.sqliteOpenHelper.getWritableDatabase();
        } catch (Throwable th) {
            try {
                ALog.e(TAG, "deleteCacheMessage sql Throwable", th, new Object[0]);
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
        if (sQLiteDatabase == null) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            return;
        }
        sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
        sQLiteDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
        try {
            sQLiteDatabase.close();
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0144 A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #4 {all -> 0x0187, blocks: (B:59:0x013c, B:61:0x0144), top: B:94:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0165 A[Catch: all -> 0x0161, TRY_LEAVE, TryCatch #0 {all -> 0x0161, blocks: (B:63:0x015d, B:67:0x0165), top: B:86:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<org.android.agoo.common.MsgDO> getUnReportMsg() {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.getUnReportMsg():java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r0.getInt(0) > 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasMessageDuplicate(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            java.util.Map<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.messageStores     // Catch: java.lang.Throwable -> L62
            boolean r2 = r2.containsKey(r8)     // Catch: java.lang.Throwable -> L62
            r3 = 1
            if (r2 == 0) goto L2d
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch: java.lang.Throwable -> L62
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L2b
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch: java.lang.Throwable -> L62
            r4.append(r8)     // Catch: java.lang.Throwable -> L62
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L62
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L62
            com.taobao.accs.utl.ALog.e(r2, r4, r5)     // Catch: java.lang.Throwable -> L62
        L2b:
            r2 = 1
            goto L2e
        L2d:
            r2 = 0
        L2e:
            android.database.sqlite.SQLiteOpenHelper r4 = r7.sqliteOpenHelper     // Catch: java.lang.Throwable -> L5f
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L5f
            if (r4 != 0) goto L3c
            if (r4 == 0) goto L3b
            r4.close()     // Catch: java.lang.Throwable -> L3b
        L3b:
            return r2
        L3c:
            java.lang.String r5 = "select count(1) from message where id = ?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L60
            r6[r1] = r8     // Catch: java.lang.Throwable -> L60
            android.database.Cursor r0 = r4.rawQuery(r5, r6)     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L55
            boolean r8 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L60
            if (r8 == 0) goto L55
            int r8 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L60
            if (r8 <= 0) goto L55
            goto L56
        L55:
            r3 = r2
        L56:
            if (r0 == 0) goto L5b
            r0.close()     // Catch: java.lang.Throwable -> L6e
        L5b:
            r4.close()     // Catch: java.lang.Throwable -> L6e
            goto L6e
        L5f:
            r4 = r0
        L60:
            r1 = r2
            goto L63
        L62:
            r4 = r0
        L63:
            if (r0 == 0) goto L68
            r0.close()     // Catch: java.lang.Throwable -> L6d
        L68:
            if (r4 == 0) goto L6d
            r4.close()     // Catch: java.lang.Throwable -> L6d
        L6d:
            r3 = r1
        L6e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.hasMessageDuplicate(java.lang.String):boolean");
    }

    public void init(Context context) {
        messageStores = new HashMap();
        mContext = context;
        this.sqliteOpenHelper = new MessageDBHelper(context);
    }

    public void updateAccsMessage(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + jn1.ARRAY_END_STR, new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
        } catch (Throwable th) {
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "updateAccsMessage error,e--->[" + th + jn1.ARRAY_END_STR + ",ex=" + th.getStackTrace().toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "updateAccsMessageFailed", th.toString());
                if (0 == 0) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sQLiteDatabase = this.sqliteOpenHelper.getWritableDatabase();
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null) {
                    return;
                }
                return;
            }
            if (TextUtils.equals(str2, "1")) {
                sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
            } else {
                sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
            }
            sQLiteDatabase.close();
        }
    }

    private void addMessage(String str, String str2, String str3, int i, long j, int i2, int i3) {
        Throwable th;
        String str4;
        int hashCode;
        String str5;
        ALog.d(TAG, "add sqlite3--->[" + str + jn1.ARRAY_END_STR, new Object[0]);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            str4 = "";
            if (TextUtils.isEmpty(str2)) {
                str5 = "";
                hashCode = -1;
            } else {
                hashCode = str2.hashCode();
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str4 = str3;
            }
            if (!messageStores.containsKey(str)) {
                messageStores.put(str, Integer.valueOf(hashCode));
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "addMessage,messageId=" + str + ",messageStores＝" + messageStores.toString(), new Object[0]);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            SQLiteDatabase writableDatabase = this.sqliteOpenHelper.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                        return;
                    } catch (Throwable th3) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th3 + jn1.ARRAY_END_STR, new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageDBcloseFailed", th3.toString());
                        return;
                    }
                }
                return;
            }
            writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str, Integer.valueOf(i), Integer.valueOf(hashCode), 0, Long.valueOf(j), Integer.valueOf(i2), str4, str5, Integer.valueOf(i3)});
            try {
                writableDatabase.close();
            } catch (Throwable th4) {
                th = th4;
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th + jn1.ARRAY_END_STR, new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageDBcloseFailed", th.toString());
            }
        } catch (Throwable th5) {
            th = th5;
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "addMessage error,e--->[" + th + jn1.ARRAY_END_STR, new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageFailed", th.toString());
                if (0 != 0) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable th6) {
                        th = th6;
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th + jn1.ARRAY_END_STR, new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageDBcloseFailed", th.toString());
                    }
                }
            } catch (Throwable th7) {
                if (0 != 0) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable th8) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th8 + jn1.ARRAY_END_STR, new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageDBcloseFailed", th8.toString());
                    }
                }
                throw th7;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
        if (r0.getInt(0) > 0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasMessageDuplicate(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            java.util.Map<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.messageStores     // Catch: java.lang.Throwable -> L82
            boolean r2 = r2.containsKey(r9)     // Catch: java.lang.Throwable -> L82
            r3 = 1
            if (r2 == 0) goto L39
            java.util.Map<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.messageStores     // Catch: java.lang.Throwable -> L82
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L82
            boolean r2 = r2.containsValue(r4)     // Catch: java.lang.Throwable -> L82
            if (r2 == 0) goto L39
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.I     // Catch: java.lang.Throwable -> L82
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> L82
            if (r2 == 0) goto L37
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r4.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = "addMessage,messageStores hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch: java.lang.Throwable -> L82
            r4.append(r9)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L82
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L82
            com.taobao.accs.utl.ALog.i(r2, r4, r5)     // Catch: java.lang.Throwable -> L82
        L37:
            r2 = 1
            goto L3a
        L39:
            r2 = 0
        L3a:
            android.database.sqlite.SQLiteOpenHelper r4 = r8.sqliteOpenHelper     // Catch: java.lang.Throwable -> L7f
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L7f
            if (r4 != 0) goto L48
            if (r4 == 0) goto L47
            r4.close()     // Catch: java.lang.Throwable -> L47
        L47:
            return r2
        L48:
            java.lang.String r5 = "select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L80
            r6[r1] = r9     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r9.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = ""
            r9.append(r7)     // Catch: java.lang.Throwable -> L80
            r9.append(r10)     // Catch: java.lang.Throwable -> L80
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L80
            r6[r3] = r9     // Catch: java.lang.Throwable -> L80
            android.database.Cursor r0 = r4.rawQuery(r5, r6)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L75
            boolean r9 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L80
            if (r9 == 0) goto L75
            int r9 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L80
            if (r9 <= 0) goto L75
            goto L76
        L75:
            r3 = r2
        L76:
            if (r0 == 0) goto L7b
            r0.close()     // Catch: java.lang.Throwable -> L8e
        L7b:
            r4.close()     // Catch: java.lang.Throwable -> L8e
            goto L8e
        L7f:
            r4 = r0
        L80:
            r1 = r2
            goto L83
        L82:
            r4 = r0
        L83:
            if (r0 == 0) goto L88
            r0.close()     // Catch: java.lang.Throwable -> L8d
        L88:
            if (r4 == 0) goto L8d
            r4.close()     // Catch: java.lang.Throwable -> L8d
        L8d:
            r3 = r1
        L8e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.hasMessageDuplicate(java.lang.String, int):boolean");
    }
}
