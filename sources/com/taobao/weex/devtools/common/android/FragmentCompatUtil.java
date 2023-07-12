package com.taobao.weex.devtools.common.android;

import android.app.Activity;
import android.view.View;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class FragmentCompatUtil {
    private FragmentCompatUtil() {
    }

    @Nullable
    public static Object findFragmentForView(View view) {
        Activity tryGetActivity = ViewUtil.tryGetActivity(view);
        if (tryGetActivity == null) {
            return null;
        }
        return findFragmentForViewInActivity(tryGetActivity, view);
    }

    @Nullable
    private static Object findFragmentForViewInActivity(Activity activity, View view) {
        Object findFragmentForViewInActivity;
        Object findFragmentForViewInActivity2;
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance == null || !supportLibInstance.getFragmentActivityClass().isInstance(activity) || (findFragmentForViewInActivity2 = findFragmentForViewInActivity(supportLibInstance, activity, view)) == null) {
            FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
            if (frameworkInstance == null || (findFragmentForViewInActivity = findFragmentForViewInActivity(frameworkInstance, activity, view)) == null) {
                return null;
            }
            return findFragmentForViewInActivity;
        }
        return findFragmentForViewInActivity2;
    }

    @Nullable
    private static Object findFragmentForViewInFragment(FragmentCompat fragmentCompat, Object obj, View view) {
        FragmentAccessor forFragment = fragmentCompat.forFragment();
        if (forFragment.getView(obj) == view) {
            return obj;
        }
        Object childFragmentManager = forFragment.getChildFragmentManager(obj);
        if (childFragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, childFragmentManager, view);
        }
        return null;
    }

    @Nullable
    private static Object findFragmentForViewInFragmentManager(FragmentCompat fragmentCompat, Object obj, View view) {
        List addedFragments = fragmentCompat.forFragmentManager().getAddedFragments(obj);
        if (addedFragments != null) {
            int size = addedFragments.size();
            for (int i = 0; i < size; i++) {
                Object findFragmentForViewInFragment = findFragmentForViewInFragment(fragmentCompat, addedFragments.get(i), view);
                if (findFragmentForViewInFragment != null) {
                    return findFragmentForViewInFragment;
                }
            }
            return null;
        }
        return null;
    }

    public static boolean isDialogFragment(Object obj) {
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        boolean z = true;
        boolean z2 = supportLibInstance != null && supportLibInstance.getDialogFragmentClass().isInstance(obj);
        if (z2) {
            return z2;
        }
        FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
        return (frameworkInstance == null || !frameworkInstance.getDialogFragmentClass().isInstance(obj)) ? false : false;
    }

    private static Object findFragmentForViewInActivity(FragmentCompat fragmentCompat, Activity activity, View view) {
        Object fragmentManager = fragmentCompat.forFragmentActivity().getFragmentManager(activity);
        if (fragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, fragmentManager, view);
        }
        return null;
    }
}
