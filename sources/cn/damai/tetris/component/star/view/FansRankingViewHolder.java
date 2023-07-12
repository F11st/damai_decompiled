package cn.damai.tetris.component.star.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import cn.damai.common.image.C0504a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.net.DoTaskResult;
import cn.damai.tetris.component.star.net.FinishTaskRequest;
import cn.damai.tetris.component.star.net.FinishTaskResponse;
import cn.damai.tetris.component.star.view.FansRankingViewHolder;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cs;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class FansRankingViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private RoundImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private DMIconFontTextView g;
    private View h;
    private ConstraintLayout i;
    private TextView j;
    private TextView k;
    private ConstraintLayout l;
    private TextView m;
    private TextView n;
    private ConstraintLayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private View s;
    private FansRankingBean t;
    private ITaskHandler u;
    private Context v;
    BasePresenter w;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface ITaskHandler {
        void doShareTask();

        LifecycleOwner getLifecycleOwner();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.view.FansRankingViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1976a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1976a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1156260664")) {
                ipChange.ipc$dispatch("-1156260664", new Object[]{this, view});
            } else if (LoginManager.k().q()) {
            } else {
                DMNav.from(FansRankingViewHolder.this.v).forResult(100).withExtras(new Bundle()).toUri(cs.f());
                FansRankingViewHolder.this.w.userTrackClick("login", true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.view.FansRankingViewHolder$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1977b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FansRankingBean a;

        View$OnClickListenerC1977b(FansRankingBean fansRankingBean) {
            this.a = fansRankingBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "955029705")) {
                ipChange.ipc$dispatch("955029705", new Object[]{this, view});
                return;
            }
            DMNav.from(FansRankingViewHolder.this.v).toUri(this.a.rankingDetailUrl);
            FansRankingViewHolder.this.w.userTrackClick("rankdetail", true);
        }
    }

    public FansRankingViewHolder(View view, ITaskHandler iTaskHandler, Context context, BasePresenter basePresenter) {
        this.s = view;
        this.v = context;
        this.u = iTaskHandler;
        this.r = (TextView) view.findViewById(R$id.join_vip_button);
        this.q = (TextView) view.findViewById(R$id.task3_desc);
        this.p = (TextView) view.findViewById(R$id.task3_name);
        this.o = (ConstraintLayout) view.findViewById(R$id.task3_container);
        this.n = (TextView) view.findViewById(R$id.task2_desc);
        this.m = (TextView) view.findViewById(R$id.task2_name);
        this.l = (ConstraintLayout) view.findViewById(R$id.task2_container);
        this.k = (TextView) view.findViewById(R$id.task1_desc);
        this.j = (TextView) view.findViewById(R$id.task1_name);
        this.i = (ConstraintLayout) view.findViewById(R$id.task1_container);
        this.h = view.findViewById(R$id.layout_shouhu_detail);
        this.g = (DMIconFontTextView) view.findViewById(R$id.youjiantou);
        this.f = (TextView) view.findViewById(R$id.love_value);
        this.d = (TextView) view.findViewById(R$id.name);
        this.e = (TextView) view.findViewById(R$id.unlogin_name);
        this.c = (RoundImageView) view.findViewById(R$id.user_head_pic);
        this.a = (TextView) view.findViewById(R$id.rank_value);
        this.b = (TextView) view.findViewById(R$id.tv_all_click_toall);
        this.w = basePresenter;
    }

    private void g(int i) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1439648874")) {
            ipChange.ipc$dispatch("1439648874", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        FansRankingBean fansRankingBean = this.t;
        if (fansRankingBean == null || (textView = this.f) == null) {
            return;
        }
        fansRankingBean.score += i;
        textView.setText(this.t.score + "");
    }

    private void h(FansRankingBean.TaskBean taskBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015481255")) {
            ipChange.ipc$dispatch("1015481255", new Object[]{this, taskBean});
        } else if (this.t == null || taskBean == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", taskBean.name);
            if (this.w.getSection().getTrackInfo().getArgsMap() != null) {
                hashMap.putAll(this.w.getSection().getTrackInfo().getArgsMap());
            }
            int i = taskBean.type;
            if (i == 1) {
                i(taskBean);
                this.w.userTrackClick("guard_0", hashMap, false);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                DMNav.from(this.v).forResult(100).toUri(taskBean.url);
                this.w.userTrackClick("guard_2", hashMap, true);
            } else {
                if (taskBean.applyStatus != 0) {
                    this.u.doShareTask();
                } else {
                    i(taskBean);
                }
                this.w.userTrackClick("guard_1", hashMap, false);
            }
        }
    }

    private void i(final FansRankingBean.TaskBean taskBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217836609")) {
            ipChange.ipc$dispatch("217836609", new Object[]{this, taskBean});
            return;
        }
        FinishTaskRequest finishTaskRequest = new FinishTaskRequest();
        finishTaskRequest.taskId = taskBean.taskId;
        finishTaskRequest.dataId = taskBean.dataId;
        if (this.u != null) {
            j(finishTaskRequest).observe(this.u.getLifecycleOwner(), new Observer() { // from class: tb.vh0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FansRankingViewHolder.this.k(taskBean, (FinishTaskResponse) obj);
                }
            });
        }
    }

    private MutableLiveData<FinishTaskResponse> j(FinishTaskRequest finishTaskRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261247238")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1261247238", new Object[]{this, finishTaskRequest});
        }
        final MutableLiveData<FinishTaskResponse> mutableLiveData = new MutableLiveData<>();
        finishTaskRequest.request(new DMMtopRequestListener<DoTaskResult>(DoTaskResult.class) { // from class: cn.damai.tetris.component.star.view.FansRankingViewHolder.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "221217072")) {
                    ipChange2.ipc$dispatch("221217072", new Object[]{this, str, str2});
                    return;
                }
                FinishTaskResponse finishTaskResponse = new FinishTaskResponse();
                finishTaskResponse.errorCode = str;
                finishTaskResponse.errorMsg = str2;
                mutableLiveData.setValue(finishTaskResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(DoTaskResult doTaskResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "804424421")) {
                    ipChange2.ipc$dispatch("804424421", new Object[]{this, doTaskResult});
                    return;
                }
                FinishTaskResponse finishTaskResponse = new FinishTaskResponse();
                finishTaskResponse.data = doTaskResult;
                mutableLiveData.setValue(finishTaskResponse);
            }
        });
        return mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(FansRankingBean.TaskBean taskBean, FinishTaskResponse finishTaskResponse) {
        DoTaskResult doTaskResult;
        DoTaskResult.TaskDetail taskDetail;
        DoTaskResult doTaskResult2;
        DoTaskResult.TaskDetail taskDetail2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841017146")) {
            ipChange.ipc$dispatch("841017146", new Object[]{this, taskBean, finishTaskResponse});
        } else if (taskBean.isGuardTask()) {
            if (finishTaskResponse != null && (doTaskResult2 = finishTaskResponse.data) != null && (taskDetail2 = doTaskResult2.taskDetail) != null && taskDetail2.applyStatus != 0) {
                taskBean.canClick = false;
                p(doTaskResult2.totalAssetsNum);
                this.k.setText("今日已完成");
                this.i.setEnabled(false);
                this.i.setBackgroundResource(R$drawable.bg_border_corner_99_black_22);
            } else if (TextUtils.isEmpty(finishTaskResponse.errorMsg)) {
            } else {
                ToastUtil.i(finishTaskResponse.errorMsg);
            }
        } else if (taskBean.isShareTask()) {
            if (finishTaskResponse != null && (doTaskResult = finishTaskResponse.data) != null && (taskDetail = doTaskResult.taskDetail) != null) {
                int i = taskDetail.applyStatus;
                if (i != 0) {
                    taskBean.canClick = false;
                    taskBean.applyStatus = i;
                    this.n.setText("今日已完成");
                }
                if (this.u != null) {
                    g(finishTaskResponse.data.totalAssetsNum);
                    this.u.doShareTask();
                }
            } else if (TextUtils.isEmpty(finishTaskResponse.errorMsg)) {
            } else {
                ToastUtil.i(finishTaskResponse.errorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i, DialogInterface dialogInterface, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744456559")) {
            ipChange.ipc$dispatch("-1744456559", new Object[]{this, Integer.valueOf(i), dialogInterface, Integer.valueOf(i2)});
        } else {
            g(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-545621251")) {
            ipChange.ipc$dispatch("-545621251", new Object[]{this, Integer.valueOf(i), view});
        } else {
            g(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(FansRankingBean fansRankingBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134897937")) {
            ipChange.ipc$dispatch("1134897937", new Object[]{this, fansRankingBean, view});
        } else if (!LoginManager.k().q()) {
            DMNav.from(this.v).forResult(100).withExtras(new Bundle()).toUri(cs.f());
        } else {
            DMNav.from(this.v).forResult(100).toUri(fansRankingBean.button.destination);
            this.w.userTrackClick("goto_artist_vip", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(FansRankingBean fansRankingBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051254160")) {
            ipChange.ipc$dispatch("-2051254160", new Object[]{this, fansRankingBean, view});
        } else if (!LoginManager.k().q()) {
            DMNav.from(this.v).forResult(100).withExtras(new Bundle()).toUri(cs.f());
        } else if (!fansRankingBean.artistVip && this.r.getVisibility() == 0) {
            ToastUtil.f("您还不是VIP会员哦");
        } else {
            FansRankingBean.TaskBean taskBean = (FansRankingBean.TaskBean) view.getTag();
            if (taskBean != null) {
                h(taskBean);
            }
        }
    }

    private void p(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129766434")) {
            ipChange.ipc$dispatch("-129766434", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Context context = this.v;
        if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        DMThemeDialog dMThemeDialog = new DMThemeDialog(this.v);
        dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_GUARD_SUCCESS);
        dMThemeDialog.f(false);
        dMThemeDialog.o("守护成功");
        if (i > 0) {
            String str = jn1.PLUS + i;
            SpannableString spannableString = new SpannableString(str + "守护值");
            spannableString.setSpan(new ForegroundColorSpan((int) SupportMenu.CATEGORY_MASK), 0, str.length(), 33);
            dMThemeDialog.j(spannableString);
        }
        dMThemeDialog.i(i > 0 ? "开心收下" : "我知道啦", new DialogInterface.OnClickListener() { // from class: tb.rh0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                FansRankingViewHolder.this.l(i, dialogInterface, i2);
            }
        });
        dMThemeDialog.g(true, new View.OnClickListener() { // from class: tb.sh0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FansRankingViewHolder.this.m(i, view);
            }
        });
        dMThemeDialog.show();
    }

    public void q(final FansRankingBean fansRankingBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10423282")) {
            ipChange.ipc$dispatch("-10423282", new Object[]{this, fansRankingBean});
        } else if (fansRankingBean != null) {
            this.t = fansRankingBean;
            if (fansRankingBean.rank >= 0) {
                this.a.setText(fansRankingBean.rank + "");
                if (fansRankingBean.rank > 9999) {
                    this.a.setTextSize(1, 10.0f);
                } else {
                    this.a.setTextSize(1, 20.0f);
                }
            } else {
                this.a.setText("——");
                this.a.setTextSize(1, 20.0f);
            }
            if (fansRankingBean.score >= 0) {
                this.f.setText(fansRankingBean.score + "");
                this.g.setVisibility(0);
            } else {
                this.f.setText("——");
                this.g.setVisibility(8);
            }
            if (LoginManager.k().q()) {
                C0504a.b().loadinto(fansRankingBean.headPic, this.c);
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.d.setText(fansRankingBean.nickName);
            } else {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.c.setImageResource(R$drawable.mine_account_default);
                this.s.findViewById(R$id.layout_shouhu_detail).setOnClickListener(new View$OnClickListenerC1976a());
            }
            if (!fansRankingBean.artistVip && fansRankingBean.button != null) {
                this.r.setVisibility(0);
                this.r.setText(fansRankingBean.button.name);
                this.w.userTrackExpose(this.r, "goto_artist_vip");
                this.r.setOnClickListener(new View.OnClickListener() { // from class: tb.uh0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FansRankingViewHolder.this.n(fansRankingBean, view);
                    }
                });
            } else {
                this.r.setVisibility(8);
                this.h.setOnClickListener(new View$OnClickListenerC1977b(fansRankingBean));
                this.w.userTrackExpose(this.h, "rankdetail");
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: tb.th0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FansRankingViewHolder.this.o(fansRankingBean, view);
                }
            };
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            this.o.setVisibility(8);
            List<FansRankingBean.TaskBean> list = fansRankingBean.task;
            if (list != null && !list.isEmpty()) {
                ConstraintLayout constraintLayout = null;
                TextView textView = null;
                TextView textView2 = null;
                for (int i = 0; i < fansRankingBean.task.size(); i++) {
                    if (i == 0) {
                        constraintLayout = this.i;
                        textView = this.j;
                        textView2 = this.k;
                    } else if (i == 1) {
                        constraintLayout = this.l;
                        textView = this.m;
                        textView2 = this.n;
                    } else if (i == 2) {
                        constraintLayout = this.o;
                        textView = this.p;
                        textView2 = this.q;
                    }
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                        textView.setText(fansRankingBean.task.get(i).name);
                        textView2.setText(fansRankingBean.task.get(i).desc);
                        if (fansRankingBean.task.get(i).applyStatus != 0) {
                            if (i == 0) {
                                this.k.setText("今日已完成");
                            } else if (i == 1) {
                                this.n.setText("今日已完成");
                            }
                        }
                        constraintLayout.setOnClickListener(onClickListener);
                        constraintLayout.setTag(fansRankingBean.task.get(i));
                        constraintLayout.setEnabled(fansRankingBean.task.get(i).canClick);
                        if (fansRankingBean.task.get(i).canClick) {
                            constraintLayout.setBackgroundResource(R$drawable.bg_border_corner_ff_black_22);
                        } else {
                            constraintLayout.setBackgroundResource(R$drawable.bg_border_corner_99_black_22);
                        }
                        if (!LoginManager.k().q()) {
                            constraintLayout.setEnabled(true);
                        }
                        if (!fansRankingBean.artistVip && this.r.getVisibility() == 0) {
                            constraintLayout.setBackgroundResource(R$drawable.bg_border_corner_99_black_22);
                            if (LoginManager.k().q()) {
                                constraintLayout.setEnabled(true);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    if (this.w.getSection().getTrackInfo().getArgsMap() != null) {
                        hashMap.putAll(this.w.getSection().getTrackInfo().getArgsMap());
                    }
                    hashMap.put("titlelabel", fansRankingBean.task.get(i).name);
                    this.w.userTrackExpose(constraintLayout, "guard_" + i, hashMap, false);
                }
            }
            if (TextUtils.isEmpty(fansRankingBean.rankingMoreLinkDesc)) {
                return;
            }
            this.b.setText(fansRankingBean.rankingMoreLinkDesc);
        }
    }
}
