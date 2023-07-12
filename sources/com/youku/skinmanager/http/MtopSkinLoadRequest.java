package com.youku.skinmanager.http;

import com.youku.mtop.common.SystemInfo;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MtopSkinLoadRequest implements IMTOPDataObject {
    public String API_NAME = "mtop.youku.haidai.themeskin.getskininfo";
    public String VERSION = "1.0";
    public String skinId;
    public String system_info;

    public MtopSkinLoadRequest() {
        this.system_info = null;
        this.system_info = new SystemInfo().toString();
    }

    public Map<String, Object> buildRequestParams() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("skinid", this.skinId);
        hashMap.put("system_info", this.system_info);
        return hashMap;
    }
}
