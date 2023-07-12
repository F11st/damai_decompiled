package cn.damai.commonbusiness.notice.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public final class NoticeItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<ItemContent> contentList;
    @Nullable
    private String title;

    @Nullable
    public final ArrayList<ItemContent> getContentList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-116239958") ? (ArrayList) ipChange.ipc$dispatch("-116239958", new Object[]{this}) : this.contentList;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1414013327") ? (String) ipChange.ipc$dispatch("-1414013327", new Object[]{this}) : this.title;
    }

    public final void setContentList(@Nullable ArrayList<ItemContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-500023986")) {
            ipChange.ipc$dispatch("-500023986", new Object[]{this, arrayList});
        } else {
            this.contentList = arrayList;
        }
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1606627365")) {
            ipChange.ipc$dispatch("1606627365", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }
}
