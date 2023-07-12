package com.alibaba.security.realidentity.business.base.chain;

import com.alibaba.security.realidentity.business.dynamic.model.ScConfig;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BusinessHeadParams implements Serializable {
    private int ctidCode;
    private String ctidParams;
    private boolean isCtidCalled = false;
    private ScConfig scConfig;

    public int getCtidCode() {
        return this.ctidCode;
    }

    public String getCtidParams() {
        return this.ctidParams;
    }

    public ScConfig getScConfig() {
        return this.scConfig;
    }

    public boolean isCtidCalled() {
        return this.isCtidCalled;
    }

    public void setCtidCalled(boolean z) {
        this.isCtidCalled = z;
    }

    public void setCtidCode(int i) {
        this.ctidCode = i;
    }

    public void setCtidParams(String str) {
        this.ctidParams = str;
    }

    public void setScConfig(ScConfig scConfig) {
        this.scConfig = scConfig;
    }
}
