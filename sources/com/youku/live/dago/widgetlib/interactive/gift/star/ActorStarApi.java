package com.youku.live.dago.widgetlib.interactive.gift.star;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetError;
import com.youku.live.dsl.network.INetRequest;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ActorStarApi {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String USER_STAR_GET = "https://api.laifeng.com/v1/star/get";

    public static void aquireStarRequest(Map<String, String> map, INetCallback iNetCallback, INetError iNetError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607175450")) {
            ipChange.ipc$dispatch("-607175450", new Object[]{map, iNetCallback, iNetError});
            return;
        }
        INetRequest createRequestWithHttp = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithHttp(USER_STAR_GET, map, false);
        if (createRequestWithHttp != null) {
            createRequestWithHttp.async(iNetCallback, iNetError);
        }
    }
}
