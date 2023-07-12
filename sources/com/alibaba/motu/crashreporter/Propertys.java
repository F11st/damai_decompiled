package com.alibaba.motu.crashreporter;

import android.content.Context;
import com.alibaba.motu.crashreporter.Options;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class Propertys extends Options<Property> {
    Context mContext;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class Property extends Options.Option {
        public Property(String str, String str2, boolean z) {
            super(str, str2, z);
        }

        public Property(String str, String str2) {
            super(str, str2);
        }
    }

    public Propertys() {
        super(true);
    }

    public void copyTo(Map<String, String> map) {
        for (String str : this.mData.keySet()) {
            Object obj = ((Property) this.mData.get(str)).value;
            if (obj instanceof String) {
                map.put(str, (String) obj);
            }
        }
    }

    @Override // com.alibaba.motu.crashreporter.Options
    public String getValue(String str) {
        return (String) super.getValue(str);
    }
}
