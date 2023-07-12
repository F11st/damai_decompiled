package com.alipay.camera2;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.ImageReader;
import android.util.Range;
import com.alipay.camera2.util.Camera2WhiteList;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes12.dex */
public class Camera2Config {
    private static boolean a = false;
    private static boolean b = true;
    public Point downgradePreviewSize;
    public Range<Integer> fpsRange = null;
    public ImageReader jpegImageReader;
    public boolean needDowngradeCameraParams;
    public String objCameraId;
    public Point pictureSize;
    public int previewFormat;
    public Point previewSize;
    public Point screenResolution;
    public ImageReader yuvImageReader;

    public static void setSupportPictureSize(boolean z) {
        a = z;
    }

    public static boolean supportYuvStream() {
        return b;
    }

    public void initImageReader() {
        Point point = this.previewSize;
        this.yuvImageReader = ImageReader.newInstance(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), this.previewFormat, 2);
        Point point2 = this.pictureSize;
        this.jpegImageReader = ImageReader.newInstance(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2), 256, 2);
    }

    public boolean supportPictureSize() {
        boolean z = (a || Camera2WhiteList.forceEnableJpegStream()) && !this.needDowngradeCameraParams;
        MPaasLogger.d("Camera2Config", new Object[]{"supportPictureSize:", Boolean.valueOf(z), ", sSupportPictureSize:", Boolean.valueOf(a), ", needDowngradeCameraParams:", Boolean.valueOf(this.needDowngradeCameraParams)});
        return z;
    }

    public boolean valid() {
        Point point;
        Point point2;
        Point point3;
        Point point4;
        return this.objCameraId != null && (point = this.screenResolution) != null && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) > 0 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) > 0 && (point2 = this.previewSize) != null && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) > 0 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) > 0 && (point3 = this.downgradePreviewSize) != null && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3) > 0 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3) > 0 && this.previewFormat > 0 && this.yuvImageReader != null && (point4 = this.pictureSize) != null && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4) > 0 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4) > 0 && this.jpegImageReader != null;
    }
}
