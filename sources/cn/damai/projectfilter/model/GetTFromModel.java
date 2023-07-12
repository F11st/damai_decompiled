package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.Type;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class GetTFromModel<T> {
    public final FilterModel mModel;

    public GetTFromModel(FilterModel filterModel) {
        this.mModel = filterModel;
    }

    public abstract T getT(Type type);
}
