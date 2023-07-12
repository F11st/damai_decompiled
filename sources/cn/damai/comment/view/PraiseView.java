package cn.damai.comment.view;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.listener.OnPraiseViewClickListener;
import cn.damai.comment.listener.OnPraiseViewClickListenerNew;
import cn.damai.comment.request.PraiseRequest;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.login.LoginManager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.cl;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class PraiseView extends FrameLayout implements PraiseRequest.PraiseRequestCallBack {
    private static transient /* synthetic */ IpChange $ipChange;
    public int COMMENT_TYPE_COMMENT_DETAIL;
    public int COMMENT_TYPE_COMMENT_LIST;
    public int COMMENT_TYPE_EVALUATE_LIST;
    public int COMMENT_TYPE_PROJECT;
    public int COMMENT_TYPE_REPERTOIRE;
    public int COMMENT_TYPE_VEVALUATE_LIST;
    private String DEFAULT_PRAISE_ICON;
    private int DEFAULT_PRAISE_ICON_AND_TEXT_MARGIN;
    private int DEFAULT_PRAISE_ICON_TEXT_COLOR;
    private int DEFAULT_PRAISE_ICON_TEXT_PRAISED_COLOR;
    private int DEFAULT_PRAISE_ICON_TEXT_SIZE;
    private String DEFAULT_PRAISE_NUMBER;
    private int DEFAULT_PRAISE_NUMBER_TEXT_COLOR;
    private int DEFAULT_PRAISE_NUMBER_TEXT_PRAISED_COLOR;
    private int DEFAULT_PRAISE_NUMBER_TEXT_SIZE;
    private LottieAnimationView animationView;
    private String commentId;
    private CommentsItemBean commentItemBean;
    private boolean isChoicenessComment;
    private String itemId;
    Animator.AnimatorListener listener;
    private OnPraiseViewClickListenerNew listenerNew;
    private View.OnClickListener onPraiseLayoutClickListener;
    private int position;
    private ImageView praiseIconImg;
    private CommentPraiseInfoBean praiseInfoBean;
    private TextView praiseNumber;
    private PraiseRequest praiseRequest;
    private OnPraiseViewClickListener praiseViewClickListener;
    private boolean showAnim;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "430871539")) {
                ipChange.ipc$dispatch("430871539", new Object[]{this, view});
            } else if (LoginManager.k().q()) {
                PraiseView.this.requestPraise();
                PraiseView.this.updateItemData();
                PraiseView.this.playAnim();
                PraiseView.this.updatePraiseView("click");
            } else {
                LoginManager.k().v(PraiseView.this.getContext());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "970967461")) {
                ipChange.ipc$dispatch("970967461", new Object[]{this, animator});
                return;
            }
            PraiseView.this.animationView.removeAnimatorListener(PraiseView.this.listener);
            PraiseView.this.praiseNumber.setVisibility(0);
            PraiseView.this.animationView.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1235395670")) {
                ipChange.ipc$dispatch("-1235395670", new Object[]{this, animator});
                return;
            }
            PraiseView.this.praiseNumber.setVisibility(0);
            PraiseView.this.animationView.setVisibility(8);
            PraiseView.this.animationView.removeAnimatorListener(PraiseView.this.listener);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1010424220")) {
                ipChange.ipc$dispatch("-1010424220", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1046300291")) {
                ipChange.ipc$dispatch("1046300291", new Object[]{this, animator});
            }
        }
    }

    public PraiseView(@NonNull Context context) {
        super(context);
        this.DEFAULT_PRAISE_NUMBER_TEXT_SIZE = 12;
        this.DEFAULT_PRAISE_ICON_TEXT_SIZE = 16;
        this.DEFAULT_PRAISE_ICON_AND_TEXT_MARGIN = 3;
        this.DEFAULT_PRAISE_NUMBER = "点赞";
        this.COMMENT_TYPE_PROJECT = 0;
        this.COMMENT_TYPE_REPERTOIRE = 1;
        this.COMMENT_TYPE_COMMENT_LIST = 2;
        this.COMMENT_TYPE_COMMENT_DETAIL = 3;
        this.COMMENT_TYPE_EVALUATE_LIST = 4;
        this.COMMENT_TYPE_VEVALUATE_LIST = 5;
        this.showAnim = true;
        this.onPraiseLayoutClickListener = new a();
        initDefaultValue();
        initView();
    }

    private void initDefaultValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324055957")) {
            ipChange.ipc$dispatch("324055957", new Object[]{this});
            return;
        }
        Resources resources = getResources();
        int i = R$color.color_9C9CA5;
        this.DEFAULT_PRAISE_NUMBER_TEXT_COLOR = resources.getColor(i);
        this.DEFAULT_PRAISE_NUMBER_TEXT_PRAISED_COLOR = getResources().getColor(i);
        this.DEFAULT_PRAISE_ICON_TEXT_COLOR = getResources().getColor(R$color.color_3C3F44);
        this.DEFAULT_PRAISE_ICON_TEXT_PRAISED_COLOR = getResources().getColor(R$color.color_FF983A);
        this.DEFAULT_PRAISE_ICON = getResources().getString(R$string.iconfont_dianzan_);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-912296832")) {
            ipChange.ipc$dispatch("-912296832", new Object[]{this});
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R$layout.praise_item_layout, (ViewGroup) null);
        addView(relativeLayout, new ViewGroup.LayoutParams(-2, -2));
        this.praiseIconImg = (ImageView) relativeLayout.findViewById(R$id.praise_item_iconimg);
        TextView textView = (TextView) relativeLayout.findViewById(R$id.praise_item_text);
        this.praiseNumber = textView;
        textView.setTextSize(1, this.DEFAULT_PRAISE_NUMBER_TEXT_SIZE);
        this.praiseNumber.setTextColor(this.DEFAULT_PRAISE_NUMBER_TEXT_COLOR);
        this.praiseNumber.setText(this.DEFAULT_PRAISE_NUMBER);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) relativeLayout.findViewById(R$id.praise_item_anim);
        this.animationView = lottieAnimationView;
        lottieAnimationView.setVisibility(8);
        setOnClickListener(this.onPraiseLayoutClickListener);
        PraiseRequest praiseRequest = new PraiseRequest();
        this.praiseRequest = praiseRequest;
        praiseRequest.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnim() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "174657264")) {
            ipChange.ipc$dispatch("174657264", new Object[]{this});
            return;
        }
        CommentPraiseInfoBean praiseInfo = getPraiseInfo();
        if (praiseInfo == null) {
            return;
        }
        try {
            i = Integer.parseInt(praiseInfo.getPraiseCount());
        } catch (Exception e) {
            cb1.b("PraiseView", e.getMessage());
            i = 0;
        }
        this.animationView.cancelAnimation();
        if (i == 1 && this.showAnim && (this.DEFAULT_PRAISE_NUMBER.equals(this.praiseNumber.getText()) || "1".equals(this.praiseNumber.getText()))) {
            this.praiseNumber.setVisibility(4);
            this.animationView.setVisibility(0);
            this.animationView.removeAllAnimatorListeners();
            b bVar = new b();
            this.listener = bVar;
            this.animationView.addAnimatorListener(bVar);
            this.animationView.playAnimation();
            return;
        }
        this.praiseNumber.setVisibility(0);
        this.animationView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPraise() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345570390")) {
            ipChange.ipc$dispatch("-1345570390", new Object[]{this});
        } else if (getPraiseInfo() == null || this.praiseRequest == null) {
        } else {
            CommentPraiseInfoBean praiseInfo = getPraiseInfo();
            this.praiseRequest.a(praiseInfo != null ? praiseInfo.isHasPraised() : false, getCommentId());
        }
    }

    private void setIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436471895")) {
            ipChange.ipc$dispatch("-1436471895", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.praiseIconImg;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    private void setIconColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1398884010")) {
            ipChange.ipc$dispatch("-1398884010", new Object[]{this, Integer.valueOf(i)});
        }
    }

    private void setValue(CommentPraiseInfoBean commentPraiseInfoBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "789452535")) {
            ipChange.ipc$dispatch("789452535", new Object[]{this, commentPraiseInfoBean, Integer.valueOf(i), str});
            return;
        }
        setPraiseNumber(i > 0 ? cl.a(i) : this.DEFAULT_PRAISE_NUMBER);
        setPraiseIcon(commentPraiseInfoBean.isHasPraised() ? getResources().getString(R$string.iconfont_dianzanmian_) : this.DEFAULT_PRAISE_ICON);
        setIconColor(commentPraiseInfoBean.isHasPraised() ? this.DEFAULT_PRAISE_ICON_TEXT_PRAISED_COLOR : this.DEFAULT_PRAISE_ICON_TEXT_COLOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateItemData() {
        CommentPraiseInfoBean praiseInfo;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "828972399")) {
            ipChange.ipc$dispatch("828972399", new Object[]{this});
        } else if (getPraiseInfo() == null || (praiseInfo = getPraiseInfo()) == null) {
        } else {
            try {
                i = Integer.parseInt(praiseInfo.getPraiseCount());
            } catch (Exception e) {
                cb1.b("PraiseView", e.getMessage());
                i = 0;
            }
            if (praiseInfo.isHasPraised()) {
                praiseInfo.setHasPraised(false);
                praiseInfo.setPraiseCount(i > 0 ? cl.a(i - 1) : this.DEFAULT_PRAISE_NUMBER);
                return;
            }
            praiseInfo.setHasPraised(true);
            praiseInfo.setPraiseCount(cl.a(i + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePraiseView(String str) {
        CommentPraiseInfoBean praiseInfo;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1597500757")) {
            ipChange.ipc$dispatch("1597500757", new Object[]{this, str});
        } else if (getPraiseInfo() == null || (praiseInfo = getPraiseInfo()) == null) {
        } else {
            if (praiseInfo.isHasPraised()) {
                this.praiseIconImg.setImageResource(R$drawable.uikit_zan_selected);
            } else {
                this.praiseIconImg.setImageResource(R$drawable.uikit_zan_unselected);
            }
            try {
                i = Integer.parseInt(praiseInfo.getPraiseCount());
            } catch (Exception e) {
                cb1.b("PraiseView", e.getMessage());
            }
            if (praiseInfo.isHasPraised() && i > 0) {
                this.praiseNumber.setTextColor(this.DEFAULT_PRAISE_NUMBER_TEXT_PRAISED_COLOR);
            } else {
                this.praiseNumber.setTextColor(this.DEFAULT_PRAISE_NUMBER_TEXT_COLOR);
            }
            setValue(praiseInfo, i, str);
        }
    }

    public String getCommentId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250694127")) {
            return (String) ipChange.ipc$dispatch("1250694127", new Object[]{this});
        }
        String str = this.commentId;
        if (str != null) {
            return str;
        }
        CommentsItemBean commentsItemBean = this.commentItemBean;
        return commentsItemBean != null ? commentsItemBean.getCommentId() : "";
    }

    public DMIconFontTextView getPraiseIconView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-773308482") ? (DMIconFontTextView) ipChange.ipc$dispatch("-773308482", new Object[]{this}) : new DMIconFontTextView(getContext());
    }

    public CommentPraiseInfoBean getPraiseInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-947650591")) {
            return (CommentPraiseInfoBean) ipChange.ipc$dispatch("-947650591", new Object[]{this});
        }
        CommentPraiseInfoBean commentPraiseInfoBean = this.praiseInfoBean;
        if (commentPraiseInfoBean != null) {
            return commentPraiseInfoBean;
        }
        CommentsItemBean commentsItemBean = this.commentItemBean;
        if (commentsItemBean != null) {
            return commentsItemBean.getPraiseInfo();
        }
        return new CommentPraiseInfoBean();
    }

    public TextView getPraiseNumberView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1176591433") ? (TextView) ipChange.ipc$dispatch("1176591433", new Object[]{this}) : this.praiseNumber;
    }

    public boolean isShowAnim() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1944680321") ? ((Boolean) ipChange.ipc$dispatch("1944680321", new Object[]{this})).booleanValue() : this.showAnim;
    }

    @Override // cn.damai.comment.request.PraiseRequest.PraiseRequestCallBack
    public void notifyPraiseClick() {
        OnPraiseViewClickListenerNew onPraiseViewClickListenerNew;
        CommentsItemBean commentsItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805846322")) {
            ipChange.ipc$dispatch("805846322", new Object[]{this});
            return;
        }
        OnPraiseViewClickListener onPraiseViewClickListener = this.praiseViewClickListener;
        if (onPraiseViewClickListener != null && (commentsItemBean = this.commentItemBean) != null) {
            onPraiseViewClickListener.OnPraiseViewClick(this.isChoicenessComment, commentsItemBean);
        }
        if (getPraiseInfo() == null || (onPraiseViewClickListenerNew = this.listenerNew) == null) {
            return;
        }
        onPraiseViewClickListenerNew.OnPraiseViewClick(this.isChoicenessComment, getCommentId());
    }

    public void setData(CommentPraiseInfoBean commentPraiseInfoBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219622237")) {
            ipChange.ipc$dispatch("219622237", new Object[]{this, commentPraiseInfoBean, str});
            return;
        }
        this.praiseInfoBean = commentPraiseInfoBean;
        this.commentId = str;
        updatePraiseView("4");
    }

    public void setIconAndTextMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1737561115")) {
            ipChange.ipc$dispatch("-1737561115", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.DEFAULT_PRAISE_ICON_AND_TEXT_MARGIN = i;
        invalidate();
    }

    public void setIconColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-415701907")) {
            ipChange.ipc$dispatch("-415701907", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.DEFAULT_PRAISE_ICON_TEXT_COLOR = i;
        this.DEFAULT_PRAISE_ICON_TEXT_PRAISED_COLOR = i2;
        invalidate();
    }

    public void setIconTextSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915274391")) {
            ipChange.ipc$dispatch("915274391", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setNumberTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853944281")) {
            ipChange.ipc$dispatch("853944281", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.praiseNumber;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setNumberTextSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576157465")) {
            ipChange.ipc$dispatch("-576157465", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.praiseNumber;
        if (textView != null) {
            textView.setTextSize(1, i);
        }
    }

    public void setNumberVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "17817707")) {
            ipChange.ipc$dispatch("17817707", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.praiseNumber;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public void setOnPraiseLayoutClickListenerCommon(OnPraiseViewClickListenerNew onPraiseViewClickListenerNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1720118672")) {
            ipChange.ipc$dispatch("1720118672", new Object[]{this, onPraiseViewClickListenerNew});
        } else {
            this.listenerNew = onPraiseViewClickListenerNew;
        }
    }

    public void setOnPraiseViewClickListener(OnPraiseViewClickListener onPraiseViewClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978607706")) {
            ipChange.ipc$dispatch("1978607706", new Object[]{this, onPraiseViewClickListener});
        } else {
            this.praiseViewClickListener = onPraiseViewClickListener;
        }
    }

    public void setPraiseIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1981390664")) {
            ipChange.ipc$dispatch("1981390664", new Object[]{this, str});
        }
    }

    public void setPraiseNumber(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356587512")) {
            ipChange.ipc$dispatch("1356587512", new Object[]{this, str});
            return;
        }
        TextView textView = this.praiseNumber;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setShowAnim(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175336913")) {
            ipChange.ipc$dispatch("-1175336913", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.showAnim = z;
        }
    }

    public void setData(String str, CommentsItemBean commentsItemBean, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636343398")) {
            ipChange.ipc$dispatch("1636343398", new Object[]{this, str, commentsItemBean, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        this.itemId = str;
        this.commentItemBean = commentsItemBean;
        this.isChoicenessComment = z;
        this.position = i;
        updatePraiseView("1");
    }

    public void setData(CommentsItemBean commentsItemBean, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218562908")) {
            ipChange.ipc$dispatch("218562908", new Object[]{this, commentsItemBean, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        this.commentItemBean = commentsItemBean;
        this.isChoicenessComment = z;
        this.position = i;
        this.praiseNumber.setVisibility(0);
        this.animationView.cancelAnimation();
        this.animationView.setVisibility(8);
        updatePraiseView("2");
    }

    public PraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_PRAISE_NUMBER_TEXT_SIZE = 12;
        this.DEFAULT_PRAISE_ICON_TEXT_SIZE = 16;
        this.DEFAULT_PRAISE_ICON_AND_TEXT_MARGIN = 3;
        this.DEFAULT_PRAISE_NUMBER = "点赞";
        this.COMMENT_TYPE_PROJECT = 0;
        this.COMMENT_TYPE_REPERTOIRE = 1;
        this.COMMENT_TYPE_COMMENT_LIST = 2;
        this.COMMENT_TYPE_COMMENT_DETAIL = 3;
        this.COMMENT_TYPE_EVALUATE_LIST = 4;
        this.COMMENT_TYPE_VEVALUATE_LIST = 5;
        this.showAnim = true;
        this.onPraiseLayoutClickListener = new a();
        initDefaultValue();
        initView();
    }

    public void setData(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399107053")) {
            ipChange.ipc$dispatch("1399107053", new Object[]{this, commentsItemBean});
            return;
        }
        this.commentItemBean = commentsItemBean;
        updatePraiseView("3");
    }

    public PraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.DEFAULT_PRAISE_NUMBER_TEXT_SIZE = 12;
        this.DEFAULT_PRAISE_ICON_TEXT_SIZE = 16;
        this.DEFAULT_PRAISE_ICON_AND_TEXT_MARGIN = 3;
        this.DEFAULT_PRAISE_NUMBER = "点赞";
        this.COMMENT_TYPE_PROJECT = 0;
        this.COMMENT_TYPE_REPERTOIRE = 1;
        this.COMMENT_TYPE_COMMENT_LIST = 2;
        this.COMMENT_TYPE_COMMENT_DETAIL = 3;
        this.COMMENT_TYPE_EVALUATE_LIST = 4;
        this.COMMENT_TYPE_VEVALUATE_LIST = 5;
        this.showAnim = true;
        this.onPraiseLayoutClickListener = new a();
        initDefaultValue();
        initView();
    }
}
