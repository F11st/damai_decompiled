package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class TicketExtFAQBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String iconUrl;
    @Nullable
    private ArrayList<String> normalQuestionList;
    @Nullable
    private String note;
    @Nullable
    private Boolean roleAndSceneGame = Boolean.FALSE;
    @Nullable
    private String title;

    @Nullable
    public final String getIconUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "42043655") ? (String) ipChange.ipc$dispatch("42043655", new Object[]{this}) : this.iconUrl;
    }

    @Nullable
    public final ArrayList<String> getNormalQuestionList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1327079478") ? (ArrayList) ipChange.ipc$dispatch("-1327079478", new Object[]{this}) : this.normalQuestionList;
    }

    @Nullable
    public final String getNote() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-603576713") ? (String) ipChange.ipc$dispatch("-603576713", new Object[]{this}) : this.note;
    }

    @Nullable
    public final Boolean getRoleAndSceneGame() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "732396603") ? (Boolean) ipChange.ipc$dispatch("732396603", new Object[]{this}) : this.roleAndSceneGame;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-376177239") ? (String) ipChange.ipc$dispatch("-376177239", new Object[]{this}) : this.title;
    }

    public final void setIconUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312900273")) {
            ipChange.ipc$dispatch("-312900273", new Object[]{this, str});
        } else {
            this.iconUrl = str;
        }
    }

    public final void setNormalQuestionList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-729171514")) {
            ipChange.ipc$dispatch("-729171514", new Object[]{this, arrayList});
        } else {
            this.normalQuestionList = arrayList;
        }
    }

    public final void setNote(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1823765689")) {
            ipChange.ipc$dispatch("-1823765689", new Object[]{this, str});
        } else {
            this.note = str;
        }
    }

    public final void setRoleAndSceneGame(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2023702437")) {
            ipChange.ipc$dispatch("-2023702437", new Object[]{this, bool});
        } else {
            this.roleAndSceneGame = bool;
        }
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580192275")) {
            ipChange.ipc$dispatch("-580192275", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }
}
