package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HBRContract {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Presenter extends BasePresenter {
        void doClickHdrInstructionClose();

        void hideQualityView();

        void openHBR();

        void setOrientation(String str);

        void showHBRChangedTips();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    interface View extends BaseView<Presenter> {
    }
}
