package cn.damai.tetris.core;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StyleInfo extends JSONObject {
    private static transient /* synthetic */ IpChange $ipChange;
    ConnerStyle connerStyle;
    public int padding;
    public int padding_left;

    public StyleInfo(@NonNull JSONObject jSONObject) {
        super(jSONObject.getInnerMap());
        this.padding = 0;
        this.padding_left = 0;
    }

    public ConnerStyle getConnerStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761674523")) {
            return (ConnerStyle) ipChange.ipc$dispatch("-761674523", new Object[]{this});
        }
        ConnerStyle connerStyle = this.connerStyle;
        if (connerStyle != null) {
            return connerStyle;
        }
        if (get("native") != null) {
            try {
                this.connerStyle = (ConnerStyle) JSON.parseObject(getJSONObject("native").toJSONString(), ConnerStyle.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.connerStyle;
        }
        return null;
    }
}
