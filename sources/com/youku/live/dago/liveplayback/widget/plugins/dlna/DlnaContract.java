package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import android.app.Activity;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.LiveControlInfo;
import com.youku.multiscreen.Client;
import com.yunos.tvhelper.youku.dlna.api.DlnaPublic;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface DlnaContract {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Presenter extends BasePresenter {
        void dlnaChangeQuality(int i);

        void handleDrm(Client client);

        void handleNoCopyRight();

        void handleUpsError(VideoRequestError videoRequestError);

        void installCibn();

        void onControlEnable(boolean z);

        void onCurrentPositionUpdate(int i, int i2);

        void onHide();

        void onHideDlnaPanel();

        void onPlayerPause();

        void onPlayerPlay();

        void onPlayerSpeed(int i);

        void onShowDlnaPanel(DlnaPublic.DlnaProjScene dlnaProjScene);

        void onShowFullScreenDevList();

        void onShowQualityView(Activity activity);

        void retryProj();

        void setChangeDevToCibn(Client client, int i);

        void setProjVideoInfo(LiveControlInfo liveControlInfo);

        boolean shouldFilterHdr();

        boolean shouldShowExit();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface View extends BaseView<Presenter> {
    }
}
