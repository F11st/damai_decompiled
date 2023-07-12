package com.youku.live.dago.liveplayback.widget.view.endPage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.compat.effects.a;
import com.taobao.uikit.extend.feature.features.PhenixOptions;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dago.liveplayback.widget.Mapper.EndPageDataMapper;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.model.EndPageModel;
import com.youku.live.dago.liveplayback.widget.model.EndPageRecommendModel;
import com.youku.live.dago.liveplayback.widget.model.EndPageShortVideoModel;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.log.ILog;
import com.youku.utils.ToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import tb.cq;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class EndPageView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_AVATAR = R.drawable.dago_end_page_default_avatar;
    private static final long DEFAULT_COINS = 0;
    private static final long DEFAULT_FANS = 0;
    private static final String DEFAULT_NICK = "主播";
    private static final long DEFAULT_POPULARITY = 0;
    private static final int LIST_POSITION_ONE = 1;
    private static final int LIST_POSITION_TWO = 2;
    private static final String TAG = "EndView";
    private long actorId;
    private int isAttention;
    private TUrlImageView mActorAvatar;
    private TextView mActorNickTv;
    private Button mAttentionBtn;
    private ImageView mAttentionIcon;
    private EndPageDataMapper.GetAttentionStateListener mAttentionListener;
    private TUrlImageView mBackgroundImageView;
    private View.OnClickListener mClickListener;
    private ImageView mCloseBtn;
    private TextView mCoinNumTv;
    private LinearLayout mContentListView;
    private Context mContext;
    private OnEndPageClickListener mEndPageListener;
    private EndPageModel mEndPageModel;
    private Button mExitPageBtn;
    private EndRecommendView mFirstRecommendView;
    private EndShortVideoView mFirstVideoView;
    private ImageView mGenderIv;
    private Button mJumpActorPageBtn;
    private EndPageDataMapper.GetEndPageDataListener mListener;
    private TextView mPopularityTv;
    private LinearLayout mRecommendTitleView;
    private Button mReplayBtn;
    private EndRecommendView mSecondRecommendView;
    private EndShortVideoView mSecondVideoView;
    private LinearLayout mShortListTitleView;
    private TextView mWatchNumTv;
    private boolean recommendListEmpty;
    private boolean shortVideoListEmpty;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnEndPageClickListener {
        void onAttentionActor();

        void onExitPage();

        void onInjectorCallbackAttention(boolean z);

        void onJumpToActorPage(String str);

        void onJumpToRecommendPage(String str);

        void onJumpToReplayPage(String str, String str2);

        void onJumpToShortVideoPage(String str);

        void onLogin();
    }

    public EndPageView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attentionActor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274133372")) {
            ipChange.ipc$dispatch("1274133372", new Object[]{this});
        } else if (!((ILogin) Dsl.getService(ILogin.class)).isLogined()) {
            this.mEndPageListener.onLogin();
        } else if (this.mEndPageListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("target_id", this.actorId + "");
            hashMap.put("guid", Utils.getGUID(this.mContext));
            hashMap.put("is_utdid", "false");
            hashMap.put("platform", "0");
            hashMap.put("did", "6");
            EndPageDataMapper.getAttentionState(hashMap, this.mAttentionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitEndPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534742219")) {
            ipChange.ipc$dispatch("1534742219", new Object[]{this});
            return;
        }
        OnEndPageClickListener onEndPageClickListener = this.mEndPageListener;
        if (onEndPageClickListener != null) {
            onEndPageClickListener.onExitPage();
        }
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-950592342")) {
            ipChange.ipc$dispatch("-950592342", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.dago_end_page_view, (ViewGroup) this, true);
        this.mBackgroundImageView = (TUrlImageView) findViewById(R.id.end_page_background);
        this.mActorNickTv = (TextView) findViewById(R.id.end_page_nick);
        this.mActorAvatar = (TUrlImageView) findViewById(R.id.end_page_avatar);
        this.mCloseBtn = (ImageView) findViewById(R.id.end_page_close);
        this.mAttentionIcon = (ImageView) findViewById(R.id.end_page_attention_icon);
        this.mGenderIv = (ImageView) findViewById(R.id.end_page_gender);
        this.mAttentionBtn = (Button) findViewById(R.id.end_page_attention);
        this.mJumpActorPageBtn = (Button) findViewById(R.id.end_page_actor_page);
        this.mCoinNumTv = (TextView) findViewById(R.id.end_page_coins);
        this.mWatchNumTv = (TextView) findViewById(R.id.end_page_watch_num);
        this.mPopularityTv = (TextView) findViewById(R.id.end_page_popularity);
        this.mExitPageBtn = (Button) findViewById(R.id.end_page_exit);
        this.mReplayBtn = (Button) findViewById(R.id.end_page_replay);
        this.mFirstVideoView = (EndShortVideoView) findViewById(R.id.end_page_shortVideo_1);
        this.mSecondVideoView = (EndShortVideoView) findViewById(R.id.end_page_shortVideo_2);
        this.mFirstRecommendView = (EndRecommendView) findViewById(R.id.end_page_recommend_1);
        this.mSecondRecommendView = (EndRecommendView) findViewById(R.id.end_page_recommend_2);
        this.mContentListView = (LinearLayout) findViewById(R.id.end_page_content_list);
        this.mShortListTitleView = (LinearLayout) findViewById(R.id.end_page_shortVideo_title);
        this.mRecommendTitleView = (LinearLayout) findViewById(R.id.end_page_recommend_title);
        this.mCloseBtn.setOnClickListener(this.mClickListener);
        this.mAttentionIcon.setOnClickListener(this.mClickListener);
        this.mAttentionBtn.setOnClickListener(this.mClickListener);
        this.mJumpActorPageBtn.setOnClickListener(this.mClickListener);
        this.mExitPageBtn.setOnClickListener(this.mClickListener);
        this.mReplayBtn.setOnClickListener(this.mClickListener);
        this.mFirstVideoView.setOnClickListener(this.mClickListener);
        this.mSecondVideoView.setOnClickListener(this.mClickListener);
        this.mFirstRecommendView.setOnClickListener(this.mClickListener);
        this.mSecondRecommendView.setOnClickListener(this.mClickListener);
        TUrlImageView tUrlImageView = this.mBackgroundImageView;
        int i = R.drawable.dago_end_page_bg;
        tUrlImageView.setImageResource(i);
        this.mBackgroundImageView.setPlaceHoldImageResId(i);
        this.mBackgroundImageView.setFadeIn(true);
        this.mBackgroundImageView.setImageUrl("https://gw.alicdn.com/tfs/TB1sVTsJYj1gK0jSZFOXXc7GpXa-113-244.png", new PhenixOptions().bitmapProcessors(new a(getContext())));
        this.mContext = context;
        setVisibility(8);
        UIUtils.setViewRoundedCorner(this.mActorAvatar, 35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToActorPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097067932")) {
            ipChange.ipc$dispatch("1097067932", new Object[]{this});
            return;
        }
        OnEndPageClickListener onEndPageClickListener = this.mEndPageListener;
        if (onEndPageClickListener != null) {
            onEndPageClickListener.onJumpToActorPage(this.actorId + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToRecommendPage(int i) {
        ArrayList<EndPageRecommendModel> arrayList;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445434926")) {
            ipChange.ipc$dispatch("1445434926", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mEndPageListener == null || (arrayList = this.mEndPageModel.recommendLiveList) == null) {
        } else {
            if (i == 1) {
                str = arrayList.get(0).liveUrl;
            } else {
                str = arrayList.get(1).liveUrl;
            }
            this.mEndPageListener.onJumpToRecommendPage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToReplayPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571011276")) {
            ipChange.ipc$dispatch("-571011276", new Object[]{this});
            return;
        }
        OnEndPageClickListener onEndPageClickListener = this.mEndPageListener;
        if (onEndPageClickListener != null) {
            EndPageModel endPageModel = this.mEndPageModel;
            onEndPageClickListener.onJumpToReplayPage(endPageModel.replayCode, endPageModel.replayUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToShortVideoPage(int i) {
        ArrayList<EndPageShortVideoModel> arrayList;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630135737")) {
            ipChange.ipc$dispatch("-1630135737", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mEndPageListener == null || (arrayList = this.mEndPageModel.shortVideoList) == null) {
        } else {
            if (i == 1) {
                str = arrayList.get(0).playUrl;
            } else {
                str = arrayList.get(1).playUrl;
            }
            this.mEndPageListener.onJumpToShortVideoPage(str);
        }
    }

    private void setAttentionBtnVisible(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377613182")) {
            ipChange.ipc$dispatch("-1377613182", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.isAttention = i;
        if (1 == i) {
            this.mAttentionBtn.setVisibility(8);
            this.mAttentionIcon.setVisibility(8);
            this.mJumpActorPageBtn.setVisibility(0);
            return;
        }
        this.mAttentionIcon.setVisibility(0);
        this.mAttentionBtn.setVisibility(0);
        this.mJumpActorPageBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompletedData(EndPageModel endPageModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266494868")) {
            ipChange.ipc$dispatch("-1266494868", new Object[]{this, endPageModel});
            return;
        }
        this.mActorNickTv.setText(endPageModel.nickName);
        this.mActorAvatar.setImageUrl(endPageModel.avatar, new PhenixOptions().bitmapProcessors(new cq()));
        TextView textView = this.mCoinNumTv;
        String valueOf = String.valueOf(endPageModel.coins);
        Boolean bool = Boolean.FALSE;
        textView.setText(Utils.formatNum(valueOf, bool));
        this.mWatchNumTv.setText(Utils.formatNum(String.valueOf(endPageModel.likeNum), bool));
        this.mPopularityTv.setText(Utils.formatNum(String.valueOf(endPageModel.fansCount), bool));
        int i = endPageModel.gender;
        if (i == 0) {
            this.mGenderIv.setImageResource(R.drawable.dago_end_page_women);
            this.mGenderIv.setVisibility(0);
        } else if (1 == i) {
            this.mGenderIv.setImageResource(R.drawable.dago_end_page_men);
            this.mGenderIv.setVisibility(0);
            this.mGenderIv.setVisibility(0);
        } else {
            this.mGenderIv.setVisibility(8);
        }
        setAttentionBtnVisible(endPageModel.attentioned);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExceptionData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-679578596")) {
            ipChange.ipc$dispatch("-679578596", new Object[]{this});
            return;
        }
        this.mActorAvatar.setImageResource(DEFAULT_AVATAR);
        this.mActorNickTv.setText(DEFAULT_NICK);
        this.mCoinNumTv.setText("0");
        this.mWatchNumTv.setText("0");
        this.mPopularityTv.setText("0");
        this.mReplayBtn.setVisibility(8);
        this.mContentListView.setVisibility(8);
        this.mGenderIv.setVisibility(8);
        this.mAttentionIcon.setVisibility(8);
        this.mAttentionBtn.setVisibility(8);
        this.mJumpActorPageBtn.setVisibility(8);
    }

    private void setReCommendListVisible(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606905914")) {
            ipChange.ipc$dispatch("-606905914", new Object[]{this, Integer.valueOf(i)});
        } else if (1 == i) {
            this.mRecommendTitleView.setVisibility(0);
            this.mFirstRecommendView.setVisibility(0);
            this.mSecondRecommendView.setVisibility(8);
        } else if (2 == i) {
            this.mRecommendTitleView.setVisibility(0);
            this.mFirstRecommendView.setVisibility(0);
            this.mSecondRecommendView.setVisibility(0);
        } else {
            this.mRecommendTitleView.setVisibility(8);
            this.mFirstRecommendView.setVisibility(8);
            this.mSecondRecommendView.setVisibility(8);
        }
    }

    private void setShortVideoListVisible(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541295389")) {
            ipChange.ipc$dispatch("-1541295389", new Object[]{this, Integer.valueOf(i)});
        } else if (1 == i) {
            this.mShortListTitleView.setVisibility(0);
            this.mFirstVideoView.setVisibility(0);
            this.mSecondVideoView.setVisibility(8);
        } else if (2 == i) {
            this.mShortListTitleView.setVisibility(0);
            this.mFirstVideoView.setVisibility(0);
            this.mSecondVideoView.setVisibility(0);
        } else {
            this.mShortListTitleView.setVisibility(8);
            this.mFirstVideoView.setVisibility(8);
            this.mSecondVideoView.setVisibility(8);
        }
    }

    public void getData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040012353")) {
            ipChange.ipc$dispatch("1040012353", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str);
        EndPageDataMapper.getEndPageData(hashMap, this.mListener);
    }

    public void setActorId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456208383")) {
            ipChange.ipc$dispatch("456208383", new Object[]{this, Long.valueOf(j)});
        } else {
            this.actorId = j;
        }
    }

    public void setOnEndPageClickListener(OnEndPageClickListener onEndPageClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175888474")) {
            ipChange.ipc$dispatch("-1175888474", new Object[]{this, onEndPageClickListener});
        } else {
            this.mEndPageListener = onEndPageClickListener;
        }
    }

    public EndPageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EndPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClickListener = new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-844412591")) {
                    ipChange.ipc$dispatch("-844412591", new Object[]{this, view});
                } else if (view.getId() == R.id.end_page_exit) {
                    EndPageView.this.exitEndPage();
                } else if (view.getId() == R.id.end_page_close) {
                    EndPageView.this.exitEndPage();
                } else if (view.getId() == R.id.end_page_replay) {
                    EndPageView.this.jumpToReplayPage();
                } else if (view.getId() == R.id.end_page_shortVideo_1) {
                    EndPageView.this.jumpToShortVideoPage(1);
                } else if (view.getId() == R.id.end_page_shortVideo_2) {
                    EndPageView.this.jumpToShortVideoPage(2);
                } else if (view.getId() == R.id.end_page_recommend_1) {
                    EndPageView.this.jumpToRecommendPage(1);
                } else if (view.getId() == R.id.end_page_recommend_2) {
                    EndPageView.this.jumpToRecommendPage(2);
                } else if (view.getId() == R.id.end_page_attention || view.getId() == R.id.end_page_attention_icon) {
                    EndPageView.this.attentionActor();
                } else if (view.getId() == R.id.end_page_actor_page) {
                    EndPageView.this.jumpToActorPage();
                }
            }
        };
        this.mListener = new EndPageDataMapper.GetEndPageDataListener() { // from class: com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.Mapper.EndPageDataMapper.GetEndPageDataListener
            public void onCompleted(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1218257639")) {
                    ipChange.ipc$dispatch("1218257639", new Object[]{this, str});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(EndPageView.TAG, "getEndPageData success");
                EndPageView.this.mEndPageModel = EndPageDataMapper.transformEndPageData(str);
                if (EndPageView.this.mEndPageModel == null) {
                    EndPageView.this.setExceptionData();
                    return;
                }
                EndPageView endPageView = EndPageView.this;
                endPageView.setCompletedData(endPageView.mEndPageModel);
            }

            @Override // com.youku.live.dago.liveplayback.widget.Mapper.EndPageDataMapper.GetEndPageDataListener
            public void onException() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1473204775")) {
                    ipChange.ipc$dispatch("-1473204775", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(EndPageView.TAG, "getEndPageData fail");
                EndPageView.this.setExceptionData();
            }
        };
        this.mAttentionListener = new EndPageDataMapper.GetAttentionStateListener() { // from class: com.youku.live.dago.liveplayback.widget.view.endPage.EndPageView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.Mapper.EndPageDataMapper.GetAttentionStateListener
            public void onCompleted(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1126409402")) {
                    ipChange.ipc$dispatch("-1126409402", new Object[]{this, str});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(EndPageView.TAG, "doAttention success");
                EndPageView.this.mAttentionIcon.setVisibility(8);
                EndPageView.this.mAttentionBtn.setVisibility(8);
                EndPageView.this.mJumpActorPageBtn.setVisibility(0);
                if (EndPageView.this.mEndPageListener != null) {
                    EndPageView.this.mEndPageListener.onInjectorCallbackAttention(true);
                }
                ToastUtil.showToast(EndPageView.this.mContext, "您已成功关注TA啦");
            }

            @Override // com.youku.live.dago.liveplayback.widget.Mapper.EndPageDataMapper.GetAttentionStateListener
            public void onException() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1824690168")) {
                    ipChange.ipc$dispatch("1824690168", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(EndPageView.TAG, "doAttention fail");
                ToastUtil.showToast(EndPageView.this.mContext, "关注失败");
            }
        };
        initView(context);
    }
}
