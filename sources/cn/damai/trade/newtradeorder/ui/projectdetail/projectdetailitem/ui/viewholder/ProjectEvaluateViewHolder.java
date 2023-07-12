package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.View;
import cn.damai.comment.bean.CommentSyncCircleBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.al;
import tb.pp2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectEvaluateViewHolder extends EvaluateItemViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context B;
    private long C;
    private String D;
    private String E;
    private EvaluateItemDataBinder F;
    private al G;
    private CommentsItemBean H;
    private int I;
    private EvaluateItemDataBinder.EvaluateItemUTReportListener J;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements EvaluateItemDataBinder.EvaluateItemUTReportListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2037967769")) {
                ipChange.ipc$dispatch("2037967769", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(pp2.u().u0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1044528682")) {
                ipChange.ipc$dispatch("-1044528682", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(pp2.u().p0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1021160506")) {
                ipChange.ipc$dispatch("-1021160506", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(pp2.u().t0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "266220200")) {
                ipChange.ipc$dispatch("266220200", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(pp2.u().r0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-109511735")) {
                ipChange.ipc$dispatch("-109511735", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(pp2.u().v0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            List<CommentSyncCircleBean> syncCircle;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-333043106")) {
                ipChange.ipc$dispatch("-333043106", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H == null || (syncCircle = ProjectEvaluateViewHolder.this.H.getSyncCircle()) == null || syncCircle.isEmpty()) {
            } else {
                c.e().x(pp2.u().o0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), syncCircle.get(0).getCircleId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "831949950")) {
                ipChange.ipc$dispatch("831949950", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(pp2.u().q0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }

        @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
        public void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2033163888")) {
                ipChange.ipc$dispatch("-2033163888", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            } else if (ProjectEvaluateViewHolder.this.H != null) {
                c.e().x(pp2.u().w0(z20.E(), ProjectEvaluateViewHolder.this.C, ProjectEvaluateViewHolder.this.H.getCommentId(), ProjectEvaluateViewHolder.this.e(), ProjectEvaluateViewHolder.this.H.getCommentType(), ProjectEvaluateViewHolder.this.I));
            }
        }
    }

    public ProjectEvaluateViewHolder(Context context, long j, String str, String str2) {
        super((DamaiBaseActivity) context);
        this.B = context;
        this.C = j;
        this.D = str;
        this.E = str2;
        h();
        g();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025736813")) {
            return (String) ipChange.ipc$dispatch("-2025736813", new Object[]{this});
        }
        CommentUserDoBean userDO = this.H.getUserDO();
        return userDO != null ? userDO.getDamaiUserId() : "";
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777157074")) {
            ipChange.ipc$dispatch("1777157074", new Object[]{this});
        } else {
            this.J = new a();
        }
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101134422")) {
            ipChange.ipc$dispatch("1101134422", new Object[]{this});
            return;
        }
        this.F = new EvaluateItemDataBinder((DamaiBaseActivity) this.B, String.valueOf(this.C));
        al alVar = new al(0);
        this.G = alVar;
        alVar.v(this.C);
        this.G.x(this.D);
        this.G.w(this.E);
        this.itemView.setBackgroundColor(-1);
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123468515")) {
            ipChange.ipc$dispatch("2123468515", new Object[]{this});
        } else {
            this.F.r(this.J);
        }
    }

    public void f(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588620965")) {
            ipChange.ipc$dispatch("-588620965", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.I = projectDataHolder.getCommentPosition();
            CommentsItemBean moduleComment = projectDataHolder.getModuleComment();
            this.H = moduleComment;
            if (moduleComment != null) {
                this.G.q(moduleComment);
                this.G.p(false);
                this.F.i(this, this.G, this.I);
                pp2 u = pp2.u();
                View view = this.itemView;
                u.H1(view, this.C + "", this.H.getCommentId(), this.I);
            }
        }
    }
}
