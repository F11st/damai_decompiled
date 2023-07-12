package com.alibaba.pictures.bricks.coupon.order.bean;

import android.net.Uri;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class GxRender implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String type;
    @Nullable
    private String url;

    @JSONField(deserialize = false, serialize = false)
    @Nullable
    public final GxTemplate getGxTemplate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374002669")) {
            return (GxTemplate) ipChange.ipc$dispatch("374002669", new Object[]{this});
        }
        try {
            Uri parse = Uri.parse(this.url);
            String queryParameter = parse.getQueryParameter(hh1.DIMEN_BIZ);
            String queryParameter2 = parse.getQueryParameter("templateId");
            String queryParameter3 = parse.getQueryParameter("templateVersion");
            if (queryParameter == null || queryParameter2 == null) {
                return null;
            }
            return new GxTemplate(queryParameter, queryParameter2, queryParameter3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1004345755") ? (String) ipChange.ipc$dispatch("1004345755", new Object[]{this}) : this.type;
    }

    @Nullable
    public final String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1480910180") ? (String) ipChange.ipc$dispatch("1480910180", new Object[]{this}) : this.url;
    }

    public final void setType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777190563")) {
            ipChange.ipc$dispatch("777190563", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82123410")) {
            ipChange.ipc$dispatch("82123410", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }
}
