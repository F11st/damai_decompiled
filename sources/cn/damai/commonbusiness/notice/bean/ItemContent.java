package cn.damai.commonbusiness.notice.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public final class ItemContent implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String content;
    @Nullable
    private ArrayList<String> imageUrlList;
    @Nullable
    private String performName;
    @Nullable
    private String rootTitle;

    @Nullable
    public final String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1609898353") ? (String) ipChange.ipc$dispatch("1609898353", new Object[]{this}) : this.content;
    }

    @Nullable
    public final ArrayList<String> getImageUrlList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-473803158") ? (ArrayList) ipChange.ipc$dispatch("-473803158", new Object[]{this}) : this.imageUrlList;
    }

    @Nullable
    public final String getPerformName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1754448764") ? (String) ipChange.ipc$dispatch("-1754448764", new Object[]{this}) : this.performName;
    }

    @Nullable
    public final String getRootTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1726485554") ? (String) ipChange.ipc$dispatch("-1726485554", new Object[]{this}) : this.rootTitle;
    }

    public final void setContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045955109")) {
            ipChange.ipc$dispatch("1045955109", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public final void setImageUrlList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "699338790")) {
            ipChange.ipc$dispatch("699338790", new Object[]{this, arrayList});
        } else {
            this.imageUrlList = arrayList;
        }
    }

    public final void setPerformName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-853288078")) {
            ipChange.ipc$dispatch("-853288078", new Object[]{this, str});
        } else {
            this.performName = str;
        }
    }

    public final void setRootTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348317800")) {
            ipChange.ipc$dispatch("348317800", new Object[]{this, str});
        } else {
            this.rootTitle = str;
        }
    }
}
