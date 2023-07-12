package com.youku.live.dsl.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class INavVirtualImp implements INav {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.router.INav
    public INav from(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1341274647") ? (INav) ipChange.ipc$dispatch("-1341274647", new Object[]{this, context}) : this;
    }

    @Override // com.youku.live.dsl.router.INav
    public boolean toUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559209433")) {
            return ((Boolean) ipChange.ipc$dispatch("-559209433", new Object[]{this, uri})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dsl.router.INav
    public boolean toUri(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1739683442")) {
            return ((Boolean) ipChange.ipc$dispatch("1739683442", new Object[]{this, str})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withCategory(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-328277") ? (INav) ipChange.ipc$dispatch("-328277", new Object[]{this, str}) : this;
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withExtras(Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2034417118") ? (INav) ipChange.ipc$dispatch("2034417118", new Object[]{this, bundle}) : this;
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withFlags(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "798762167") ? (INav) ipChange.ipc$dispatch("798762167", new Object[]{this, Integer.valueOf(i)}) : this;
    }
}
