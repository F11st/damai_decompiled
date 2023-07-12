package com.youku.live.dsl.log;

import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ILogImp implements ILog {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String EMPTY = "empty";

    @Override // com.youku.live.dsl.log.ILog
    public void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996500288")) {
            ipChange.ipc$dispatch("996500288", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
            Log.d(str, "empty");
        } else {
            Log.d(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836887009")) {
            ipChange.ipc$dispatch("-1836887009", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
            Log.i(str, "empty");
        } else {
            Log.e(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833089334")) {
            ipChange.ipc$dispatch("1833089334", new Object[]{this, str, str2, th});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285534309")) {
            ipChange.ipc$dispatch("-285534309", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
            Log.i(str, "empty");
        } else {
            Log.i(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461271354")) {
            ipChange.ipc$dispatch("1461271354", new Object[]{this, str, str2, th});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535136494")) {
            ipChange.ipc$dispatch("1535136494", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
            Log.v(str, "empty");
        } else {
            Log.v(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298250803")) {
            ipChange.ipc$dispatch("-1298250803", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
            Log.i(str, "empty");
        } else {
            Log.w(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1987575224")) {
            ipChange.ipc$dispatch("-1987575224", new Object[]{this, str, str2, th});
        }
    }
}
