package cn.damai.onearch.view;

import android.view.View;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.Presenter;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AbsView<I extends IItem<ItemValue>, M extends IContract.Model<I>, P extends IContract.Presenter<I, M>> extends com.alient.onearch.adapter.view.AbsView<I, M, P> {
    public AbsView(View view) {
        super(view);
    }
}
