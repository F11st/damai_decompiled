package com.youku.alixplayer.opensdk.statistics.param;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UriParams implements IParams<String, String> {
    private Map<String, String> mStringMap = new HashMap();

    public UriParams(String str) {
        Uri parse = Uri.parse(str);
        for (String str2 : parse.getQueryParameterNames()) {
            this.mStringMap.put(str2, parse.getQueryParameter(str2));
        }
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public Map<String, String> getData() {
        return this.mStringMap;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public String getString() {
        return this.mStringMap.toString();
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public String getValue(String str) {
        return this.mStringMap.get(str);
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public void putAll(IParams iParams) {
        this.mStringMap.putAll(iParams.getData());
    }
}
