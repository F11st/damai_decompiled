package com.alibaba.pictures.bricks.coupon.order.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class GaiaXBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private JSONObject data;
    @Nullable
    private List<GxRender> render;
    @Nullable
    private String templateId;

    @Nullable
    public final JSONObject getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1764772752") ? (JSONObject) ipChange.ipc$dispatch("1764772752", new Object[]{this}) : this.data;
    }

    @Nullable
    public final List<GxRender> getRender() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-476151805") ? (List) ipChange.ipc$dispatch("-476151805", new Object[]{this}) : this.render;
    }

    @Nullable
    public final String getTemplateId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "623019515") ? (String) ipChange.ipc$dispatch("623019515", new Object[]{this}) : this.templateId;
    }

    @JSONField(deserialize = false, serialize = false)
    public final boolean isValid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614639714")) {
            return ((Boolean) ipChange.ipc$dispatch("1614639714", new Object[]{this})).booleanValue();
        }
        if (this.templateId == null || this.data == null) {
            return false;
        }
        List<GxRender> list = this.render;
        return !(list == null || list.isEmpty());
    }

    public final void setData(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620635764")) {
            ipChange.ipc$dispatch("-620635764", new Object[]{this, jSONObject});
        } else {
            this.data = jSONObject;
        }
    }

    public final void setRender(@Nullable List<GxRender> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263014103")) {
            ipChange.ipc$dispatch("-1263014103", new Object[]{this, list});
        } else {
            this.render = list;
        }
    }

    public final void setTemplateId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23852355")) {
            ipChange.ipc$dispatch("23852355", new Object[]{this, str});
        } else {
            this.templateId = str;
        }
    }
}
