package com.taobao.android.protodb;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes12.dex */
public class NativeBridgedObject {
    protected static boolean sNativeLibraryLoaded;
    @Keep
    private final long mNativePointer;

    static {
        try {
            System.loadLibrary("ProtoDB");
            sNativeLibraryLoaded = true;
        } catch (Throwable unused) {
            sNativeLibraryLoaded = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NativeBridgedObject(long j) {
        this.mNativePointer = j;
    }

    @Keep
    private native void freeNativeObject();

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (sNativeLibraryLoaded) {
            freeNativeObject();
        }
    }

    public long getNativePointer() {
        return this.mNativePointer;
    }
}
