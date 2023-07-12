package cn.damai.category.grab.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.common.listener.ShareImageCallback;
import cn.damai.category.grab.bean.ItemBean;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.j11;
import tb.ns;
import tb.ou0;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GrabItemHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BEING = 2;
    public static final int SELL_OUT = 3;
    public static final int SOON = 1;
    private TextView A;
    private TextView B;
    private ViewGroup C;
    private Context a;
    private View b;
    private View c;
    private RoundImageView d;
    private View e;
    private DMPosterView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private View o;
    private View p;
    private TextView q;
    private View r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private View y;
    private TextView z;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.viewholder.GrabItemHolder$a */
    /* loaded from: classes.dex */
    public class C0407a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0407a(GrabItemHolder grabItemHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "514448008")) {
                ipChange.ipc$dispatch("514448008", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.viewholder.GrabItemHolder$b */
    /* loaded from: classes.dex */
    public class C0408b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ItemBean a;
        final /* synthetic */ ShareImageCallback b;

        C0408b(ItemBean itemBean, ShareImageCallback shareImageCallback) {
            this.a = itemBean;
            this.b = shareImageCallback;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-187578851")) {
                ipChange.ipc$dispatch("-187578851", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
            } else {
                String d = j11.d(this.a.verticalPic, bitmap, GrabItemHolder.this.a);
                ShareImageCallback shareImageCallback = this.b;
                if (shareImageCallback != null) {
                    shareImageCallback.callback(this.a.verticalPic, d);
                }
            }
        }
    }

    public GrabItemHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.grab_project_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = this.itemView.getContext();
        View findViewById = this.itemView.findViewById(R$id.layout_shadow);
        this.b = findViewById;
        ns.b(findViewById, Color.parseColor("#ffffff"), t60.a(this.a, 2.0f), Color.parseColor("#09000000"), t60.a(this.a, 3.0f), 0, t60.a(this.a, 3.0f));
        this.c = this.itemView.findViewById(R$id.layout_top);
        this.d = (RoundImageView) this.itemView.findViewById(R$id.image_bg);
        this.e = this.itemView.findViewById(R$id.image_mask);
        this.f = (DMPosterView) this.itemView.findViewById(R$id.poster);
        this.g = (TextView) this.itemView.findViewById(R$id.tv_name);
        this.h = (TextView) this.itemView.findViewById(R$id.tv_time);
        this.i = (TextView) this.itemView.findViewById(R$id.tv_address);
        this.j = this.itemView.findViewById(R$id.layout_see);
        this.k = (TextView) this.itemView.findViewById(R$id.tv_see);
        this.l = (TextView) this.itemView.findViewById(R$id.tv_price);
        this.m = (TextView) this.itemView.findViewById(R$id.tv_price_tip);
        this.n = (TextView) this.itemView.findViewById(R$id.btn_buy);
        this.C = (ViewGroup) this.itemView.findViewById(R$id.ht_ll_tagview);
        this.o = this.itemView.findViewById(R$id.view_xuxian);
        this.p = this.itemView.findViewById(R$id.layout_bottom);
        this.q = (TextView) this.itemView.findViewById(R$id.tv_time_tip);
        this.r = this.itemView.findViewById(R$id.layout_daojishi);
        this.s = (TextView) this.itemView.findViewById(R$id.tv_time1);
        this.t = (TextView) this.itemView.findViewById(R$id.tv_time1_tip);
        this.u = (TextView) this.itemView.findViewById(R$id.tv_time2);
        this.v = (TextView) this.itemView.findViewById(R$id.tv_time3);
        this.w = (TextView) this.itemView.findViewById(R$id.tv_time4);
        this.x = (TextView) this.itemView.findViewById(R$id.btn_see);
        this.y = this.itemView.findViewById(R$id.layout_bottom2);
        this.z = (TextView) this.itemView.findViewById(R$id.tv_selling_tip);
        this.A = (TextView) this.itemView.findViewById(R$id.btn_go_buy);
        this.B = (TextView) this.itemView.findViewById(R$id.tv_qiangwanle);
        int[] iArr = {Color.parseColor("#FF7F81"), Color.parseColor("#FF2D79")};
        ns.d(this.n, iArr, t60.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), t60.a(this.a, 2.0f), 0, t60.a(this.a, 2.0f));
        ns.d(this.x, iArr, t60.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), t60.a(this.a, 2.0f), 0, t60.a(this.a, 2.0f));
        ns.d(this.A, iArr, t60.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), t60.a(this.a, 2.0f), 0, t60.a(this.a, 2.0f));
    }

    private void b(MarketTagBean marketTagBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1151168634")) {
            ipChange.ipc$dispatch("1151168634", new Object[]{this, marketTagBean});
        } else if (marketTagBean != null) {
            if (this.C.getVisibility() != 0) {
                this.C.setVisibility(0);
            }
            marketTagBean.addMarketTagView(this.C, true);
        }
    }

    private String c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301861419")) {
            return (String) ipChange.ipc$dispatch("1301861419", new Object[]{this, Long.valueOf(j)});
        }
        if (j >= 0) {
            String str = j + "";
            if (TextUtils.isEmpty(str)) {
                return "00";
            }
            if (str.length() == 1) {
                return "0" + str;
            }
            return str;
        }
        return "00";
    }

    private void e(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985723785")) {
            ipChange.ipc$dispatch("1985723785", new Object[]{this, str, str2, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("discount_type", str2);
        }
        C0529c e = C0529c.e();
        View view = this.itemView;
        e.G(view, "item_" + i, "list", ou0.GRAB_PAGE, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(boolean r11, cn.damai.category.grab.bean.ItemBean r12, int r13, cn.damai.category.common.listener.ShareImageCallback r14) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.category.grab.ui.viewholder.GrabItemHolder.d(boolean, cn.damai.category.grab.bean.ItemBean, int, cn.damai.category.common.listener.ShareImageCallback):void");
    }
}
