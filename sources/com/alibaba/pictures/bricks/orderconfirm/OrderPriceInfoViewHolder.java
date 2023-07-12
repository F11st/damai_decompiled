package com.alibaba.pictures.bricks.orderconfirm;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder;
import com.alibaba.pictures.bricks.orderconfirm.view.BricksTextInputDialog;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.vn1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrderPriceInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String EVENT_BUY_AMOUNT_INPUT = "order_input";
    @NotNull
    public static final String EVENT_BUY_AMOUNT_MINUS = "order_minus";
    @NotNull
    public static final String EVENT_BUY_AMOUNT_PLUS = "order_plus";
    @Nullable
    private OnEventListener a;
    @Nullable
    private JSONObject b;
    private final View c;
    private final View d;
    private final TextView e;
    private final TextView f;
    private final DigitTextView g;
    private int h;
    private int i;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements BricksTextInputDialog.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String b;

        b(String str) {
            this.b = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
            r6 = kotlin.text.n.i(r6);
         */
        @Override // com.alibaba.pictures.bricks.orderconfirm.view.BricksTextInputDialog.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(@org.jetbrains.annotations.Nullable android.content.DialogInterface r6, @org.jetbrains.annotations.Nullable java.lang.CharSequence r7) {
            /*
                r5 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder.b.$ipChange
                java.lang.String r1 = "1747330610"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                if (r2 == 0) goto L1a
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r4 = 0
                r2[r4] = r5
                r2[r3] = r6
                r6 = 2
                r2[r6] = r7
                r0.ipc$dispatch(r1, r2)
                return
            L1a:
                tb.vn1 r6 = tb.vn1.INSTANCE
                com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder r0 = com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder.this
                android.widget.TextView r0 = com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder.d(r0)
                java.lang.String r1 = "buyAmountTv"
                tb.b41.h(r0, r1)
                java.lang.String r1 = r5.b
                r6.b(r0, r1)
                if (r7 == 0) goto L74
                java.lang.String r6 = r7.toString()
                if (r6 == 0) goto L74
                java.lang.CharSequence r6 = kotlin.text.g.M0(r6)
                java.lang.String r6 = r6.toString()
                if (r6 == 0) goto L74
                java.lang.Integer r6 = kotlin.text.g.i(r6)
                if (r6 == 0) goto L74
                int r6 = r6.intValue()
                if (r6 >= r3) goto L52
                com.alibaba.pictures.bricks.util.toast.BricksToastUtil r6 = com.alibaba.pictures.bricks.util.toast.BricksToastUtil.INSTANCE
                java.lang.String r7 = "至少购买1张哦"
                r6.b(r7)
                goto L74
            L52:
                com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder r7 = com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder.this
                int r7 = com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder.e(r7)
                if (r6 <= r7) goto L62
                com.alibaba.pictures.bricks.util.toast.BricksToastUtil r6 = com.alibaba.pictures.bricks.util.toast.BricksToastUtil.INSTANCE
                java.lang.String r7 = "单次购买超出限购数量，请重新输入哦"
                r6.b(r7)
                goto L74
            L62:
                com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder r7 = com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder.this
                com.alibaba.pictures.bricks.orderconfirm.OnEventListener r7 = r7.j()
                if (r7 == 0) goto L74
                r0 = 0
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                java.lang.String r1 = "order_input"
                r7.onEvent(r1, r0, r6)
            L74:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder.b.onClick(android.content.DialogInterface, java.lang.CharSequence):void");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderPriceInfoViewHolder(@NotNull View view, @Nullable OnEventListener onEventListener, @Nullable JSONObject jSONObject) {
        super(view);
        b41.i(view, "itemView");
        this.a = onEventListener;
        this.b = jSONObject;
        this.c = view.findViewById(R$id.order_buy_amount_counter_plus);
        this.d = view.findViewById(R$id.order_buy_amount_counter_minus);
        this.e = (TextView) view.findViewById(R$id.order_buy_amount_counter_text);
        this.f = (TextView) view.findViewById(R$id.order_buy_amount_limit_desc);
        this.g = (DigitTextView) view.findViewById(R$id.order_buy_amount_total_price);
        this.h = Integer.MAX_VALUE;
        this.i = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106578925")) {
            ipChange.ipc$dispatch("106578925", new Object[]{orderPriceInfoViewHolder, str, view});
            return;
        }
        b41.i(orderPriceInfoViewHolder, "this$0");
        vn1 vn1Var = vn1.INSTANCE;
        TextView textView = orderPriceInfoViewHolder.e;
        b41.h(textView, "buyAmountTv");
        vn1Var.b(textView, str);
        int i = orderPriceInfoViewHolder.i;
        if (i >= orderPriceInfoViewHolder.h) {
            BricksToastUtil.INSTANCE.b("单次购买超出限购数量，请重新输入哦");
            return;
        }
        OnEventListener onEventListener = orderPriceInfoViewHolder.a;
        if (onEventListener != null) {
            onEventListener.onEvent(EVENT_BUY_AMOUNT_PLUS, null, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880003764")) {
            ipChange.ipc$dispatch("-880003764", new Object[]{orderPriceInfoViewHolder, str, view});
            return;
        }
        b41.i(orderPriceInfoViewHolder, "this$0");
        vn1 vn1Var = vn1.INSTANCE;
        TextView textView = orderPriceInfoViewHolder.e;
        b41.h(textView, "buyAmountTv");
        vn1Var.b(textView, str);
        int i = orderPriceInfoViewHolder.i;
        if (i <= 1) {
            BricksToastUtil.INSTANCE.b("至少购买1张哦");
            orderPriceInfoViewHolder.i = 1;
            return;
        }
        OnEventListener onEventListener = orderPriceInfoViewHolder.a;
        if (onEventListener != null) {
            onEventListener.onEvent(EVENT_BUY_AMOUNT_MINUS, null, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str, String str2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "908927073")) {
            ipChange.ipc$dispatch("908927073", new Object[]{orderPriceInfoViewHolder, str, str2, view});
            return;
        }
        b41.i(orderPriceInfoViewHolder, "this$0");
        new BricksTextInputDialog(orderPriceInfoViewHolder.e.getContext()).g("", str).h(new b(str2)).show();
    }

    public final void f(@Nullable JSONObject jSONObject) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950029881")) {
            ipChange.ipc$dispatch("-1950029881", new Object[]{this, jSONObject});
        } else if (jSONObject == null) {
        } else {
            try {
                this.i = jSONObject.getIntValue("buyAmount");
                this.h = jSONObject.getIntValue("buyLimit");
            } catch (Exception unused) {
                this.i = 1;
                this.h = Integer.MAX_VALUE;
            }
            this.e.setText(String.valueOf(this.i));
            JSONObject jSONObject2 = this.b;
            final String obj2 = (jSONObject2 == null || (obj = jSONObject2.get("itemId")) == null) ? null : obj.toString();
            vn1 vn1Var = vn1.INSTANCE;
            TextView textView = this.e;
            b41.h(textView, "buyAmountTv");
            vn1Var.c(textView, obj2);
            final String string = jSONObject.getString("limitDesc");
            this.f.setText(string);
            this.g.setText(jSONObject.getString("totalPriceTxt"));
            this.c.setEnabled(this.i < this.h);
            this.d.setEnabled(this.i > 1);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: tb.xo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderPriceInfoViewHolder.g(OrderPriceInfoViewHolder.this, obj2, view);
                }
            });
            this.d.setOnClickListener(new View.OnClickListener() { // from class: tb.wo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderPriceInfoViewHolder.h(OrderPriceInfoViewHolder.this, obj2, view);
                }
            });
            this.e.setOnClickListener(new View.OnClickListener() { // from class: tb.yo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderPriceInfoViewHolder.i(OrderPriceInfoViewHolder.this, string, obj2, view);
                }
            });
        }
    }

    @Nullable
    public final OnEventListener j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1830850207") ? (OnEventListener) ipChange.ipc$dispatch("1830850207", new Object[]{this}) : this.a;
    }
}
