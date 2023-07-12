package com.alibaba.pictures.bricks.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.VoteActionRes;
import com.alibaba.pictures.bricks.bean.VoteBean;
import com.alibaba.pictures.bricks.bean.VoteInfoBean;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.BottomListDialog;
import com.alibaba.pictures.bricks.view.VotePanel;
import com.alibaba.pictures.bricks.view.request.VoteActionRequest;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bb2;
import tb.cc0;
import tb.dc0;
import tb.wt2;
import tb.xy2;
import tb.yb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class VotePanel implements OnItemClickListener<VoteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final ViewGroup a;
    @NotNull
    private final TextView b;
    @NotNull
    private final TextView c;
    @NotNull
    private final ViewGroup d;
    @Nullable
    private VoteInfoBean e;
    private int f;
    @NotNull
    private final VoteActionListener g;
    private int h;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface VoteActionListener extends VoteUtListener {
        @Nullable
        Activity getActivity();

        void onVoteInfoUpdate(@NotNull VoteInfoBean voteInfoBean);

        void showActivityLoading(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface VoteUtListener {
        void ut4CancelVoteClick(@Nullable VoteInfoBean voteInfoBean);

        void ut4VoteCardExposure(@Nullable View view, @Nullable VoteInfoBean voteInfoBean, int i);

        void ut4VoteClick(@Nullable VoteInfoBean voteInfoBean, @Nullable VoteBean voteBean, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.VotePanel$a */
    /* loaded from: classes7.dex */
    public static final class C3585a implements BottomListDialog.OnActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ VoteBean b;
        final /* synthetic */ String c;

        C3585a(VoteBean voteBean, String str) {
            this.b = voteBean;
            this.c = str;
        }

        @Override // com.alibaba.pictures.bricks.view.BottomListDialog.OnActionListener
        public void onCancelVoteClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-569016308")) {
                ipChange.ipc$dispatch("-569016308", new Object[]{this});
                return;
            }
            VotePanel votePanel = VotePanel.this;
            VoteBean voteBean = this.b;
            String str = this.c;
            b41.h(str, "activityId");
            votePanel.f(voteBean, str, false, VotePanel.this.g());
        }

        @Override // com.alibaba.pictures.bricks.view.BottomListDialog.OnActionListener
        public void onGiveUpClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-645711212")) {
                ipChange.ipc$dispatch("-645711212", new Object[]{this});
            }
        }
    }

    public VotePanel(@NotNull ViewGroup viewGroup, @NotNull VoteActionListener voteActionListener) {
        b41.i(viewGroup, "mRoot");
        b41.i(voteActionListener, "listener");
        this.a = viewGroup;
        View findViewById = viewGroup.findViewById(R$id.vote_select_title);
        b41.h(findViewById, "mRoot.findViewById(R.id.vote_select_title)");
        this.b = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R$id.vote_select_count);
        b41.h(findViewById2, "mRoot.findViewById(R.id.vote_select_count)");
        this.c = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R$id.vote_select_item_container);
        b41.h(findViewById3, "mRoot.findViewById(R.id.…te_select_item_container)");
        this.d = (ViewGroup) findViewById3;
        this.g = voteActionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final VoteBean voteBean, String str, final boolean z, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525228938")) {
            ipChange.ipc$dispatch("-1525228938", new Object[]{this, voteBean, str, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (i() || this.e == null) {
            this.g.showActivityLoading(true);
            if (!DoloresLoginHandler.Companion.a().c()) {
                yb1.C9955a c9955a = yb1.Companion;
                Context context = this.a.getContext();
                b41.h(context, "mRoot.context");
                c9955a.b(context);
                return;
            }
            VoteInfoBean voteInfoBean = this.e;
            b41.f(voteInfoBean);
            String str2 = voteInfoBean.id;
            b41.h(str2, "mBean!!.id");
            cc0.a(new VoteActionRequest(str2, str, z)).doOnKTSuccess(new Function1<VoteActionRes, wt2>() { // from class: com.alibaba.pictures.bricks.view.VotePanel$dispatchVoteAction$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(VoteActionRes voteActionRes) {
                    invoke2(voteActionRes);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable VoteActionRes voteActionRes) {
                    VotePanel.VoteActionListener voteActionListener;
                    VotePanel.VoteActionListener voteActionListener2;
                    VoteInfoBean voteInfoBean2;
                    VotePanel.VoteActionListener voteActionListener3;
                    VoteInfoBean voteInfoBean3;
                    VotePanel.VoteActionListener voteActionListener4;
                    VoteInfoBean voteInfoBean4;
                    VotePanel.VoteActionListener voteActionListener5;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "502689702")) {
                        ipChange2.ipc$dispatch("502689702", new Object[]{this, voteActionRes});
                    } else if (voteActionRes == null) {
                    } else {
                        voteActionListener = VotePanel.this.g;
                        voteActionListener.showActivityLoading(false);
                        if (voteActionRes.isShouldShowToast()) {
                            BricksToastUtil.INSTANCE.b(voteActionRes.msg);
                        }
                        if (voteActionRes.isValid()) {
                            voteActionListener5 = VotePanel.this.g;
                            VoteInfoBean voteInfoBean5 = voteActionRes.voteVO;
                            b41.h(voteInfoBean5, "bean.voteVO");
                            voteActionListener5.onVoteInfoUpdate(voteInfoBean5);
                            VotePanel votePanel = VotePanel.this;
                            votePanel.e(voteActionRes.voteVO, true, votePanel.g());
                        } else {
                            voteActionListener2 = VotePanel.this.g;
                            voteActionListener2.showActivityLoading(false);
                            BricksToastUtil.INSTANCE.b("数据异常，请点击重试");
                        }
                        voteInfoBean2 = VotePanel.this.e;
                        if (voteInfoBean2 != null) {
                            if (z) {
                                voteActionListener4 = VotePanel.this.g;
                                voteInfoBean4 = VotePanel.this.e;
                                voteActionListener4.ut4VoteClick(voteInfoBean4, voteBean, i);
                                return;
                            }
                            voteActionListener3 = VotePanel.this.g;
                            voteInfoBean3 = VotePanel.this.e;
                            voteActionListener3.ut4CancelVoteClick(voteInfoBean3);
                        }
                    }
                }
            }).doOnKTFail(new Function1<dc0<VoteActionRes>, wt2>() { // from class: com.alibaba.pictures.bricks.view.VotePanel$dispatchVoteAction$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<VoteActionRes> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<VoteActionRes> dc0Var) {
                    VotePanel.VoteActionListener voteActionListener;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "373992329")) {
                        ipChange2.ipc$dispatch("373992329", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    voteActionListener = VotePanel.this.g;
                    voteActionListener.showActivityLoading(false);
                    BricksToastUtil.INSTANCE.b(dc0Var.d());
                }
            });
        }
    }

    private final boolean i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348392824")) {
            return ((Boolean) ipChange.ipc$dispatch("348392824", new Object[]{this})).booleanValue();
        }
        Activity activity = this.g.getActivity();
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    private final void k(boolean z, List<? extends VoteBean> list, boolean z2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1507467371")) {
            ipChange.ipc$dispatch("1507467371", new Object[]{this, Boolean.valueOf(z), list, Boolean.valueOf(z2), Integer.valueOf(i)});
            return;
        }
        if (bb2.d(list)) {
            this.d.removeAllViews();
        } else {
            int childCount = this.d.getChildCount();
            int size = list.size();
            int i2 = size - childCount;
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    View inflate = LayoutInflater.from(AppInfoProviderProxy.getApplication()).inflate(R$layout.bricks_item_single_vote_bar, this.d, false);
                    b41.g(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup = (ViewGroup) inflate;
                    viewGroup.setTag(new xy2(viewGroup, this));
                    this.d.addView(viewGroup);
                }
            }
            if (i2 < 0) {
                this.d.removeViews(size, -i2);
            }
        }
        int childCount2 = this.d.getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            VoteBean voteBean = (VoteBean) bb2.b(list, i4);
            Object tag = this.d.getChildAt(i4).getTag();
            if ((tag instanceof xy2) && voteBean != null) {
                if (i == 1 && Build.VERSION.SDK_INT >= 21) {
                    ((xy2) tag).d(this.a.getContext().getDrawable(R$drawable.bricks_purple_progress_drawable), this.a.getContext().getDrawable(R$drawable.bricks_grey_progress_drawable), "#8F8FFF", "#333333");
                }
                ((xy2) tag).b(voteBean, z, i4, z2);
            }
        }
    }

    public final void d(@Nullable VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682325428")) {
            ipChange.ipc$dispatch("-1682325428", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
        } else {
            e(voteInfoBean, false, i);
        }
    }

    public final void e(@Nullable VoteInfoBean voteInfoBean, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611944826")) {
            ipChange.ipc$dispatch("-611944826", new Object[]{this, voteInfoBean, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (voteInfoBean == null) {
        } else {
            this.e = voteInfoBean;
            this.f = i;
            b41.f(voteInfoBean);
            voteInfoBean.computeItemProgressIntIfNeed();
            this.b.setText(voteInfoBean.name);
            this.c.setText(voteInfoBean.getPeopleCountText(this.h == 1));
            try {
                VoteInfoBean voteInfoBean2 = this.e;
                b41.f(voteInfoBean2);
                boolean z2 = voteInfoBean2.hasVote;
                List<VoteBean> list = voteInfoBean.activityOptions;
                b41.h(list, "bean.activityOptions");
                k(z2, list, z, this.h);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.g.ut4VoteCardExposure(this.a, this.e, this.f);
        }
    }

    public final int g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1150712746") ? ((Integer) ipChange.ipc$dispatch("-1150712746", new Object[]{this})).intValue() : this.f;
    }

    @NotNull
    public final View h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1961751998") ? (View) ipChange.ipc$dispatch("1961751998", new Object[]{this}) : this.a;
    }

    @Override // com.alibaba.pictures.bricks.view.OnItemClickListener
    /* renamed from: j */
    public void onItemClick(@Nullable VoteBean voteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093666558")) {
            ipChange.ipc$dispatch("-1093666558", new Object[]{this, voteBean, Integer.valueOf(i)});
        } else if (this.e == null || !i()) {
        } else {
            Activity activity = this.g.getActivity();
            VoteInfoBean voteInfoBean = this.e;
            b41.f(voteInfoBean);
            if (voteInfoBean.hasVote) {
                VoteInfoBean voteInfoBean2 = this.e;
                b41.f(voteInfoBean2);
                String votedItemId = voteInfoBean2.getVotedItemId();
                b41.f(activity);
                new BottomListDialog(activity, new C3585a(voteBean, votedItemId)).show();
                return;
            }
            b41.f(voteBean);
            String str = voteBean.id;
            b41.h(str, "bean!!.id");
            f(voteBean, str, true, this.f);
        }
    }
}
