package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.tetris.component.brand.bean.ActivityInfo;
import cn.damai.tetris.component.brand.bean.BrandInfoBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.BrandAndArtists;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.gb;
import tb.z20;
import tb.zx2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectBrandSingleViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private RelativeLayout b;

    public ProjectBrandSingleViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_brand_single_layout, viewGroup, false));
        this.a = context;
        this.b = (RelativeLayout) this.itemView.findViewById(R$id.rl_project_detail_brand_area);
    }

    private ArrayList<BaseLayer> b(BrandAndArtists brandAndArtists) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-904468902")) {
            return (ArrayList) ipChange.ipc$dispatch("-904468902", new Object[]{this, brandAndArtists});
        }
        ArrayList<BaseLayer> arrayList = new ArrayList<>();
        BaseLayer baseLayer = new BaseLayer();
        ArrayList arrayList2 = new ArrayList();
        BaseSection baseSection = new BaseSection();
        baseSection.setComponentId("dm_card_ip_brand");
        JSONObject jSONObject = new JSONObject();
        if (brandAndArtists != null) {
            BrandInfoBean brandInfoBean = new BrandInfoBean();
            brandInfoBean.id = String.valueOf(brandAndArtists.id);
            brandInfoBean.name = brandAndArtists.name;
            if (!TextUtils.isEmpty(brandAndArtists.label)) {
                brandInfoBean.subTitle = brandAndArtists.label;
            } else if (!TextUtils.isEmpty(brandAndArtists.desc)) {
                brandInfoBean.subTitle = brandAndArtists.desc;
            } else {
                brandInfoBean.subTitle = "";
            }
            brandInfoBean.followStatus = brandAndArtists.getFollowStatus();
            brandInfoBean.pic = brandAndArtists.picUrl;
            brandInfoBean.backgroundPic = brandAndArtists.bgPicUrl;
            if (!TextUtils.isEmpty(brandAndArtists.activityId)) {
                ActivityInfo activityInfo = new ActivityInfo();
                activityInfo.targetId = String.valueOf(brandAndArtists.id);
                activityInfo.couponId = brandAndArtists.activityId;
                brandInfoBean.activityDO = activityInfo;
            } else {
                brandInfoBean.activityDO = null;
            }
            jSONObject.put("brand", (Object) brandInfoBean);
            JSON.parseObject(JSON.toJSONString(jSONObject));
            baseSection.setItem(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("brand_id", (Object) Long.valueOf(brandAndArtists.id));
            jSONObject2.put("coupon_id", (Object) brandAndArtists.activityId);
            jSONObject2.put("usercode", (Object) z20.i());
            baseSection.setTrackInfoBeta(jSONObject2);
            baseSection.getTrackInfo().trackB = gb.PROJECT_PAGE;
            baseSection.getTrackInfo().trackC = "brand";
            baseSection.getTrackInfo().trackD = "coupon_btn";
            arrayList2.add(baseSection);
            baseLayer.setSections(arrayList2);
            arrayList.add(baseLayer);
        }
        return arrayList;
    }

    public void a(ProjectDataHolder projectDataHolder, zx2 zx2Var) {
        BrandAndArtists brandAndArtists;
        LinearLayout c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816810366")) {
            ipChange.ipc$dispatch("1816810366", new Object[]{this, projectDataHolder, zx2Var});
        } else if (projectDataHolder == null || (brandAndArtists = projectDataHolder.brandOrArtists) == null || zx2Var == null || (c = zx2Var.c(b(brandAndArtists), (ViewGroup) this.itemView)) == null) {
        } else {
            AttentionView attentionView = (AttentionView) c.findViewById(cn.damai.commonbusiness.R$id.attent_view_ipbrand);
            if ((this.a instanceof AttentionView.StateListener) && attentionView != null) {
                ((AttentionView.StateListener) this.a).onStateChanged(attentionView.getState());
            }
            this.b.removeAllViews();
            this.b.addView(c);
            View findViewById = c.findViewById(cn.damai.commonbusiness.R$id.ip_brand_title);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }
}
