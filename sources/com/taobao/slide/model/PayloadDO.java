package com.taobao.slide.model;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PayloadDO implements ValidDO, Serializable {
    private static final long serialVersionUID = 8493103853347143021L;
    public String digest;
    public String extra;
    public String url;
    public String version;

    @Override // com.taobao.slide.model.ValidDO
    public boolean isValid() {
        return (TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.digest) || TextUtils.isEmpty(this.version)) ? false : true;
    }

    public String toString() {
        return String.format("{url:%s, digest:%s, version:%s}", this.url, this.digest, this.version);
    }
}
