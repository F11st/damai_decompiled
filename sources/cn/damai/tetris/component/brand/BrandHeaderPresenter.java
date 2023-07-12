package cn.damai.tetris.component.brand;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$dimen;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.login.LoginManager;
import cn.damai.player.video.opt.MultiConditionPlayOptHelper;
import cn.damai.tetris.component.brand.BrandHeaderContract;
import cn.damai.tetris.component.brand.bean.BrandHeaderInfoBean;
import cn.damai.tetris.component.brand.bean.CommonCard;
import cn.damai.tetris.component.brand.bean.DrawReward;
import cn.damai.tetris.component.brand.bean.LotteryDrawResult;
import cn.damai.tetris.component.brand.bean.LotteryRequest;
import cn.damai.tetris.component.brand.bean.LotteryResponse;
import cn.damai.tetris.component.brand.bean.ProjectVideoBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.msg.Message;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.alixplayer.MsgID;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.DummyPagerTitleView;
import tb.C9175gc;
import tb.gy2;
import tb.h62;
import tb.ja;
import tb.jl;
import tb.ns;
import tb.t60;
import tb.u12;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BrandHeaderPresenter extends BasePresenter<BrandHeaderContract.Model, BrandHeaderContract.View, BaseSection> implements BrandHeaderContract.Presenter<BrandHeaderContract.Model, BrandHeaderContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int singleH = 180;
    private static final int videoH = 400;
    BrandCouponAdapter commonCardAdapter;
    private boolean isSetVideoPlayOptHelper;
    private boolean isVisiableToUser;
    MultiConditionPlayOptHelper mOptHelper;
    private TrackInfo mTrackInfo;
    int position;
    BrandHeaderVideoAdapter videoAdapter;
    long videoMillis;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class PageChangeListenter {
        private static transient /* synthetic */ IpChange $ipChange;
        private HashMap<String, String> a;
        private List<ProjectVideoBean> b;

        public PageChangeListenter(HashMap<String, String> hashMap, List<ProjectVideoBean> list) {
            this.a = hashMap;
            this.b = list;
        }

        public ViewPager.OnPageChangeListener b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1575893308") ? (ViewPager.OnPageChangeListener) ipChange.ipc$dispatch("1575893308", new Object[]{this}) : new ViewPager.OnPageChangeListener() { // from class: cn.damai.tetris.component.brand.BrandHeaderPresenter.PageChangeListenter.1
                private static transient /* synthetic */ IpChange $ipChange;

                private boolean a(float f) {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-888258426") ? ((Boolean) ipChange2.ipc$dispatch("-888258426", new Object[]{this, Float.valueOf(f)})).booleanValue() : f < 1.0E-5f && f > -1.0E-5f;
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "630790719")) {
                        ipChange2.ipc$dispatch("630790719", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-753838626")) {
                        ipChange2.ipc$dispatch("-753838626", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    } else if (a(f)) {
                    } else {
                        if (i == 0) {
                            BrandHeaderPresenter.this.getView().getImgBg().setImageAlpha((int) ((1.0f - f) * 255.0f));
                            BrandHeaderPresenter.this.getView().getImgBg1().setImageAlpha((int) (f * 255.0f));
                            BrandHeaderPresenter.this.getView().getImgBg2().setImageAlpha(0);
                        }
                        if (i == 1) {
                            BrandHeaderPresenter.this.getView().getImgBg().setImageAlpha(0);
                            BrandHeaderPresenter.this.getView().getImgBg1().setImageAlpha((int) ((1.0f - f) * 255.0f));
                            BrandHeaderPresenter.this.getView().getImgBg2().setImageAlpha((int) (f * 255.0f));
                        }
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1732897866")) {
                        ipChange2.ipc$dispatch("1732897866", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    ((BasePresenter) BrandHeaderPresenter.this).postion = i;
                    BrandHeaderPresenter.this.getView().getIndicator().onPageSelected(i);
                    BrandHeaderPresenter.this.videoAdapter.h(i);
                    long currentTimeMillis = System.currentTimeMillis();
                    BrandHeaderPresenter brandHeaderPresenter = BrandHeaderPresenter.this;
                    long j = currentTimeMillis - brandHeaderPresenter.videoMillis;
                    VideoInfo videoInfo = brandHeaderPresenter.videoAdapter.e().get(BrandHeaderPresenter.this.position);
                    if (videoInfo != null && PageChangeListenter.this.a != null) {
                        PageChangeListenter.this.a.put("video_id", videoInfo.getVideoId());
                        if (videoInfo.getProjectInfo() != null) {
                            PageChangeListenter.this.a.put("item_id", videoInfo.getProjectInfo().id);
                        }
                    }
                    C0529c e = C0529c.e();
                    e.C("video_" + BrandHeaderPresenter.this.position, BrandHeaderPresenter.this.mTrackInfo.trackC, BrandHeaderPresenter.this.mTrackInfo.trackB, "1.0", j, PageChangeListenter.this.a, 2201);
                    BrandHeaderPresenter.this.videoMillis = System.currentTimeMillis();
                    BrandHeaderPresenter.this.position = i;
                }
            };
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1770a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1770a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2003766500")) {
                ipChange.ipc$dispatch("-2003766500", new Object[]{this, view});
            } else {
                BrandHeaderPresenter.this.share();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1771b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1771b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "107523869")) {
                ipChange.ipc$dispatch("107523869", new Object[]{this, view});
            } else {
                BrandHeaderPresenter.this.followClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1772c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1772c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2076153058")) {
                ipChange.ipc$dispatch("-2076153058", new Object[]{this, view});
            } else if (!LoginManager.k().q()) {
                DMNav.from(((BasePresenter) BrandHeaderPresenter.this).mContext.getActivity()).forResult(100).toUri(NavUri.b("login"));
            } else {
                view.setClickable(false);
                CommonCard commonCard = (CommonCard) view.getTag();
                if (commonCard != null) {
                    int i = commonCard.gainCouponButtonCode;
                    if (i == 2) {
                        BrandHeaderPresenter.this.followAndGet(commonCard, view);
                    } else if (i == 3) {
                        BrandHeaderPresenter.this.get(commonCard, view);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1773d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BrandHeaderInfoBean a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$d$a */
        /* loaded from: classes16.dex */
        public class DialogInterface$OnClickListenerC1774a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC1774a(View$OnClickListenerC1773d view$OnClickListenerC1773d) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "260737155")) {
                    ipChange.ipc$dispatch("260737155", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        View$OnClickListenerC1773d(BrandHeaderInfoBean brandHeaderInfoBean) {
            this.a = brandHeaderInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "35137311")) {
                ipChange.ipc$dispatch("35137311", new Object[]{this, view});
                return;
            }
            DMThemeDialog dMThemeDialog = new DMThemeDialog(BrandHeaderPresenter.this.getContext().getActivity());
            dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_GUARD_SUCCESS);
            dMThemeDialog.k(this.a.fansDescription).i("知道了", new DialogInterface$OnClickListenerC1774a(this)).g(false, null);
            dMThemeDialog.show();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$e */
    /* loaded from: classes7.dex */
    public class C1775e extends jl {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List b;

        C1775e(List list) {
            this.b = list;
        }

        @Override // tb.jl
        public int a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1360832937")) {
                return ((Integer) ipChange.ipc$dispatch("1360832937", new Object[]{this})).intValue();
            }
            List list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // tb.jl
        public IPagerIndicator b(Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-467165798")) {
                return (IPagerIndicator) ipChange.ipc$dispatch("-467165798", new Object[]{this, context});
            }
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setLineHeight(context.getResources().getDimension(R$dimen.margin_3dp));
            linePagerIndicator.setRoundRadius(t60.a(((BasePresenter) BrandHeaderPresenter.this).mContext.getActivity(), 2.5f));
            linePagerIndicator.setColors(-1);
            return linePagerIndicator;
        }

        @Override // tb.jl
        public IPagerTitleView c(Context context, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "395237277") ? (IPagerTitleView) ipChange.ipc$dispatch("395237277", new Object[]{this, context, Integer.valueOf(i)}) : new DummyPagerTitleView(context);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$f */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC1776f implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1776f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2060466990")) {
                ipChange.ipc$dispatch("2060466990", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (BrandHeaderPresenter.this.getView().getAttentionView().followed()) {
                BrandHeaderPresenter.this.getView().getAttentionView().getRelationUpdateAndLogin();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$g */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC1777g implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1777g(BrandHeaderPresenter brandHeaderPresenter) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1264919283")) {
                ipChange.ipc$dispatch("-1264919283", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$h */
    /* loaded from: classes16.dex */
    public class C1778h {
        private static transient /* synthetic */ IpChange $ipChange;
        private HashMap<String, String> a;
        private List<ProjectVideoBean> b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.tetris.component.brand.BrandHeaderPresenter$h$a */
        /* loaded from: classes16.dex */
        public class View$OnAttachStateChangeListenerC1779a implements View.OnAttachStateChangeListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnAttachStateChangeListenerC1779a() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1590168521")) {
                    ipChange.ipc$dispatch("1590168521", new Object[]{this, view});
                } else if (!BrandHeaderPresenter.this.isSetVideoPlayOptHelper && (view.getParent() instanceof RecyclerView)) {
                    BrandHeaderPresenter.this.isSetVideoPlayOptHelper = true;
                    C1778h c1778h = C1778h.this;
                    BrandHeaderPresenter.this.videoAdapter = new BrandHeaderVideoAdapter(c1778h.b, BrandHeaderPresenter.this.getContext().getActivity(), view, BrandHeaderPresenter.this);
                    BrandHeaderPresenter.this.getView().getViewPager().setVisibility(0);
                    BrandHeaderPresenter.this.getView().getViewPager().setAdapter(BrandHeaderPresenter.this.videoAdapter);
                    BrandHeaderPresenter.this.videoMillis = System.currentTimeMillis();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-732904954")) {
                    ipChange.ipc$dispatch("-732904954", new Object[]{this, view});
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                BrandHeaderPresenter brandHeaderPresenter = BrandHeaderPresenter.this;
                long j = currentTimeMillis - brandHeaderPresenter.videoMillis;
                BrandHeaderVideoAdapter brandHeaderVideoAdapter = brandHeaderPresenter.videoAdapter;
                if (brandHeaderVideoAdapter != null) {
                    VideoInfo videoInfo = brandHeaderVideoAdapter.e().get(BrandHeaderPresenter.this.position);
                    if (videoInfo != null && C1778h.this.a != null) {
                        C1778h.this.a.put("video_id", videoInfo.getVideoId());
                        if (videoInfo.getProjectInfo() != null) {
                            C1778h.this.a.put("item_id", videoInfo.getProjectInfo().id);
                        }
                    }
                    C0529c e = C0529c.e();
                    e.C("video_" + BrandHeaderPresenter.this.position, BrandHeaderPresenter.this.mTrackInfo.trackC, BrandHeaderPresenter.this.mTrackInfo.trackB, "1.0", j, C1778h.this.a, 2201);
                    BrandHeaderPresenter.this.videoMillis = System.currentTimeMillis();
                }
            }
        }

        public C1778h(HashMap<String, String> hashMap, List<ProjectVideoBean> list) {
            this.a = hashMap;
            this.b = list;
        }

        public View.OnAttachStateChangeListener c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "573252524") ? (View.OnAttachStateChangeListener) ipChange.ipc$dispatch("573252524", new Object[]{this}) : new View$OnAttachStateChangeListenerC1779a();
        }
    }

    public BrandHeaderPresenter(BrandHeaderView brandHeaderView, String str, ja jaVar) {
        super(brandHeaderView, str, jaVar);
        this.position = 0;
        this.isSetVideoPlayOptHelper = false;
        this.isVisiableToUser = true;
    }

    private int dep2px(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1861322787") ? ((Integer) ipChange.ipc$dispatch("1861322787", new Object[]{this, Integer.valueOf(i)})).intValue() : t60.a(this.mContext.getActivity(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void followAndGet(CommonCard commonCard, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-827124220")) {
            ipChange.ipc$dispatch("-827124220", new Object[]{this, commonCard, view});
            return;
        }
        if (!getView().getAttentionView().followed()) {
            getView().getAttentionView().getRelationUpdateAndLogin();
        }
        get(commonCard, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void get(final CommonCard commonCard, final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357083020")) {
            ipChange.ipc$dispatch("357083020", new Object[]{this, commonCard, view});
            return;
        }
        LotteryRequest lotteryRequest = new LotteryRequest();
        lotteryRequest.cityCode = z20.c();
        lotteryRequest.lotteryMixId = commonCard.prizePoolSpreadId;
        lotteryRequest.request(new DMMtopRequestListener<LotteryResponse>(LotteryResponse.class) { // from class: cn.damai.tetris.component.brand.BrandHeaderPresenter.8
            private static transient /* synthetic */ IpChange $ipChange;

            private void showGiftDialog(DrawReward drawReward) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1585636761")) {
                    ipChange2.ipc$dispatch("-1585636761", new Object[]{this, drawReward});
                } else if (((BasePresenter) BrandHeaderPresenter.this).mContext.getActivity() == null || drawReward == null) {
                } else {
                    showMsgToast("领取成功，快去'我的-优惠券'中使用吧");
                    BrandHeaderPresenter.this.sendMsg(new Message(10243, drawReward));
                }
            }

            private void showMsgToast(String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-337783847")) {
                    ipChange2.ipc$dispatch("-337783847", new Object[]{this, str});
                } else if (((BasePresenter) BrandHeaderPresenter.this).mContext.getActivity() != null) {
                    ToastUtil.a().j(((BasePresenter) BrandHeaderPresenter.this).mContext.getActivity(), str);
                }
            }

            private void sycnState() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2086899288")) {
                    ipChange2.ipc$dispatch("2086899288", new Object[]{this});
                    return;
                }
                CommonCard commonCard2 = commonCard;
                if (commonCard2 == null || commonCard2.index >= ((BrandHeaderContract.Model) ((BasePresenter) BrandHeaderPresenter.this).mModel).getCoupons().size() || ((BrandHeaderContract.Model) ((BasePresenter) BrandHeaderPresenter.this).mModel).getCoupons().get(commonCard.index) == null) {
                    return;
                }
                ((BrandHeaderContract.Model) ((BasePresenter) BrandHeaderPresenter.this).mModel).getCoupons().get(commonCard.index).gainCouponButtonCode = 1;
                BrandHeaderPresenter brandHeaderPresenter = BrandHeaderPresenter.this;
                brandHeaderPresenter.commonCardAdapter.notifyItemChanged(commonCard.index, ((BrandHeaderContract.Model) ((BasePresenter) brandHeaderPresenter).mModel).getCoupons().get(commonCard.index));
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1898738057")) {
                    ipChange2.ipc$dispatch("1898738057", new Object[]{this, str, str2});
                    return;
                }
                showMsgToast("抱歉来晚了～券已经发完了");
                view.setClickable(true);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(LotteryResponse lotteryResponse) {
                List<DrawReward> list;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "894216995")) {
                    ipChange2.ipc$dispatch("894216995", new Object[]{this, lotteryResponse});
                    return;
                }
                view.setClickable(true);
                if (lotteryResponse != null && !TextUtils.isEmpty(lotteryResponse.returnCode)) {
                    if ("0".equals(lotteryResponse.returnCode)) {
                        LotteryDrawResult lotteryDrawResult = lotteryResponse.returnValue;
                        if (lotteryDrawResult != null && (list = lotteryDrawResult.rewards) != null && list.size() != 0) {
                            showGiftDialog(lotteryResponse.returnValue.rewards.get(0));
                            sycnState();
                            return;
                        }
                        showMsgToast("抱歉来晚了～券已经发完了");
                        return;
                    } else if (!"200016".equals(lotteryResponse.returnCode) && !"200015".equals(lotteryResponse.returnCode) && !"200003".equals(lotteryResponse.returnCode)) {
                        showMsgToast("抱歉来晚了～券已经发完了");
                        return;
                    } else {
                        showMsgToast("你已经领取过该券了，快去'我的-优惠券'中使用吧");
                        sycnState();
                        return;
                    }
                }
                showMsgToast("抱歉来晚了～券已经发完了");
            }
        });
        HashMap hashMap = new HashMap();
        if (getModel() != null && getModel().getTrackInfo() != null) {
            hashMap.putAll(getModel().getTrackInfo().getArgsMap());
        }
        String str = commonCard.prizePoolSpreadId;
        if (str != null) {
            hashMap.put("coupon_id", str);
        }
        hashMap.put("status", commonCard.gainCouponButtonCode + "");
        userTrackClick("coupon_btn", hashMap, false);
    }

    private void initMagicIndicator(MagicIndicator magicIndicator, ViewPager viewPager, List<ProjectVideoBean> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688346923")) {
            ipChange.ipc$dispatch("688346923", new Object[]{this, magicIndicator, viewPager, list, Integer.valueOf(i)});
            return;
        }
        CommonNavigator commonNavigator = new CommonNavigator(this.mContext.getActivity());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new C1775e(list));
        magicIndicator.setNavigator(commonNavigator);
        gy2.a(magicIndicator, viewPager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319408851")) {
            ipChange.ipc$dispatch("-319408851", new Object[]{this});
        } else if (getModel().getHeaderInfo() == null) {
        } else {
            Bundle bundle = new Bundle();
            BrandHeaderInfoBean headerInfo = getModel().getHeaderInfo();
            String nickname = headerInfo.getNickname();
            bundle.putString("title", nickname + "在大麦");
            bundle.putString("message", "关注TA，第一时间获取演出动态");
            bundle.putString("imageurl", headerInfo.getHeadImg());
            bundle.putString("producturl", "https://m.damai.cn/app/dmfe/show/pages/brand/index.html?brandId=" + headerInfo.getBid());
            bundle.putString("fromWhere", "brand");
            bundle.putBoolean("showGenerateImage", true);
            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE);
            bundle.putString("projectName", nickname + "在大麦");
            if (!wh2.j(headerInfo.getHeadImg())) {
                bundle.putString("projectImage", headerInfo.getHeadImg());
            } else {
                bundle.putString("projectImage", h62.r(R$drawable.c_default_bg));
            }
            ShareManager.E().T(getContext().getActivity(), bundle, getView().getShareBtn());
            ShareManager.E().L();
            ShareManager.E().q0();
            ShareManager.E().l0();
            userTrackClick("share", false);
        }
    }

    public void followClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717210507")) {
            ipChange.ipc$dispatch("-717210507", new Object[]{this});
        } else if (getView().getAttentionView().followed()) {
            new DMDialog(this.mContext.getActivity()).o(false).v(PurchaseConstants.NORMAL_WARNING_TITLE).q("确认取消关注？取消后将无法获取厂牌号最新权益。").t(3).i("取消", new DialogInterface$OnClickListenerC1777g(this)).n("确定", new DialogInterface$OnClickListenerC1776f()).show();
        } else {
            if (getModel().getActivityDO() != null && !TextUtils.isEmpty(getModel().getActivityDO().couponId)) {
                sendMsg(new Message(MsgID.MEDIA_INFO_VIDEO_START_RECOVER, new Pair("4", Pair.create(Integer.valueOf(getView().getAttentionView().getState()), getModel().getHeaderInfo().getBid()))));
            }
            if (getView().getAttentionView().followed()) {
                return;
            }
            getView().getAttentionView().getRelationUpdateAndLogin();
        }
    }

    public String getFansNum(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2115452234")) {
            return (String) ipChange.ipc$dispatch("2115452234", new Object[]{this, Long.valueOf(j)});
        }
        String[] strArr = new String[2];
        try {
            if (j < 10000) {
                strArr[0] = j + "";
                strArr[1] = "粉丝";
                return strArr[0] + strArr[1];
            }
            strArr[0] = (((float) (j / 1000)) / 10.0f) + "";
            strArr[1] = "万粉丝";
            return strArr[0] + strArr[1];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getTags(List<String> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "857197234")) {
            return (String) ipChange.ipc$dispatch("857197234", new Object[]{this, list});
        }
        String str = "";
        if (list == null) {
            return "";
        }
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str = str + it.next();
                if (i < list.size() - 1) {
                    str = str + " | ";
                    i++;
                }
            }
        }
        return str;
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1408780763")) {
            ipChange.ipc$dispatch("1408780763", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 7002) {
            share();
        } else if (i == 10244) {
            if (((BrandHeaderContract.Model) this.mModel).getCoupons() == null || obj == null) {
                return;
            }
            for (CommonCard commonCard : ((BrandHeaderContract.Model) this.mModel).getCoupons()) {
                if (commonCard != null && !TextUtils.isEmpty(commonCard.prizePoolSpreadId)) {
                    String str = commonCard.prizePoolSpreadId;
                    if (str.equals(obj + "")) {
                        commonCard.gainCouponButtonCode = 1;
                        this.commonCardAdapter.notifyItemChanged(commonCard.index, ((BrandHeaderContract.Model) this.mModel).getCoupons().get(commonCard.index));
                    }
                }
            }
        } else if (i != 11001) {
            switch (i) {
                case 11003:
                    MultiConditionPlayOptHelper multiConditionPlayOptHelper = this.mOptHelper;
                    if (multiConditionPlayOptHelper != null) {
                        multiConditionPlayOptHelper.a(false);
                    }
                    BrandHeaderVideoAdapter brandHeaderVideoAdapter = this.videoAdapter;
                    if (brandHeaderVideoAdapter != null) {
                        brandHeaderVideoAdapter.i();
                        return;
                    }
                    return;
                case 11004:
                    MultiConditionPlayOptHelper multiConditionPlayOptHelper2 = this.mOptHelper;
                    if (multiConditionPlayOptHelper2 != null) {
                        multiConditionPlayOptHelper2.a(false);
                    }
                    BrandHeaderVideoAdapter brandHeaderVideoAdapter2 = this.videoAdapter;
                    if (brandHeaderVideoAdapter2 != null) {
                        brandHeaderVideoAdapter2.g();
                        return;
                    }
                    return;
                case 11005:
                    MultiConditionPlayOptHelper multiConditionPlayOptHelper3 = this.mOptHelper;
                    if (multiConditionPlayOptHelper3 != null) {
                        multiConditionPlayOptHelper3.a(true);
                    }
                    BrandHeaderVideoAdapter brandHeaderVideoAdapter3 = this.videoAdapter;
                    if (brandHeaderVideoAdapter3 == null || !this.isVisiableToUser) {
                        return;
                    }
                    brandHeaderVideoAdapter3.j();
                    return;
                default:
                    return;
            }
        } else if (this.videoAdapter != null && (obj instanceof Boolean)) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.isVisiableToUser = booleanValue;
            MultiConditionPlayOptHelper multiConditionPlayOptHelper4 = this.mOptHelper;
            if (multiConditionPlayOptHelper4 != null) {
                multiConditionPlayOptHelper4.a(booleanValue);
            }
            if (this.isVisiableToUser) {
                this.videoAdapter.j();
            } else {
                this.videoAdapter.i();
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310595896")) {
            return ((Boolean) ipChange.ipc$dispatch("310595896", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void rebindData(BrandHeaderContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173351705")) {
            ipChange.ipc$dispatch("-1173351705", new Object[]{this, model});
        }
    }

    public void trackExpo(CommonCard commonCard) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694708173")) {
            ipChange.ipc$dispatch("1694708173", new Object[]{this, commonCard});
            return;
        }
        HashMap hashMap = new HashMap();
        if (getModel() != null && getModel().getTrackInfo() != null) {
            hashMap.putAll(getModel().getTrackInfo().getArgsMap());
        }
        String str = commonCard.prizePoolSpreadId;
        if (str != null) {
            hashMap.put("coupon_id", str);
        }
        hashMap.put("status", commonCard.gainCouponButtonCode + "");
        userTrackExpose(getView().getTitle(), "coupon_btn", hashMap, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(BrandHeaderContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427826685")) {
            ipChange.ipc$dispatch("427826685", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        BrandHeaderInfoBean headerInfo = getModel().getHeaderInfo();
        if (headerInfo == null) {
            return;
        }
        getView().getShareBtn().setOnClickListener(new View$OnClickListenerC1770a());
        C9175gc.a(getView().getTitle(), headerInfo.getNickname());
        long j = 0;
        try {
            j = Long.parseLong(headerInfo.getFansNum());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        C9175gc.a(getView().getSubTitle(), getFansNum(j));
        C9175gc.a(getView().getDesc2(), getTags(headerInfo.getTagList()));
        C2497a.a().loadinto(headerInfo.getHeadImg(), getView().getHeader());
        int a = t60.a(getContext().getActivity(), 6.0f);
        ns.b(getView().getRootView().findViewById(R$id.brand_header_img_shadow), Color.parseColor("#00ffffff"), t60.a(getContext().getActivity(), 50.0f), Color.parseColor("#1A000000"), a, a, a);
        int a2 = t60.a(getContext().getActivity(), 12.0f);
        View rootView = getView().getRootView();
        int i = R$id.brand_index_headerbg_shadow;
        ns.b(rootView.findViewById(i), Color.parseColor("#00ffffff"), a2, Color.parseColor("#1A000000"), a2, 0, 0);
        getView().getAttentionView().setInitParams(headerInfo.getBid(), "4");
        getView().getAttentionView().setVisibility(0);
        getView().getAttentionView().setState(headerInfo.getFavoriteFlag());
        getView().getAttentionView().setOnAttentionClickDelegate(new View$OnClickListenerC1771b());
        HashMap hashMap = new HashMap();
        if (getModel() != null && getModel().getTrackInfo() != null) {
            hashMap.putAll(getModel().getTrackInfo().getArgsMap());
        }
        if (getModel().getTrackInfo() != null) {
            getView().getAttentionView().setPage(getModel().getTrackInfo().trackB);
            getView().getAttentionView().setPageBdian(getModel().getTrackInfo().trackB);
            getView().getAttentionView().setModule(getModel().getTrackInfo().trackC);
            getView().getAttentionView().setArgsMap(hashMap);
        }
        sendMsg(new Message(10242, getView().getAttentionView()));
        List<ProjectVideoBean> projectVideoBean = getModel().getProjectVideoBean();
        if (projectVideoBean != null && projectVideoBean.size() != 0) {
            getView().getCover().setVisibility(8);
            ImageView[] imageViewArr = {getView().getImgBg(), getView().getImgBg1(), getView().getImgBg2()};
            for (int i2 = 0; i2 < projectVideoBean.size() && i2 < 3; i2++) {
                ProjectVideoBean projectVideoBean2 = projectVideoBean.get(i2);
                if (projectVideoBean2 != null) {
                    C2497a.a().loadinto(projectVideoBean2.getBackgroundPic(), imageViewArr[i2]);
                }
            }
            getView().getImgBg1().setVisibility(0);
            getView().getImgBg1().setImageAlpha(0);
            getView().getImgBg2().setVisibility(0);
            getView().getImgBg2().setImageAlpha(0);
            if (projectVideoBean.size() > 1) {
                getView().getIndicator().setVisibility(0);
                initMagicIndicator(getView().getIndicator(), getView().getViewPager(), projectVideoBean, 0);
            } else {
                getView().getIndicator().setVisibility(8);
            }
            getView().getRootView().addOnAttachStateChangeListener(new C1778h(hashMap, projectVideoBean).c());
            getView().getViewPager().addOnPageChangeListener(new PageChangeListenter(hashMap, projectVideoBean).b());
        } else {
            getView().getImgBg().getLayoutParams().height = t60.a(this.mContext.getActivity(), 180.0f);
            getView().getCover().setVisibility(0);
            getView().getCover().getLayoutParams().height = t60.a(this.mContext.getActivity(), 180.0f);
            ((RelativeLayout.LayoutParams) getView().getRootView().findViewById(i).getLayoutParams()).setMargins(dep2px(15), dep2px(103), dep2px(15), 0);
            C2497a.a().loadinto(headerInfo.getHeadBgImg(), getView().getImgBg());
            userTrackExpose(getView().getImgBg(), u12.REPERTOITE);
        }
        if (getModel().getCoupons() != null && getModel().getCoupons().size() > 0) {
            getView().getRecyclerView().setVisibility(0);
            this.commonCardAdapter = new BrandCouponAdapter(this.mContext.getActivity(), headerInfo.getBid(), "4", new View$OnClickListenerC1772c(), this);
            RecyclerView recyclerView = getView().getRecyclerView();
            recyclerView.setVisibility(0);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext.getActivity());
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.commonCardAdapter);
            this.commonCardAdapter.e(getModel().getCoupons());
        } else {
            getView().getRecyclerView().setVisibility(8);
        }
        if (!TextUtils.isEmpty(headerInfo.fansDescription)) {
            View rootView2 = getView().getRootView();
            int i3 = R$id.tv_fans_icon_tip;
            rootView2.findViewById(i3).setVisibility(0);
            getView().getRootView().findViewById(i3).setOnClickListener(new View$OnClickListenerC1773d(headerInfo));
            return;
        }
        getView().getRootView().findViewById(R$id.tv_fans_icon_tip).setVisibility(8);
    }
}
