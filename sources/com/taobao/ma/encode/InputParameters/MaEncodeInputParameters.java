package com.taobao.ma.encode.InputParameters;

import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaEncodeInputParameters {
    public int qrSize;
    public int rotation;
    public int version;
    public int type = 0;
    public String publicData = null;
    public String errorMsg = "";
    public char errorCorrectionLevel = qb1.LEVEL_L;

    public MaEncodeInputParameters() {
        this.qrSize = 0;
        this.version = 0;
        this.rotation = 0;
        this.rotation = 0;
        this.qrSize = 0;
        this.version = 4;
    }

    public boolean isLegal() {
        if (this.qrSize <= 0) {
            this.errorMsg += "ERROR: qrSize <=0 ";
            return false;
        } else if (this.publicData == null) {
            this.errorMsg += "ERROR: publicData cant be null \n";
            return false;
        } else {
            return true;
        }
    }
}
