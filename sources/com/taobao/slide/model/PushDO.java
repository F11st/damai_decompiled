package com.taobao.slide.model;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PushDO implements ValidDO, Serializable {
    private static final long serialVersionUID = -246732497229716223L;
    public String payload;
    public int type;

    @Override // com.taobao.slide.model.ValidDO
    public boolean isValid() {
        return !TextUtils.isEmpty(this.payload);
    }
}
