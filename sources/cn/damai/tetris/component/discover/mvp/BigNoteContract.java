package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface BigNoteContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        NoteBean getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void OnPraiseViewClick(boolean z, String str, int i);

        void dnaOnClickReport(String str, String str2, int i);

        void exposeNote(android.view.View view, NoteBean noteBean, int i);

        void itemClick(View view, NoteBean noteBean, int i);

        void likeOnClickReport(boolean z, String str, int i);

        void shareClick(ContentShareInfo contentShareInfo, int i);

        void userOnClickReport(String str, String str2, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(NoteBean noteBean, int i);
    }
}
