package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.LogEx;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.ViewPlaceholder;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract;
import com.yunos.lego.LegoApp;
import com.yunos.tvhelper.ui.bridge.UiBridgeDef;
import com.yunos.tvhelper.ui.bridge.playerprojctrl.PlayerProjCtrlFragment3;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaControlPanelView extends LazyInflatedView implements DlnaContract.View {
    private FragmentActivity mActivity;
    private AlixPlayerContext mPlayerContext;
    private DlnaContract.Presenter mPresenter;
    private UiBridgeDef.IPlayerProjPlugin3 mProjPlugin3;

    public DlnaControlPanelView(AlixPlayerContext alixPlayerContext, ILMLayerManager<ViewGroup> iLMLayerManager, String str, int i, ViewPlaceholder viewPlaceholder) {
        super(alixPlayerContext, iLMLayerManager, str, i, viewPlaceholder);
        this.mProjPlugin3 = new UiBridgeDef.IPlayerProjPlugin3() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaControlPanelView.2
            private static transient /* synthetic */ IpChange $ipChange;

            public void onCloseProjPanel() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1375451317")) {
                    ipChange.ipc$dispatch("-1375451317", new Object[]{this});
                    return;
                }
                DlnaControlPanelView.this.mPresenter.onHideDlnaPanel();
                DlnaControlPanelView.this.showDlnaControlPanel(false);
            }

            public void onProjDefinitionPicker() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "324903292")) {
                    ipChange.ipc$dispatch("324903292", new Object[]{this});
                } else {
                    DlnaControlPanelView.this.mPresenter.onShowQualityView(null);
                }
            }

            public void onProjDevPicker() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1677557974")) {
                    ipChange.ipc$dispatch("-1677557974", new Object[]{this});
                } else {
                    DlnaControlPanelView.this.mPresenter.onShowFullScreenDevList();
                }
            }

            public void onProjInstallCibn() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "868340352")) {
                    ipChange.ipc$dispatch("868340352", new Object[]{this});
                } else {
                    DlnaControlPanelView.this.mPresenter.installCibn();
                }
            }

            public void onProjLangPicker() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-601853631")) {
                    ipChange.ipc$dispatch("-601853631", new Object[]{this});
                }
            }

            public void onProjPlaySpeedPicker() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-20499060")) {
                    ipChange.ipc$dispatch("-20499060", new Object[]{this});
                }
            }

            public void onProjRetry() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "833691493")) {
                    ipChange.ipc$dispatch("833691493", new Object[]{this});
                } else {
                    DlnaControlPanelView.this.mPresenter.retryProj();
                }
            }

            public boolean shouldShowClosePanel() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "597891457") ? ((Boolean) ipChange.ipc$dispatch("597891457", new Object[]{this})).booleanValue() : DlnaControlPanelView.this.mPresenter.shouldShowExit();
            }
        };
        this.mActivity = (FragmentActivity) alixPlayerContext.getActivity();
        this.mPlayerContext = alixPlayerContext;
    }

    private void initUI(View view) {
    }

    @Nullable
    private PlayerProjCtrlFragment3 projCtrlFragment() {
        return this.mActivity.getSupportFragmentManager().findFragmentById(R.id.dlna_control_panel_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDlnaControlPanel(boolean z) {
        String tag = tag();
        LogEx.i(tag, "hit, show: " + z + ", orient: " + LegoApp.ctx().getResources().getConfiguration().orientation);
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity == null) {
            LogEx.i(tag(), "null activity");
        } else if (fragmentActivity.isFinishing()) {
            LogEx.w(tag(), "activity is finishing");
        } else if (Build.VERSION.SDK_INT >= 17 && this.mActivity.isDestroyed()) {
            LogEx.w(tag(), "is destroyed");
        } else {
            try {
                Fragment projCtrlFragment = projCtrlFragment();
                FragmentTransaction beginTransaction = this.mActivity.getSupportFragmentManager().beginTransaction();
                if (projCtrlFragment != null) {
                    beginTransaction.remove(projCtrlFragment);
                }
                if (z) {
                    PlayerProjCtrlFragment3 create = PlayerProjCtrlFragment3.create();
                    create.setPlugin(this.mProjPlugin3);
                    beginTransaction.replace(R.id.dlna_control_panel_container, create);
                }
                beginTransaction.commitAllowingStateLoss();
            } catch (Exception unused) {
            }
        }
    }

    private String tag() {
        return LogEx.tag(this);
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void hide() {
        super.hide();
        showDlnaControlPanel(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hidePopupWindow() {
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    protected void onInflate(View view) {
        initUI(view);
        this.mInflatedView.setOnTouchListener(new View.OnTouchListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaControlPanelView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1779370791")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1779370791", new Object[]{this, view2, motionEvent})).booleanValue();
                }
                Log.i(LazyInflatedView.TAG, "TOUCH DLNA PANEL");
                return false;
            }
        });
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void show() {
        super.show();
        showDlnaControlPanel(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void toggleInstallCibn(boolean z) {
        PlayerProjCtrlFragment3 projCtrlFragment = projCtrlFragment();
        if (projCtrlFragment != null) {
            projCtrlFragment.toggleInstallCibn(z);
        }
    }

    void updateSpeed(String str) {
        PlayerProjCtrlFragment3 projCtrlFragment = projCtrlFragment();
        if (projCtrlFragment != null) {
            projCtrlFragment.updatePlaySpeed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void volumeDown() {
        PlayerProjCtrlFragment3 projCtrlFragment = projCtrlFragment();
        if (projCtrlFragment != null) {
            projCtrlFragment.volumeDown(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void volumeUp() {
        PlayerProjCtrlFragment3 projCtrlFragment = projCtrlFragment();
        if (projCtrlFragment != null) {
            projCtrlFragment.volumeUp(true);
        }
    }

    @Override // com.youku.alixplugin.view.BaseView
    public void setPresenter(DlnaContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
