package cn.damai.uikit.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SwitchButton extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private float mLastStartX;
    private float mLastWidth;
    private List<Integer> mLengthList;
    private LinearLayout mLinearLayout;
    private View.OnClickListener mOnClickListener;
    private FrameLayout.LayoutParams mParams;
    private View mSelectView;
    private float mStartx;
    private List<TextView> mTvList;
    private float mWidth;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2026694491")) {
                ipChange.ipc$dispatch("2026694491", new Object[]{this, view});
                return;
            }
            Option option = (Option) view.getTag();
            if (option == null) {
                return;
            }
            SwitchButton.this.setSelect(option.index);
            SwitchButton.this.mOnClickListener.onClick(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1669762075")) {
                ipChange.ipc$dispatch("-1669762075", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            float f = SwitchButton.this.mStartx > SwitchButton.this.mLastStartX ? SwitchButton.this.mLastStartX + (((SwitchButton.this.mStartx - SwitchButton.this.mLastStartX) * intValue) / 100.0f) : SwitchButton.this.mLastStartX - (((SwitchButton.this.mLastStartX - SwitchButton.this.mStartx) * intValue) / 100.0f);
            float unused = SwitchButton.this.mLastWidth;
            float f2 = SwitchButton.this.mWidth > SwitchButton.this.mLastWidth ? SwitchButton.this.mLastWidth + (((SwitchButton.this.mWidth - SwitchButton.this.mLastWidth) * intValue) / 100.0f) : SwitchButton.this.mLastWidth - (((SwitchButton.this.mLastWidth - SwitchButton.this.mWidth) * intValue) / 100.0f);
            SwitchButton.this.mParams.setMargins((int) f, 0, 0, 0);
            SwitchButton.this.mParams.width = (int) f2;
            SwitchButton.this.requestLayout();
            if (intValue == 100) {
                SwitchButton switchButton = SwitchButton.this;
                switchButton.mLastStartX = switchButton.mStartx;
                SwitchButton switchButton2 = SwitchButton.this;
                switchButton2.mLastWidth = switchButton2.mWidth;
            }
        }
    }

    public SwitchButton(Context context) {
        super(context);
        this.mTvList = new ArrayList();
        this.mLastStartX = 0.0f;
        this.mStartx = 0.0f;
        this.mWidth = 0.0f;
        this.mLastWidth = 0.0f;
        this.mLengthList = new ArrayList();
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91517976")) {
            ipChange.ipc$dispatch("-91517976", new Object[]{this});
            return;
        }
        setBackgroundResource(R$drawable.switch_button_common_bg);
        View view = new View(this.mContext);
        this.mSelectView = view;
        view.setBackgroundResource(R$drawable.switch_button_common_select_bg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        this.mParams = layoutParams;
        layoutParams.height = yr2.a(this.mContext, 25.0f);
        this.mSelectView.setLayoutParams(this.mParams);
        addView(this.mSelectView);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.mLinearLayout = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mLinearLayout.getLayoutParams().height = yr2.a(this.mContext, 25.0f);
        this.mLinearLayout.setOrientation(0);
        this.mLinearLayout.setGravity(16);
        addView(this.mLinearLayout);
    }

    private void startAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300093338")) {
            ipChange.ipc$dispatch("1300093338", new Object[]{this});
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new b());
        ofInt.start();
    }

    public boolean isEmpty(List<?> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1498390049") ? ((Boolean) ipChange.ipc$dispatch("-1498390049", new Object[]{this, list})).booleanValue() : list == null || list.size() <= 0;
    }

    public void setBtnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443621742")) {
            ipChange.ipc$dispatch("1443621742", new Object[]{this, onClickListener});
        } else {
            this.mOnClickListener = onClickListener;
        }
    }

    public void setDefaultSelect(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952861535")) {
            ipChange.ipc$dispatch("-1952861535", new Object[]{this, Integer.valueOf(i)});
        } else {
            post(new Runnable() { // from class: cn.damai.uikit.view.SwitchButton.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1990355187")) {
                        ipChange2.ipc$dispatch("1990355187", new Object[]{this});
                        return;
                    }
                    SwitchButton switchButton = SwitchButton.this;
                    if (switchButton.isEmpty(switchButton.mTvList) || SwitchButton.this.mTvList.size() <= i) {
                        return;
                    }
                    TextView textView = (TextView) SwitchButton.this.mTvList.get(i);
                    SwitchButton.this.mStartx = textView.getLeft();
                    SwitchButton.this.mLastStartX = textView.getLeft();
                    SwitchButton.this.mWidth = textView.getWidth();
                    SwitchButton.this.mLastWidth = textView.getWidth();
                    SwitchButton.this.mParams.setMargins((int) SwitchButton.this.mStartx, 0, 0, 0);
                    SwitchButton.this.mParams.width = (int) SwitchButton.this.mWidth;
                    textView.setTextColor(SwitchButton.this.mContext.getResources().getColor(R$color.color_000000));
                    SwitchButton.this.requestLayout();
                }
            });
        }
    }

    public void setOption(List<Option> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "17226279")) {
            ipChange.ipc$dispatch("17226279", new Object[]{this, list});
        } else if (!isEmpty(list)) {
            this.mTvList.clear();
            this.mLinearLayout.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                Option option = list.get(i);
                if (option != null) {
                    TextView textView = new TextView(this.mContext);
                    textView.setTextSize(1, 13.0f);
                    textView.setTextColor(this.mContext.getResources().getColor(R$color.color_808080));
                    textView.setText(option.title);
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
                    textView.setPadding(yr2.a(this.mContext, 9.0f), 0, yr2.a(this.mContext, 9.0f), 0);
                    textView.setGravity(17);
                    textView.setTag(option);
                    textView.setOnClickListener(new a());
                    this.mTvList.add(textView);
                    this.mLinearLayout.addView(textView);
                }
            }
            post(new Runnable() { // from class: cn.damai.uikit.view.SwitchButton.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2108098604")) {
                        ipChange2.ipc$dispatch("-2108098604", new Object[]{this});
                        return;
                    }
                    SwitchButton switchButton = SwitchButton.this;
                    if (switchButton.isEmpty(switchButton.mTvList)) {
                        return;
                    }
                    for (int i2 = 0; i2 < SwitchButton.this.mTvList.size(); i2++) {
                        SwitchButton.this.mLengthList.add(Integer.valueOf(((TextView) SwitchButton.this.mTvList.get(i2)).getLeft()));
                    }
                }
            });
        }
    }

    public void setSelect(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137127828")) {
            ipChange.ipc$dispatch("1137127828", new Object[]{this, Integer.valueOf(i)});
        } else if (!isEmpty(this.mTvList) && this.mTvList.size() > i) {
            for (int i2 = 0; i2 < this.mTvList.size(); i2++) {
                TextView textView = this.mTvList.get(i2);
                if (i2 == i) {
                    textView.setTextColor(this.mContext.getResources().getColor(R$color.color_000000));
                    this.mStartx = textView.getLeft();
                    this.mWidth = textView.getWidth();
                } else {
                    textView.setTextColor(this.mContext.getResources().getColor(R$color.color_808080));
                }
            }
            startAnim();
        }
    }

    public SwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTvList = new ArrayList();
        this.mLastStartX = 0.0f;
        this.mStartx = 0.0f;
        this.mWidth = 0.0f;
        this.mLastWidth = 0.0f;
        this.mLengthList = new ArrayList();
        this.mContext = context;
        initView();
    }
}
