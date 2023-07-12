package cn.damai.tetris.component.brand;

import cn.damai.tetris.component.brand.BrandQuickReportContract;
import cn.damai.tetris.component.brand.bean.BrandQuickReportContentBean;
import cn.damai.tetris.component.brand.bean.BrandQuickReportResult;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BrandQuickReportModel extends AbsModel implements BrandQuickReportContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private String brandNew;
    private ArrayList<BrandQuickReportContentBean> contents;
    private String latestPublishTimeStr;
    private String schema;
    private String total;

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.Model
    public String getBrandNew() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-712752100") ? (String) ipChange.ipc$dispatch("-712752100", new Object[]{this}) : this.brandNew;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.Model
    public ArrayList<BrandQuickReportContentBean> getContents() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1113334979") ? (ArrayList) ipChange.ipc$dispatch("-1113334979", new Object[]{this}) : this.contents;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.Model
    public String getLatestPublishTimeStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "732823423") ? (String) ipChange.ipc$dispatch("732823423", new Object[]{this}) : this.latestPublishTimeStr;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.Model
    public String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1056575708") ? (String) ipChange.ipc$dispatch("-1056575708", new Object[]{this}) : this.schema;
    }

    @Override // cn.damai.tetris.component.brand.BrandQuickReportContract.Model
    public String getTotal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1369356759") ? (String) ipChange.ipc$dispatch("1369356759", new Object[]{this}) : this.total;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803819896")) {
            ipChange.ipc$dispatch("803819896", new Object[]{this, baseNode});
            return;
        }
        try {
            BrandQuickReportResult brandQuickReportResult = (BrandQuickReportResult) JSON.parseObject(baseNode.getItem().toJSONString(), BrandQuickReportResult.class);
            this.brandNew = brandQuickReportResult.brandNew;
            this.latestPublishTimeStr = brandQuickReportResult.latestPublishTimeStr;
            this.schema = brandQuickReportResult.schema;
            this.total = brandQuickReportResult.total;
            this.contents = brandQuickReportResult.contents;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
