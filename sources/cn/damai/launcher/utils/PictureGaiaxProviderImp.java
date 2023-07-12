package cn.damai.launcher.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import cn.damai.common.app.widget.DMDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.provider.module.proxy.PictureGaiaxProviderAbs;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PictureGaiaxProviderImp extends PictureGaiaxProviderAbs {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.gaiax.provider.module.proxy.IProxyPictureGaiaxProvider
    @NonNull
    public Dialog PictureCommonDialog(@NonNull Activity activity, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1102985414") ? (Dialog) ipChange.ipc$dispatch("-1102985414", new Object[]{this, activity, str, str2, str3, str4, onClickListener, onClickListener2}) : new DMDialog(activity).v(str).q(str2).n(str4, onClickListener).i(str3, onClickListener2).t(17).o(true);
    }
}
