package com.taobao.android.protodb;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.f0;
import tb.n71;
import tb.r71;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class LSDB extends NativeBridgedObject {
    private static final int SIZE_OF_BOOL = 1;
    private static final int SIZE_OF_DOUBLE = 8;
    private static final int SIZE_OF_FLOAT = 4;
    private static final int SIZE_OF_INT = 4;
    private static final int SIZE_OF_LONG = 8;
    private static final ConcurrentLinkedQueue<LSDB> sLSDBInstances = new ConcurrentLinkedQueue<>();
    private final String path;
    private final String tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LSDB(long j, String str) {
        super(j);
        this.tag = "ProtoDB";
        this.path = str;
    }

    public static void compactAll() {
        java.util.Iterator<LSDB> it = sLSDBInstances.iterator();
        while (it.hasNext()) {
            it.next().forceCompact();
        }
    }

    @Keep
    private native boolean nativeClose();

    @Keep
    private native boolean nativeCompact();

    @Keep
    private native boolean nativeContains(String str);

    @Keep
    private native boolean nativeDelete(String str);

    @Keep
    private native byte[] nativeGetBinary(String str);

    @Keep
    private native boolean nativeGetBinaryToBuffer(String str, byte[] bArr, int i);

    @Keep
    private native int nativeGetDataSize(String str);

    @Keep
    private native boolean nativeInsert(String str, int i, byte[] bArr, int i2);

    @Keep
    private native String[] nativeKeyIterator(String str, String str2);

    @Keep
    private static native long nativeOpen(String str, Config config);

    public static LSDB open(String str, Config config) {
        Application a = f0.a();
        if (a != null) {
            if (!NativeBridgedObject.sNativeLibraryLoaded) {
                return new a(a);
            }
            LSDB openInternal = openInternal(a.getFilesDir() + File.separator + "lsdb-" + str, config);
            return openInternal != null ? openInternal : new a(a);
        }
        throw new RuntimeException("failed to get android context!");
    }

    private static LSDB openInternal(String str, Config config) {
        long nativeOpen = nativeOpen(str, config);
        if (nativeOpen > 0) {
            LSDB lsdb = new LSDB(nativeOpen, str);
            sLSDBInstances.add(lsdb);
            return lsdb;
        }
        return null;
    }

    public boolean close() {
        sLSDBInstances.remove(this);
        return nativeClose();
    }

    public boolean contains(@NonNull n71 n71Var) {
        return nativeContains(n71Var.a());
    }

    public boolean delete(@NonNull n71 n71Var) {
        return nativeDelete(n71Var.a());
    }

    public boolean forceCompact() {
        Log.e("ProtoDB", "begin compacting: " + this.path);
        boolean nativeCompact = nativeCompact();
        Log.e("ProtoDB", "finish compacting: " + this.path);
        return nativeCompact;
    }

    public byte[] getBinary(@NonNull n71 n71Var) {
        return nativeGetBinary(n71Var.a());
    }

    public boolean getBinaryToBuffer(@NonNull n71 n71Var, byte[] bArr) {
        return nativeGetBinaryToBuffer(n71Var.a(), bArr, bArr.length);
    }

    public boolean getBool(@NonNull n71 n71Var) {
        byte[] bArr = new byte[1];
        return nativeGetBinaryToBuffer(n71Var.a(), bArr, 1) && ByteBuffer.wrap(bArr).get() != 0;
    }

    public int getDataSize(@NonNull n71 n71Var) {
        return nativeGetDataSize(n71Var.a());
    }

    public double getDouble(@NonNull n71 n71Var) {
        byte[] bArr = new byte[8];
        if (nativeGetBinaryToBuffer(n71Var.a(), bArr, 8)) {
            return ByteBuffer.wrap(bArr).getDouble();
        }
        return 0.0d;
    }

    public float getFloat(@NonNull n71 n71Var) {
        byte[] bArr = new byte[4];
        if (nativeGetBinaryToBuffer(n71Var.a(), bArr, 4)) {
            return ByteBuffer.wrap(bArr).getFloat();
        }
        return 0.0f;
    }

    public int getInt(@NonNull n71 n71Var) {
        byte[] bArr = new byte[4];
        if (nativeGetBinaryToBuffer(n71Var.a(), bArr, 4)) {
            return ByteBuffer.wrap(bArr).getInt();
        }
        return 0;
    }

    public long getLong(@NonNull n71 n71Var) {
        byte[] bArr = new byte[8];
        if (nativeGetBinaryToBuffer(n71Var.a(), bArr, 8)) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return 0L;
    }

    public String getString(@NonNull n71 n71Var) {
        byte[] nativeGetBinary = nativeGetBinary(n71Var.a());
        if (nativeGetBinary == null || nativeGetBinary.length <= 0) {
            return null;
        }
        return new String(nativeGetBinary, Charset.forName("UTF-8"));
    }

    public boolean insertBinary(@NonNull n71 n71Var, byte[] bArr) {
        return nativeInsert(n71Var.a(), Integer.MAX_VALUE, bArr, bArr != null ? bArr.length : 0);
    }

    public boolean insertBool(@NonNull n71 n71Var, boolean z) {
        return nativeInsert(n71Var.a(), Integer.MAX_VALUE, new byte[]{z ? (byte) 1 : (byte) 0}, 1);
    }

    public boolean insertDouble(@NonNull n71 n71Var, double d) {
        return nativeInsert(n71Var.a(), Integer.MAX_VALUE, ByteBuffer.allocate(8).putDouble(d).array(), 8);
    }

    public boolean insertFloat(@NonNull n71 n71Var, float f) {
        return nativeInsert(n71Var.a(), Integer.MAX_VALUE, ByteBuffer.allocate(4).putFloat(f).array(), 4);
    }

    public boolean insertInt(@NonNull n71 n71Var, int i) {
        return nativeInsert(n71Var.a(), Integer.MAX_VALUE, ByteBuffer.allocate(4).putInt(i).array(), 4);
    }

    public boolean insertLong(@NonNull n71 n71Var, long j) {
        return nativeInsert(n71Var.a(), Integer.MAX_VALUE, ByteBuffer.allocate(8).putLong(j).array(), 8);
    }

    public boolean insertStream(@NonNull n71 n71Var, int i, InputStream inputStream) {
        if (inputStream != null) {
            try {
                int available = inputStream.available();
                byte[] bArr = new byte[available];
                if (inputStream.read(bArr, 0, inputStream.available()) == available) {
                    return insertBinary(n71Var, i, bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean insertString(@NonNull n71 n71Var, @NonNull String str) {
        if (str == null) {
            return nativeInsert(n71Var.a(), Integer.MAX_VALUE, null, 0);
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        return nativeInsert(n71Var.a(), Integer.MAX_VALUE, bytes, bytes.length);
    }

    public Iterator<n71> keyIterator() {
        return new r71(nativeKeyIterator(null, null));
    }

    public boolean insertBinary(@NonNull n71 n71Var, int i, byte[] bArr) {
        return nativeInsert(n71Var.a(), i, bArr, bArr != null ? bArr.length : 0);
    }

    public Iterator<n71> keyIterator(@NonNull n71 n71Var, @NonNull n71 n71Var2) {
        return new r71(nativeKeyIterator(n71Var.a(), n71Var2.a()));
    }

    public static LSDB open(Context context, String str, Config config) {
        if (!NativeBridgedObject.sNativeLibraryLoaded) {
            return new a(context);
        }
        LSDB openInternal = openInternal(context.getFilesDir() + File.separator + "lsdb-" + str, config);
        return openInternal != null ? openInternal : new a(context);
    }
}
