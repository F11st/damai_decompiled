package cn.damai.category.category.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = -4523206817754221234L;
    public String categoryName;
    public boolean isSelected;
    public String subCategoryId;
    public String subName;
    public int subNum;
    public String categoryId = "0";
    public int index = 0;
    public int subIndex = 0;
}
