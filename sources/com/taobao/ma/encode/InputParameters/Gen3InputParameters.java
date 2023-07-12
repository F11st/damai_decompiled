package com.taobao.ma.encode.InputParameters;

import android.graphics.Bitmap;
import android.util.Log;
import com.taobao.ma.common.log.MaLogger;
import com.taobao.ma.encode.ImageHelper;
import com.youku.upsplayer.util.YKUpsConvert;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Gen3InputParameters extends MaEncodeInputParameters {
    public int bgImage_channel;
    public byte[] bgImage_data;
    public int bgImage_height;
    public int bgImage_step;
    public int bgImage_width;
    public char domainIndex;
    public int gen3format;
    public String hiddenData;
    public int margin;
    public int qrX;
    public int qrY;
    public int visual_level;

    public Gen3InputParameters(String str, Bitmap bitmap) {
        this.publicData = str;
        this.type = 3;
        this.visual_level = 2;
        this.qrX = 0;
        this.qrY = 0;
        this.domainIndex = YKUpsConvert.CHAR_ZERO;
        this.qrSize = bitmap.getWidth();
        this.gen3format = 0;
        initializeGen3InputBackgroundPictureParameters(bitmap);
    }

    public void initializeGen3InputBackgroundPictureParameters(Bitmap bitmap) {
        MaLogger.v("Gen3.initializeGen3InputBackgroundPictureParameters");
        try {
            this.bgImage_data = ImageHelper.getPixelDataRGB(bitmap, bitmap.getWidth(), bitmap.getHeight(), bitmap.hasAlpha() ? 4 : 3);
            this.bgImage_channel = 3;
            this.bgImage_width = bitmap.getWidth();
            this.bgImage_height = bitmap.getHeight();
            this.bgImage_step = bitmap.getWidth() * 3;
        } catch (Exception e) {
            MaLogger.v(e.toString());
        }
    }

    @Override // com.taobao.ma.encode.InputParameters.MaEncodeInputParameters
    public boolean isLegal() {
        super.isLegal();
        MaLogger.v("Gen3.isLegal1");
        if (this.bgImage_width > 0 && this.bgImage_height > 0) {
            if (this.visual_level >= 0 && this.qrX >= 0 && this.qrY >= 0) {
                Log.v("masdk209", "Gen3.isLegal4");
                return true;
            }
            MaLogger.v("Gen3.isLegal3");
            this.errorMsg += "ERROR: qrX,qrY,visual_level,domainIndex\n error";
            return false;
        }
        MaLogger.v("Gen3.isLegal2");
        this.errorMsg += "ERROR: background image' width or height or channel is ilegal\n ";
        return false;
    }

    public Gen3InputParameters(String str, Bitmap bitmap, int i, int i2, int i3, int i4, char c, int i5) {
        this.publicData = str;
        this.type = 3;
        this.visual_level = i4;
        this.qrX = i;
        this.qrY = i2;
        this.qrSize = i3;
        this.domainIndex = c;
        this.version = i5;
        this.gen3format = 0;
        initializeGen3InputBackgroundPictureParameters(bitmap);
    }

    public Gen3InputParameters(String str, Bitmap bitmap, int i, char c, int i2, int i3) {
        this.publicData = str;
        this.type = 3;
        this.visual_level = i;
        this.qrX = 0;
        this.qrY = 0;
        this.qrSize = bitmap.getWidth();
        this.domainIndex = c;
        this.version = i2;
        this.gen3format = i3;
        initializeGen3InputBackgroundPictureParameters(bitmap);
    }

    public Gen3InputParameters(String str, Bitmap bitmap, int i, char c, int i2) {
        this.publicData = str;
        this.type = 3;
        this.visual_level = i;
        this.qrX = 0;
        this.qrY = 0;
        this.qrSize = bitmap.getWidth();
        this.domainIndex = c;
        this.version = i2;
        this.gen3format = 0;
        initializeGen3InputBackgroundPictureParameters(bitmap);
    }
}
