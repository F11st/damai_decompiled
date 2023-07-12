package com.taobao.weex.devtools.common.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import com.taobao.weex.devtools.common.android.FragmentCompat;
import javax.annotation.Nullable;

/* compiled from: Taobao */
@TargetApi(11)
/* loaded from: classes11.dex */
final class FragmentCompatFramework extends FragmentCompat<Fragment, DialogFragment, FragmentManager, Activity> {
    private static final DialogFragmentAccessorFramework sDialogFragmentAccessor;
    private static final FragmentAccessorFrameworkHoneycomb sFragmentAccessor;
    private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection<>();
    private static final FragmentActivityAccessorFramework sFragmentActivityAccessor = new FragmentActivityAccessorFramework();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DialogFragmentAccessorFramework implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> {
        private final FragmentAccessor<Fragment, FragmentManager> mFragmentAccessor;

        public DialogFragmentAccessorFramework(FragmentAccessor<Fragment, FragmentManager> fragmentAccessor) {
            this.mFragmentAccessor = fragmentAccessor;
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return this.mFragmentAccessor.getChildFragmentManager(fragment);
        }

        @Override // com.taobao.weex.devtools.common.android.DialogFragmentAccessor
        public Dialog getDialog(DialogFragment dialogFragment) {
            return dialogFragment.getDialog();
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public FragmentManager getFragmentManager(Fragment fragment) {
            return this.mFragmentAccessor.getFragmentManager(fragment);
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        public int getId(Fragment fragment) {
            return this.mFragmentAccessor.getId(fragment);
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        public Resources getResources(Fragment fragment) {
            return this.mFragmentAccessor.getResources(fragment);
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public String getTag(Fragment fragment) {
            return this.mFragmentAccessor.getTag(fragment);
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public View getView(Fragment fragment) {
            return this.mFragmentAccessor.getView(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class FragmentAccessorFrameworkHoneycomb implements FragmentAccessor<Fragment, FragmentManager> {
        private FragmentAccessorFrameworkHoneycomb() {
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return null;
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public FragmentManager getFragmentManager(Fragment fragment) {
            return fragment.getFragmentManager();
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        public int getId(Fragment fragment) {
            return fragment.getId();
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        public Resources getResources(Fragment fragment) {
            return fragment.getResources();
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public String getTag(Fragment fragment) {
            return fragment.getTag();
        }

        @Override // com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public View getView(Fragment fragment) {
            return fragment.getView();
        }
    }

    /* compiled from: Taobao */
    @TargetApi(17)
    /* loaded from: classes11.dex */
    private static class FragmentAccessorFrameworkJellyBean extends FragmentAccessorFrameworkHoneycomb {
        private FragmentAccessorFrameworkJellyBean() {
            super();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.devtools.common.android.FragmentCompatFramework.FragmentAccessorFrameworkHoneycomb, com.taobao.weex.devtools.common.android.FragmentAccessor
        @Nullable
        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return fragment.getChildFragmentManager();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class FragmentActivityAccessorFramework implements FragmentActivityAccessor<Activity, FragmentManager> {
        private FragmentActivityAccessorFramework() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.devtools.common.android.FragmentActivityAccessor
        @Nullable
        public FragmentManager getFragmentManager(Activity activity) {
            return activity.getFragmentManager();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            sFragmentAccessor = new FragmentAccessorFrameworkJellyBean();
        } else {
            sFragmentAccessor = new FragmentAccessorFrameworkHoneycomb();
        }
        sDialogFragmentAccessor = new DialogFragmentAccessorFramework(sFragmentAccessor);
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<DialogFragment> getDialogFragmentClass() {
        return DialogFragment.class;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<Activity> getFragmentActivityClass() {
        return Activity.class;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public Class<Fragment> getFragmentClass() {
        return Fragment.class;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> forDialogFragment() {
        return sDialogFragmentAccessor;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentAccessor<Fragment, FragmentManager> forFragment() {
        return sFragmentAccessor;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    public FragmentActivityAccessor<Activity, FragmentManager> forFragmentActivity() {
        return sFragmentActivityAccessor;
    }

    @Override // com.taobao.weex.devtools.common.android.FragmentCompat
    /* renamed from: forFragmentManager */
    public FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager2() {
        return sFragmentManagerAccessor;
    }
}
