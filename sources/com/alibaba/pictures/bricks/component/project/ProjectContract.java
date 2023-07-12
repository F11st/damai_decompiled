package com.alibaba.pictures.bricks.component.project;

import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        long getNativeDiffTime();

        ProjectItemBean getProjectItemBean();

        long getServerTime();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface View extends IContract.View {
        BricksProjectViewHolder getHolder();
    }
}
