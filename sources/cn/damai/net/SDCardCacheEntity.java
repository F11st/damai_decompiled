package cn.damai.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SDCardCacheEntity implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String data;
    public long time = 0;
    public String url = "";
    public String etag = "";

    public String getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "254711522") ? (String) ipChange.ipc$dispatch("254711522", new Object[]{this}) : this.data;
    }

    public String getEtag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-595104563") ? (String) ipChange.ipc$dispatch("-595104563", new Object[]{this}) : this.etag;
    }

    public long getTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1584230255") ? ((Long) ipChange.ipc$dispatch("1584230255", new Object[]{this})).longValue() : this.time;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1618888275") ? (String) ipChange.ipc$dispatch("-1618888275", new Object[]{this}) : this.url;
    }

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-986634180")) {
            ipChange.ipc$dispatch("-986634180", new Object[]{this, str});
        } else {
            this.data = str;
        }
    }

    public void setEtag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1561129039")) {
            ipChange.ipc$dispatch("-1561129039", new Object[]{this, str});
        } else {
            this.etag = str;
        }
    }

    public void setTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777948597")) {
            ipChange.ipc$dispatch("1777948597", new Object[]{this, Long.valueOf(j)});
        } else {
            this.time = j;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522348183")) {
            ipChange.ipc$dispatch("-1522348183", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }
}
