package cn.damai.user.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ShareJsonBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String ipName;
    public List<String> verticalPicList;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "248421382") ? ((Boolean) ipChange.ipc$dispatch("248421382", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.id) || cb2.d(this.verticalPicList)) ? false : true;
    }
}
