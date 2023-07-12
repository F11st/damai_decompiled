package com.youku.phone.xcdnengine;

import android.content.Context;
import androidx.annotation.Keep;
import com.youku.phone.xcdn.api.IXcdnApi;
import com.youku.phone.xcdn.api.IXcdnCallback;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class IXcdnImpl implements IXcdnApi {
    private XcdnEngine engine;

    public IXcdnImpl(Context context) {
        this.engine = new XcdnEngine(context);
    }

    @Override // com.youku.phone.xcdn.api.IXcdnApi
    public boolean cancelDownload(long j) {
        return this.engine.cancelDownload(j);
    }

    @Override // com.youku.phone.xcdn.api.IXcdnApi
    public void setGlobalConfigs(Map<String, String> map) {
        this.engine.setGlobalConfigs(map);
    }

    @Override // com.youku.phone.xcdn.api.IXcdnApi
    public long startDownload(String str, String str2, HashMap<String, String> hashMap, IXcdnCallback iXcdnCallback) {
        return this.engine.startDownload(str, str2, hashMap, iXcdnCallback);
    }
}
