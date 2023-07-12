package cn.damai.evaluate.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentProjectInfoBean;
import cn.damai.comment.bean.CommentRepertoireInfoBean;
import cn.damai.comment.bean.CommentTextDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.comment.util.NineImgUtil;
import cn.damai.comment.view.DMTagView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cs;
import tb.dl;
import tb.os;
import tb.pl;
import tb.q60;
import tb.u12;
import tb.wh2;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMEvaluateDetailHeadView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView content;
    private DMTagView dmTagView;
    private NineGridlayout gridlayout;
    private ImageView ivLuxury;
    private Context mContext;
    private os mScriptUi;
    private os mStoreUi;
    private FlowLayout mTagLayout;
    private TextView paddindView;
    private View playedIcon;
    private DMEvaluateProjectCardView projectCardView;
    private DMRatingBar ratingBar;
    private ImageView spoilers;
    private TextView tvScore;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;

        a(CommentsItemBean commentsItemBean) {
            this.a = commentsItemBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1079328446")) {
                ipChange.ipc$dispatch("-1079328446", new Object[]{this, view});
                return;
            }
            DMEvaluateDetailHeadView dMEvaluateDetailHeadView = DMEvaluateDetailHeadView.this;
            CommentsItemBean commentsItemBean = this.a;
            dMEvaluateDetailHeadView.gotoTarget(commentsItemBean, "3", this.a.getStoreInfo().getStoreId() + "");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;
        final /* synthetic */ ScriptBean b;

        b(CommentsItemBean commentsItemBean, ScriptBean scriptBean) {
            this.a = commentsItemBean;
            this.b = scriptBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1031961923")) {
                ipChange.ipc$dispatch("1031961923", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(dl.I().J(this.a.getCommentId(), this.a.getUserDO().getDamaiUserId(), this.a.getScriptInfo().getId(), null, 1));
            DMEvaluateDetailHeadView.this.openScriptActivity(this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;
        final /* synthetic */ CommentProjectInfoBean b;

        c(CommentsItemBean commentsItemBean, CommentProjectInfoBean commentProjectInfoBean) {
            this.a = commentsItemBean;
            this.b = commentProjectInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1151715004")) {
                ipChange.ipc$dispatch("-1151715004", new Object[]{this, view});
            } else {
                DMEvaluateDetailHeadView.this.gotoTarget(this.a, "1", this.b.getProjectId());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;
        final /* synthetic */ CommentRepertoireInfoBean b;

        d(CommentsItemBean commentsItemBean, CommentRepertoireInfoBean commentRepertoireInfoBean) {
            this.a = commentsItemBean;
            this.b = commentRepertoireInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "959575365")) {
                ipChange.ipc$dispatch("959575365", new Object[]{this, view});
            } else {
                DMEvaluateDetailHeadView.this.gotoTarget(this.a, "2", this.b.getRepertoireId());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class e implements NineImgUtil.OnClickExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;
        final /* synthetic */ String b;

        e(DMEvaluateDetailHeadView dMEvaluateDetailHeadView, CommentsItemBean commentsItemBean, String str) {
            this.a = commentsItemBean;
            this.b = str;
        }

        @Override // cn.damai.comment.util.NineImgUtil.OnClickExtraListener
        public void onExtraLister(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1853101738")) {
                ipChange.ipc$dispatch("1853101738", new Object[]{this, Integer.valueOf(i)});
            } else {
                cn.damai.common.user.c.e().x(dl.I().o(this.a.getCommentId(), this.a.getUserDO().getDamaiUserId(), i, this.b, this.a.getScriptInfo() != null ? this.a.getScriptInfo().getId() : ""));
            }
        }
    }

    public DMEvaluateDetailHeadView(Context context) {
        super(context);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoTarget(CommentsItemBean commentsItemBean, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "762437736")) {
            ipChange.ipc$dispatch("762437736", new Object[]{this, commentsItemBean, str, str2});
        } else if ("1".equals(str)) {
            cn.damai.common.user.c.e().x(dl.I().u(str2, null, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), null));
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, str2);
            DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
        } else if ("2".equals(str)) {
            cn.damai.common.user.c.e().x(dl.I().u(null, str2, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), null));
            Bundle bundle2 = new Bundle();
            bundle2.putString(RepertoireDetailFragment.REPERTOIREID, str2);
            DMNav.from(this.mContext).withExtras(bundle2).toUri(NavUri.b(u12.REPERTOITE));
        } else if ("3".equals(str)) {
            cn.damai.common.user.c.e().x(dl.I().J(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), null, commentsItemBean.getStoreInfo().getStoreId(), 1));
            Bundle bundle3 = new Bundle();
            bundle3.putString("storeId", str2);
            DMNav.from(this.mContext).withExtras(bundle3).toUri(NavUri.b(cs.SCRIPT_SHOP_DETAIL));
        } else if ("4".equals(str)) {
            DMNav.from(this.mContext).withExtras(new Bundle()).toUri(commentsItemBean.getScriptInfo().getActionUrl());
        }
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673091436")) {
            ipChange.ipc$dispatch("-1673091436", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947852977")) {
            ipChange.ipc$dispatch("-1947852977", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.evaluate_detail_head_layout, this);
        this.ratingBar = (DMRatingBar) inflate.findViewById(R$id.evaluate_grade_view);
        this.tvScore = (TextView) inflate.findViewById(R$id.comment_score);
        this.ivLuxury = (ImageView) inflate.findViewById(R$id.iv_comment_luxury);
        this.content = (TextView) inflate.findViewById(R$id.comment_content);
        this.gridlayout = (NineGridlayout) inflate.findViewById(R$id.nine_image_layout);
        this.projectCardView = (DMEvaluateProjectCardView) inflate.findViewById(R$id.evaluate_project_info);
        FlowLayout flowLayout = (FlowLayout) inflate.findViewById(R$id.user_tag_layout);
        this.mTagLayout = flowLayout;
        flowLayout.setOrientation(0);
        this.dmTagView = (DMTagView) inflate.findViewById(R$id.evaluate_head_dm_info_tag_view);
        this.paddindView = (TextView) inflate.findViewById(R$id.evaluate_detail_sep);
        this.spoilers = (ImageView) inflate.findViewById(R$id.has_spoilers);
        this.playedIcon = inflate.findViewById(R$id.comment_has_played_icon);
        View findViewById = inflate.findViewById(R$id.evaluate_script_info_v1);
        this.mStoreUi = new os(inflate.findViewById(R$id.evaluate_store_info_v1));
        this.mScriptUi = new os(findViewById);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openScriptActivity(ScriptBean scriptBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723378153")) {
            ipChange.ipc$dispatch("1723378153", new Object[]{this, scriptBean});
            return;
        }
        String id = scriptBean.getId();
        if (TextUtils.isEmpty(id)) {
            return;
        }
        DMNav from = DMNav.from(this.mContext);
        from.toUri("damai://V1/ScriptDetail?scriptId=" + id);
    }

    private void setNineImgs(CommentsItemBean commentsItemBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405752528")) {
            ipChange.ipc$dispatch("1405752528", new Object[]{this, commentsItemBean, str});
            return;
        }
        List<CommentImageInfoBean> imageDOList = commentsItemBean.getImageDOList();
        this.gridlayout.setVisibility(0);
        NineImgUtil.a().b(this.mContext, ((int) yr2.d(this.mContext)) - (yr2.a(this.mContext, 21.0f) * 2), false, this.gridlayout, commentsItemBean, imageDOList, new e(this, commentsItemBean, str));
    }

    private void setRatingBarData(CommentsItemBean commentsItemBean) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-219485206")) {
            ipChange.ipc$dispatch("-219485206", new Object[]{this, commentsItemBean});
            return;
        }
        String str = "";
        this.mTagLayout.removeAllViews();
        if (wh2.e(commentsItemBean.getGradeDOList()) > 0) {
            f = -1.0f;
            for (int i = 0; i < commentsItemBean.getGradeDOList().size(); i++) {
                CommentGradeBean commentGradeBean = commentsItemBean.getGradeDOList().get(i);
                if (commentGradeBean != null) {
                    if (commentGradeBean.type == 1) {
                        str = commentGradeBean.valueDesc;
                        if (!TextUtils.isEmpty(commentGradeBean.value)) {
                            try {
                                f = Float.valueOf(commentGradeBean.value).floatValue() / 2.0f;
                            } catch (Exception unused) {
                            }
                        }
                    } else if (!TextUtils.isEmpty(commentGradeBean.desc) && !TextUtils.isEmpty(commentGradeBean.value)) {
                        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.evaluate_detail_header_tag_item, (ViewGroup) null, false);
                        ((TextView) inflate.findViewById(R$id.tv_tag)).setText(commentGradeBean.desc + ": " + commentGradeBean.value);
                        this.mTagLayout.addView(inflate);
                    }
                }
            }
        } else {
            f = -1.0f;
        }
        if (TextUtils.isEmpty(str)) {
            this.tvScore.setVisibility(8);
        } else {
            this.tvScore.setText(str);
            this.tvScore.setVisibility(0);
            if (f > 3.0f) {
                this.tvScore.setTextColor(Color.parseColor("#FF8F3F"));
            } else {
                this.tvScore.setTextColor(Color.parseColor("#9C9CA5"));
            }
        }
        if (commentsItemBean.getItemType() == 1) {
            this.ratingBar.setStarSize(q60.a(getContext(), 12.0f));
            this.ratingBar.setStarDistance(q60.a(getContext(), 1.5f));
            this.ratingBar.setMarkDrawable(R$drawable.rating_fill_type_2, R$drawable.rating_empty_type_2);
        } else {
            this.ratingBar.setStarDistance(q60.a(getContext(), 1.0f));
            this.ratingBar.setStarSize(q60.a(getContext(), 8.0f));
            this.ratingBar.setMarkDrawable(R$drawable.rating_fill, R$drawable.rating_empty);
        }
        if (f == -1.0f) {
            this.ratingBar.setVisibility(8);
        } else {
            this.ratingBar.setStarMark(f);
            this.ratingBar.setVisibility(0);
        }
        if (this.mTagLayout.getChildCount() > 0) {
            this.mTagLayout.setVisibility(0);
        } else {
            this.mTagLayout.setVisibility(8);
        }
    }

    public void setData(CommentsItemBean commentsItemBean, CommentProjectInfoBean commentProjectInfoBean, CommentRepertoireInfoBean commentRepertoireInfoBean) {
        CommentTextDoBean commentTextDoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "817666528")) {
            ipChange.ipc$dispatch("817666528", new Object[]{this, commentsItemBean, commentProjectInfoBean, commentRepertoireInfoBean});
        } else if (commentsItemBean == null) {
            setVisibility(8);
        } else {
            if (commentsItemBean.isHideInteraction()) {
                this.paddindView.setVisibility(8);
            } else {
                this.paddindView.setVisibility(0);
            }
            setVisibility(0);
            setRatingBarData(commentsItemBean);
            List<CommentTextDoBean> textDOList = commentsItemBean.getTextDOList();
            if (textDOList != null && textDOList.size() > 0 && (commentTextDoBean = textDOList.get(0)) != null && !TextUtils.isEmpty(commentTextDoBean.getValue())) {
                this.content.setText(commentTextDoBean.getValue());
            }
            setNineImgs(commentsItemBean, commentProjectInfoBean != null ? commentProjectInfoBean.getProjectId() : "");
            int itemType = commentsItemBean.getItemType();
            this.projectCardView.setVisibility(8);
            this.mStoreUi.b();
            this.mScriptUi.b();
            if (itemType == 1 || itemType == 2) {
                StoreInfo storeInfo = commentsItemBean.getStoreInfo();
                ScriptBean scriptInfo = commentsItemBean.getScriptInfo();
                if (storeInfo != null) {
                    StringBuilder sb = new StringBuilder();
                    String storeImgUrl = commentsItemBean.getStoreInfo().getStoreImgUrl();
                    String storeName = commentsItemBean.getStoreInfo().getStoreName();
                    sb.append(commentsItemBean.getStoreInfo().getDes());
                    this.mStoreUi.a(storeImgUrl, storeName, sb.toString(), true, storeInfo.getStoreId());
                    this.mStoreUi.c(new a(commentsItemBean));
                }
                if (scriptInfo != null) {
                    this.mScriptUi.a(scriptInfo.getPosterUrl(), scriptInfo.getName(), scriptInfo.getDes(), false, scriptInfo.getId());
                    this.mScriptUi.c(new b(commentsItemBean, scriptInfo));
                }
            } else if (commentProjectInfoBean != null) {
                this.projectCardView.setVisibility(0);
                String projectPoster = commentProjectInfoBean.getProjectPoster();
                String projectName = commentProjectInfoBean.getProjectName();
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(commentProjectInfoBean.getCityName())) {
                    sb2.append(commentProjectInfoBean.getCityName());
                }
                if (!TextUtils.isEmpty(commentProjectInfoBean.getShowTime())) {
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append(" | ");
                    }
                    sb2.append(commentProjectInfoBean.getShowTime());
                }
                if (!TextUtils.isEmpty(commentProjectInfoBean.getVenueName())) {
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append(" | ");
                    }
                    sb2.append(commentProjectInfoBean.getVenueName());
                }
                this.projectCardView.setData(projectPoster, projectName, sb2.toString(), 0);
                this.projectCardView.setOnClickListener(new c(commentsItemBean, commentProjectInfoBean));
            } else if (commentRepertoireInfoBean != null) {
                this.projectCardView.setVisibility(0);
                this.projectCardView.setData(commentRepertoireInfoBean.getRepertoirePic(), commentRepertoireInfoBean.getRepertoireName(), commentRepertoireInfoBean.getArtsDesc());
                this.projectCardView.setOnClickListener(new d(commentsItemBean, commentRepertoireInfoBean));
            }
            if (commentsItemBean.isFeature()) {
                this.ivLuxury.setVisibility(0);
            } else {
                this.ivLuxury.setVisibility(8);
            }
            if (commentsItemBean.isSpoilerType()) {
                this.spoilers.setVisibility(0);
            } else {
                this.spoilers.setVisibility(8);
            }
            DmInfo dmInfo = commentsItemBean.getDmInfo();
            if (dmInfo != null) {
                this.dmTagView.setVisibility(0);
                this.dmTagView.setDmBaseData(dmInfo.dmHeadImageUrl, dmInfo.dmName);
                this.dmTagView.setDmTagData(dmInfo.dmTags);
            } else {
                this.dmTagView.setVisibility(8);
            }
            this.playedIcon.setVisibility(commentsItemBean.hasPlayed ? 0 : 8);
        }
    }

    @RequiresApi(api = 11)
    public DMEvaluateDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        init(context);
    }

    @RequiresApi(api = 21)
    public DMEvaluateDetailHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        init(context);
    }
}
