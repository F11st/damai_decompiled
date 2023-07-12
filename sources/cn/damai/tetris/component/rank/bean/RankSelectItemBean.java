package cn.damai.tetris.component.rank.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class RankSelectItemBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String categoryName;
    @JvmField
    @Nullable
    public String id;
    @JvmField
    public int pos = -1;
    @JvmField
    @Nullable
    public String shortDesc;
    @JvmField
    @Nullable
    public String shortName;
    @Nullable
    private String total;
    @Nullable
    private String type;
    @JvmField
    @Nullable
    public List<String> verticalPicList;

    @Nullable
    public final String getCategoryName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-51837794") ? (String) ipChange.ipc$dispatch("-51837794", new Object[]{this}) : this.categoryName;
    }

    @Nullable
    public final String getTotal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2030324133") ? (String) ipChange.ipc$dispatch("2030324133", new Object[]{this}) : this.total;
    }

    @Nullable
    public final String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-344133969") ? (String) ipChange.ipc$dispatch("-344133969", new Object[]{this}) : this.type;
    }

    public final void setCategoryName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209090560")) {
            ipChange.ipc$dispatch("-1209090560", new Object[]{this, str});
        } else {
            this.categoryName = str;
        }
    }

    public final void setTotal(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1006906225")) {
            ipChange.ipc$dispatch("1006906225", new Object[]{this, str});
        } else {
            this.total = str;
        }
    }

    public final void setType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1923992079")) {
            ipChange.ipc$dispatch("1923992079", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }
}
