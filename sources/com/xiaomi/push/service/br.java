package com.xiaomi.push.service;

import com.xiaomi.push.hw;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class br {
    public static hw a(hw hwVar) {
        Map<String, String> map;
        if (hwVar != null && (map = hwVar.f536b) != null) {
            map.remove("score_info");
        }
        return hwVar;
    }
}
