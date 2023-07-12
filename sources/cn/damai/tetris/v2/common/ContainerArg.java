package cn.damai.tetris.v2.common;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ContainerArg implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String args;
    public String patternName;
    public String patternVersion;

    public ContainerArg() {
    }

    public static ContainerArg defaultDramaChannelArg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1660818905") ? (ContainerArg) ipChange.ipc$dispatch("-1660818905", new Object[0]) : new ContainerArg("category_drama_new", "1.0", "{\"categoryId\":\"3\"}");
    }

    public static ContainerArg defaultMusicFestivalArg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1031824362") ? (ContainerArg) ipChange.ipc$dispatch("1031824362", new Object[0]) : new ContainerArg("festivalHomePage", "1.0", null);
    }

    public ContainerArg(String str, String str2, String str3) {
        this.patternName = str;
        this.patternVersion = str2;
        this.args = str3;
    }
}
