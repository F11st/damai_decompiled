package com.taobao.accs.asp;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.asp.BaseSharedPreferences;
import com.taobao.accs.asp.StatMonitor;
import com.taobao.accs.utl.ALog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class CoreSharedPreferences extends BaseSharedPreferences {
    private static final String TAG = "CoreSharedPreferences";
    private SharedPreferences.Editor sysEditor;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    final class CoreEditor extends BaseSharedPreferences.BaseEditor {
        CoreEditor() {
            super();
        }

        @Override // com.taobao.accs.asp.BaseSharedPreferences.BaseEditor
        void commitToDisk(BaseSharedPreferences.MemoryCommitResult memoryCommitResult) {
            int i;
            ModifiedRecord modifiedRecord = memoryCommitResult.modifiedRecord;
            if (modifiedRecord == null) {
                return;
            }
            PrefsIPCChannel.getInstance().dataUpdateEvent(modifiedRecord);
            long currentTimeMillis = System.currentTimeMillis();
            if (CoreSharedPreferences.this.sysEditor == null) {
                CoreSharedPreferences coreSharedPreferences = CoreSharedPreferences.this;
                coreSharedPreferences.sysEditor = coreSharedPreferences.mSystemSP.edit();
            }
            if (modifiedRecord.isClear) {
                CoreSharedPreferences.this.sysEditor.clear();
            }
            for (String str : modifiedRecord.modified.keySet()) {
                Object obj = modifiedRecord.modified.get(str);
                if (obj == null) {
                    CoreSharedPreferences.this.sysEditor.remove(str);
                } else if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() >= 5120) {
                        StatMonitor.SizeAlarm sizeAlarm = new StatMonitor.SizeAlarm(CoreSharedPreferences.this.mName);
                        sizeAlarm.key = str;
                        sizeAlarm.keySize = str.length();
                        sizeAlarm.value = str2;
                        sizeAlarm.valueSize = str2.length();
                        sizeAlarm.commit();
                    }
                    CoreSharedPreferences.this.sysEditor.putString(str, str2);
                } else if (obj instanceof Integer) {
                    CoreSharedPreferences.this.sysEditor.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    CoreSharedPreferences.this.sysEditor.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    CoreSharedPreferences.this.sysEditor.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof ArrayList) {
                    CoreSharedPreferences.this.sysEditor.putStringSet(str, new HashSet((ArrayList) obj));
                } else if (obj instanceof Float) {
                    CoreSharedPreferences.this.sysEditor.putFloat(str, ((Float) obj).floatValue());
                }
            }
            FileLock fileLock = null;
            try {
                try {
                    fileLock = new RandomAccessFile(CoreSharedPreferences.this.mLockFile, "rw").getChannel().lock();
                    boolean commit = CoreSharedPreferences.this.sysEditor.commit();
                    i = commit;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                            i = commit;
                        } catch (IOException e) {
                            e.printStackTrace();
                            i = commit;
                        }
                    }
                } catch (Throwable th) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                ALog.e(CoreSharedPreferences.TAG, "[commitToDisk]error.", e3, new Object[0]);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                i = 0;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ALog.i(CoreSharedPreferences.TAG, "commitToDisk", "cost", Long.valueOf(currentTimeMillis2));
            StatMonitor.Performance performance = new StatMonitor.Performance(CoreSharedPreferences.this.mName, 2);
            performance.costTime = currentTimeMillis2;
            performance.result = i;
            performance.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CoreSharedPreferences(Context context, String str, SharedPreferences sharedPreferences) {
        super(context, str, sharedPreferences, 0);
    }

    @Override // com.taobao.accs.asp.BaseSharedPreferences
    BaseSharedPreferences.BaseEditor customEdit() {
        return new CoreEditor();
    }

    @Override // com.taobao.accs.asp.BaseSharedPreferences
    void loadFromSP() {
        if (this.mLoaded) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, ?> entry : this.mSystemSP.getAll().entrySet()) {
            this.mMap.put(entry.getKey(), new BaseSharedPreferences.MemoryObject(entry.getValue()));
        }
        this.mLoaded = true;
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ALog.i(TAG, "loadFromSP", "cost", Long.valueOf(currentTimeMillis2));
        StatMonitor.Performance performance = new StatMonitor.Performance(this.mName, 1);
        performance.costTime = currentTimeMillis2;
        performance.result = 1;
        performance.commit();
    }
}
