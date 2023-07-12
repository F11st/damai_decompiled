package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.app.widget.DMDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.kcrason.dynamicpagerindicatorlibrary.DynamicPagerIndicator;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.update.utils.ErrorCode;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import com.youku.live.dago.utils.ColorUtil;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.NestViewPager;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.CommonAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftShowAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftViewPagerAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftCategoryBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPosition;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView;
import com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView;
import com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.ParticleSystem;
import com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton;
import com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.Floating;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.FloatingBuilder;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition;
import com.youku.live.dago.widgetlib.interactive.gift.view.indicator.YKLPagerTabIndicator;
import com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.NoScrollGridView;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.YKLGiftPageView;
import com.youku.live.dago.widgetlib.interactive.utils.AnimUitls;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.GiftUTUtils;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import com.youku.live.dago.widgetlib.interactive.utils.VibrateUtil;
import com.youku.live.dago.widgetlib.util.OrangeUtil;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tb.h62;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SendGiftWindow extends FrameLayout implements ParticleSendGiftButton.OnSendListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = SendGiftWindow.class.getSimpleName();
    private final int DISPLAY_GIFT_BOARD;
    private final int DISPLAY_NUM_KEY_BOARD;
    private final String YKPACKAGE;
    private long allCombNum;
    private long allSendNum;
    private String args;
    List<GiftCategoryBean> categoryGiftBeanArrayList;
    private boolean closeAll;
    private String combRatio;
    private boolean hasPack;
    private boolean hasPackTip;
    private boolean isClosing;
    private int isNewComb;
    private boolean isOldSend;
    private boolean isShowCombo;
    private boolean isShowProp;
    private FrameLayout mBlankView;
    private GiftNumKeyBoardView.ClickSureListener mClickSureListener;
    private CombFloatingView mCombFloatingView;
    private CombWaveView mCombWaveView;
    private int mComboInterval;
    private Context mContext;
    private String mCurrentGroupId;
    private int mCurrentTabPosition;
    private String mCurrentTitle;
    private Floating mFloating;
    private TUrlImageView mGestureIndicator;
    private LinearLayout mGestureIndicatorContainer;
    private ArrayList<GiftBaseView> mGiftBaseViews;
    private IGiftBoardCallback mGiftBoardCallback;
    private RelativeLayout mGiftBoardLayout;
    private ViewGroup mGiftBoardRootView;
    private GiftNumSelectView mGiftNumSelectView;
    private int mGiftRowNum;
    private LinearLayout mGiftShowLayout;
    private GiftStateLayout mGiftStateLayout;
    private GiftViewPagerAdapter mGiftViewAdapter;
    private boolean mHasStarGift;
    private boolean mIsLandscape;
    private String mLastSelectedGid;
    private String mLastSelectedPid;
    private MultiTargetListView mMultiTargetLayout;
    private GiftNumKeyBoardView mNumkeyboardView;
    private OnGestureGiftDetectedListener mOnGestureGiftDetectedListener;
    private GiftNumSelectView.OnGiftNumClickListener mOnGiftNumClickListener;
    private GiftStateLayout.OnGiftStateClickListener mOnGiftStateClickListener;
    private ImageView mPackIndicator;
    private View mPackLayout;
    private TextView mPackText;
    private View mPackTipRedPoint;
    private View mParticlePoint;
    private GiftStateLayout.OnPropClickListener mPropClickListener;
    private PropShowView.PropListener mPropListener;
    private PropShowView mPropPagerView;
    private View mRefreshBtn;
    private View mRefreshLayout;
    private String mRoomId;
    private FrameLayout mRootView;
    private String mScreenId;
    private GiftInfoBean mSelectedGiftInfoBean;
    private long mSelectedNum;
    private String mSelectedTargetIds;
    private ParticleSendGiftButton mSendGiftButton;
    private View mShotPoint;
    private boolean mShowTargetDetails;
    private MultiTargetListView.EventListener mTargetLayoutListner;
    private ArrayList<String> mTitles;
    private NestViewPager mViewPager;
    private ViewSwitcher mViewSwitcher;
    private YKLPagerTabIndicator mYKLPagerTabIndicator;
    private long maxCombNum;
    private int numBottom;
    private int roomType;
    private ArrayList<Integer> selPositions;
    private int y;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnGestureGiftDetectedListener {
        void onGestureGiftDetected(List<GiftInfoBean> list, int i, List<GiftTargetInfoBean> list2);
    }

    public SendGiftWindow(@NonNull Context context) {
        super(context);
        this.DISPLAY_GIFT_BOARD = 0;
        this.DISPLAY_NUM_KEY_BOARD = 1;
        this.mGiftRowNum = 2;
        this.mSelectedGiftInfoBean = null;
        this.mSelectedNum = 1L;
        this.mGiftBaseViews = new ArrayList<>();
        this.mTitles = new ArrayList<>();
        this.categoryGiftBeanArrayList = new ArrayList();
        this.selPositions = new ArrayList<>();
        this.mLastSelectedGid = null;
        this.mLastSelectedPid = null;
        this.args = "";
        this.mScreenId = "";
        this.mIsLandscape = false;
        this.mComboInterval = 10;
        this.mCurrentGroupId = "";
        this.mCurrentTitle = "";
        this.mSelectedTargetIds = "";
        this.mRoomId = "";
        this.isShowCombo = false;
        this.isShowProp = false;
        this.hasPack = false;
        this.hasPackTip = false;
        this.mCurrentTabPosition = 0;
        this.isClosing = false;
        this.isNewComb = 1;
        this.mTargetLayoutListner = new MultiTargetListView.EventListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onClick(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1827109741")) {
                    ipChange.ipc$dispatch("1827109741", new Object[]{this, giftTargetInfoBean});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onExposed(List<GiftTargetInfoBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1374779564")) {
                    ipChange.ipc$dispatch("1374779564", new Object[]{this, list});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void openUserCard(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1372192131")) {
                    ipChange.ipc$dispatch("1372192131", new Object[]{this, giftTargetInfoBean});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || giftTargetInfoBean == null) {
                } else {
                    SendGiftWindow.this.mGiftBoardCallback.openUserCard(giftTargetInfoBean.id);
                }
            }
        };
        this.mPropListener = new PropShowView.PropListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void morePropBtnClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-13246677")) {
                    ipChange.ipc$dispatch("-13246677", new Object[]{this});
                    return;
                }
                GiftUTUtils.taskBoardClick();
                if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.morePropBtnClick();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onChildPageChange(int i, List<GiftPropBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-424566955")) {
                    ipChange.ipc$dispatch("-424566955", new Object[]{this, Integer.valueOf(i), list});
                } else {
                    GiftUTUtils.propPageChange(list);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemChecked(GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2005935740")) {
                    ipChange.ipc$dispatch("2005935740", new Object[]{this, giftPropBean});
                } else if (giftPropBean != null) {
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(giftPropBean.isGift(), giftPropBean.expire, giftPropBean.btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j, CommonAdapter<GiftPropBean> commonAdapter) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1407602716")) {
                    ipChange.ipc$dispatch("1407602716", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j), commonAdapter});
                } else if (SendGiftWindow.this.mPropPagerView.getSeletedProp() != null) {
                    GiftUTUtils.propItemClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(SendGiftWindow.this.mPropPagerView.getSeletedProp().isGift(), SendGiftWindow.this.mPropPagerView.getSeletedProp().expire, SendGiftWindow.this.mPropPagerView.getSeletedProp().btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onRefresh() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1771197439")) {
                    ipChange.ipc$dispatch("1771197439", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.refresh(true);
                }
            }
        };
        this.mOnGiftStateClickListener = new GiftStateLayout.OnGiftStateClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onRechargeClick(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "235951295")) {
                    ipChange.ipc$dispatch("235951295", new Object[]{this, Boolean.valueOf(z)});
                } else {
                    SendGiftWindow.this.recharge();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onSendGiftClick(long j) {
                int i;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-259271266")) {
                    ipChange.ipc$dispatch("-259271266", new Object[]{this, Long.valueOf(j)});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean == null) {
                } else {
                    try {
                        i = Integer.parseInt(SendGiftWindow.this.mSelectedGiftInfoBean.coins);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        i = 0;
                    }
                    if (i > 0) {
                        SendGiftWindow.this.showDmDialog("大麦暂不支持赠送付费礼物，请去优酷app赠送");
                        return;
                    }
                    if (!SendGiftWindow.this.checkCost()) {
                        GiftUTUtils.comboExpose(SendGiftWindow.this.mSelectedGiftInfoBean);
                        if (SendGiftWindow.this.mSelectedNum == 1 && SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.girdViewType != 1) {
                            if (SendGiftWindow.this.mSelectedGiftInfoBean.continuousSend) {
                                SendGiftWindow.this.mSendGiftButton.show();
                                SendGiftWindow.this.isShowCombo = true;
                                SendGiftWindow.this.mGiftStateLayout.setSendBtnVisible(false);
                            } else {
                                ((ILog) Dsl.getService(ILog.class)).i(SendGiftWindow.TAG, "不支持连送");
                                return;
                            }
                        }
                    }
                    SendGiftWindow.this.sendGift();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onShowGiftNumConfig() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-303073797")) {
                    ipChange.ipc$dispatch("-303073797", new Object[]{this});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.multiSend) {
                    if (SendGiftWindow.this.mSelectedGiftInfoBean.numList == null || SendGiftWindow.this.mSelectedGiftInfoBean.numList.size() <= 0) {
                        SendGiftWindow.this.displaySimulationKeyBord();
                    } else {
                        SendGiftWindow.this.showGiftNumListView(true);
                    }
                }
            }
        };
        this.numBottom = -1;
        this.mPropClickListener = new GiftStateLayout.OnPropClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onPropMissionClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-48200519")) {
                    ipChange.ipc$dispatch("-48200519", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.doTaskClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftBoardCallback.onDoMission(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onSendPropClick(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "228754862")) {
                    ipChange.ipc$dispatch("228754862", new Object[]{this, Integer.valueOf(i)});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.sendPropClickMulti(SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                    if (i < 1) {
                        i = 1;
                    }
                    SendGiftWindow.this.mGiftBoardCallback.onSendProp(i, SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onShowNumKeyBoard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "749278946")) {
                    ipChange.ipc$dispatch("749278946", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mOnGiftNumClickListener = new GiftNumSelectView.OnGiftNumClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onNumPannelclose() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1310051711")) {
                    ipChange.ipc$dispatch("1310051711", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "onNumPannelclose");
                SendGiftWindow.this.mGiftStateLayout.setArrOrientation(false);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onSelectedNum(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1481416349")) {
                    ipChange.ipc$dispatch("1481416349", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                SendGiftWindow.this.mSelectedNum = i;
                SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onShowCustomNumKeyboard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1551828814")) {
                    ipChange.ipc$dispatch("-1551828814", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mClickSureListener = new GiftNumKeyBoardView.ClickSureListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.12
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.ClickSureListener
            public void onNumConfirm(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "955782180")) {
                    ipChange.ipc$dispatch("955782180", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                if (j != 0) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "onNumConfirm  = " + SendGiftWindow.this.isShowProp);
                    if (SendGiftWindow.this.isShowProp) {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update PROP num  = " + j);
                        SendGiftWindow.this.mGiftStateLayout.setSelPropNum(j);
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update gift num  = " + j);
                        SendGiftWindow.this.mSelectedNum = j;
                        SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
                    }
                }
                SendGiftWindow.this.switchDisplayBoard(0);
            }
        };
        this.YKPACKAGE = AXPParamsProvider.ClientType.YOUKU;
        this.mContext = context;
        initView(context);
    }

    private void UTSendCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862000220")) {
            ipChange.ipc$dispatch("-862000220", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("send_count", this.allSendNum + "");
        hashMap.put("combo_count", this.allCombNum + "");
        hashMap.put("combo_proportion", this.combRatio);
        hashMap.put("max_combo", this.maxCombNum + "");
        hashMap.put("isNew", this.isNewComb + "");
        GiftUTUtils.allSendCount(hashMap);
        this.allSendNum = 0L;
        this.allCombNum = 0L;
        this.combRatio = "0";
        this.maxCombNum = 0L;
    }

    private void calculateSendNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073092803")) {
            ipChange.ipc$dispatch("-2073092803", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        long j = this.allSendNum + 1;
        this.allSendNum = j;
        if (1 != i) {
            if (2 == i) {
                this.allCombNum++;
            }
            this.allCombNum++;
        }
        long j2 = i;
        if (j2 >= this.maxCombNum) {
            this.maxCombNum = j2;
        }
        if (0 != j) {
            this.combRatio = new DecimalFormat("#0.00").format(this.allCombNum / this.allSendNum);
        }
    }

    private ParticleSystem createBomShot(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952430430")) {
            return (ParticleSystem) ipChange.ipc$dispatch("-1952430430", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        ParticleSystem particleSystem = new ParticleSystem(this, 2, UIUtil.zoomImage(i, UIUtil.dip2px(i2), UIUtil.dip2px(i3)), i4);
        particleSystem.setScaleRange(0.4f, 0.7f);
        particleSystem.setSpeedModuleAndAngleRange(0.7f, 1.0f, -100, ErrorCode.ERROR_MD5_UPDATE);
        particleSystem.setRotationSpeedRange(90.0f, 180.0f);
        particleSystem.setAcceleration(0.003f, 80);
        particleSystem.setFadeOut(getRandomAlpha(), 400L, new AccelerateInterpolator());
        return particleSystem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displaySimulationKeyBord() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "497215337")) {
            ipChange.ipc$dispatch("497215337", new Object[]{this});
        } else {
            switchDisplayBoard(1);
        }
    }

    private float getRandomAlpha() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1100473079") ? ((Float) ipChange.ipc$dispatch("-1100473079", new Object[]{this})).floatValue() : (new Random().nextFloat() * 0.4f) + 0.4f;
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392306879")) {
            ipChange.ipc$dispatch("392306879", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_board_layout, this);
        this.mYKLPagerTabIndicator = (YKLPagerTabIndicator) findViewById(R.id.id_pager_s_t_s);
        this.mRootView = (FrameLayout) findViewById(R.id.root_view);
        this.mGiftBoardRootView = (ViewGroup) findViewById(R.id.id_gift_board);
        this.mGiftBoardLayout = (RelativeLayout) findViewById(R.id.gift_board_layout);
        GiftNumKeyBoardView giftNumKeyBoardView = (GiftNumKeyBoardView) findViewById(R.id.id_num_keyboard);
        this.mNumkeyboardView = giftNumKeyBoardView;
        giftNumKeyBoardView.setVisibility(8);
        this.mNumkeyboardView.setClickSureListener(this.mClickSureListener);
        Floating floating = new Floating(this.mContext);
        this.mFloating = floating;
        floating.setFloatingDecorView(this.mRootView);
        this.mCombWaveView = (CombWaveView) findViewById(R.id.combWaveView);
        this.mShotPoint = findViewById(R.id.shotPoint);
        this.mParticlePoint = findViewById(R.id.particlePoint);
        this.mCombFloatingView = new CombFloatingView(this.mContext);
        this.mViewPager = (NestViewPager) findViewById(R.id.id_view_pager);
        this.mBlankView = (FrameLayout) findViewById(R.id.id_space);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.gesture_indicator_container);
        this.mGestureIndicatorContainer = linearLayout;
        linearLayout.setVisibility(4);
        this.mGestureIndicator = (TUrlImageView) findViewById(R.id.gesture_gift_indicator);
        this.mGiftStateLayout = (GiftStateLayout) findViewById(R.id.id_gift_state_layout);
        this.mGiftShowLayout = (LinearLayout) findViewById(R.id.id_gift_show_layout);
        GiftNumSelectView giftNumSelectView = (GiftNumSelectView) findViewById(R.id.gift_num_select_layout);
        this.mGiftNumSelectView = giftNumSelectView;
        giftNumSelectView.setOnGiftConfigClickListener(this.mOnGiftNumClickListener);
        this.mViewSwitcher = (ViewSwitcher) findViewById(R.id.id_view_switcher_id);
        this.mSendGiftButton = (ParticleSendGiftButton) findViewById(R.id.id_gift_send_bt);
        this.mRefreshBtn = findViewById(R.id.refresh_btn);
        this.mRefreshLayout = findViewById(R.id.refresh_layout);
        this.mSendGiftButton.setOnSendListener(this);
        this.mPropPagerView = (PropShowView) findViewById(R.id.id_view_prop_pager);
        this.mPackTipRedPoint = findViewById(R.id.id_pack_tip_red_point);
        this.mPackText = (TextView) findViewById(R.id.id_pack_text);
        this.mPackIndicator = (ImageView) findViewById(R.id.id_pack_indicator);
        View findViewById = findViewById(R.id.id_pack_layout);
        this.mPackLayout = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "309939228")) {
                    ipChange2.ipc$dispatch("309939228", new Object[]{this, view});
                    return;
                }
                GiftUTUtils.propTabClick();
                SendGiftWindow.this.switchPropPannel(true);
            }
        });
        this.mRefreshBtn.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1873737699")) {
                    ipChange2.ipc$dispatch("-1873737699", new Object[]{this, view});
                } else if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.refresh(false);
                    SendGiftWindow.this.showRefreshLayout(false);
                }
            }
        });
        ur1.o().s(h62.p("dago_pgc_ykl_gesture_enter_indicator")).y(this.mGestureIndicator);
        this.mBlankView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange2, "237552670")) {
                    ipChange2.ipc$dispatch("237552670", new Object[]{this, view});
                } else if (SendGiftWindow.this.mGestureIndicatorContainer.getVisibility() == 0) {
                    List<GiftCategoryBean> giftCategoryList = GiftDataManager.getInstance().getGiftCategoryList();
                    List<GiftInfoBean> arrayList = new ArrayList<>();
                    for (GiftCategoryBean giftCategoryBean : giftCategoryList) {
                        Iterator<GiftInfoBean> it = giftCategoryBean.giftInfos.iterator();
                        while (it.hasNext()) {
                            GiftInfoBean next = it.next();
                            if (next.checkGiftTag(GiftInfoBean.GiftTag.GRAFFITI)) {
                                arrayList.add(next);
                                if (SendGiftWindow.this.mSelectedGiftInfoBean != null && (SendGiftWindow.this.mSelectedGiftInfoBean == next || SendGiftWindow.this.mSelectedGiftInfoBean.id.equals(next.id))) {
                                    i = arrayList.indexOf(next);
                                }
                            }
                        }
                    }
                    if (arrayList.size() <= 0 || SendGiftWindow.this.mOnGestureGiftDetectedListener == null) {
                        return;
                    }
                    SendGiftWindow.this.mOnGestureGiftDetectedListener.onGestureGiftDetected(arrayList, i, SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                } else {
                    SendGiftWindow.this.dismiss();
                }
            }
        });
        MultiTargetListView multiTargetListView = (MultiTargetListView) findViewById(R.id.id_multi_targetview);
        this.mMultiTargetLayout = multiTargetListView;
        multiTargetListView.setEventListener(this.mTargetLayoutListner);
        this.mViewSwitcher.setAnimateFirstView(false);
        setOrangeSendType();
        setWaveViewStyle();
        setFloatingViewParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275851739")) {
            return ((Boolean) ipChange.ipc$dispatch("1275851739", new Object[]{this, context, str})).booleanValue();
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recharge() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710926103")) {
            ipChange.ipc$dispatch("710926103", new Object[]{this});
            return;
        }
        showDmDialog("大麦暂不支持充值，请去优酷app操作");
        GiftUTUtils.rechargeClick();
        IGiftBoardCallback iGiftBoardCallback = this.mGiftBoardCallback;
        if (iGiftBoardCallback != null) {
            iGiftBoardCallback.onRecharge();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGift() {
        GiftInfoBean giftInfoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267107142")) {
            ipChange.ipc$dispatch("267107142", new Object[]{this});
            return;
        }
        long tvNum = this.mGiftStateLayout.getTvNum();
        this.mSelectedNum = tvNum;
        IGiftBoardCallback iGiftBoardCallback = this.mGiftBoardCallback;
        if (iGiftBoardCallback == null || (giftInfoBean = this.mSelectedGiftInfoBean) == null) {
            return;
        }
        iGiftBoardCallback.onSendGift(tvNum, giftInfoBean, this.mMultiTargetLayout.getTargetInfos());
    }

    private void sendRedPacket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114111483")) {
            ipChange.ipc$dispatch("1114111483", new Object[]{this});
        }
    }

    private void sendStar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657507100")) {
            ipChange.ipc$dispatch("-1657507100", new Object[]{this});
        } else if (this.mGiftViewAdapter != null) {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "gift 这里这么获取roomid");
            if (this.mGiftViewAdapter.getStarItemView() == null || TextUtils.isEmpty(this.mRoomId)) {
                return;
            }
            this.mGiftViewAdapter.getStarItemView().sendStar(this.mRoomId);
        }
    }

    private void setFloatingViewParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1270629465")) {
            ipChange.ipc$dispatch("1270629465", new Object[]{this});
            return;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            this.mCombFloatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mCombFloatingView.bringToFront();
            ((FrameLayout) ((Activity) context).getWindow().getDecorView()).addView(this.mCombFloatingView);
        }
    }

    private void setOrangeSendType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "729205882")) {
            ipChange.ipc$dispatch("729205882", new Object[]{this});
            return;
        }
        this.isOldSend = !OrangeUtil.isOpenNewCombSend();
        GiftStateLayout giftStateLayout = this.mGiftStateLayout;
        if (giftStateLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) giftStateLayout.getLayoutParams();
            layoutParams.height = UIUtil.dip2px(this.isOldSend ? 50 : 65);
            this.mGiftStateLayout.setLayoutParams(layoutParams);
            this.mGiftStateLayout.setChildLayoutParams(this.isOldSend);
        }
        ParticleSendGiftButton particleSendGiftButton = this.mSendGiftButton;
        if (particleSendGiftButton != null) {
            particleSendGiftButton.isOldSend(this.isOldSend);
        }
        GiftNumSelectView giftNumSelectView = this.mGiftNumSelectView;
        if (giftNumSelectView != null) {
            giftNumSelectView.setChildLayoutParams(this.isOldSend);
        }
    }

    private void setWaveViewStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451954861")) {
            ipChange.ipc$dispatch("1451954861", new Object[]{this});
            return;
        }
        CombWaveView combWaveView = this.mCombWaveView;
        if (combWaveView != null) {
            combWaveView.setColor(Color.parseColor("#66860dab"));
            this.mCombWaveView.setStyle(Paint.Style.STROKE);
            this.mCombWaveView.setInitialRadius(UIUtil.dip2px(37));
            this.mCombWaveView.setMaxRadius(UIUtil.dip2px(54));
            this.mCombWaveView.setInterpolator(new AccelerateInterpolator(1.0f));
            this.mCombWaveView.setPaintWidth(UIUtil.dip2px(3));
            this.mCombWaveView.setDuration(450L);
            this.mCombWaveView.setSpeed(150);
        }
    }

    private void showDialogCharge() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618436549")) {
            ipChange.ipc$dispatch("1618436549", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDmDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084976038")) {
            ipChange.ipc$dispatch("-1084976038", new Object[]{this, str});
        } else {
            new DMDialog(this.mContext).n("打开优酷", new DialogInterface.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.14
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1238971613")) {
                        ipChange2.ipc$dispatch("-1238971613", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                        return;
                    }
                    dialogInterface.dismiss();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    SendGiftWindow sendGiftWindow = SendGiftWindow.this;
                    if (sendGiftWindow.isAppInstalled(sendGiftWindow.mContext, AXPParamsProvider.ClientType.YOUKU)) {
                        intent.setData(Uri.parse("http://vku.youku.com/live/ilproom?id=" + SendGiftWindow.this.mRoomId));
                        intent.setPackage(AXPParamsProvider.ClientType.YOUKU);
                        SendGiftWindow.this.mContext.startActivity(intent);
                        return;
                    }
                    intent.setData(Uri.parse("market://details?id=com.youku.phone"));
                    if (intent.resolveActivity(SendGiftWindow.this.mContext.getPackageManager()) != null) {
                        SendGiftWindow.this.mContext.startActivity(intent);
                    }
                }
            }).i("取消", new DialogInterface.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2086414660")) {
                        ipChange2.ipc$dispatch("2086414660", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }).q(str).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGiftNumListView(boolean z) {
        List<GiftNumBean> list;
        FrameLayout.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443686364")) {
            ipChange.ipc$dispatch("-1443686364", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (this.mIsLandscape) {
            if (this.numBottom == -1) {
                this.numBottom = this.mGiftBoardRootView.getBottom() - this.mGiftStateLayout.getBottom();
            }
            if (this.numBottom > 0 && (layoutParams = (FrameLayout.LayoutParams) this.mGiftNumSelectView.getLayoutParams()) != null && layoutParams.bottomMargin == 0) {
                layoutParams.bottomMargin = this.numBottom;
                this.mGiftNumSelectView.setLayoutParams(layoutParams);
            }
        }
        if (this.mSelectedGiftInfoBean == null) {
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "Open showGiftNumListView isShow = " + z);
        if (z && this.mGiftNumSelectView.getVisibility() == 0) {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "mGiftNumSelectView.getVisibility() == VISIBLE");
            return;
        }
        if (z && (list = this.mSelectedGiftInfoBean.numList) != null && !list.isEmpty()) {
            this.mGiftNumSelectView.setData(this.mSelectedGiftInfoBean.numList);
        }
        this.mGiftNumSelectView.setVisibility(z ? 0 : 8);
        this.mGiftStateLayout.setArrOrientation(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRefreshLayout(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051691440")) {
            ipChange.ipc$dispatch("-2051691440", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mRefreshLayout.setVisibility(0);
            this.mGiftShowLayout.setVisibility(4);
            this.mSendGiftButton.setVisibility(4);
            this.mGiftStateLayout.setVisibility(4);
        } else {
            this.mRefreshLayout.setVisibility(8);
            this.mGiftShowLayout.setVisibility(0);
            this.mSendGiftButton.setVisibility(0);
            this.mGiftStateLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBomShot() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1601900154")) {
            ipChange.ipc$dispatch("-1601900154", new Object[]{this});
            return;
        }
        ParticleSystem createBomShot = createBomShot(R.drawable.dago_pgc_combsend_heart, 50, 50, 500);
        ParticleSystem createBomShot2 = createBomShot(R.drawable.dago_pgc_combsend_laugh, 50, 50, 500);
        ParticleSystem createBomShot3 = createBomShot(R.drawable.dago_pgc_combsend_like, 50, 50, 500);
        if (createBomShot != null) {
            createBomShot.oneShot(this.mParticlePoint, 2);
        }
        if (createBomShot2 != null) {
            createBomShot2.oneShot(this.mParticlePoint, 2);
        }
        if (createBomShot3 != null) {
            createBomShot3.oneShot(this.mParticlePoint, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGiftIconFloating() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737977179")) {
            ipChange.ipc$dispatch("737977179", new Object[]{this});
        } else if (this.mSelectedGiftInfoBean == null) {
        } else {
            CombGiftView combGiftView = new CombGiftView(this.mContext);
            combGiftView.setData(this.mSelectedGiftInfoBean);
            FloatingBuilder targetView = new FloatingBuilder().anchorView(this.mShotPoint).targetView(combGiftView);
            Context context = this.mContext;
            this.mFloating.startFloating(targetView.floatingTransition(new CombSendFloatingTransition(context, this.y, UIUtil.getScreenWidth(context), UIUtil.getFullActivityHeight(this.mContext), this.mIsLandscape)).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchDisplayBoard(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958112899")) {
            ipChange.ipc$dispatch("-958112899", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "switchDisplayBoard mIsLandscape = " + this.mIsLandscape);
        if (i == 0) {
            AnimUitls.switchGiftBoardView(this.mRootView, this.mNumkeyboardView, this.mIsLandscape);
        } else if (i != 1) {
        } else {
            AnimUitls.switchKeyBoardView(this.mNumkeyboardView, this.mRootView, this.mIsLandscape);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchSendButtonState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510121365")) {
            ipChange.ipc$dispatch("-510121365", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        GiftInfoBean giftInfoBean = this.mSelectedGiftInfoBean;
        if (giftInfoBean != null && giftInfoBean.girdViewType == 1) {
            this.mGiftStateLayout.switchSendButton(false);
            this.mSendGiftButton.switchSendBtnStyle(false);
            return;
        }
        this.mGiftStateLayout.switchSendButton(z);
        this.mSendGiftButton.switchSendBtnStyle(z);
    }

    public void addPropItem(int i, GiftPropBean giftPropBean) {
        PropShowView propShowView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095699836")) {
            ipChange.ipc$dispatch("-1095699836", new Object[]{this, Integer.valueOf(i), giftPropBean});
        } else if (giftPropBean == null || (propShowView = this.mPropPagerView) == null) {
        } else {
            propShowView.addItem(i, giftPropBean);
        }
    }

    public boolean canSendGift() {
        GiftStateLayout giftStateLayout;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-632740504") ? ((Boolean) ipChange.ipc$dispatch("-632740504", new Object[]{this})).booleanValue() : this.mSelectedGiftInfoBean == null || (giftStateLayout = this.mGiftStateLayout) == null || ParseUtils.parse2Long(this.mSelectedGiftInfoBean.coins) * this.mGiftStateLayout.getTvNum() > giftStateLayout.getCoins();
    }

    public void changeToGiftTab(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435719343")) {
            ipChange.ipc$dispatch("-435719343", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.isShowProp) {
            switchPropPannel(false);
        }
        if (this.mGiftBaseViews.size() > i) {
            this.mYKLPagerTabIndicator.onPageSelected(i);
            this.mGiftBaseViews.get(i).jumpToPosition(0);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.OnSendListener
    public boolean checkCost() {
        GiftStateLayout giftStateLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684485669")) {
            return ((Boolean) ipChange.ipc$dispatch("-684485669", new Object[]{this})).booleanValue();
        }
        if (this.mSelectedGiftInfoBean != null && (giftStateLayout = this.mGiftStateLayout) != null) {
            if (ParseUtils.parse2Long(this.mSelectedGiftInfoBean.coins) * this.mGiftStateLayout.getTvNum() > giftStateLayout.getCoins()) {
                showDialogCharge();
                this.mSendGiftButton.setSendVisibility(false);
                return true;
            }
            this.mSendGiftButton.setSendVisibility(true);
            return false;
        }
        this.mSendGiftButton.setSendVisibility(false);
        return true;
    }

    public void deletePropItem(String str) {
        PropShowView propShowView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138300775")) {
            ipChange.ipc$dispatch("138300775", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || (propShowView = this.mPropPagerView) == null) {
        } else {
            propShowView.deleteItem(str);
        }
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-166611998")) {
            ipChange.ipc$dispatch("-166611998", new Object[]{this});
        } else if (this.isClosing) {
        } else {
            this.isClosing = true;
            if (this.mGiftBoardCallback != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("isCombo", Boolean.valueOf(this.isShowCombo));
                hashMap.put("countdownTime", Integer.valueOf(getCountdownNum()));
                this.mGiftBoardCallback.close(hashMap);
            }
            UTSendCount();
            this.closeAll = false;
        }
    }

    public int getCountdownNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816771660")) {
            return ((Integer) ipChange.ipc$dispatch("-816771660", new Object[]{this})).intValue();
        }
        ParticleSendGiftButton particleSendGiftButton = this.mSendGiftButton;
        if (particleSendGiftButton != null) {
            return particleSendGiftButton.getCountdownNum();
        }
        return 100;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.OnSendListener
    public void onCombSend(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1880491251")) {
            ipChange.ipc$dispatch("-1880491251", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        GiftInfoBean giftInfoBean = this.mSelectedGiftInfoBean;
        if (giftInfoBean == null) {
            return;
        }
        try {
            i2 = Integer.parseInt(giftInfoBean.coins);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (i2 > 0) {
            showDmDialog("大麦暂不支持赠送付费礼物，请去优酷app赠送");
        } else if (this.mSelectedGiftInfoBean.girdViewType == 1) {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "//送星星 ");
            sendStar();
        } else {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "GiftInfoBean send ");
            if (!checkCost()) {
                if (this.mSelectedGiftInfoBean == null) {
                    return;
                }
                if (this.isOldSend) {
                    this.mSendGiftButton.oldStartShowProgress();
                } else {
                    CombFloatingView combFloatingView = this.mCombFloatingView;
                    if (combFloatingView != null) {
                        combFloatingView.startFloatingAnim(i);
                    }
                    if (getHandler() != null) {
                        getHandler().postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.15
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-533526909")) {
                                    ipChange2.ipc$dispatch("-533526909", new Object[]{this});
                                    return;
                                }
                                if (SendGiftWindow.this.mCombWaveView != null) {
                                    SendGiftWindow.this.mCombWaveView.start();
                                }
                                SendGiftWindow.this.startBomShot();
                                SendGiftWindow.this.startGiftIconFloating();
                                if (SendGiftWindow.this.mCombWaveView != null) {
                                    SendGiftWindow.this.mCombWaveView.stop();
                                }
                            }
                        }, 100L);
                    }
                    VibrateUtil.vSimple(this.mContext, 50);
                }
                calculateSendNum(i);
                GiftUTUtils.comboClickMultiTarget(this.mCurrentGroupId, this.mSelectedGiftInfoBean, this.mMultiTargetLayout.getTargetInfos());
            }
            sendGift();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144671377")) {
            ipChange.ipc$dispatch("-2144671377", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        dismiss();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.OnSendListener
    public void onRenew() {
        GiftStateLayout giftStateLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461443582")) {
            ipChange.ipc$dispatch("1461443582", new Object[]{this});
            return;
        }
        GiftInfoBean giftInfoBean = this.mSelectedGiftInfoBean;
        if (giftInfoBean == null || (giftStateLayout = this.mGiftStateLayout) == null) {
            return;
        }
        int i = giftInfoBean.girdViewType;
        giftStateLayout.setSendBtnVisible(true);
        this.isShowCombo = false;
        CombFloatingView combFloatingView = this.mCombFloatingView;
        if (combFloatingView != null) {
            combFloatingView.removeSelf();
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.OnSendListener
    public void onSend() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836405257")) {
            ipChange.ipc$dispatch("-1836405257", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "onSend 目前没用");
        GiftInfoBean giftInfoBean = this.mSelectedGiftInfoBean;
        if (giftInfoBean.girdViewType == 1) {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "//送星星 ");
            sendStar();
            return;
        }
        if (!giftInfoBean.continuousSend) {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "GiftInfoBean send ");
            if (!checkCost()) {
                GiftInfoBean giftInfoBean2 = this.mSelectedGiftInfoBean;
                if (giftInfoBean2 == null) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "mSelectedGiftInfoBean == null ");
                    return;
                }
                GiftUTUtils.comboClickMultiTarget(this.mCurrentGroupId, giftInfoBean2, this.mMultiTargetLayout.getTargetInfos());
            } else {
                this.mSendGiftButton.resetProgress(false);
                onRenew();
            }
        }
        sendGift();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.OnSendListener
    public void onTouchDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989558")) {
            ipChange.ipc$dispatch("-989558", new Object[]{this});
        }
    }

    public void openMultiSendMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047694562")) {
            ipChange.ipc$dispatch("1047694562", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        MultiTargetListView multiTargetListView = this.mMultiTargetLayout;
        if (multiTargetListView != null) {
            multiTargetListView.openMultiSendMode(z);
        }
    }

    public void refreshGiftInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1220329235")) {
            ipChange.ipc$dispatch("1220329235", new Object[]{this});
            return;
        }
        ArrayList<GiftBaseView> arrayList = this.mGiftBaseViews;
        if (arrayList != null) {
            arrayList.clear();
        }
        List<GiftCategoryBean> list = this.categoryGiftBeanArrayList;
        if (list != null) {
            list.clear();
        }
        this.categoryGiftBeanArrayList.addAll(GiftDataManager.getInstance().getGiftCategoryList());
        List<GiftCategoryBean> list2 = this.categoryGiftBeanArrayList;
        if (list2 != null && list2.size() != 0) {
            if (this.categoryGiftBeanArrayList.size() > 0 && this.categoryGiftBeanArrayList.get(0) != null && this.mHasStarGift) {
                ((ILog) Dsl.getService(ILog.class)).d("liulei-position", "mHasStarGift");
                GiftInfoBean giftInfoBean = new GiftInfoBean();
                giftInfoBean.giftId = "-9";
                giftInfoBean.id = "-9";
                giftInfoBean.girdViewType = 1;
                giftInfoBean.continuousSend = false;
                giftInfoBean.multiSend = false;
                giftInfoBean.name = "星星";
                if (this.categoryGiftBeanArrayList.get(0).giftInfos != null) {
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-position", "add star");
                    this.categoryGiftBeanArrayList.get(0).giftInfos.add(0, giftInfoBean);
                }
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-position", "categoryGiftBeanArrayList size = " + this.categoryGiftBeanArrayList.size());
            GiftPosition giftPosition = GiftDataManager.getInstance().getGiftPosition(this.mLastSelectedGid);
            for (int i = 0; i < this.categoryGiftBeanArrayList.size(); i++) {
                if (this.categoryGiftBeanArrayList.get(i) != null) {
                    this.mTitles.add(this.categoryGiftBeanArrayList.get(i).name);
                    YKLGiftPageView yKLGiftPageView = new YKLGiftPageView(this.mContext);
                    yKLGiftPageView.setLandscape(this.mIsLandscape);
                    yKLGiftPageView.setRowNum(this.mGiftRowNum);
                    yKLGiftPageView.setClipChildren(false);
                    yKLGiftPageView.setGroupId(this.categoryGiftBeanArrayList.get(i).groupId, this.categoryGiftBeanArrayList.get(i).name, i);
                    yKLGiftPageView.setData(this.categoryGiftBeanArrayList.get(i).giftInfos);
                    if (i == giftPosition.groupPosition) {
                        this.mCurrentGroupId = this.categoryGiftBeanArrayList.get(i).groupId;
                        this.mCurrentTitle = this.categoryGiftBeanArrayList.get(i).name;
                        if (this.categoryGiftBeanArrayList.get(i).giftInfos != null && this.categoryGiftBeanArrayList.get(i).giftInfos.size() > 0) {
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-position", "");
                            this.mSelectedGiftInfoBean = this.categoryGiftBeanArrayList.get(i).giftInfos.get(giftPosition.giftPosition);
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-position", "mSelectedGiftInfoBean = " + this.mSelectedGiftInfoBean.girdViewType);
                            GiftInfoBean giftInfoBean2 = this.mSelectedGiftInfoBean;
                            giftInfoBean2.isChecked = true;
                            this.mLastSelectedGid = giftInfoBean2.id;
                            ParticleSendGiftButton particleSendGiftButton = this.mSendGiftButton;
                            if (particleSendGiftButton != null) {
                                particleSendGiftButton.setCanCombo(giftInfoBean2.continuousSend);
                            }
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-position", "mLastSelectedGid = " + this.mLastSelectedGid);
                        }
                        yKLGiftPageView.jumpToPosition(giftPosition.giftPosition);
                    }
                    yKLGiftPageView.setItemClickInterface(new GiftBaseView.OnItemClickInterface<GiftInfoBean>() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.6
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView.OnItemClickInterface
                        public void onChildPageChangeListener(int i2, List<GiftInfoBean> list3) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-1545528790")) {
                                ipChange2.ipc$dispatch("-1545528790", new Object[]{this, Integer.valueOf(i2), list3});
                            } else {
                                GiftUTUtils.giftBoardPageChange(SendGiftWindow.this.mCurrentGroupId, SendGiftWindow.this.mCurrentTitle, i2, list3);
                            }
                        }

                        @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView.OnItemClickInterface
                        public void onItemClick(AdapterView<?> adapterView, View view, int i2, int i3, long j, CommonAdapter<GiftInfoBean> commonAdapter) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "630189840")) {
                                ipChange2.ipc$dispatch("630189840", new Object[]{this, adapterView, view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), commonAdapter});
                                return;
                            }
                            if (SendGiftWindow.this.mSelectedGiftInfoBean != null && !TextUtils.isEmpty(SendGiftWindow.this.mSelectedGiftInfoBean.id)) {
                                SendGiftWindow sendGiftWindow = SendGiftWindow.this;
                                sendGiftWindow.mLastSelectedGid = sendGiftWindow.mSelectedGiftInfoBean.id;
                            }
                            List<GiftInfoBean> data = commonAdapter.getData();
                            if (data != null && data.size() > 0) {
                                if (!commonAdapter.getData().get(i3).checkGiftTag(GiftInfoBean.GiftTag.GRAFFITI)) {
                                    SendGiftWindow.this.mGestureIndicatorContainer.setVisibility(4);
                                } else {
                                    SendGiftWindow.this.setIndicatorVisibility(0);
                                    SendGiftWindow.this.mGestureIndicatorContainer.setVisibility(0);
                                }
                            }
                            Iterator it = SendGiftWindow.this.mGiftBaseViews.iterator();
                            while (it.hasNext()) {
                                HashMap<CommonAdapter<T>, NoScrollGridView> hashMap = ((GiftBaseView) it.next()).mCategoryAllAdapterGV;
                                for (GiftShowAdapter giftShowAdapter : hashMap.keySet()) {
                                    giftShowAdapter.unSelected(hashMap.get(giftShowAdapter), SendGiftWindow.this.mLastSelectedGid);
                                }
                            }
                            ((GiftShowAdapter) commonAdapter).selected(adapterView, i3);
                            GiftInfoBean item = commonAdapter.getItem(i3);
                            if (item == null || !TextUtils.equals(SendGiftWindow.this.mLastSelectedGid, item.id)) {
                                SendGiftWindow.this.mSelectedGiftInfoBean = commonAdapter.getItem(i3);
                                if (SendGiftWindow.this.mSelectedGiftInfoBean != null) {
                                    SendGiftWindow.this.mSelectedNum = 1L;
                                    SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
                                    if (SendGiftWindow.this.getHandler() != null && !SendGiftWindow.this.mSelectedGiftInfoBean.checkGiftTag(GiftInfoBean.GiftTag.GRAFFITI)) {
                                        SendGiftWindow.this.getHandler().post(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.6.1
                                            private static transient /* synthetic */ IpChange $ipChange;

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IpChange ipChange3 = $ipChange;
                                                if (AndroidInstantRuntime.support(ipChange3, "1359064194")) {
                                                    ipChange3.ipc$dispatch("1359064194", new Object[]{this});
                                                } else if (SendGiftWindow.this.mSelectedGiftInfoBean == null || TextUtils.isEmpty(SendGiftWindow.this.mSelectedGiftInfoBean.desc)) {
                                                } else {
                                                    ToastUtil.showCenter(SendGiftWindow.this.getContext(), SendGiftWindow.this.mSelectedGiftInfoBean.desc);
                                                }
                                            }
                                        });
                                    }
                                }
                                String str = SendGiftWindow.this.mCurrentTabPosition + "";
                                GiftUTUtils.giftBoardItemClick(SendGiftWindow.this.mCurrentGroupId, SendGiftWindow.this.mCurrentTitle, str, i2 + "", i3 + "", SendGiftWindow.this.mSelectedGiftInfoBean);
                                if (SendGiftWindow.this.mSelectedGiftInfoBean != null) {
                                    SendGiftWindow sendGiftWindow2 = SendGiftWindow.this;
                                    sendGiftWindow2.mLastSelectedGid = sendGiftWindow2.mSelectedGiftInfoBean.id;
                                }
                                if (SendGiftWindow.this.mSelectedGiftInfoBean == null || SendGiftWindow.this.mSelectedGiftInfoBean.girdViewType != 1) {
                                    SendGiftWindow.this.switchSendButtonState(true);
                                } else {
                                    SendGiftWindow.this.switchSendButtonState(false);
                                }
                                if (SendGiftWindow.this.mSelectedGiftInfoBean != null) {
                                    SendGiftWindow.this.mSendGiftButton.setGiftType(SendGiftWindow.this.mSelectedGiftInfoBean.girdViewType);
                                }
                                SendGiftWindow.this.mSendGiftButton.setCombo(true);
                                SendGiftWindow.this.mSendGiftButton.resetProgress(false);
                                SendGiftWindow.this.onRenew();
                                ((ILog) Dsl.getService(ILog.class)).d("jiangzGift", SendGiftWindow.this.mSelectedGiftInfoBean.btn + " " + SendGiftWindow.this.mSelectedGiftInfoBean.multiSend + " " + SendGiftWindow.this.mSelectedGiftInfoBean.continuousSend);
                                if (!TextUtils.isEmpty(SendGiftWindow.this.mSelectedGiftInfoBean.btn)) {
                                    if (SendGiftWindow.this.mSendGiftButton != null) {
                                        SendGiftWindow.this.mSendGiftButton.setSendText(SendGiftWindow.this.mSelectedGiftInfoBean.btn);
                                    }
                                    if (SendGiftWindow.this.mGiftStateLayout != null) {
                                        SendGiftWindow.this.mGiftStateLayout.setSendText(SendGiftWindow.this.mSelectedGiftInfoBean.btn);
                                    }
                                }
                                if (SendGiftWindow.this.mSendGiftButton != null) {
                                    SendGiftWindow.this.mSendGiftButton.setCanCombo(SendGiftWindow.this.mSelectedGiftInfoBean.continuousSend);
                                }
                            }
                        }
                    });
                    this.mGiftBaseViews.add(yKLGiftPageView);
                }
            }
            GiftInfoBean giftInfoBean3 = this.mSelectedGiftInfoBean;
            if (giftInfoBean3 != null) {
                if (giftInfoBean3.girdViewType == 1) {
                    switchSendButtonState(false);
                } else {
                    switchSendButtonState(true);
                }
                this.mGiftStateLayout.setSelNum(this.mSelectedNum);
            }
            if (this.mGiftRowNum == 1) {
                this.mViewPager.getLayoutParams().height = DensityUtil.dip2px(this.mContext, 126.0f);
            } else {
                this.mViewPager.getLayoutParams().height = DensityUtil.dip2px(this.mContext, 226.0f);
            }
            this.mViewPager.setOffscreenPageLimit(4);
            GiftViewPagerAdapter giftViewPagerAdapter = new GiftViewPagerAdapter(this.mGiftBaseViews, this.mTitles);
            this.mGiftViewAdapter = giftViewPagerAdapter;
            this.mViewPager.setAdapter(giftViewPagerAdapter);
            if (this.mTitles.size() < 1 && !this.hasPack) {
                this.mYKLPagerTabIndicator.setVisibility(8);
            } else {
                this.mYKLPagerTabIndicator.setVisibility(0);
            }
            if (this.mYKLPagerTabIndicator.getViewPager() == null) {
                this.mYKLPagerTabIndicator.setViewPager(this.mViewPager);
            }
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1773382384")) {
                        ipChange2.ipc$dispatch("1773382384", new Object[]{this, Integer.valueOf(i2)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f, int i3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2134648719")) {
                        ipChange2.ipc$dispatch("2134648719", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1454339643")) {
                        ipChange2.ipc$dispatch("1454339643", new Object[]{this, Integer.valueOf(i2)});
                    } else if (GiftDataManager.getInstance().getGiftCategoryList().size() > i2) {
                        GiftDataManager.getInstance().getGiftCategoryList().get(i2);
                        if (SendGiftWindow.this.mGiftBaseViews == null || SendGiftWindow.this.mGiftBaseViews.size() <= 0 || i2 >= SendGiftWindow.this.mGiftBaseViews.size()) {
                            return;
                        }
                        GiftUTUtils.giftBoardPageChange(SendGiftWindow.this.mCurrentGroupId, SendGiftWindow.this.mCurrentTitle, i2, ((GiftBaseView) SendGiftWindow.this.mGiftBaseViews.get(i2)).getCurrentChildPageData());
                    }
                }
            });
            this.mYKLPagerTabIndicator.setOnItemTabClickListener(new DynamicPagerIndicator.OnItemTabClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.kcrason.dynamicpagerindicatorlibrary.DynamicPagerIndicator.OnItemTabClickListener
                public void onItemTabClick(int i2) {
                    GiftCategoryBean giftCategoryBean;
                    List<GiftInfoBean> currentChildPageData;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-469348426")) {
                        ipChange2.ipc$dispatch("-469348426", new Object[]{this, Integer.valueOf(i2)});
                        return;
                    }
                    if (SendGiftWindow.this.isShowProp) {
                        SendGiftWindow.this.switchPropPannel(false);
                    }
                    SendGiftWindow.this.mCurrentTabPosition = i2;
                    if (SendGiftWindow.this.mGiftBaseViews != null && SendGiftWindow.this.mGiftBaseViews.size() > 0 && i2 < SendGiftWindow.this.mGiftBaseViews.size() && (currentChildPageData = ((GiftBaseView) SendGiftWindow.this.mGiftBaseViews.get(i2)).getCurrentChildPageData()) != null) {
                        for (GiftInfoBean giftInfoBean4 : currentChildPageData) {
                            if (giftInfoBean4.isChecked && giftInfoBean4.checkGiftTag(GiftInfoBean.GiftTag.GRAFFITI)) {
                                SendGiftWindow.this.setIndicatorVisibility(0);
                            }
                        }
                    }
                    if (GiftDataManager.getInstance().getGiftCategoryList().size() <= i2 || (giftCategoryBean = GiftDataManager.getInstance().getGiftCategoryList().get(i2)) == null) {
                        return;
                    }
                    SendGiftWindow.this.mCurrentGroupId = giftCategoryBean.groupId;
                    SendGiftWindow.this.mCurrentTitle = giftCategoryBean.name;
                    GiftUTUtils.giftBoardTabClick(SendGiftWindow.this.mCurrentGroupId, SendGiftWindow.this.mCurrentTitle, i2, giftCategoryBean.giftInfos);
                }
            });
            ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "giftPosition.groupPosition + " + giftPosition.groupPosition);
            int i2 = giftPosition.groupPosition;
            this.mCurrentTabPosition = i2;
            this.mYKLPagerTabIndicator.setUnCheckedAll(this.isShowProp, i2);
            this.mViewPager.setCurrentItem(giftPosition.groupPosition);
            this.mGiftStateLayout.setOnGiftStateClickListener(this.mOnGiftStateClickListener);
            this.mGiftStateLayout.setOnPropClickListener(this.mPropClickListener);
            return;
        }
        showRefreshLayout(true);
    }

    public void refreshPropData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806698236")) {
            ipChange.ipc$dispatch("-1806698236", new Object[]{this});
            return;
        }
        this.mPropPagerView.setPageViewParams(this.mGiftRowNum);
        this.mPropPagerView.setListener(this.mPropListener);
        if (this.mGiftRowNum == 1) {
            this.mPropPagerView.getLayoutParams().height = DensityUtil.dip2px(this.mContext, 126.0f);
        } else {
            this.mPropPagerView.getLayoutParams().height = DensityUtil.dip2px(this.mContext, 226.0f);
        }
        this.mPropPagerView.setSelectedProp(this.mLastSelectedPid);
        this.mPropPagerView.setData(GiftDataManager.getInstance().getGiftPropList());
        setIndicatorVisibility(4);
        if (this.mPropPagerView.getSeletedProp() != null) {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "mPropPagerView.getSeletedProp() != null");
            this.mGiftStateLayout.setVisibility(0);
            this.mGiftStateLayout.updatePropTip(this.mPropPagerView.getSeletedProp().isGift(), this.mPropPagerView.getSeletedProp().expire, this.mPropPagerView.getSeletedProp().btn);
        } else {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "mPropPagerView.getSeletedProp() == null");
        }
        if (this.mTitles.size() < 1 && !this.hasPack) {
            this.mYKLPagerTabIndicator.setVisibility(8);
        } else {
            this.mYKLPagerTabIndicator.setVisibility(0);
        }
    }

    public void refreshTargetData() {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187978774")) {
            ipChange.ipc$dispatch("187978774", new Object[]{this});
        } else if (GiftDataManager.getInstance().hasTarget()) {
            this.mMultiTargetLayout.setVisibility(0);
            if (!TextUtils.isEmpty(this.mSelectedTargetIds) && (split = this.mSelectedTargetIds.split(",")) != null && split.length > 0) {
                this.selPositions.clear();
                for (String str : split) {
                    int targetPosition = GiftDataManager.getInstance().getTargetPosition(str);
                    if (targetPosition != -1) {
                        this.selPositions.add(Integer.valueOf(targetPosition));
                    }
                }
                Collections.sort(this.selPositions);
            }
            this.mMultiTargetLayout.setTargetList(GiftDataManager.getInstance().getGiftTargetList());
            ArrayList<Integer> arrayList = this.selPositions;
            if (arrayList != null && arrayList.size() > 0) {
                this.mMultiTargetLayout.selectAndScrollToPosition(this.selPositions);
            } else {
                this.mMultiTargetLayout.scrollTo(1, 0);
            }
        } else {
            this.mMultiTargetLayout.setVisibility(8);
        }
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962733893")) {
            ipChange.ipc$dispatch("1962733893", new Object[]{this});
            return;
        }
        this.mLastSelectedGid = null;
        this.mSelectedTargetIds = null;
        this.mSelectedGiftInfoBean = null;
    }

    public void removeFloatingView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994033423")) {
            ipChange.ipc$dispatch("994033423", new Object[]{this});
            return;
        }
        CombFloatingView combFloatingView = this.mCombFloatingView;
        if (combFloatingView != null) {
            combFloatingView.removeSelf();
        }
    }

    public void setArgs(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194806391")) {
            ipChange.ipc$dispatch("194806391", new Object[]{this, str});
        } else {
            this.args = str;
        }
    }

    public void setBoardWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1848222055")) {
            ipChange.ipc$dispatch("-1848222055", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-gift", "width = " + i);
        RelativeLayout relativeLayout = this.mGiftBoardLayout;
        if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-gift", "getLayoutParams width = " + i);
        this.mGiftBoardLayout.getLayoutParams().width = i;
        RelativeLayout relativeLayout2 = this.mGiftBoardLayout;
        relativeLayout2.setLayoutParams(relativeLayout2.getLayoutParams());
    }

    public void setCoinIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365456310")) {
            ipChange.ipc$dispatch("-365456310", new Object[]{this, str});
        } else {
            this.mGiftStateLayout.setCoinIcon(str);
        }
    }

    public void setComboInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1425632086")) {
            ipChange.ipc$dispatch("1425632086", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mComboInterval = i;
        ParticleSendGiftButton particleSendGiftButton = this.mSendGiftButton;
        if (particleSendGiftButton != null) {
            particleSendGiftButton.setComboInterval(i);
        }
    }

    public void setFirstRecharge(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150124587")) {
            ipChange.ipc$dispatch("1150124587", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        GiftStateLayout giftStateLayout = this.mGiftStateLayout;
        if (giftStateLayout != null) {
            giftStateLayout.setChargeBtnState(z);
        }
    }

    public void setGiftBoardCallback(IGiftBoardCallback iGiftBoardCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931791169")) {
            ipChange.ipc$dispatch("1931791169", new Object[]{this, iGiftBoardCallback});
        } else {
            this.mGiftBoardCallback = iGiftBoardCallback;
        }
    }

    public void setGiftFloatingEndXY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "255632457")) {
            ipChange.ipc$dispatch("255632457", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.y = i;
        ((ILog) Dsl.getService(ILog.class)).i("GiftPoint= ", " y= " + i);
    }

    public void setGiftRowNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1843534155")) {
            ipChange.ipc$dispatch("-1843534155", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mGiftRowNum = i;
        }
    }

    public void setHasPackTip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459264946")) {
            ipChange.ipc$dispatch("459264946", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasPackTip = z;
        if (z) {
            this.mPackTipRedPoint.setVisibility(0);
        } else {
            this.mPackTipRedPoint.setVisibility(8);
        }
    }

    public void setHasProp(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584730769")) {
            ipChange.ipc$dispatch("1584730769", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasPack = z;
        if (z) {
            this.mPackLayout.setVisibility(0);
        } else {
            this.mPackLayout.setVisibility(8);
        }
    }

    public void setHasStarGift(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183724240")) {
            ipChange.ipc$dispatch("1183724240", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mHasStarGift = z;
        }
    }

    public void setIndicatorVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396219228")) {
            ipChange.ipc$dispatch("-1396219228", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mGestureIndicatorContainer.setVisibility(i);
        this.mGestureIndicatorContainer.setAlpha(i == 0 ? 1.0f : 0.0f);
    }

    public void setMultipleText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076277001")) {
            ipChange.ipc$dispatch("-2076277001", new Object[]{this, str});
            return;
        }
        MultiTargetListView multiTargetListView = this.mMultiTargetLayout;
        if (multiTargetListView != null) {
            multiTargetListView.setMultipleText(str);
        }
    }

    public void setOnGestureGiftDetectedListener(OnGestureGiftDetectedListener onGestureGiftDetectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019065142")) {
            ipChange.ipc$dispatch("-1019065142", new Object[]{this, onGestureGiftDetectedListener});
        } else {
            this.mOnGestureGiftDetectedListener = onGestureGiftDetectedListener;
        }
    }

    public void setPackTabName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669620771")) {
            ipChange.ipc$dispatch("669620771", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-gift", "window set setPackTabName =  " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mPackText.setText(str);
    }

    public void setRoomId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285877666")) {
            ipChange.ipc$dispatch("-1285877666", new Object[]{this, str});
        } else {
            this.mRoomId = str;
        }
    }

    public void setScreenId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761443437")) {
            ipChange.ipc$dispatch("761443437", new Object[]{this, str});
        } else {
            this.mScreenId = str;
        }
    }

    public void setSelectGid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1149208708")) {
            ipChange.ipc$dispatch("1149208708", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-gift", "window set gid =  " + str);
        this.mLastSelectedGid = str;
    }

    public void setSelectNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058555187")) {
            ipChange.ipc$dispatch("-1058555187", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 1) {
            i = 1;
        }
        long j = i;
        this.mSelectedNum = j;
        this.mGiftStateLayout.setSelNum(j);
    }

    public void setSelectPid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546147931")) {
            ipChange.ipc$dispatch("546147931", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-gift", "window set Pid =  " + str);
    }

    public void setSelectTid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278120919")) {
            ipChange.ipc$dispatch("278120919", new Object[]{this, str});
        } else {
            this.mSelectedTargetIds = str;
        }
    }

    public void setShowComboBtn(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080498101")) {
            ipChange.ipc$dispatch("1080498101", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowCombo = z;
        }
    }

    public void setShowTargetDetails(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068860712")) {
            ipChange.ipc$dispatch("2068860712", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mShowTargetDetails = z;
        MultiTargetListView multiTargetListView = this.mMultiTargetLayout;
        if (multiTargetListView != null) {
            multiTargetListView.changeView(!z);
        }
    }

    public void switchPropPannel(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042030491")) {
            ipChange.ipc$dispatch("-1042030491", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.isShowProp == z) {
        } else {
            this.isShowProp = z;
            ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "switch prop = " + z);
            IGiftBoardCallback iGiftBoardCallback = this.mGiftBoardCallback;
            if (iGiftBoardCallback != null) {
                iGiftBoardCallback.switchToProp(z);
            }
            if (z) {
                if (this.mPackTipRedPoint.getVisibility() == 0) {
                    this.mPackTipRedPoint.setVisibility(8);
                }
                this.mSendGiftButton.resetProgress(false);
                onRenew();
                this.mSendGiftButton.setVisibility(8);
                this.mPackText.setTypeface(Typeface.defaultFromStyle(1));
                this.mPackText.setTextColor(-1);
                this.mPackIndicator.setVisibility(0);
                this.mViewSwitcher.setInAnimation(this.mContext, R.anim.dago_pgc_translate_right_in);
                this.mViewSwitcher.setOutAnimation(this.mContext, R.anim.dago_pgc_translate_left_out);
                this.mViewSwitcher.showNext();
            } else {
                this.mPackText.setTypeface(Typeface.defaultFromStyle(0));
                this.mPackText.setTextColor(-1275068417);
                this.mPackIndicator.setVisibility(8);
                this.mViewSwitcher.setInAnimation(this.mContext, R.anim.dago_pgc_translate_left_in);
                this.mViewSwitcher.setOutAnimation(this.mContext, R.anim.dago_pgc_translate_right_out);
                this.mViewSwitcher.showPrevious();
                this.mSendGiftButton.setVisibility(0);
                this.mPropPagerView.resetView();
            }
            this.mYKLPagerTabIndicator.setUnCheckedAll(z, this.mCurrentTabPosition);
            this.mGiftStateLayout.switchPropLayout(z);
        }
    }

    public void switchVirtualCoinsExchange(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276287000")) {
            ipChange.ipc$dispatch("1276287000", new Object[]{this, Boolean.valueOf(z), str, str2});
        }
    }

    public void updatePropItem(GiftPropBean giftPropBean) {
        PropShowView propShowView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695716203")) {
            ipChange.ipc$dispatch("-695716203", new Object[]{this, giftPropBean});
        } else if (giftPropBean == null || TextUtils.isEmpty(giftPropBean.id) || (propShowView = this.mPropPagerView) == null) {
        } else {
            propShowView.updateItem(giftPropBean);
        }
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005305696")) {
            ipChange.ipc$dispatch("1005305696", new Object[]{this, giftTheme});
            return;
        }
        int dip2px = DensityUtil.dip2px(this.mContext, 1.0f);
        this.mYKLPagerTabIndicator.setIndicatorColor(ColorUtil.getHexString(giftTheme.themeColor));
        this.mRefreshBtn.setBackground(ThemeUtils.getGradientDrawable(giftTheme.btnGiantStartColor, giftTheme.btnGiantEndColor, GradientDrawable.Orientation.LEFT_RIGHT, 0, 0, dip2px * 15));
        this.mPackIndicator.setImageDrawable(ThemeUtils.getDrawable(giftTheme.themeColor, 0, 0, dip2px * 4));
        this.mGiftStateLayout.updateTheme(giftTheme);
        this.mSendGiftButton.updateTheme(giftTheme);
        this.mPropPagerView.updateTheme(giftTheme);
        this.mMultiTargetLayout.updateTheme(giftTheme);
        this.mNumkeyboardView.updateTheme(giftTheme);
        GiftInfoBean giftInfoBean = this.mSelectedGiftInfoBean;
        if (giftInfoBean != null) {
            if (giftInfoBean.girdViewType == 1) {
                switchSendButtonState(false);
            } else {
                switchSendButtonState(true);
            }
            this.mGiftStateLayout.setSelNum(this.mSelectedNum);
        }
    }

    public void updateUserCoins(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102049544")) {
            ipChange.ipc$dispatch("2102049544", new Object[]{this, str});
            return;
        }
        GiftStateLayout giftStateLayout = this.mGiftStateLayout;
        if (giftStateLayout != null) {
            giftStateLayout.updateCoins(str);
        }
    }

    public SendGiftWindow(@NonNull Context context, boolean z) {
        super(context);
        this.DISPLAY_GIFT_BOARD = 0;
        this.DISPLAY_NUM_KEY_BOARD = 1;
        this.mGiftRowNum = 2;
        this.mSelectedGiftInfoBean = null;
        this.mSelectedNum = 1L;
        this.mGiftBaseViews = new ArrayList<>();
        this.mTitles = new ArrayList<>();
        this.categoryGiftBeanArrayList = new ArrayList();
        this.selPositions = new ArrayList<>();
        this.mLastSelectedGid = null;
        this.mLastSelectedPid = null;
        this.args = "";
        this.mScreenId = "";
        this.mIsLandscape = false;
        this.mComboInterval = 10;
        this.mCurrentGroupId = "";
        this.mCurrentTitle = "";
        this.mSelectedTargetIds = "";
        this.mRoomId = "";
        this.isShowCombo = false;
        this.isShowProp = false;
        this.hasPack = false;
        this.hasPackTip = false;
        this.mCurrentTabPosition = 0;
        this.isClosing = false;
        this.isNewComb = 1;
        this.mTargetLayoutListner = new MultiTargetListView.EventListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onClick(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1827109741")) {
                    ipChange.ipc$dispatch("1827109741", new Object[]{this, giftTargetInfoBean});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onExposed(List<GiftTargetInfoBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1374779564")) {
                    ipChange.ipc$dispatch("1374779564", new Object[]{this, list});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void openUserCard(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1372192131")) {
                    ipChange.ipc$dispatch("1372192131", new Object[]{this, giftTargetInfoBean});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || giftTargetInfoBean == null) {
                } else {
                    SendGiftWindow.this.mGiftBoardCallback.openUserCard(giftTargetInfoBean.id);
                }
            }
        };
        this.mPropListener = new PropShowView.PropListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void morePropBtnClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-13246677")) {
                    ipChange.ipc$dispatch("-13246677", new Object[]{this});
                    return;
                }
                GiftUTUtils.taskBoardClick();
                if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.morePropBtnClick();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onChildPageChange(int i, List<GiftPropBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-424566955")) {
                    ipChange.ipc$dispatch("-424566955", new Object[]{this, Integer.valueOf(i), list});
                } else {
                    GiftUTUtils.propPageChange(list);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemChecked(GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2005935740")) {
                    ipChange.ipc$dispatch("2005935740", new Object[]{this, giftPropBean});
                } else if (giftPropBean != null) {
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(giftPropBean.isGift(), giftPropBean.expire, giftPropBean.btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j, CommonAdapter<GiftPropBean> commonAdapter) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1407602716")) {
                    ipChange.ipc$dispatch("1407602716", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j), commonAdapter});
                } else if (SendGiftWindow.this.mPropPagerView.getSeletedProp() != null) {
                    GiftUTUtils.propItemClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(SendGiftWindow.this.mPropPagerView.getSeletedProp().isGift(), SendGiftWindow.this.mPropPagerView.getSeletedProp().expire, SendGiftWindow.this.mPropPagerView.getSeletedProp().btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onRefresh() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1771197439")) {
                    ipChange.ipc$dispatch("1771197439", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.refresh(true);
                }
            }
        };
        this.mOnGiftStateClickListener = new GiftStateLayout.OnGiftStateClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onRechargeClick(boolean z2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "235951295")) {
                    ipChange.ipc$dispatch("235951295", new Object[]{this, Boolean.valueOf(z2)});
                } else {
                    SendGiftWindow.this.recharge();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onSendGiftClick(long j) {
                int i;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-259271266")) {
                    ipChange.ipc$dispatch("-259271266", new Object[]{this, Long.valueOf(j)});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean == null) {
                } else {
                    try {
                        i = Integer.parseInt(SendGiftWindow.this.mSelectedGiftInfoBean.coins);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        i = 0;
                    }
                    if (i > 0) {
                        SendGiftWindow.this.showDmDialog("大麦暂不支持赠送付费礼物，请去优酷app赠送");
                        return;
                    }
                    if (!SendGiftWindow.this.checkCost()) {
                        GiftUTUtils.comboExpose(SendGiftWindow.this.mSelectedGiftInfoBean);
                        if (SendGiftWindow.this.mSelectedNum == 1 && SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.girdViewType != 1) {
                            if (SendGiftWindow.this.mSelectedGiftInfoBean.continuousSend) {
                                SendGiftWindow.this.mSendGiftButton.show();
                                SendGiftWindow.this.isShowCombo = true;
                                SendGiftWindow.this.mGiftStateLayout.setSendBtnVisible(false);
                            } else {
                                ((ILog) Dsl.getService(ILog.class)).i(SendGiftWindow.TAG, "不支持连送");
                                return;
                            }
                        }
                    }
                    SendGiftWindow.this.sendGift();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onShowGiftNumConfig() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-303073797")) {
                    ipChange.ipc$dispatch("-303073797", new Object[]{this});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.multiSend) {
                    if (SendGiftWindow.this.mSelectedGiftInfoBean.numList == null || SendGiftWindow.this.mSelectedGiftInfoBean.numList.size() <= 0) {
                        SendGiftWindow.this.displaySimulationKeyBord();
                    } else {
                        SendGiftWindow.this.showGiftNumListView(true);
                    }
                }
            }
        };
        this.numBottom = -1;
        this.mPropClickListener = new GiftStateLayout.OnPropClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onPropMissionClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-48200519")) {
                    ipChange.ipc$dispatch("-48200519", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.doTaskClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftBoardCallback.onDoMission(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onSendPropClick(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "228754862")) {
                    ipChange.ipc$dispatch("228754862", new Object[]{this, Integer.valueOf(i)});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.sendPropClickMulti(SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                    if (i < 1) {
                        i = 1;
                    }
                    SendGiftWindow.this.mGiftBoardCallback.onSendProp(i, SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onShowNumKeyBoard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "749278946")) {
                    ipChange.ipc$dispatch("749278946", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mOnGiftNumClickListener = new GiftNumSelectView.OnGiftNumClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onNumPannelclose() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1310051711")) {
                    ipChange.ipc$dispatch("1310051711", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "onNumPannelclose");
                SendGiftWindow.this.mGiftStateLayout.setArrOrientation(false);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onSelectedNum(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1481416349")) {
                    ipChange.ipc$dispatch("1481416349", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                SendGiftWindow.this.mSelectedNum = i;
                SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onShowCustomNumKeyboard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1551828814")) {
                    ipChange.ipc$dispatch("-1551828814", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mClickSureListener = new GiftNumKeyBoardView.ClickSureListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.12
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.ClickSureListener
            public void onNumConfirm(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "955782180")) {
                    ipChange.ipc$dispatch("955782180", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                if (j != 0) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "onNumConfirm  = " + SendGiftWindow.this.isShowProp);
                    if (SendGiftWindow.this.isShowProp) {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update PROP num  = " + j);
                        SendGiftWindow.this.mGiftStateLayout.setSelPropNum(j);
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update gift num  = " + j);
                        SendGiftWindow.this.mSelectedNum = j;
                        SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
                    }
                }
                SendGiftWindow.this.switchDisplayBoard(0);
            }
        };
        this.YKPACKAGE = AXPParamsProvider.ClientType.YOUKU;
        this.mContext = context;
        this.mIsLandscape = z;
        initView(context);
    }

    public SendGiftWindow(@NonNull Context context, int i, boolean z) {
        super(context);
        this.DISPLAY_GIFT_BOARD = 0;
        this.DISPLAY_NUM_KEY_BOARD = 1;
        this.mGiftRowNum = 2;
        this.mSelectedGiftInfoBean = null;
        this.mSelectedNum = 1L;
        this.mGiftBaseViews = new ArrayList<>();
        this.mTitles = new ArrayList<>();
        this.categoryGiftBeanArrayList = new ArrayList();
        this.selPositions = new ArrayList<>();
        this.mLastSelectedGid = null;
        this.mLastSelectedPid = null;
        this.args = "";
        this.mScreenId = "";
        this.mIsLandscape = false;
        this.mComboInterval = 10;
        this.mCurrentGroupId = "";
        this.mCurrentTitle = "";
        this.mSelectedTargetIds = "";
        this.mRoomId = "";
        this.isShowCombo = false;
        this.isShowProp = false;
        this.hasPack = false;
        this.hasPackTip = false;
        this.mCurrentTabPosition = 0;
        this.isClosing = false;
        this.isNewComb = 1;
        this.mTargetLayoutListner = new MultiTargetListView.EventListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onClick(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1827109741")) {
                    ipChange.ipc$dispatch("1827109741", new Object[]{this, giftTargetInfoBean});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onExposed(List<GiftTargetInfoBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1374779564")) {
                    ipChange.ipc$dispatch("1374779564", new Object[]{this, list});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void openUserCard(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1372192131")) {
                    ipChange.ipc$dispatch("1372192131", new Object[]{this, giftTargetInfoBean});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || giftTargetInfoBean == null) {
                } else {
                    SendGiftWindow.this.mGiftBoardCallback.openUserCard(giftTargetInfoBean.id);
                }
            }
        };
        this.mPropListener = new PropShowView.PropListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void morePropBtnClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-13246677")) {
                    ipChange.ipc$dispatch("-13246677", new Object[]{this});
                    return;
                }
                GiftUTUtils.taskBoardClick();
                if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.morePropBtnClick();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onChildPageChange(int i2, List<GiftPropBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-424566955")) {
                    ipChange.ipc$dispatch("-424566955", new Object[]{this, Integer.valueOf(i2), list});
                } else {
                    GiftUTUtils.propPageChange(list);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemChecked(GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2005935740")) {
                    ipChange.ipc$dispatch("2005935740", new Object[]{this, giftPropBean});
                } else if (giftPropBean != null) {
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(giftPropBean.isGift(), giftPropBean.expire, giftPropBean.btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j, CommonAdapter<GiftPropBean> commonAdapter) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1407602716")) {
                    ipChange.ipc$dispatch("1407602716", new Object[]{this, adapterView, view, Integer.valueOf(i2), Long.valueOf(j), commonAdapter});
                } else if (SendGiftWindow.this.mPropPagerView.getSeletedProp() != null) {
                    GiftUTUtils.propItemClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(SendGiftWindow.this.mPropPagerView.getSeletedProp().isGift(), SendGiftWindow.this.mPropPagerView.getSeletedProp().expire, SendGiftWindow.this.mPropPagerView.getSeletedProp().btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onRefresh() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1771197439")) {
                    ipChange.ipc$dispatch("1771197439", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.refresh(true);
                }
            }
        };
        this.mOnGiftStateClickListener = new GiftStateLayout.OnGiftStateClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onRechargeClick(boolean z2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "235951295")) {
                    ipChange.ipc$dispatch("235951295", new Object[]{this, Boolean.valueOf(z2)});
                } else {
                    SendGiftWindow.this.recharge();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onSendGiftClick(long j) {
                int i2;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-259271266")) {
                    ipChange.ipc$dispatch("-259271266", new Object[]{this, Long.valueOf(j)});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean == null) {
                } else {
                    try {
                        i2 = Integer.parseInt(SendGiftWindow.this.mSelectedGiftInfoBean.coins);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        i2 = 0;
                    }
                    if (i2 > 0) {
                        SendGiftWindow.this.showDmDialog("大麦暂不支持赠送付费礼物，请去优酷app赠送");
                        return;
                    }
                    if (!SendGiftWindow.this.checkCost()) {
                        GiftUTUtils.comboExpose(SendGiftWindow.this.mSelectedGiftInfoBean);
                        if (SendGiftWindow.this.mSelectedNum == 1 && SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.girdViewType != 1) {
                            if (SendGiftWindow.this.mSelectedGiftInfoBean.continuousSend) {
                                SendGiftWindow.this.mSendGiftButton.show();
                                SendGiftWindow.this.isShowCombo = true;
                                SendGiftWindow.this.mGiftStateLayout.setSendBtnVisible(false);
                            } else {
                                ((ILog) Dsl.getService(ILog.class)).i(SendGiftWindow.TAG, "不支持连送");
                                return;
                            }
                        }
                    }
                    SendGiftWindow.this.sendGift();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onShowGiftNumConfig() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-303073797")) {
                    ipChange.ipc$dispatch("-303073797", new Object[]{this});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.multiSend) {
                    if (SendGiftWindow.this.mSelectedGiftInfoBean.numList == null || SendGiftWindow.this.mSelectedGiftInfoBean.numList.size() <= 0) {
                        SendGiftWindow.this.displaySimulationKeyBord();
                    } else {
                        SendGiftWindow.this.showGiftNumListView(true);
                    }
                }
            }
        };
        this.numBottom = -1;
        this.mPropClickListener = new GiftStateLayout.OnPropClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onPropMissionClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-48200519")) {
                    ipChange.ipc$dispatch("-48200519", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.doTaskClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftBoardCallback.onDoMission(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onSendPropClick(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "228754862")) {
                    ipChange.ipc$dispatch("228754862", new Object[]{this, Integer.valueOf(i2)});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.sendPropClickMulti(SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                    if (i2 < 1) {
                        i2 = 1;
                    }
                    SendGiftWindow.this.mGiftBoardCallback.onSendProp(i2, SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onShowNumKeyBoard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "749278946")) {
                    ipChange.ipc$dispatch("749278946", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mOnGiftNumClickListener = new GiftNumSelectView.OnGiftNumClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onNumPannelclose() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1310051711")) {
                    ipChange.ipc$dispatch("1310051711", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "onNumPannelclose");
                SendGiftWindow.this.mGiftStateLayout.setArrOrientation(false);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onSelectedNum(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1481416349")) {
                    ipChange.ipc$dispatch("1481416349", new Object[]{this, Integer.valueOf(i2)});
                    return;
                }
                SendGiftWindow.this.mSelectedNum = i2;
                SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onShowCustomNumKeyboard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1551828814")) {
                    ipChange.ipc$dispatch("-1551828814", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mClickSureListener = new GiftNumKeyBoardView.ClickSureListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.12
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.ClickSureListener
            public void onNumConfirm(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "955782180")) {
                    ipChange.ipc$dispatch("955782180", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                if (j != 0) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "onNumConfirm  = " + SendGiftWindow.this.isShowProp);
                    if (SendGiftWindow.this.isShowProp) {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update PROP num  = " + j);
                        SendGiftWindow.this.mGiftStateLayout.setSelPropNum(j);
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update gift num  = " + j);
                        SendGiftWindow.this.mSelectedNum = j;
                        SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
                    }
                }
                SendGiftWindow.this.switchDisplayBoard(0);
            }
        };
        this.YKPACKAGE = AXPParamsProvider.ClientType.YOUKU;
        this.mContext = context;
        this.mGiftRowNum = i;
        this.mIsLandscape = z;
        initView(context);
    }

    public SendGiftWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DISPLAY_GIFT_BOARD = 0;
        this.DISPLAY_NUM_KEY_BOARD = 1;
        this.mGiftRowNum = 2;
        this.mSelectedGiftInfoBean = null;
        this.mSelectedNum = 1L;
        this.mGiftBaseViews = new ArrayList<>();
        this.mTitles = new ArrayList<>();
        this.categoryGiftBeanArrayList = new ArrayList();
        this.selPositions = new ArrayList<>();
        this.mLastSelectedGid = null;
        this.mLastSelectedPid = null;
        this.args = "";
        this.mScreenId = "";
        this.mIsLandscape = false;
        this.mComboInterval = 10;
        this.mCurrentGroupId = "";
        this.mCurrentTitle = "";
        this.mSelectedTargetIds = "";
        this.mRoomId = "";
        this.isShowCombo = false;
        this.isShowProp = false;
        this.hasPack = false;
        this.hasPackTip = false;
        this.mCurrentTabPosition = 0;
        this.isClosing = false;
        this.isNewComb = 1;
        this.mTargetLayoutListner = new MultiTargetListView.EventListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onClick(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1827109741")) {
                    ipChange.ipc$dispatch("1827109741", new Object[]{this, giftTargetInfoBean});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onExposed(List<GiftTargetInfoBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1374779564")) {
                    ipChange.ipc$dispatch("1374779564", new Object[]{this, list});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void openUserCard(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1372192131")) {
                    ipChange.ipc$dispatch("1372192131", new Object[]{this, giftTargetInfoBean});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || giftTargetInfoBean == null) {
                } else {
                    SendGiftWindow.this.mGiftBoardCallback.openUserCard(giftTargetInfoBean.id);
                }
            }
        };
        this.mPropListener = new PropShowView.PropListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void morePropBtnClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-13246677")) {
                    ipChange.ipc$dispatch("-13246677", new Object[]{this});
                    return;
                }
                GiftUTUtils.taskBoardClick();
                if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.morePropBtnClick();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onChildPageChange(int i2, List<GiftPropBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-424566955")) {
                    ipChange.ipc$dispatch("-424566955", new Object[]{this, Integer.valueOf(i2), list});
                } else {
                    GiftUTUtils.propPageChange(list);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemChecked(GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2005935740")) {
                    ipChange.ipc$dispatch("2005935740", new Object[]{this, giftPropBean});
                } else if (giftPropBean != null) {
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(giftPropBean.isGift(), giftPropBean.expire, giftPropBean.btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j, CommonAdapter<GiftPropBean> commonAdapter) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1407602716")) {
                    ipChange.ipc$dispatch("1407602716", new Object[]{this, adapterView, view, Integer.valueOf(i2), Long.valueOf(j), commonAdapter});
                } else if (SendGiftWindow.this.mPropPagerView.getSeletedProp() != null) {
                    GiftUTUtils.propItemClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(SendGiftWindow.this.mPropPagerView.getSeletedProp().isGift(), SendGiftWindow.this.mPropPagerView.getSeletedProp().expire, SendGiftWindow.this.mPropPagerView.getSeletedProp().btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onRefresh() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1771197439")) {
                    ipChange.ipc$dispatch("1771197439", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.refresh(true);
                }
            }
        };
        this.mOnGiftStateClickListener = new GiftStateLayout.OnGiftStateClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onRechargeClick(boolean z2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "235951295")) {
                    ipChange.ipc$dispatch("235951295", new Object[]{this, Boolean.valueOf(z2)});
                } else {
                    SendGiftWindow.this.recharge();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onSendGiftClick(long j) {
                int i2;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-259271266")) {
                    ipChange.ipc$dispatch("-259271266", new Object[]{this, Long.valueOf(j)});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean == null) {
                } else {
                    try {
                        i2 = Integer.parseInt(SendGiftWindow.this.mSelectedGiftInfoBean.coins);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        i2 = 0;
                    }
                    if (i2 > 0) {
                        SendGiftWindow.this.showDmDialog("大麦暂不支持赠送付费礼物，请去优酷app赠送");
                        return;
                    }
                    if (!SendGiftWindow.this.checkCost()) {
                        GiftUTUtils.comboExpose(SendGiftWindow.this.mSelectedGiftInfoBean);
                        if (SendGiftWindow.this.mSelectedNum == 1 && SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.girdViewType != 1) {
                            if (SendGiftWindow.this.mSelectedGiftInfoBean.continuousSend) {
                                SendGiftWindow.this.mSendGiftButton.show();
                                SendGiftWindow.this.isShowCombo = true;
                                SendGiftWindow.this.mGiftStateLayout.setSendBtnVisible(false);
                            } else {
                                ((ILog) Dsl.getService(ILog.class)).i(SendGiftWindow.TAG, "不支持连送");
                                return;
                            }
                        }
                    }
                    SendGiftWindow.this.sendGift();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onShowGiftNumConfig() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-303073797")) {
                    ipChange.ipc$dispatch("-303073797", new Object[]{this});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.multiSend) {
                    if (SendGiftWindow.this.mSelectedGiftInfoBean.numList == null || SendGiftWindow.this.mSelectedGiftInfoBean.numList.size() <= 0) {
                        SendGiftWindow.this.displaySimulationKeyBord();
                    } else {
                        SendGiftWindow.this.showGiftNumListView(true);
                    }
                }
            }
        };
        this.numBottom = -1;
        this.mPropClickListener = new GiftStateLayout.OnPropClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onPropMissionClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-48200519")) {
                    ipChange.ipc$dispatch("-48200519", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.doTaskClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftBoardCallback.onDoMission(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onSendPropClick(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "228754862")) {
                    ipChange.ipc$dispatch("228754862", new Object[]{this, Integer.valueOf(i2)});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.sendPropClickMulti(SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                    if (i2 < 1) {
                        i2 = 1;
                    }
                    SendGiftWindow.this.mGiftBoardCallback.onSendProp(i2, SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onShowNumKeyBoard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "749278946")) {
                    ipChange.ipc$dispatch("749278946", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mOnGiftNumClickListener = new GiftNumSelectView.OnGiftNumClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onNumPannelclose() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1310051711")) {
                    ipChange.ipc$dispatch("1310051711", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "onNumPannelclose");
                SendGiftWindow.this.mGiftStateLayout.setArrOrientation(false);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onSelectedNum(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1481416349")) {
                    ipChange.ipc$dispatch("1481416349", new Object[]{this, Integer.valueOf(i2)});
                    return;
                }
                SendGiftWindow.this.mSelectedNum = i2;
                SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onShowCustomNumKeyboard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1551828814")) {
                    ipChange.ipc$dispatch("-1551828814", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mClickSureListener = new GiftNumKeyBoardView.ClickSureListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.12
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.ClickSureListener
            public void onNumConfirm(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "955782180")) {
                    ipChange.ipc$dispatch("955782180", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                if (j != 0) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "onNumConfirm  = " + SendGiftWindow.this.isShowProp);
                    if (SendGiftWindow.this.isShowProp) {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update PROP num  = " + j);
                        SendGiftWindow.this.mGiftStateLayout.setSelPropNum(j);
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update gift num  = " + j);
                        SendGiftWindow.this.mSelectedNum = j;
                        SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
                    }
                }
                SendGiftWindow.this.switchDisplayBoard(0);
            }
        };
        this.YKPACKAGE = AXPParamsProvider.ClientType.YOUKU;
        this.mContext = context;
        initView(context);
    }

    public SendGiftWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DISPLAY_GIFT_BOARD = 0;
        this.DISPLAY_NUM_KEY_BOARD = 1;
        this.mGiftRowNum = 2;
        this.mSelectedGiftInfoBean = null;
        this.mSelectedNum = 1L;
        this.mGiftBaseViews = new ArrayList<>();
        this.mTitles = new ArrayList<>();
        this.categoryGiftBeanArrayList = new ArrayList();
        this.selPositions = new ArrayList<>();
        this.mLastSelectedGid = null;
        this.mLastSelectedPid = null;
        this.args = "";
        this.mScreenId = "";
        this.mIsLandscape = false;
        this.mComboInterval = 10;
        this.mCurrentGroupId = "";
        this.mCurrentTitle = "";
        this.mSelectedTargetIds = "";
        this.mRoomId = "";
        this.isShowCombo = false;
        this.isShowProp = false;
        this.hasPack = false;
        this.hasPackTip = false;
        this.mCurrentTabPosition = 0;
        this.isClosing = false;
        this.isNewComb = 1;
        this.mTargetLayoutListner = new MultiTargetListView.EventListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onClick(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1827109741")) {
                    ipChange.ipc$dispatch("1827109741", new Object[]{this, giftTargetInfoBean});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void onExposed(List<GiftTargetInfoBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1374779564")) {
                    ipChange.ipc$dispatch("1374779564", new Object[]{this, list});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.EventListener
            public void openUserCard(GiftTargetInfoBean giftTargetInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1372192131")) {
                    ipChange.ipc$dispatch("1372192131", new Object[]{this, giftTargetInfoBean});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || giftTargetInfoBean == null) {
                } else {
                    SendGiftWindow.this.mGiftBoardCallback.openUserCard(giftTargetInfoBean.id);
                }
            }
        };
        this.mPropListener = new PropShowView.PropListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void morePropBtnClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-13246677")) {
                    ipChange.ipc$dispatch("-13246677", new Object[]{this});
                    return;
                }
                GiftUTUtils.taskBoardClick();
                if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.morePropBtnClick();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onChildPageChange(int i2, List<GiftPropBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-424566955")) {
                    ipChange.ipc$dispatch("-424566955", new Object[]{this, Integer.valueOf(i2), list});
                } else {
                    GiftUTUtils.propPageChange(list);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemChecked(GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2005935740")) {
                    ipChange.ipc$dispatch("2005935740", new Object[]{this, giftPropBean});
                } else if (giftPropBean != null) {
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(giftPropBean.isGift(), giftPropBean.expire, giftPropBean.btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j, CommonAdapter<GiftPropBean> commonAdapter) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1407602716")) {
                    ipChange.ipc$dispatch("1407602716", new Object[]{this, adapterView, view, Integer.valueOf(i2), Long.valueOf(j), commonAdapter});
                } else if (SendGiftWindow.this.mPropPagerView.getSeletedProp() != null) {
                    GiftUTUtils.propItemClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftStateLayout.updatePropTip(SendGiftWindow.this.mPropPagerView.getSeletedProp().isGift(), SendGiftWindow.this.mPropPagerView.getSeletedProp().expire, SendGiftWindow.this.mPropPagerView.getSeletedProp().btn);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.PropShowView.PropListener
            public void onRefresh() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1771197439")) {
                    ipChange.ipc$dispatch("1771197439", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback != null) {
                    SendGiftWindow.this.mGiftBoardCallback.refresh(true);
                }
            }
        };
        this.mOnGiftStateClickListener = new GiftStateLayout.OnGiftStateClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onRechargeClick(boolean z2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "235951295")) {
                    ipChange.ipc$dispatch("235951295", new Object[]{this, Boolean.valueOf(z2)});
                } else {
                    SendGiftWindow.this.recharge();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onSendGiftClick(long j) {
                int i2;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-259271266")) {
                    ipChange.ipc$dispatch("-259271266", new Object[]{this, Long.valueOf(j)});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean == null) {
                } else {
                    try {
                        i2 = Integer.parseInt(SendGiftWindow.this.mSelectedGiftInfoBean.coins);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        i2 = 0;
                    }
                    if (i2 > 0) {
                        SendGiftWindow.this.showDmDialog("大麦暂不支持赠送付费礼物，请去优酷app赠送");
                        return;
                    }
                    if (!SendGiftWindow.this.checkCost()) {
                        GiftUTUtils.comboExpose(SendGiftWindow.this.mSelectedGiftInfoBean);
                        if (SendGiftWindow.this.mSelectedNum == 1 && SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.girdViewType != 1) {
                            if (SendGiftWindow.this.mSelectedGiftInfoBean.continuousSend) {
                                SendGiftWindow.this.mSendGiftButton.show();
                                SendGiftWindow.this.isShowCombo = true;
                                SendGiftWindow.this.mGiftStateLayout.setSendBtnVisible(false);
                            } else {
                                ((ILog) Dsl.getService(ILog.class)).i(SendGiftWindow.TAG, "不支持连送");
                                return;
                            }
                        }
                    }
                    SendGiftWindow.this.sendGift();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnGiftStateClickListener
            public void onShowGiftNumConfig() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-303073797")) {
                    ipChange.ipc$dispatch("-303073797", new Object[]{this});
                } else if (SendGiftWindow.this.mSelectedGiftInfoBean != null && SendGiftWindow.this.mSelectedGiftInfoBean.multiSend) {
                    if (SendGiftWindow.this.mSelectedGiftInfoBean.numList == null || SendGiftWindow.this.mSelectedGiftInfoBean.numList.size() <= 0) {
                        SendGiftWindow.this.displaySimulationKeyBord();
                    } else {
                        SendGiftWindow.this.showGiftNumListView(true);
                    }
                }
            }
        };
        this.numBottom = -1;
        this.mPropClickListener = new GiftStateLayout.OnPropClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onPropMissionClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-48200519")) {
                    ipChange.ipc$dispatch("-48200519", new Object[]{this});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.doTaskClick(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                    SendGiftWindow.this.mGiftBoardCallback.onDoMission(SendGiftWindow.this.mPropPagerView.getSeletedProp());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onSendPropClick(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "228754862")) {
                    ipChange.ipc$dispatch("228754862", new Object[]{this, Integer.valueOf(i2)});
                } else if (SendGiftWindow.this.mGiftBoardCallback == null || SendGiftWindow.this.mPropPagerView.getSeletedProp() == null) {
                } else {
                    GiftUTUtils.sendPropClickMulti(SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                    if (i2 < 1) {
                        i2 = 1;
                    }
                    SendGiftWindow.this.mGiftBoardCallback.onSendProp(i2, SendGiftWindow.this.mPropPagerView.getSeletedProp(), SendGiftWindow.this.mMultiTargetLayout.getTargetInfos());
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.OnPropClickListener
            public void onShowNumKeyBoard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "749278946")) {
                    ipChange.ipc$dispatch("749278946", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mOnGiftNumClickListener = new GiftNumSelectView.OnGiftNumClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onNumPannelclose() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1310051711")) {
                    ipChange.ipc$dispatch("1310051711", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "onNumPannelclose");
                SendGiftWindow.this.mGiftStateLayout.setArrOrientation(false);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onSelectedNum(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1481416349")) {
                    ipChange.ipc$dispatch("1481416349", new Object[]{this, Integer.valueOf(i2)});
                    return;
                }
                SendGiftWindow.this.mSelectedNum = i2;
                SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumSelectView.OnGiftNumClickListener
            public void onShowCustomNumKeyboard() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1551828814")) {
                    ipChange.ipc$dispatch("-1551828814", new Object[]{this});
                } else {
                    SendGiftWindow.this.displaySimulationKeyBord();
                }
            }
        };
        this.mClickSureListener = new GiftNumKeyBoardView.ClickSureListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.12
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GiftNumKeyBoardView.ClickSureListener
            public void onNumConfirm(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "955782180")) {
                    ipChange.ipc$dispatch("955782180", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                if (j != 0) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "onNumConfirm  = " + SendGiftWindow.this.isShowProp);
                    if (SendGiftWindow.this.isShowProp) {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update PROP num  = " + j);
                        SendGiftWindow.this.mGiftStateLayout.setSelPropNum(j);
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "update gift num  = " + j);
                        SendGiftWindow.this.mSelectedNum = j;
                        SendGiftWindow.this.mGiftStateLayout.setSelNum(SendGiftWindow.this.mSelectedNum);
                    }
                }
                SendGiftWindow.this.switchDisplayBoard(0);
            }
        };
        this.YKPACKAGE = AXPParamsProvider.ClientType.YOUKU;
        this.mContext = context;
        initView(context);
    }
}
