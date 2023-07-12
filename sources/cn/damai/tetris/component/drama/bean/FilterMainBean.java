package cn.damai.tetris.component.drama.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class FilterMainBean implements Serializable {
    public int id;
    public boolean isSelected;
    public List<FilterTagBean> labels;
    public String name;

    public FilterMainBean() {
        this.isSelected = false;
    }

    public FilterMainBean(String str, boolean z) {
        this.isSelected = false;
        this.name = str;
        this.isSelected = z;
    }

    public FilterMainBean(int i, String str, boolean z) {
        this.isSelected = false;
        this.id = i;
        this.name = str;
        this.isSelected = z;
    }
}
