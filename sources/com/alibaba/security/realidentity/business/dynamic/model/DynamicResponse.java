package com.alibaba.security.realidentity.business.dynamic.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DynamicResponse implements Serializable {
    private PureWirelessConf BASIC;
    private BcConfig BC;
    private CtidConfig CTID;
    private String H5_DOMAIN;
    private ScConfig SC;

    public PureWirelessConf getBASIC() {
        return this.BASIC;
    }

    public BcConfig getBC() {
        return this.BC;
    }

    public CtidConfig getCTID() {
        return this.CTID;
    }

    public String getH5_DOMAIN() {
        return this.H5_DOMAIN;
    }

    public ScConfig getSC() {
        return this.SC;
    }

    public void setBASIC(PureWirelessConf pureWirelessConf) {
        this.BASIC = pureWirelessConf;
    }

    public void setBC(BcConfig bcConfig) {
        this.BC = bcConfig;
    }

    public void setCTID(CtidConfig ctidConfig) {
        this.CTID = ctidConfig;
    }

    public void setH5_DOMAIN(String str) {
        this.H5_DOMAIN = str;
    }

    public void setSC(ScConfig scConfig) {
        this.SC = scConfig;
    }
}
