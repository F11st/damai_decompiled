package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.amap.api.mapcore.util.C4646y;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CrossVectorOverlay extends BaseMapOverlay<GLCrossVector, Object> implements C4646y.InterfaceC4647a, ICrossVectorOverlay {
    AVectorCrossAttr attr;
    private CrossOverlay.GenerateCrossImageListener imageListener;
    private boolean isImageMode;
    private C4646y pluginTexture;

    public CrossVectorOverlay(int i, Context context, IAMap iAMap) {
        super(i, context, iAMap);
        this.isImageMode = false;
        this.attr = null;
    }

    private void drawVectorFailed(int i) {
        C4646y c4646y = this.pluginTexture;
        if (c4646y != null) {
            c4646y.b();
        }
        CrossOverlay.GenerateCrossImageListener generateCrossImageListener = this.imageListener;
        if (generateCrossImageListener != null) {
            generateCrossImageListener.onGenerateComplete(null, i);
        }
    }

    private void initImageMode(int i, int i2) {
        if (this.pluginTexture == null) {
            C4646y c4646y = new C4646y(this.mMapView);
            this.pluginTexture = c4646y;
            c4646y.a(this.imageListener);
            this.pluginTexture.a(this);
            this.pluginTexture.b(Rect.width(this.attr.stAreaRect), Rect.height(this.attr.stAreaRect));
        }
        T t = this.mGLOverlay;
        if (t != 0) {
            ((GLCrossVector) t).initFBOTexture(i, i2);
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void addItem(Object obj) {
    }

    public void addOverlayTexture(Bitmap bitmap, int i, int i2) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i;
        gLTextureProperty.mAnchor = i2;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        this.mMapView.addOverlayTexture(this.mEngineID, gLTextureProperty);
    }

    public int dipToPixel(Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.amap.api.mapcore.util.C4646y.InterfaceC4647a
    public int getTextureID() {
        return ((GLCrossVector) this.mGLOverlay).getFBOTextureId();
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    protected void iniGLOverlay() {
        this.mGLOverlay = new GLCrossVector(this.mEngineID, this.mMapView, hashCode());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void remove() {
        C4646y c4646y = this.pluginTexture;
        if (c4646y != null) {
            c4646y.b();
            this.pluginTexture = null;
        }
        this.imageListener = null;
        setVisible(false);
        releaseInstance();
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void resumeMarker(Bitmap bitmap) {
        addOverlayTexture(bitmap, 12345, 4);
        ((GLCrossVector) this.mGLOverlay).setArrowResId(false, 12345);
        ((GLCrossVector) this.mGLOverlay).setCarResId(12345);
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("cross/crossing_nigth_bk.data");
        addOverlayTexture(fromAsset != null ? fromAsset.getBitmap() : null, 54321, 0);
        ((GLCrossVector) this.mGLOverlay).setBackgroundResId(54321);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.attr = aVectorCrossAttr;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public int setData(byte[] bArr) {
        int i;
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        if (this.attr == null) {
            AVectorCrossAttr aVectorCrossAttr = new AVectorCrossAttr();
            this.attr = aVectorCrossAttr;
            aVectorCrossAttr.stAreaRect = new android.graphics.Rect(0, 0, this.mMapView.getMapWidth(), (this.mMapView.getMapHeight() * 4) / 11);
            this.attr.stAreaColor = Color.argb(217, 95, 95, 95);
            this.attr.fArrowBorderWidth = dipToPixel(this.mContext, 22);
            this.attr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
            this.attr.fArrowLineWidth = dipToPixel(this.mContext, 18);
            this.attr.stArrowLineColor = Color.argb(255, 255, 253, 65);
            this.attr.dayMode = false;
        }
        if (bArr == null || this.attr == null) {
            i = -1;
        } else {
            final int mapWidth = this.mMapView.getMapWidth();
            final int mapHeight = this.mMapView.getMapHeight();
            if (this.isImageMode && this.imageListener != null) {
                initImageMode(mapWidth, mapHeight);
            }
            i = ((GLCrossVector) this.mGLOverlay).addVectorItem(this.attr, bArr, bArr.length);
            ((GLCrossVector) this.mGLOverlay).setVisible(true);
            if (this.isImageMode && this.imageListener != null) {
                this.mMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            T t = CrossVectorOverlay.this.mGLOverlay;
                            if (t == 0 || !((GLCrossVector) t).isVisible() || CrossVectorOverlay.this.pluginTexture == null || CrossVectorOverlay.this.pluginTexture.c()) {
                                return;
                            }
                            CrossVectorOverlay.this.pluginTexture.a(mapWidth, mapHeight);
                            CrossVectorOverlay.this.pluginTexture.a();
                        } catch (Throwable th) {
                            hd.c(th, "CrossVectorOverlay", "setData");
                        }
                    }
                });
            }
        }
        if (i == -1) {
            drawVectorFailed(i);
        }
        return i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        this.imageListener = generateCrossImageListener;
        C4646y c4646y = this.pluginTexture;
        if (c4646y != null) {
            c4646y.a(generateCrossImageListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setImageMode(boolean z) {
        this.isImageMode = z;
    }
}
