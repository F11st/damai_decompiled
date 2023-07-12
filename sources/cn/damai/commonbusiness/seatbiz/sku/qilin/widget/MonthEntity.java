package cn.damai.commonbusiness.seatbiz.sku.qilin.widget;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MonthEntity implements Serializable {
    private static final long serialVersionUID = -8894216253807048535L;
    public List<DayEntity> days;
    public int index;
    public boolean isSelected;
    public boolean isShowYear;
    public int month;
    public int year;
}
