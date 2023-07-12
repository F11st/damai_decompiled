package com.ali.user.open.ucc.util;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.ucc.model.UccParams;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UTHitUtils {
    public static void send(String str, String str2, UccParams uccParams, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (uccParams != null && !TextUtils.isEmpty(uccParams.site)) {
            hashMap.put("site", uccParams.site);
        } else {
            hashMap.put("site", AliMemberSDK.getMasterSite());
        }
        if (uccParams != null) {
            hashMap.put("bindSite", uccParams.bindSite);
            hashMap.put("userToken", uccParams.userToken);
            if (!TextUtils.isEmpty(uccParams.miniAppId)) {
                hashMap.put("miniAppId", uccParams.miniAppId);
            }
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, uccParams.traceId);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send(str, str2, hashMap);
    }
}
