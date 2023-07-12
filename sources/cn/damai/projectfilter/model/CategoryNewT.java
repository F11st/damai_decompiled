package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class CategoryNewT extends GetTFromModel<CategoryDataAssembler> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryNewT(@NotNull FilterModel filterModel) {
        super(filterModel);
        b41.i(filterModel, "model");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.projectfilter.model.GetTFromModel
    @NotNull
    public CategoryDataAssembler getT(@NotNull Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518782733")) {
            return (CategoryDataAssembler) ipChange.ipc$dispatch("1518782733", new Object[]{this, type});
        }
        b41.i(type, "type");
        CategoryDataAssembler categoryDataAssembler = this.mModel.mCatAssembler;
        b41.h(categoryDataAssembler, "mModel.mCatAssembler");
        return categoryDataAssembler;
    }
}
