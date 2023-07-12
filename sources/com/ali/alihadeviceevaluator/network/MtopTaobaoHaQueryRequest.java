package com.ali.alihadeviceevaluator.network;

import mtopsdk.mtop.domain.IMTOPDataObject;

/* loaded from: classes9.dex */
class MtopTaobaoHaQueryRequest implements IMTOPDataObject {
    private String API_NAME = "mtop.taobao.ha.query";
    private String VERSION = "1.0";
    private boolean NEED_ECODE = false;
    private boolean NEED_SESSION = false;
    private String data = null;
    private String bizid = null;
    private String reserved2 = null;
    private String reserved1 = null;

    public String getAPI_NAME() {
        return this.API_NAME;
    }

    public String getBizid() {
        return this.bizid;
    }

    public String getData() {
        return this.data;
    }

    public String getReserved1() {
        return this.reserved1;
    }

    public String getReserved2() {
        return this.reserved2;
    }

    public String getVERSION() {
        return this.VERSION;
    }

    public boolean isNEED_ECODE() {
        return this.NEED_ECODE;
    }

    public boolean isNEED_SESSION() {
        return this.NEED_SESSION;
    }

    public void setAPI_NAME(String str) {
        this.API_NAME = str;
    }

    public void setBizid(String str) {
        this.bizid = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setNEED_ECODE(boolean z) {
        this.NEED_ECODE = z;
    }

    public void setNEED_SESSION(boolean z) {
        this.NEED_SESSION = z;
    }

    public void setReserved1(String str) {
        this.reserved1 = str;
    }

    public void setReserved2(String str) {
        this.reserved2 = str;
    }

    public void setVERSION(String str) {
        this.VERSION = str;
    }
}
