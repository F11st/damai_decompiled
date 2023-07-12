package com.alibaba.security.biometrics.service.model.detector;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MineInfo implements Serializable {
    private static final long serialVersionUID = 1;
    protected int mt;
    protected long t;

    public MineInfo(int i, long j) {
        this.mt = i;
        this.t = j;
    }

    public int getMt() {
        return this.mt;
    }

    public long getT() {
        return this.t;
    }

    public void setMt(int i) {
        this.mt = i;
    }

    public void setT(long j) {
        this.t = j;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS", Locale.getDefault());
        return "Mine [minetype=" + this.mt + "(0:ACTIONBLEND,1:NOTVIDEO,2:TIMEOUT,3:NOTLIVE,4:BADCOLOR,5:BAD3D,-1:UNKNOWN), time=" + simpleDateFormat.format(new Date(this.t)) + jn1.ARRAY_END_STR;
    }
}
