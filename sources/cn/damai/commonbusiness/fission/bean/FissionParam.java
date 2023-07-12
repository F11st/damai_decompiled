package cn.damai.commonbusiness.fission.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FissionParam implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String channelType;
    public String imageUrl;
    public String loadingState;
    public String mainMessage;
    public String projectName;
    public String sceneTip;
    public String sceneType;
    public String shareUrl;
    public String subMessage;
    public String uniqueIdent;

    public String getUniqueIdent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907530840")) {
            return (String) ipChange.ipc$dispatch("907530840", new Object[]{this});
        }
        long j = 0;
        try {
            j = Long.parseLong(this.uniqueIdent);
        } catch (Exception unused) {
        }
        return String.valueOf(j);
    }
}
