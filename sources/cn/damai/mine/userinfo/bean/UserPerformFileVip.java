package cn.damai.mine.userinfo.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class UserPerformFileVip implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String hisAssetDesc;
    public String hisAssetDescUrl;
    public String title;
    public String willExpireScore;

    public String getWillScore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1286261728")) {
            return (String) ipChange.ipc$dispatch("1286261728", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.willExpireScore) || "0".equals(this.willExpireScore)) {
            return null;
        }
        return this.willExpireScore;
    }
}
