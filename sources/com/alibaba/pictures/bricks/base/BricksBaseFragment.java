package com.alibaba.pictures.bricks.base;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class BricksBaseFragment extends Fragment {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface IClickListener {
        @NotNull
        public static final C3445a Companion = C3445a.a;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.pictures.bricks.base.BricksBaseFragment$IClickListener$a */
        /* loaded from: classes7.dex */
        public static final class C3445a {
            private static transient /* synthetic */ IpChange $ipChange;
            static final /* synthetic */ C3445a a = new C3445a();

            private C3445a() {
            }
        }

        void handleClick(int i);
    }

    public final void hideLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735639866")) {
            ipChange.ipc$dispatch("-735639866", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof IBaseActivityProxy)) {
            return;
        }
        ((IBaseActivityProxy) activity).hideLoading();
    }

    public final void hideLoadingDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587495838")) {
            ipChange.ipc$dispatch("1587495838", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof IBaseActivityProxy)) {
            return;
        }
        ((IBaseActivityProxy) activity).hideLoadingDialog();
    }

    public final void removeErrorView(@NotNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157980438")) {
            ipChange.ipc$dispatch("157980438", new Object[]{this, viewGroup});
            return;
        }
        b41.i(viewGroup, "container");
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof IBaseActivityProxy)) {
            return;
        }
        ((IBaseActivityProxy) activity).removeErrorView(viewGroup);
    }

    public final void showErrorView(@NotNull String str, @NotNull String str2, @NotNull ViewGroup viewGroup, @NotNull IClickListener iClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-979682008")) {
            ipChange.ipc$dispatch("-979682008", new Object[]{this, str, str2, viewGroup, iClickListener});
            return;
        }
        b41.i(str, "msg");
        b41.i(str2, "code");
        b41.i(viewGroup, "container");
        b41.i(iClickListener, "listener");
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof IBaseActivityProxy)) {
            return;
        }
        ((IBaseActivityProxy) activity).showErrorView(str, str2, viewGroup, iClickListener);
    }

    public final void showLoading(@NotNull String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901317310")) {
            ipChange.ipc$dispatch("1901317310", new Object[]{this, strArr});
            return;
        }
        b41.i(strArr, "args");
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof IBaseActivityProxy)) {
            return;
        }
        ((IBaseActivityProxy) activity).showLoading((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void showLoadingDialog(@NotNull String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154304218")) {
            ipChange.ipc$dispatch("-154304218", new Object[]{this, strArr});
            return;
        }
        b41.i(strArr, "args");
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof IBaseActivityProxy)) {
            return;
        }
        ((IBaseActivityProxy) activity).showLoadingDialog((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void showErrorView(int i, @NotNull String str, @NotNull String str2, @NotNull ViewGroup viewGroup, boolean z, boolean z2, boolean z3, @NotNull IClickListener iClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468901613")) {
            ipChange.ipc$dispatch("-468901613", new Object[]{this, Integer.valueOf(i), str, str2, viewGroup, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iClickListener});
            return;
        }
        b41.i(str, "msg");
        b41.i(str2, "code");
        b41.i(viewGroup, "container");
        b41.i(iClickListener, "listener");
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof IBaseActivityProxy)) {
            return;
        }
        ((IBaseActivityProxy) activity).showErrorView(i, str, str2, viewGroup, z, z2, z3, iClickListener);
    }
}
