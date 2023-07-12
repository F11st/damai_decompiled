package com.youku.live.dsl.downgrade;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDownGradeImp implements IDownGrade {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.downgrade.IDownGrade
    public void downgradeWebview(Context context, String str, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139174264")) {
            ipChange.ipc$dispatch("2139174264", new Object[]{this, context, str, bundle});
        } else if (context == null || TextUtils.isEmpty(str)) {
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("url", str);
            DMNav.from(context).withExtras(bundle).toUri(str);
        }
    }

    @Override // com.youku.live.dsl.downgrade.IDownGrade
    public void downgradeWebviewForResult(Context context, String str, Bundle bundle, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157009235")) {
            ipChange.ipc$dispatch("157009235", new Object[]{this, context, str, bundle, Integer.valueOf(i)});
        } else if (context == null || TextUtils.isEmpty(str)) {
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("url", str);
            DMNav.from(context).withExtras(bundle).forResult(i).toUri(str);
        }
    }

    @Override // com.youku.live.dsl.downgrade.IDownGrade
    public void downgradeWebview(String str, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449591444")) {
            ipChange.ipc$dispatch("449591444", new Object[]{this, str, bundle});
        } else if (Dsl.getContext() == null || TextUtils.isEmpty(str)) {
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("url", str);
            DMNav.from(Dsl.getContext()).withExtras(bundle).toUri(str);
        }
    }
}
