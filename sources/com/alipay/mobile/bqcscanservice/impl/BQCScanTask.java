package com.alipay.mobile.bqcscanservice.impl;

import android.graphics.Point;
import android.hardware.Camera;
import com.alipay.camera2.operation.callback.OnReadImageListener;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class BQCScanTask<T> implements Runnable {
    protected Camera mCamera;
    protected byte[] mData;
    protected int mPreviewFormat;
    protected Point mPreviewPoint;
    protected Camera.Size mPreviewSize;
    protected OnReadImageListener.ScanImagePlanes[] planes;
    protected int strideWidth;

    protected void onPostExecute(T t) {
        this.mData = null;
        this.mCamera = null;
    }

    protected void onPreExecute() {
    }

    public void setData(byte[] bArr, Camera camera, Camera.Size size, int i) {
        this.mData = bArr;
        this.mCamera = camera;
        this.mPreviewSize = size;
        this.mPreviewFormat = i;
    }

    public void setData(byte[] bArr, Point point, int i, int i2) {
        this.strideWidth = i;
        this.mData = bArr;
        this.mPreviewPoint = point;
        this.mPreviewFormat = i2;
    }

    public void setData(OnReadImageListener.ScanImagePlanes[] scanImagePlanesArr, Point point, int i) {
        this.planes = scanImagePlanesArr;
        this.mPreviewPoint = point;
        this.mPreviewFormat = i;
    }
}
