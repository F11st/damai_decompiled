package com.ta.utdid2.core.persistent;

import com.ta.utdid2.core.persistent.MySharedPreferences;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TransactionXMLFile {
    private static final Object GLOBAL_COMMIT_LOCK = new Object();
    public static final int MODE_PRIVATE = 0;
    private File mPreferencesDir;
    private final Object mSync = new Object();
    private HashMap<File, MySharedPreferencesImpl> sSharedPrefs = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    private static final class MySharedPreferencesImpl implements MySharedPreferences {
        private static final Object mContent = new Object();
        private boolean hasChange = false;
        private final File mBackupFile;
        private final File mFile;
        private WeakHashMap<MySharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners;
        private Map mMap;
        private final int mMode;

        /* compiled from: Taobao */
        /* loaded from: classes7.dex */
        public final class EditorImpl implements MySharedPreferences.MyEditor {
            private final Map<String, Object> mModified = new HashMap();
            private boolean mClear = false;

            public EditorImpl() {
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor clear() {
                synchronized (this) {
                    this.mClear = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<MySharedPreferences.OnSharedPreferenceChangeListener> hashSet;
                boolean writeFileLocked;
                synchronized (TransactionXMLFile.GLOBAL_COMMIT_LOCK) {
                    z = MySharedPreferencesImpl.this.mListeners.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(MySharedPreferencesImpl.this.mListeners.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.mClear) {
                            MySharedPreferencesImpl.this.mMap.clear();
                            this.mClear = false;
                        }
                        for (Map.Entry<String, Object> entry : this.mModified.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                MySharedPreferencesImpl.this.mMap.remove(key);
                            } else {
                                MySharedPreferencesImpl.this.mMap.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.mModified.clear();
                    }
                    writeFileLocked = MySharedPreferencesImpl.this.writeFileLocked();
                    if (writeFileLocked) {
                        MySharedPreferencesImpl.this.setHasChange(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (MySharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : hashSet) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(MySharedPreferencesImpl.this, str);
                            }
                        }
                    }
                }
                return writeFileLocked;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putBoolean(String str, boolean z) {
                synchronized (this) {
                    this.mModified.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putFloat(String str, float f) {
                synchronized (this) {
                    this.mModified.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putInt(String str, int i) {
                synchronized (this) {
                    this.mModified.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putLong(String str, long j) {
                synchronized (this) {
                    this.mModified.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor putString(String str, String str2) {
                synchronized (this) {
                    this.mModified.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor
            public MySharedPreferences.MyEditor remove(String str) {
                synchronized (this) {
                    this.mModified.put(str, this);
                }
                return this;
            }
        }

        MySharedPreferencesImpl(File file, int i, Map map) {
            this.mFile = file;
            this.mBackupFile = TransactionXMLFile.makeBackupFile(file);
            this.mMode = i;
            this.mMap = map == null ? new HashMap() : map;
            this.mListeners = new WeakHashMap<>();
        }

        private FileOutputStream createFileOutputStream(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean writeFileLocked() {
            if (this.mFile.exists()) {
                if (!this.mBackupFile.exists()) {
                    if (!this.mFile.renameTo(this.mBackupFile)) {
                        return false;
                    }
                } else {
                    this.mFile.delete();
                }
            }
            try {
                FileOutputStream createFileOutputStream = createFileOutputStream(this.mFile);
                if (createFileOutputStream == null) {
                    return false;
                }
                XmlUtils.writeMapXml(this.mMap, createFileOutputStream);
                createFileOutputStream.close();
                this.mBackupFile.delete();
                return true;
            } catch (Exception unused) {
                if (this.mFile.exists()) {
                    this.mFile.delete();
                }
                return false;
            }
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public boolean checkFile() {
            return this.mFile != null && new File(this.mFile.getAbsolutePath()).exists();
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public boolean contains(String str) {
            boolean containsKey;
            synchronized (this) {
                containsKey = this.mMap.containsKey(str);
            }
            return containsKey;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public MySharedPreferences.MyEditor edit() {
            return new EditorImpl();
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.mMap);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public boolean getBoolean(String str, boolean z) {
            synchronized (this) {
                Boolean bool = (Boolean) this.mMap.get(str);
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            return z;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public float getFloat(String str, float f) {
            synchronized (this) {
                Float f2 = (Float) this.mMap.get(str);
                if (f2 != null) {
                    f = f2.floatValue();
                }
            }
            return f;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public int getInt(String str, int i) {
            synchronized (this) {
                Integer num = (Integer) this.mMap.get(str);
                if (num != null) {
                    i = num.intValue();
                }
            }
            return i;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.mMap.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.mMap.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        public boolean hasFileChanged() {
            boolean z;
            synchronized (this) {
                z = this.hasChange;
            }
            return z;
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public void registerOnSharedPreferenceChangeListener(MySharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            synchronized (this) {
                this.mListeners.put(onSharedPreferenceChangeListener, mContent);
            }
        }

        public void replace(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.mMap = map;
                }
            }
        }

        public void setHasChange(boolean z) {
            synchronized (this) {
                this.hasChange = z;
            }
        }

        @Override // com.ta.utdid2.core.persistent.MySharedPreferences
        public void unregisterOnSharedPreferenceChangeListener(MySharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            synchronized (this) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
            }
        }
    }

    public TransactionXMLFile(String str) {
        if (str != null && str.length() > 0) {
            this.mPreferencesDir = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    private File getPreferencesDir() {
        File file;
        synchronized (this.mSync) {
            file = this.mPreferencesDir;
        }
        return file;
    }

    private File getSharedPrefsFile(String str) {
        File preferencesDir = getPreferencesDir();
        return makeFilename(preferencesDir, str + ".xml");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File makeBackupFile(File file) {
        return new File(file.getPath() + ".bak");
    }

    private File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c A[Catch: all -> 0x005a, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x005a, blocks: (B:30:0x0057, B:53:0x008c), top: B:85:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ta.utdid2.core.persistent.MySharedPreferences getMySharedPreferences(java.lang.String r6, int r7) {
        /*
            r5 = this;
            java.io.File r6 = r5.getSharedPrefsFile(r6)
            java.lang.Object r0 = com.ta.utdid2.core.persistent.TransactionXMLFile.GLOBAL_COMMIT_LOCK
            monitor-enter(r0)
            java.util.HashMap<java.io.File, com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl> r1 = r5.sSharedPrefs     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> Lb3
            com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl r1 = (com.ta.utdid2.core.persistent.TransactionXMLFile.MySharedPreferencesImpl) r1     // Catch: java.lang.Throwable -> Lb3
            if (r1 == 0) goto L19
            boolean r2 = r1.hasFileChanged()     // Catch: java.lang.Throwable -> Lb3
            if (r2 != 0) goto L19
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb3
            return r1
        L19:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb3
            java.io.File r0 = makeBackupFile(r6)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L2a
            r6.delete()
            r0.renameTo(r6)
        L2a:
            boolean r0 = r6.exists()
            r2 = 0
            if (r0 == 0) goto L90
            boolean r0 = r6.canRead()
            if (r0 == 0) goto L90
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 org.xmlpull.v1.XmlPullParserException -> L5c
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 org.xmlpull.v1.XmlPullParserException -> L5c
            java.util.HashMap r2 = com.ta.utdid2.core.persistent.XmlUtils.readMapXml(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a org.xmlpull.v1.XmlPullParserException -> L4e
            r0.close()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a org.xmlpull.v1.XmlPullParserException -> L4e
            r0.close()     // Catch: java.lang.Throwable -> L90
            goto L90
        L47:
            r6 = move-exception
            r2 = r0
            goto L7d
        L4a:
            r4 = r2
            r2 = r0
            r0 = r4
            goto L55
        L4e:
            r4 = r2
            r2 = r0
            r0 = r4
            goto L5d
        L52:
            r6 = move-exception
            goto L7d
        L54:
            r0 = r2
        L55:
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.lang.Throwable -> L5a
        L5a:
            r2 = r0
            goto L90
        L5c:
            r0 = r2
        L5d:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L83
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L83
            int r2 = r3.available()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L74
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L74
            r3.read(r2)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L74
            r3.close()     // Catch: java.lang.Throwable -> L6f
            goto L8a
        L6f:
            goto L8a
        L71:
            r6 = move-exception
            r2 = r3
            goto L77
        L74:
            r2 = r3
            goto L84
        L76:
            r6 = move-exception
        L77:
            if (r2 == 0) goto L7c
            r2.close()     // Catch: java.lang.Throwable -> L7c
        L7c:
            throw r6     // Catch: java.lang.Throwable -> L52
        L7d:
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.lang.Throwable -> L82
        L82:
            throw r6
        L83:
        L84:
            if (r2 == 0) goto L89
            r2.close()     // Catch: java.lang.Throwable -> L89
        L89:
            r3 = r2
        L8a:
            if (r3 == 0) goto L5a
            r3.close()     // Catch: java.lang.Throwable -> L5a
            goto L5a
        L90:
            java.lang.Object r3 = com.ta.utdid2.core.persistent.TransactionXMLFile.GLOBAL_COMMIT_LOCK
            monitor-enter(r3)
            if (r1 == 0) goto L99
            r1.replace(r2)     // Catch: java.lang.Throwable -> Lb0
            goto Lae
        L99:
            java.util.HashMap<java.io.File, com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl> r0 = r5.sSharedPrefs     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r0 = r0.get(r6)     // Catch: java.lang.Throwable -> Lb0
            r1 = r0
            com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl r1 = (com.ta.utdid2.core.persistent.TransactionXMLFile.MySharedPreferencesImpl) r1     // Catch: java.lang.Throwable -> Lb0
            if (r1 != 0) goto Lae
            com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl r1 = new com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl     // Catch: java.lang.Throwable -> Lb0
            r1.<init>(r6, r7, r2)     // Catch: java.lang.Throwable -> Lb0
            java.util.HashMap<java.io.File, com.ta.utdid2.core.persistent.TransactionXMLFile$MySharedPreferencesImpl> r7 = r5.sSharedPrefs     // Catch: java.lang.Throwable -> Lb0
            r7.put(r6, r1)     // Catch: java.lang.Throwable -> Lb0
        Lae:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb0
            return r1
        Lb0:
            r6 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb0
            throw r6
        Lb3:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb3
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.TransactionXMLFile.getMySharedPreferences(java.lang.String, int):com.ta.utdid2.core.persistent.MySharedPreferences");
    }
}
