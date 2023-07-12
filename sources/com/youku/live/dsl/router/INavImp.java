package com.youku.live.dsl.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class INavImp implements INav {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.router.INav
    public INav from(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415950782")) {
            return (INav) ipChange.ipc$dispatch("1415950782", new Object[]{this, context});
        }
        return null;
    }

    @Override // com.youku.live.dsl.router.INav
    public boolean toUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2109904964")) {
            return ((Boolean) ipChange.ipc$dispatch("-2109904964", new Object[]{this, uri})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dsl.router.INav
    public boolean toUri(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912762237")) {
            return ((Boolean) ipChange.ipc$dispatch("912762237", new Object[]{this, str})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withCategory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425685898")) {
            return (INav) ipChange.ipc$dispatch("-425685898", new Object[]{this, str});
        }
        return null;
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withExtras(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496675251")) {
            return (INav) ipChange.ipc$dispatch("496675251", new Object[]{this, bundle});
        }
        return null;
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withFlags(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454477570")) {
            return (INav) ipChange.ipc$dispatch("454477570", new Object[]{this, Integer.valueOf(i)});
        }
        return null;
    }
}
