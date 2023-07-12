package com.taobao.orange;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface OConfigListener extends OBaseListener {
    public static final String CONFIG_VERSION = "configVersion";
    public static final String FROM_CACHE = "fromCache";

    void onConfigUpdate(String str, Map<String, String> map);
}
