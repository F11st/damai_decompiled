package cn.damai.evaluate.ui.item;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.comment.R$dimen;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.CommentTextDoBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.listener.OnPraiseViewClickListener;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.comment.util.NineImgUtil;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.al;
import tb.cl;
import tb.cs;
import tb.dl;
import tb.g41;
import tb.m62;
import tb.pf0;
import tb.pl;
import tb.u12;
import tb.xr;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class EvaluateItemDataBinder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COMMENT_ITEM_TYPE_DEFAULT = 0;
    public static final int COMMENT_ITEM_TYPE_DETAIL = 1;
    public static final int COMMENT_SCENE_DEFAULT = 0;
    public static final int COMMENT_SCENE_SCRIPT = 2;
    public static final int COMMENT_SCENE_SCRIPT_STORE = 1;
    private Activity a;
    private f b;
    private e c;
    private EvaluateItemUTReportListener d;
    private EvaluateItemOtherListener e;
    public SimpleItemClickListener f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private OnPraiseViewClickListener k;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface EvaluateItemOtherListener {
        void deleteComment(CommentsItemBean commentsItemBean);

        void onClickShareBtn(CommentsItemBean commentsItemBean);

        void replyContentClick(boolean z, CommentsItemBean commentsItemBean);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface EvaluateItemUTReportListener {
        void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2);

        void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);

        void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    enum Scene {
        LIST(0),
        DETAIL(1);
        
        int value;

        Scene(int i) {
            this.value = i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface SimpleItemClickListener {
        void onSingleItemClick();
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ EvaluateItemViewHolder a;

        a(EvaluateItemDataBinder evaluateItemDataBinder, EvaluateItemViewHolder evaluateItemViewHolder) {
            this.a = evaluateItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2019771697")) {
                ipChange.ipc$dispatch("-2019771697", new Object[]{this, view});
                return;
            }
            EvaluateItemViewHolder evaluateItemViewHolder = this.a;
            if (evaluateItemViewHolder == null || (textView = evaluateItemViewHolder.c) == null || textView.getLayout() == null) {
                return;
            }
            if (this.a.c.getLayout().getEllipsisCount(this.a.c.getLineCount() - 1) > 0) {
                this.a.e.setText("收起");
                this.a.c.setMaxLines(Integer.MAX_VALUE);
                return;
            }
            this.a.e.setText("查看全文");
            this.a.c.setMaxLines(5);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements NineImgUtil.OnClickExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;

        b(CommentsItemBean commentsItemBean) {
            this.a = commentsItemBean;
        }

        @Override // cn.damai.comment.util.NineImgUtil.OnClickExtraListener
        public void onExtraLister(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-946057035")) {
                ipChange.ipc$dispatch("-946057035", new Object[]{this, Integer.valueOf(i)});
            } else if (EvaluateItemDataBinder.this.d != null) {
                EvaluateItemUTReportListener evaluateItemUTReportListener = EvaluateItemDataBinder.this.d;
                CommentsItemBean commentsItemBean = this.a;
                evaluateItemUTReportListener.onReportImageInfoClickEvent(false, commentsItemBean, commentsItemBean.getItemIndex(), i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TextView a;
        final /* synthetic */ CommentsItemBean b;

        c(TextView textView, CommentsItemBean commentsItemBean) {
            this.a = textView;
            this.b = commentsItemBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "19132114")) {
                ipChange.ipc$dispatch("19132114", new Object[]{this, view});
            } else if (!LoginManager.k().q()) {
                LoginManager.k().v(EvaluateItemDataBinder.this.a);
            } else if (EvaluateItemDataBinder.this.a == null || EvaluateItemDataBinder.this.e == null || TextUtils.isEmpty(this.a.getText().toString())) {
            } else {
                EvaluateItemDataBinder.this.e.replyContentClick(true, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d implements OnPraiseViewClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.comment.listener.OnPraiseViewClickListener
        public void OnPraiseViewClick(boolean z, CommentsItemBean commentsItemBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "274677592")) {
                ipChange.ipc$dispatch("274677592", new Object[]{this, Boolean.valueOf(z), commentsItemBean});
            } else if (EvaluateItemDataBinder.this.a == null || EvaluateItemDataBinder.this.a.isFinishing()) {
            } else {
                xr.c("evaluate_praise", commentsItemBean);
                if (EvaluateItemDataBinder.this.d != null) {
                    EvaluateItemDataBinder.this.d.onReportPraiseViewClickEvent(z, commentsItemBean, commentsItemBean.getItemIndex());
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1656712397")) {
                ipChange.ipc$dispatch("-1656712397", new Object[]{this, view});
            } else if (view.getTag() == null) {
            } else {
                int id = view.getId();
                if (id != R$id.uikit_damai_avatar && id != R$id.comment_userinfo_view) {
                    if (id == R$id.comment_layout) {
                        if (view.getTag() instanceof al) {
                            EvaluateItemDataBinder.this.p((al) view.getTag());
                        }
                    } else if (id == R$id.comment_detail_maincomment_more) {
                        if (view.getTag() instanceof al) {
                            EvaluateItemDataBinder.this.m((al) view.getTag());
                        }
                    } else if (id == R$id.evaluate_project_info) {
                        if (view.getTag() instanceof al) {
                            EvaluateItemDataBinder.this.h((al) view.getTag());
                        }
                    } else if (id == R$id.comment_detail_comment_delete && (view.getTag() instanceof al) && EvaluateItemDataBinder.this.e != null) {
                        EvaluateItemDataBinder.this.e.deleteComment(((al) view.getTag()).a());
                    }
                } else if (view.getTag() instanceof al) {
                    EvaluateItemDataBinder.this.o((al) view.getTag());
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            al alVar;
            CommentsItemBean a;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "261561582")) {
                ipChange.ipc$dispatch("261561582", new Object[]{this, view});
            } else if (view.getTag() == null || !(view.getTag() instanceof al) || (a = (alVar = (al) view.getTag()).a()) == null || TextUtils.isEmpty(a.getUrl()) || EvaluateItemDataBinder.this.a == null || EvaluateItemDataBinder.this.a.isFinishing()) {
            } else {
                if (alVar.n()) {
                    if (EvaluateItemDataBinder.this.e != null) {
                        EvaluateItemDataBinder.this.e.replyContentClick(true, a);
                        return;
                    }
                    return;
                }
                if (EvaluateItemDataBinder.this.d != null) {
                    EvaluateItemDataBinder.this.d.onReportItemClickEvent(alVar.o(), a, a.getItemIndex());
                }
                SimpleItemClickListener simpleItemClickListener = EvaluateItemDataBinder.this.f;
                if (simpleItemClickListener != null) {
                    simpleItemClickListener.onSingleItemClick();
                }
                Bundle bundle = new Bundle();
                bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, a.getCommentId());
                bundle.putBoolean("isVEvaluate", alVar.o());
                DMNav.from(EvaluateItemDataBinder.this.a).withExtras(bundle).toUri(NavUri.b(cs.X));
            }
        }
    }

    public EvaluateItemDataBinder(Activity activity, String str) {
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = new d();
        this.a = activity;
        this.b = new f();
        this.c = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(al alVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527545162")) {
            ipChange.ipc$dispatch("-527545162", new Object[]{this, alVar});
        } else if (alVar == null || alVar.a() == null) {
        } else {
            EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
            if (evaluateItemUTReportListener != null) {
                evaluateItemUTReportListener.onReportTransferClickEvent(alVar.o(), alVar.a(), alVar.a().getItemIndex());
            }
            if (alVar.a().getItemType() != 0) {
                int n = n(this.i, alVar.a());
                if (n == 1 && alVar.a().getStoreInfo() != null) {
                    String valueOf = alVar.a().getStoreInfo().getStoreId() == null ? "" : String.valueOf(alVar.a().getStoreInfo().getStoreId());
                    cn.damai.common.user.c.e().x(dl.I().J(alVar.a().getCommentId(), null, null, alVar.a().getStoreInfo().getStoreId(), 0));
                    if (valueOf.isEmpty()) {
                        return;
                    }
                    DMNav from = DMNav.from(this.a);
                    from.toUri("damai://V1/ScriptPlay?storeId=" + valueOf);
                } else if (n != 2 || alVar.a().getScriptInfo() == null) {
                } else {
                    cn.damai.common.user.c.e().x(dl.I().J(alVar.a().getCommentId(), null, alVar.a().getScriptInfo().getId(), null, 0));
                    if (TextUtils.isEmpty(alVar.a().getScriptInfo().getActionUrl())) {
                        return;
                    }
                    DMNav.from(this.a).toUri(alVar.a().getScriptInfo().getActionUrl());
                }
            } else if ("1".equals(alVar.a().getTargetDataDO().getTargetDataType())) {
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, alVar.a().getTargetDataDO().getTargetId());
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
            } else if ("2".equals(alVar.a().getTargetDataDO().getTargetDataType())) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(RepertoireDetailFragment.REPERTOIREID, alVar.a().getTargetDataDO().getTargetId());
                DMNav.from(this.a).withExtras(bundle2).toUri(NavUri.b(u12.REPERTOITE));
            }
        }
    }

    private void k(boolean z, EvaluateItemViewHolder evaluateItemViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612768809")) {
            ipChange.ipc$dispatch("-612768809", new Object[]{this, Boolean.valueOf(z), evaluateItemViewHolder});
        } else if (evaluateItemViewHolder == null) {
        } else {
            evaluateItemViewHolder.q.setVisibility(z ? 8 : 0);
            evaluateItemViewHolder.r.setVisibility(z ? 8 : 0);
        }
    }

    private boolean l(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183039224")) {
            return ((Boolean) ipChange.ipc$dispatch("183039224", new Object[]{this, commentsItemBean})).booleanValue();
        }
        if (commentsItemBean == null || TextUtils.isEmpty(commentsItemBean.getIsOwner())) {
            return false;
        }
        return Boolean.parseBoolean(commentsItemBean.getIsOwner());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(al alVar) {
        CommentsItemBean a2;
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922856990")) {
            ipChange.ipc$dispatch("1922856990", new Object[]{this, alVar});
        } else if (alVar == null || (a2 = alVar.a()) == null || a2.getUserDO() == null || (activity = this.a) == null || activity.isFinishing()) {
        } else {
            Activity activity2 = this.a;
            if (activity2 instanceof DamaiBaseActivity) {
                DamaiBaseActivity damaiBaseActivity = (DamaiBaseActivity) activity2;
                EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
                if (evaluateItemUTReportListener != null) {
                    evaluateItemUTReportListener.onReportMoreInfoClickEvent(alVar.o(), a2, a2.getItemIndex());
                }
                if (a2.getItemType() == 1 && a2.getStoreInfo() != null) {
                    CommentItemMoreUtil.j(damaiBaseActivity, "evaluateList", cl.b(a2.getStoreInfo().getStoreId()), a2.getStoreInfo().getStoreImgUrl(), a2.getStoreInfo().getStoreName(), a2.getStoreInfo().getDes(), "", a2, l(a2), R$layout.comment_detail_layout, false);
                } else {
                    CommentItemMoreUtil.j(damaiBaseActivity, "evaluateList", alVar.e(), alVar.f(), alVar.g(), alVar.d(), alVar.h(), a2, l(a2), R$layout.new_evaluate_activity, a2.getItemType() != 2);
                }
            }
        }
    }

    private int n(int i, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165725686")) {
            return ((Integer) ipChange.ipc$dispatch("165725686", new Object[]{this, Integer.valueOf(i), commentsItemBean})).intValue();
        }
        if (i == 0) {
            return commentsItemBean.getItemType();
        }
        if (i != 1 || commentsItemBean.getScriptInfo() == null) {
            return (i != 2 || commentsItemBean.getStoreInfo() == null) ? 0 : 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(al alVar) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-141587125")) {
            ipChange.ipc$dispatch("-141587125", new Object[]{this, alVar});
        } else if (alVar == null) {
        } else {
            if (!LoginManager.k().q()) {
                LoginManager.k().v(this.a);
                return;
            }
            CommentsItemBean a2 = alVar.a();
            if (a2 == null || TextUtils.isEmpty(a2.getUrl()) || (activity = this.a) == null || activity.isFinishing()) {
                return;
            }
            if (alVar.n()) {
                EvaluateItemOtherListener evaluateItemOtherListener = this.e;
                if (evaluateItemOtherListener != null) {
                    evaluateItemOtherListener.replyContentClick(false, a2);
                    return;
                }
                return;
            }
            EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
            if (evaluateItemUTReportListener != null) {
                evaluateItemUTReportListener.onReportReplyClickEvent(alVar.o(), a2, a2.getItemIndex());
            }
            Bundle bundle = new Bundle();
            bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, a2.getCommentId());
            bundle.putBoolean("isShowSoftInput", true);
            bundle.putBoolean("isVEvaluate", alVar.o());
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.X));
        }
    }

    private void t(NineGridlayout nineGridlayout, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226912380")) {
            ipChange.ipc$dispatch("-1226912380", new Object[]{this, nineGridlayout, commentsItemBean});
        } else if (commentsItemBean == null) {
            nineGridlayout.setVisibility(8);
        } else {
            b bVar = new b(commentsItemBean);
            NineImgUtil.a().b(this.a, (((int) yr2.d(this.a)) - m62.a(this.a, 42.0f)) - ((int) this.a.getResources().getDimension(R$dimen.evaluate_item_margin_left)), true, nineGridlayout, commentsItemBean, commentsItemBean.getImageDOList(), bVar);
        }
    }

    private void v(CommentsItemBean commentsItemBean, RelativeLayout relativeLayout, TextView textView) {
        CommentUserDoBean userDO;
        String str;
        CommentTextDoBean commentTextDoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-432774032")) {
            ipChange.ipc$dispatch("-432774032", new Object[]{this, commentsItemBean, relativeLayout, textView});
            return;
        }
        List<CommentsItemBean> appendComments = commentsItemBean.getAppendComments();
        if (appendComments != null && appendComments.size() > 0) {
            CommentsItemBean commentsItemBean2 = appendComments.get(0);
            if (commentsItemBean2 == null) {
                pf0.g().m(relativeLayout);
                return;
            }
            if (TextUtils.isEmpty(commentsItemBean2.getUserDO().getNickname())) {
                str = "";
            } else {
                str = "回复@" + userDO.getNickname();
            }
            List<CommentTextDoBean> textDOList = commentsItemBean2.getTextDOList();
            if (textDOList != null && textDOList.size() > 0 && (commentTextDoBean = textDOList.get(0)) != null && !TextUtils.isEmpty(commentTextDoBean.getValue())) {
                SpannableString spannableString = new SpannableString(str + commentTextDoBean.getValue());
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#30AEFF")), 0, str.length(), 33);
                textView.setText(spannableString);
            }
            relativeLayout.setOnClickListener(new c(textView, commentsItemBean2));
            return;
        }
        textView.setText("该内容已被删除");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:11|(5:13|(1:15)(1:186)|16|(1:18)(1:185)|19)(2:187|(1:189))|20|(3:24|(3:27|(1:181)(33:31|32|(28:34|35|(1:37)(1:178)|38|(1:40)(1:177)|41|(1:43)(1:176)|44|(1:175)(2:48|(1:174)(3:52|(1:54)(1:173)|55))|56|(3:58|(1:60)(1:168)|61)(2:169|(1:171)(1:172))|62|63|64|(1:66)(1:164)|67|(1:163)(1:77)|78|(5:80|(1:(1:129)(1:128))(1:84)|85|(1:124)(1:89)|90)(2:130|(3:159|(1:161)|162)(3:134|(2:154|(1:158))(6:138|(1:140)|141|(3:143|(1:145)|146)|147|(3:149|(1:151)|152))|153))|(1:92)(1:123)|93|(1:95)(1:122)|96|(3:98|(1:100)(1:102)|101)|103|(3:105|(1:107)(1:109)|108)|110|(2:112|(2:114|115)(1:116))(2:117|(2:119|120)(1:121)))|179|35|(0)(0)|38|(0)(0)|41|(0)(0)|44|(1:46)|175|56|(0)(0)|62|63|64|(0)(0)|67|(3:69|71|73)|163|78|(0)(0)|(0)(0)|93|(0)(0)|96|(0)|103|(0)|110|(0)(0))|25)|183)|184|179|35|(0)(0)|38|(0)(0)|41|(0)(0)|44|(0)|175|56|(0)(0)|62|63|64|(0)(0)|67|(0)|163|78|(0)(0)|(0)(0)|93|(0)(0)|96|(0)|103|(0)|110|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02d4, code lost:
        r0.printStackTrace();
        r0 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0312  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(final cn.damai.evaluate.ui.item.EvaluateItemViewHolder r19, tb.al r20, int r21) {
        /*
            Method dump skipped, instructions count: 1358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.evaluate.ui.item.EvaluateItemDataBinder.i(cn.damai.evaluate.ui.item.EvaluateItemViewHolder, tb.al, int):void");
    }

    public void j(EvaluateItemViewHolder evaluateItemViewHolder, al alVar, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305690321")) {
            ipChange.ipc$dispatch("305690321", new Object[]{this, evaluateItemViewHolder, alVar, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (i == 0) {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_first_bg);
            evaluateItemViewHolder.x.setVisibility(0);
        } else if (i == i2 - 1) {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_last_bg);
            evaluateItemViewHolder.x.setVisibility(4);
        } else {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_bg);
            evaluateItemViewHolder.x.setVisibility(0);
        }
        if (i == 0 && i2 == 1) {
            evaluateItemViewHolder.n.setBackgroundResource(R$drawable.comment_only_bg);
            evaluateItemViewHolder.x.setVisibility(4);
        }
        i(evaluateItemViewHolder, alVar, i);
    }

    public void o(al alVar) {
        CommentsItemBean a2;
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106028855")) {
            ipChange.ipc$dispatch("-2106028855", new Object[]{this, alVar});
        } else if (alVar == null || (a2 = alVar.a()) == null || a2.getUserDO() == null || (activity = this.a) == null || activity.isFinishing()) {
        } else {
            EvaluateItemUTReportListener evaluateItemUTReportListener = this.d;
            if (evaluateItemUTReportListener != null) {
                evaluateItemUTReportListener.onReportUserInfoClickEvent(alVar.o(), a2, a2.getItemIndex());
            }
            SoftInputUtils.a(this.a);
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, a2.getUserDO().getDamaiUserId());
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    public void q(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35721860")) {
            ipChange.ipc$dispatch("-35721860", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.h = i;
        }
    }

    public void r(EvaluateItemUTReportListener evaluateItemUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806089517")) {
            ipChange.ipc$dispatch("-1806089517", new Object[]{this, evaluateItemUTReportListener});
        } else {
            this.d = evaluateItemUTReportListener;
        }
    }

    public void s(EvaluateItemOtherListener evaluateItemOtherListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292858300")) {
            ipChange.ipc$dispatch("292858300", new Object[]{this, evaluateItemOtherListener});
        } else {
            this.e = evaluateItemOtherListener;
        }
    }

    public void u(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331119002")) {
            ipChange.ipc$dispatch("-1331119002", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.g = z;
        }
    }

    public EvaluateItemDataBinder(Activity activity, String str, int i) {
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = new d();
        this.a = activity;
        this.i = i;
        this.b = new f();
        this.c = new e();
    }

    public EvaluateItemDataBinder(Activity activity) {
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = new d();
        this.a = activity;
        this.b = new f();
        this.c = new e();
    }

    public EvaluateItemDataBinder(Activity activity, int i) {
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = new d();
        this.a = activity;
        this.i = i;
        this.b = new f();
        this.c = new e();
    }
}
