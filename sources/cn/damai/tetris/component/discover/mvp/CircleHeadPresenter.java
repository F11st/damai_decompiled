package cn.damai.tetris.component.discover.mvp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.discover.bean.ThemeRelationQueryBean;
import cn.damai.commonbusiness.discover.request.ThemeRelationQueryRequest;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.discover.mvp.CircleHeadContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.NewSimpleTitleLayout;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.cb2;
import tb.cs;
import tb.d23;
import tb.gc;
import tb.gh1;
import tb.ja;
import tb.m62;
import tb.pb;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CircleHeadPresenter extends BasePresenter<CircleHeadContract.Model, CircleHeadContract.View, BaseSection> implements CircleHeadContract.Presenter<CircleHeadContract.Model, CircleHeadContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean addCircleStatue;
    private TrackInfo mTrackInfo;
    private CircleHeadContract.Model tempModel;
    private String themeId;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements NewSimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CircleHeadContract.Model a;

        a(CircleHeadContract.Model model) {
            this.a = model;
        }

        @Override // cn.damai.uikit.view.NewSimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1235125743")) {
                ipChange.ipc$dispatch("1235125743", new Object[]{this});
            } else if (CircleHeadPresenter.this.getContext() == null || CircleHeadPresenter.this.getContext().getActivity().isFinishing()) {
            } else {
                CircleHeadPresenter.this.getContext().getActivity().finish();
            }
        }

        @Override // cn.damai.uikit.view.NewSimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "832430673")) {
                ipChange.ipc$dispatch("832430673", new Object[]{this});
            } else if (this.a.getShare() != null) {
                CircleHeadPresenter.this.sendMsg(new Message(AbsFragment.TETRIS_BIZ_CODE_SHARE, null));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CircleHeadContract.Model a;

        b(CircleHeadContract.Model model) {
            this.a = model;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1744192107")) {
                ipChange.ipc$dispatch("1744192107", new Object[]{this, view});
                return;
            }
            CircleHeadPresenter circleHeadPresenter = CircleHeadPresenter.this;
            circleHeadPresenter.followCircle(circleHeadPresenter.addCircleStatue ? "0" : "1", this.a.getThemeBean().id, "21");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-439484820")) {
                ipChange.ipc$dispatch("-439484820", new Object[]{this, view});
            } else if (TextUtils.isEmpty(this.a)) {
            } else {
                HashMap<String, String> f = d23.f();
                f.put("quanziid", CircleHeadPresenter.this.getModel().getTrackInfo().getArgsMap().get(pb.CNT_CONTENT_ID));
                CircleHeadPresenter circleHeadPresenter = CircleHeadPresenter.this;
                circleHeadPresenter.userTrack(TrackType.click, null, ((CircleHeadContract.Model) ((BasePresenter) circleHeadPresenter).mModel).getTrackInfo().trackB, "top", gh1.MODULE_BANNER, f, true);
                DMNav.from(CircleHeadPresenter.this.getContext().getActivity()).toUri(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        d(CircleHeadPresenter circleHeadPresenter, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1892144031")) {
                ipChange.ipc$dispatch("1892144031", new Object[]{this, bVar});
                return;
            }
            Drawable drawable = bVar.a;
            if (drawable != null) {
                this.a.setImageDrawable(drawable);
                return;
            }
            Bitmap bitmap = bVar.b;
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    public CircleHeadPresenter(CircleHeadView circleHeadView, String str, ja jaVar) {
        super(circleHeadView, str, jaVar);
        this.addCircleStatue = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void followCircle(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483867913")) {
            ipChange.ipc$dispatch("483867913", new Object[]{this, str, str2, str3});
        } else if (LoginManager.k().q()) {
            ThemeRelationQueryRequest themeRelationQueryRequest = new ThemeRelationQueryRequest();
            themeRelationQueryRequest.operateType = str;
            themeRelationQueryRequest.targetId = str2;
            themeRelationQueryRequest.targetType = str3;
            themeRelationQueryRequest.request(new DMMtopRequestListener<ThemeRelationQueryBean>(ThemeRelationQueryBean.class) { // from class: cn.damai.tetris.component.discover.mvp.CircleHeadPresenter.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str4, String str5) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "945347284")) {
                        ipChange2.ipc$dispatch("945347284", new Object[]{this, str4, str5});
                    } else {
                        ToastUtil.i(str5);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(ThemeRelationQueryBean themeRelationQueryBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-325372541")) {
                        ipChange2.ipc$dispatch("-325372541", new Object[]{this, themeRelationQueryBean});
                        return;
                    }
                    if (!themeRelationQueryBean.hasJoin) {
                        if (CircleHeadPresenter.this.addCircleStatue != themeRelationQueryBean.hasJoin) {
                            ToastUtil.i("您已取消加入改圈子");
                        } else {
                            ToastUtil.i(themeRelationQueryBean.joinTotal);
                        }
                    } else {
                        ToastUtil.i("您已加入该圈子");
                    }
                    HashMap<String, String> f = d23.f();
                    f.put("type", CircleHeadPresenter.this.addCircleStatue ? "1" : "0");
                    f.put("quanziid", CircleHeadPresenter.this.getModel().getTrackInfo().getArgsMap().get(pb.CNT_CONTENT_ID));
                    CircleHeadPresenter circleHeadPresenter = CircleHeadPresenter.this;
                    circleHeadPresenter.userTrack(TrackType.click, null, circleHeadPresenter.getModel().getTrackInfo().trackB, "top", "join", f, false);
                    boolean z = CircleHeadPresenter.this.addCircleStatue;
                    boolean z2 = themeRelationQueryBean.hasJoin;
                    if (z != z2) {
                        CircleHeadPresenter.this.addCircleStatue = z2;
                        CircleHeadPresenter.this.joinUserUpdate(themeRelationQueryBean.joinTotal, themeRelationQueryBean.joinHeadPics);
                        CircleHeadPresenter circleHeadPresenter2 = CircleHeadPresenter.this;
                        circleHeadPresenter2.joinBtnStyleView(circleHeadPresenter2.addCircleStatue);
                        if (CircleHeadPresenter.this.tempModel != null) {
                            CircleHeadPresenter.this.tempModel.getThemeBean().hasJoin = themeRelationQueryBean.hasJoin;
                            CircleHeadPresenter.this.tempModel.getThemeBean().joinHeadPics = themeRelationQueryBean.joinHeadPics;
                            CircleHeadPresenter.this.tempModel.getThemeBean().joinTotal = themeRelationQueryBean.joinTotal;
                        }
                        CircleHeadPresenter.this.sendMsg(new Message(8001, null));
                    }
                }
            });
        } else {
            LoginManager.k().x(getContext().getActivity(), new Intent(), 1000);
        }
    }

    private void imgShow(ImageView imageView, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1347939583")) {
            ipChange.ipc$dispatch("-1347939583", new Object[]{this, imageView, str, Integer.valueOf(i)});
            return;
        }
        if (i != 0) {
            imageView.setImageResource(i);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cn.damai.uikit.image.a.a().loadinto(str, imageView);
        cn.damai.uikit.image.a.a().load(str, 0, 0, 0, new d(this, imageView), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void joinBtnStyleView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229669332")) {
            ipChange.ipc$dispatch("-1229669332", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        String startColor = getModel().getStartColor();
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.mContext.getActivity(), R$drawable.circle_share_bg);
        if (gradientDrawable != null) {
            gradientDrawable.setColor(Color.parseColor(startColor));
            gradientDrawable.setAlpha(z ? AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX : 255);
            getView().getThemeJoinBtn().setBackground(gradientDrawable);
        }
        getView().getJoinIcon().setVisibility(z ? 8 : 0);
        gc.a(getView().getThemeJoinBtn(), z ? "已加入" : "     加入");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void joinUserUpdate(String str, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568130766")) {
            ipChange.ipc$dispatch("-1568130766", new Object[]{this, str, arrayList});
            return;
        }
        gc.a(getView().getThemeJoinNum(), str);
        getView().getThemeJoinNum().setTextColor(Color.parseColor(getModel().getStartColor()));
        if (arrayList != null && arrayList.size() > 0) {
            getView().getUserOverlay().setMaxAvatarCount(3);
            getView().getUserOverlay().setImageSize(t60.a(getContext().getActivity(), 14.0f));
            getView().getUserOverlay().initData(arrayList);
            getView().getUserOverlay().setVisibility(0);
            return;
        }
        getView().getUserOverlay().setVisibility(8);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Presenter
    public void clickPoj(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876512038")) {
            ipChange.ipc$dispatch("1876512038", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        } else if (projectItemBean == null) {
        } else {
            HashMap<String, String> f = d23.f();
            f.put("quanziid", this.themeId);
            f.put("item_id", projectItemBean.id);
            TrackType trackType = TrackType.click;
            String str = ((CircleHeadContract.Model) this.mModel).getTrackInfo().trackB;
            userTrack(trackType, null, str, "center_item", "item_" + i, f, true);
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
            bundle.putString("projectName", projectItemBean.name);
            bundle.putString("projectImage", projectItemBean.verticalPic);
            if (!TextUtils.isEmpty(projectItemBean.schema)) {
                NavProxy.from(this.mContext.getActivity()).withExtras(bundle).toUri(projectItemBean.schema);
            } else {
                NavProxy.from(this.mContext.getActivity()).withExtras(bundle).toUri(INavUri.page(cs.b));
            }
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Presenter
    public void clickPojMore(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042341189")) {
            ipChange.ipc$dispatch("1042341189", new Object[]{this, list});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("quanziid", this.themeId);
        userTrack(TrackType.click, null, ((CircleHeadContract.Model) this.mModel).getTrackInfo().trackB, "center_item", "more", f, true);
        Bundle bundle = new Bundle();
        bundle.putSerializable("projectList", (ArrayList) list);
        DMNav.from(this.mContext.getActivity()).withExtras(bundle).toUri(NavUri.b("theme_project_list"));
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Presenter
    public void clickVote(RankUserBean rankUserBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1826239740")) {
            ipChange.ipc$dispatch("-1826239740", new Object[]{this, rankUserBean, Integer.valueOf(i)});
        } else if (rankUserBean.isValidUser()) {
            HashMap<String, String> f = d23.f();
            f.put("quanziid", this.themeId);
            TrackType trackType = TrackType.click;
            String str = ((CircleHeadContract.Model) this.mModel).getTrackInfo().trackB;
            userTrack(trackType, null, str, "rank", "item_" + i, f, true);
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, rankUserBean.havanaIdStr);
            DMNav.from(this.mContext.getActivity()).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Presenter
    public void exposePoj(View view, ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-767372008")) {
            ipChange.ipc$dispatch("-767372008", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("quanziid", this.themeId);
        f.put("item_id", projectItemBean.id);
        TrackType trackType = TrackType.expose;
        String str = ((CircleHeadContract.Model) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, view, str, "center_item", "item_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Presenter
    public void exposeVote(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219812209")) {
            ipChange.ipc$dispatch("-1219812209", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("quanziid", this.themeId);
        TrackType trackType = TrackType.expose;
        String str = ((CircleHeadContract.Model) this.mModel).getTrackInfo().trackB;
        userTrack(trackType, view, str, "rank", "item_" + i, f, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1249518295")) {
            ipChange.ipc$dispatch("-1249518295", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616348678")) {
            return ((Boolean) ipChange.ipc$dispatch("616348678", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(CircleHeadContract.Model model) {
        String str;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2015715331")) {
            ipChange.ipc$dispatch("-2015715331", new Object[]{this, model});
            return;
        }
        this.tempModel = model;
        this.mTrackInfo = model.getTrackInfo();
        this.themeId = model.getThemeBean().id;
        getView().getTitleLayout().enableImmersiveMode(getContext().getActivity());
        getView().getTitleLayout().setAlpha(0.0f);
        getView().getTitleLayout().setListener(new a(model));
        HashMap<String, String> f = d23.f();
        f.put("type", this.addCircleStatue ? "1" : "0");
        f.put("quanziid", this.themeId);
        userTrack(TrackType.expose, getView().getThemeJoinBtn(), ((CircleHeadContract.Model) this.mModel).getTrackInfo().trackB, "top", "join", f, false);
        getView().getTitleLayout().showShareBtn((this.tempModel.getShare() == null || this.tempModel.getShare().shareUrl == null) ? false : false);
        if (model.getThemeBean() != null) {
            gc.a(getView().getThemeName(), model.getThemeBean().themeName);
            joinUserUpdate(model.getThemeBean().joinTotal, model.getThemeBean().joinHeadPics);
            if (TextUtils.isEmpty(model.getThemeBean().themeDesc)) {
                getView().getThemeDesc().setVisibility(8);
            }
            TextView themeDesc = getView().getThemeDesc();
            if (TextUtils.isEmpty(model.getThemeBean().themeDesc)) {
                str = "";
            } else {
                str = "简介：" + model.getThemeBean().themeDesc;
            }
            gc.a(themeDesc, str);
            boolean z2 = model.getThemeBean().hasJoin;
            this.addCircleStatue = z2;
            joinBtnStyleView(z2);
            getView().getThemeJoinBtn().setOnClickListener(new b(model));
            imgShow(getView().getBgImage(), getModel().getThemeBean().colorGroup.backgroundImage, 0);
            imgShow(getView().getCircleHeadImage(), getModel().getThemeBean().headImage, R$drawable.uikit_default_image_bg_gradient);
        }
        List<ProjectItemBean> projectList = model.getProjectList();
        if (cb2.d(projectList)) {
            getView().getProjectUi().setVisibility(8);
        } else {
            getView().getProjectUi().setVisibility(0);
            getView().getProjectUi().create(projectList);
        }
        getView().getRankView().k(model.getRank());
        String bannerPic = getModel().getBannerPic();
        String bannerUrl = getModel().getBannerUrl();
        if (!TextUtils.isEmpty(bannerPic) && !TextUtils.isEmpty(bannerUrl)) {
            getView().getBannerUi().setVisibility(0);
            getView().getBannerImg().setOnClickListener(new c(bannerUrl));
            cn.damai.common.image.a.b().f(bannerPic, DisplayMetrics.getwidthPixels(m62.b(getContext().getActivity())) - (m62.a(getContext().getActivity(), 12.0f) * 2), m62.a(getContext().getActivity(), 88.0f)).g(getView().getBannerImg());
            return;
        }
        getView().getBannerUi().setVisibility(8);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void rebindData(CircleHeadContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244602343")) {
            ipChange.ipc$dispatch("1244602343", new Object[]{this, model});
            return;
        }
        CircleHeadContract.Model model2 = this.tempModel;
        if (model2 != null) {
            super.rebindData((CircleHeadPresenter) model2);
        } else {
            super.rebindData((CircleHeadPresenter) model);
        }
    }
}
