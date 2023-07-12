package cn.damai.commonbusiness.discover.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.lazyimg.ImgLoader;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;
import tb.c21;
import tb.d21;
import tb.fi0;
import tb.jm1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BigThemeViewHolder extends BaseViewHolder<ThemeBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private GifCareImageView a;
    private TextView b;
    private TextView c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    public ThemeBean j;
    public int k;
    private OnItemClickListener<ThemeBean> l;
    private ImgLoader m;
    private d21 n;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1998266680")) {
                ipChange.ipc$dispatch("-1998266680", new Object[]{this, view});
                return;
            }
            BigThemeViewHolder.this.m = c21.a(view);
            BigThemeViewHolder.this.f();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-360394427")) {
                ipChange.ipc$dispatch("-360394427", new Object[]{this, view});
            }
        }
    }

    public BigThemeViewHolder(View view, OnItemClickListener<ThemeBean> onItemClickListener) {
        super(view);
        view.addOnAttachStateChangeListener(new a());
        this.l = onItemClickListener;
        this.a = (GifCareImageView) view.findViewById(R$id.theme_img);
        this.b = (TextView) view.findViewById(R$id.theme_title);
        this.c = (TextView) view.findViewById(R$id.theme_des);
        this.d = view.findViewById(R$id.theme_watch_info);
        this.f = (TextView) view.findViewById(R$id.theme_content_num);
        this.g = (TextView) view.findViewById(R$id.theme_content_tip);
        this.e = view.findViewById(R$id.watch_line);
        this.h = (TextView) view.findViewById(R$id.theme_ipvuv_num);
        this.i = (TextView) view.findViewById(R$id.theme_ipvuv_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        d21 d21Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039683532")) {
            ipChange.ipc$dispatch("1039683532", new Object[]{this});
            return;
        }
        ImgLoader imgLoader = this.m;
        if (imgLoader == null || (d21Var = this.n) == null) {
            return;
        }
        imgLoader.a(d21Var);
        this.n = null;
    }

    private void h(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760972658")) {
            ipChange.ipc$dispatch("1760972658", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            this.e.setVisibility((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? 8 : 0);
            this.f.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.g.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.i.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
            this.h.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
            this.f.setText(TextUtils.isEmpty(str) ? "" : g(str));
            this.h.setText(TextUtils.isEmpty(str2) ? "" : g(str2));
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: e */
    public void a(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118167389")) {
            ipChange.ipc$dispatch("-1118167389", new Object[]{this, themeBean, Integer.valueOf(i)});
            return;
        }
        this.j = themeBean;
        this.k = i;
        this.n = new fi0(this.a, themeBean.pic);
        f();
        this.b.setText(themeBean.name);
        this.c.setText(themeBean.desc);
        h(themeBean.contentCount, themeBean.ipvuv);
        this.itemView.setOnClickListener(this);
    }

    public String g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153248387")) {
            return (String) ipChange.ipc$dispatch("-1153248387", new Object[]{this, str});
        }
        float i = jm1.i(str, 0.0f);
        double doubleValue = new BigDecimal(i / 10000.0f).setScale(1, 4).doubleValue();
        if (i >= 10000.0f) {
            return "" + doubleValue + "万";
        }
        return str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThemeBean themeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423023905")) {
            ipChange.ipc$dispatch("1423023905", new Object[]{this, view});
            return;
        }
        OnItemClickListener<ThemeBean> onItemClickListener = this.l;
        if (onItemClickListener == null || (themeBean = this.j) == null) {
            return;
        }
        onItemClickListener.onItemClick(themeBean, this.k);
    }
}
