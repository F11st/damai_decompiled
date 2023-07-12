package cn.damai.tetris.component.ip;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultBaseData;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$raw;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.h5container.DamaiWebView;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.ip.IpInfoContract;
import cn.damai.tetris.component.ip.bean.IPInfoBean;
import cn.damai.tetris.component.ip.bean.IpTags;
import cn.damai.tetris.component.ip.mtop.PraiseRequest;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.msg.Message;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMThemeDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.MsgID;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tb.C9175gc;
import tb.C9548pb;
import tb.cs;
import tb.ed2;
import tb.g41;
import tb.ja;
import tb.pp2;
import tb.q60;
import tb.rt1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpInfoPresenter extends BasePresenter<IpInfoContract.Model, IpInfoContract.View, BaseSection> implements IpInfoContract.Presenter<IpInfoContract.Model, IpInfoContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String followStateKey;
    ArrayList<String> initPraIds;
    ed2 likedStack;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class FollowClick implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        IPInfoBean a;

        public FollowClick(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "14222673")) {
                ipChange.ipc$dispatch("14222673", new Object[]{this, view});
                return;
            }
            IpInfoPresenter.this.userTrackClick("favorite", false);
            FollowRequest followRequest = new FollowRequest();
            StringBuilder sb = new StringBuilder();
            sb.append(view.getTag());
            sb.append("");
            followRequest.operateType = "true".equals(sb.toString()) ? "0" : "1";
            followRequest.targetId = this.a.getId();
            followRequest.targetType = "5";
            followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.tetris.component.ip.IpInfoPresenter.FollowClick.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "796201092")) {
                        ipChange2.ipc$dispatch("796201092", new Object[]{this, str, str2});
                    } else {
                        view.setClickable(true);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(FollowDataBean followDataBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1655979044")) {
                        ipChange2.ipc$dispatch("-1655979044", new Object[]{this, followDataBean});
                        return;
                    }
                    view.setClickable(true);
                    boolean z = followDataBean.getStatus() != 0;
                    view.setTag(Boolean.valueOf(z));
                    IpInfoPresenter.this.sendMsg(new Message(MsgID.MEDIA_INFO_VIDEO_START_RECOVER, new Pair("5", Pair.create(Integer.valueOf(followDataBean.getStatus()), FollowClick.this.a.getId()))));
                    IpInfoPresenter.this.updateWannaSeeUi(z, true);
                }
            });
            view.setClickable(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1898a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        View$OnClickListenerC1898a(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-532441990")) {
                ipChange.ipc$dispatch("-532441990", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1899b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1899b() {
        }

        private int a(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1605550603")) {
                return ((Integer) ipChange.ipc$dispatch("1605550603", new Object[]{this, view})).intValue();
            }
            IpTags ipTags = (IpTags) view.getTag();
            int like = ipTags.getLike();
            view.setTag(ipTags);
            return like;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1578848379")) {
                ipChange.ipc$dispatch("1578848379", new Object[]{this, view});
            } else if (a(view) == 1) {
                IpInfoPresenter.this.grayTag(view);
                IpInfoPresenter.this.likedStack.b();
            } else {
                IpInfoPresenter.this.hightLightTag(view);
                View view2 = (View) IpInfoPresenter.this.likedStack.c(view);
                if (view2 != null) {
                    IpInfoPresenter.this.grayTag(view2);
                    a(view2);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1900c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        View$OnClickListenerC1900c(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-957977269")) {
                ipChange.ipc$dispatch("-957977269", new Object[]{this, view});
            } else {
                DMNav.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).toUri(this.a.getGuidelines());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1901d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        View$OnClickListenerC1901d(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1153313100")) {
                ipChange.ipc$dispatch("1153313100", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("pic_info", (Serializable) this.a.getVerticalPicList());
            IpInfoPresenter.this.userTrackClick("poster", true);
            NavProxy.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).withExtras(bundle).toUri(INavUri.page("image_gallery"));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$e */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1902e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        View$OnClickListenerC1902e(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1030363827")) {
                ipChange.ipc$dispatch("-1030363827", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(g41.ISSUE_PARAM_IPID, this.a.getId());
            NavProxy.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).withExtras(bundle).toUri(INavUri.page(cs.W));
            IpInfoPresenter.this.userTrackClick(pp2.PROJECT_EVALUATE, true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$f */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1903f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;
        final /* synthetic */ TextView b;

        View$OnClickListenerC1903f(IPInfoBean iPInfoBean, TextView textView) {
            this.a = iPInfoBean;
            this.b = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1080926542")) {
                ipChange.ipc$dispatch("1080926542", new Object[]{this, view});
                return;
            }
            IpInfoPresenter.this.userTrackClick("seen", false);
            if (!LoginManager.k().q()) {
                DMNav.from(((BasePresenter) IpInfoPresenter.this).mContext.getActivity()).forResult(100).toUri(NavUri.b("login"));
            } else if (this.a.getIpTags() != null && this.a.getIpTags().size() != 0) {
                IpInfoPresenter.this.showTagsPopwindow(this.a, this.b);
            } else {
                boolean booleanValue = ((Boolean) view.getTag()).booleanValue();
                if (booleanValue) {
                    return;
                }
                z20.T(IpInfoPresenter.this.followStateKey + this.a.getId(), !booleanValue ? "1" : "0");
                view.setTag(Boolean.valueOf(!booleanValue));
                IpInfoPresenter.this.updateHaveSeenText(this.b, !booleanValue);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$g */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1904g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        View$OnClickListenerC1904g(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1102750385")) {
                ipChange.ipc$dispatch("-1102750385", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(RankListFragment.KEY_RANK_ID, this.a.getRank().id);
            NavProxy.from(IpInfoPresenter.this.getContext().getActivity()).withExtras(bundle).toHost("ranking");
            HashMap hashMap = new HashMap();
            hashMap.put(C9548pb.PRE_CONTENT_ID, this.a.getRank().id);
            hashMap.put(C9548pb.PRE_CONTENT_TYPE, "randlist");
            if (IpInfoPresenter.this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(IpInfoPresenter.this.mTrackInfo.getArgsMap());
            }
            IpInfoPresenter.this.userTrackClick("repertoire_ranklist", hashMap, true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$h */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1905h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IPInfoBean a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$h$a */
        /* loaded from: classes16.dex */
        public class DialogInterface$OnClickListenerC1906a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC1906a(View$OnClickListenerC1905h view$OnClickListenerC1905h) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "632561266")) {
                    ipChange.ipc$dispatch("632561266", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        View$OnClickListenerC1905h(IPInfoBean iPInfoBean) {
            this.a = iPInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1008539984")) {
                ipChange.ipc$dispatch("1008539984", new Object[]{this, view});
                return;
            }
            DMThemeDialog dMThemeDialog = new DMThemeDialog(IpInfoPresenter.this.getContext().getActivity());
            dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_GUARD_SUCCESS);
            dMThemeDialog.k(this.a.ipvuvDescription).i("知道了", new DialogInterface$OnClickListenerC1906a(this)).g(false, null);
            dMThemeDialog.show();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$i */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1907i implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        View$OnClickListenerC1907i(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1175136943")) {
                ipChange.ipc$dispatch("-1175136943", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$j */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1908j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        View$OnClickListenerC1908j(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "936153426")) {
                ipChange.ipc$dispatch("936153426", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpInfoPresenter$k */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1909k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        View$OnClickListenerC1909k(IpInfoPresenter ipInfoPresenter, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1247523501")) {
                ipChange.ipc$dispatch("-1247523501", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    public IpInfoPresenter(IpInfoView ipInfoView, String str, ja jaVar) {
        super(ipInfoView, str, jaVar);
        this.followStateKey = "IpInfoPresenter_follow_stateKey_";
        this.likedStack = new ed2(3);
        this.initPraIds = new ArrayList<>();
    }

    private void bindItem(View view, IpTags ipTags) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535589856")) {
            ipChange.ipc$dispatch("-1535589856", new Object[]{this, view, ipTags});
            return;
        }
        C9175gc.a((TextView) view.findViewById(R$id.tv_ipinfo_tagleft), ipTags.getTagName());
        if (ipTags.getTagCount() > 100) {
            C9175gc.a((TextView) view.findViewById(R$id.tv_ipinfo_tagright), ipTags.getTagCount() + "");
            return;
        }
        view.findViewById(R$id.tv_ipinfo_tagright).setVisibility(8);
    }

    private void bindPopTagItem(View view, IPInfoBean iPInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319437919")) {
            ipChange.ipc$dispatch("1319437919", new Object[]{this, view, iPInfoBean, Integer.valueOf(i)});
        } else if (i < iPInfoBean.getIpTags().size() && iPInfoBean.getIpTags().get(i) != null) {
            bindSinglePopTagItem(view, iPInfoBean.getIpTags().get(i));
        } else {
            view.setVisibility(4);
        }
    }

    private void bindSinglePopTagItem(View view, IpTags ipTags) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877635121")) {
            ipChange.ipc$dispatch("1877635121", new Object[]{this, view, ipTags});
            return;
        }
        C9175gc.a((TextView) view.findViewById(R$id.ip_tags_tag_title), ipTags.getTagName());
        if (ipTags.getTagCount() > 100) {
            C9175gc.a((TextView) view.findViewById(R$id.ip_tags_tag_count), ipTags.getTagCount() + "");
            view.findViewById(R$id.ip_tags_tag_zan).setVisibility(0);
        } else {
            view.findViewById(R$id.ip_tags_tag_count).setVisibility(8);
            view.findViewById(R$id.ip_tags_tag_zan).setVisibility(8);
        }
        if (ipTags.getLike() == 1) {
            hightLightTag(view);
            this.likedStack.c(view);
            this.initPraIds.add(ipTags.getTagId());
        } else {
            grayTag(view);
        }
        view.setTag(ipTags);
        view.setOnClickListener(new View$OnClickListenerC1899b());
    }

    public static String getFansNum(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080330577")) {
            return (String) ipChange.ipc$dispatch("-1080330577", new Object[]{Long.valueOf(j), str});
        }
        try {
            if (j < 10000) {
                return j + str;
            }
            return (((float) (j / 1000)) / 10.0f) + "万" + str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grayTag(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "260252300")) {
            ipChange.ipc$dispatch("260252300", new Object[]{this, view});
            return;
        }
        Resources resources = getContext().getActivity().getResources();
        int i = R$color.color_9C9CA5;
        ((TextView) view.findViewById(R$id.ip_tags_tag_count)).setTextColor(resources.getColor(i));
        ((TextView) view.findViewById(R$id.ip_tags_tag_zan)).setTextColor(getContext().getActivity().getResources().getColor(R$color.color_3c3f44));
        ((TextView) view.findViewById(R$id.ip_tags_tag_title)).setTextColor(getContext().getActivity().getResources().getColor(i));
        view.findViewById(R$id.ip_tags_tag_bg).setBackground(getContext().getActivity().getResources().getDrawable(R$drawable.bg_border_corner_15_0_r15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hightLightTag(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170314005")) {
            ipChange.ipc$dispatch("-1170314005", new Object[]{this, view});
            return;
        }
        Resources resources = getContext().getActivity().getResources();
        int i = R$color.color_FF9200;
        ((TextView) view.findViewById(R$id.ip_tags_tag_count)).setTextColor(resources.getColor(i));
        ((TextView) view.findViewById(R$id.ip_tags_tag_zan)).setTextColor(getContext().getActivity().getResources().getColor(i));
        ((TextView) view.findViewById(R$id.ip_tags_tag_title)).setTextColor(getContext().getActivity().getResources().getColor(R$color.black));
        view.findViewById(R$id.ip_tags_tag_bg).setBackground(getContext().getActivity().getResources().getDrawable(R$drawable.bg_border_corner_0_r15));
    }

    private void setScore(IPInfoBean iPInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264484893")) {
            ipChange.ipc$dispatch("-1264484893", new Object[]{this, iPInfoBean});
            return;
        }
        TextView ipScore = getView().getIpScore();
        C9175gc.a(ipScore, iPInfoBean.getItemScore() + "");
        C9175gc.a(getView().getIpScoreDesc(), iPInfoBean.getScoreDesc());
        getView().getRatingBar().updateView((double) iPInfoBean.getItemScoreFloat());
        if (iPInfoBean.getContent() != null) {
            C9175gc.a(getView().getUserComment(), iPInfoBean.getContent().getContent());
            C2497a.a().loadinto(iPInfoBean.getContent().getHeadImg(), getView().getUserImg());
        }
    }

    private void setTags(IPInfoBean iPInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462353592")) {
            ipChange.ipc$dispatch("-1462353592", new Object[]{this, iPInfoBean});
        } else if (iPInfoBean.getIpTags() != null) {
            LinearLayout linearLayout = (LinearLayout) getView().getRootView().findViewById(R$id.ipinfo_score_tags_parent);
            linearLayout.removeAllViews();
            for (int i = 0; i < iPInfoBean.getIpTags().size(); i++) {
                View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_videoinfo_ip_tag, (ViewGroup) linearLayout, false);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                layoutParams.setMargins(0, 0, q60.a(this.mContext.getActivity(), 3.0f), 0);
                linearLayout.addView(inflate, layoutParams);
                bindItem(inflate, iPInfoBean.getIpTags().get(i));
                userTrackExpose(inflate, "tag_" + i);
            }
        }
    }

    private void showPopwindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1947614873")) {
            ipChange.ipc$dispatch("1947614873", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_scoretip, (ViewGroup) null);
        PopupWindow c = new rt1(inflate, q60.a(this.mContext.getActivity(), 287.0f)).g(this.mContext.getActivity()).c();
        inflate.setOnClickListener(new View$OnClickListenerC1907i(this, c));
        inflate.findViewById(R$id.ip_tour_top_close).setOnClickListener(new View$OnClickListenerC1908j(this, c));
        ((DamaiWebView) inflate.findViewById(R$id.mWebView)).loadUrl("https://m.damai.cn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTagsPopwindow(final IPInfoBean iPInfoBean, final TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "986271180")) {
            ipChange.ipc$dispatch("986271180", new Object[]{this, iPInfoBean, textView});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_tags, (ViewGroup) null);
        int a = q60.a(this.mContext.getActivity(), 42.0f);
        int size = iPInfoBean.getIpTags().size();
        this.initPraIds.clear();
        this.likedStack = new ed2(3);
        for (int i = 0; i < size; i++) {
            View inflate2 = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_popup_ip_tag, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
            bindPopTagItem(inflate2, iPInfoBean, i);
            ((FlowLayout) inflate.findViewById(R$id.ip_tags_scroll_content)).addView(inflate2, layoutParams);
        }
        rt1 g = new rt1(inflate, (((size / 2) + 1) * a) + q60.a(this.mContext.getActivity(), 149.0f)).g(this.mContext.getActivity());
        final PopupWindow c = g.c();
        int f = g.f();
        int i2 = R$id.sub_content;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) inflate.findViewById(i2).getLayoutParams();
        layoutParams2.height = f;
        inflate.findViewById(i2).setLayoutParams(layoutParams2);
        inflate.setOnClickListener(new View$OnClickListenerC1909k(this, c));
        inflate.findViewById(R$id.ip_tags_bottombar).setOnClickListener(new View.OnClickListener() { // from class: cn.damai.tetris.component.ip.IpInfoPresenter.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1651234937")) {
                    ipChange2.ipc$dispatch("1651234937", new Object[]{this, view});
                } else if (IpInfoPresenter.this.likedStack.a() == null) {
                    ToastUtil.a().e(((BasePresenter) IpInfoPresenter.this).mContext.getActivity(), "请至少选择一个标签哦");
                } else {
                    c.dismiss();
                    final PraiseRequest praiseRequest = new PraiseRequest();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        View view2 = (View) IpInfoPresenter.this.likedStack.b();
                        if (view2 == null) {
                            break;
                        }
                        IpTags ipTags = (IpTags) view2.getTag();
                        if (ipTags != null) {
                            Log.d("likedStack", "praise tag : " + ipTags.getTagName());
                            praiseRequest.praiseTargetIdList.add(ipTags.getTagId());
                            stringBuffer.append(ipTags.getTagName());
                            stringBuffer.append("&");
                        }
                    }
                    if (IpInfoPresenter.this.mTrackInfo != null && !TextUtils.isEmpty(stringBuffer.toString())) {
                        IpInfoPresenter.this.mTrackInfo.put("titlelabel", (Object) stringBuffer.toString());
                    }
                    IpInfoPresenter.this.userTrackClick("finish", false);
                    Iterator<String> it = IpInfoPresenter.this.initPraIds.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!praiseRequest.praiseTargetIdList.contains(next)) {
                            Log.d("likedStack", "un praise tag : " + next);
                            praiseRequest.cancleTargetIdList.add(next);
                        }
                    }
                    praiseRequest.targetType = "3";
                    praiseRequest.request(new DMMtopRequestListener<DMMtopResultBaseData>(DMMtopResultBaseData.class) { // from class: cn.damai.tetris.component.ip.IpInfoPresenter.10.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onFail(String str, String str2) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1581749844")) {
                                ipChange3.ipc$dispatch("-1581749844", new Object[]{this, str, str2});
                            } else {
                                view.setClickable(true);
                            }
                        }

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onSuccess(DMMtopResultBaseData dMMtopResultBaseData) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1496781176")) {
                                ipChange3.ipc$dispatch("-1496781176", new Object[]{this, dMMtopResultBaseData});
                                return;
                            }
                            view.setClickable(true);
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            iPInfoBean.like = true;
                            IpInfoPresenter.this.updateHaveSeenText(textView, true);
                            for (IpTags ipTags2 : iPInfoBean.getIpTags()) {
                                if (praiseRequest.praiseTargetIdList.contains(ipTags2.getTagId())) {
                                    ipTags2.setLike(1);
                                } else if (praiseRequest.cancleTargetIdList.contains(ipTags2.getTagId())) {
                                    ipTags2.setLike(0);
                                }
                            }
                        }
                    });
                    view.setClickable(false);
                }
            }
        });
        inflate.findViewById(R$id.ip_tags_top_close).setOnClickListener(new View$OnClickListenerC1898a(this, c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaveSeenText(TextView textView, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2093215228")) {
            ipChange.ipc$dispatch("-2093215228", new Object[]{this, textView, Boolean.valueOf(z)});
            return;
        }
        textView.setTextColor(z ? Color.parseColor("#ff993a") : -16777216);
        textView.setText(getContext().getActivity().getResources().getString(z ? R$string.iconfont_pingfenmian_ : R$string.iconfont_pingfen_));
        View haveSeen = getView().getHaveSeen();
        int i = R$id.ipinfo_showinfo_haveseen_text;
        ((TextView) haveSeen.findViewById(i)).setTextColor(z ? Color.parseColor("#9c9ca5") : -16777216);
        C9175gc.a((TextView) getView().getHaveSeen().findViewById(i), z ? "已看过" : "看过");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public void updateWannaSeeUi(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794528276")) {
            ipChange.ipc$dispatch("794528276", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        getView().getWannaSee().setTag(Boolean.valueOf(z));
        getModel().getIpInfo().setFocus(z);
        TextView textView = (TextView) getView().getWannaSee().findViewById(R$id.ipinfo_showinfo_wannasee_text);
        textView.setText(z ? "已想看" : "想看");
        textView.setTextColor(z ? Color.parseColor("#9c9ca5") : -16777216);
        int i = z ? R$raw.lottie_favourite_click : R$raw.lottie_favorite_cancel;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getView().getWannaSee().findViewById(R$id.ipinfo_showinfo_wannasee_icon);
        lottieAnimationView.setAnimation(i);
        lottieAnimationView.invalidate();
        lottieAnimationView.setProgress(0.0f);
        if (z2) {
            lottieAnimationView.playAnimation();
        } else {
            lottieAnimationView.setProgress(1.0f);
        }
    }

    public SpannableString getFansDesc(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067209632")) {
            return (SpannableString) ipChange.ipc$dispatch("1067209632", new Object[]{this, Long.valueOf(j), str});
        }
        try {
            String fansNum = getFansNum(j, str);
            SpannableString spannableString = new SpannableString(fansNum);
            spannableString.setSpan(new ForegroundColorSpan(this.mContext.getActivity().getResources().getColor(R$color.color_FF993A)), 0, fansNum.indexOf(str), 17);
            return spannableString;
        } catch (Exception e) {
            e.printStackTrace();
            return new SpannableString("");
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840397302")) {
            ipChange.ipc$dispatch("-1840397302", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        Log.e("msggsg", "i: " + i + " , o : " + obj);
        if (i == 10240 && (obj instanceof Pair)) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            if ((obj2 instanceof String) && "5".equals(obj2)) {
                Object obj3 = pair.second;
                if (obj3 instanceof Pair) {
                    Pair pair2 = (Pair) obj3;
                    if (getModel() == null || getModel().getIpInfo() == null || !getModel().getIpInfo().getId().equals(pair2.second)) {
                        return;
                    }
                    String str = getModel().getIpInfo().getFocus() ? "1" : "0";
                    if (str.equals(pair2.first + "")) {
                        return;
                    }
                    updateWannaSeeUi("1".equals(pair2.first + ""), false);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x05a9  */
    @Override // cn.damai.tetris.core.BasePresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(cn.damai.tetris.component.ip.IpInfoContract.Model r10) {
        /*
            Method dump skipped, instructions count: 1469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.ip.IpInfoPresenter.init(cn.damai.tetris.component.ip.IpInfoContract$Model):void");
    }
}
