package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>> {
    private int mEngineID;
    private long mNativeInstance;
    private final List<E> mOverlayList = new ArrayList();
    private SparseArray<GLOverlayTexture> mTextureCaches = new SparseArray<>();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class GLAmapFocusHits {
        public long mOverlayHashCode = 0;
        public long mHitedIndex = 0;
        public long mHitedTimes = 1000;
    }

    public GLOverlayBundle(int i, IAMapDelegate iAMapDelegate) {
        this.mNativeInstance = 0L;
        this.mEngineID = i;
        if (iAMapDelegate != null) {
            try {
                this.mNativeInstance = iAMapDelegate.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);
            } catch (Throwable unused) {
            }
        }
    }

    private int getOverlyExType(E e) {
        return 0;
    }

    public static void intClr2PVRClr(float[] fArr, int i) {
        fArr[2] = (i & 255) / 255.0f;
        fArr[1] = ((i >> 8) & 255) / 255.0f;
        fArr[0] = ((i >> 16) & 255) / 255.0f;
        fArr[3] = ((i >> 24) & 255) / 255.0f;
    }

    private static native void nativeAddGLOverlay(long j, long j2, long j3);

    private static native void nativeAddGLOverlayEx(long j, long j2, long j3, int i);

    private static native void nativeClearAllGLOverlay(long j, boolean z);

    private static native boolean nativeOnSingleTapLineOverlay(long j, int i, int i2, long[] jArr);

    private static native boolean nativeOnSingleTapPointOverlay(long j, int i, int i2, long[] jArr);

    private static native void nativeRemoveGLOverlay(long j, long j2);

    private static native void nativeRemoveGLOverlayEx(long j, long j2, int i);

    private static native void nativeSortAllGLOverlay(long j);

    public void addOverlay(E e) {
        if (e == null) {
            return;
        }
        nativeAddGLOverlay(this.mNativeInstance, e.getGLOverlay().getNativeInstatnce(), e.getGLOverlay().getCode());
        e.getGLOverlay().mIsInBundle = true;
        synchronized (this.mOverlayList) {
            this.mOverlayList.add(e);
        }
    }

    public boolean addOverlayTextureItem(int i, int i2, int i3, int i4) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i, i2, i3, i4);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i, gLOverlayTexture);
        }
        return true;
    }

    public long checkSingleTapOnLine(int i, int i2) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapLineOverlay(this.mNativeInstance, i, i2, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public long checkSingleTapOnPoint(int i, int i2) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapPointOverlay(this.mNativeInstance, i, i2, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public void clearFocus() {
        List<E> list = this.mOverlayList;
        if (list != null) {
            synchronized (list) {
                for (int i = 0; i < this.mOverlayList.size(); i++) {
                    E e = this.mOverlayList.get(i);
                    if (e != null) {
                        e.clearFocus();
                    }
                }
            }
        }
    }

    public void clearOverlayTexture() {
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.clear();
        }
    }

    public boolean cotainsOverlay(E e) {
        boolean contains;
        if (e == null) {
            return false;
        }
        synchronized (this.mOverlayList) {
            contains = this.mOverlayList.contains(e);
        }
        return contains;
    }

    public E getOverlay(int i) {
        synchronized (this.mOverlayList) {
            if (i >= 0) {
                if (i <= this.mOverlayList.size() - 1) {
                    return this.mOverlayList.get(i);
                }
            }
            return null;
        }
    }

    public int getOverlayCount() {
        int size;
        synchronized (this.mOverlayList) {
            size = this.mOverlayList.size();
        }
        return size;
    }

    public GLOverlayTexture getOverlayTextureItem(int i) {
        GLOverlayTexture gLOverlayTexture;
        synchronized (this.mTextureCaches) {
            gLOverlayTexture = this.mTextureCaches.get(i);
        }
        return gLOverlayTexture;
    }

    public boolean onSingleTap(int i, int i2, int i3, int i4) {
        boolean onSingleTapPoints = (i4 & 1) == 1 ? onSingleTapPoints(i, i2, i3) : false;
        if (onSingleTapPoints) {
            return true;
        }
        if ((i4 & 2) == 2) {
            onSingleTapPoints = onSingleTapLines(i, i2, i3);
        }
        return onSingleTapPoints;
    }

    boolean onSingleTapLines(int i, int i2, int i3) {
        return false;
    }

    boolean onSingleTapPoints(int i, int i2, int i3) {
        return false;
    }

    public void reculateRouteBoard(IAMapDelegate iAMapDelegate) {
    }

    public void removeAll(boolean z) {
        nativeClearAllGLOverlay(this.mNativeInstance, z);
        synchronized (this.mOverlayList) {
            for (int i = 0; i < this.mOverlayList.size(); i++) {
                E e = this.mOverlayList.get(i);
                if (e != null) {
                    e.getGLOverlay().mIsInBundle = false;
                    e.getGLOverlay().releaseInstance();
                }
            }
            this.mOverlayList.clear();
        }
    }

    public void removeOverlay(E e) {
        if (e == null) {
            return;
        }
        nativeRemoveGLOverlay(this.mNativeInstance, e.getGLOverlay().getNativeInstatnce());
        e.getGLOverlay().mIsInBundle = false;
        synchronized (this.mOverlayList) {
            this.mOverlayList.remove(e);
        }
    }

    public void sortOverlay() {
        nativeSortAllGLOverlay(this.mNativeInstance);
    }

    public boolean addOverlayTextureItem(int i, int i2, float f, float f2, int i3, int i4) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i, i2, f, f2, i3, i4);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i, gLOverlayTexture);
        }
        return true;
    }
}
