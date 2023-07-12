package com.youku.live.dago.liveplayback.widget.plugins.quality;

import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ChangeQualityContract {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    interface Presenter extends BasePresenter {
        void changeQuality(int i);

        void onHide();

        void refreshDefinitionData();

        void showQualityInfo(android.view.View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    interface View extends BaseView<Presenter> {
    }
}
