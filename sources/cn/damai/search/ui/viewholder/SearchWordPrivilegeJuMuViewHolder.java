package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.C9826vr;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchWordPrivilegeJuMuViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private TextView b;
    private TextView c;
    private RoundImageView d;
    private String e;
    TextView f;
    View g;

    public SearchWordPrivilegeJuMuViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_privilege_ju_mu, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = context;
        this.d = (RoundImageView) this.itemView.findViewById(R$id.iv_jumu_image);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_jumu_name);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_jumu_desc);
    }

    public void a(BaccountInfo baccountInfo, int i, boolean z, boolean z2) {
        int start;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1396589558")) {
            ipChange.ipc$dispatch("-1396589558", new Object[]{this, baccountInfo, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        if (z) {
            TextView textView = this.f;
            if (textView != null) {
                ((ViewGroup) this.itemView).removeView(textView);
            }
            TextView textView2 = new TextView(this.a);
            this.f = textView2;
            textView2.setText("剧目");
            this.f.setTextSize(1, 16.0f);
            this.f.setTextColor(this.a.getResources().getColor(R$color.black));
            this.f.setGravity(115);
            this.f.setPadding(0, 0, 0, q60.a(this.a, 15.0f));
            ((ViewGroup) this.itemView).addView(this.f, 0, new LinearLayout.LayoutParams(-1, -2));
            if (z2) {
                View view = this.g;
                if (view != null) {
                    ((ViewGroup) this.itemView).removeView(view);
                }
                View view2 = new View(this.a);
                this.g = view2;
                view2.setBackgroundColor(this.a.getResources().getColor(R$color.color_eeeeee));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                layoutParams.setMargins(0, 0, 0, q60.a(this.a, 15.0f));
                ((ViewGroup) this.itemView).addView(this.g, 0, layoutParams);
            }
        } else {
            TextView textView3 = this.f;
            if (textView3 != null) {
                ((ViewGroup) this.itemView).removeView(textView3);
                this.f = null;
            }
            View view3 = this.g;
            if (view3 != null) {
                ((ViewGroup) this.itemView).removeView(view3);
                this.g = null;
            }
        }
        if (this.d.getTag() instanceof C9826vr) {
            ((C9826vr) this.d.getTag()).cancel();
        }
        DMImageCreator c = C0504a.b().c(baccountInfo.headPic);
        int i2 = R$drawable.uikit_default_image_bg_gradient;
        this.d.setTag(c.i(i2).c(i2).g(this.d));
        this.b.setText(baccountInfo.description);
        String str = this.e;
        String trim = str == null ? "" : str.trim();
        String str2 = baccountInfo.name;
        if ((TextUtils.isEmpty(trim) || TextUtils.isEmpty(str2)) ? false : false) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            try {
                Matcher matcher = Pattern.compile(trim).matcher(str2);
                while (matcher.find() && (start = matcher.start()) != -1) {
                    if (start >= 0) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.a, cn.damai.commonbusiness.R$color.color_FF2D79)), start, trim.length() + start, 18);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.c.setText(spannableStringBuilder);
            return;
        }
        this.c.setText(str2);
    }

    public void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602124716")) {
            ipChange.ipc$dispatch("-1602124716", new Object[]{this, str});
        } else {
            this.e = str;
        }
    }
}
