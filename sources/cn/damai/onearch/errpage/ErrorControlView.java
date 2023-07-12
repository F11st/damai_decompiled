package cn.damai.onearch.errpage;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ErrorControlView {
    @Nullable
    ViewGroup getErrContainer();

    @Nullable
    Activity getErrContainerActivity();

    void hideErrView();

    boolean isErrViewShown();

    void showDialogLoading(boolean z);

    void showErrView(ErrControlViewInfo errControlViewInfo);
}
