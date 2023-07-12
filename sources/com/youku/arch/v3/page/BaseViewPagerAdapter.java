package com.youku.arch.v3.page;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.event.ActivityEventPoster;
import com.youku.arch.v3.util.LogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 N2\u00020\u0001:\u0001NB\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\bL\u0010MJ&\u0010\t\u001a\u00020\b2\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H$J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0006H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010%\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u00162\u0006\u0010&\u001a\u00020\u0006R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u0001018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R%\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR(\u0010D\u001a\u0004\u0018\u00010\u00042\b\u0010C\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0013\u0010I\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\bH\u0010GR!\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bJ\u0010B¨\u0006O"}, d2 = {"Lcom/youku/arch/v3/page/BaseViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/util/SparseArray;", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "sparseArray", "", "size", "Ltb/wt2;", "incrSize", "position", "getFragment", "getActualFragment", "getItem", "getCount", "Lcom/youku/arch/v3/event/ActivityEventPoster;", "interceptor", "setInterceptor", "createFragment", "Landroid/view/ViewGroup;", "container", "startUpdate", "", "instantiateItem", "object", "destroyItem", "setPrimaryItem", "finishUpdate", "Landroid/view/View;", "view", "", "isViewFromObject", "Landroid/os/Parcelable;", "saveState", "state", "Ljava/lang/ClassLoader;", "loader", "restoreState", "pos", "getData", "Landroidx/fragment/app/FragmentManager;", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "activityEventPoster", "Lcom/youku/arch/v3/event/ActivityEventPoster;", "getActivityEventPoster", "()Lcom/youku/arch/v3/event/ActivityEventPoster;", "setActivityEventPoster", "(Lcom/youku/arch/v3/event/ActivityEventPoster;)V", "", "dataset", "Ljava/util/List;", "getDataset", "()Ljava/util/List;", "setDataset", "(Ljava/util/List;)V", "Landroidx/fragment/app/FragmentTransaction;", "mCurTransaction", "Landroidx/fragment/app/FragmentTransaction;", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment$SavedState;", "mSavedState", "Ljava/util/ArrayList;", "fragments", "Landroid/util/SparseArray;", "getFragments", "()Landroid/util/SparseArray;", "<set-?>", "currentPrimaryItem", "Landroidx/fragment/app/Fragment;", "getCurrentPrimaryItem", "()Landroidx/fragment/app/Fragment;", "getActualCurrentPrimaryItem", "actualCurrentPrimaryItem", "getActualFragments", "actualFragments", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class BaseViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final boolean DEBUG = false;
    @NotNull
    private static final String TAG = "OneArch.GenericViewPagerAdapter";
    @Nullable
    private ActivityEventPoster activityEventPoster;
    @Nullable
    private Fragment currentPrimaryItem;
    @Nullable
    private List<?> dataset;
    @NotNull
    private final SparseArray<WeakReference<Fragment>> fragments;
    @Nullable
    private FragmentTransaction mCurTransaction;
    @NotNull
    private final FragmentManager mFragmentManager;
    @NotNull
    private final ArrayList<Fragment.SavedState> mSavedState;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/page/BaseViewPagerAdapter$Companion;", "", "", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public BaseViewPagerAdapter(@NotNull FragmentManager fragmentManager) {
        b41.i(fragmentManager, "mFragmentManager");
        this.mFragmentManager = fragmentManager;
        this.mSavedState = new ArrayList<>();
        this.fragments = new SparseArray<>();
    }

    private final void incrSize(SparseArray<WeakReference<Fragment>> sparseArray, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1620646051")) {
            ipChange.ipc$dispatch("1620646051", new Object[]{this, sparseArray, Integer.valueOf(i)});
        } else if (i < 0) {
        } else {
            while (true) {
                int i3 = i2 + 1;
                b41.f(sparseArray);
                if (sparseArray.size() <= i2) {
                    sparseArray.append(i2, new WeakReference<>(null));
                }
                if (i2 == i) {
                    return;
                }
                i2 = i3;
            }
        }
    }

    @NotNull
    protected abstract Fragment createFragment(int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085805067")) {
            ipChange.ipc$dispatch("-2085805067", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        b41.i(viewGroup, "container");
        b41.i(obj, "object");
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        while (this.mSavedState.size() <= i) {
            this.mSavedState.add(null);
        }
        this.mSavedState.set(i, fragment.isAdded() ? this.mFragmentManager.saveFragmentInstanceState(fragment) : null);
        this.fragments.put(i, new WeakReference<>(null));
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        b41.f(fragmentTransaction);
        fragmentTransaction.remove(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NotNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202317611")) {
            ipChange.ipc$dispatch("-1202317611", new Object[]{this, viewGroup});
            return;
        }
        b41.i(viewGroup, "container");
        try {
            FragmentTransaction fragmentTransaction = this.mCurTransaction;
            if (fragmentTransaction != null) {
                b41.f(fragmentTransaction);
                fragmentTransaction.commitNowAllowingStateLoss();
                this.mCurTransaction = null;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final ActivityEventPoster getActivityEventPoster() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "177413483") ? (ActivityEventPoster) ipChange.ipc$dispatch("177413483", new Object[]{this}) : this.activityEventPoster;
    }

    @NotNull
    public final Fragment getActualCurrentPrimaryItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680327242")) {
            return (Fragment) ipChange.ipc$dispatch("-680327242", new Object[]{this});
        }
        Fragment fragment = this.currentPrimaryItem;
        if (!(fragment instanceof LazyLoadFragment)) {
            b41.f(fragment);
            return fragment;
        }
        Objects.requireNonNull(fragment, "null cannot be cast to non-null type com.youku.arch.v3.page.LazyLoadFragment");
        Fragment childFragment = ((LazyLoadFragment) fragment).getChildFragment();
        b41.h(childFragment, "currentPrimaryItem as La…adFragment).childFragment");
        return childFragment;
    }

    @NotNull
    public final Fragment getActualFragment(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12097263")) {
            return (Fragment) ipChange.ipc$dispatch("12097263", new Object[]{this, Integer.valueOf(i)});
        }
        Fragment fragment = getFragment(i);
        if (!(fragment instanceof LazyLoadFragment)) {
            b41.f(fragment);
            return fragment;
        }
        Fragment childFragment = ((LazyLoadFragment) fragment).getChildFragment();
        b41.h(childFragment, "fragment.childFragment");
        return childFragment;
    }

    @NotNull
    public final SparseArray<WeakReference<Fragment>> getActualFragments() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1462209958")) {
            return (SparseArray) ipChange.ipc$dispatch("1462209958", new Object[]{this});
        }
        SparseArray<WeakReference<Fragment>> sparseArray = new SparseArray<>(this.fragments.size());
        int size = this.fragments.size();
        if (size > 0) {
            while (true) {
                int i2 = i + 1;
                WeakReference<Fragment> valueAt = this.fragments.valueAt(i);
                Fragment fragment = valueAt == null ? null : valueAt.get();
                if (fragment instanceof LazyLoadFragment) {
                    valueAt = new WeakReference<>(((LazyLoadFragment) fragment).getChildFragment());
                }
                sparseArray.put(this.fragments.keyAt(i), valueAt);
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return sparseArray;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744588340")) {
            return ((Integer) ipChange.ipc$dispatch("-1744588340", new Object[]{this})).intValue();
        }
        if (getDataset() != null) {
            List<?> dataset = getDataset();
            b41.f(dataset);
            return dataset.size();
        }
        return 0;
    }

    @Nullable
    public final Fragment getCurrentPrimaryItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "97337160") ? (Fragment) ipChange.ipc$dispatch("97337160", new Object[]{this}) : this.currentPrimaryItem;
    }

    @Nullable
    public final Object getData(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654236185")) {
            return ipChange.ipc$dispatch("-1654236185", new Object[]{this, Integer.valueOf(i)});
        }
        if (getDataset() != null) {
            List<?> dataset = getDataset();
            b41.f(dataset);
            if (dataset.size() > i && i >= 0) {
                List<?> dataset2 = getDataset();
                b41.f(dataset2);
                return dataset2.get(i);
            }
        }
        return null;
    }

    @Nullable
    public List<?> getDataset() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "786534199") ? (List) ipChange.ipc$dispatch("786534199", new Object[]{this}) : this.dataset;
    }

    @Nullable
    public final Fragment getFragment(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537199331")) {
            return (Fragment) ipChange.ipc$dispatch("-1537199331", new Object[]{this, Integer.valueOf(i)});
        }
        if (i < 0 || this.fragments.size() <= i || this.fragments.valueAt(i) == null) {
            return null;
        }
        WeakReference<Fragment> valueAt = this.fragments.valueAt(i);
        b41.f(valueAt);
        return valueAt.get();
    }

    @NotNull
    public final SparseArray<WeakReference<Fragment>> getFragments() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1191928916") ? (SparseArray) ipChange.ipc$dispatch("1191928916", new Object[]{this}) : this.fragments;
    }

    @Nullable
    public final Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577321466")) {
            return (Fragment) ipChange.ipc$dispatch("577321466", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.fragments.size() > i && this.fragments.valueAt(i) != null) {
            WeakReference<Fragment> valueAt = this.fragments.valueAt(i);
            b41.f(valueAt);
            if (valueAt.get() != null) {
                LogUtil.d(TAG, b41.r("getItem from cache ", Integer.valueOf(i)));
                WeakReference<Fragment> valueAt2 = this.fragments.valueAt(i);
                b41.f(valueAt2);
                return valueAt2.get();
            }
        }
        LogUtil.d(TAG, b41.r("getItem to new ", Integer.valueOf(i)));
        return createFragment(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319730569")) {
            return ipChange.ipc$dispatch("1319730569", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "container");
        if (this.fragments.size() > i) {
            if (this.fragments.valueAt(i) != null) {
                WeakReference<Fragment> valueAt = this.fragments.valueAt(i);
                b41.f(valueAt);
                fragment = valueAt.get();
            } else {
                fragment = null;
            }
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        Fragment item = getItem(i);
        b41.f(item);
        if (this.mSavedState.size() > i && (savedState = this.mSavedState.get(i)) != null && !item.isAdded()) {
            item.setInitialSavedState(savedState);
        }
        incrSize(this.fragments, i);
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.fragments.setValueAt(i, new WeakReference<>(item));
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        b41.f(fragmentTransaction);
        fragmentTransaction.add(viewGroup.getId(), item);
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1193642104")) {
            return ((Boolean) ipChange.ipc$dispatch("1193642104", new Object[]{this, view, obj})).booleanValue();
        }
        b41.i(view, "view");
        b41.i(obj, "object");
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        boolean F;
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305760570")) {
            ipChange.ipc$dispatch("-1305760570", new Object[]{this, parcelable, classLoader});
        } else if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.fragments.clear();
            if (parcelableArray != null && parcelableArray.length - 1 >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    ArrayList<Fragment.SavedState> arrayList = this.mSavedState;
                    Parcelable parcelable2 = parcelableArray[i];
                    Objects.requireNonNull(parcelable2, "null cannot be cast to non-null type androidx.fragment.app.Fragment.SavedState");
                    arrayList.add((Fragment.SavedState) parcelable2);
                    if (i2 > length) {
                        break;
                    }
                    i = i2;
                }
            }
            Set<String> keySet = bundle.keySet();
            b41.h(keySet, "bundle.keySet()");
            for (String str : keySet) {
                F = o.F(str, "f", false, 2, null);
                if (F) {
                    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(1);
                    b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                    int parseInt = Integer.parseInt(substring);
                    Fragment fragment = this.mFragmentManager.getFragment(bundle, str);
                    if (fragment != null) {
                        incrSize(this.fragments, parseInt);
                        fragment.setMenuVisibility(false);
                        this.fragments.setValueAt(parseInt, new WeakReference<>(fragment));
                    } else {
                        LogUtil.w(TAG, b41.r("Bad fragment at key ", str));
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        Fragment fragment;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2016169255")) {
            return (Parcelable) ipChange.ipc$dispatch("2016169255", new Object[]{this});
        }
        Bundle bundle = null;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        int size = this.fragments.size();
        if (size > 0) {
            while (true) {
                int i2 = i + 1;
                WeakReference<Fragment> valueAt = this.fragments.valueAt(i);
                if (valueAt != null && (fragment = valueAt.get()) != null && fragment.isAdded()) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    this.mFragmentManager.putFragment(bundle, b41.r("f", Integer.valueOf(i)), fragment);
                }
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return bundle;
    }

    public final void setActivityEventPoster(@Nullable ActivityEventPoster activityEventPoster) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119292239")) {
            ipChange.ipc$dispatch("119292239", new Object[]{this, activityEventPoster});
        } else {
            this.activityEventPoster = activityEventPoster;
        }
    }

    public void setDataset(@Nullable List<?> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009670669")) {
            ipChange.ipc$dispatch("2009670669", new Object[]{this, list});
        } else {
            this.dataset = list;
        }
    }

    public final void setInterceptor(@Nullable ActivityEventPoster activityEventPoster) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "549889148")) {
            ipChange.ipc$dispatch("549889148", new Object[]{this, activityEventPoster});
        } else {
            this.activityEventPoster = activityEventPoster;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285737313")) {
            ipChange.ipc$dispatch("285737313", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        b41.i(viewGroup, "container");
        b41.i(obj, "object");
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.currentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                b41.f(fragment2);
                fragment2.setMenuVisibility(false);
                Fragment fragment3 = this.currentPrimaryItem;
                b41.f(fragment3);
                fragment3.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.currentPrimaryItem = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NotNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1611403148")) {
            ipChange.ipc$dispatch("1611403148", new Object[]{this, viewGroup});
            return;
        }
        b41.i(viewGroup, "container");
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException(("ViewPager with adapter " + this + " requires a view id").toString());
    }
}
