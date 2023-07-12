package com.taobao.ma.encode.InputParameters;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Gen0InputParameters extends MaEncodeInputParameters {
    private static final int MAX_MARGIN = 20;
    public String hiddenData;
    public int margin;

    public Gen0InputParameters(int i, int i2, String str, int i3) {
        this.type = 0;
        this.publicData = str;
        this.qrSize = i;
        this.margin = i2;
        this.version = i3;
    }

    private int calcMargin(int i, int i2) {
        int i3 = (i * 4) + 17;
        int i4 = i2 / i3;
        if (i2 % i3 == 0) {
            return 0;
        }
        for (int i5 = 0; i5 <= 20; i5++) {
            if (i2 % ((i5 * 2) + i3) == 0) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.taobao.ma.encode.InputParameters.MaEncodeInputParameters
    public boolean isLegal() {
        super.isLegal();
        return true;
    }

    public Gen0InputParameters(int i, String str) {
        this.type = 0;
        this.publicData = str;
        this.qrSize = i;
        this.margin = 0;
    }

    public Gen0InputParameters(int i, String str, String str2) {
        this.type = 0;
        this.hiddenData = str2;
        this.publicData = str;
        this.qrSize = i;
        this.margin = 0;
    }
}
