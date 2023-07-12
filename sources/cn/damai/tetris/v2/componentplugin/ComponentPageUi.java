package cn.damai.tetris.v2.componentplugin;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.v2.structure.container.IContainer;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ComponentPageUi {
    ja getBaseContext();

    IContainer getPageContainer();

    RecyclerView getRecycler();

    View getRootView();

    void hideErrorViewV2();

    void hideNoMoreV2();

    void loadMoreResetV2(boolean z);

    void showErrorViewV2(String str, String str2, OnErrClickListener onErrClickListener);

    void showLoadMoreV2();

    void showNoMoreV2();

    void showNoMoreV2(String str);

    void startProgressDialog();

    void stopProgressDialog();
}
