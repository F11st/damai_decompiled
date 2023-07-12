package com.youku.live.dago.widgetlib.view.usercard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.model.event.FollowAnchorEvent;
import com.youku.live.dago.utils.ShapeBuilder;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.DeviceUtils;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.usercard.MaxHeightRecyclerView;
import com.youku.live.dago.widgetlib.usercard.UserVideoAdapter;
import com.youku.live.dago.widgetlib.util.LiveAppUtil;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.im.IImChannel;
import com.youku.live.dsl.im.RedPointCallBack;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.usercenter.passport.PassportManager;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoUserCardView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DAGO_LIVE_ACTOR_ATTENTION = "mtop.tudou.subscribe.relation.RelationServiceMTOP.create";
    private static final int MSG_UPDATE_HEADER_UI = 257;
    private static final int MSG_UPDATE_PRIVATE_CHAT_RED_POINT = 258;
    private static final String TAG = "DagoUserCardView";
    private boolean isShowLiveManageBtn;
    private FrameLayout mAvatarBg;
    private View mBtnAttention;
    private LinearLayout mBtnAttentionSmall;
    private View mBtnHeaderView;
    private View mBtnHome;
    private LinearLayout mBtnHomeSmall;
    private View mBtnLiveManageSmall;
    private View mBtnPrivateChat;
    private Handler mHandler;
    private ImageView mImgHome;
    private ImageView mImgPrivateChat;
    private UserVideoAdapter.ItemClickListener mItemClickLister;
    private ImageView mIvAttention;
    private ImageView mIvAvatar;
    private ImageView mIvGender;
    private ImageView mIvLevel;
    private ImageView mIvPrivateChatRedPoint;
    private ImageView mIvYoukuTag;
    private RelativeLayout mLayoutAvatar;
    private RelativeLayout mLayoutHeader;
    private LinearLayout mLayoutName;
    private LinearLayout mLayoutWrapper;
    private OnUserCardListener mListener;
    private StaggeredGridLayoutManager mRvLayoutManager;
    private int mRvScrollDy;
    private MaxHeightRecyclerView mRvVideo;
    private TextView mTvAttention;
    private TextView mTvID;
    private TextView mTvIntroduction;
    private TextView mTvName;
    private UserCardInfo mUserCardInfo;
    private UserCardVideoList mUserCardVideoList;
    private UserVideoAdapter mUserVideoAdapter;
    private Orientation orientation;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnUserCardListener {
        void onError(String str);

        void onFollowed(Object obj);

        void onHomeClicked(long j);

        void onLiveManageClicked();

        void onLoginClicked();

        void onPrivateChatClicked(long j, boolean z);

        void onScrolledBottom();

        void onVideoClicked(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int lRMargin;
        private int space;

        public SpacesItemDecoration(int i) {
            this.lRMargin = 0;
            this.space = i;
            this.lRMargin = DensityUtil.dip2px(AppContextUtils.getApp(), 15.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) > 0) {
                if (((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex() % 2 == 0) {
                    int i = this.space;
                    rect.left = this.lRMargin + i;
                    rect.right = i;
                } else {
                    int i2 = this.space;
                    rect.left = i2;
                    rect.right = i2 + this.lRMargin;
                }
                int i3 = this.space;
                rect.bottom = i3;
                rect.top = i3;
                return;
            }
            rect.left = 0;
            rect.right = 0;
            rect.top = 0;
            rect.bottom = 0;
        }
    }

    public DagoUserCardView(@NonNull Context context) {
        super(context);
        this.orientation = Orientation.ORIENTATION_PORTAIT;
        this.mHandler = new Handler() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1137112132")) {
                    ipChange.ipc$dispatch("1137112132", new Object[]{this, message});
                    return;
                }
                int i = message.what;
                if (i != 257) {
                    if (i != 258) {
                        return;
                    }
                    DagoUserCardView.this.showOrHideChatRedPoint(((Boolean) message.obj).booleanValue());
                    return;
                }
                DagoUserCardView.this.updateHeaderUI();
                Message obtain = Message.obtain();
                obtain.what = 257;
                DagoUserCardView.this.mHandler.sendMessageDelayed(obtain, 5L);
            }
        };
        this.mItemClickLister = new UserVideoAdapter.ItemClickListener() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.ItemClickListener
            public void onClickHome(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "500296861")) {
                    ipChange.ipc$dispatch("500296861", new Object[]{this, Long.valueOf(j)});
                }
            }

            @Override // com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.ItemClickListener
            public void onClickVideo(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "694872051")) {
                    ipChange.ipc$dispatch("694872051", new Object[]{this, str});
                } else if (DagoUserCardView.this.mListener != null) {
                    DagoUserCardView.this.mListener.onVideoClicked(str);
                }
            }
        };
        this.mRvScrollDy = 0;
        this.isShowLiveManageBtn = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findMax(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612369677")) {
            return ((Integer) ipChange.ipc$dispatch("-612369677", new Object[]{this, iArr})).intValue();
        }
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604489315")) {
            ipChange.ipc$dispatch("-1604489315", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R.C7942layout.dago_pgc_user_card_layout, this);
        this.mIvAvatar = (ImageView) findViewById(R.id.iv_anchor_avatar);
        this.mLayoutWrapper = (LinearLayout) findViewById(R.id.layout_dago_user_card_wapper);
        if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_LANDSCAPE && Build.VERSION.SDK_INT >= 21) {
            this.mLayoutWrapper.setOutlineProvider(new ViewOutlineProvider() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1943244653")) {
                        ipChange2.ipc$dispatch("-1943244653", new Object[]{this, view, outline});
                    } else {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), DensityUtil.dip2px(AppContextUtils.getApp(), 15.0f));
                    }
                }
            });
            this.mLayoutWrapper.setClipToOutline(true);
        }
        this.mTvName = (TextView) findViewById(R.id.tv_anchor_name);
        this.mTvIntroduction = (TextView) findViewById(R.id.tv_anchor_introduction);
        this.mIvGender = (ImageView) findViewById(R.id.iv_anchor_gender);
        this.mIvLevel = (ImageView) findViewById(R.id.iv_anchor_level);
        this.mLayoutAvatar = (RelativeLayout) findViewById(R.id.layout_user_card_anchor_avatar);
        this.mLayoutName = (LinearLayout) findViewById(R.id.layout_user_card_anchor_name);
        this.mLayoutHeader = (RelativeLayout) findViewById(R.id.layout_user_card_header);
        this.mBtnHomeSmall = (LinearLayout) findViewById(R.id.layout_dago_user_card_btn_home_small);
        this.mBtnAttentionSmall = (LinearLayout) findViewById(R.id.layout_dago_user_card_btn_attention_small);
        this.mBtnLiveManageSmall = findViewById(R.id.btn_admin);
        this.mBtnHomeSmall.setOnClickListener(this);
        this.mBtnAttentionSmall.setOnClickListener(this);
        this.mBtnLiveManageSmall.setOnClickListener(this);
        this.mAvatarBg = (FrameLayout) findViewById(R.id.layout_user_card_avatar_bg);
        this.mIvYoukuTag = (ImageView) findViewById(R.id.iv_user_card_youku_tag);
        View inflate = LayoutInflater.from(getContext()).inflate(R.C7942layout.dago_pgc_user_card_videos_header, (ViewGroup) null, false);
        this.mBtnHeaderView = inflate;
        inflate.setBackgroundColor(-1);
        this.mTvID = (TextView) this.mBtnHeaderView.findViewById(R.id.tv_dago_user_card_anchor_id);
        this.mBtnHome = this.mBtnHeaderView.findViewById(R.id.layout_dago_user_card_btn_home);
        this.mImgHome = (ImageView) this.mBtnHeaderView.findViewById(R.id.img_dago_user_card_btn_home);
        this.mBtnPrivateChat = this.mBtnHeaderView.findViewById(R.id.layout_dago_user_card_btn_private_chat);
        this.mImgPrivateChat = (ImageView) this.mBtnHeaderView.findViewById(R.id.img_dago_user_card_btn_private_chat);
        this.mBtnAttention = this.mBtnHeaderView.findViewById(R.id.layout_dago_user_card_btn_attention);
        this.mTvAttention = (TextView) this.mBtnHeaderView.findViewById(R.id.tv_dago_pgc_user_attention_btn);
        this.mIvAttention = (ImageView) this.mBtnHeaderView.findViewById(R.id.iv_dago_pgc_user_attention_btn);
        this.mIvPrivateChatRedPoint = (ImageView) this.mBtnHeaderView.findViewById(R.id.iv_red_point);
        this.mBtnHome.setOnClickListener(this);
        this.mBtnPrivateChat.setOnClickListener(this);
        this.mBtnAttention.setOnClickListener(this);
        this.mRvVideo = (MaxHeightRecyclerView) findViewById(R.id.list_user_card_videos);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.mRvLayoutManager = staggeredGridLayoutManager;
        this.mRvVideo.setLayoutManager(staggeredGridLayoutManager);
        this.mRvVideo.addItemDecoration(new SpacesItemDecoration(DensityUtil.dip2px(AppContextUtils.getApp(), 5.0f)));
        UserVideoAdapter userVideoAdapter = new UserVideoAdapter(getContext(), new ArrayList());
        this.mUserVideoAdapter = userVideoAdapter;
        this.mRvVideo.setAdapter(userVideoAdapter);
        this.mUserVideoAdapter.setClickListener(this.mItemClickLister);
        this.mRvVideo.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.4
            private static transient /* synthetic */ IpChange $ipChange;
            boolean isSlidingToLast = false;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-75888710")) {
                    ipChange2.ipc$dispatch("-75888710", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    int itemCount = DagoUserCardView.this.mRvLayoutManager.getItemCount();
                    int[] iArr = new int[DagoUserCardView.this.mRvLayoutManager.getSpanCount()];
                    DagoUserCardView.this.mRvLayoutManager.findLastVisibleItemPositions(iArr);
                    int findMax = DagoUserCardView.this.findMax(iArr);
                    if (DagoUserCardView.this.mRvLayoutManager.getChildCount() > 0 && findMax >= itemCount - 1 && DagoUserCardView.this.mListener != null) {
                        DagoUserCardView.this.mListener.onScrolledBottom();
                    }
                }
                if (i == 0) {
                    DagoUserCardView.this.mHandler.removeCallbacksAndMessages(null);
                } else if (i == 1) {
                    DagoUserCardView.this.mHandler.sendEmptyMessage(257);
                }
                ((ILog) Dsl.getService(ILog.class)).i(DagoUserCardView.TAG, "scroll state : " + i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2116450085")) {
                    ipChange2.ipc$dispatch("2116450085", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                ((ILog) Dsl.getService(ILog.class)).i(DagoUserCardView.TAG, "dx = " + i + ", dy = " + i2);
                if (i2 > 0) {
                    this.isSlidingToLast = true;
                } else {
                    this.isSlidingToLast = false;
                }
                DagoUserCardView.this.mRvScrollDy += i2;
                ((ILog) Dsl.getService(ILog.class)).i(DagoUserCardView.TAG, "scroll y : " + DagoUserCardView.this.mRvScrollDy);
            }
        });
        this.mRvScrollDy = 0;
        this.mUserVideoAdapter.addHeaderView(this.mBtnHeaderView);
        if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
            this.mRvVideo.setMaxHeight(DensityUtil.dip2px(AppContextUtils.getApp(), 258.0f));
        }
        if (LiveAppUtil.isStarLive()) {
            this.mBtnHome.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOrHideChatRedPoint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172303488")) {
            ipChange.ipc$dispatch("1172303488", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ImageView imageView = this.mIvPrivateChatRedPoint;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAttentionButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263077790")) {
            ipChange.ipc$dispatch("1263077790", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mBtnAttention.setOnClickListener(null);
            this.mTvAttention.setVisibility(8);
            this.mIvAttention.setVisibility(0);
        } else {
            this.mBtnAttention.setOnClickListener(this);
            this.mIvAttention.setVisibility(8);
            this.mTvAttention.setVisibility(0);
            UserCardInfo userCardInfo = this.mUserCardInfo;
            if (userCardInfo != null && userCardInfo.localType == 0) {
                ShapeBuilder.create().radius(UIUtil.dip2px(getContext(), 17)).gradient(45, Color.parseColor("#37E8FF"), Color.parseColor("#80C6FF"), Color.parseColor("#F586FF")).build(this.mTvAttention);
                ShapeBuilder.create().radius(UIUtil.dip2px(getContext(), 17)).gradient(45, Color.parseColor("#37E8FF"), Color.parseColor("#80C6FF"), Color.parseColor("#F586FF")).build(this.mBtnAttentionSmall);
                return;
            }
            ShapeBuilder.create().radius(UIUtil.dip2px(getContext(), 17)).solid(Color.parseColor("#EAEAEA")).build(this.mTvAttention);
            ShapeBuilder.create().radius(UIUtil.dip2px(getContext(), 17)).solid(Color.parseColor("#EAEAEA")).build(this.mBtnAttentionSmall);
        }
    }

    private void updateChatBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744507006")) {
            ipChange.ipc$dispatch("1744507006", new Object[]{this});
            return;
        }
        UserCardInfo userCardInfo = this.mUserCardInfo;
        if (userCardInfo != null) {
            if (userCardInfo.localType == 0) {
                this.mImgPrivateChat.setImageResource(R.C7941drawable.dago_pgc_user_card_private_chat_btn_icon);
                return;
            } else {
                this.mImgPrivateChat.setImageResource(R.C7941drawable.dago_pgc_user_card_private_chat_btn_icon_no_click);
                return;
            }
        }
        this.mImgPrivateChat.setImageResource(R.C7941drawable.dago_pgc_user_card_private_chat_btn_icon_no_click);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeaderUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363999395")) {
            ipChange.ipc$dispatch("1363999395", new Object[]{this});
            return;
        }
        Log.i("CURRENT_VALUE", "cur value = " + this.mRvScrollDy);
        int i = this.mRvScrollDy;
        if (i <= 10) {
            i = 0;
        }
        if (i >= 180) {
            this.mTvIntroduction.setVisibility(4);
            i = 180;
        } else {
            this.mTvIntroduction.setVisibility(0);
        }
        int dip2px = DensityUtil.dip2px(AppContextUtils.getApp(), 25.0f);
        int i2 = 180 - dip2px;
        float f = 1.0f;
        if (i <= dip2px) {
            f = 0.0f;
        } else {
            float f2 = (float) (((i - dip2px) * 1.0d) / i2);
            if (f2 >= 1.0f) {
                f2 = 1.0f;
            }
            if (!isSlideToBottom(this.mRvVideo)) {
                f = f2;
            }
        }
        double d = 180 - i;
        int i3 = (int) (((42.0d * d) / 180.0d) + 52.0d);
        int i4 = (int) (((40.0d * d) / 180.0d) + 66.0d);
        float f3 = (float) (d / 180.0d);
        int dip2px2 = DensityUtil.dip2px(AppContextUtils.getApp(), (int) (((d * 4.0d) / 180.0d) + 2.0d));
        if (this.mIvYoukuTag.getVisibility() == 0) {
            ((RelativeLayout.LayoutParams) this.mIvYoukuTag.getLayoutParams()).setMargins(0, 0, dip2px2, dip2px2);
        }
        float f4 = i3;
        this.mLayoutAvatar.getLayoutParams().width = DensityUtil.dip2px(AppContextUtils.getApp(), f4);
        this.mLayoutAvatar.getLayoutParams().height = DensityUtil.dip2px(AppContextUtils.getApp(), f4);
        this.mLayoutAvatar.requestLayout();
        ((RelativeLayout.LayoutParams) this.mLayoutName.getLayoutParams()).setMargins(DensityUtil.dip2px(AppContextUtils.getApp(), i4), DensityUtil.dip2px(AppContextUtils.getApp(), 12.0f), 0, 0);
        this.mTvIntroduction.setAlpha(f3);
        UserCardInfo userCardInfo = this.mUserCardInfo;
        if (userCardInfo == null) {
            return;
        }
        if (this.mRvScrollDy <= dip2px) {
            this.mBtnHomeSmall.setVisibility(8);
            this.mBtnAttentionSmall.setVisibility(8);
            setShowLiveManageBtn(this.isShowLiveManageBtn);
        } else {
            if (userCardInfo.isFollower) {
                this.mBtnHomeSmall.setVisibility(0);
                this.mBtnAttentionSmall.setVisibility(8);
                this.mBtnHomeSmall.setAlpha(f);
            } else {
                this.mBtnHomeSmall.setVisibility(8);
                this.mBtnAttentionSmall.setVisibility(0);
                this.mBtnAttentionSmall.setAlpha(f);
            }
            this.mBtnLiveManageSmall.setVisibility(8);
        }
        this.mLayoutHeader.requestLayout();
    }

    private void updateHomeBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546546263")) {
            ipChange.ipc$dispatch("546546263", new Object[]{this});
            return;
        }
        UserCardInfo userCardInfo = this.mUserCardInfo;
        if (userCardInfo != null) {
            if (userCardInfo.localType == 0) {
                this.mImgHome.setImageResource(R.C7941drawable.dago_pgc_user_card_home_btn_icon);
                return;
            } else {
                this.mImgHome.setImageResource(R.C7941drawable.dago_pgc_user_card_home_btn_icon_no_click);
                return;
            }
        }
        this.mImgHome.setImageResource(R.C7941drawable.dago_pgc_user_card_home_btn_icon_no_click);
    }

    private void updatePrivateChatRedPoint() {
        UserCardInfo userCardInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213593868")) {
            ipChange.ipc$dispatch("1213593868", new Object[]{this});
            return;
        }
        IImChannel iImChannel = (IImChannel) Dsl.getService(IImChannel.class);
        if (iImChannel == null || (userCardInfo = this.mUserCardInfo) == null) {
            return;
        }
        iImChannel.checkRedPointWithSomeOne(String.valueOf(userCardInfo.ytid), new RedPointCallBack() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dsl.im.RedPointCallBack
            public void onRedPointStateChanged(boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1927033815")) {
                    ipChange2.ipc$dispatch("1927033815", new Object[]{this, Boolean.valueOf(z)});
                } else {
                    DagoUserCardView.this.showOrHideChatRedPoint(z);
                }
            }
        });
    }

    public void attentionActor(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1608978159")) {
            ipChange.ipc$dispatch("1608978159", new Object[]{this, map});
            return;
        }
        INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop("mtop.tudou.subscribe.relation.RelationServiceMTOP.create", "1.1", map, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1517892835")) {
                        ipChange2.ipc$dispatch("-1517892835", new Object[]{this, iNetResponse});
                        return;
                    }
                    if (iNetResponse != null) {
                        try {
                            if ("SUCCESS".equals(iNetResponse.getRetCode())) {
                                if (DagoUserCardView.this.mUserCardInfo != null) {
                                    DagoUserCardView.this.mUserCardInfo.isFollower = true;
                                    FollowAnchorEvent followAnchorEvent = new FollowAnchorEvent();
                                    followAnchorEvent.ytid = DagoUserCardView.this.mUserCardInfo.ytid;
                                    followAnchorEvent.isFollowed = true;
                                    EventBus.b().i(followAnchorEvent);
                                }
                                DagoUserCardView.this.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.6.1
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IpChange ipChange3 = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange3, "-1728717037")) {
                                            ipChange3.ipc$dispatch("-1728717037", new Object[]{this});
                                            return;
                                        }
                                        DagoUserCardView.this.updateAttentionButton(true);
                                        DagoUserCardView.this.updateHeaderUI();
                                    }
                                });
                                if (DagoUserCardView.this.mListener != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("isFollow", "1");
                                    DagoUserCardView.this.mListener.onFollowed(hashMap);
                                    return;
                                }
                                return;
                            }
                        } catch (Exception unused) {
                            if (DagoUserCardView.this.mListener != null) {
                                DagoUserCardView.this.mListener.onError("关注失败");
                                return;
                            }
                            return;
                        }
                    }
                    if (DagoUserCardView.this.mListener != null) {
                        DagoUserCardView.this.mListener.onError("关注失败");
                    }
                }
            });
        }
    }

    public boolean isSlideToBottom(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-376983381") ? ((Boolean) ipChange.ipc$dispatch("-376983381", new Object[]{this, recyclerView})).booleanValue() : recyclerView != null && recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UserCardInfo userCardInfo;
        OnUserCardListener onUserCardListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934815390")) {
            ipChange.ipc$dispatch("934815390", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id != R.id.layout_dago_user_card_btn_home && id != R.id.layout_dago_user_card_btn_home_small) {
            if (id != R.id.layout_dago_user_card_btn_attention && id != R.id.layout_dago_user_card_btn_attention_small) {
                if (id == R.id.layout_dago_user_card_btn_private_chat) {
                    UserCardInfo userCardInfo2 = this.mUserCardInfo;
                    if (userCardInfo2 != null) {
                        long j = userCardInfo2.ytid;
                        if (j >= 0) {
                            int i = userCardInfo2.localType;
                            if (i == 0) {
                                OnUserCardListener onUserCardListener2 = this.mListener;
                                if (onUserCardListener2 != null) {
                                    onUserCardListener2.onPrivateChatClicked(j, userCardInfo2.isFollower);
                                    return;
                                }
                                return;
                            } else if (i == 1) {
                                ToastUtil.toast(getContext(), "不能和自己私聊哦");
                                return;
                            } else if (i == 2) {
                                ToastUtil.toast(getContext(), "对方未登录，暂时无法和TA私聊哦");
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } else if (view != this.mBtnLiveManageSmall || (userCardInfo = this.mUserCardInfo) == null || userCardInfo.localType != 0 || (onUserCardListener = this.mListener) == null) {
                    return;
                } else {
                    onUserCardListener.onLiveManageClicked();
                    return;
                }
            }
            PassportManager.getInstance().getUserInfo();
            UserCardInfo userCardInfo3 = this.mUserCardInfo;
            if (userCardInfo3 == null || userCardInfo3.ytid < 0) {
                return;
            }
            int i2 = userCardInfo3.localType;
            if (i2 == 1) {
                ToastUtil.toast(getContext(), "不能关注自己哦");
                return;
            } else if (i2 != 0) {
                if (i2 == 2) {
                    ToastUtil.toast(getContext(), "对方未登录，暂时无法关注TA哦");
                    return;
                }
                return;
            } else if (!((ILogin) Dsl.getService(ILogin.class)).isLogined()) {
                ((ILogin) Dsl.getService(ILogin.class)).login();
                OnUserCardListener onUserCardListener3 = this.mListener;
                if (onUserCardListener3 != null) {
                    onUserCardListener3.onLoginClicked();
                    return;
                }
                return;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("target_id", this.mUserCardInfo.ytid + "");
                hashMap.put("guid", DeviceUtils.getGUID(AppContextUtils.getApp()));
                hashMap.put("is_utdid", "false");
                hashMap.put("platform", "0");
                hashMap.put("did", "6");
                attentionActor(hashMap);
                return;
            }
        }
        UserCardInfo userCardInfo4 = this.mUserCardInfo;
        if (userCardInfo4 != null) {
            long j2 = userCardInfo4.ytid;
            if (j2 >= 0) {
                int i3 = userCardInfo4.localType;
                if (i3 == 0) {
                    OnUserCardListener onUserCardListener4 = this.mListener;
                    if (onUserCardListener4 != null) {
                        onUserCardListener4.onHomeClicked(j2);
                    }
                } else if (i3 == 1) {
                    ToastUtil.toast(getContext(), "该功能暂不可用");
                } else if (i3 == 2) {
                    ToastUtil.toast(getContext(), "对方未登录，暂时无法访问TA的主页哦");
                }
            }
        }
    }

    public void setShowChatEntrance(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1919779580")) {
            ipChange.ipc$dispatch("-1919779580", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.mBtnPrivateChat;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setShowLiveManageBtn(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004765363")) {
            ipChange.ipc$dispatch("2004765363", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShowLiveManageBtn = z;
        View view = this.mBtnLiveManageSmall;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setUserCardViewListener(OnUserCardListener onUserCardListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264910080")) {
            ipChange.ipc$dispatch("-264910080", new Object[]{this, onUserCardListener});
        } else {
            this.mListener = onUserCardListener;
        }
    }

    public void updateUserCardInfo(UserCardTabInfo userCardTabInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477880669")) {
            ipChange.ipc$dispatch("-477880669", new Object[]{this, userCardTabInfo, Boolean.valueOf(z)});
        } else if (userCardTabInfo == null) {
        } else {
            if (!z) {
                UserCardVideoList userCardVideoList = userCardTabInfo.recDataVO;
                this.mUserCardVideoList = userCardVideoList;
                updateVideoList(userCardVideoList, true);
                return;
            }
            UserCardInfo userCardInfo = userCardTabInfo.userCardVO;
            this.mUserCardInfo = userCardInfo;
            this.mUserCardVideoList = userCardTabInfo.recDataVO;
            updateUserCardInfo(userCardInfo);
            updateVideoList(this.mUserCardVideoList, false);
        }
    }

    public void updateVideoList(UserCardVideoList userCardVideoList, boolean z) {
        List<UserCardVideo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330772085")) {
            ipChange.ipc$dispatch("-1330772085", new Object[]{this, userCardVideoList, Boolean.valueOf(z)});
        } else if (LiveAppUtil.isStarLive()) {
        } else {
            List<UserCardVideo> videos = this.mUserVideoAdapter.getVideos();
            if ((userCardVideoList != null && (list = userCardVideoList.itemList) != null && list.size() > 0) || (videos != null && videos.size() > 0)) {
                this.mBtnHeaderView.setBackgroundColor(0);
                if (z) {
                    this.mUserVideoAdapter.addVideos(userCardVideoList.itemList);
                    return;
                } else {
                    this.mUserVideoAdapter.updateVideos(userCardVideoList.itemList);
                    return;
                }
            }
            this.mBtnHeaderView.setBackgroundColor(-1);
        }
    }

    public void updateUserCardInfo(UserCardInfo userCardInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004112754")) {
            ipChange.ipc$dispatch("-2004112754", new Object[]{this, userCardInfo});
        } else if (userCardInfo == null) {
        } else {
            int i = userCardInfo.localType;
            if (i == 0 || i == 1) {
                if (!TextUtils.isEmpty(userCardInfo.avatar)) {
                    DagoImageLoader.getInstance().showCircle(getContext(), userCardInfo.avatar, this.mIvAvatar);
                }
                TextView textView = this.mTvID;
                textView.setText("ID : " + userCardInfo.ytid);
                this.mTvName.setText(userCardInfo.nickName);
                this.mTvIntroduction.setText(userCardInfo.description);
                int i2 = userCardInfo.userGender;
                if (i2 == 2) {
                    this.mIvGender.setVisibility(8);
                } else if (i2 == 0) {
                    this.mIvGender.setImageResource(R.C7941drawable.dago_pgc_user_card_female_icon);
                    this.mIvGender.setVisibility(0);
                } else {
                    this.mIvGender.setImageResource(R.C7941drawable.dago_pgc_user_card_male_icon);
                    this.mIvGender.setVisibility(0);
                }
                this.mIvLevel.setVisibility(0);
            } else if (i == 2) {
                this.mIvAvatar.setImageResource(R.C7941drawable.dago_user_card_visitor_img);
                this.mTvID.setText("");
                this.mTvName.setText(userCardInfo.nickName);
                this.mTvIntroduction.setText("");
                this.mIvGender.setVisibility(8);
                this.mIvLevel.setVisibility(8);
            }
            if (userCardInfo.isPugc == 1) {
                this.mAvatarBg.setBackgroundResource(R.C7941drawable.dago_pgc_user_card_anchor_avatar_tag_circle);
                this.mIvYoukuTag.setVisibility(0);
            } else {
                this.mAvatarBg.setBackgroundResource(R.C7941drawable.dago_pgc_user_card_anchor_avatar_bg);
                this.mIvYoukuTag.setVisibility(8);
            }
            int i3 = R.C7941drawable.dago_user_card_userlevel_normal;
            switch (userCardInfo.userLevel) {
                case 1:
                    i3 = R.C7941drawable.dago_user_card_userlevel_1;
                    break;
                case 2:
                    i3 = R.C7941drawable.dago_user_card_userlevel_2;
                    break;
                case 3:
                    i3 = R.C7941drawable.dago_user_card_userlevel_3;
                    break;
                case 4:
                    i3 = R.C7941drawable.dago_user_card_userlevel_4;
                    break;
                case 5:
                    i3 = R.C7941drawable.dago_user_card_userlevel_5;
                    break;
                case 6:
                    i3 = R.C7941drawable.dago_user_card_userlevel_6;
                    break;
                case 7:
                    i3 = R.C7941drawable.dago_user_card_userlevel_7;
                    break;
            }
            this.mIvLevel.setImageResource(i3);
            updateAttentionButton(userCardInfo.isFollower);
            updatePrivateChatRedPoint();
            updateChatBackground();
            updateHomeBackground();
        }
    }

    public DagoUserCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = Orientation.ORIENTATION_PORTAIT;
        this.mHandler = new Handler() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1137112132")) {
                    ipChange.ipc$dispatch("1137112132", new Object[]{this, message});
                    return;
                }
                int i = message.what;
                if (i != 257) {
                    if (i != 258) {
                        return;
                    }
                    DagoUserCardView.this.showOrHideChatRedPoint(((Boolean) message.obj).booleanValue());
                    return;
                }
                DagoUserCardView.this.updateHeaderUI();
                Message obtain = Message.obtain();
                obtain.what = 257;
                DagoUserCardView.this.mHandler.sendMessageDelayed(obtain, 5L);
            }
        };
        this.mItemClickLister = new UserVideoAdapter.ItemClickListener() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.ItemClickListener
            public void onClickHome(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "500296861")) {
                    ipChange.ipc$dispatch("500296861", new Object[]{this, Long.valueOf(j)});
                }
            }

            @Override // com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.ItemClickListener
            public void onClickVideo(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "694872051")) {
                    ipChange.ipc$dispatch("694872051", new Object[]{this, str});
                } else if (DagoUserCardView.this.mListener != null) {
                    DagoUserCardView.this.mListener.onVideoClicked(str);
                }
            }
        };
        this.mRvScrollDy = 0;
        this.isShowLiveManageBtn = false;
        init();
    }

    public DagoUserCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = Orientation.ORIENTATION_PORTAIT;
        this.mHandler = new Handler() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1137112132")) {
                    ipChange.ipc$dispatch("1137112132", new Object[]{this, message});
                    return;
                }
                int i2 = message.what;
                if (i2 != 257) {
                    if (i2 != 258) {
                        return;
                    }
                    DagoUserCardView.this.showOrHideChatRedPoint(((Boolean) message.obj).booleanValue());
                    return;
                }
                DagoUserCardView.this.updateHeaderUI();
                Message obtain = Message.obtain();
                obtain.what = 257;
                DagoUserCardView.this.mHandler.sendMessageDelayed(obtain, 5L);
            }
        };
        this.mItemClickLister = new UserVideoAdapter.ItemClickListener() { // from class: com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.ItemClickListener
            public void onClickHome(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "500296861")) {
                    ipChange.ipc$dispatch("500296861", new Object[]{this, Long.valueOf(j)});
                }
            }

            @Override // com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.ItemClickListener
            public void onClickVideo(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "694872051")) {
                    ipChange.ipc$dispatch("694872051", new Object[]{this, str});
                } else if (DagoUserCardView.this.mListener != null) {
                    DagoUserCardView.this.mListener.onVideoClicked(str);
                }
            }
        };
        this.mRvScrollDy = 0;
        this.isShowLiveManageBtn = false;
        init();
    }
}
