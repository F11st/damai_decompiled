package com.alibaba.pictures.bricks.selector.view;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$string;
import com.alibaba.pictures.bricks.orderconfirm.OnEventListener;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.view.ShopViewHolder;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShopViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3546a Companion = new C3546a(null);
    @Nullable
    private OnEventListener a;
    private final RoundRadiusImageView b;
    private final TextView c;
    private final TextView d;
    private final BricksIconFontTextView e;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.selector.view.ShopViewHolder$a */
    /* loaded from: classes7.dex */
    public static final class C3546a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3546a() {
        }

        public /* synthetic */ C3546a(k50 k50Var) {
            this();
        }

        @NotNull
        public final ShopViewHolder a(@NotNull ViewGroup viewGroup, @Nullable OnEventListener onEventListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1296218690")) {
                return (ShopViewHolder) ipChange.ipc$dispatch("1296218690", new Object[]{this, viewGroup, onEventListener});
            }
            b41.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_script_select_shop, viewGroup, false);
            b41.h(inflate, "from(parent.context)\n   …lect_shop, parent, false)");
            return new ShopViewHolder(inflate, onEventListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopViewHolder(@NotNull View view, @Nullable OnEventListener onEventListener) {
        super(view);
        b41.i(view, "itemView");
        this.a = onEventListener;
        this.b = (RoundRadiusImageView) view.findViewById(R$id.shop_img);
        this.c = (TextView) view.findViewById(R$id.shop_name);
        this.d = (TextView) view.findViewById(R$id.shop_address);
        this.e = (BricksIconFontTextView) view.findViewById(R$id.checkbox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ShopViewHolder shopViewHolder, ScriptSelectMo scriptSelectMo, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254205204")) {
            ipChange.ipc$dispatch("-1254205204", new Object[]{shopViewHolder, scriptSelectMo, view});
            return;
        }
        b41.i(shopViewHolder, "this$0");
        b41.i(scriptSelectMo, "$data");
        shopViewHolder.e(true);
        OnEventListener onEventListener = shopViewHolder.a;
        if (onEventListener != null) {
            onEventListener.onEvent(ScriptSelectFragment.EVENT_ID_ITEM_SELECT, shopViewHolder.itemView, scriptSelectMo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void d(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.selector.view.ShopViewHolder.$ipChange
            java.lang.String r1 = "150119142"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1a
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            r6 = 2
            r2[r6] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L1a:
            if (r7 == 0) goto L25
            boolean r0 = kotlin.text.C8596g.s(r7)
            if (r0 == 0) goto L23
            goto L25
        L23:
            r0 = 0
            goto L26
        L25:
            r0 = 1
        L26:
            if (r0 != 0) goto L78
            if (r6 == 0) goto L32
            boolean r0 = kotlin.text.C8596g.s(r6)
            if (r0 == 0) goto L31
            goto L32
        L31:
            r3 = 0
        L32:
            if (r3 == 0) goto L35
            goto L78
        L35:
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>(r6)
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r7)     // Catch: java.lang.Exception -> L6e
            java.util.regex.Matcher r6 = r1.matcher(r6)     // Catch: java.lang.Exception -> L6e
        L42:
            boolean r1 = r6.find()     // Catch: java.lang.Exception -> L6e
            if (r1 == 0) goto L72
            int r1 = r6.start()     // Catch: java.lang.Exception -> L6e
            r2 = -1
            if (r1 == r2) goto L72
            if (r1 >= 0) goto L52
            goto L72
        L52:
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan     // Catch: java.lang.Exception -> L6e
            android.widget.TextView r3 = r5.c     // Catch: java.lang.Exception -> L6e
            android.content.Context r3 = r3.getContext()     // Catch: java.lang.Exception -> L6e
            int r4 = com.alibaba.pictures.R$color.bricks_FF2D79     // Catch: java.lang.Exception -> L6e
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)     // Catch: java.lang.Exception -> L6e
            r2.<init>(r3)     // Catch: java.lang.Exception -> L6e
            int r3 = r7.length()     // Catch: java.lang.Exception -> L6e
            int r3 = r3 + r1
            r4 = 18
            r0.setSpan(r2, r1, r3, r4)     // Catch: java.lang.Exception -> L6e
            goto L42
        L6e:
            r6 = move-exception
            r6.printStackTrace()
        L72:
            android.widget.TextView r6 = r5.c
            r6.setText(r0)
            return
        L78:
            android.widget.TextView r7 = r5.c
            r7.setText(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.selector.view.ShopViewHolder.d(java.lang.String, java.lang.String):void");
    }

    private final void e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "26378527")) {
            ipChange.ipc$dispatch("26378527", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.e.setText(R$string.iconfont_yuangouxuanxuanzhong);
            this.e.setTextColor(Color.parseColor("#FF2869"));
        } else {
            this.e.setText(R$string.iconfont_yuangouxuanweixuanzhong);
            this.e.setTextColor(Color.parseColor("#C8C8C8"));
        }
    }

    public final void b(@NotNull final ScriptSelectMo scriptSelectMo, @Nullable String str, @Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418459869")) {
            ipChange.ipc$dispatch("418459869", new Object[]{this, scriptSelectMo, str, bool});
            return;
        }
        b41.i(scriptSelectMo, "data");
        ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
        String headImgUrl = scriptSelectMo.getHeadImgUrl();
        RoundRadiusImageView roundRadiusImageView = this.b;
        int i = R$drawable.store_defult_img;
        proxy.loadinto(headImgUrl, roundRadiusImageView, i, i);
        d(scriptSelectMo.getTargetName(), str);
        this.d.setText(scriptSelectMo.getDescribe());
        e(bool != null ? bool.booleanValue() : false);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.kc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShopViewHolder.c(ShopViewHolder.this, scriptSelectMo, view);
            }
        });
    }
}
