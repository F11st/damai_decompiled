package cn.damai.evaluate.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.CommentContentLabelBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.view.TopScoreDivideView;
import cn.damai.common.nav.DMNav;
import cn.damai.evaluate.ui.EvaluateListCallBack;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.view.DMRatingBar;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.jm1;
import tb.l62;
import tb.q60;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMEvaluateListHeadView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMEvaluateGradeBlockView blockView;
    private EvaluateListCallBack callBack;
    private View commentUrl;
    private List<CommentContentLabelBean> contentLabelInfo;
    private int gap;
    private FlowLayout labelList;
    private View leftTitleView;
    private TopScoreDivideView leftTitleViewDiv;
    private Context mContext;
    private DMRatingBar scoreStarView;
    private String selectLabel;
    private String selectLabelId;
    private String selectLabelType;
    private int singleW;
    private TextView titleDesc;
    private TextView titleNum;
    private TextView titleScore;
    private View titleView;
    private View titleViewDiv;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.evaluate.view.DMEvaluateListHeadView$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1099a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsResultBean a;

        View$OnClickListenerC1099a(CommentsResultBean commentsResultBean) {
            this.a = commentsResultBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-272400753")) {
                ipChange.ipc$dispatch("-272400753", new Object[]{this, view});
            } else {
                DMNav.from(DMEvaluateListHeadView.this.getContext()).toUri(this.a.getDamaiCommentInfoUrl());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.evaluate.view.DMEvaluateListHeadView$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1100b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentContentLabelBean a;

        View$OnClickListenerC1100b(CommentContentLabelBean commentContentLabelBean) {
            this.a = commentContentLabelBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1838889616")) {
                ipChange.ipc$dispatch("1838889616", new Object[]{this, view});
            } else if (DMEvaluateListHeadView.this.callBack == null || this.a == null) {
            } else {
                DMEvaluateListHeadView.this.callBack.labelClick(this.a);
            }
        }
    }

    public DMEvaluateListHeadView(Context context) {
        super(context);
        this.gap = 9;
        this.mContext = context;
        setOrientation(1);
        initView();
        this.singleW = (DisplayMetrics.getwidthPixels(l62.c((Activity) context)) - t60.a(context, (this.gap * 2) + 42)) / 3;
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135344412")) {
            ipChange.ipc$dispatch("2135344412", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.evaluate_list_head_layout, this);
        this.blockView = (DMEvaluateGradeBlockView) inflate.findViewById(R$id.evaluate_grade_block);
        this.labelList = (FlowLayout) inflate.findViewById(R$id.evaluate_label_list);
        this.titleNum = (TextView) inflate.findViewById(R$id.tv_rating_num_desc);
        this.titleScore = (TextView) inflate.findViewById(R$id.tv_score);
        this.titleDesc = (TextView) inflate.findViewById(R$id.tv_socre_desc);
        this.scoreStarView = (DMRatingBar) inflate.findViewById(R$id.scoreStar_view);
        this.commentUrl = inflate.findViewById(R$id.tv_score_icon_tip);
        this.leftTitleView = inflate.findViewById(R$id.top_score_layout_left);
        this.leftTitleViewDiv = (TopScoreDivideView) inflate.findViewById(R$id.top_score_layout_div);
        this.titleView = inflate.findViewById(R$id.top_score_layout);
        this.titleViewDiv = inflate.findViewById(R$id.top_score_layoutdiv);
    }

    private View newTextView(CommentContentLabelBean commentContentLabelBean, EvaluateListCallBack evaluateListCallBack, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340222059")) {
            return (View) ipChange.ipc$dispatch("-1340222059", new Object[]{this, commentContentLabelBean, evaluateListCallBack, Boolean.valueOf(z)});
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.evaluate_label_item, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.label_item);
        String labelName = commentContentLabelBean.getLabelName();
        if (!TextUtils.isEmpty(labelName) && labelName.length() > 5) {
            labelName = labelName.substring(0, 5);
        }
        String str = " " + commentContentLabelBean.getCount();
        if (commentContentLabelBean.getCount() == 0) {
            str = "";
        } else if (commentContentLabelBean.getCount() >= 1000) {
            str = " 999+";
        }
        textView.setText(labelName + str);
        textView.setTag(commentContentLabelBean);
        setStyle(textView, commentContentLabelBean.isStatusChoose(), commentContentLabelBean.getLabelType());
        if ("99".equals(commentContentLabelBean.getLabelType())) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = this.singleW;
            if (!z) {
                layoutParams.setMargins(0, t60.a(getContext(), this.gap - 1), t60.a(getContext(), this.gap - 1), 0);
            } else {
                layoutParams.setMargins(0, t60.a(getContext(), this.gap - 1), 0, 0);
            }
            textView.setLayoutParams(layoutParams);
        }
        inflate.setOnClickListener(new View$OnClickListenerC1100b(commentContentLabelBean));
        return inflate;
    }

    public List<CommentContentLabelBean> getContentLabelInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "533097421") ? (List) ipChange.ipc$dispatch("533097421", new Object[]{this}) : this.contentLabelInfo;
    }

    public FlowLayout getLabelList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2051766327") ? (FlowLayout) ipChange.ipc$dispatch("-2051766327", new Object[]{this}) : this.labelList;
    }

    public void setCallBack(EvaluateListCallBack evaluateListCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1288658317")) {
            ipChange.ipc$dispatch("-1288658317", new Object[]{this, evaluateListCallBack});
        } else {
            this.callBack = evaluateListCallBack;
        }
    }

    public void setContentLabelInfo(List<CommentContentLabelBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134590879")) {
            ipChange.ipc$dispatch("1134590879", new Object[]{this, list});
        } else {
            this.contentLabelInfo = list;
        }
    }

    public void setData(CommentsResultBean commentsResultBean, int i, RelativeLayout relativeLayout, FlowLayout flowLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1782415316")) {
            ipChange.ipc$dispatch("-1782415316", new Object[]{this, commentsResultBean, Integer.valueOf(i), relativeLayout, flowLayout});
        } else if (commentsResultBean == null) {
            setVisibility(8);
        } else {
            if (commentsResultBean.getStatScoreInfo() != null && commentsResultBean.getStatScoreInfo().size() != 0 && !TextUtils.isEmpty(commentsResultBean.getItemScore())) {
                this.titleView.setVisibility(0);
                this.titleViewDiv.setVisibility(0);
            } else {
                this.titleView.setVisibility(8);
                this.titleViewDiv.setVisibility(8);
            }
            setVisibility(0);
            if (!TextUtils.isEmpty(commentsResultBean.getDamaiCommentInfoUrl())) {
                this.commentUrl.setOnClickListener(new View$OnClickListenerC1099a(commentsResultBean));
            }
            if (TextUtils.isEmpty(commentsResultBean.getItemScore())) {
                this.leftTitleViewDiv.setVisibility(8);
                this.leftTitleView.setVisibility(8);
            } else {
                this.leftTitleViewDiv.setVisibility(0);
                this.leftTitleView.setVisibility(0);
                this.titleScore.setText(commentsResultBean.getItemScore());
                TextView textView = this.titleNum;
                textView.setText(jm1.g(commentsResultBean.getTotal()) + "条");
                this.titleDesc.setText(commentsResultBean.getItemScoreDesc());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.scoreStarView.getLayoutParams();
                if (i == 2) {
                    this.scoreStarView.setStarSize(q60.a(getContext(), 12.0f));
                    this.scoreStarView.setStarDistance(q60.a(getContext(), 1.5f));
                    this.scoreStarView.setMarkDrawable(R$drawable.rating_fill_type_2, R$drawable.rating_empty_type_2);
                    layoutParams.rightMargin = q60.a(getContext(), 3.0f);
                } else {
                    this.scoreStarView.setStarDistance(q60.a(getContext(), 1.0f));
                    this.scoreStarView.setStarSize(q60.a(getContext(), 8.0f));
                    this.scoreStarView.setMarkDrawable(R$drawable.rating_fill, R$drawable.rating_empty);
                    layoutParams.rightMargin = q60.a(getContext(), 6.0f);
                }
                this.scoreStarView.setLayoutParams(layoutParams);
                this.scoreStarView.setStarMark(commentsResultBean.getItemStar() / 2.0f);
            }
            this.blockView.setVisibility(0);
            this.blockView.setData(commentsResultBean.getStatScoreInfo());
        }
    }

    public void setHeaderLabel(CommentsResultBean commentsResultBean, RelativeLayout relativeLayout, FlowLayout flowLayout) {
        String str;
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542750622")) {
            ipChange.ipc$dispatch("-542750622", new Object[]{this, commentsResultBean, relativeLayout, flowLayout});
            return;
        }
        int e = commentsResultBean == null ? 0 : wh2.e(commentsResultBean.getContentLabelInfo());
        if (e > 0) {
            int i = 0;
            while (true) {
                if (i >= e) {
                    i = -1;
                    break;
                }
                CommentContentLabelBean commentContentLabelBean = commentsResultBean.getContentLabelInfo().get(i);
                if (commentContentLabelBean != null && (str = this.selectLabelType) != null && str.equals(commentContentLabelBean.getLabelType()) && (((str2 = this.selectLabelId) != null && str2.equals(commentContentLabelBean.getLabelId())) || (!this.selectLabelType.equals("99") && (str3 = this.selectLabel) != null && str3.equals(commentContentLabelBean.getLabelName())))) {
                    break;
                }
                i++;
            }
            CommentContentLabelBean commentContentLabelBean2 = commentsResultBean.getContentLabelInfo().get(i != -1 ? i : 0);
            commentContentLabelBean2.setStatus("1");
            commentContentLabelBean2.setPos(0);
            this.callBack.setChooseLabel(commentContentLabelBean2);
            setContentLabelInfo(commentsResultBean.getContentLabelInfo());
            this.labelList.setVisibility(0);
            this.labelList.removeAllViews();
            flowLayout.removeAllViews();
            int i2 = 0;
            for (int i3 = 0; i3 < e; i3++) {
                CommentContentLabelBean commentContentLabelBean3 = commentsResultBean.getContentLabelInfo().get(i3);
                if (commentContentLabelBean3 != null) {
                    commentContentLabelBean3.setPos(i3);
                    if ("99".equals(commentContentLabelBean3.getLabelType())) {
                        i2++;
                    }
                    int i4 = i2 % 3;
                    this.labelList.addView((ViewGroup) newTextView(commentContentLabelBean3, this.callBack, i4 == 0));
                    flowLayout.addView((ViewGroup) newTextView(commentContentLabelBean3, this.callBack, i4 == 0));
                }
            }
            if (i == -1) {
                if (this.selectLabelType == null && this.selectLabelId == null) {
                    return;
                }
                this.callBack.resetLabel(commentsResultBean.getContentLabelInfo().get(0));
                return;
            }
            return;
        }
        this.labelList.setVisibility(8);
        relativeLayout.setVisibility(8);
    }

    public void setInitSelectLabel(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964694153")) {
            ipChange.ipc$dispatch("964694153", new Object[]{this, str, str2, str3});
            return;
        }
        this.selectLabel = str;
        this.selectLabelType = str2;
        this.selectLabelId = str3;
    }

    public void setStyle(TextView textView, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631904978")) {
            ipChange.ipc$dispatch("631904978", new Object[]{this, textView, Boolean.valueOf(z)});
        } else if (z) {
            textView.setBackgroundResource(R$drawable.evaluate_label_press);
            textView.setTextColor(Color.parseColor("#000000"));
        } else {
            textView.setBackgroundResource(R$drawable.evaluate_label_unpress);
            textView.setTextColor(Color.parseColor("#666666"));
        }
    }

    public void setStyle(TextView textView, boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436611612")) {
            ipChange.ipc$dispatch("1436611612", new Object[]{this, textView, Boolean.valueOf(z), str});
        } else if (z) {
            textView.setBackgroundResource(R$drawable.evaluate_label_press_pink);
            textView.setTextColor(Color.parseColor("#ff2d79"));
        } else if ("99".equals(str)) {
            textView.setBackgroundResource(R$drawable.evaluate_label_unpress_white);
            textView.setTextColor(Color.parseColor("#666666"));
        } else {
            textView.setBackgroundResource(R$drawable.evaluate_label_unpress);
            textView.setTextColor(Color.parseColor("#666666"));
        }
    }
}
