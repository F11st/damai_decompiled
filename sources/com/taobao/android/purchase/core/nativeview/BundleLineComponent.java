package com.taobao.android.purchase.core.nativeview;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BundleLineComponent extends DMComponent {
    public static final String COMPONENT_TAG = "bundleLine";
    private static final JSONObject JSON_DATA = JSON.parseObject("{\n        \"tag\" : \"bundleLine\",\n        \"type\" : \"bundleLine\",\n        \"fields\" : {}\n      }");

    public BundleLineComponent() {
        this(JSON_DATA, "native", null, null);
    }

    public BundleLineComponent(JSONObject jSONObject, String str, JSONObject jSONObject2, Map<String, List<IDMEvent>> map) {
        super(jSONObject, str, jSONObject2, map);
    }
}
