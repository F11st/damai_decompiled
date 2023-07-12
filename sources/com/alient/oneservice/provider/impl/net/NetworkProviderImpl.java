package com.alient.oneservice.provider.impl.net;

import androidx.annotation.Keep;
import cn.damai.common.net.mtop.Util;
import com.alient.oneservice.net.NetworkProvider;
import java.util.Map;
import tb.w20;

/* compiled from: Taobao */
@Keep
/* loaded from: classes10.dex */
public class NetworkProviderImpl implements NetworkProvider {
    @Override // com.alient.oneservice.net.NetworkProvider
    public String getErrorMsg(String str, String str2) {
        return Util.getErrorMsg(str, str2);
    }

    @Override // com.alient.oneservice.net.NetworkProvider
    public Map<String, String> signParams(String str, Map<String, String> map) {
        return w20.b().c(str, map);
    }
}
