package cn.damai.search.component.feed;

import cn.damai.tetris.component.discover.bean.NoteBean;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ContentContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        NoteBean getNoteBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
        void exposeContentCard(android.view.View view, NoteBean noteBean, int i);

        void gotoContentActivity(NoteBean noteBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface View extends IContract.View {
        void render(NoteBean noteBean, int i);
    }
}
