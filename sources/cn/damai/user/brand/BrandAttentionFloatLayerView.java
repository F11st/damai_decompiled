package cn.damai.user.brand;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.round.RoundImageView2;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ns;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class BrandAttentionFloatLayerView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    TextView attentionAction;
    RoundImageView2 brandIcon;
    ImageView brandIconShadow;
    AttentionLayerCallBack callBack;
    DMIconFontTextView close;
    Context context;
    LinearLayout introduceOne;
    LinearLayout introduceThree;
    LinearLayout introduceTwo;
    View partent;
    FrameLayout rlShoadow;
    TextView tvBrandIntroduce;
    TextView tvTroOne;
    TextView tvTroThree;
    TextView tvTroTwo;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface AttentionLayerCallBack {
        void attentionAction();

        void closeLayer();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandAttentionFloatLayerView$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2673a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2673a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1710243157")) {
                ipChange.ipc$dispatch("1710243157", new Object[]{this, view});
            } else {
                BrandAttentionFloatLayerView.this.callBack.attentionAction();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandAttentionFloatLayerView$b */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2674b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2674b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-473433770")) {
                ipChange.ipc$dispatch("-473433770", new Object[]{this, view});
            } else {
                BrandAttentionFloatLayerView.this.callBack.closeLayer();
            }
        }
    }

    public BrandAttentionFloatLayerView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820974366")) {
            ipChange.ipc$dispatch("-1820974366", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.brand_attention_float_layer_layout, this);
        this.partent = inflate;
        this.rlShoadow = (FrameLayout) inflate.findViewById(R$id.brand_attention_float_layer_ll_shadow);
        this.attentionAction = (TextView) this.partent.findViewById(R$id.brand_attention_float_layer_action);
        this.tvBrandIntroduce = (TextView) this.partent.findViewById(R$id.brand_attention_float_layer_name);
        this.close = (DMIconFontTextView) this.partent.findViewById(R$id.brand_attention_float_layer_close);
        this.brandIcon = (RoundImageView2) this.partent.findViewById(R$id.brand_attention_float_layer_icon);
        this.brandIconShadow = (ImageView) this.partent.findViewById(R$id.brand_attention_float_layer_icon_shadow);
        LinearLayout linearLayout = (LinearLayout) this.partent.findViewById(R$id.brand_attention_introduce_one);
        this.introduceOne = linearLayout;
        int i = R$id.brand_introduce_text;
        this.tvTroOne = (TextView) linearLayout.findViewById(i);
        LinearLayout linearLayout2 = (LinearLayout) this.partent.findViewById(R$id.brand_attention_introduce_two);
        this.introduceTwo = linearLayout2;
        this.tvTroTwo = (TextView) linearLayout2.findViewById(i);
        LinearLayout linearLayout3 = (LinearLayout) this.partent.findViewById(R$id.brand_attention_introduce_three);
        this.introduceThree = linearLayout3;
        this.tvTroThree = (TextView) linearLayout3.findViewById(i);
    }

    public void setCallBack(AttentionLayerCallBack attentionLayerCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759661659")) {
            ipChange.ipc$dispatch("759661659", new Object[]{this, attentionLayerCallBack});
        } else {
            this.callBack = attentionLayerCallBack;
        }
    }

    public void update(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239080780")) {
            ipChange.ipc$dispatch("239080780", new Object[]{this, str, str2, str3});
            return;
        }
        TextView textView = this.tvBrandIntroduce;
        textView.setText("关注“" + str + "” 享受粉丝福利");
        this.attentionAction.setText(str2);
        DMImageCreator c = C0504a.b().c(str3);
        int i = R$drawable.uikit_default_image_bg_gradient;
        c.i(i).c(i).g(this.brandIcon);
        ns.c(this.brandIconShadow, 2, Color.parseColor("#00000000"), t60.a(this.context, 10.0f), Color.parseColor("#1A000000"), t60.a(this.context, 10.0f), t60.a(this.context, 10.0f), t60.a(this.context, 10.0f));
        ns.b(this.rlShoadow, Color.parseColor("#00000000"), t60.a(this.context, 10.0f), Color.parseColor("#1A000000"), t60.a(this.context, 10.0f), t60.a(this.context, 10.0f), t60.a(this.context, 10.0f));
        this.tvTroOne.setText("最新资讯");
        this.tvTroTwo.setText("上新通知");
        this.tvTroThree.setText("低价活动预告");
        if (this.callBack != null) {
            this.attentionAction.setOnClickListener(new View$OnClickListenerC2673a());
            this.close.setOnClickListener(new View$OnClickListenerC2674b());
        }
    }

    public BrandAttentionFloatLayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BrandAttentionFloatLayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
