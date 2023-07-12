package cn.damai.category.category.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConditionEntity implements Serializable {
    private static final long serialVersionUID = -919527383148736839L;
    public int dateType;
    public String endDate;
    public String latitude;
    public String longitude;
    public String startDate;
    public String currentCityId = z20.c();
    public int sortType = 3;
    public List<String> projectIdList = new ArrayList();
}
