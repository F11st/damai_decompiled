package com.alibaba.security.biometrics.service.util.params;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.security.common.d.h;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class JsonBundleConverter extends BundleConverter {
    @Override // com.alibaba.security.biometrics.service.util.params.BundleConverter
    public Object deserialize(Object obj) {
        if (obj != null && (obj instanceof String)) {
            return JSON.parseObject((String) obj, this.type, new Feature[0]);
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.util.params.BundleConverter
    public String serialize(Object obj) {
        return h.a(obj);
    }
}
