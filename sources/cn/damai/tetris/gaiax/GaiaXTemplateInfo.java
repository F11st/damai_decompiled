package cn.damai.tetris.gaiax;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;

/* compiled from: Taobao */
@Keep
/* loaded from: classes16.dex */
public class GaiaXTemplateInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bizKey;
    public String componentId;
    public String identifier;
    public String version;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424710920")) {
            return ((Boolean) ipChange.ipc$dispatch("424710920", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GaiaXTemplateInfo gaiaXTemplateInfo = (GaiaXTemplateInfo) obj;
        return TextUtils.equals(this.componentId, gaiaXTemplateInfo.componentId) && TextUtils.equals(this.version, gaiaXTemplateInfo.version);
    }

    public String getIdentifier() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059982660")) {
            return (String) ipChange.ipc$dispatch("-2059982660", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.identifier)) {
            this.identifier = this.componentId + JSMethod.NOT_SET + this.version;
        }
        return this.identifier;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "640915135") ? ((Integer) ipChange.ipc$dispatch("640915135", new Object[]{this})).intValue() : getIdentifier().hashCode();
    }
}
