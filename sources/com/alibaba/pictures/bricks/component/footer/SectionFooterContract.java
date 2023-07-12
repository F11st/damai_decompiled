package com.alibaba.pictures.bricks.component.footer;

import com.alibaba.fastjson.JSONArray;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SectionFooterContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        String getComponentId();

        JSONArray getResult();

        int getTotal();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
        void dispatchAction();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    interface View extends IContract.View {
        void renderContent(String str);
    }
}
