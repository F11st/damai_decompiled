package com.taobao.ma.encode.InputParameters;

import android.graphics.Bitmap;
import com.taobao.ma.common.log.MaLogger;
import com.taobao.ma.encode.ImageHelper;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogoBWInputParameters extends MaEncodeInputParameters {
    public int logoChannel;
    public byte[] logoData;
    public int logoHeight;
    public int logoSize;
    private int logoStep;
    public int logoWidth;
    public int logoX;
    public int logoY;
    public int margin;

    public LogoBWInputParameters(String str, Bitmap bitmap, int i, int i2, char c) {
        this.errorCorrectionLevel = c;
        this.rotation = 0;
        this.qrSize = i2;
        this.version = 4;
        this.type = 4;
        this.margin = i;
        initializeLogoPictureParameters(bitmap);
        this.publicData = str;
    }

    public void initializeLogoPictureParameters(Bitmap bitmap) {
        MaLogger.v("Gen3.initializeGen3InputBackgroundPictureParameters");
        try {
            int i = bitmap.hasAlpha() ? 4 : 3;
            this.logoData = ImageHelper.getPixelDataRGB(bitmap, bitmap.getWidth(), bitmap.getHeight(), i);
            MaLogger.v("length = " + this.logoData.length);
            this.logoChannel = 3;
            this.logoWidth = bitmap.getWidth();
            this.logoHeight = bitmap.getHeight();
            this.logoStep = bitmap.getWidth() * i;
        } catch (Exception e) {
            MaLogger.v(e.toString());
        }
    }

    @Override // com.taobao.ma.encode.InputParameters.MaEncodeInputParameters
    public boolean isLegal() {
        return true;
    }

    public LogoBWInputParameters(String str, Bitmap bitmap, int i, int i2, char c, int i3) {
        this.errorCorrectionLevel = c;
        this.rotation = 0;
        this.qrSize = i2;
        this.version = i3;
        this.type = 4;
        this.margin = i;
        initializeLogoPictureParameters(bitmap);
        this.publicData = str;
    }
}
