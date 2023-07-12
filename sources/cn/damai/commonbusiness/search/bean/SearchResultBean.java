package cn.damai.commonbusiness.search.bean;

import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class SearchResultBean implements Serializable {
    public ArrayList<BaccountInfo> baccountInfo;
    public String baccountMoreMessage;
    public List<BrandOptimizationDO> brandOptimization;
    public long currentTime;
    public String discountInfo;
    public List<ProjectItemBean> projectInfo;
    public RepertoireBean repertoireInfoDO;
    public StarBean starInfoDO;
    public List<ProjectItemBean> suggestProjectInfo;
    public int total;
    public SearchTourBean tour;
}
