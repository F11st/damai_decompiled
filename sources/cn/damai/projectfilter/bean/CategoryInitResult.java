package cn.damai.projectfilter.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CategoryInitResult implements Serializable {
    public CategoryLevelTwo mInitSelectTwo;
    @NonNull
    public HashMap<String, CategoryLevelOne> mOneMap = new HashMap<>();
    @Nullable
    public CategoryLevelTwo mResetSelectTwo;
    @Nullable
    public CategoryLevelTwo mTwoAll;
}
