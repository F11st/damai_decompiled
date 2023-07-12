package cn.damai.tetris.core;

import android.view.View;
import cn.damai.tetris.core.IPresenter;
import java.io.Serializable;
import tb.gi2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IView<P extends IPresenter> extends Serializable {
    View getRootView();

    void setPresenter(P p);

    void setStyle(gi2 gi2Var);
}
