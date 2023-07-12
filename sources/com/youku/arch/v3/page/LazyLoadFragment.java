package com.youku.arch.v3.page;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LazyLoadFragment extends Fragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "LazyLoadFragment";
    private Fragment mChildFragment;
    private boolean mRenderAttached = false;
    private boolean isFragmentVisible = false;
    private boolean isViewCreated = false;

    private void bindRenderFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044622537")) {
            ipChange.ipc$dispatch("-2044622537", new Object[]{this});
        } else if (this.mRenderAttached) {
        } else {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.onearch_lazy_load_fragment, this.mChildFragment);
            beginTransaction.commit();
            this.mChildFragment.setUserVisibleHint(true);
            this.mRenderAttached = true;
        }
    }

    private void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092024000")) {
            ipChange.ipc$dispatch("-1092024000", new Object[]{this});
            return;
        }
        Log.d(TAG, "lazyLoad");
        if (this.isViewCreated && this.isFragmentVisible) {
            Log.d(TAG, "lazyLoad enter in logic process");
            bindRenderFragment();
        }
    }

    public Fragment getChildFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1853798442") ? (Fragment) ipChange.ipc$dispatch("1853798442", new Object[]{this}) : this.mChildFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770913259")) {
            ipChange.ipc$dispatch("-1770913259", new Object[]{this, bundle});
            return;
        }
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        Log.d(TAG, "onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68658767")) {
            return (View) ipChange.ipc$dispatch("68658767", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        Log.d(TAG, "onCreateView");
        return layoutInflater.inflate(R.C7804layout.onearch_fragment_lazy_load, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583167851")) {
            ipChange.ipc$dispatch("-1583167851", new Object[]{this});
            return;
        }
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        this.isFragmentVisible = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559786576")) {
            ipChange.ipc$dispatch("-559786576", new Object[]{this});
            return;
        }
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
        this.isFragmentVisible = false;
        this.isViewCreated = false;
        this.mRenderAttached = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399931346")) {
            ipChange.ipc$dispatch("-1399931346", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        Log.d(TAG, "onViewCreated");
        this.isViewCreated = true;
        lazyLoad();
    }

    public void setChildFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046574744")) {
            ipChange.ipc$dispatch("-2046574744", new Object[]{this, fragment});
        } else {
            this.mChildFragment = fragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441266458")) {
            ipChange.ipc$dispatch("-1441266458", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        Log.d(TAG, "setUserVisibleHint:" + z);
        this.isFragmentVisible = z;
        if (z) {
            lazyLoad();
        }
        Fragment fragment = this.mChildFragment;
        if (fragment == null || !fragment.isAdded()) {
            return;
        }
        this.mChildFragment.setUserVisibleHint(z);
    }
}
