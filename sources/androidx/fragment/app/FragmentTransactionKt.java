package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.downloader.adpater.Monitor;
import kotlin.Metadata;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\t\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b\u001a-\u0010\t\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b\u001a;\u0010\n\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/Fragment;", UTConstant.Args.UT_SUCCESS_F, "Landroidx/fragment/app/FragmentTransaction;", "", "containerViewId", "", "tag", "Landroid/os/Bundle;", "args", Monitor.POINT_ADD, "replace", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, @IdRes int i, String str, Bundle bundle) {
        b41.i(fragmentTransaction, "$this$add");
        b41.o(4, UTConstant.Args.UT_SUCCESS_F);
        FragmentTransaction add = fragmentTransaction.add(i, Fragment.class, bundle, str);
        b41.h(add, "add(containerViewId, F::class.java, args, tag)");
        return add;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        b41.i(fragmentTransaction, "$this$add");
        b41.o(4, UTConstant.Args.UT_SUCCESS_F);
        FragmentTransaction add = fragmentTransaction.add(i, Fragment.class, bundle, str);
        b41.h(add, "add(containerViewId, F::class.java, args, tag)");
        return add;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, @IdRes int i, String str, Bundle bundle) {
        b41.i(fragmentTransaction, "$this$replace");
        b41.o(4, UTConstant.Args.UT_SUCCESS_F);
        FragmentTransaction replace = fragmentTransaction.replace(i, Fragment.class, bundle, str);
        b41.h(replace, "replace(containerViewId, F::class.java, args, tag)");
        return replace;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        b41.i(fragmentTransaction, "$this$replace");
        b41.o(4, UTConstant.Args.UT_SUCCESS_F);
        FragmentTransaction replace = fragmentTransaction.replace(i, Fragment.class, bundle, str);
        b41.h(replace, "replace(containerViewId, F::class.java, args, tag)");
        return replace;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String str, Bundle bundle) {
        b41.i(fragmentTransaction, "$this$add");
        b41.i(str, "tag");
        b41.o(4, UTConstant.Args.UT_SUCCESS_F);
        FragmentTransaction add = fragmentTransaction.add(Fragment.class, bundle, str);
        b41.h(add, "add(F::class.java, args, tag)");
        return add;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        b41.i(fragmentTransaction, "$this$add");
        b41.i(str, "tag");
        b41.o(4, UTConstant.Args.UT_SUCCESS_F);
        FragmentTransaction add = fragmentTransaction.add(Fragment.class, bundle, str);
        b41.h(add, "add(F::class.java, args, tag)");
        return add;
    }
}
