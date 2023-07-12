package com.taobao.orange.model;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.util.OLog;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CustomConfigDO extends ConfigDO {
    @JSONField(name = "content")
    public String stringContent;

    @Override // com.taobao.orange.model.ConfigDO, com.taobao.orange.model.CheckDO
    public boolean checkValid() {
        if (!TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.appVersion) && !TextUtils.isEmpty(this.id) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.resourceId) && !TextUtils.isEmpty(this.type) && !TextUtils.isEmpty(this.loadLevel) && !TextUtils.isEmpty(this.stringContent) && !TextUtils.isEmpty(this.version)) {
            boolean z = (this.appVersion.equals(jn1.MUL) || this.appVersion.equals(GlobalOrange.appVersion)) && this.appKey.equals(GlobalOrange.appKey);
            if (!z) {
                OLog.w("ConfigDO", "invaild", new Object[0]);
            }
            return z;
        }
        OLog.w("ConfigDO", "lack param", new Object[0]);
        return false;
    }
}
