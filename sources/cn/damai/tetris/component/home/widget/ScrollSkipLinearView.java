package cn.damai.tetris.component.home.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.h62;
import tb.q60;
import tb.ui2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ScrollSkipLinearView extends TabLottieLinearView {
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
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        a(ScrollSkipLinearView scrollSkipLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "223521201")) {
                ipChange.ipc$dispatch("223521201", new Object[]{this, view});
            } else {
                this.a.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        b(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "825153516")) {
                ipChange.ipc$dispatch("825153516", new Object[]{this, aVar});
                return;
            }
            this.a.setComposition(aVar);
            this.a.playAnimation();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements LottieListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        c(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // com.airbnb.lottie.LottieListener
        public void onResult(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "309022466")) {
                ipChange.ipc$dispatch("309022466", new Object[]{this, obj});
            } else {
                this.a.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        d(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1915419418")) {
                ipChange.ipc$dispatch("-1915419418", new Object[]{this, dVar});
            } else {
                this.a.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class e implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        e(ScrollSkipLinearView scrollSkipLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1241461243")) {
                ipChange.ipc$dispatch("1241461243", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
            } else {
                this.a.setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class f implements IPhenixListener<ui2> {
        private static transient /* synthetic */ IpChange $ipChange;

        f(ScrollSkipLinearView scrollSkipLinearView) {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ui2 ui2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1620939696")) {
                return ((Boolean) ipChange.ipc$dispatch("-1620939696", new Object[]{this, ui2Var})).booleanValue();
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

    private String getHashString(MessageDigest messageDigest) {
        byte[] digest;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409574058")) {
            return (String) ipChange.ipc$dispatch("1409574058", new Object[]{this, messageDigest});
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : messageDigest.digest()) {
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString(b2 & 15));
        }
        return sb.toString();
    }

    private String getMD5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760378133")) {
            return (String) ipChange.ipc$dispatch("-1760378133", new Object[]{this, str});
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes(Charset.forName("UTF-8")));
            return getHashString(messageDigest);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLottieLinearView, cn.damai.tetris.component.home.widget.TabLinearView
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970099518")) {
            ipChange.ipc$dispatch("1970099518", new Object[]{this});
        } else {
            this.listener = new f(this);
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLottieLinearView, cn.damai.tetris.component.home.widget.TabLinearView, android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924216491")) {
            ipChange.ipc$dispatch("-1924216491", new Object[]{this, canvas});
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLottieLinearView, cn.damai.tetris.component.home.widget.TabLinearView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1968258910")) {
            ipChange.ipc$dispatch("1968258910", new Object[]{this, Integer.valueOf(i)});
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

    @Override // cn.damai.tetris.component.home.widget.TabLottieLinearView, cn.damai.tetris.component.home.widget.TabLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935063595")) {
            ipChange.ipc$dispatch("935063595", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.homepage_anchor_index_item, (ViewGroup) null);
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
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R$id.lottie_view);
                    if (TextUtils.isEmpty(scrollTitleBean.picUrl) && TextUtils.isEmpty(scrollTitleBean.picJson)) {
                        lottieAnimationView.setVisibility(8);
                    } else {
                        lottieAnimationView.setVisibility(0);
                        if (!TextUtils.isEmpty(scrollTitleBean.picJson)) {
                            String str = scrollTitleBean.picJson;
                            LottieTask<com.airbnb.lottie.a> m = com.airbnb.lottie.b.m(str, getMD5(str));
                            m.f(new b(this, lottieAnimationView));
                            m.e(new c(this, lottieAnimationView));
                        } else if (!TextUtils.isEmpty(scrollTitleBean.picUrl)) {
                            cn.damai.common.image.a.b().h(this.mContext).c(scrollTitleBean.picUrl).n(new e(this, lottieAnimationView)).e(new d(this, lottieAnimationView)).f();
                        }
                    }
                    addView(inflate);
                }
            }
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLottieLinearView, cn.damai.tetris.component.home.widget.TabLinearView
    public void startAnim(int i, float f2, float f3, float f4, float f5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "142618879")) {
            ipChange.ipc$dispatch("142618879", new Object[]{this, Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)});
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
