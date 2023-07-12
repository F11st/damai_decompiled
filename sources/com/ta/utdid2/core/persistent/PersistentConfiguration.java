package com.ta.utdid2.core.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.android.utils.StringUtils;
import com.ta.utdid2.core.persistent.MySharedPreferences;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PersistentConfiguration {
    private static final String KEY_TIMESTAMP2 = "t2";
    private static final String KEY_TYPE = "type";
    private static final String KEY_UTDID2 = "UTDID2";
    private static final String TAG = "PersistentConfiguration";
    private MySharedPreferences mMySp;
    private SharedPreferences mSp;

    public PersistentConfiguration(Context context, String str, String str2) {
        String str3 = null;
        this.mSp = null;
        this.mMySp = null;
        if (context == null) {
            return;
        }
        this.mSp = context.getSharedPreferences(str2, 0);
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e) {
            UtdidLogger.e(TAG, e, new Object[0]);
        }
        boolean z = !StringUtils.isEmpty(str3) && (str3.equals("mounted") || str3.equals("mounted_ro"));
        UtdidLogger.d(TAG, "PersistentConfiguration canRead", Boolean.valueOf(z));
        if (!z || StringUtils.isEmpty(str)) {
            return;
        }
        try {
            TransactionXMLFile transactionXMLFile = getTransactionXMLFile(str);
            if (transactionXMLFile != null) {
                this.mMySp = transactionXMLFile.getMySharedPreferences(str2, 0);
            }
        } catch (Exception unused) {
        }
    }

    private File getRootFolder(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    private TransactionXMLFile getTransactionXMLFile(String str) {
        File rootFolder = getRootFolder(str);
        if (rootFolder != null) {
            return new TransactionXMLFile(rootFolder.getAbsolutePath());
        }
        return null;
    }

    public boolean copyMySPToSP(int i) {
        boolean z;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (this.mMySp != null && (sharedPreferences = this.mSp) != null && (edit = sharedPreferences.edit()) != null) {
            edit.clear();
            edit.putString(KEY_UTDID2, this.mMySp.getString(KEY_UTDID2, ""));
            edit.putInt("type", i);
            edit.putLong(KEY_TIMESTAMP2, this.mMySp.getLong(KEY_TIMESTAMP2, 0L));
            try {
                z = edit.commit();
            } catch (Exception unused) {
            }
            UtdidLogger.d(TAG, "copyMySPToSP", Boolean.valueOf(z));
            return z;
        }
        z = false;
        UtdidLogger.d(TAG, "copyMySPToSP", Boolean.valueOf(z));
        return z;
    }

    public boolean copySPToMySP() {
        boolean z;
        if (this.mSp != null && this.mMySp != null) {
            UtdidLogger.d(TAG, "copySPToMySP");
            MySharedPreferences.MyEditor edit = this.mMySp.edit();
            if (edit != null) {
                edit.clear();
                edit.putString(KEY_UTDID2, this.mSp.getString(KEY_UTDID2, ""));
                edit.putLong(KEY_TIMESTAMP2, this.mSp.getLong(KEY_TIMESTAMP2, 0L));
                try {
                    z = edit.commit();
                } catch (Exception unused) {
                }
                UtdidLogger.d(TAG, "copySPToMySP", Boolean.valueOf(z));
                return z;
            }
        }
        z = false;
        UtdidLogger.d(TAG, "copySPToMySP", Boolean.valueOf(z));
        return z;
    }

    public int getTypeFromSp() {
        SharedPreferences sharedPreferences = this.mSp;
        int i = sharedPreferences != null ? sharedPreferences.getInt("type", 0) : 0;
        UtdidLogger.d(TAG, "getTypeFromSp type", Integer.valueOf(i));
        return i;
    }

    public String getUtdidFromMySp() {
        MySharedPreferences mySharedPreferences = this.mMySp;
        String string = mySharedPreferences != null ? mySharedPreferences.getString(KEY_UTDID2, "") : "";
        UtdidLogger.d(TAG, "getUtdidFromMySp utdid", string);
        return string;
    }

    public String getUtdidFromSp() {
        SharedPreferences sharedPreferences = this.mSp;
        String string = sharedPreferences != null ? sharedPreferences.getString(KEY_UTDID2, "") : "";
        UtdidLogger.d(TAG, "getUtdidFromSp utdid", string);
        return string;
    }

    public void updateUtdidToSp(String str) {
        if (this.mSp != null) {
            UtdidLogger.d(TAG, "updateUtdidToSp utdid", str);
            SharedPreferences.Editor edit = this.mSp.edit();
            edit.putString(KEY_UTDID2, str);
            if (this.mSp.getLong(KEY_TIMESTAMP2, 0L) == 0) {
                edit.putLong(KEY_TIMESTAMP2, System.currentTimeMillis());
            }
            try {
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public void writeUtdidToMySp(String str) {
        if (this.mMySp != null) {
            UtdidLogger.d(TAG, "writeUtdidToMySp utdid", str);
            MySharedPreferences.MyEditor edit = this.mMySp.edit();
            edit.putString(KEY_UTDID2, str);
            if (this.mMySp.getLong(KEY_TIMESTAMP2, 0L) == 0) {
                edit.putLong(KEY_TIMESTAMP2, System.currentTimeMillis());
            }
            try {
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public void writeUtdidToSp(String str, int i) {
        if (this.mSp != null) {
            UtdidLogger.d(TAG, "writeUtdidToSp utdid", str);
            SharedPreferences.Editor edit = this.mSp.edit();
            edit.putString(KEY_UTDID2, str);
            edit.putInt("type", i);
            if (this.mSp.getLong(KEY_TIMESTAMP2, 0L) == 0) {
                edit.putLong(KEY_TIMESTAMP2, System.currentTimeMillis());
            }
            try {
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }
}
