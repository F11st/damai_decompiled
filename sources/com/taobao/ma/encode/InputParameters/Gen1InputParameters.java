package com.taobao.ma.encode.InputParameters;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Gen1InputParameters extends MaEncodeInputParameters {
    public byte[] background_img;
    public int background_img_channel;
    public int background_img_depth;
    public int background_img_height;
    public int background_img_width;
    public String hiddenData;
    public int margin;
    public int qrX;
    public int qrY;

    public Gen1InputParameters() {
        this.type = 1;
    }

    @Override // com.taobao.ma.encode.InputParameters.MaEncodeInputParameters
    public boolean isLegal() {
        int i;
        super.isLegal();
        if (this.background_img.length > 0 && (i = this.background_img_width) > 0 && i > 0 && this.background_img_channel > 0) {
            int i2 = this.margin;
            if (i2 <= 0) {
                i2 = 0;
            }
            int i3 = this.version;
            if (i3 <= 0) {
                i3 = 0;
            }
            if (this.qrSize % (((i3 * 4) + 17) + (i2 * 2)) != 0) {
                this.errorMsg += "ERROR: width , version , margin should according to the formula:  width % (17 + _version *4 + 2*margin) == 0 \n";
                return false;
            }
            return true;
        }
        this.errorMsg += "ERROR: background image' width or height or channel is ilegal\n ";
        return false;
    }
}
