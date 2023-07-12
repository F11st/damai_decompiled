package com.taobao.accs.asp;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.asp.BaseSharedPreferences;
import com.taobao.accs.asp.PrefsIPCChannel;
import com.taobao.accs.asp.StatMonitor;
import com.taobao.accs.utl.ALog;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class EdgeSharedPreferences extends BaseSharedPreferences implements OnDataUpdateListener {
    private static final String TAG = "EdgeSharedPreferences";

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    final class EdgeEditor extends BaseSharedPreferences.BaseEditor {
        EdgeEditor() {
            super();
        }

        @Override // com.taobao.accs.asp.BaseSharedPreferences.BaseEditor
        void commitToDisk(BaseSharedPreferences.MemoryCommitResult memoryCommitResult) {
            ModifiedRecord modifiedRecord = memoryCommitResult.modifiedRecord;
            if (modifiedRecord == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            PrefsIPCChannel.Client.commitToDisk(modifiedRecord);
            ALog.i(EdgeSharedPreferences.TAG, "commitToDisk", "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EdgeSharedPreferences(Context context, String str, SharedPreferences sharedPreferences) {
        super(context, str, sharedPreferences, 1);
        registerChannelListener();
    }

    @Override // com.taobao.accs.asp.BaseSharedPreferences
    BaseSharedPreferences.BaseEditor customEdit() {
        return new EdgeEditor();
    }

    @Override // com.taobao.accs.asp.BaseSharedPreferences
    void loadFromSP() {
        RandomAccessFile randomAccessFile;
        if (this.mLoaded) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileLock fileLock = null;
        try {
            randomAccessFile = new RandomAccessFile(this.mLockFile, "rw");
            int i = 0;
            while (fileLock == null && i < 10) {
                try {
                    fileLock = randomAccessFile.getChannel().tryLock();
                    if (fileLock == null) {
                        Thread.sleep(20L);
                        i++;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        for (Map.Entry<String, ?> entry : this.mSystemSP.getAll().entrySet()) {
            this.mMap.put(entry.getKey(), new BaseSharedPreferences.MemoryObject(entry.getValue()));
        }
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                ALog.e(TAG, "randomAccessFile close err", th2, new Object[0]);
            }
        }
        this.mLoaded = true;
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ALog.i(TAG, "loadFromSP", "cost", Long.valueOf(currentTimeMillis2));
        StatMonitor.Performance performance = new StatMonitor.Performance(this.mName, 1);
        performance.costTime = currentTimeMillis2;
        performance.result = 1;
        performance.commit();
    }

    @Override // com.taobao.accs.asp.OnDataUpdateListener
    public void onDataUpdate(ModifiedRecord modifiedRecord) {
        sync(modifiedRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerChannelListener() {
        AThreadPool.submitWriteTask(new Runnable() { // from class: com.taobao.accs.asp.EdgeSharedPreferences.1
            @Override // java.lang.Runnable
            public void run() {
                EdgeSharedPreferences edgeSharedPreferences = EdgeSharedPreferences.this;
                PrefsIPCChannel.Client.registerDataListener(edgeSharedPreferences.mName, edgeSharedPreferences);
            }
        });
    }
}
