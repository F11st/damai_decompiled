package cn.damai.onearch.component.shoptip;

import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ShopTipContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        String getContent();
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface View extends IContract.View {
        void hideRightArrow();

        void renderContent(String str);

        void showRightArrow();

        void updateBgColor(int i);
    }
}
