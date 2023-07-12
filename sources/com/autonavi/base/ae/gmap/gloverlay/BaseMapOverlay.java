package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID;
    protected T mGLOverlay;
    protected Vector<E> mItemList;
    protected int mLastFocusedIndex;
    protected IAMapDelegate mMapView;

    public BaseMapOverlay(int i, Context context, IAMap iAMap) {
        this.mItemList = null;
        this.mEngineID = 1;
        this.mEngineID = i;
        this.mContext = context;
        try {
            this.mMapView = (IAMapDelegate) iAMap;
        } catch (Throwable unused) {
        }
        this.mItemList = new Vector<>();
        iniGLOverlay();
    }

    public abstract void addItem(E e);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            T t = this.mGLOverlay;
            if (t != null) {
                t.removeAll();
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public final E getItem(int i) {
        try {
            synchronized (this.mItemList) {
                if (i >= 0 && i <= this.mItemList.size() - 1) {
                    return this.mItemList.get(i);
                }
                return null;
            }
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    protected abstract void iniGLOverlay();

    public boolean isClickable() {
        T t = this.mGLOverlay;
        if (t != null) {
            return t.isClickable();
        }
        return false;
    }

    public boolean isVisible() {
        T t = this.mGLOverlay;
        if (t != null) {
            return t.isVisible();
        }
        return false;
    }

    public void releaseInstance() {
        this.mMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay.1
            @Override // java.lang.Runnable
            public void run() {
                if (BaseMapOverlay.this.getGLOverlay() != null) {
                    IAMapDelegate iAMapDelegate = BaseMapOverlay.this.mMapView;
                    if (iAMapDelegate != null && iAMapDelegate.isMaploaded()) {
                        BaseMapOverlay baseMapOverlay = BaseMapOverlay.this;
                        baseMapOverlay.mMapView.removeEngineGLOverlay(baseMapOverlay);
                    }
                    BaseMapOverlay.this.getGLOverlay().releaseInstance();
                    BaseMapOverlay.this.mGLOverlay = null;
                }
            }
        });
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(int i) {
        if (i >= 0) {
            try {
                if (i > this.mItemList.size() - 1) {
                    return;
                }
                if (i == this.mLastFocusedIndex) {
                    this.mLastFocusedIndex = -1;
                    clearFocus();
                }
                this.mItemList.remove(i);
                T t = this.mGLOverlay;
                if (t != null) {
                    t.removeItem(i);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public abstract void resumeMarker(Bitmap bitmap);

    public void setClickable(boolean z) {
        T t = this.mGLOverlay;
        if (t != null) {
            t.setClickable(z);
        }
    }

    public void setVisible(boolean z) {
        T t = this.mGLOverlay;
        if (t != null) {
            t.setVisible(z);
        }
    }

    public void removeItem(E e) {
        if (e == null) {
            return;
        }
        try {
            synchronized (this.mItemList) {
                removeItem(this.mItemList.indexOf(e));
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }
}
