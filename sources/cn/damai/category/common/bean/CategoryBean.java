package cn.damai.category.common.bean;

import cn.damai.category.category.bean.SubCategory;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryBean implements Serializable {
    private static final long serialVersionUID = 8499530670854957651L;
    public int count;
    public String id;
    public String name;
    public String pic;
    public List<SubCategory> subCategories;
}
