package com.alibaba.pictures.bricks.onearch;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class AbsModel<D extends IItem<ItemValue>, VALUE> extends com.alient.onearch.adapter.view.AbsModel<D, VALUE> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected TrackInfo compatTrackInfo;

    protected TrackInfo compatParseTrackInfo(D d) {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1960917639")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1960917639", new Object[]{this, d});
        }
        TrackInfo trackInfo = new TrackInfo();
        ModelValue property = d.getComponent().getModule().getContainer().getProperty();
        ComponentValue property2 = d.getComponent().getProperty();
        if (property.getData() != null && property2.getData() != null) {
            JSONObject jSONObject = property.getData().getJSONObject("globalConfig");
            JSONObject jSONObject2 = property2.getData().getJSONObject("trackInfo");
            if (jSONObject2 != null) {
                if (jSONObject != null) {
                    trackInfo.setSpmb(jSONObject.getString("pageName"));
                }
                if (!TextUtils.isEmpty(jSONObject2.getString("spmc"))) {
                    trackInfo.setSpmc(jSONObject2.getString("spmc"));
                }
                if (!TextUtils.isEmpty(jSONObject2.getString("spmd"))) {
                    if (jSONObject2.getString("spmd").contains(JSMethod.NOT_SET)) {
                        string = jSONObject2.getString("spmd") + d.getIndex();
                    } else {
                        string = jSONObject2.getString("spmd");
                    }
                    trackInfo.setSpmd(string);
                }
                HashMap<String, String> parseTrackInfoArgs = parseTrackInfoArgs(jSONObject2);
                parseTrackInfoArgs.remove("spmc");
                parseTrackInfoArgs.remove("spmd");
                trackInfo.setArgs(parseTrackInfoArgs);
            }
        }
        return trackInfo;
    }

    public TrackInfo getCompatTrackInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1881904846") ? (TrackInfo) ipChange.ipc$dispatch("1881904846", new Object[]{this}) : this.compatTrackInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseTrackInfo(D d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622796203")) {
            ipChange.ipc$dispatch("-1622796203", new Object[]{this, d});
            return;
        }
        super.parseTrackInfo(d);
        this.compatTrackInfo = compatParseTrackInfo(d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> parseTrackInfoArgs(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271746803")) {
            return (HashMap) ipChange.ipc$dispatch("1271746803", new Object[]{this, jSONObject});
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            for (Map.Entry<String, Object> entry : jSONObject.getInnerMap().entrySet()) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return hashMap;
    }
}
