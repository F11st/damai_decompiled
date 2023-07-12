package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarBean implements Serializable {
    private static final long serialVersionUID = -5026024649237355533L;
    public String currentPerformId;
    public List<DateBean> dateViews;
    public String performDesc;
    public List<PerformSummaryBean> performViews;
    public boolean showDates;
    public String today;
}
