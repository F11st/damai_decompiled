package cn.damai.tetris.component.star;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.star.FansRankingContract;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.bean.TopFans;
import cn.damai.tetris.component.star.view.FansRankingViewHolder;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMLabelView;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.e80;
import tb.gc;
import tb.ja;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FansRankingPresenter extends BasePresenter<FansRankingContract.Model, FansRankingView, BaseSection> implements FansRankingContract.Presenter<FansRankingContract.Model, FansRankingView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements FansRankingViewHolder.ITaskHandler {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.star.view.FansRankingViewHolder.ITaskHandler
        public void doShareTask() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1980562789")) {
                ipChange.ipc$dispatch("1980562789", new Object[]{this});
            } else {
                FansRankingPresenter.this.sendMsg(new Message(AbsFragment.TETRIS_BIZ_CODE_SHARE, null));
            }
        }

        @Override // cn.damai.tetris.component.star.view.FansRankingViewHolder.ITaskHandler
        public LifecycleOwner getLifecycleOwner() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1127242884") ? (LifecycleOwner) ipChange.ipc$dispatch("-1127242884", new Object[]{this}) : (LifecycleOwner) ((BasePresenter) FansRankingPresenter.this).mContext.getActivity();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1536904194")) {
                ipChange.ipc$dispatch("-1536904194", new Object[]{this, view});
                return;
            }
            NavProxy.from(((BasePresenter) FansRankingPresenter.this).mContext.getActivity()).toUri(FansRankingPresenter.this.getModel().getUrl());
            FansRankingPresenter.this.userTrackClick("rule", true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FansRankingBean a;

        c(FansRankingBean fansRankingBean) {
            this.a = fansRankingBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "574386175")) {
                ipChange.ipc$dispatch("574386175", new Object[]{this, view});
                return;
            }
            NavProxy.from(((BasePresenter) FansRankingPresenter.this).mContext.getActivity()).toUri(this.a.rankingUrl);
            FansRankingPresenter.this.userTrackClick("more", true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        d(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1501565012")) {
                ipChange.ipc$dispatch("-1501565012", new Object[]{this, bVar});
                return;
            }
            Bitmap bitmap = bVar.b;
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bVar.b.getHeight();
                int d = e80.d() - q60.a(((BasePresenter) FansRankingPresenter.this).mContext.getActivity(), 42.0f);
                int i = (height * d) / width;
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = i;
                layoutParams.width = d;
                this.a.setLayoutParams(layoutParams);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class e implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e(FansRankingPresenter fansRankingPresenter) {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1814765291")) {
                ipChange.ipc$dispatch("-1814765291", new Object[]{this, aVar});
            }
        }
    }

    public FansRankingPresenter(FansRankingView fansRankingView, String str, ja jaVar) {
        super(fansRankingView, str, jaVar);
    }

    private void bindFans(View view, TopFans topFans, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674901464")) {
            ipChange.ipc$dispatch("1674901464", new Object[]{this, view, topFans, Integer.valueOf(i)});
            return;
        }
        gc.a((TextView) view.findViewById(R$id.ll_fans_ranking_item_name), topFans.nickName);
        gc.a((TextView) view.findViewById(R$id.ll_fans_ranking_item_value), topFans.score);
        DMAvatar dMAvatar = (DMAvatar) view.findViewById(R$id.ll_fans_ranking_item_pic);
        dMAvatar.setVisibility(0);
        dMAvatar.setAvatar(topFans.headPic);
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
        dMAvatar.setAvatarPlaceholder(R$drawable.transparent_bg);
        DMLabelView dMLabelView = (DMLabelView) view.findViewById(R$id.ll_fans_ranking_item_number);
        dMLabelView.setLabelTextSize(14.0f);
        if (i == 0) {
            dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_RANK_TOP_ONE);
        } else if (i == 1) {
            dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_RANK_TOP_TWO);
        } else if (i == 2) {
            dMLabelView.setLabelType(DMLabelType.LABEL_TYPE_RANK_TOP_THREE);
        }
        dMLabelView.setLabelName("" + (i + 1));
    }

    public Bitmap getNewBitmap(Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014332794")) {
            return (Bitmap) ipChange.ipc$dispatch("-2014332794", new Object[]{this, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235647300")) {
            ipChange.ipc$dispatch("-235647300", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(FansRankingContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "752501921")) {
            ipChange.ipc$dispatch("752501921", new Object[]{this, model});
        } else if (model.getRankingData() != null) {
            FansRankingBean rankingData = model.getRankingData();
            TextView textView = (TextView) getView().getFansView().findViewById(R$id.tv_project_tip);
            if (textView != null) {
                if (!TextUtils.isEmpty(model.getStyleValue("title"))) {
                    textView.setVisibility(0);
                    textView.setText(model.getStyleValue("title"));
                } else {
                    textView.setVisibility(8);
                }
            }
            new FansRankingViewHolder(getView().getFansView(), new a(), this.mContext.getActivity(), this).q(rankingData);
            if (model.getFansList() != null) {
                LinearLayout linearLayout = (LinearLayout) getView().getRootView().findViewById(R$id.ll_fans_ranking_parent);
                linearLayout.removeAllViews();
                for (int i = 0; i < model.getFansList().size(); i++) {
                    View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_fans_love_rank_list_item, (ViewGroup) linearLayout, false);
                    linearLayout.addView(inflate);
                    bindFans(inflate, model.getFansList().get(i), i);
                }
            }
            if (TextUtils.isEmpty(getModel().getUrl())) {
                getView().getFansView().findViewById(R$id.layout_all).setVisibility(4);
            } else {
                ViewGroup fansView = getView().getFansView();
                int i2 = R$id.layout_all;
                fansView.findViewById(i2).setVisibility(0);
                getView().getFansView().findViewById(i2).setOnClickListener(new b());
                userTrackExpose(getView().getFansView().findViewById(i2), "rule");
            }
            ViewGroup fansView2 = getView().getFansView();
            int i3 = R$id.tv_all_click_toall;
            gc.a((TextView) fansView2.findViewById(i3), rankingData.rankingMoreLinkDesc);
            getView().getFansView().findViewById(R$id.layout_all_click_toall).setOnClickListener(new c(rankingData));
            userTrackExpose(getView().getFansView().findViewById(i3), "more");
            ImageView imageView = (ImageView) getView().getFansView().findViewById(R$id.fans_banner);
            if (!TextUtils.isEmpty(getModel().getBannerImg())) {
                imageView.setVisibility(0);
                IImageLoader a2 = cn.damai.uikit.image.a.a();
                String bannerImg = getModel().getBannerImg();
                int i4 = R$drawable.uikit_default_image_bg_gradient_v2;
                a2.loadinto(bannerImg, imageView, i4, i4);
                cn.damai.uikit.image.a.a().load(getModel().getBannerImg(), R$drawable.uikit_default_image_bg_grey, new d(imageView), new e(this));
                return;
            }
            imageView.setVisibility(8);
        }
    }
}
