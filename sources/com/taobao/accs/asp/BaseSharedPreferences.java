package com.taobao.accs.asp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseSharedPreferences implements SharedPreferences {
    static final int TYPE_CORE = 0;
    static final int TYPE_EDGE = 1;
    final File mLockFile;
    final String mName;
    final SharedPreferences mSystemSP;
    private final int mType;
    private static final Handler sUiHandler = new Handler(Looper.getMainLooper());
    private static final Object CONTENT = new Object();
    private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap<>();
    private final Object mLock = new Object();
    Map<String, MemoryObject> mMap = new HashMap();
    boolean mLoaded = false;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    abstract class BaseEditor implements SharedPreferences.Editor {
        private final Object mEditorLock = new Object();
        private Bundle mModified = new Bundle();
        private boolean mClear = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BaseEditor() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ce A[Catch: all -> 0x0106, TryCatch #1 {, blocks: (B:4:0x000b, B:10:0x001d, B:12:0x0036, B:13:0x0038, B:52:0x0104, B:14:0x0039, B:16:0x003d, B:18:0x0047, B:20:0x0051, B:21:0x005b, B:23:0x0061, B:25:0x0071, B:26:0x0079, B:28:0x0085, B:32:0x008e, B:35:0x0099, B:45:0x00ce, B:36:0x00a1, B:38:0x00ab, B:40:0x00b9, B:43:0x00c0, B:47:0x00d3, B:49:0x00e1, B:50:0x00fb, B:51:0x0103), top: B:60:0x000b }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.taobao.accs.asp.BaseSharedPreferences.MemoryCommitResult commitToMemory(long r17) {
            /*
                Method dump skipped, instructions count: 268
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.asp.BaseSharedPreferences.BaseEditor.commitToMemory(long):com.taobao.accs.asp.BaseSharedPreferences$MemoryCommitResult");
        }

        private void saveEditor() {
            final MemoryCommitResult commitToMemory = commitToMemory(SystemClock.elapsedRealtimeNanos());
            if (commitToMemory.changesMade) {
                AThreadPool.submitWriteTask(new Runnable() { // from class: com.taobao.accs.asp.BaseSharedPreferences.BaseEditor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseEditor.this.commitToDisk(commitToMemory);
                    }
                });
            }
            BaseSharedPreferences.this.notifyListeners(commitToMemory);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            saveEditor();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            synchronized (this.mEditorLock) {
                this.mClear = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            saveEditor();
            return true;
        }

        abstract void commitToDisk(MemoryCommitResult memoryCommitResult);

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this.mEditorLock) {
                this.mModified.putBoolean(str, z);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this.mEditorLock) {
                this.mModified.putFloat(str, f);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this.mEditorLock) {
                this.mModified.putInt(str, i);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this.mEditorLock) {
                this.mModified.putLong(str, j);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            synchronized (this.mEditorLock) {
                this.mModified.putString(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            synchronized (this.mEditorLock) {
                this.mModified.putStringArrayList(str, set == null ? null : new ArrayList<>(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            synchronized (this.mEditorLock) {
                this.mModified.putParcelable(str, null);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class MemoryCommitResult {
        boolean changesMade;
        @Nullable
        final List<String> keysModified;
        @Nullable
        final Set<SharedPreferences.OnSharedPreferenceChangeListener> listeners;
        ModifiedRecord modifiedRecord;

        private MemoryCommitResult(boolean z, @Nullable List<String> list, @Nullable Set<SharedPreferences.OnSharedPreferenceChangeListener> set) {
            this.changesMade = z;
            this.keysModified = list;
            this.listeners = set;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseSharedPreferences(Context context, String str, SharedPreferences sharedPreferences, int i) {
        this.mName = str;
        this.mLockFile = getLockFile(context, str);
        this.mSystemSP = sharedPreferences;
        this.mType = i;
        AThreadPool.submitLoadTask(new Runnable() { // from class: com.taobao.accs.asp.BaseSharedPreferences.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BaseSharedPreferences.this.mLock) {
                    BaseSharedPreferences.this.loadFromSP();
                    BaseSharedPreferences.this.mLock.notifyAll();
                }
            }
        });
    }

    private void awaitLoadedLocked() {
        while (!this.mLoaded) {
            try {
                this.mLock.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private File getLockFile(Context context, String str) {
        File file = new File(context.getFilesDir(), "shared_prefs");
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file, str + ".lock");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(MemoryCommitResult memoryCommitResult) {
        List<String> list;
        if (memoryCommitResult.listeners == null || !memoryCommitResult.changesMade || (list = memoryCommitResult.keysModified) == null || list.size() == 0) {
            return;
        }
        for (int size = memoryCommitResult.keysModified.size() - 1; size >= 0; size--) {
            final String str = memoryCommitResult.keysModified.get(size);
            for (final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : memoryCommitResult.listeners) {
                if (onSharedPreferenceChangeListener != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                    } else {
                        sUiHandler.post(new Runnable() { // from class: com.taobao.accs.asp.BaseSharedPreferences.3
                            @Override // java.lang.Runnable
                            public void run() {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(BaseSharedPreferences.this, str);
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean containsKey;
        synchronized (this.mLock) {
            awaitLoadedLocked();
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    abstract BaseEditor customEdit();

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        synchronized (this.mLock) {
            awaitLoadedLocked();
        }
        return customEdit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        synchronized (this.mLock) {
            awaitLoadedLocked();
            hashMap = new HashMap();
            for (Map.Entry<String, MemoryObject> entry : this.mMap.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().value);
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Boolean bool = memoryObject != null ? (Boolean) memoryObject.value : null;
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Float f2 = memoryObject != null ? (Float) memoryObject.value : null;
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Integer num = memoryObject != null ? (Integer) memoryObject.value : null;
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Long l = memoryObject != null ? (Long) memoryObject.value : null;
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            String str3 = memoryObject != null ? (String) memoryObject.value : null;
            if (str3 != null) {
                str2 = str3;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
            MemoryObject memoryObject = this.mMap.get(str);
            Set<String> set2 = memoryObject != null ? (Set) memoryObject.value : null;
            if (set2 != null) {
                set = set2;
            }
        }
        return set;
    }

    abstract void loadFromSP();

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mLock) {
            this.mListeners.put(onSharedPreferenceChangeListener, CONTENT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sync(ModifiedRecord modifiedRecord) {
        synchronized (this.mLock) {
            awaitLoadedLocked();
        }
        final BaseEditor customEdit = customEdit();
        customEdit.mModified = modifiedRecord.modified;
        customEdit.mClear = modifiedRecord.isClear;
        final MemoryCommitResult commitToMemory = customEdit.commitToMemory(modifiedRecord.timestampVersion);
        if (commitToMemory.changesMade && this.mType == 0) {
            AThreadPool.submitWriteTask(new Runnable() { // from class: com.taobao.accs.asp.BaseSharedPreferences.2
                @Override // java.lang.Runnable
                public void run() {
                    customEdit.commitToDisk(commitToMemory);
                }
            });
        }
        notifyListeners(commitToMemory);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mLock) {
            this.mListeners.remove(onSharedPreferenceChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class MemoryObject {
        long timestampVersion;
        Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MemoryObject(Object obj) {
            this.value = obj;
        }

        MemoryObject(Object obj, long j) {
            this.value = obj;
            this.timestampVersion = j;
        }
    }
}
