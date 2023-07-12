package com.youku.live.dago.liveplayback.widget.plugins.dlna.view;

import android.app.Activity;
import android.content.Context;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPreProjHandler;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.DlnaQualityInfo;
import com.youku.multiscreen.Client;
import com.yunos.tvhelper.support.api.SupportApiBu;
import com.yunos.tvhelper.ui.api.UiApiBu;
import com.yunos.tvhelper.ui.api.UiApiDef;
import com.yunos.tvhelper.ui.app.dialog.AppDlg;
import com.yunos.tvhelper.ui.app.dialog.DlgDef;
import com.yunos.tvhelper.ui.app.popup.PopupDef;
import com.yunos.tvhelper.youku.dlna.api.DlnaApiBu;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaDlg {
    private static AppDlg mDlg;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum INSTALL_REASON {
        HIGH_DEFINITION,
        FORBIDDEN_TP,
        COPYRIGHT_DRM
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface QualityListener {
        String onGetCurQuality();

        List<DlnaQualityInfo> onGetQualities();

        void onQualitySelected(Activity activity, DlnaQualityInfo dlnaQualityInfo);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface SpeedListener {
        String onGetCurSpeed();

        void onSpeedSelected(double d);
    }

    private static Client getTVCibnClient(Client client) {
        for (Client client2 : DlnaApiBu.api().devs().devs()) {
            String ip = client2.getIp();
            String manufacturer = client2.getManufacturer();
            if (ip.equals(client.getIp()) && manufacturer.startsWith("www.yunos.com_")) {
                return client2;
            }
        }
        return null;
    }

    public static void installCibnOrOpen(Context context, Client client, DlnaPreProjHandler dlnaPreProjHandler) {
        WeakReference weakReference = new WeakReference(context);
        Client tVCibnClient = getTVCibnClient(client);
        if (tVCibnClient == null) {
            dlnaPreProjHandler.getPresenter().setChangeDevToCibn(client, 4);
            UiApiDef.CibnInstallerOpt cibnInstallerOpt = new UiApiDef.CibnInstallerOpt();
            cibnInstallerOpt.mTargetDev = client;
            cibnInstallerOpt.mScene = UiApiDef.CibnInstallerScene.UPGRADE_TO_CIBN;
            UiApiBu.rinstaller().openCibnInstaller((Activity) weakReference.get(), cibnInstallerOpt);
            return;
        }
        dlnaPreProjHandler.getPreProjInfo().mDev = tVCibnClient;
        dlnaPreProjHandler.start((Activity) weakReference.get());
    }

    public static void openQualityDlg(Context context, QualityListener qualityListener) {
        WeakReference weakReference = new WeakReference(context);
        QualityPopup qualityPopup = new QualityPopup(qualityListener);
        qualityPopup.setCaller((Activity) weakReference.get());
        qualityPopup.prepare();
        qualityPopup.showAsPopup();
    }

    public static void openSpeedDlg(Context context, SpeedListener speedListener) {
    }

    public static void showInstallCibn(Activity activity, YoukuVideoInfo youkuVideoInfo, AlixPlayerContext alixPlayerContext, final INSTALL_REASON install_reason) {
        String str;
        String str2;
        AppDlg appDlg = mDlg;
        if (appDlg == null || !appDlg.isShowing()) {
            final WeakReference weakReference = new WeakReference(activity);
            mDlg = null;
            AppDlg appDlg2 = new AppDlg();
            mDlg = appDlg2;
            appDlg2.setCaller((Activity) weakReference.get());
            mDlg.prepare(new PopupDef.PopupOpt().setCloseOnTouchOutside(true));
            if (install_reason == INSTALL_REASON.FORBIDDEN_TP) {
                str = SupportApiBu.api().orange().multiscreen().copyright_forbidden_msg;
                str2 = SupportApiBu.api().orange().multiscreen().copyright_forbidden_btn;
            } else if (install_reason == INSTALL_REASON.HIGH_DEFINITION) {
                str = SupportApiBu.api().orange().multiscreen().high_definition_msg;
                str2 = SupportApiBu.api().orange().multiscreen().high_definition_btn;
            } else if (install_reason == INSTALL_REASON.COPYRIGHT_DRM) {
                str = SupportApiBu.api().orange().multiscreen().copyright_promote_content;
                str2 = SupportApiBu.api().orange().multiscreen().copyright_promote_btn;
            } else {
                str = SupportApiBu.api().orange().multiscreen().high_definition_msg;
                str2 = SupportApiBu.api().orange().multiscreen().high_definition_btn;
            }
            mDlg.dlgView().setTitle(R.string.dago_dlna_dlg_title_install_cibn).setMsgLayout(R.C7935layout.dago_dlna_dlg_msg).btns().reset().setBtn(DlgDef.DlgBtnId.POSITIVE, str2, (Object) null).setHighlightedBtn(DlgDef.DlgBtnId.POSITIVE);
            ((DlnaDlgView) mDlg.dlgView().msgView(DlnaDlgView.class)).setMsg(str);
            mDlg.setDlgListener(new DlgDef.IAppDlgListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlg.1
                public void onBtnClicked(AppDlg appDlg3, DlgDef.DlgBtnId dlgBtnId, Object obj) {
                    if (INSTALL_REASON.this != INSTALL_REASON.FORBIDDEN_TP) {
                        UiApiBu.trunk().openCibnInstallGuide((Activity) weakReference.get());
                    }
                    AppDlg unused = DlnaDlg.mDlg = null;
                }

                public void onCancelled(AppDlg appDlg3) {
                    AppDlg unused = DlnaDlg.mDlg = null;
                }
            });
            mDlg.showAsPopup();
        }
    }
}
