package android.taobao.windvane.cache;

import android.os.Process;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.util.TaoLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVFileCache {
    public static final int CREATE = 4;
    public static final int DELETE = 3;
    private static final String FILE_INFO = "wv_web_info.dat";
    public static final int READ = 1;
    private static String TAG = "WVFileCache";
    public static final int WRITE = 2;
    private String baseDirPath;
    private FileChannel fInfoChannel;
    private RandomAccessFile fInfoOs;
    private String infoDirPath;
    private int maxCapacity;
    private boolean sdcard;
    private Map<String, WVFileInfo> storedFile = Collections.synchronizedMap(new FixedSizeLinkedHashMap());
    private boolean isNoSpaceClear = true;
    private boolean isInit = false;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    protected class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = 1;

        protected FixedSizeLinkedHashMap() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() > WVFileCache.this.maxCapacity) {
                if (TaoLog.getLogStatus()) {
                    String str = WVFileCache.TAG;
                    TaoLog.d(str, "removeEldestEntry, size:" + size() + " " + entry.getKey());
                }
                V value = entry.getValue();
                if (value instanceof WVFileInfo) {
                    WVFileInfo wVFileInfo = (WVFileInfo) value;
                    if (FileAccesser.deleteFile(new File(WVFileCache.this.baseDirPath, wVFileInfo.fileName))) {
                        WVFileInfoParser.updateFileInfo(3, wVFileInfo, WVFileCache.this.fInfoChannel);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    public WVFileCache(String str, String str2, int i, boolean z) {
        this.maxCapacity = 100;
        this.baseDirPath = str;
        this.infoDirPath = str2;
        this.maxCapacity = i;
        this.sdcard = z;
    }

    private boolean collectFiles() {
        byte[] bArr;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ByteBuffer allocate = ByteBuffer.allocate((int) this.fInfoChannel.size());
            this.fInfoChannel.read(allocate);
            bArr = allocate.array();
        } catch (IOException e) {
            String str = TAG;
            TaoLog.e(str, "collectFiles fInfoChannel.read error:" + e.getMessage());
            bArr = null;
        }
        if (TaoLog.getLogStatus()) {
            String str2 = TAG;
            TaoLog.d(str2, "collectFiles read fileinfo:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (bArr != null) {
            TaoLog.d("collectFiles", "read fileinfo success");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 60;
            boolean z = false;
            int i2 = 0;
            while (i < bArr.length) {
                if (bArr[i] == 10) {
                    int i3 = i - i2;
                    WVFileInfo fileInfo = WVFileInfoParser.getFileInfo(bArr, i2, i3);
                    if (fileInfo != null) {
                        String str3 = fileInfo.fileName;
                        if (!this.storedFile.containsKey(str3)) {
                            fileInfo.pos = byteArrayOutputStream.size();
                            this.storedFile.put(str3, fileInfo);
                            byteArrayOutputStream.write(bArr, i2, i3 + 1);
                            i2 = i + 1;
                            i += 60;
                        }
                    }
                    z = true;
                    i2 = i + 1;
                    i += 60;
                }
                i++;
            }
            if (TaoLog.getLogStatus()) {
                String str4 = TAG;
                TaoLog.d(str4, "parse fileinfo:" + (System.currentTimeMillis() - currentTimeMillis2));
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (z) {
                try {
                    this.fInfoChannel.truncate(0L);
                    this.fInfoChannel.position(0L);
                    ByteBuffer wrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                    wrap.position(0);
                    this.fInfoChannel.write(wrap);
                } catch (IOException e2) {
                    String str5 = TAG;
                    TaoLog.e(str5, "collectFiles fInfoChannel.write error:" + e2.getMessage());
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            if (TaoLog.getLogStatus()) {
                String str6 = TAG;
                TaoLog.d(str6, "write fileinfo:" + (System.currentTimeMillis() - currentTimeMillis3));
            }
            return true;
        }
        return false;
    }

    private void onFileOverflow() {
        TaoLog.d(TAG, "onFileOverflow");
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<String, WVFileInfo>> entrySet = this.storedFile.entrySet();
        int size = this.storedFile.size();
        for (Map.Entry<String, WVFileInfo> entry : entrySet) {
            if (size < this.maxCapacity) {
                break;
            }
            WVFileInfo value = entry.getValue();
            if (value != null) {
                arrayList.add(value);
            }
            size--;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            delete(((WVFileInfo) it.next()).fileName);
        }
    }

    private void setCapacity(int i) {
        if (this.storedFile.size() > i) {
            onFileOverflow();
        }
    }

    public boolean clear() {
        String[] list;
        if (!this.isInit || (list = new File(this.baseDirPath).list()) == null) {
            return false;
        }
        boolean z = true;
        for (String str : list) {
            z &= delete(str);
        }
        return z;
    }

    public boolean delete(String str) {
        WVFileInfo wVFileInfo;
        if (this.isInit && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(this.baseDirPath, str);
            r1 = file.isFile() ? file.delete() : false;
            if ((r1 || !file.exists()) && (wVFileInfo = this.storedFile.get(str)) != null) {
                TaoLog.d(TAG, "delete success");
                WVFileInfoParser.updateFileInfo(3, wVFileInfo, this.fInfoChannel);
                this.storedFile.remove(str);
                if (TaoLog.getLogStatus()) {
                    String str2 = TAG;
                    TaoLog.d(str2, "delete time cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    return true;
                }
                return true;
            }
        }
        return r1;
    }

    protected void finalize() throws Throwable {
        RandomAccessFile randomAccessFile = this.fInfoOs;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileChannel fileChannel = this.fInfoChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        super.finalize();
    }

    public String getDirPath() {
        return this.baseDirPath;
    }

    public WVFileInfo getFileInfo(String str) {
        WVFileInfo wVFileInfo;
        if (this.isInit && (wVFileInfo = this.storedFile.get(str)) != null) {
            if (new File(this.baseDirPath, str).exists()) {
                return wVFileInfo;
            }
            WVFileInfoParser.updateFileInfo(3, wVFileInfo, this.fInfoChannel);
            return null;
        }
        return null;
    }

    public synchronized boolean init() {
        if (!this.isInit) {
            File file = new File(this.infoDirPath, FILE_INFO);
            if (!file.exists()) {
                new File(this.infoDirPath).mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    String str = TAG;
                    TaoLog.e(str, "init createNewFile:" + e.getMessage());
                    return false;
                }
            }
            new File(this.baseDirPath).mkdirs();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsolutePath(), "rw");
                this.fInfoOs = randomAccessFile;
                if (this.fInfoChannel == null) {
                    this.fInfoChannel = randomAccessFile.getChannel();
                }
                if (TaoLog.getLogStatus()) {
                    String str2 = TAG;
                    TaoLog.d(str2, "lock success process is " + Process.myPid());
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (!collectFiles()) {
                    return false;
                }
                if (TaoLog.getLogStatus()) {
                    String str3 = TAG;
                    TaoLog.d(str3, "init time cost:" + (System.currentTimeMillis() - currentTimeMillis));
                }
                this.isInit = true;
                setCapacity(this.maxCapacity);
                if (this.storedFile.size() == 0) {
                    clear();
                }
            } catch (Exception e2) {
                String str4 = TAG;
                TaoLog.e(str4, "init fInfoOs RandomAccessFile:" + e2.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean isSdcard() {
        return this.sdcard;
    }

    public byte[] read(String str) {
        if (TaoLog.getLogStatus()) {
            String str2 = TAG;
            TaoLog.d(str2, "read:" + str);
        }
        if (this.isInit) {
            long currentTimeMillis = System.currentTimeMillis();
            WVFileInfo wVFileInfo = this.storedFile.get(str);
            if (wVFileInfo == null) {
                return null;
            }
            this.storedFile.remove(str);
            this.storedFile.put(str, WVFileInfoParser.updateFileInfo(1, wVFileInfo, this.fInfoChannel));
            byte[] read = FileAccesser.read(new File(this.baseDirPath, str));
            if (TaoLog.getLogStatus()) {
                String str3 = TAG;
                TaoLog.d(str3, "read time cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return read;
        }
        return null;
    }

    public int size() {
        if (this.isInit) {
            return this.storedFile.size();
        }
        return 0;
    }

    public void updateFileInfo(WVFileInfo wVFileInfo) {
        String str;
        WVFileInfo wVFileInfo2;
        if (!this.isInit || wVFileInfo == null || (str = wVFileInfo.fileName) == null || (wVFileInfo2 = this.storedFile.get(str)) == null) {
            return;
        }
        TaoLog.d(TAG, "update info success");
        wVFileInfo.pos = wVFileInfo2.pos;
        this.storedFile.put(str, WVFileInfoParser.updateFileInfo(2, wVFileInfo, this.fInfoChannel));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean write(android.taobao.windvane.cache.WVFileInfo r8, java.nio.ByteBuffer r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto Lae
            java.lang.String r1 = r8.fileName
            if (r1 != 0) goto L9
            goto Lae
        L9:
            boolean r2 = android.taobao.windvane.util.TaoLog.getLogStatus()
            if (r2 == 0) goto L26
            java.lang.String r2 = android.taobao.windvane.cache.WVFileCache.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "write:"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.taobao.windvane.util.TaoLog.d(r2, r3)
        L26:
            boolean r2 = r7.isInit
            if (r2 == 0) goto Lae
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r7.baseDirPath
            r2.<init>(r3, r1)
            boolean r9 = android.taobao.windvane.file.FileAccesser.write(r2, r9)     // Catch: android.taobao.windvane.file.NotEnoughSpace -> L36
            goto L6b
        L36:
            r3 = move-exception
            java.lang.String r4 = android.taobao.windvane.cache.WVFileCache.TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "write error. fileName="
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = ". NotEnoughSpace: "
            r5.append(r6)
            java.lang.String r3 = r3.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.taobao.windvane.util.TaoLog.e(r4, r3)
            boolean r3 = r7.isNoSpaceClear
            if (r3 == 0) goto L6a
            r7.clear()
            boolean r9 = android.taobao.windvane.file.FileAccesser.write(r2, r9)     // Catch: android.taobao.windvane.file.NotEnoughSpace -> L66
            goto L6b
        L66:
            r9 = move-exception
            r9.printStackTrace()
        L6a:
            r9 = 0
        L6b:
            if (r9 == 0) goto Lae
            java.util.Map<java.lang.String, android.taobao.windvane.cache.WVFileInfo> r9 = r7.storedFile
            java.lang.Object r9 = r9.get(r1)
            android.taobao.windvane.cache.WVFileInfo r9 = (android.taobao.windvane.cache.WVFileInfo) r9
            if (r9 == 0) goto L94
            java.lang.String r0 = android.taobao.windvane.cache.WVFileCache.TAG
            java.lang.String r2 = "writed success, file exist"
            android.taobao.windvane.util.TaoLog.d(r0, r2)
            long r2 = r9.pos
            r8.pos = r2
            r9 = 2
            java.nio.channels.FileChannel r0 = r7.fInfoChannel
            android.taobao.windvane.cache.WVFileInfo r8 = android.taobao.windvane.cache.WVFileInfoParser.updateFileInfo(r9, r8, r0)
            java.util.Map<java.lang.String, android.taobao.windvane.cache.WVFileInfo> r9 = r7.storedFile
            android.taobao.windvane.cache.WVFileInfo r8 = r8.convertToFileInfo()
            r9.put(r1, r8)
            goto Lac
        L94:
            java.lang.String r9 = android.taobao.windvane.cache.WVFileCache.TAG
            java.lang.String r0 = "writed success, file do not exist"
            android.taobao.windvane.util.TaoLog.d(r9, r0)
            r9 = 4
            java.nio.channels.FileChannel r0 = r7.fInfoChannel
            android.taobao.windvane.cache.WVFileInfo r8 = android.taobao.windvane.cache.WVFileInfoParser.updateFileInfo(r9, r8, r0)
            java.util.Map<java.lang.String, android.taobao.windvane.cache.WVFileInfo> r9 = r7.storedFile
            android.taobao.windvane.cache.WVFileInfo r8 = r8.convertToFileInfo()
            r9.put(r1, r8)
        Lac:
            r8 = 1
            return r8
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.cache.WVFileCache.write(android.taobao.windvane.cache.WVFileInfo, java.nio.ByteBuffer):boolean");
    }
}
