package com.taobao.slide.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PeaDO implements ValidDO, Serializable {
    private static final long serialVersionUID = 896286555439986847L;
    public String condition;
    public String control;
    public String etag;
    public String extra;
    public List<PayloadDO> resources;

    @Override // com.taobao.slide.model.ValidDO
    public boolean isValid() {
        List<PayloadDO> list;
        return (TextUtils.isEmpty(this.condition) || (list = this.resources) == null || list.isEmpty() || TextUtils.isEmpty(this.etag)) ? false : true;
    }

    public String toString() {
        return String.format("{condition:%s, control:%s, etag:%s}", this.condition, this.control, this.etag);
    }
}
