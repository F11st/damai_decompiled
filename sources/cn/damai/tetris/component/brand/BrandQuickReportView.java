package cn.damai.tetris.component.brand;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.brand.BrandQuickReportContract;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ns;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BrandQuickReportView extends AbsView<BrandQuickReportContract.Presenter> implements BrandQuickReportContract.View<BrandQuickReportContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    View blackHolder;
    RelativeLayout brandLayout;
    TextView brandNew;
    LinearLayout itemLayout;
    FrameLayout itemShadow;
    LinearLayout llMore;
    private Context mContext;
    RelativeLayout normalItemOne;
    DMPosterView normalItemOneImg;
    TextView normalItemOneIpvuv;
    TextView normalItemOneTitle;
    RelativeLayout normalItemTwo;
    DMPosterView normalItemTwoImg;
    TextView normalItemTwoIpvuv;
    TextView normalItemTwoTitle;
    DMPosterView specialImg;
    TextView specialIpvuv;
    RelativeLayout specialItem;
    TextView specialTitle;
    TextView updateTime;
    TextView updateTimePoint;

    public BrandQuickReportView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.brandLayout = (RelativeLayout) view.findViewById(R$id.brand_quickreport_layout);
        this.itemLayout = (LinearLayout) view.findViewById(R$id.brand_quickreport_item_layout);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.brand_quickreport_item_layout_fr_shadow);
        this.itemShadow = frameLayout;
        ns.b(frameLayout, Color.parseColor("#00000000"), t60.a(this.mContext, 10.0f), Color.parseColor("#1A6A7A99"), t60.a(this.mContext, 10.0f), t60.a(this.mContext, 10.0f), t60.a(this.mContext, 10.0f));
        this.brandNew = (TextView) view.findViewById(R$id.brand_quickreport_title);
        this.updateTime = (TextView) view.findViewById(R$id.brand_quickreport_update_time);
        this.updateTimePoint = (TextView) view.findViewById(R$id.brand_quickreport_update_time_point);
        this.llMore = (LinearLayout) view.findViewById(R$id.brand_ll_quickreport_more);
        this.specialItem = (RelativeLayout) view.findViewById(R$id.brand_quickreport_special);
        this.specialImg = (DMPosterView) view.findViewById(R$id.brand_quickreport_special_img);
        this.specialTitle = (TextView) view.findViewById(R$id.brand_quickreport_tv_special_title);
        this.specialIpvuv = (TextView) view.findViewById(R$id.brand_quickreport_tv_special_ipuv);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.card_brand_normal_item_one);
        this.normalItemOne = relativeLayout;
        int i = R$id.brand_quickreport_normal_img;
        this.normalItemOneImg = (DMPosterView) relativeLayout.findViewById(i);
        RelativeLayout relativeLayout2 = this.normalItemOne;
        int i2 = R$id.brand_quickreport_tv_normal_title;
        this.normalItemOneTitle = (TextView) relativeLayout2.findViewById(i2);
        RelativeLayout relativeLayout3 = this.normalItemOne;
        int i3 = R$id.brand_quickreport_tv_normal_ipuv;
        this.normalItemOneIpvuv = (TextView) relativeLayout3.findViewById(i3);
        RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R$id.card_brand_normal_item_two);
        this.normalItemTwo = relativeLayout4;
        this.normalItemTwoImg = (DMPosterView) relativeLayout4.findViewById(i);
        this.normalItemTwoTitle = (TextView) this.normalItemTwo.findViewById(i2);
        this.normalItemTwoIpvuv = (TextView) this.normalItemTwo.findViewById(i3);
        this.blackHolder = view.findViewById(R$id.card_brand_normal_item_black_holder);
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public View getBlackHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1473754838") ? (View) ipChange.ipc$dispatch("1473754838", new Object[]{this}) : this.blackHolder;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getBrandLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1948232866") ? (RelativeLayout) ipChange.ipc$dispatch("-1948232866", new Object[]{this}) : this.brandLayout;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getBrandNew() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1560147046") ? (TextView) ipChange.ipc$dispatch("1560147046", new Object[]{this}) : this.brandNew;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public LinearLayout getLlMore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1065024019") ? (LinearLayout) ipChange.ipc$dispatch("-1065024019", new Object[]{this}) : this.llMore;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getNormalItemOne() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "670857827") ? (RelativeLayout) ipChange.ipc$dispatch("670857827", new Object[]{this}) : this.normalItemOne;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public DMPosterView getNormalItemOneImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1225757940") ? (DMPosterView) ipChange.ipc$dispatch("1225757940", new Object[]{this}) : this.normalItemOneImg;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemOneIpvuv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2030948453") ? (TextView) ipChange.ipc$dispatch("-2030948453", new Object[]{this}) : this.normalItemOneIpvuv;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemOneTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1537054547") ? (TextView) ipChange.ipc$dispatch("1537054547", new Object[]{this}) : this.normalItemOneTitle;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getNormalItemTwo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1846868797") ? (RelativeLayout) ipChange.ipc$dispatch("1846868797", new Object[]{this}) : this.normalItemTwo;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public DMPosterView getNormalItemTwoImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-959018418") ? (DMPosterView) ipChange.ipc$dispatch("-959018418", new Object[]{this}) : this.normalItemTwoImg;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemTwoIpvuv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1715917951") ? (TextView) ipChange.ipc$dispatch("-1715917951", new Object[]{this}) : this.normalItemTwoIpvuv;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getNormalItemTwoTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1852085049") ? (TextView) ipChange.ipc$dispatch("1852085049", new Object[]{this}) : this.normalItemTwoTitle;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public DMPosterView getSpecialImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1098871161") ? (DMPosterView) ipChange.ipc$dispatch("-1098871161", new Object[]{this}) : this.specialImg;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getSpecialIpvuv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1309112984") ? (TextView) ipChange.ipc$dispatch("-1309112984", new Object[]{this}) : this.specialIpvuv;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public RelativeLayout getSpecialItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1588313885") ? (RelativeLayout) ipChange.ipc$dispatch("-1588313885", new Object[]{this}) : this.specialItem;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getSpecialTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2036077280") ? (TextView) ipChange.ipc$dispatch("-2036077280", new Object[]{this}) : this.specialTitle;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getUpdateTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2086234583") ? (TextView) ipChange.ipc$dispatch("-2086234583", new Object[]{this}) : this.updateTime;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.View
    public TextView getUpdateTimePoint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1035194425") ? (TextView) ipChange.ipc$dispatch("1035194425", new Object[]{this}) : this.updateTimePoint;
    }
}
