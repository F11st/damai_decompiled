package com.youku.live.dago.widgetlib.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.nav.Nav;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.arch.utils.ContextUtils;
import com.youku.live.dago.utils.DataUtils;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.LiveAppUtil;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dago.widgetlib.view.management.LiveManageController;
import com.youku.live.dago.widgetlib.view.management.LiveManageDialog;
import com.youku.live.dago.widgetlib.view.management.LiveUserInfoData;
import com.youku.live.dago.widgetlib.view.management.LiveUserInfoDataResponse;
import com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView;
import com.youku.live.dago.widgetlib.view.usercard.UserCardApi;
import com.youku.live.dago.widgetlib.view.usercard.UserCardInfo;
import com.youku.live.dago.widgetlib.view.usercard.UserCardTabInfo;
import com.youku.live.dago.widgetlib.view.usercard.UserCardVideo;
import com.youku.live.dago.widgetlib.view.usercard.UserCardVideoList;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.IUser;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.Orientation;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoUserCardDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MSG_USER_CARD_AND_VIDEOS = 257;
    private static final int MSG_USER_CARD_MESSAGE = 258;
    private static final String TAG = "DagoUserCardDialog";
    private static final int USER_CARD_VIDEO_REQUEST_LIMIT = 20;
    private boolean isLinkLiving;
    private volatile boolean isVideosRequesting;
    private String mAnchorId;
    private Handler mHandler;
    private boolean mIsActor;
    private boolean mIsShowChatEntrance;
    private JSCallback mJsCallback;
    protected LiveManageController mLiveManageController;
    protected LiveUserInfoData.InfoData mLiveUserInfoData;
    private String mOperateUserId;
    private String mRoomId;
    private String mScreenId;
    private String mSpmCnt;
    private String mTargetUserId;
    private String mUTPageName;
    private UserCardTabInfo mUserCardTabInfo;
    private DagoUserCardView mUserCardView;
    private boolean showDialog;
    private UserCardApi.UserCardInfoListener userCardInfoListener;
    private DagoUserCardView.OnUserCardListener userCardListener;

    public DagoUserCardDialog(Context context, boolean z) {
        super(context, R.C7944style.dago_pgc_user_card_dialog);
        this.isLinkLiving = false;
        this.mUTPageName = "";
        this.mScreenId = "";
        this.mSpmCnt = "";
        this.mAnchorId = "";
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.component.DagoUserCardDialog.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                boolean z2 = true;
                if (AndroidInstantRuntime.support(ipChange, "-1796092487")) {
                    ipChange.ipc$dispatch("-1796092487", new Object[]{this, message});
                    return;
                }
                int i = message.what;
                if (i != 257) {
                    if (i != 258) {
                        return;
                    }
                    ToastUtil.toast(DagoUserCardDialog.this.getContext(), (String) message.obj);
                    return;
                }
                DagoUserCardDialog.this.mUserCardTabInfo = (UserCardTabInfo) message.obj;
                if (DagoUserCardDialog.this.mUserCardView == null) {
                    DagoUserCardDialog.this.mUserCardView = new DagoUserCardView(DagoUserCardDialog.this.getContext());
                    DagoUserCardDialog.this.mUserCardView.setUserCardViewListener(DagoUserCardDialog.this.userCardListener);
                    DagoUserCardDialog.this.mUserCardView.setShowChatEntrance(DagoUserCardDialog.this.mIsShowChatEntrance);
                }
                if (DataUtils.getLongNumberFromString(DagoUserCardDialog.this.mTargetUserId) <= 0) {
                    if (DagoUserCardDialog.this.mUserCardTabInfo.userCardVO != null) {
                        DagoUserCardDialog.this.mUserCardTabInfo.userCardVO.localType = 2;
                    }
                    DagoUserCardDialog.this.mUserCardView.updateUserCardInfo(DagoUserCardDialog.this.mUserCardTabInfo, true);
                } else {
                    if (DagoUserCardDialog.this.mUserCardTabInfo.userCardVO != null) {
                        if (("" + DagoUserCardDialog.this.mTargetUserId).equals(((IUser) Dsl.getService(IUser.class)).getId())) {
                            DagoUserCardDialog.this.mUserCardTabInfo.userCardVO.localType = 1;
                        } else {
                            DagoUserCardDialog.this.mUserCardTabInfo.userCardVO.localType = 0;
                        }
                    }
                    DagoUserCardDialog.this.mUserCardView.updateUserCardInfo(DagoUserCardDialog.this.mUserCardTabInfo, (DagoUserCardDialog.this.mUserCardTabInfo.userCardVO == null || DagoUserCardDialog.this.mUserCardTabInfo.userCardVO.ytid <= 0) ? false : false);
                }
                if (DagoUserCardDialog.this.showDialog) {
                    DagoUserCardDialog.this.showDialog = false;
                    DagoUserCardDialog.this.show();
                    DagoUserCardDialog.this.requestUserStatus();
                }
            }
        };
        this.userCardInfoListener = new UserCardApi.UserCardInfoListener() { // from class: com.youku.live.dago.widgetlib.component.DagoUserCardDialog.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.view.usercard.UserCardApi.UserCardInfoListener
            public void onError(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1029675227")) {
                    ipChange.ipc$dispatch("-1029675227", new Object[]{this, str});
                    return;
                }
                DagoUserCardDialog.this.isVideosRequesting = false;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 258;
                obtain.obj = str;
                DagoUserCardDialog.this.mHandler.sendMessage(obtain);
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.UserCardApi.UserCardInfoListener
            public void onUserInfo(UserCardInfo userCardInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-532928799")) {
                    ipChange.ipc$dispatch("-532928799", new Object[]{this, userCardInfo});
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.UserCardApi.UserCardInfoListener
            public void onUserTab(UserCardTabInfo userCardTabInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1148739763")) {
                    ipChange.ipc$dispatch("1148739763", new Object[]{this, userCardTabInfo});
                    return;
                }
                DagoUserCardDialog.this.isVideosRequesting = false;
                if (userCardTabInfo != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 257;
                    obtain.obj = userCardTabInfo;
                    DagoUserCardDialog.this.mHandler.sendMessage(obtain);
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.UserCardApi.UserCardInfoListener
            public void onUserVideos(UserCardVideoList userCardVideoList) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1967839026")) {
                    ipChange.ipc$dispatch("1967839026", new Object[]{this, userCardVideoList});
                }
            }
        };
        this.isVideosRequesting = false;
        this.userCardListener = new DagoUserCardView.OnUserCardListener() { // from class: com.youku.live.dago.widgetlib.component.DagoUserCardDialog.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onError(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1255188228")) {
                    ipChange.ipc$dispatch("1255188228", new Object[]{this, str});
                } else if (TextUtils.isEmpty(str)) {
                } else {
                    Message obtain = Message.obtain();
                    obtain.what = 258;
                    obtain.obj = str;
                    DagoUserCardDialog.this.mHandler.sendMessage(obtain);
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onFollowed(Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1097271084")) {
                    ipChange.ipc$dispatch("-1097271084", new Object[]{this, obj});
                    return;
                }
                if (DagoUserCardDialog.this.mJsCallback != null) {
                    DagoUserCardDialog.this.mJsCallback.invoke(obj);
                }
                Message obtain = Message.obtain();
                obtain.what = 258;
                obtain.obj = "关注成功";
                DagoUserCardDialog.this.mHandler.sendMessage(obtain);
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onHomeClicked(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1219544138")) {
                    ipChange.ipc$dispatch("1219544138", new Object[]{this, Long.valueOf(j)});
                } else if (DagoUserCardDialog.this.isLinkLiving) {
                    Message obtain = Message.obtain();
                    obtain.what = 258;
                    obtain.obj = "当前连麦中，功能暂不可用";
                    DagoUserCardDialog.this.mHandler.sendMessage(obtain);
                } else {
                    Nav.from(ContextUtils.getContext(DagoUserCardDialog.this.getContext())).toUri(Uri.parse("youku://personalchannel/openpersonalchannel?uid=" + j));
                    DagoUserCardDialog.this.dismiss();
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onLiveManageClicked() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1319019020")) {
                    ipChange.ipc$dispatch("1319019020", new Object[]{this});
                    return;
                }
                DagoUserCardDialog.this.dismiss();
                LiveManageDialog liveManageDialog = new LiveManageDialog(DagoUserCardDialog.this.getContext(), DagoUserCardDialog.this.mLiveManageController);
                liveManageDialog.setUserInfo(DagoUserCardDialog.this.mRoomId, DagoUserCardDialog.this.mTargetUserId);
                liveManageDialog.setLiveUserInfoData(DagoUserCardDialog.this.mLiveUserInfoData);
                liveManageDialog.show();
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onLoginClicked() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1446889910")) {
                    ipChange.ipc$dispatch("-1446889910", new Object[]{this});
                } else {
                    DagoUserCardDialog.this.dismiss();
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onPrivateChatClicked(long j, boolean z2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "832114476")) {
                    ipChange.ipc$dispatch("832114476", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z2)});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("spm", DagoUserCardDialog.this.mSpmCnt + ".cardim.imbutton");
                hashMap.put("direction", LiveAppUtil.getDirection());
                hashMap.put("spm-name", "cardim");
                hashMap.put("anchor-id", DagoUserCardDialog.this.mAnchorId);
                hashMap.put("roomid", DagoUserCardDialog.this.mRoomId);
                hashMap.put("screenid", DagoUserCardDialog.this.mScreenId);
                ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(DagoUserCardDialog.this.mUTPageName, "cardim_imbutton", hashMap);
                if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_LANDSCAPE) {
                    ToastUtil.showCenter(DagoUserCardDialog.this.getContext(), "该功能横屏下暂不可用");
                } else if (z2) {
                    if (DagoUserCardDialog.this.isLinkLiving) {
                        Message obtain = Message.obtain();
                        obtain.what = 258;
                        obtain.obj = "当前连麦中，功能暂不可用";
                        DagoUserCardDialog.this.mHandler.sendMessage(obtain);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("hiddenSetting", DagoUserCardDialog.this.mIsActor);
                    bundle.putString("from", LiveAppUtil.getFromeName());
                    bundle.putString("pageName", DagoUserCardDialog.this.mUTPageName);
                    bundle.putString("direction", LiveAppUtil.getDirection());
                    bundle.putString("spm-cnt", DagoUserCardDialog.this.mSpmCnt);
                    bundle.putString("anchor-id", DagoUserCardDialog.this.mAnchorId);
                    bundle.putString("roomid", DagoUserCardDialog.this.mRoomId);
                    bundle.putString("screenid", DagoUserCardDialog.this.mScreenId);
                    Nav.from(ContextUtils.getContext(DagoUserCardDialog.this.getContext())).withExtras(bundle).toUri(Uri.parse("youku://messageChatHalfScreen?uid=" + j));
                    DagoUserCardDialog.this.dismiss();
                } else {
                    ToastUtil.toast(DagoUserCardDialog.this.getContext(), "关注才能私聊呦");
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onScrolledBottom() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1304315377")) {
                    ipChange.ipc$dispatch("1304315377", new Object[]{this});
                } else if (DagoUserCardDialog.this.mUserCardTabInfo == null || DagoUserCardDialog.this.mUserCardTabInfo.recDataVO == null || !DagoUserCardDialog.this.mUserCardTabInfo.recDataVO.hasNext || DagoUserCardDialog.this.isVideosRequesting) {
                } else {
                    DagoUserCardDialog.this.isVideosRequesting = true;
                    DagoUserCardDialog dagoUserCardDialog = DagoUserCardDialog.this;
                    dagoUserCardDialog.requestData(dagoUserCardDialog.mTargetUserId, DagoUserCardDialog.this.mUserCardTabInfo.recDataVO.offset);
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.OnUserCardListener
            public void onVideoClicked(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "85252006")) {
                    ipChange.ipc$dispatch("85252006", new Object[]{this, str});
                } else if (DagoUserCardDialog.this.isLinkLiving) {
                    Message obtain = Message.obtain();
                    obtain.what = 258;
                    obtain.obj = "当前连麦中，功能暂不可用";
                    DagoUserCardDialog.this.mHandler.sendMessage(obtain);
                } else if (TextUtils.isEmpty(str)) {
                } else {
                    Nav.from(DagoUserCardDialog.this.getContext()).toUri(Uri.parse("ykshortvideo://video_play?instationType=ZPD&vid=" + str));
                    DagoUserCardDialog.this.dismiss();
                }
            }
        };
        this.showDialog = false;
        this.isLinkLiving = z;
        this.mOperateUserId = ((IUser) Dsl.getService(IUser.class)).getId();
        this.mLiveManageController = new LiveManageController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowLiveManageBtn(LiveUserInfoData.InfoData infoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124290581")) {
            return ((Boolean) ipChange.ipc$dispatch("124290581", new Object[]{this, infoData})).booleanValue();
        }
        if (infoData == null || this.mOperateUserId == null) {
            return false;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "isShowLiveManageBtn mIsActor: " + this.mIsActor + ", isManager: " + LiveManageController.isManager(infoData.operateUserRoles) + ", mTargetUserId: " + this.mTargetUserId + ", myUid: " + this.mOperateUserId);
        return (this.mIsActor || this.mOperateUserId.equals(this.mTargetUserId) || (!LiveManageController.isManager(infoData.operateUserRoles) && !LiveManageController.isActor(infoData.operateUserRoles))) ? false : true;
    }

    private void reportExposure() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968102947")) {
            ipChange.ipc$dispatch("-968102947", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", this.mSpmCnt + ".cardim.imbutton");
        hashMap.put("direction", LiveAppUtil.getDirection());
        hashMap.put("spm-name", "cardim");
        hashMap.put("anchor-id", this.mAnchorId);
        hashMap.put("roomid", this.mRoomId);
        hashMap.put("screenid", this.mScreenId);
        IUserTracker iUserTracker = (IUserTracker) Dsl.getService(IUserTracker.class);
        String str = this.mUTPageName;
        iUserTracker.trackCustom(str, 2201, this.mUTPageName + "_cardim_imbutton", null, null, hashMap);
    }

    private void requestData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1933836861")) {
            ipChange.ipc$dispatch("-1933836861", new Object[]{this, str});
        } else {
            requestData(str, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUserStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-704612122")) {
            ipChange.ipc$dispatch("-704612122", new Object[]{this});
            return;
        }
        LiveManageController liveManageController = this.mLiveManageController;
        if (liveManageController != null) {
            liveManageController.setUserInfo(this.mRoomId, this.mOperateUserId, this.mTargetUserId);
            this.mLiveManageController.requestUserStatus(new INetCallback() { // from class: com.youku.live.dago.widgetlib.component.DagoUserCardDialog.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "991261908")) {
                        ipChange2.ipc$dispatch("991261908", new Object[]{this, iNetResponse});
                    } else if (iNetResponse.isSuccess()) {
                        try {
                            LiveUserInfoDataResponse liveUserInfoDataResponse = (LiveUserInfoDataResponse) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), LiveUserInfoDataResponse.class);
                            if (liveUserInfoDataResponse == null || liveUserInfoDataResponse.data == 0 || DagoUserCardDialog.this.mUserCardView == null) {
                                return;
                            }
                            DagoUserCardDialog dagoUserCardDialog = DagoUserCardDialog.this;
                            dagoUserCardDialog.mLiveUserInfoData = ((LiveUserInfoData) liveUserInfoDataResponse.data).data;
                            DagoUserCardView dagoUserCardView = dagoUserCardDialog.mUserCardView;
                            DagoUserCardDialog dagoUserCardDialog2 = DagoUserCardDialog.this;
                            dagoUserCardView.setShowLiveManageBtn(dagoUserCardDialog2.isShowLiveManageBtn(dagoUserCardDialog2.mLiveUserInfoData));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    private void setDialogWindow() {
        UserCardVideoList userCardVideoList;
        List<UserCardVideo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818662936")) {
            ipChange.ipc$dispatch("1818662936", new Object[]{this});
            return;
        }
        Window window = getWindow();
        if (window != null) {
            if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setWindowAnimations(R.C7944style.dago_pgc_user_card_bottom_anim);
                return;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.gravity = 85;
            UserCardTabInfo userCardTabInfo = this.mUserCardTabInfo;
            if (userCardTabInfo != null && (userCardVideoList = userCardTabInfo.recDataVO) != null && (list = userCardVideoList.itemList) != null && list.size() > 0 && !LiveAppUtil.isStarLive()) {
                attributes2.height = -1;
            } else {
                attributes2.height = -2;
            }
            attributes2.width = -2;
            window.setAttributes(attributes2);
            window.setWindowAnimations(R.C7944style.dago_pgc_user_card_right_anim);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127628041")) {
            ipChange.ipc$dispatch("-2127628041", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        if (this.mUserCardView == null) {
            DagoUserCardView dagoUserCardView = new DagoUserCardView(getContext());
            this.mUserCardView = dagoUserCardView;
            dagoUserCardView.setUserCardViewListener(this.userCardListener);
            this.mUserCardView.setShowChatEntrance(this.mIsShowChatEntrance);
        }
        setContentView(this.mUserCardView);
        setDialogWindow();
    }

    public void setActor(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1304833873")) {
            ipChange.ipc$dispatch("-1304833873", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsActor = z;
        }
    }

    public void setJSCallback(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865994906")) {
            ipChange.ipc$dispatch("-865994906", new Object[]{this, jSCallback});
        } else {
            this.mJsCallback = jSCallback;
        }
    }

    public void setRoomId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113733348")) {
            ipChange.ipc$dispatch("113733348", new Object[]{this, str});
            return;
        }
        this.mRoomId = str;
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "mRoomId: " + this.mRoomId);
    }

    public void setShowChatEntrance(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068805585")) {
            ipChange.ipc$dispatch("-2068805585", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsShowChatEntrance = z;
        DagoUserCardView dagoUserCardView = this.mUserCardView;
        if (dagoUserCardView != null) {
            dagoUserCardView.setShowChatEntrance(z);
        }
    }

    public void setTargetUserId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338920605")) {
            ipChange.ipc$dispatch("-1338920605", new Object[]{this, str});
            return;
        }
        this.mTargetUserId = str;
        long longNumberFromString = DataUtils.getLongNumberFromString(str);
        if (longNumberFromString > 0) {
            requestData(this.mTargetUserId);
            return;
        }
        UserCardTabInfo userCardTabInfo = new UserCardTabInfo();
        UserCardInfo userCardInfo = new UserCardInfo();
        userCardTabInfo.userCardVO = userCardInfo;
        userCardInfo.localType = 2;
        userCardInfo.nickName = "未登录用户";
        userCardInfo.ytid = longNumberFromString;
        userCardInfo.yid = longNumberFromString;
        Message obtain = Message.obtain();
        obtain.what = 257;
        obtain.obj = userCardTabInfo;
        this.mHandler.sendMessage(obtain);
    }

    public void setUTAnchorId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63195147")) {
            ipChange.ipc$dispatch("63195147", new Object[]{this, str});
        } else {
            this.mAnchorId = str;
        }
    }

    public void setUTPageName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136161601")) {
            ipChange.ipc$dispatch("1136161601", new Object[]{this, str});
        } else {
            this.mUTPageName = str;
        }
    }

    public void setUTScreenId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-827208588")) {
            ipChange.ipc$dispatch("-827208588", new Object[]{this, str});
        } else {
            this.mScreenId = str;
        }
    }

    public void setUTSpmCnt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1612863550")) {
            ipChange.ipc$dispatch("-1612863550", new Object[]{this, str});
        } else {
            this.mSpmCnt = str;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1336694715")) {
            ipChange.ipc$dispatch("1336694715", new Object[]{this});
            return;
        }
        try {
            Activity ownerActivity = getOwnerActivity();
            if (ownerActivity != null) {
                if (ownerActivity.isFinishing()) {
                    return;
                }
            }
        } catch (Exception unused) {
        }
        reportExposure();
        super.show();
    }

    public void showDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180401965")) {
            ipChange.ipc$dispatch("-180401965", new Object[]{this});
        } else if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
            this.showDialog = false;
            show();
            requestUserStatus();
        } else {
            this.showDialog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestData(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180628896")) {
            ipChange.ipc$dispatch("180628896", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        UserCardApi userCardApi = new UserCardApi();
        userCardApi.setListener(this.userCardInfoListener);
        userCardApi.requestUserInfoAndVideos(str, i, 20);
    }
}
