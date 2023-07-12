package com.taobao.slide.model;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AppUpdateDO implements ValidDO, Serializable {
    private static final long serialVersionUID = -7287663922696585432L;
    public String dig;
    public String url;
    public String ver;

    @Override // com.taobao.slide.model.ValidDO
    public boolean isValid() {
        return (TextUtils.isEmpty(this.ver) || TextUtils.isEmpty(this.dig) || TextUtils.isEmpty(this.url)) ? false : true;
    }

    public String toString() {
        return String.format("{ver:%s, digest:%s, url:%s}", this.ver, this.dig, this.url);
    }
}
