package com.youku.live.livesdk.model.mtop.data.livefullinfo;

import android.util.Base64;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.widgets.model.template.TemplateModel;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LiveBundleLayout implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_LANDSCAPE = "landScape";
    public static final String TYPE_VERTICAL = "vertical";
    public String layout;
    public TemplateModel layoutModel;
    public String layoutSource;
    public String type;

    public String getLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "67729205") ? (String) ipChange.ipc$dispatch("67729205", new Object[]{this}) : this.layout;
    }

    public void setLayout(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704513353")) {
            ipChange.ipc$dispatch("704513353", new Object[]{this, str});
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
