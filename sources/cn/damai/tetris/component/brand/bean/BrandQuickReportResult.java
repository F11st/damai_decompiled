package cn.damai.tetris.component.brand.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BrandQuickReportResult implements Serializable {
    private static final long serialVersionUID = 1;
    public String brandNew;
    public ArrayList<BrandQuickReportContentBean> contents;
    private boolean hasNext;
    public String latestPublishTimeStr;
    public String schema;
    public String total;
}
