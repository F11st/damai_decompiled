package cn.damai.uikit.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScrollLottieLinearView extends ScrollLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
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

        a(ScrollLottieLinearView scrollLottieLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "222884712")) {
                ipChange.ipc$dispatch("222884712", new Object[]{this, view});
            } else {
                this.a.onClick(view);
            }
        }
    }

    public ScrollLottieLinearView(Context context) {
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
        if (AndroidInstantRuntime.support(ipChange, "913989749")) {
            ipChange.ipc$dispatch("913989749", new Object[]{this});
        } else {
            setGravity(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView, android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588976190")) {
            ipChange.ipc$dispatch("588976190", new Object[]{this, canvas});
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048403691")) {
            ipChange.ipc$dispatch("-2048403691", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSelectIndex = i;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            RelativeLayout relativeLayout = (RelativeLayout) getChildAt(i2);
            TextView textView = (TextView) relativeLayout.findViewById(R$id.tv_name);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) relativeLayout.findViewById(R$id.iv_line);
            if (i == i2) {
                textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                textView.setTextSize(1, this.mDaSize);
                textView.setPadding(0, 0, 0, 0);
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setImageAssetsFolder("cc/images/");
                lottieAnimationView.setAnimation("cc/data.json");
                lottieAnimationView.playAnimation();
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                textView.setTextSize(1, this.mXiaoSize);
                textView.setPadding(0, q60.a(getContext(), 2.0f), 0, 0);
                lottieAnimationView.setVisibility(4);
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709218412")) {
            ipChange.ipc$dispatch("-709218412", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.anchor_lottie_index_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_name);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    textView.setTextSize(1, this.mXiaoSize);
                    inflate.setTag(scrollTitleBean);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
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
        if (AndroidInstantRuntime.support(ipChange, "1305458422")) {
            ipChange.ipc$dispatch("1305458422", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
    }

    public ScrollLottieLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.mScrollX = 0;
        this.mContext = context;
        initView();
    }
}
