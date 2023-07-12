package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ItemData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kv1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BuyButtonStatusHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private Context d;
    private ItemData e;
    private long f;
    private OnBuyBtnClickListener g;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnBuyBtnClickListener {
        void onRemindBookingRegister();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.view.BuyButtonStatusHelper$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2267a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2267a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-282378112")) {
                ipChange.ipc$dispatch("-282378112", new Object[]{this, view});
            } else if (BuyButtonStatusHelper.this.g != null) {
                BuyButtonStatusHelper.this.g.onRemindBookingRegister();
            }
        }
    }

    public BuyButtonStatusHelper(Context context, ItemData itemData, long j, ViewGroup viewGroup) {
        this.d = context;
        this.e = itemData;
        this.f = j;
        e(context, viewGroup);
        f(context, this.e);
    }

    private int b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024317466")) {
            return ((Integer) ipChange.ipc$dispatch("-2024317466", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        if (z) {
            return R$drawable.project_buy_btn_usable_bg_selector;
        }
        return R$drawable.project_buy_btn_unusable_bg;
    }

    private String c(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "450961986") ? (String) ipChange.ipc$dispatch("450961986", new Object[]{this, str, str2}) : TextUtils.isEmpty(str) ? str2 : str;
    }

    private View e(Context context, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569912920")) {
            return (View) ipChange.ipc$dispatch("1569912920", new Object[]{this, context, viewGroup});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.project_item_buy_btn_status_view, viewGroup, false);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R$id.tv_left_main_text);
        this.c = (TextView) this.a.findViewById(R$id.tv_left_sub_text);
        this.a.setVisibility(8);
        return this.a;
    }

    private void f(Context context, ItemData itemData) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482307634")) {
            ipChange.ipc$dispatch("1482307634", new Object[]{this, context, itemData});
            return;
        }
        int i = 99;
        if (itemData != null) {
            i = wh2.k(itemData.getBuyBtnStatus());
            str = itemData.getBuyBtnText();
        } else {
            str = "";
        }
        String str2 = str;
        if (i != 1) {
            g(str2, "暂不可售", "", false, null);
            return;
        }
        g(str2, "预定登记", "", true, new View$OnClickListenerC2267a());
        kv1.h().j(this.b, String.valueOf(this.f));
    }

    private void g(String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1036252430")) {
            ipChange.ipc$dispatch("1036252430", new Object[]{this, str, str2, str3, Boolean.valueOf(z), onClickListener});
            return;
        }
        this.a.setVisibility(0);
        this.a.setBackgroundResource(b(z));
        this.a.setOnClickListener(onClickListener);
        this.a.setClickable(onClickListener != null);
        this.b.setText(c(str, str2));
        if (!TextUtils.isEmpty(str3)) {
            this.c.setText(str3);
            this.c.setVisibility(0);
            return;
        }
        this.c.setText("");
        this.c.setVisibility(8);
    }

    public View d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "989374804") ? (View) ipChange.ipc$dispatch("989374804", new Object[]{this}) : this.a;
    }

    public void h(OnBuyBtnClickListener onBuyBtnClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023915516")) {
            ipChange.ipc$dispatch("2023915516", new Object[]{this, onBuyBtnClickListener});
        } else {
            this.g = onBuyBtnClickListener;
        }
    }

    public void i(ItemData itemData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607670349")) {
            ipChange.ipc$dispatch("-607670349", new Object[]{this, itemData});
            return;
        }
        this.e = itemData;
        f(this.d, itemData);
    }
}
