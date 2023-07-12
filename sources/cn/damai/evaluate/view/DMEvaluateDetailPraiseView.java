package cn.damai.evaluate.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.uikit.view.PraiseAnimateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.cl;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMEvaluateDetailPraiseView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    String DEFAULT_PRAISE_NUMBER;
    private Context mContext;
    private PraiseAnimateView praiseAnimateView;
    private TextView praiseNum;

    public DMEvaluateDetailPraiseView(Context context) {
        super(context);
        this.DEFAULT_PRAISE_NUMBER = "点赞";
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228635400")) {
            ipChange.ipc$dispatch("-228635400", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        setOrientation(0);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256078741")) {
            ipChange.ipc$dispatch("-1256078741", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.evaluate_praise_layout, this);
        this.praiseAnimateView = (PraiseAnimateView) inflate.findViewById(R$id.evaluate_praise_view);
        this.praiseNum = (TextView) inflate.findViewById(R$id.evaluate_praise_num);
    }

    public void setData(CommentPraiseInfoBean commentPraiseInfoBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-333600322")) {
            ipChange.ipc$dispatch("-333600322", new Object[]{this, commentPraiseInfoBean});
        } else if (commentPraiseInfoBean == null) {
        } else {
            try {
                i = Integer.parseInt(commentPraiseInfoBean.getPraiseCount());
            } catch (Exception e) {
                cb1.b("PraiseView", e.getMessage());
            }
            if (commentPraiseInfoBean.isHasPraised()) {
                this.praiseAnimateView.playClickAnimate();
            } else {
                this.praiseAnimateView.playCancelAnimate();
            }
            this.praiseNum.setTextSize(1, i > 0 ? 14 : 12);
            this.praiseNum.setTextColor(Color.parseColor(i > 0 ? "#000000" : "#9C9CA5"));
            this.praiseNum.setText(i > 0 ? cl.a(i) : this.DEFAULT_PRAISE_NUMBER);
        }
    }

    public void updateItemData(CommentPraiseInfoBean commentPraiseInfoBean) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1036976990")) {
            ipChange.ipc$dispatch("-1036976990", new Object[]{this, commentPraiseInfoBean});
        } else if (commentPraiseInfoBean == null) {
        } else {
            try {
                i = Integer.parseInt(commentPraiseInfoBean.getPraiseCount());
            } catch (Exception e) {
                cb1.b("PraiseView", e.getMessage());
                i = 0;
            }
            if (commentPraiseInfoBean.isHasPraised()) {
                commentPraiseInfoBean.setHasPraised(false);
                commentPraiseInfoBean.setPraiseCount(i > 0 ? cl.a(i - 1) : this.DEFAULT_PRAISE_NUMBER);
                return;
            }
            commentPraiseInfoBean.setHasPraised(true);
            commentPraiseInfoBean.setPraiseCount(cl.a(i + 1));
        }
    }

    @RequiresApi(api = 11)
    public DMEvaluateDetailPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.DEFAULT_PRAISE_NUMBER = "点赞";
        init(context);
    }

    @RequiresApi(api = 21)
    public DMEvaluateDetailPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.DEFAULT_PRAISE_NUMBER = "点赞";
        init(context);
    }
}
