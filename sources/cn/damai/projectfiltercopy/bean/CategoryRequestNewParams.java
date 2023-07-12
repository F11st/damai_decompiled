package cn.damai.projectfiltercopy.bean;

import java.io.Serializable;
import tb.gm;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CategoryRequestNewParams implements Serializable {
    private static final long serialVersionUID = 912092;
    public int cityOption;
    public String comboDispatchId;
    public int dateType;
    public String endDate;
    public String firstLevelSelection;
    public String groupId;
    public String itemId;
    public String latitude;
    public String longitude;
    public String optionParam;
    public String secondLevelSelection;
    public String startDate;
    public String currentCityId = gm.INSTANCE.a().getCityId();
    public int sortType = 3;
    public int pageIndex = 1;
    public String pageSize = "15";
}
