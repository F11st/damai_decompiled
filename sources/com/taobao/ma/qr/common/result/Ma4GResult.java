package com.taobao.ma.qr.common.result;

import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaType;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Ma4GResult extends MaResult {
    private String signature;

    public Ma4GResult(MaType maType, String str) {
        super(maType, str);
    }

    public String getSignature() {
        return this.signature;
    }

    public Ma4GResult(MaType maType, String str, String str2) {
        this(maType, str);
        this.signature = str2;
    }
}
