package com.alibaba.android.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class SharedPreferencesNewImpl implements SharedPreferences {
    private final LinkedHashMap<String, Object> a;
    private final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> b;
    private FileObserverC3235e c;
    private boolean d;
    private File e;
    private String f;
    private int g;
    private FileChannel h;
    private MappedByteBuffer i;
    private HandlerThread j;
    private Handler k;
    private final Object l;
    private final Object m;
    private int n;
    private Vector<SharedPreferences.Editor> o;
    private OnSharedPreferenceErrorListener p;
    private long q;
    private final Runnable r;
    private RunnableEx s;
    private int t;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static abstract class RunnableEx implements Runnable {
        private Object mArg;

        public Object getArg() {
            return this.mArg;
        }

        public void setArg(Object obj) {
            this.mArg = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl$a */
    /* loaded from: classes5.dex */
    public static class C3231a {
        public static float a(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }

        public static byte[] b(float f) {
            return ByteBuffer.allocate(4).putFloat(f).array();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl$b */
    /* loaded from: classes5.dex */
    public static class C3232b {
        public static int a(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }

        public static byte[] b(int i) {
            return ByteBuffer.allocate(4).putInt(i).array();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl$c */
    /* loaded from: classes5.dex */
    public static class C3233c {
        public static long a(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }

        public static byte[] b(long j) {
            return ByteBuffer.allocate(8).putLong(j).array();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl$d */
    /* loaded from: classes5.dex */
    public final class SharedPreferences$EditorC3234d implements SharedPreferences.Editor {
        private HashMap<String, Object> a = new HashMap<>();
        private boolean b;

        public SharedPreferences$EditorC3234d() {
        }

        boolean a() {
            boolean z;
            synchronized (this) {
                z = this.b;
                this.b = false;
            }
            return z;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            SharedPreferencesNewImpl.this.M(this, false, false, true);
        }

        HashMap<String, Object> b() {
            HashMap<String, Object> hashMap;
            synchronized (this) {
                hashMap = this.a;
            }
            return hashMap;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            synchronized (this) {
                this.b = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            SharedPreferencesNewImpl.this.M(this, false, true, false);
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.a.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            synchronized (this) {
                this.a.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            synchronized (this) {
                this.a.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            synchronized (this) {
                this.a.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.a.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.a.put(str, null);
            }
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl$e */
    /* loaded from: classes5.dex */
    private final class FileObserverC3235e extends FileObserver {
        public FileObserverC3235e(String str, int i) {
            super(str, i);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if (SharedPreferencesNewImpl.this.b.size() > 0) {
                SharedPreferencesNewImpl.this.Q();
            } else {
                stopWatching();
            }
        }
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, null);
    }

    private boolean A() {
        byte[] bArr;
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        String str;
        long length;
        RandomAccessFile randomAccessFile;
        int a;
        Closeable closeable = null;
        byte[] bArr2 = null;
        boolean z = true;
        try {
            randomAccessFile = new RandomAccessFile(this.f, UploadQueueMgr.MSGTYPE_REALTIME);
            try {
                byte[] bArr3 = new byte[4];
                randomAccessFile.read(bArr3, 0, 4);
                a = C3232b.a(bArr3);
            } catch (Throwable th) {
                th = th;
                bArr = bArr2;
                closeable = randomAccessFile;
                try {
                    th.printStackTrace();
                    L(closeable);
                    try {
                        z = H(bArr, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        str = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + th.getCause() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + z;
                        length = bArr != null ? bArr.length : 0;
                        onSharedPreferenceErrorListener.onError(str, 12, length);
                    }
                    return z;
                } catch (Throwable th2) {
                    L(closeable);
                    try {
                        z = H(bArr, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.p;
                    if (onSharedPreferenceErrorListener2 != null) {
                        onSharedPreferenceErrorListener2.onError(this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + th.getCause() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + z, 12, bArr != null ? bArr.length : 0);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
        }
        if (a <= 10) {
            L(randomAccessFile);
            try {
                H(null, false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return false;
        }
        if (a > Integer.MAX_VALUE) {
            a = Integer.MAX_VALUE;
        }
        if (a > randomAccessFile.length()) {
            a = (int) randomAccessFile.length();
        }
        int i = a - 10;
        bArr2 = new byte[i];
        randomAccessFile.seek(10L);
        randomAccessFile.read(bArr2);
        L(randomAccessFile);
        try {
            z = H(bArr2, false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        onSharedPreferenceErrorListener = this.p;
        if (onSharedPreferenceErrorListener != null) {
            str = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + ((Object) "") + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + z;
            length = i;
            onSharedPreferenceErrorListener.onError(str, 12, length);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.d) {
            return;
        }
        z(false);
        this.d = true;
        notifyAll();
    }

    private FileLock C(boolean z) {
        FileChannel fileChannel = this.h;
        FileLock fileLock = null;
        if (fileChannel == null) {
            return null;
        }
        if (z) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            while (fileLock == null) {
                try {
                    fileLock = this.h.tryLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fileLock == null) {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (SystemClock.elapsedRealtime() - elapsedRealtime > 10000) {
                    return fileLock;
                }
            }
            return fileLock;
        }
        try {
            return fileChannel.tryLock();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private boolean D(SharedPreferences.Editor editor, Map map, boolean z) {
        if (editor == null) {
            return false;
        }
        SharedPreferences$EditorC3234d sharedPreferences$EditorC3234d = (SharedPreferences$EditorC3234d) editor;
        boolean a = sharedPreferences$EditorC3234d.a();
        if (a) {
            map.clear();
        }
        HashMap<String, Object> b = sharedPreferences$EditorC3234d.b();
        if (b.size() == 0) {
            return a;
        }
        synchronized (editor) {
            for (Map.Entry<String, Object> entry : b.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.remove(key);
                } else {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                    map.put(key, value);
                }
                if (!z) {
                    F(key);
                }
            }
        }
        return true;
    }

    private void E() {
        synchronized (this.a) {
            if (this.o.size() > 0) {
                Iterator<SharedPreferences.Editor> it = this.o.iterator();
                while (it.hasNext()) {
                    D(it.next(), this.a, true);
                }
            }
        }
    }

    private void F(String str) {
        if (this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.b.get(i);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    private byte[] G() {
        Pair<Integer, byte[][]> q = q();
        int intValue = ((Integer) q.first).intValue() + 10 + (((byte[][]) q.second).length * 1);
        if (intValue > Integer.MAX_VALUE) {
            intValue = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[intValue];
        byte[] b = C3232b.b(intValue);
        System.arraycopy(b, 0, bArr, 0, b.length);
        int length = b.length + 0;
        bArr[length] = r(b);
        int i = length + 1;
        byte[] b2 = C3232b.b(w());
        System.arraycopy(b2, 0, bArr, i, b2.length);
        int length2 = i + b2.length;
        bArr[length2] = r(b2);
        int i2 = length2 + 1;
        byte[][] bArr2 = (byte[][]) q.second;
        int length3 = bArr2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length3) {
                break;
            }
            byte[] bArr3 = bArr2[i3];
            if (bArr3 != null) {
                if (bArr3.length + i2 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr3, 0, bArr, i2, bArr3.length);
                    int length4 = i2 + bArr3.length;
                    bArr[length4] = r(bArr3);
                    i2 = length4 + 1;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Write too much data in ");
                    File file = this.e;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    Log.e("SharedPreferencesNew", sb.toString());
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        File file2 = this.e;
                        onSharedPreferenceErrorListener.onError(file2 != null ? file2.getAbsolutePath() : null, 7, -1L);
                    }
                }
            }
            i3++;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        r3 = r12.p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (r3 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        r5 = r12.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r5 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
        r5 = r5.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
        r3.onError(r5, 8, r13.length);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean H(byte[] r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.H(byte[], boolean):boolean");
    }

    private void I() {
        if (this.i == null) {
            return;
        }
        synchronized (this.l) {
            try {
                int p = p();
                if (p > this.i.capacity()) {
                    j(p + 1024);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean J(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int position = mappedByteBuffer.position();
        if (position + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private void K(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
            mappedByteBuffer = j(mappedByteBuffer.position() + bArr.length + 1024);
        }
        mappedByteBuffer.put(bArr);
    }

    private void L(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(SharedPreferences.Editor editor, boolean z, boolean z2, boolean z3) {
        if (editor == null) {
            return;
        }
        synchronized (this.a) {
            this.n = 0;
            if (D(editor, this.a, false)) {
                this.o.add(editor);
                if (z2) {
                    N(z);
                    return;
                }
                long j = z3 ? 1000L : 0L;
                this.s.setArg(Boolean.valueOf(z));
                Message obtain = Message.obtain(this.k, this.s);
                obtain.what = 21310;
                this.k.sendMessageDelayed(obtain, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(final boolean z) {
        synchronized (this.m) {
            FileLock C = C(false);
            if (C != null) {
                if (R()) {
                    E();
                    F(null);
                }
                synchronized (this.a) {
                    if (this.o.size() <= 0) {
                        try {
                            C.release();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    O(G(), z);
                    l();
                    try {
                        C.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                int i = this.n;
                this.n = i + 1;
                if (i < 6) {
                    this.k.postDelayed(new Runnable() { // from class: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.3
                        @Override // java.lang.Runnable
                        public void run() {
                            SharedPreferencesNewImpl.this.N(z);
                        }
                    }, 2000L);
                }
            }
        }
    }

    private void O(byte[] bArr, boolean z) {
        synchronized (this.l) {
            this.i.position(0);
            K(this.i, bArr);
            if (z) {
                this.i.force();
            }
        }
    }

    private void P() {
        synchronized (this) {
            this.d = false;
        }
        this.k.post(new Runnable() { // from class: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.B();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (SystemClock.elapsedRealtime() - this.q > 60) {
            this.q = SystemClock.elapsedRealtime();
            this.k.removeCallbacks(this.r);
            this.k.post(this.r);
        }
    }

    private boolean R() {
        int s = s();
        if (s <= 0 || s == this.g) {
            return false;
        }
        z(true);
        return true;
    }

    private MappedByteBuffer j(int i) {
        MappedByteBuffer mappedByteBuffer = this.i;
        int position = mappedByteBuffer != null ? mappedByteBuffer.position() : 0;
        try {
            this.i = this.h.map(FileChannel.MapMode.READ_WRITE, 0L, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MappedByteBuffer mappedByteBuffer2 = this.i;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(position);
        }
        return this.i;
    }

    private void k() {
        synchronized (this) {
            while (!this.d) {
                wait();
            }
        }
        Q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l() {
        Throwable th;
        Closeable closeable;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel = null;
        try {
            File file = new File(this.f);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
        }
        try {
            fileChannel = fileOutputStream.getChannel();
            this.h.transferTo(0L, this.i.capacity(), fileChannel);
            L(fileOutputStream);
            L(fileChannel);
        } catch (Throwable th3) {
            closeable = fileChannel;
            fileChannel = fileOutputStream;
            th = th3;
            try {
                th.printStackTrace();
            } finally {
                L(fileChannel);
                L(closeable);
            }
        }
    }

    private byte n(byte[] bArr) {
        byte b = 0;
        for (byte b2 : bArr) {
            b = (byte) (b ^ b2);
        }
        return b;
    }

    private byte[] o(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return ((String) obj).getBytes();
                }
                if (obj instanceof Boolean) {
                    int i = 1;
                    byte[] bArr = new byte[1];
                    if (!((Boolean) obj).booleanValue()) {
                        i = 0;
                    }
                    bArr[0] = (byte) i;
                    return bArr;
                } else if (obj instanceof Float) {
                    return C3231a.b(((Float) obj).floatValue());
                } else {
                    if (obj instanceof Integer) {
                        return C3232b.b(((Integer) obj).intValue());
                    }
                    if (obj instanceof Long) {
                        return C3233c.b(((Long) obj).longValue());
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private int p() {
        if (this.i == null || this.h == null) {
            return -1;
        }
        synchronized (this.l) {
            this.i.position(0);
            byte[] bArr = new byte[4];
            J(this.i, bArr);
            int a = C3232b.a(bArr);
            this.i.position(4);
            byte b = this.i.get();
            if ((b == 18 || b == r(bArr)) && a >= 0) {
                if (a > Integer.MAX_VALUE) {
                    a = Integer.MAX_VALUE;
                }
                return a;
            }
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
            if (onSharedPreferenceErrorListener != null) {
                File file = this.e;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.e;
                onSharedPreferenceErrorListener.onError(absolutePath, 1, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    private Pair<Integer, byte[][]> q() {
        byte[][] bArr;
        ArrayList arrayList;
        synchronized (this.a) {
            bArr = new byte[this.a.size() * 5];
            arrayList = new ArrayList(this.a.entrySet());
            this.o.clear();
        }
        int i = 0;
        int i2 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && str.trim().length() > 0 && value != null) {
                byte[] bytes = str.getBytes();
                byte[] b = C3232b.b(bytes.length);
                bArr[i2] = b;
                bArr[i2 + 1] = bytes;
                int length = i + b.length + bytes.length;
                byte[] o = o(value);
                byte[] b2 = C3232b.b(o.length);
                bArr[i2 + 2] = b2;
                bArr[i2 + 3] = o;
                byte[] bArr2 = new byte[1];
                bArr2[0] = (byte) u(value);
                bArr[i2 + 4] = bArr2;
                i = length + b2.length + o.length + 1;
                i2 += 5;
            }
        }
        return new Pair<>(Integer.valueOf(i), bArr);
    }

    private byte r(byte[] bArr) {
        return n(bArr);
    }

    private Object t(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            if (i == 5) {
                return new String(bArr);
            }
            boolean z = true;
            if (i == 4) {
                if (bArr[0] != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else if (i == 2) {
                return Float.valueOf(C3231a.a(bArr));
            } else {
                if (i == 1) {
                    return Integer.valueOf(C3232b.a(bArr));
                }
                if (i == 3) {
                    return Long.valueOf(C3233c.a(bArr));
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int u(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        return obj instanceof Long ? 3 : 0;
    }

    private Pair<byte[], Integer> v(byte[] bArr, int i) throws Exception {
        int i2;
        int i3;
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i, bArr2, 0, 4);
        int i4 = i + 4;
        if (bArr[i4] != 18 && bArr[i4] != r(bArr2)) {
            throw new Exception("length string's finish mark missing");
        }
        int i5 = i4 + 1;
        int a = C3232b.a(bArr2);
        if (a >= 0 && (i2 = i5 + a) < bArr.length && a <= Integer.MAX_VALUE) {
            byte[] bArr3 = null;
            if (a == 0) {
                i3 = i5 + 1;
            } else {
                bArr3 = new byte[a];
                System.arraycopy(bArr, i5, bArr3, 0, a);
                if (bArr[i2] != 18 && bArr[i2] != r(bArr3)) {
                    throw new Exception("Stored bytes' finish mark missing");
                }
                i3 = i2 + 1;
            }
            return new Pair<>(bArr3, Integer.valueOf(i3));
        }
        throw new Exception("length string is invalid");
    }

    private int w() {
        int i = (this.g + 1) % Integer.MAX_VALUE;
        this.g = i;
        return i;
    }

    private boolean x() {
        boolean z = true;
        if (this.i == null) {
            try {
                if (!this.e.exists()) {
                    this.e.getParentFile().mkdirs();
                    this.e.createNewFile();
                    z = new File(this.f).exists();
                } else if (this.e.length() == 0) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        onSharedPreferenceErrorListener.onError(this.e.getAbsolutePath(), 4, this.e.length());
                    }
                    z = false;
                }
                this.h = new RandomAccessFile(this.e, "rw").getChannel();
                j(10);
                if (!z) {
                    y();
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.p;
                if (onSharedPreferenceErrorListener2 != null) {
                    onSharedPreferenceErrorListener2.onError(this.e.getAbsolutePath() + " " + e.getCause(), 10, -1L);
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    private void y() {
        if (this.i != null) {
            byte[] bArr = new byte[10];
            byte[] b = C3232b.b(0);
            System.arraycopy(b, 0, bArr, 0, 4);
            bArr[4] = r(b);
            byte[] b2 = C3232b.b(0);
            System.arraycopy(b2, 0, bArr, 5, 4);
            bArr[9] = r(b2);
            this.i.position(0);
            this.i.put(bArr);
        }
    }

    private void z(boolean z) {
        byte[] bArr = null;
        FileLock C = z ? null : C(true);
        if (C == null && !z) {
            if (z) {
                return;
            }
            A();
            return;
        }
        boolean z2 = false;
        try {
            I();
            MappedByteBuffer mappedByteBuffer = this.i;
            if (mappedByteBuffer != null && mappedByteBuffer.capacity() != 0) {
                long p = p();
                if (p <= 10) {
                    try {
                        z2 = H(null, true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!z2 || this.g < 0) {
                        A();
                    }
                    if (C != null) {
                        try {
                            C.release();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                int s = s();
                this.g = s;
                if (s > 0) {
                    synchronized (this.l) {
                        this.i.position(10);
                        bArr = new byte[((int) p) - 10];
                        J(this.i, bArr);
                    }
                }
                try {
                    z2 = H(bArr, true);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (!z2 || (bArr == null && this.g < 0)) {
                    A();
                }
                if (C != null) {
                    try {
                        C.release();
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                z2 = H(null, true);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            if (!z2 || this.g < 0) {
                A();
            }
            if (C != null) {
                try {
                    C.release();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        } catch (Throwable th) {
            try {
                z2 = H(bArr, true);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            if (!z2 || (bArr == null && this.g < 0)) {
                A();
            }
            if (C != null) {
                try {
                    C.release();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean containsKey;
        k();
        synchronized (this.a) {
            containsKey = this.a.containsKey(str);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        k();
        return new SharedPreferences$EditorC3234d();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        k();
        synchronized (this.a) {
            hashMap = new HashMap(this.a);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        k();
        synchronized (this.a) {
            try {
                try {
                    Boolean bool = (Boolean) this.a.get(str);
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.e;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb.append(str);
                        sb.append(e);
                        String sb2 = sb.toString();
                        File file2 = this.e;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        k();
        synchronized (this.a) {
            try {
                try {
                    Float f2 = (Float) this.a.get(str);
                    if (f2 != null) {
                        f = f2.floatValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.e;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb.append(str);
                        sb.append(e);
                        String sb2 = sb.toString();
                        File file2 = this.e;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        k();
        synchronized (this.a) {
            try {
                try {
                    Integer num = (Integer) this.a.get(str);
                    if (num != null) {
                        i = num.intValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.e;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb.append(str);
                        sb.append(e);
                        String sb2 = sb.toString();
                        File file2 = this.e;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        k();
        synchronized (this.a) {
            try {
                try {
                    Long l = (Long) this.a.get(str);
                    if (l != null) {
                        j = l.longValue();
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.e;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb.append(str);
                        sb.append(e);
                        String sb2 = sb.toString();
                        File file2 = this.e;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        k();
        synchronized (this.a) {
            try {
                try {
                    String str3 = (String) this.a.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } catch (ClassCastException e) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.p;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb = new StringBuilder();
                        File file = this.e;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb.append(str);
                        sb.append(e);
                        String sb2 = sb.toString();
                        File file2 = this.e;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return str2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    boolean m(byte b) {
        return b == 4 || b == 2 || b == 1 || b == 3 || b == 5;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            this.b.add(onSharedPreferenceChangeListener);
            FileObserverC3235e fileObserverC3235e = this.c;
            if (fileObserverC3235e != null) {
                fileObserverC3235e.startWatching();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        if (this.i == null) {
            return -1;
        }
        synchronized (this.l) {
            this.i.position(5);
            byte[] bArr = new byte[4];
            J(this.i, bArr);
            int a = C3232b.a(bArr);
            this.i.position(9);
            byte b = this.i.get();
            if ((b == 18 || b == r(bArr)) && a >= 0) {
                return a;
            }
            int i = this.t + 1;
            this.t = i;
            if (i < 3 && (onSharedPreferenceErrorListener = this.p) != null) {
                File file = this.e;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.e;
                onSharedPreferenceErrorListener.onError(absolutePath, 2, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            this.b.remove(onSharedPreferenceChangeListener);
            if (this.c == null || this.b.size() > 0) {
                return;
            }
            this.c.stopWatching();
        }
    }

    public SharedPreferencesNewImpl(File file, int i, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.a = new LinkedHashMap<>();
        this.b = new ArrayList<>();
        this.d = true;
        this.l = new Object();
        this.m = new Object();
        this.o = new Vector<>();
        this.r = new Runnable() { // from class: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int s = SharedPreferencesNewImpl.this.s();
                if (s <= 0 || s == SharedPreferencesNewImpl.this.g) {
                    return;
                }
                SharedPreferencesNewImpl.this.N(false);
            }
        };
        this.s = new RunnableEx() { // from class: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferencesNewImpl.this.N(((Boolean) getArg()).booleanValue());
            }
        };
        this.p = onSharedPreferenceErrorListener;
        HandlerThread handlerThread = new HandlerThread(file.getName());
        this.j = handlerThread;
        handlerThread.start();
        this.k = new Handler(this.j.getLooper());
        this.e = file;
        this.f = file.getAbsolutePath() + ".bak";
        if (x()) {
            P();
        }
        this.k.post(new Runnable() { // from class: com.alibaba.android.newsharedpreferences.SharedPreferencesNewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file2 = new File(SharedPreferencesNewImpl.this.f);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SharedPreferencesNewImpl sharedPreferencesNewImpl = SharedPreferencesNewImpl.this;
                SharedPreferencesNewImpl sharedPreferencesNewImpl2 = SharedPreferencesNewImpl.this;
                sharedPreferencesNewImpl.c = new FileObserverC3235e(sharedPreferencesNewImpl2.f, 2);
                if (SharedPreferencesNewImpl.this.b.size() > 0) {
                    SharedPreferencesNewImpl.this.c.startWatching();
                }
            }
        });
    }
}
