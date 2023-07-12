package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
enum LittleEndianByteArray$UnsafeByteArray implements LittleEndianByteArray$LittleEndianBytes {
    UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.1
        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public long getLongLittleEndian(byte[] bArr, int i) {
            return LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
        }

        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public void putLongLittleEndian(byte[] bArr, int i, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j);
        }
    },
    UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.2
        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public long getLongLittleEndian(byte[] bArr, int i) {
            return Long.reverseBytes(LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
        }

        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public void putLongLittleEndian(byte[] bArr, int i, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j));
        }
    };
    
    private static final int BYTE_ARRAY_BASE_OFFSET;
    private static final Unsafe theUnsafe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$a */
    /* loaded from: classes10.dex */
    public static class C5218a implements PrivilegedExceptionAction<Unsafe> {
        C5218a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        Unsafe unsafe = getUnsafe();
        theUnsafe = unsafe;
        BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        if (unsafe.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
        }
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new C5218a());
            }
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
    }
}
