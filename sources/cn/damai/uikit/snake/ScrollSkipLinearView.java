package cn.damai.uikit.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import java.util.List;
import tb.h62;
import tb.q60;
import tb.ui2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScrollSkipLinearView extends ScrollLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
    IPhenixListener listener;
    private float mLineWidth;
    private Paint mPaint;
    private int mScrollX;
    public int mSelectIndex;
    private TextView mSelectTv;
    private float mStartX;
    private int mStartY;
    private float mStopX;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        a(ScrollSkipLinearView scrollSkipLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1581963080")) {
                ipChange.ipc$dispatch("1581963080", new Object[]{this, view});
            } else {
                this.a.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements IPhenixListener<ui2> {
        private static transient /* synthetic */ IpChange $ipChange;

        b(ScrollSkipLinearView scrollSkipLinearView) {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ui2 ui2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-875667613")) {
                return ((Boolean) ipChange.ipc$dispatch("-875667613", new Object[]{this, ui2Var})).booleanValue();
            }
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) ui2Var.f();
            animatedImageDrawable.start();
            animatedImageDrawable.setMaxLoopCount(1);
            return false;
        }
    }

    public ScrollSkipLinearView(Context context) {
        super(context);
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.mScrollX = 0;
        this.mContext = context;
        initView();
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967636053")) {
            ipChange.ipc$dispatch("967636053", new Object[]{this});
        } else {
            this.listener = new b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView, android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "235937886")) {
            ipChange.ipc$dispatch("235937886", new Object[]{this, canvas});
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007846667")) {
            ipChange.ipc$dispatch("-1007846667", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSelectIndex = i;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i2);
            TextView textView = (TextView) viewGroup.findViewById(R$id.tv_name);
            ImageView imageView = (ImageView) viewGroup.findViewById(R$id.iv_line);
            if (i == i2) {
                textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                textView.setTextSize(1, this.mDaSize);
                textView.setPadding(0, 0, 0, q60.a(getContext(), 1.0f));
                imageView.setVisibility(0);
                TUrlImageView tUrlImageView = (TUrlImageView) imageView;
                tUrlImageView.setImageUrl(h62.p("tab_indicator_anim.png"));
                tUrlImageView.succListener(this.listener);
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                textView.setTextSize(1, this.mXiaoSize);
                textView.setPadding(0, q60.a(getContext(), 2.0f), 0, 0);
                imageView.setVisibility(4);
                ((TUrlImageView) imageView).setImageUrl("");
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754017868")) {
            ipChange.ipc$dispatch("-1754017868", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.anchor_index_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_name);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    textView.setTextSize(1, this.mXiaoSize);
                    inflate.setTag(scrollTitleBean);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams.gravity = 16;
                    inflate.setPadding(dip2px(this.mSpace / 2), 0, dip2px(this.mSpace / 2), 0);
                    inflate.setLayoutParams(layoutParams);
                    inflate.setOnClickListener(new a(this, onClickListener));
                    addView(inflate);
                }
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void startAnim(int i, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553378518")) {
            ipChange.ipc$dispatch("553378518", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
    }

    public ScrollSkipLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.mScrollX = 0;
        this.mContext = context;
        initView();
    }
}
