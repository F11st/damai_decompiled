package androidx.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import androidx.renderscript.Element;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RenderScript {
    private static final String CACHE_PATH = "com.android.renderscript.cache";
    public static final int CREATE_FLAG_NONE = 0;
    static final boolean DEBUG = false;
    static final boolean LOG_ENABLED = false;
    static final String LOG_TAG = "RenderScript_jni";
    static final int SUPPORT_LIB_API = 23;
    static final int SUPPORT_LIB_VERSION = 2301;
    static String mCachePath;
    static Method registerNativeAllocation;
    static Method registerNativeFree;
    static boolean sInitialized;
    static int sPointerSize;
    static Object sRuntime;
    static boolean sUseGCHooks;
    private static boolean useNative;
    private Context mApplicationContext;
    long mContext;
    long mDev;
    Element mElement_ALLOCATION;
    Element mElement_A_8;
    Element mElement_BOOLEAN;
    Element mElement_CHAR_2;
    Element mElement_CHAR_3;
    Element mElement_CHAR_4;
    Element mElement_DOUBLE_2;
    Element mElement_DOUBLE_3;
    Element mElement_DOUBLE_4;
    Element mElement_ELEMENT;
    Element mElement_F32;
    Element mElement_F64;
    Element mElement_FLOAT_2;
    Element mElement_FLOAT_3;
    Element mElement_FLOAT_4;
    Element mElement_I16;
    Element mElement_I32;
    Element mElement_I64;
    Element mElement_I8;
    Element mElement_INT_2;
    Element mElement_INT_3;
    Element mElement_INT_4;
    Element mElement_LONG_2;
    Element mElement_LONG_3;
    Element mElement_LONG_4;
    Element mElement_MATRIX_2X2;
    Element mElement_MATRIX_3X3;
    Element mElement_MATRIX_4X4;
    Element mElement_RGBA_4444;
    Element mElement_RGBA_5551;
    Element mElement_RGBA_8888;
    Element mElement_RGB_565;
    Element mElement_RGB_888;
    Element mElement_SAMPLER;
    Element mElement_SCRIPT;
    Element mElement_SHORT_2;
    Element mElement_SHORT_3;
    Element mElement_SHORT_4;
    Element mElement_TYPE;
    Element mElement_U16;
    Element mElement_U32;
    Element mElement_U64;
    Element mElement_U8;
    Element mElement_UCHAR_2;
    Element mElement_UCHAR_3;
    Element mElement_UCHAR_4;
    Element mElement_UINT_2;
    Element mElement_UINT_3;
    Element mElement_UINT_4;
    Element mElement_ULONG_2;
    Element mElement_ULONG_3;
    Element mElement_ULONG_4;
    Element mElement_USHORT_2;
    Element mElement_USHORT_3;
    Element mElement_USHORT_4;
    long mIncCon;
    long mIncDev;
    boolean mIncLoaded;
    MessageThread mMessageThread;
    private String mNativeLibDir;
    ReentrantReadWriteLock mRWLock;
    Sampler mSampler_CLAMP_LINEAR;
    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    Sampler mSampler_CLAMP_NEAREST;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_NEAREST;
    Sampler mSampler_WRAP_LINEAR;
    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    Sampler mSampler_WRAP_NEAREST;
    private static ArrayList<RenderScript> mProcessContextList = new ArrayList<>();
    private static String mBlackList = "";
    static Object lock = new Object();
    private static int sNative = -1;
    private static int sSdkVersion = -1;
    private static boolean useIOlib = false;
    private boolean mIsProcessContext = false;
    private int mContextFlags = 0;
    private int mContextSdkVersion = 0;
    RSMessageHandler mMessageCallback = null;
    RSErrorHandler mErrorCallback = null;
    ContextType mContextType = ContextType.NORMAL;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);
        
        int mID;

        ContextType(int i) {
            this.mID = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class MessageThread extends Thread {
        static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        int[] mAuxData;
        RenderScript mRS;
        boolean mRun;

        MessageThread(RenderScript renderScript) {
            super("RSMessageThread");
            this.mRun = true;
            this.mAuxData = new int[2];
            this.mRS = renderScript;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int[] iArr = new int[16];
            RenderScript renderScript = this.mRS;
            renderScript.nContextInitToClient(renderScript.mContext);
            while (this.mRun) {
                iArr[0] = 0;
                RenderScript renderScript2 = this.mRS;
                int nContextPeekMessage = renderScript2.nContextPeekMessage(renderScript2.mContext, this.mAuxData);
                int[] iArr2 = this.mAuxData;
                int i = iArr2[1];
                int i2 = iArr2[0];
                if (nContextPeekMessage == 4) {
                    if ((i >> 2) >= iArr.length) {
                        iArr = new int[(i + 3) >> 2];
                    }
                    RenderScript renderScript3 = this.mRS;
                    if (renderScript3.nContextGetUserMessage(renderScript3.mContext, iArr) == 4) {
                        RSMessageHandler rSMessageHandler = this.mRS.mMessageCallback;
                        if (rSMessageHandler != null) {
                            rSMessageHandler.mData = iArr;
                            rSMessageHandler.mID = i2;
                            rSMessageHandler.mLength = i;
                            rSMessageHandler.run();
                        } else {
                            throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                        }
                    } else {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    }
                } else if (nContextPeekMessage == 3) {
                    RenderScript renderScript4 = this.mRS;
                    String nContextGetErrorMessage = renderScript4.nContextGetErrorMessage(renderScript4.mContext);
                    if (i2 < 4096) {
                        RSErrorHandler rSErrorHandler = this.mRS.mErrorCallback;
                        if (rSErrorHandler != null) {
                            rSErrorHandler.mErrorMessage = nContextGetErrorMessage;
                            rSErrorHandler.mErrorNum = i2;
                            rSErrorHandler.run();
                        } else {
                            Log.e(RenderScript.LOG_TAG, "non fatal RS error, " + nContextGetErrorMessage);
                        }
                    } else {
                        throw new RSRuntimeException("Fatal error " + i2 + ", details: " + nContextGetErrorMessage);
                    }
                } else {
                    try {
                        Thread.sleep(1L, 0);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum Priority {
        LOW(15),
        NORMAL(-4);
        
        int mID;

        Priority(int i) {
            this.mID = i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class RSErrorHandler implements Runnable {
        protected String mErrorMessage;
        protected int mErrorNum;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class RSMessageHandler implements Runnable {
        protected int[] mData;
        protected int mID;
        protected int mLength;

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    RenderScript(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.mApplicationContext = applicationContext;
            if (Build.VERSION.SDK_INT > 8) {
                this.mNativeLibDir = applicationContext.getApplicationInfo().nativeLibraryDir;
            }
        }
        this.mIncDev = 0L;
        this.mIncCon = 0L;
        this.mIncLoaded = false;
        this.mRWLock = new ReentrantReadWriteLock();
    }

    public static RenderScript create(Context context) {
        return create(context, ContextType.NORMAL);
    }

    public static RenderScript createMultiContext(Context context, ContextType contextType, int i, int i2) {
        return internalCreate(context, i2, contextType, i);
    }

    public static void forceCompat() {
        sNative = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.renderscript.RenderScript internalCreate(android.content.Context r10, int r11, androidx.renderscript.RenderScript.ContextType r12, int r13) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.renderscript.RenderScript.internalCreate(android.content.Context, int, androidx.renderscript.RenderScript$ContextType, int):androidx.renderscript.RenderScript");
    }

    public static void releaseAllContexts() {
        ArrayList<RenderScript> arrayList;
        synchronized (mProcessContextList) {
            arrayList = mProcessContextList;
            mProcessContextList = new ArrayList<>();
        }
        Iterator<RenderScript> it = arrayList.iterator();
        while (it.hasNext()) {
            RenderScript next = it.next();
            next.mIsProcessContext = false;
            next.destroy();
        }
        arrayList.clear();
    }

    static native int rsnSystemGetPointerSize();

    public static void setBlackList(String str) {
        if (str != null) {
            mBlackList = str;
        }
    }

    public static void setupDiskCache(File file) {
        File file2 = new File(file, CACHE_PATH);
        mCachePath = file2.getAbsolutePath();
        file2.mkdirs();
    }

    private static boolean setupNative(int i, Context context) {
        int i2;
        ApplicationInfo applicationInfo;
        long j;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < i && i3 < 21) {
            sNative = 0;
        }
        if (sNative == -1) {
            try {
                i2 = ((Integer) Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(null, "debug.rs.forcecompat", new Integer(0))).intValue();
            } catch (Exception unused) {
                i2 = 0;
            }
            if (Build.VERSION.SDK_INT >= 19 && i2 == 0) {
                sNative = 1;
            } else {
                sNative = 0;
            }
            if (sNative == 1) {
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (PackageManager.NameNotFoundException unused2) {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    try {
                        Class<?> cls = Class.forName("android.renderscript.RenderScript");
                        if (Build.VERSION.SDK_INT <= 22) {
                            j = ((Long) cls.getDeclaredMethod("getMinorID", new Class[0]).invoke(null, new Object[0])).longValue();
                        } else {
                            j = ((Long) cls.getDeclaredMethod("getMinorVersion", new Class[0]).invoke(null, new Object[0])).longValue();
                        }
                    } catch (Exception unused3) {
                        j = 0;
                    }
                    Bundle bundle = applicationInfo.metaData;
                    if (bundle != null) {
                        if (bundle.getBoolean("com.android.support.v8.renderscript.EnableAsyncTeardown") && j == 0) {
                            sNative = 0;
                        }
                        if (applicationInfo.metaData.getBoolean("com.android.support.v8.renderscript.EnableBlurWorkaround") && Build.VERSION.SDK_INT <= 19) {
                            sNative = 0;
                        }
                    }
                }
            }
        }
        if (sNative == 1) {
            if (mBlackList.length() > 0) {
                if (mBlackList.contains('(' + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER() + jn1.CONDITION_IF_MIDDLE + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT() + jn1.CONDITION_IF_MIDDLE + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL() + ')')) {
                    sNative = 0;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void destroy() {
        if (this.mIsProcessContext) {
            return;
        }
        validate();
        nContextFinish();
        if (this.mIncCon != 0) {
            nIncContextFinish();
            nIncContextDestroy();
            this.mIncCon = 0L;
        }
        nContextDeinitToClient(this.mContext);
        MessageThread messageThread = this.mMessageThread;
        messageThread.mRun = false;
        try {
            messageThread.join();
        } catch (InterruptedException unused) {
        }
        nContextDestroy();
        nDeviceDestroy(this.mDev);
        long j = this.mIncDev;
        if (j != 0) {
            nIncDeviceDestroy(j);
            this.mIncDev = 0L;
        }
        this.mDev = 0L;
    }

    public void finish() {
        nContextFinish();
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public RSErrorHandler getErrorHandler() {
        return this.mErrorCallback;
    }

    public RSMessageHandler getMessageHandler() {
        return this.mMessageCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAlive() {
        return this.mContext != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isUseNative() {
        return useNative;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationCopyFromBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyFromBitmap(this.mContext, j, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationCopyToBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyToBitmap(this.mContext, j, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nAllocationCreateBitmapBackedAllocation(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCreateBitmapBackedAllocation(this.mContext, j, i, bitmap, i2);
    }

    synchronized long nAllocationCreateBitmapRef(long j, Bitmap bitmap) {
        validate();
        return rsnAllocationCreateBitmapRef(this.mContext, j, bitmap);
    }

    synchronized long nAllocationCreateFromAssetStream(int i, int i2, int i3) {
        validate();
        return rsnAllocationCreateFromAssetStream(this.mContext, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nAllocationCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCreateFromBitmap(this.mContext, j, i, bitmap, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nAllocationCreateTyped(long j, int i, int i2, long j2) {
        validate();
        return rsnAllocationCreateTyped(this.mContext, j, i, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nAllocationCubeCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCubeCreateFromBitmap(this.mContext, j, i, bitmap, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData1D(long j, int i, int i2, int i3, Object obj, int i4, Element.DataType dataType, int i5, boolean z) {
        validate();
        rsnAllocationData1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID, i5, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, j2, i7, i8, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, int i9, int i10, int i11) {
        validate();
        rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, j2, i8, i9, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationElementData1D(long j, int i, int i2, int i3, byte[] bArr, int i4) {
        validate();
        rsnAllocationElementData1D(this.mContext, j, i, i2, i3, bArr, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationGenerateMipmaps(long j) {
        validate();
        rsnAllocationGenerateMipmaps(this.mContext, j);
    }

    synchronized long nAllocationGetType(long j) {
        validate();
        return rsnAllocationGetType(this.mContext, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationIoReceive(long j) {
        validate();
        rsnAllocationIoReceive(this.mContext, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationIoSend(long j) {
        validate();
        rsnAllocationIoSend(this.mContext, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationRead(long j, Object obj, Element.DataType dataType, int i, boolean z) {
        validate();
        rsnAllocationRead(this.mContext, j, obj, dataType.mID, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationRead1D(long j, int i, int i2, int i3, Object obj, int i4, Element.DataType dataType, int i5, boolean z) {
        validate();
        rsnAllocationRead1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID, i5, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationRead2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, Element.DataType dataType, int i8, boolean z) {
        validate();
        rsnAllocationRead2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID, i8, z);
    }

    synchronized void nAllocationResize1D(long j, int i) {
        validate();
        rsnAllocationResize1D(this.mContext, j, i);
    }

    synchronized void nAllocationResize2D(long j, int i, int i2) {
        validate();
        rsnAllocationResize2D(this.mContext, j, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationSetSurface(long j, Surface surface) {
        validate();
        rsnAllocationSetSurface(this.mContext, j, surface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationSyncAll(long j, int i) {
        validate();
        rsnAllocationSyncAll(this.mContext, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nClosureCreate(long j, long j2, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4) {
        long rsnClosureCreate;
        validate();
        rsnClosureCreate = rsnClosureCreate(this.mContext, j, j2, jArr, jArr2, iArr, jArr3, jArr4);
        if (rsnClosureCreate == 0) {
            throw new RSRuntimeException("Failed creating closure.");
        }
        return rsnClosureCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nClosureSetArg(long j, int i, long j2, int i2) {
        validate();
        rsnClosureSetArg(this.mContext, j, i, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nClosureSetGlobal(long j, long j2, long j3, int i) {
        validate();
        rsnClosureSetGlobal(this.mContext, j, j2, j3, i);
    }

    synchronized long nContextCreate(long j, int i, int i2, int i3, String str) {
        return rsnContextCreate(j, i, i2, i3, str);
    }

    native void nContextDeinitToClient(long j);

    synchronized void nContextDestroy() {
        validate();
        ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mContext;
        this.mContext = 0L;
        writeLock.unlock();
        rsnContextDestroy(j);
    }

    synchronized void nContextDump(int i) {
        validate();
        rsnContextDump(this.mContext, i);
    }

    synchronized void nContextFinish() {
        validate();
        rsnContextFinish(this.mContext);
    }

    native String nContextGetErrorMessage(long j);

    native int nContextGetUserMessage(long j, int[] iArr);

    native void nContextInitToClient(long j);

    native int nContextPeekMessage(long j, int[] iArr);

    synchronized void nContextSendMessage(int i, int[] iArr) {
        validate();
        rsnContextSendMessage(this.mContext, i, iArr);
    }

    synchronized void nContextSetPriority(int i) {
        validate();
        rsnContextSetPriority(this.mContext, i);
    }

    native long nDeviceCreate();

    native void nDeviceDestroy(long j);

    native void nDeviceSetConfig(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nElementCreate(long j, int i, boolean z, int i2) {
        validate();
        return rsnElementCreate(this.mContext, j, i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nElementCreate2(long[] jArr, String[] strArr, int[] iArr) {
        validate();
        return rsnElementCreate2(this.mContext, jArr, strArr, iArr);
    }

    synchronized void nElementGetNativeData(long j, int[] iArr) {
        validate();
        rsnElementGetNativeData(this.mContext, j, iArr);
    }

    synchronized void nElementGetSubElements(long j, long[] jArr, String[] strArr, int[] iArr) {
        validate();
        rsnElementGetSubElements(this.mContext, j, jArr, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nIncAllocationCreateTyped(long j, long j2) {
        validate();
        return rsnIncAllocationCreateTyped(this.mContext, this.mIncCon, j, j2);
    }

    synchronized long nIncContextCreate(long j, int i, int i2, int i3) {
        return rsnIncContextCreate(j, i, i2, i3);
    }

    synchronized void nIncContextDestroy() {
        validate();
        ReentrantReadWriteLock.WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mIncCon;
        this.mIncCon = 0L;
        writeLock.unlock();
        rsnIncContextDestroy(j);
    }

    synchronized void nIncContextFinish() {
        validate();
        rsnIncContextFinish(this.mIncCon);
    }

    native long nIncDeviceCreate();

    native void nIncDeviceDestroy(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nIncElementCreate(long j, int i, boolean z, int i2) {
        validate();
        return rsnIncElementCreate(this.mIncCon, j, i, z, i2);
    }

    native boolean nIncLoadSO(int i, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nIncObjDestroy(long j) {
        long j2 = this.mIncCon;
        if (j2 != 0) {
            rsnIncObjDestroy(j2, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nIncTypeCreate(long j, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        validate();
        return rsnIncTypeCreate(this.mIncCon, j, i, i2, i3, z, z2, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nInvokeClosureCreate(long j, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr) {
        long rsnInvokeClosureCreate;
        validate();
        rsnInvokeClosureCreate = rsnInvokeClosureCreate(this.mContext, j, bArr, jArr, jArr2, iArr);
        if (rsnInvokeClosureCreate == 0) {
            throw new RSRuntimeException("Failed creating closure.");
        }
        return rsnInvokeClosureCreate;
    }

    native boolean nLoadIOSO();

    native boolean nLoadSO(boolean z, int i, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nObjDestroy(long j) {
        long j2 = this.mContext;
        if (j2 != 0) {
            rsnObjDestroy(j2, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nSamplerCreate(int i, int i2, int i3, int i4, int i5, float f) {
        validate();
        return rsnSamplerCreate(this.mContext, i, i2, i3, i4, i5, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptBindAllocation(long j, long j2, int i, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptBindAllocation(j3, j, j2, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nScriptCCreate(String str, String str2, byte[] bArr, int i) {
        validate();
        return rsnScriptCCreate(this.mContext, str, str2, bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nScriptFieldIDCreate(long j, int i, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptFieldIDCreate(j2, j, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptForEach(long j, int i, long j2, long j3, byte[] bArr, boolean z) {
        validate();
        if (bArr == null) {
            rsnScriptForEach(this.mContext, this.mIncCon, j, i, j2, j3, z);
        } else {
            rsnScriptForEach(this.mContext, this.mIncCon, j, i, j2, j3, bArr, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptForEachClipped(long j, int i, long j2, long j3, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        validate();
        if (bArr == null) {
            rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i, j2, j3, i2, i3, i4, i5, i6, i7, z);
        } else {
            rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i, j2, j3, bArr, i2, i3, i4, i5, i6, i7, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nScriptGroup2Create(String str, String str2, long[] jArr) {
        validate();
        return rsnScriptGroup2Create(this.mContext, str, str2, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptGroup2Execute(long j) {
        validate();
        rsnScriptGroup2Execute(this.mContext, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nScriptGroupCreate(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5) {
        validate();
        return rsnScriptGroupCreate(this.mContext, jArr, jArr2, jArr3, jArr4, jArr5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptGroupExecute(long j) {
        validate();
        rsnScriptGroupExecute(this.mContext, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptGroupSetInput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetInput(this.mContext, j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptGroupSetOutput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetOutput(this.mContext, j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_BNNM(long j, int i, int i2, int i3, long j2, int i4, long j3, int i5, long j4, int i6, int i7, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_BNNM(this.mContext, this.mIncCon, j, i, i2, i3, j2, i4, j3, i5, j4, i6, i7, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Complex(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, float f2, long j2, long j3, float f3, float f4, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Complex(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, f, f2, j2, j3, f3, f4, j4, i10, i11, i12, i13, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Double(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, long j2, long j3, double d2, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Double(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, d, j2, j3, d2, j4, i10, i11, i12, i13, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Single(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, long j2, long j3, float f2, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Single(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, f, j2, j3, f2, j4, i10, i11, i12, i13, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptIntrinsicBLAS_Z(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, double d2, long j2, long j3, double d3, double d4, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Z(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, d, d2, j2, j3, d3, d4, j4, i10, i11, i12, i13, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nScriptIntrinsicCreate(int i, long j, boolean z) {
        validate();
        if (z) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (!this.mIncLoaded) {
                    try {
                        System.loadLibrary("RSSupport");
                        if (nIncLoadSO(23, this.mNativeLibDir + "/libRSSupport.so")) {
                            this.mIncLoaded = true;
                        } else {
                            throw new RSRuntimeException("Error loading libRSSupport library for Incremental Intrinsic Support");
                        }
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(LOG_TAG, "Error loading RS Compat library for Incremental Intrinsic Support: " + e);
                        throw new RSRuntimeException("Error loading RS Compat library for Incremental Intrinsic Support: " + e);
                    }
                }
                if (this.mIncDev == 0) {
                    this.mIncDev = nIncDeviceCreate();
                }
                if (this.mIncCon == 0) {
                    this.mIncCon = nIncContextCreate(this.mIncDev, 0, 0, 0);
                }
                return rsnScriptIntrinsicCreate(this.mIncCon, i, j, z);
            }
            Log.e(LOG_TAG, "Incremental Intrinsics are not supported, please change targetSdkVersion to >= 21");
            throw new RSRuntimeException("Incremental Intrinsics are not supported before Lollipop (API 21)");
        }
        return rsnScriptIntrinsicCreate(this.mContext, i, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptInvoke(long j, int i, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvoke(j2, j, i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nScriptInvokeIDCreate(long j, int i) {
        validate();
        return rsnScriptInvokeIDCreate(this.mContext, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptInvokeV(long j, int i, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvokeV(j2, j, i, bArr, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nScriptKernelIDCreate(long j, int i, int i2, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptKernelIDCreate(j2, j, i, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetTimeZone(long j, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetTimeZone(j2, j, bArr, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarD(long j, int i, double d, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarD(j2, j, i, d, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarF(long j, int i, float f, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarF(j2, j, i, f, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarI(long j, int i, int i2, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarI(j2, j, i, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarJ(long j, int i, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarJ(j3, j, i, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarObj(long j, int i, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarObj(j3, j, i, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarV(long j, int i, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarV(j2, j, i, bArr, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nScriptSetVarVE(long j, int i, byte[] bArr, long j2, int[] iArr, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarVE(j3, j, i, bArr, j2, iArr, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long nTypeCreate(long j, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        validate();
        return rsnTypeCreate(this.mContext, j, i, i2, i3, z, z2, i4);
    }

    synchronized void nTypeGetNativeData(long j, long[] jArr) {
        validate();
        rsnTypeGetNativeData(this.mContext, j, jArr);
    }

    native void rsnAllocationCopyFromBitmap(long j, long j2, Bitmap bitmap);

    native void rsnAllocationCopyToBitmap(long j, long j2, Bitmap bitmap);

    native long rsnAllocationCreateBitmapBackedAllocation(long j, long j2, int i, Bitmap bitmap, int i2);

    native long rsnAllocationCreateBitmapRef(long j, long j2, Bitmap bitmap);

    native long rsnAllocationCreateFromAssetStream(long j, int i, int i2, int i3);

    native long rsnAllocationCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    native long rsnAllocationCreateTyped(long j, long j2, int i, int i2, long j3);

    native long rsnAllocationCubeCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    native void rsnAllocationData1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5, int i6, boolean z);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, long j3, int i7, int i8, int i9, int i10);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8, int i9, boolean z);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, Bitmap bitmap);

    native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j3, int i8, int i9, int i10, int i11);

    native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, int i9, int i10, boolean z);

    native void rsnAllocationElementData1D(long j, long j2, int i, int i2, int i3, byte[] bArr, int i4);

    native void rsnAllocationGenerateMipmaps(long j, long j2);

    native long rsnAllocationGetType(long j, long j2);

    native void rsnAllocationIoReceive(long j, long j2);

    native void rsnAllocationIoSend(long j, long j2);

    native void rsnAllocationRead(long j, long j2, Object obj, int i, int i2, boolean z);

    native void rsnAllocationRead1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5, int i6, boolean z);

    native void rsnAllocationRead2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8, int i9, boolean z);

    native void rsnAllocationResize1D(long j, long j2, int i);

    native void rsnAllocationResize2D(long j, long j2, int i, int i2);

    native void rsnAllocationSetSurface(long j, long j2, Surface surface);

    native void rsnAllocationSyncAll(long j, long j2, int i);

    native long rsnClosureCreate(long j, long j2, long j3, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4);

    native void rsnClosureSetArg(long j, long j2, int i, long j3, int i2);

    native void rsnClosureSetGlobal(long j, long j2, long j3, long j4, int i);

    native long rsnContextCreate(long j, int i, int i2, int i3, String str);

    native void rsnContextDestroy(long j);

    native void rsnContextDump(long j, int i);

    native void rsnContextFinish(long j);

    native void rsnContextSendMessage(long j, int i, int[] iArr);

    native void rsnContextSetPriority(long j, int i);

    native long rsnElementCreate(long j, long j2, int i, boolean z, int i2);

    native long rsnElementCreate2(long j, long[] jArr, String[] strArr, int[] iArr);

    native void rsnElementGetNativeData(long j, long j2, int[] iArr);

    native void rsnElementGetSubElements(long j, long j2, long[] jArr, String[] strArr, int[] iArr);

    native long rsnIncAllocationCreateTyped(long j, long j2, long j3, long j4);

    native long rsnIncContextCreate(long j, int i, int i2, int i3);

    native void rsnIncContextDestroy(long j);

    native void rsnIncContextFinish(long j);

    native long rsnIncElementCreate(long j, long j2, int i, boolean z, int i2);

    native void rsnIncObjDestroy(long j, long j2);

    native long rsnIncTypeCreate(long j, long j2, int i, int i2, int i3, boolean z, boolean z2, int i4);

    native long rsnInvokeClosureCreate(long j, long j2, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr);

    native void rsnObjDestroy(long j, long j2);

    native long rsnSamplerCreate(long j, int i, int i2, int i3, int i4, int i5, float f);

    native void rsnScriptBindAllocation(long j, long j2, long j3, int i, boolean z);

    native long rsnScriptCCreate(long j, String str, String str2, byte[] bArr, int i);

    native long rsnScriptFieldIDCreate(long j, long j2, int i, boolean z);

    native void rsnScriptForEach(long j, long j2, long j3, int i, long j4, long j5, boolean z);

    native void rsnScriptForEach(long j, long j2, long j3, int i, long j4, long j5, byte[] bArr, boolean z);

    native void rsnScriptForEachClipped(long j, long j2, long j3, int i, long j4, long j5, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    native void rsnScriptForEachClipped(long j, long j2, long j3, int i, long j4, long j5, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    native long rsnScriptGroup2Create(long j, String str, String str2, long[] jArr);

    native void rsnScriptGroup2Execute(long j, long j2);

    native long rsnScriptGroupCreate(long j, long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5);

    native void rsnScriptGroupExecute(long j, long j2);

    native void rsnScriptGroupSetInput(long j, long j2, long j3, long j4);

    native void rsnScriptGroupSetOutput(long j, long j2, long j3, long j4);

    native void rsnScriptIntrinsicBLAS_BNNM(long j, long j2, long j3, int i, int i2, int i3, long j4, int i4, long j5, int i5, long j6, int i6, int i7, boolean z);

    native void rsnScriptIntrinsicBLAS_Complex(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, float f2, long j4, long j5, float f3, float f4, long j6, int i10, int i11, int i12, int i13, boolean z);

    native void rsnScriptIntrinsicBLAS_Double(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, long j4, long j5, double d2, long j6, int i10, int i11, int i12, int i13, boolean z);

    native void rsnScriptIntrinsicBLAS_Single(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, long j4, long j5, float f2, long j6, int i10, int i11, int i12, int i13, boolean z);

    native void rsnScriptIntrinsicBLAS_Z(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, double d2, long j4, long j5, double d3, double d4, long j6, int i10, int i11, int i12, int i13, boolean z);

    native long rsnScriptIntrinsicCreate(long j, int i, long j2, boolean z);

    native void rsnScriptInvoke(long j, long j2, int i, boolean z);

    native long rsnScriptInvokeIDCreate(long j, long j2, int i);

    native void rsnScriptInvokeV(long j, long j2, int i, byte[] bArr, boolean z);

    native long rsnScriptKernelIDCreate(long j, long j2, int i, int i2, boolean z);

    native void rsnScriptSetTimeZone(long j, long j2, byte[] bArr, boolean z);

    native void rsnScriptSetVarD(long j, long j2, int i, double d, boolean z);

    native void rsnScriptSetVarF(long j, long j2, int i, float f, boolean z);

    native void rsnScriptSetVarI(long j, long j2, int i, int i2, boolean z);

    native void rsnScriptSetVarJ(long j, long j2, int i, long j3, boolean z);

    native void rsnScriptSetVarObj(long j, long j2, int i, long j3, boolean z);

    native void rsnScriptSetVarV(long j, long j2, int i, byte[] bArr, boolean z);

    native void rsnScriptSetVarVE(long j, long j2, int i, byte[] bArr, long j3, int[] iArr, boolean z);

    native long rsnTypeCreate(long j, long j2, int i, int i2, int i3, boolean z, boolean z2, int i4);

    native void rsnTypeGetNativeData(long j, long j2, long[] jArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long safeID(BaseObj baseObj) {
        if (baseObj != null) {
            return baseObj.getID(this);
        }
        return 0L;
    }

    public void sendMessage(int i, int[] iArr) {
        nContextSendMessage(i, iArr);
    }

    public void setErrorHandler(RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
    }

    public void setMessageHandler(RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean usingIO() {
        return useIOlib;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void validate() {
        if (this.mContext == 0) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    public static RenderScript create(Context context, ContextType contextType) {
        return create(context, contextType, 0);
    }

    public static RenderScript create(Context context, ContextType contextType, int i) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, Element.DataType dataType, int i8, boolean z) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID, i8, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, Element.DataType dataType, int i9, boolean z) {
        validate();
        rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, obj, i8, dataType.mID, i9, z);
    }

    public static RenderScript create(Context context, int i) {
        return create(context, i, ContextType.NORMAL, 0);
    }

    public static RenderScript create(Context context, int i, ContextType contextType) {
        return create(context, i, contextType, 0);
    }

    public static RenderScript create(Context context, int i, ContextType contextType, int i2) {
        synchronized (mProcessContextList) {
            Iterator<RenderScript> it = mProcessContextList.iterator();
            while (it.hasNext()) {
                RenderScript next = it.next();
                if (next.mContextType == contextType && next.mContextFlags == i2 && next.mContextSdkVersion == i) {
                    return next;
                }
            }
            RenderScript internalCreate = internalCreate(context, i, contextType, i2);
            internalCreate.mIsProcessContext = true;
            mProcessContextList.add(internalCreate);
            return internalCreate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, Bitmap bitmap) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, bitmap);
    }
}
