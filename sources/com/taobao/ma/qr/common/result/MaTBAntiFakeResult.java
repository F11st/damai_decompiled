package com.taobao.ma.qr.common.result;

import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaType;
import com.taobao.ma.util.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaTBAntiFakeResult extends MaResult {
    private String hiddenData;

    public MaTBAntiFakeResult(MaType maType, String str) {
        super(maType, str);
    }

    public boolean exist() {
        return !StringUtils.isEmpty(this.hiddenData);
    }

    public String getHiddenData() {
        return this.hiddenData;
    }

    public MaTBAntiFakeResult(MaType maType, String str, String str2) {
        this(maType, str);
        this.hiddenData = str2;
    }
}
