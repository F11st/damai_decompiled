package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class CategoryUpdate {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final List<CategoryLevelOne> cloneOneList;
    @Nullable
    private final List<CategoryLevelTwo> cloneTwoList;

    public CategoryUpdate(@Nullable List<CategoryLevelOne> list, @Nullable List<CategoryLevelTwo> list2) {
        this.cloneOneList = list;
        this.cloneTwoList = list2;
    }

    @Nullable
    public final List<CategoryLevelOne> getCloneOneList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1959271037") ? (List) ipChange.ipc$dispatch("1959271037", new Object[]{this}) : this.cloneOneList;
    }

    @Nullable
    public final List<CategoryLevelTwo> getCloneTwoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-877158941") ? (List) ipChange.ipc$dispatch("-877158941", new Object[]{this}) : this.cloneTwoList;
    }
}
