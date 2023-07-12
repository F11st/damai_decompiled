package cn.damai.ultron.view.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DetailInfoVO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String desc;
    public String icon;
    public String jumpUrl;
    public String packageTicketID;
    public String title;
    public String type;

    public boolean isTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1683679394") ? ((Boolean) ipChange.ipc$dispatch("-1683679394", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.type) && "root".equals(this.type);
    }
}
