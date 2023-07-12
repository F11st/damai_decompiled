package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import androidx.annotation.Nullable;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.LogEx;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.PropUtil;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.StrUtil;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.LiveControlInfo;
import com.youku.multiscreen.Client;
import com.yunos.tvhelper.support.api.SupportApiBu;
import com.yunos.tvhelper.ui.api.UiApiDef;
import com.yunos.tvhelper.ui.app.UiAppDef;
import com.yunos.tvhelper.ui.app.preproj.PreProjHandler;
import com.yunos.tvhelper.youku.dlna.api.DlnaPublic;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaPreProjHandler extends PreProjHandler {
    private DlnaPreCallback mDlnaPreCallback;
    private DlnaPreProjInfo mDlnaPreProjInfo;
    private DlnaPlugin mPresenter;
    private DlnaPublic.DlnaProjScene mProjScene;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface DlnaPreCallback {
        void onStartProj(Client client, DlnaPreProjHandler dlnaPreProjHandler);
    }

    public DlnaPreProjHandler(DlnaPlugin dlnaPlugin, DlnaPreProjInfo dlnaPreProjInfo) {
        super(dlnaPreProjInfo);
        this.mPresenter = dlnaPlugin;
        this.mDlnaPreProjInfo = dlnaPreProjInfo;
    }

    public static DlnaPreProjInfo createPreProjInfo(Client client, LiveControlInfo liveControlInfo, DlnaPublic.DlnaProjScene dlnaProjScene, UiAppDef.DevpickerScene devpickerScene) {
        return createPreProjInfo(client, liveControlInfo.livePlayControl.liveId, dlnaProjScene, devpickerScene);
    }

    public static DlnaPreProjInfo createPreProjInfoByVideoInfo(Client client, PlayVideoInfo playVideoInfo, DlnaPublic.DlnaProjScene dlnaProjScene, UiAppDef.DevpickerScene devpickerScene) {
        return createPreProjInfo(client, playVideoInfo.getVid(), dlnaProjScene, devpickerScene);
    }

    public DlnaPreProjInfo getPreProjInfo() {
        return this.mDlnaPreProjInfo;
    }

    public DlnaPlugin getPresenter() {
        return this.mPresenter;
    }

    public DlnaPublic.DlnaProjScene getProjScene() {
        return this.mProjScene;
    }

    public void onDevsSelected(@Nullable Client client, UiApiDef.DevpickerSource devpickerSource) {
        DlnaPublic.DlnaProjScene dlnaProjScene;
        super.onDevsSelected(client, devpickerSource);
        if (client == null) {
            return;
        }
        if (devpickerSource == UiApiDef.DevpickerSource.NORMAL) {
            dlnaProjScene = this.mDlnaPreProjInfo.fromAd ? DlnaPublic.DlnaProjScene.DEVPICKER_AD : DlnaPublic.DlnaProjScene.DEVPICKER;
        } else if (devpickerSource == UiApiDef.DevpickerSource.LAST_USE) {
            dlnaProjScene = this.mDlnaPreProjInfo.fromAd ? DlnaPublic.DlnaProjScene.LASTUSEDEV_AD : DlnaPublic.DlnaProjScene.LASTUSEDEV;
        } else if (devpickerSource == UiApiDef.DevpickerSource.UNKNOWN) {
            dlnaProjScene = this.mDlnaPreProjInfo.mProjScene;
        } else {
            LogEx.i("", "unknown source: " + devpickerSource);
            return;
        }
        this.mProjScene = dlnaProjScene;
        DlnaPlugin dlnaPlugin = this.mPresenter;
        if (dlnaPlugin != null) {
            dlnaPlugin.startProj(client, this);
        } else {
            DlnaPreCallback dlnaPreCallback = this.mDlnaPreCallback;
            if (dlnaPreCallback != null) {
                dlnaPreCallback.onStartProj(client, this);
            }
        }
        DlnaPreProjInfo dlnaPreProjInfo = this.mDlnaPreProjInfo;
        if (dlnaPreProjInfo == null) {
            return;
        }
        SupportApiBu.api().ut().commitEvt("tp_on_select_dev", PropUtil.get(new Properties(), new String[]{"deviceName", client.getName(), "deviceManufacturer", client.getManufacturer(), WXDebugConstants.ENV_DEVICE_MODEL, client.getModel(), "videoTitle", StrUtil.isValidStr(dlnaPreProjInfo.mTitle) ? this.mDlnaPreProjInfo.mTitle : "", "videoId", StrUtil.isValidStr(this.mDlnaPreProjInfo.mVid) ? this.mDlnaPreProjInfo.mVid : "", "videoShowId", StrUtil.isValidStr(this.mDlnaPreProjInfo.mShowId) ? this.mDlnaPreProjInfo.mShowId : ""}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProjFromAd(boolean z) {
        this.mDlnaPreProjInfo.fromAd = z;
    }

    public static DlnaPreProjInfo createPreProjInfo(Client client, String str, DlnaPublic.DlnaProjScene dlnaProjScene, UiAppDef.DevpickerScene devpickerScene) {
        DlnaPreProjInfo dlnaPreProjInfo = new DlnaPreProjInfo();
        dlnaPreProjInfo.mDevpickeScene = devpickerScene;
        dlnaPreProjInfo.mDev = client;
        dlnaPreProjInfo.mTitle = "";
        dlnaPreProjInfo.mVid = str;
        dlnaPreProjInfo.mProjScene = dlnaProjScene;
        dlnaPreProjInfo.mProjMode = DlnaPublic.DlnaProjMode.LIVE_WEEX;
        return dlnaPreProjInfo;
    }

    public DlnaPreProjHandler(DlnaPreProjInfo dlnaPreProjInfo, DlnaPreCallback dlnaPreCallback) {
        super(dlnaPreProjInfo);
        this.mDlnaPreCallback = dlnaPreCallback;
        this.mDlnaPreProjInfo = dlnaPreProjInfo;
    }
}
