package cn.damai.discover.main.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ThemeShare {
    private static transient /* synthetic */ IpChange $ipChange;
    public String shareImage;
    public String shareSubTitle;
    public String shareTitle;
    public String shareUrl;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1534144483") ? ((Boolean) ipChange.ipc$dispatch("-1534144483", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.shareImage) || TextUtils.isEmpty(this.shareUrl)) ? false : true;
    }
}
