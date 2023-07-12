package com.youku.arch.v3.page;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.io.IResponse;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J&\u0010\u0017\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\tH&J&\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\b\u0010!\u001a\u00020\u0004H&J\b\u0010\"\u001a\u00020\u0004H&J\b\u0010#\u001a\u00020\u0004H&J\b\u0010$\u001a\u00020\u0004H&J\b\u0010%\u001a\u00020\u0004H&J\b\u0010&\u001a\u00020\u0004H&J\b\u0010'\u001a\u00020\u0004H&J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0006H&J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0006H&J\"\u00101\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020,H&J\u0012\u00102\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\"\u00107\u001a\u00020\u00042\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u000105H&J\b\u00108\u001a\u00020\u0004H&J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH&J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0006H&J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0006H&J\u0012\u0010A\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010?H&J-\u0010G\u001a\u00020\u00042\u0006\u00103\u001a\u00020,2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010F\u001a\u00020EH&¢\u0006\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/youku/arch/v3/page/FragmentInterceptor;", "Lcom/scwang/smartrefresh/layout/listener/OnMultiPurposeListener;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/wt2;", "onApiResponse", "", "isSelected", "onPageSelected", "Landroid/os/Bundle;", "args", "setArguments", "savedInstanceState", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, "onFragmentCreate", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "onFragmentAttach", "Landroidx/fragment/app/Fragment;", "childFragment", "onAttachFragment", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "onInflate", "Landroid/view/LayoutInflater;", "onGetLayoutInflater", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "Landroid/view/View;", "view", "onViewCreated", "onFragmentStart", "onFragmentResume", "onFragmentPause", "onFragmentStop", "onDestroyView", "onFragmentDestroy", "onFragmentDetach", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "", "transit", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "onViewStateRestored", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onLowMemory", "outState", "onSaveInstanceState", "isInMultiWindowMode", "onMultiWindowModeChanged", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "", "permissions", "", WXModule.GRANT_RESULTS, "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface FragmentInterceptor extends OnMultiPurposeListener {
    void onActivityCreated(@Nullable Bundle bundle);

    void onActivityResult(int i, int i2, @Nullable Intent intent);

    void onApiResponse(@Nullable IResponse iResponse);

    void onAttachFragment(@Nullable Fragment fragment);

    void onConfigurationChanged(@Nullable Configuration configuration);

    @Nullable
    Animation onCreateAnimation(int i, boolean z, int i2);

    void onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    void onDestroyView();

    void onFragmentAttach(@Nullable Context context);

    void onFragmentCreate(@Nullable Bundle bundle);

    void onFragmentDestroy();

    void onFragmentDetach();

    void onFragmentPause();

    void onFragmentResume();

    void onFragmentStart();

    void onFragmentStop();

    @Nullable
    LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle);

    void onHiddenChanged(boolean z);

    void onInflate(@Nullable Context context, @Nullable AttributeSet attributeSet, @Nullable Bundle bundle);

    void onLowMemory();

    void onMultiWindowModeChanged(boolean z);

    void onPageSelected(boolean z);

    void onPictureInPictureModeChanged(boolean z);

    void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr);

    void onSaveInstanceState(@NotNull Bundle bundle);

    void onViewCreated(@NotNull View view, @Nullable Bundle bundle);

    void onViewStateRestored(@Nullable Bundle bundle);

    void setArguments(@Nullable Bundle bundle);

    void setUserVisibleHint(boolean z);
}
