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
import com.alibaba.pictures.bricks.selector.view.ScriptViewHolder;
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
public final class ScriptViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private OnEventListener a;
    private final RoundRadiusImageView b;
    private final TextView c;
    private final BricksIconFontTextView d;
    private final View e;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final ScriptViewHolder a(@NotNull ViewGroup viewGroup, @Nullable OnEventListener onEventListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "158934168")) {
                return (ScriptViewHolder) ipChange.ipc$dispatch("158934168", new Object[]{this, viewGroup, onEventListener});
            }
            b41.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_script_select_scrpit, viewGroup, false);
            b41.h(inflate, "from(parent.context)\n   …ct_scrpit, parent, false)");
            return new ScriptViewHolder(inflate, onEventListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptViewHolder(@NotNull View view, @Nullable OnEventListener onEventListener) {
        super(view);
        b41.i(view, "itemView");
        this.a = onEventListener;
        this.b = (RoundRadiusImageView) view.findViewById(R$id.script_img);
        this.c = (TextView) view.findViewById(R$id.script_name);
        this.d = (BricksIconFontTextView) view.findViewById(R$id.checkbox);
        this.e = view.findViewById(R$id.checkbox_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ScriptViewHolder scriptViewHolder, ScriptSelectMo scriptSelectMo, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712782104")) {
            ipChange.ipc$dispatch("712782104", new Object[]{scriptViewHolder, scriptSelectMo, view});
            return;
        }
        b41.i(scriptViewHolder, "this$0");
        b41.i(scriptSelectMo, "$data");
        OnEventListener onEventListener = scriptViewHolder.a;
        if (onEventListener != null) {
            onEventListener.onEvent(ScriptSelectFragment.EVENT_ID_ITEM_SELECT, scriptViewHolder.itemView, scriptSelectMo);
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
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.selector.view.ScriptViewHolder.$ipChange
            java.lang.String r1 = "1244327089"
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
            boolean r0 = kotlin.text.g.s(r7)
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
            boolean r0 = kotlin.text.g.s(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.selector.view.ScriptViewHolder.d(java.lang.String, java.lang.String):void");
    }

    private final void e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902876502")) {
            ipChange.ipc$dispatch("-1902876502", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.d.setText(R$string.iconfont_yuangouxuanxuanzhong);
            this.d.setTextColor(Color.parseColor("#FF2869"));
            this.e.setVisibility(0);
        } else {
            this.d.setText(R$string.iconfont_yuangouxuanweixuanzhong);
            this.d.setTextColor(Color.parseColor("#FFFFFF"));
            this.e.setVisibility(8);
        }
    }

    public final void b(@NotNull final ScriptSelectMo scriptSelectMo, @Nullable String str, @Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688533016")) {
            ipChange.ipc$dispatch("-688533016", new Object[]{this, scriptSelectMo, str, bool});
            return;
        }
        b41.i(scriptSelectMo, "data");
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ScriptSelectFragment.Companion.a();
        }
        ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
        if (layoutParams2 != null) {
            ScriptSelectFragment.a aVar = ScriptSelectFragment.Companion;
            layoutParams2.width = aVar.a();
            layoutParams2.height = (int) ((aVar.a() * 216.0f) / 162.0f);
        }
        ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
        String headImgUrl = scriptSelectMo.getHeadImgUrl();
        RoundRadiusImageView roundRadiusImageView = this.b;
        int i = R$drawable.bricks_uikit_default_image_bg_grey;
        proxy.loadinto(headImgUrl, roundRadiusImageView, i, i);
        d(scriptSelectMo.getTargetName(), str);
        e(bool != null ? bool.booleanValue() : false);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.l72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScriptViewHolder.c(ScriptViewHolder.this, scriptSelectMo, view);
            }
        });
    }
}
