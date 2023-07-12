package cn.damai.commonbusiness.search.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class HorizontalProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public TextView a;
    public TextView b;
    public TextView c;
    public ImageView d;

    public HorizontalProjectViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.layout_horizontal_project, (ViewGroup) null));
        this.a = (TextView) this.itemView.findViewById(R$id.uikit_hori_project_title);
        this.b = (TextView) this.itemView.findViewById(R$id.uikit_hori_project_info);
        this.c = (TextView) this.itemView.findViewById(R$id.uikit_hori_project_price);
        this.d = (ImageView) this.itemView.findViewById(R$id.uikit_hori_project_img);
    }

    private void b(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818841852")) {
            ipChange.ipc$dispatch("-1818841852", new Object[]{this, str, str2, str3, str4});
            return;
        }
        e(this.a, str);
        e(this.b, str2);
        if (!wh2.j(str3)) {
            e(this.c, str3);
        } else {
            e(this.c, "价格待定");
        }
        DMImageCreator c = a.b().c(str4);
        int i = R$drawable.uikit_default_image_bg_gradient;
        c.i(i).c(i).g(this.d);
    }

    private String c(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-868086550")) {
            return (String) ipChange.ipc$dispatch("-868086550", new Object[]{this, projectItemBean});
        }
        return !TextUtils.isEmpty(projectItemBean.promotionPrice) ? projectItemBean.promotionPrice : projectItemBean.priceLow;
    }

    private String d(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57241694")) {
            return (String) ipChange.ipc$dispatch("57241694", new Object[]{this, projectItemBean});
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(projectItemBean.cityName)) {
            stringBuffer.append("城市待定");
        } else {
            stringBuffer.append(projectItemBean.cityName);
        }
        stringBuffer.append(" | ");
        if (!TextUtils.isEmpty(projectItemBean.showTime)) {
            stringBuffer.append(projectItemBean.showTime);
        } else {
            stringBuffer.append("时间待定");
        }
        stringBuffer.append(" | ");
        if (!TextUtils.isEmpty(projectItemBean.venueName)) {
            stringBuffer.append(projectItemBean.venueName);
        } else {
            stringBuffer.append("场馆待定");
        }
        return stringBuffer.toString();
    }

    private void e(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198734410")) {
            ipChange.ipc$dispatch("-198734410", new Object[]{this, textView, str});
        } else if (wh2.j(str)) {
        } else {
            textView.setText(str);
        }
    }

    public void a(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035629974")) {
            ipChange.ipc$dispatch("-2035629974", new Object[]{this, projectItemBean});
        } else {
            b(projectItemBean.name, d(projectItemBean), c(projectItemBean), projectItemBean.verticalPic);
        }
    }
}
