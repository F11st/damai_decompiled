package com.youku.live.livesdk.model.mtop.data.livefullinfo;

import android.util.Base64;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.widgets.model.template.TemplateModel;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TemplateDTO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String interactJsBundle;
    public Boolean landScape;
    public String layout;
    public List<LiveBundleLayout> layoutList;
    public TemplateModel layoutModel;
    public String layoutSource;
    public String staticJsBundle;
    public String templateId;

    public String getLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1962285338") ? (String) ipChange.ipc$dispatch("-1962285338", new Object[]{this}) : this.layout;
    }

    public void setLayout(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2096395336")) {
            ipChange.ipc$dispatch("-2096395336", new Object[]{this, str});
            return;
        }
        this.layout = str;
        try {
            this.layoutSource = new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
        }
        if (this.layoutSource != null) {
            this.layoutModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(this.layoutSource, TemplateModel.class);
        }
    }
}
