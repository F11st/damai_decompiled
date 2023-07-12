package cn.damai.projectfilter.model;

import cn.damai.common.util.ToastUtil;
import cn.damai.projectfilter.bean.CategoryInitResult;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import cn.damai.projectfilter.bean.PresetBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.mu0;
import tb.rd;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class CategoryDataAssembler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MAX_SELECT_COUNT = 10;
    @Nullable
    private List<CategoryLevelOne> mCategoryList;
    @Nullable
    private CategoryLevelTwo mInitSelectTwo;
    @Nullable
    private OnCategoryUpdateListener mListener;
    @Nullable
    private CategoryLevelTwo mResetSelectTwo;
    @Nullable
    private CategoryLevelTwo mTwoAll;
    @NotNull
    private final HashSet<CategoryLevelTwo> mSelectTwosUsed4UiSet = new HashSet<>();
    @NotNull
    private final ArrayList<CategoryLevelOne> mSelectUsed4RequestList = new ArrayList<>();
    @NotNull
    private final HashMap<String, CategoryLevelOne> mPid2LevelOneMap = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public static /* synthetic */ void doReset$default(CategoryDataAssembler categoryDataAssembler, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        categoryDataAssembler.doReset(z);
    }

    public static /* synthetic */ void selectOne$default(CategoryDataAssembler categoryDataAssembler, CategoryLevelOne categoryLevelOne, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        categoryDataAssembler.selectOne(categoryLevelOne, z);
    }

    public static /* synthetic */ boolean selectTwo$default(CategoryDataAssembler categoryDataAssembler, CategoryLevelTwo categoryLevelTwo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return categoryDataAssembler.selectTwo(categoryLevelTwo, z);
    }

    public final void doConfirm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238172135")) {
            ipChange.ipc$dispatch("238172135", new Object[]{this});
            return;
        }
        this.mSelectUsed4RequestList.clear();
        for (CategoryLevelTwo categoryLevelTwo : this.mSelectTwosUsed4UiSet) {
            CategoryLevelOne categoryLevelOne = this.mPid2LevelOneMap.get(categoryLevelTwo.parentValue);
            if (categoryLevelOne != null) {
                int indexOf = this.mSelectUsed4RequestList.indexOf(categoryLevelOne);
                if (indexOf >= 0) {
                    List<CategoryLevelTwo> list = this.mSelectUsed4RequestList.get(indexOf).lineItemList;
                    if (list != null) {
                        list.add(categoryLevelTwo);
                    }
                } else {
                    CategoryLevelOne cloneWithoutChild = categoryLevelOne.cloneWithoutChild();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(categoryLevelTwo);
                    cloneWithoutChild.lineItemList = arrayList;
                    this.mSelectUsed4RequestList.add(cloneWithoutChild);
                }
            }
        }
    }

    public final void doMatchIfNeed() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1491416785")) {
            ipChange.ipc$dispatch("-1491416785", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CategoryLevelOne categoryLevelOne : this.mSelectUsed4RequestList) {
            List<CategoryLevelTwo> list = categoryLevelOne.lineItemList;
            if (!(list == null || list.isEmpty())) {
                arrayList.addAll(categoryLevelOne.lineItemList);
            }
        }
        for (CategoryLevelTwo categoryLevelTwo : this.mSelectTwosUsed4UiSet) {
            arrayList2.add(categoryLevelTwo);
        }
        if (arrayList.size() == arrayList2.size()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!arrayList2.contains((CategoryLevelTwo) it.next())) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            doReset(false);
            for (CategoryLevelOne categoryLevelOne2 : this.mSelectUsed4RequestList) {
                List<CategoryLevelTwo> list2 = categoryLevelOne2.lineItemList;
                if (list2 != null) {
                    b41.h(list2, "lineItemList");
                    for (CategoryLevelTwo categoryLevelTwo2 : list2) {
                        b41.h(categoryLevelTwo2, AdvanceSetting.NETWORK_TYPE);
                        selectTwo(categoryLevelTwo2, false);
                    }
                }
            }
            List<CategoryLevelOne> list3 = this.mCategoryList;
            if (list3 != null) {
                for (CategoryLevelOne categoryLevelOne3 : list3) {
                    if (this.mSelectUsed4RequestList.contains(categoryLevelOne3)) {
                        selectOne$default(this, categoryLevelOne3, false, 2, null);
                        return;
                    }
                }
            }
        }
    }

    public final void doReset(boolean z) {
        OnCategoryUpdateListener onCategoryUpdateListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340408924")) {
            ipChange.ipc$dispatch("340408924", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        for (CategoryLevelTwo categoryLevelTwo : this.mSelectTwosUsed4UiSet) {
            categoryLevelTwo.select = false;
        }
        this.mSelectTwosUsed4UiSet.clear();
        CategoryLevelTwo categoryLevelTwo2 = this.mResetSelectTwo;
        if (categoryLevelTwo2 != null) {
            selectTwo$default(this, categoryLevelTwo2, false, 2, null);
        }
        if (!z || (onCategoryUpdateListener = this.mListener) == null) {
            return;
        }
        onCategoryUpdateListener.categoryUpdate(getUpdate());
    }

    @NotNull
    public final String getBtnText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1008869307")) {
            return (String) ipChange.ipc$dispatch("-1008869307", new Object[]{this});
        }
        String str = "品类";
        if (this.mSelectUsed4RequestList.size() != 0) {
            try {
                str = rd.h(this.mCategoryList, this.mSelectUsed4RequestList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            b41.h(str, "{\n            try {\n    …\"\n            }\n        }");
        }
        return str;
    }

    @Nullable
    public final OnCategoryUpdateListener getMListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-434758245") ? (OnCategoryUpdateListener) ipChange.ipc$dispatch("-434758245", new Object[]{this}) : this.mListener;
    }

    @NotNull
    public final ArrayList<CategoryLevelOne> getSelect4Request() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "408786505") ? (ArrayList) ipChange.ipc$dispatch("408786505", new Object[]{this}) : this.mSelectUsed4RequestList;
    }

    @NotNull
    public final CategoryUpdate getUpdate() {
        List<CategoryLevelTwo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-132659576")) {
            return (CategoryUpdate) ipChange.ipc$dispatch("-132659576", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<CategoryLevelOne> list2 = this.mCategoryList;
        if (list2 != null) {
            for (CategoryLevelOne categoryLevelOne : list2) {
                categoryLevelOne.updateTag();
                arrayList.add(categoryLevelOne.cloneWithoutChild());
                if (categoryLevelOne.select && (list = categoryLevelOne.lineItemList) != null) {
                    b41.h(list, "lineItemList");
                    for (CategoryLevelTwo categoryLevelTwo : list) {
                        Object clone = categoryLevelTwo.clone();
                        b41.g(clone, "null cannot be cast to non-null type cn.damai.projectfilter.bean.CategoryLevelTwo");
                        arrayList2.add((CategoryLevelTwo) clone);
                    }
                }
            }
        }
        return new CategoryUpdate(arrayList, arrayList2);
    }

    public final int indexOneSelect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539171535")) {
            return ((Integer) ipChange.ipc$dispatch("-1539171535", new Object[]{this})).intValue();
        }
        List<CategoryLevelOne> list = this.mCategoryList;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).select) {
                    return i;
                }
            }
            return 0;
        }
        return 0;
    }

    public final void init(@Nullable List<CategoryLevelOne> list, @NotNull PresetBean presetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307046871")) {
            ipChange.ipc$dispatch("-1307046871", new Object[]{this, list, presetBean});
            return;
        }
        b41.i(presetBean, "presetBean");
        this.mCategoryList = list;
        CategoryInitResult init = CategoryLevelOne.init(list, presetBean);
        this.mTwoAll = init.mTwoAll;
        this.mResetSelectTwo = init.mResetSelectTwo;
        this.mInitSelectTwo = init.mInitSelectTwo;
        this.mPid2LevelOneMap.putAll(init.mOneMap);
        List<CategoryLevelOne> list2 = this.mCategoryList;
        if (list2 != null && list2.size() > 0) {
            selectOne$default(this, list2.get(0), false, 2, null);
            CategoryLevelTwo categoryLevelTwo = this.mInitSelectTwo;
            if (categoryLevelTwo != null) {
                selectTwo$default(this, categoryLevelTwo, false, 2, null);
            }
        }
        doConfirm();
    }

    public final void selectOne(@NotNull CategoryLevelOne categoryLevelOne, boolean z) {
        OnCategoryUpdateListener onCategoryUpdateListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791636455")) {
            ipChange.ipc$dispatch("-791636455", new Object[]{this, categoryLevelOne, Boolean.valueOf(z)});
            return;
        }
        b41.i(categoryLevelOne, "oneClone");
        if (categoryLevelOne.select) {
            return;
        }
        List<CategoryLevelOne> list = this.mCategoryList;
        if (list != null) {
            for (CategoryLevelOne categoryLevelOne2 : list) {
                categoryLevelOne2.select = categoryLevelOne2.equals(categoryLevelOne);
            }
        }
        if (!z || (onCategoryUpdateListener = this.mListener) == null) {
            return;
        }
        onCategoryUpdateListener.categoryUpdate(getUpdate());
    }

    public final boolean selectTwo(@NotNull CategoryLevelTwo categoryLevelTwo, boolean z) {
        OnCategoryUpdateListener onCategoryUpdateListener;
        OnCategoryUpdateListener onCategoryUpdateListener2;
        CategoryLevelTwo categoryLevelTwo2;
        OnCategoryUpdateListener onCategoryUpdateListener3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345352855")) {
            return ((Boolean) ipChange.ipc$dispatch("-345352855", new Object[]{this, categoryLevelTwo, Boolean.valueOf(z)})).booleanValue();
        }
        b41.i(categoryLevelTwo, "twoClone");
        List<CategoryLevelOne> list = this.mCategoryList;
        if (list == null || list.isEmpty()) {
            return false;
        }
        if (categoryLevelTwo.isAllFilter()) {
            if (categoryLevelTwo.select) {
                return false;
            }
            for (CategoryLevelTwo categoryLevelTwo3 : this.mSelectTwosUsed4UiSet) {
                categoryLevelTwo3.select = false;
            }
            this.mSelectTwosUsed4UiSet.clear();
            CategoryLevelOne categoryLevelOne = this.mPid2LevelOneMap.get(categoryLevelTwo.parentValue);
            if (categoryLevelOne != null) {
                categoryLevelOne.countOrSelectUpdate(categoryLevelTwo, true, false);
            }
            if (z && (onCategoryUpdateListener3 = this.mListener) != null) {
                onCategoryUpdateListener3.categoryUpdate(getUpdate());
            }
            return true;
        }
        CategoryLevelOne categoryLevelOne2 = this.mPid2LevelOneMap.get(categoryLevelTwo.parentValue);
        if (categoryLevelOne2 != null) {
            if (categoryLevelTwo.select) {
                categoryLevelOne2.countOrSelectUpdate(categoryLevelTwo, false, false);
                this.mSelectTwosUsed4UiSet.remove(categoryLevelTwo);
                if (this.mSelectTwosUsed4UiSet.size() == 0 && (categoryLevelTwo2 = this.mResetSelectTwo) != null) {
                    if (categoryLevelTwo2.isAllFilter()) {
                        categoryLevelTwo2.select = true;
                    } else {
                        selectTwo$default(this, categoryLevelTwo2, false, 2, null);
                    }
                }
                CategoryLevelTwo categoryLevelTwo4 = this.mTwoAll;
                if (categoryLevelTwo4 != null) {
                    categoryLevelTwo4.select = this.mSelectTwosUsed4UiSet.size() == 0;
                }
                if (z && (onCategoryUpdateListener2 = this.mListener) != null) {
                    onCategoryUpdateListener2.categoryUpdate(getUpdate());
                }
                return true;
            } else if (categoryLevelOne2.countOrSelectUpdate(categoryLevelTwo, true, true) + this.mSelectTwosUsed4UiSet.size() > 10) {
                if (z) {
                    ToastUtil.a().j(mu0.a(), "最多可选10个");
                }
                return false;
            } else {
                categoryLevelOne2.countOrSelectUpdate(categoryLevelTwo, true, false);
                List<CategoryLevelTwo> list2 = categoryLevelOne2.lineItemList;
                if (list2 != null) {
                    b41.h(list2, "lineItemList");
                    for (CategoryLevelTwo categoryLevelTwo5 : list2) {
                        if (categoryLevelTwo5.select) {
                            this.mSelectTwosUsed4UiSet.add(categoryLevelTwo5);
                        } else {
                            this.mSelectTwosUsed4UiSet.remove(categoryLevelTwo5);
                        }
                    }
                }
                CategoryLevelTwo categoryLevelTwo6 = this.mTwoAll;
                if (categoryLevelTwo6 != null) {
                    categoryLevelTwo6.select = this.mSelectTwosUsed4UiSet.size() == 0;
                }
                if (z && (onCategoryUpdateListener = this.mListener) != null) {
                    onCategoryUpdateListener.categoryUpdate(getUpdate());
                }
                return true;
            }
        }
        return false;
    }

    public final void setMListener(@Nullable OnCategoryUpdateListener onCategoryUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015488839")) {
            ipChange.ipc$dispatch("-1015488839", new Object[]{this, onCategoryUpdateListener});
        } else {
            this.mListener = onCategoryUpdateListener;
        }
    }
}
