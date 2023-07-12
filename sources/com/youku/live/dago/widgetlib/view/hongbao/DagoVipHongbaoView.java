package com.youku.live.dago.widgetlib.view.hongbao;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.view.progressring.ProgressRing;
import com.youku.live.dago.widgetlib.util.AsyncInflaterUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoVipHongbaoView extends FrameLayout implements IHongbaoCountdownView, IDestroyable, IAppearStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoVipHongbaoView";
    private final int LAYOUT_ID;
    private Context mContext;
    private ProgressRing mCountdownProgressView;
    private TextView mCountdownTextView;
    private IEngineInstance mEngineInstance;
    private ImageView mHongbaoIconView;
    private View mInflateRoot;
    private IListener mListener;
    private boolean supportAsyncInflater;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface IListener {
        void onClick();
    }

    public DagoVipHongbaoView(@NonNull Context context) {
        this(context, null);
    }

    private void initChildrenView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163588308")) {
            ipChange.ipc$dispatch("-163588308", new Object[]{this, view});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initChildrenView");
        this.mHongbaoIconView = (ImageView) findViewById(R.id.dago_hongbao_icon);
        this.mCountdownTextView = (TextView) findViewById(R.id.dago_hongbao_countdown_num);
        this.mCountdownProgressView = (ProgressRing) findViewById(R.id.dago_hongbao_countdown_progress);
        setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1430441688")) {
                    ipChange2.ipc$dispatch("1430441688", new Object[]{this, view2});
                } else if (DagoVipHongbaoView.this.mListener != null) {
                    DagoVipHongbaoView.this.mListener.onClick();
                }
            }
        });
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091105667")) {
            ipChange.ipc$dispatch("1091105667", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        this.supportAsyncInflater = AsyncInflaterUtils.supportAsyncInflater();
        LayoutInflater.from(context).inflate(this.LAYOUT_ID, this);
        initChildrenView(this);
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void countdownEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144246320")) {
            ipChange.ipc$dispatch("1144246320", new Object[]{this});
            return;
        }
        TextView textView = this.mCountdownTextView;
        if (textView != null) {
            textView.setText("抢");
        }
        ProgressRing progressRing = this.mCountdownProgressView;
        if (progressRing != null) {
            progressRing.setVisibility(8);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502771658")) {
            ipChange.ipc$dispatch("-502771658", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092542524")) {
            ipChange.ipc$dispatch("1092542524", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800174858")) {
            ipChange.ipc$dispatch("-800174858", new Object[]{this});
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61711087")) {
            ipChange.ipc$dispatch("61711087", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    public void setEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099964270")) {
            ipChange.ipc$dispatch("-2099964270", new Object[]{this, iEngineInstance});
        } else {
            this.mEngineInstance = iEngineInstance;
        }
    }

    public void setIListener(IListener iListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492827508")) {
            ipChange.ipc$dispatch("-1492827508", new Object[]{this, iListener});
        } else {
            this.mListener = iListener;
        }
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void setMaxProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2059563349")) {
            ipChange.ipc$dispatch("2059563349", new Object[]{this, Float.valueOf(f)});
            return;
        }
        ProgressRing progressRing = this.mCountdownProgressView;
        if (progressRing != null) {
            progressRing.setMaxProgress(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void updateCountdownProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1607395384")) {
            ipChange.ipc$dispatch("-1607395384", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ProgressRing progressRing = this.mCountdownProgressView;
        if (progressRing != null) {
            progressRing.setProgress(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void updateCountdownText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670484955")) {
            ipChange.ipc$dispatch("-670484955", new Object[]{this, str});
            return;
        }
        TextView textView = this.mCountdownTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498140979")) {
            ipChange.ipc$dispatch("1498140979", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640394399")) {
            ipChange.ipc$dispatch("640394399", new Object[]{this});
        }
    }

    public DagoVipHongbaoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DagoVipHongbaoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LAYOUT_ID = R.C7942layout.dago_youku_vip_hongbao_small_layout;
        initView(context);
    }
}
