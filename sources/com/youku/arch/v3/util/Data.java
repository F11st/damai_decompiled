package com.youku.arch.v3.util;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/youku/arch/v3/util/Data;", "", "", AdUtConstants.XAD_UT_ARG_COUNT, "I", "getCount", "()I", "setCount", "(I)V", "", "maxTime", "J", "getMaxTime", "()J", "setMaxTime", "(J)V", "minTime", "getMinTime", "setMinTime", "averageTime", "getAverageTime", "setAverageTime", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Data {
    private static transient /* synthetic */ IpChange $ipChange;
    private long averageTime;
    private int count;
    private long maxTime;
    private long minTime;

    public final long getAverageTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "654914951") ? ((Long) ipChange.ipc$dispatch("654914951", new Object[]{this})).longValue() : this.averageTime;
    }

    public final int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1555248865") ? ((Integer) ipChange.ipc$dispatch("1555248865", new Object[]{this})).intValue() : this.count;
    }

    public final long getMaxTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "893695072") ? ((Long) ipChange.ipc$dispatch("893695072", new Object[]{this})).longValue() : this.maxTime;
    }

    public final long getMinTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-929272910") ? ((Long) ipChange.ipc$dispatch("-929272910", new Object[]{this})).longValue() : this.minTime;
    }

    public final void setAverageTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252408571")) {
            ipChange.ipc$dispatch("-252408571", new Object[]{this, Long.valueOf(j)});
        } else {
            this.averageTime = j;
        }
    }

    public final void setCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777870263")) {
            ipChange.ipc$dispatch("-1777870263", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.count = i;
        }
    }

    public final void setMaxTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163038028")) {
            ipChange.ipc$dispatch("163038028", new Object[]{this, Long.valueOf(j)});
        } else {
            this.maxTime = j;
        }
    }

    public final void setMinTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514394566")) {
            ipChange.ipc$dispatch("-514394566", new Object[]{this, Long.valueOf(j)});
        } else {
            this.minTime = j;
        }
    }
}
