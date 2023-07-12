package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.multiscreen.Client;
import com.yunos.tvhelper.youku.dlna.api.DlnaApiBu;
import com.yunos.tvhelper.youku.dlna.api.DlnaPublic;
import com.yunos.youku.multiscreen.YkMultiscreenEntry;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaContinueProjMgr {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DlnaContinueProjMgr mInst;
    private Client mCurrentClient;
    private PlayerConfig mPlayerConfig;
    private boolean mAttacheDetailActivity = false;
    private boolean mIsNeedSpeed = false;
    private DlnaPublic.IDlnaProjListener mDlnaProjListener = new DlnaPublic.IDlnaProjListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContinueProjMgr.1
        public void onProjExit(DlnaPublic.DlnaProjExitReason dlnaProjExitReason) {
            if (DlnaContinueProjMgr.this.mAttacheDetailActivity || DlnaApiBu.api() == null || DlnaApiBu.api().proj() == null || DlnaApiBu.api().proj().preReq() == null || DlnaApiBu.api().proj().preReq().mMode == DlnaPublic.DlnaProjMode.LIVE_WEEX) {
                return;
            }
            DlnaPublic.DlnaProjMode dlnaProjMode = DlnaApiBu.api().proj().preReq().mMode;
            DlnaPublic.DlnaProjMode dlnaProjMode2 = DlnaPublic.DlnaProjMode.LIVE_PLAYBACK_WEEX;
        }

        public void onProjReqResult(int i) {
            DlnaContinueProjMgr.this.mIsNeedSpeed = false;
        }

        public void onProjReqStart() {
            DlnaContinueProjMgr.this.mIsNeedSpeed = false;
            DlnaContinueProjMgr.this.mCurrentClient = DlnaApiBu.api().proj().req().mDev;
        }

        public void onProjSucc(DlnaPublic.DlnaProjSuccReason dlnaProjSuccReason, DlnaPublic.DlnaProjSuccMode dlnaProjSuccMode) {
        }

        public void onUpdatePlayerAttr(DlnaPublic.DlnaPlayerAttr dlnaPlayerAttr) {
            if (DlnaContinueProjMgr.this.mAttacheDetailActivity || DlnaApiBu.api().proj().req().mMode == DlnaPublic.DlnaProjMode.LIVE_WEEX) {
                return;
            }
            DlnaPublic.DlnaProjMode dlnaProjMode = DlnaApiBu.api().proj().req().mMode;
            DlnaPublic.DlnaProjMode dlnaProjMode2 = DlnaPublic.DlnaProjMode.LIVE_PLAYBACK_WEEX;
        }
    };
    private Object mObject = new Object();

    public DlnaContinueProjMgr() {
        if (YkMultiscreenEntry.isInited()) {
            DlnaApiBu.api().proj().unregisterListenerIf(this.mDlnaProjListener);
            DlnaApiBu.api().proj().registerListener(this.mDlnaProjListener);
        }
    }

    public static DlnaContinueProjMgr getInst() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1418377396")) {
            return (DlnaContinueProjMgr) ipChange.ipc$dispatch("-1418377396", new Object[0]);
        }
        synchronized (DlnaContinueProjMgr.class) {
            if (mInst == null) {
                mInst = new DlnaContinueProjMgr();
            }
        }
        return mInst;
    }

    public void setAttachDetailAcivity(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049584084")) {
            ipChange.ipc$dispatch("1049584084", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mAttacheDetailActivity = z;
        }
    }

    public void setPlayerConfig(PlayerConfig playerConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212007905")) {
            ipChange.ipc$dispatch("212007905", new Object[]{this, playerConfig});
        } else if (this.mPlayerConfig != null) {
        } else {
            PlayerConfig playerConfig2 = new PlayerConfig();
            this.mPlayerConfig = playerConfig2;
            playerConfig2.setCCode(playerConfig.getCCode());
            this.mPlayerConfig.setAppVersion(playerConfig.getAppVersion());
            this.mPlayerConfig.setDynamicProperties(playerConfig.getDynamicProperties());
        }
    }
}
