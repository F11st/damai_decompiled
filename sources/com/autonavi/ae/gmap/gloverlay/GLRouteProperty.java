package com.autonavi.ae.gmap.gloverlay;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GLRouteProperty {
    public EAMapRouteTexture euRouteTexture;
    public boolean isCanCovered;
    public boolean isLineExtract;
    public boolean isUseCap;
    public boolean isUseColor;
    public int mBgColor;
    public int mBgResId;
    public int mBorderLineWidth;
    public float mCapX1;
    public float mCapX2;
    public float mCapY1;
    public float mCapY2;
    public int mFilledColor;
    public int mFilledResId;
    public float mGLStart;
    public int mLineWidth;
    public float mSimple3DGLStart;
    public float mSimple3DTextureLen;
    public float mSimple3DX1;
    public float mSimple3DX2;
    public float mSimple3DY1;
    public float mSimple3DY2;
    public float mTextureLen;
    public float mX1;
    public float mX2;
    public float mY1;
    public float mY2;
    public int mSimple3DFillResId = -1;
    public boolean mShowArrow = false;
    public boolean mbTexPreMulAlpha = false;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum EAMapRouteTexture {
        AMAP_ROUTE_TEXTURE_NONAVI,
        AMAP_ROUTE_TEXTURE_NAVI,
        AMAP_ROUTE_TEXTURE_DEFAULT,
        AMAP_ROUTE_TEXTURE_OPEN,
        AMAP_ROUTE_TEXTURE_AMBLE,
        AMAP_ROUTE_TEXTURE_JAM,
        AMAP_ROUTE_TEXTURE_CONGESTED,
        AMAP_ROUTE_TEXTURE_ARROW,
        AMAP_ROUTE_TEXTURE_CHARGE,
        AMAP_ROUTE_TEXTURE_FREE,
        AMAP_ROUTE_TEXTURE_LIMIT,
        AMAP_ROUTE_TEXTURE_SLOWER,
        AMAP_ROUTE_TEXTURE_FASTER,
        AMAP_ROUTE_TEXTURE_WRONG,
        AMAP_ROUTE_TEXTURE_FERRY,
        AMAP_ROUTE_TEXTURE_NUMBER
    }
}
