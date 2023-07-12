package cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PromotionTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C0855a Companion = new C0855a(null);
    @NotNull
    public static final String HALF_PRICE = "1004";
    @NotNull
    public static final String VIP_BUY = "1005";
    @NotNull
    public static final String ZAO_NIAO = "1001";
    @NotNull
    private final ImageView imageTag;
    @Nullable
    private Tag mTag;
    @NotNull
    private final TextView textTag;
    @NotNull
    private final View vipTag;
    @NotNull
    private final TextView vipTagDes;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.PromotionTagView$a */
    /* loaded from: classes.dex */
    public static final class C0855a {
        private C0855a() {
        }

        public /* synthetic */ C0855a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PromotionTagView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ PromotionTagView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @NotNull
    public final View getCurrentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1454508940")) {
            return (View) ipChange.ipc$dispatch("1454508940", new Object[]{this});
        }
        if (this.imageTag.getVisibility() == 0) {
            return this.imageTag;
        }
        if (this.vipTag.getVisibility() == 0) {
            return this.vipTag;
        }
        return this.textTag;
    }

    @NotNull
    public final ImageView getImageTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1348425715") ? (ImageView) ipChange.ipc$dispatch("-1348425715", new Object[]{this}) : this.imageTag;
    }

    @NotNull
    public final TextView getTextTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1352360175") ? (TextView) ipChange.ipc$dispatch("1352360175", new Object[]{this}) : this.textTag;
    }

    @NotNull
    public final View getVipTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-382756249") ? (View) ipChange.ipc$dispatch("-382756249", new Object[]{this}) : this.vipTag;
    }

    @NotNull
    public final TextView getVipTagDes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1024182841") ? (TextView) ipChange.ipc$dispatch("-1024182841", new Object[]{this}) : this.vipTagDes;
    }

    public final void setTag(@Nullable Tag tag) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1536418948")) {
            ipChange.ipc$dispatch("-1536418948", new Object[]{this, tag});
        } else if (tag == null) {
        } else {
            this.mTag = tag;
            setVisibility(0);
            if (b41.d(tag.tag, HALF_PRICE)) {
                this.imageTag.setVisibility(0);
                this.vipTag.setVisibility(8);
                this.textTag.setVisibility(8);
            } else if (b41.d(tag.tag, VIP_BUY)) {
                this.vipTag.setVisibility(0);
                this.imageTag.setVisibility(8);
                this.textTag.setVisibility(8);
                this.vipTagDes.setText("专享购");
            } else if (TextUtils.isEmpty(tag.tagDesc)) {
            } else {
                this.textTag.setVisibility(0);
                this.imageTag.setVisibility(8);
                this.vipTag.setVisibility(8);
                this.textTag.setText(tag.tagDesc);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PromotionTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.sku_ncov_itembox_tag, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.layout_tag_text);
        b41.h(findViewById, "findViewById(R.id.layout_tag_text)");
        this.textTag = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.layout_tag_img);
        b41.h(findViewById2, "findViewById(R.id.layout_tag_img)");
        this.imageTag = (ImageView) findViewById2;
        View findViewById3 = findViewById(R$id.layout_tag_vip);
        b41.h(findViewById3, "findViewById(R.id.layout_tag_vip)");
        this.vipTag = findViewById3;
        View findViewById4 = findViewById(R$id.layout_tag_vip_des);
        b41.h(findViewById4, "findViewById(R.id.layout_tag_vip_des)");
        this.vipTagDes = (TextView) findViewById4;
    }
}
