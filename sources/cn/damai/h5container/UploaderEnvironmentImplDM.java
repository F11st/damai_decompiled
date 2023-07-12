package cn.damai.h5container;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.av2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UploaderEnvironmentImplDM extends av2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public UploaderEnvironmentImplDM(Context context) {
        super(context);
    }

    @Override // tb.av2, com.uploader.export.IUploaderEnvironment
    public String getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "485421471") ? (String) ipChange.ipc$dispatch("485421471", new Object[]{this}) : z20.i();
    }
}
