package com.alibaba.pictures.bricks.component.home.feed;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.base.IBaseActivityProxy;
import com.alibaba.pictures.bricks.bean.VoteBean;
import com.alibaba.pictures.bricks.bean.VoteInfoBean;
import com.alibaba.pictures.bricks.component.home.feed.VoteContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.util.C3550a;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.VotePanel;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class VoteView extends AbsView<GenericItem<ItemValue>, VoteModel, VotePresent> implements VoteContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    @Nullable
    private VoteInfoBean mBean;
    @Nullable
    private VotePanel mPanel;
    @NotNull
    private final View mRoot;
    @NotNull
    private final ImageView mTopImg;
    @NotNull
    private final DMCategroyTagView mVoteTag;
    @NotNull
    private final View mVoteTagNew;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.feed.VoteView$a */
    /* loaded from: classes7.dex */
    public static final class C3472a implements VotePanel.VoteActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ VoteView b;

        C3472a(Context context, VoteView voteView) {
            this.a = context;
            this.b = voteView;
        }

        @Override // com.alibaba.pictures.bricks.view.VotePanel.VoteActionListener
        @Nullable
        public Activity getActivity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "5148103")) {
                return (Activity) ipChange.ipc$dispatch("5148103", new Object[]{this});
            }
            Context context = this.a;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return null;
        }

        @Override // com.alibaba.pictures.bricks.view.VotePanel.VoteActionListener
        public void onVoteInfoUpdate(@NotNull VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2014048294")) {
                ipChange.ipc$dispatch("-2014048294", new Object[]{this, voteInfoBean});
            } else {
                b41.i(voteInfoBean, "bean");
            }
        }

        @Override // com.alibaba.pictures.bricks.view.VotePanel.VoteActionListener
        public void showActivityLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1589995298")) {
                ipChange.ipc$dispatch("-1589995298", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            Activity activity = getActivity();
            if (activity instanceof IBaseActivityProxy) {
                IBaseActivityProxy iBaseActivityProxy = (IBaseActivityProxy) activity;
                if (z) {
                    iBaseActivityProxy.showLoading(new String[0]);
                } else {
                    iBaseActivityProxy.hideLoading();
                }
            }
        }

        @Override // com.alibaba.pictures.bricks.view.VotePanel.VoteUtListener
        public void ut4CancelVoteClick(@Nullable VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1039246761")) {
                ipChange.ipc$dispatch("1039246761", new Object[]{this, voteInfoBean});
            } else {
                ((VotePresent) this.b.getPresenter()).ut4CancelVoteClick(voteInfoBean);
            }
        }

        @Override // com.alibaba.pictures.bricks.view.VotePanel.VoteUtListener
        public void ut4VoteCardExposure(@Nullable View view, @Nullable VoteInfoBean voteInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1848255065")) {
                ipChange.ipc$dispatch("-1848255065", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
            } else {
                ((VotePresent) this.b.getPresenter()).ut4VoteCardExposure(view, voteInfoBean, i);
            }
        }

        @Override // com.alibaba.pictures.bricks.view.VotePanel.VoteUtListener
        public void ut4VoteClick(@Nullable VoteInfoBean voteInfoBean, @Nullable VoteBean voteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1107091610")) {
                ipChange.ipc$dispatch("1107091610", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
            } else {
                ((VotePresent) this.b.getPresenter()).ut4VoteClick(voteInfoBean, voteBean, i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.item_feed_vote_top_img);
        b41.h(findViewById, "itemView.findViewById(R.id.item_feed_vote_top_img)");
        this.mTopImg = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.item_feed_vote_ui);
        b41.h(findViewById2, "itemView.findViewById<Vi…>(R.id.item_feed_vote_ui)");
        this.mRoot = findViewById2;
        View findViewById3 = view.findViewById(R$id.item_vote_tag);
        b41.h(findViewById3, "itemView.findViewById(R.id.item_vote_tag)");
        this.mVoteTag = (DMCategroyTagView) findViewById3;
        View findViewById4 = view.findViewById(R$id.item_vote_tag_img);
        b41.h(findViewById4, "itemView.findViewById(R.id.item_vote_tag_img)");
        this.mVoteTagNew = findViewById4;
        View findViewById5 = view.findViewById(R$id.item_vote_layout_id);
        b41.h(findViewById5, "itemView.findViewById(R.id.item_vote_layout_id)");
        Context context = view.getContext();
        b41.h(context, "itemView.context");
        this.mPanel = new VotePanel((ViewGroup) findViewById5, getActionListener(context));
    }

    private final VotePanel.VoteActionListener getActionListener(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1586295014") ? (VotePanel.VoteActionListener) ipChange.ipc$dispatch("1586295014", new Object[]{this, context}) : new C3472a(context, this);
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.VoteContract.View
    public void bindView(@NotNull VoteInfoBean voteInfoBean) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1351079483")) {
            ipChange.ipc$dispatch("-1351079483", new Object[]{this, voteInfoBean});
            return;
        }
        b41.i(voteInfoBean, "bean");
        if (this.mBean == voteInfoBean) {
            return;
        }
        this.mBean = voteInfoBean;
        View view = this.mRoot;
        b41.f(voteInfoBean);
        view.setBackground(voteInfoBean.getVoteBgDrawable());
        VoteInfoBean voteInfoBean2 = this.mBean;
        b41.f(voteInfoBean2);
        if (TextUtils.isEmpty(voteInfoBean2.activityTag)) {
            this.mVoteTag.setVisibility(8);
            this.mVoteTagNew.setVisibility(8);
        } else {
            VoteInfoBean voteInfoBean3 = this.mBean;
            b41.f(voteInfoBean3);
            if (b41.d("投票", voteInfoBean3.activityTag)) {
                this.mVoteTagNew.setVisibility(0);
                this.mVoteTag.setVisibility(8);
            } else {
                this.mVoteTagNew.setVisibility(8);
                this.mVoteTag.setVisibility(0);
                DMCategroyTagView dMCategroyTagView = this.mVoteTag;
                VoteInfoBean voteInfoBean4 = this.mBean;
                b41.f(voteInfoBean4);
                dMCategroyTagView.setTagName(voteInfoBean4.activityTag);
                this.mVoteTag.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
            }
        }
        VoteInfoBean voteInfoBean5 = this.mBean;
        b41.f(voteInfoBean5);
        String str = voteInfoBean5.feedBackground;
        if (TextUtils.isEmpty(str)) {
            this.mTopImg.setVisibility(8);
            s60 s60Var = s60.INSTANCE;
            Application application = AppInfoProviderProxy.getApplication();
            b41.h(application, "getApplication()");
            i = s60Var.b(application, 37);
        } else {
            this.mTopImg.setVisibility(0);
            s60 s60Var2 = s60.INSTANCE;
            Application application2 = AppInfoProviderProxy.getApplication();
            b41.h(application2, "getApplication()");
            int b = s60Var2.b(application2, 82);
            Application application3 = AppInfoProviderProxy.getApplication();
            b41.h(application3, "getApplication()");
            DisplayMetrics d = s60Var2.d(application3);
            if (d != null) {
                int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(d);
                Application application4 = AppInfoProviderProxy.getApplication();
                b41.h(application4, "getApplication()");
                Application application5 = AppInfoProviderProxy.getApplication();
                b41.h(application5, "getApplication()");
                ImageLoaderProviderProxy.loadinto(C3550a.c(str, (i2 - (s60Var2.b(application4, 21) * 2)) / 2, s60Var2.b(application5, 90)), this.mTopImg);
            } else {
                ImageLoaderProviderProxy.loadinto(str, this.mTopImg);
            }
            i = b;
        }
        VotePanel votePanel = this.mPanel;
        View h = votePanel != null ? votePanel.h() : null;
        ViewGroup.LayoutParams layoutParams = h != null ? h.getLayoutParams() : null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i;
            h.setLayoutParams(layoutParams);
        }
        VotePanel votePanel2 = this.mPanel;
        b41.f(votePanel2);
        votePanel2.d(this.mBean, ((VotePresent) getPresenter()).getViewCard().getRankInModule());
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1381908637") ? (View) ipChange.ipc$dispatch("-1381908637", new Object[]{this}) : this.itemView;
    }
}
