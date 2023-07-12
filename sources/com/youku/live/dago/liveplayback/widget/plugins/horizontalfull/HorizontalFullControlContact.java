package com.youku.live.dago.liveplayback.widget.plugins.horizontalfull;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HorizontalFullControlContact {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Presenter extends BasePresenter {
        void addViewGroup(ViewGroup viewGroup);

        int getMode();

        AlixPlayerContext getPlayerContext();

        void onControlBtnClicked();

        void onDisplayBtnClicked();

        void seekTo(int i);

        void showMultiList();

        void showQuality(android.view.View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    interface View extends BaseView<Presenter> {
        void addView(android.view.View view, LinearLayout.LayoutParams layoutParams, String str);

        void setCastMode(boolean z);

        void showDisplayButton(boolean z);

        void showQualityTip(boolean z, String str);

        void showQualityView(boolean z, String str);

        void updateProgress(int i);
    }
}
