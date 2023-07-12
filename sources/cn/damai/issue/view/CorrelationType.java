package cn.damai.issue.view;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public enum CorrelationType {
    STORE(0, "家店铺可选", "关联店铺", "目前暂无可选店铺", false),
    SCRIPT(1, "个剧本可选", "关联剧本", "目前暂无可选剧本", true);
    
    @NotNull
    private final String des;
    @NotNull
    private final String nullDes;
    private final boolean required;
    @NotNull
    private final String title;
    private final int type;

    CorrelationType(int i, String str, String str2, String str3, boolean z) {
        this.type = i;
        this.des = str;
        this.title = str2;
        this.nullDes = str3;
        this.required = z;
    }

    @NotNull
    public final String getDes() {
        return this.des;
    }

    @NotNull
    public final String getNullDes() {
        return this.nullDes;
    }

    public final boolean getRequired() {
        return this.required;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }
}
