package com.youku.ups.a;

import android.content.Context;
import android.text.TextUtils;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainFactory;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;
import com.youku.ups.data.RequestParams;
import com.youku.upsplayer.util.PlayStageTracker;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.youku.ups.a.a */
/* loaded from: classes3.dex */
public class C8083a {
    public static String a(Context context, Map<String, String> map, boolean z) {
        String str = map.get("vid");
        String str2 = map.get("idsForCkey");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        String str3 = map.get(RequestParams.client_ip);
        String str4 = map.get("ccode");
        String str5 = map.get(RequestParams.utid);
        AntiTheftChainParam antiTheftChainParam = new AntiTheftChainParam();
        antiTheftChainParam.setVid(str);
        antiTheftChainParam.setServerEnv(0);
        antiTheftChainParam.setContext(context);
        antiTheftChainParam.setClientTs(map.get(RequestParams.client_ts));
        antiTheftChainParam.setAntiTheftChainClientType(z ? AntiTheftChainClientType.External : AntiTheftChainClientType.Internal);
        antiTheftChainParam.setCcode(str4);
        antiTheftChainParam.setClientIP(str3);
        antiTheftChainParam.setUtid(str5);
        PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
        upsRequest.beginSection("createCkey");
        String ckey = AntiTheftChainFactory.create().getCkey(antiTheftChainParam);
        upsRequest.endSection();
        return C8084b.c(ckey);
    }
}
