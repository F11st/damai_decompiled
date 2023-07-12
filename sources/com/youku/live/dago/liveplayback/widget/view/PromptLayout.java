package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.ContextUtils;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.image.IImageLoaderFactory;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PromptLayout extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "PromptLayout";
    private boolean landScape;
    private View mBgView;
    private ImageView mCoverIv;
    private OnPromptBtnClickListener mOnPromptBtnClickListener;
    private Button mPromptBtn;
    private TextView mPromptTv;
    private int orientation;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnPromptBtnClickListener {
        void onBackHome();

        void onRefresh();
    }

    public PromptLayout(Context context) {
        super(context);
        this.landScape = false;
        this.orientation = 1;
        initView();
    }

    private int dip2px(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1887440018") ? ((Integer) ipChange.ipc$dispatch("-1887440018", new Object[]{this, Integer.valueOf(i)})).intValue() : ContextUtils.dip2px(getContext(), i);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393130434")) {
            ipChange.ipc$dispatch("1393130434", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.dago_player_view_prompt, (ViewGroup) this, true);
        this.mPromptTv = (TextView) findViewById(R.id.f1035tv);
        this.mPromptBtn = (Button) findViewById(R.id.btn);
        this.mCoverIv = (ImageView) findViewById(R.id.iv);
        this.mBgView = findViewById(R.id.bg);
        this.mPromptTv.setVisibility(4);
        this.mPromptBtn.setVisibility(4);
        this.mCoverIv.setVisibility(4);
        this.mBgView.setVisibility(4);
    }

    private void setPrompt(String str, final String str2) {
        Button button;
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773411871")) {
            ipChange.ipc$dispatch("-773411871", new Object[]{this, str, str2});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setPrompt text: " + str + ", btn: " + str2);
        if (!TextUtils.isEmpty(str) && (textView = this.mPromptTv) != null) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2) && (button = this.mPromptBtn) != null) {
            button.setText(str2);
        }
        Button button2 = this.mPromptBtn;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.view.PromptLayout.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "943613493")) {
                        ipChange2.ipc$dispatch("943613493", new Object[]{this, view});
                    } else if (PromptLayout.this.mOnPromptBtnClickListener != null) {
                        if ("刷新".equals(str2)) {
                            PromptLayout.this.mOnPromptBtnClickListener.onRefresh();
                        }
                        if ("返回首页".equals(str2)) {
                            PromptLayout.this.mOnPromptBtnClickListener.onBackHome();
                        }
                    }
                }
            });
        }
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840431563")) {
            ipChange.ipc$dispatch("-840431563", new Object[]{this});
            return;
        }
        hideCover();
        hidePrompt();
    }

    public void hideCover() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281394622")) {
            ipChange.ipc$dispatch("1281394622", new Object[]{this});
            return;
        }
        ImageView imageView = this.mCoverIv;
        if (imageView != null) {
            imageView.setVisibility(4);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "hideCover");
        }
    }

    public void hidePrompt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708190671")) {
            ipChange.ipc$dispatch("-1708190671", new Object[]{this});
            return;
        }
        View view = this.mBgView;
        if (view != null) {
            view.setVisibility(4);
        }
        Button button = this.mPromptBtn;
        if (button != null) {
            button.setVisibility(4);
        }
        TextView textView = this.mPromptTv;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "hidePrompt");
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "651219446")) {
            ipChange.ipc$dispatch("651219446", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        this.orientation = configuration.orientation;
        updateView(this.landScape);
    }

    public PromptLayout setCover(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076259107")) {
            return (PromptLayout) ipChange.ipc$dispatch("2076259107", new Object[]{this, str});
        }
        if (this.mCoverIv != null && !TextUtils.isEmpty(str)) {
            ((IImageLoaderFactory) Dsl.getService(IImageLoaderFactory.class)).createInstance().loadUrl(str).into(this.mCoverIv);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "setCover: " + str);
        }
        return this;
    }

    public void setOnPromptBtnClickListener(OnPromptBtnClickListener onPromptBtnClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492745264")) {
            ipChange.ipc$dispatch("-1492745264", new Object[]{this, onPromptBtnClickListener});
        } else {
            this.mOnPromptBtnClickListener = onPromptBtnClickListener;
        }
    }

    public void showCover() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-132801927")) {
            ipChange.ipc$dispatch("-132801927", new Object[]{this});
            return;
        }
        ImageView imageView = this.mCoverIv;
        if (imageView != null) {
            imageView.setVisibility(0);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "showCover");
        }
    }

    public void showPrompt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1696356566")) {
            ipChange.ipc$dispatch("1696356566", new Object[]{this});
            return;
        }
        View view = this.mBgView;
        if (view != null) {
            view.setVisibility(0);
        }
        Button button = this.mPromptBtn;
        if (button != null) {
            button.setVisibility(0);
        }
        TextView textView = this.mPromptTv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "showPrompt");
    }

    public void updateView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "497201803")) {
            ipChange.ipc$dispatch("497201803", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateView landScape: " + z);
        this.landScape = z;
        if (z) {
            if (this.orientation == 1) {
                updateView(12.0f, dip2px(76), 10.0f, dip2px(18), dip2px(75), dip2px(26));
                return;
            }
            int dip2px = dip2px(99);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateView ui 99: " + dip2px);
            int min = (int) (((double) Math.min(UIUtils.getScreenWidth(getContext()), UIUtils.getScreenHeight(getContext()))) * 0.32d);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateView ui 32%: " + min);
            updateView(14.0f, min, 14.0f, dip2px(24), dip2px(114), dip2px(36));
            return;
        }
        updateView(14.0f, dip2px(197), 14.0f, dip2px(24), dip2px(114), dip2px(36));
    }

    public PromptLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.landScape = false;
        this.orientation = 1;
        initView();
    }

    public void showPrompt(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047491774")) {
            ipChange.ipc$dispatch("1047491774", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            setPrompt("回放再路上！", "刷新");
            showPrompt();
        } else {
            setPrompt("本场直播已结束", "返回首页");
            showPrompt();
        }
    }

    public PromptLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.landScape = false;
        this.orientation = 1;
        initView();
    }

    private void updateView(float f, int i, float f2, int i2, int i3, int i4) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "729252687")) {
            ipChange.ipc$dispatch("729252687", new Object[]{this, Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else if (this.mPromptBtn == null || (textView = this.mPromptTv) == null) {
        } else {
            textView.setTextSize(f);
            this.mPromptBtn.setTextSize(f2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPromptTv.getLayoutParams();
            layoutParams.topMargin = i;
            this.mPromptTv.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mPromptBtn.getLayoutParams();
            layoutParams2.topMargin = i2;
            layoutParams2.width = i3;
            layoutParams2.height = i4;
            this.mPromptBtn.setLayoutParams(layoutParams2);
        }
    }
}
