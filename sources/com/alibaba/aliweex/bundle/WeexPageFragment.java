package com.alibaba.aliweex.bundle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.aliweex.AliWXSDKInstance;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.R$layout;
import com.alibaba.aliweex.adapter.INavigationBarModuleAdapter;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.render.WXAbstractRenderContainer;
import com.taobao.weex.ui.component.NestedContainer;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.sz2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WeexPageFragment extends Fragment {
    public static String FRAGMENT_ARG_BUNDLE_URL = "arg_bundle_url";
    public static String FRAGMENT_ARG_CUSTOM_OPT = "arg_custom_opt";
    public static String FRAGMENT_ARG_FROM_ACTIVITY = "arg_from_activity";
    public static String FRAGMENT_ARG_INIT_DATA = "arg_init_data";
    public static String FRAGMENT_ARG_RENDER_URL = "arg_render_url";
    public static String FRAGMENT_ARG_TAG = "arg_tag";
    public static String FRAGMENT_ARG_TEMPLATE = "arg_template";
    @Deprecated
    public static String FRAGMENT_ARG_URI = "arg_uri";
    public static String FRAGMENT_TAG = "weex_page";
    private static final String TAG = "WeexPageFragment";
    public static final String WX_RENDER_STRATEGY = "render_strategy";
    private WeexPageContract.IDynamicUrlPresenter mDynamicUrlPresenter;
    private WeexPageContract.IErrorView mErrorView;
    private Boolean mFullScreen;
    private sz2 mNavBarAdapter;
    private boolean mNoAnimated;
    private WeexPageContract.IProgressBar mProgressBarView;
    private BroadcastReceiver mRefreshReceiver;
    private BroadcastReceiver mReloadReceiver;
    private b mRenderListener;
    private WeexPageContract.IRenderPresenter mRenderPresenter;
    private FrameLayout mRootView;
    private WeexPageContract.IUTPresenter mUTPresenter;
    private WeexPageContract.IUrlValidate mUrlValidate;
    protected String mFtag = FRAGMENT_TAG;
    private boolean mUTEnable = true;
    private boolean mDyUrlEnable = false;
    private INavigationBarModuleAdapter.OnItemClickListener mOnBackPressedListener = null;
    private WXAbstractRenderContainer mRenderContainer = null;
    private boolean mIsHeron = false;
    g mWXRenderListener = null;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a extends b {
        a() {
        }

        @Override // com.alibaba.aliweex.bundle.WeexPageFragment.b, com.taobao.weex.IWXRenderListener
        public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
            super.onException(wXSDKInstance, str, str2);
            WeexPageFragment.this.onWXException(wXSDKInstance, str, str2);
        }

        @Override // com.alibaba.aliweex.bundle.WeexPageFragment.b, com.taobao.weex.IWXRenderListener
        public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
            super.onViewCreated(wXSDKInstance, view);
            WeexPageFragment.this.onWXViewCreated(wXSDKInstance, view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class b implements IWXRenderListener {
        public boolean a() {
            return true;
        }

        public View b(WXSDKInstance wXSDKInstance, View view) {
            return view;
        }

        public void c(WXSDKInstance wXSDKInstance, boolean z, String str, String str2) {
        }

        @Override // com.taobao.weex.IWXRenderListener
        public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
        }

        @Override // com.taobao.weex.IWXRenderListener
        public void onRefreshSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        }

        @Override // com.taobao.weex.IWXRenderListener
        public void onRenderSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        }

        @Override // com.taobao.weex.IWXRenderListener
        public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
        }
    }

    private static Fragment installFragment(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, String str3, HashMap<String, Object> hashMap, String str4, int i, String str5, Serializable serializable) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        String str6 = TextUtils.isEmpty(str5) ? FRAGMENT_TAG : str5;
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str6);
        if (findFragmentByTag != null) {
            return findFragmentByTag;
        }
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_ARG_TAG, str6);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(FRAGMENT_ARG_TEMPLATE, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(FRAGMENT_ARG_BUNDLE_URL, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString(FRAGMENT_ARG_RENDER_URL, str3);
        }
        if (hashMap != null) {
            bundle.putSerializable(FRAGMENT_ARG_CUSTOM_OPT, hashMap);
        }
        if (!TextUtils.isEmpty(str4)) {
            bundle.putString(FRAGMENT_ARG_INIT_DATA, str4);
        }
        if (serializable != null) {
            bundle.putSerializable(FRAGMENT_ARG_FROM_ACTIVITY, serializable);
        }
        Fragment instantiate = Fragment.instantiate(fragmentActivity, cls.getName(), bundle);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (TextUtils.isEmpty(str5)) {
            str5 = FRAGMENT_TAG;
        }
        beginTransaction.add(i, instantiate, str5);
        beginTransaction.commitAllowingStateLoss();
        return instantiate;
    }

    private boolean isScollViewOnTop(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            return (childAt instanceof WXScrollView) && ((WXScrollView) childAt).getScrollY() == 0;
        }
        return false;
    }

    @Deprecated
    public static Fragment newInstance(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, int i) {
        return installFragment(fragmentActivity, cls, null, str, str, null, null, i, null, null);
    }

    public static Fragment newInstanceWithTemplate(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, int i) {
        return installFragment(fragmentActivity, cls, str, str2, null, null, null, i, null, null);
    }

    public static Fragment newInstanceWithUrl(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, int i) {
        return installFragment(fragmentActivity, cls, null, str, str2, null, null, i, null, null);
    }

    private void parseArgsFromActivity() {
        boolean booleanValue;
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(FRAGMENT_ARG_FROM_ACTIVITY);
            this.mFtag = arguments.getString(FRAGMENT_ARG_TAG);
            if (serializable instanceof Map) {
                Map map = (Map) serializable;
                String str = (String) map.get("orientation");
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("landscape") && getActivity() != null) {
                    String str2 = (String) map.get("preferredOrientation");
                    if ("landscapeRight".equalsIgnoreCase(str2)) {
                        getActivity().setRequestedOrientation(0);
                    } else if ("landscapeLeft".equalsIgnoreCase(str2)) {
                        getActivity().setRequestedOrientation(8);
                    } else {
                        getActivity().setRequestedOrientation(6);
                    }
                }
                this.mFullScreen = Boolean.valueOf((String) map.get("fullscreen"));
                showFullScreenSystemStatusbar();
                showFullScreenActionbar();
                Object obj = map.get(Constants.Name.ANIMATED);
                if (obj != null) {
                    if (obj instanceof String) {
                        booleanValue = Boolean.parseBoolean((String) obj);
                    } else {
                        booleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : true;
                    }
                    this.mNoAnimated = !booleanValue;
                }
            }
        }
    }

    private void registerBroadcastReceiver() {
        if (WXEnvironment.isApkDebugable()) {
            this.mRefreshReceiver = new BroadcastReceiver() { // from class: com.alibaba.aliweex.bundle.WeexPageFragment.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    WeexPageFragment.this.reload();
                }
            };
            getActivity().registerReceiver(this.mRefreshReceiver, new IntentFilter("DEBUG_INSTANCE_REFRESH"));
        }
        try {
            this.mReloadReceiver = new BroadcastReceiver() { // from class: com.alibaba.aliweex.bundle.WeexPageFragment.3
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (WeexPageFragment.this.getContext() != null) {
                        WeexPageFragment.this.reload();
                    }
                }
            };
            getActivity().registerReceiver(this.mReloadReceiver, new IntentFilter("INSTANCE_RELOAD"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean shouldDegrade(WXSDKInstance wXSDKInstance, String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.contains("|")) {
            return TextUtils.equals("1", str.substring(0, str.indexOf("|")));
        }
        WXErrorCode wXErrorCode = WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
        if (TextUtils.equals(str, wXErrorCode.getErrorCode()) && !TextUtils.isEmpty(str2) && str2.contains("createInstance fail")) {
            String instanceId = wXSDKInstance.getInstanceId();
            WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "shouldDegrade", wXErrorCode.getErrorMsg() + " -- " + str2, null);
        } else {
            WXErrorCode wXErrorCode2 = WXErrorCode.WX_DEGRAD_EAGLE_RENDER_ERROR;
            if (TextUtils.equals(str, wXErrorCode2.getErrorCode()) && !TextUtils.isEmpty(str2) && str2.contains("eagleRenderErr")) {
                String instanceId2 = wXSDKInstance.getInstanceId();
                WXExceptionUtils.commitCriticalExceptionRT(instanceId2, wXErrorCode2, "shouldDegrade", wXErrorCode2.getErrorMsg() + " -- " + str2, null);
            } else {
                WXErrorCode wXErrorCode3 = WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR;
                if (TextUtils.equals(str, wXErrorCode3.getErrorCode()) && !TextUtils.isEmpty(str2) && str2.contains("degradeToH5")) {
                    String instanceId3 = wXSDKInstance.getInstanceId();
                    WXExceptionUtils.commitCriticalExceptionRT(instanceId3, wXErrorCode3, "shouldDegrade", wXErrorCode3.getErrorMsg() + " -- " + str2, null);
                } else {
                    WXErrorCode wXErrorCode4 = WXErrorCode.WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED;
                    if (TextUtils.equals(str, wXErrorCode4.getErrorCode()) && !TextUtils.isEmpty(str2) && str2.contains("degradeToH5")) {
                        String instanceId4 = wXSDKInstance.getInstanceId();
                        WXExceptionUtils.commitCriticalExceptionRT(instanceId4, wXErrorCode4, "shouldDegrade", wXErrorCode4.getErrorMsg() + "-- " + str2, null);
                    } else {
                        WXErrorCode wXErrorCode5 = WXErrorCode.WX_ERR_JSC_CRASH;
                        if (!TextUtils.equals(str, wXErrorCode5.getErrorCode()) || TextUtils.isEmpty(str2) || !str2.contains("degradeToH5")) {
                            return false;
                        }
                        String instanceId5 = wXSDKInstance.getInstanceId();
                        WXExceptionUtils.commitCriticalExceptionRT(instanceId5, wXErrorCode5, "shouldDegrade", wXErrorCode5.getErrorMsg() + "-- " + str2, null);
                    }
                }
            }
        }
        return true;
    }

    private void showFullScreenActionbar() {
        ActionBar supportActionBar;
        if (this.mFullScreen == null || getActivity() == null || !this.mFullScreen.booleanValue() || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (getActivity().getActionBar() != null) {
                getActivity().getActionBar().hide();
                return;
            }
            boolean z = false;
            try {
                int i = AppCompatActivity.a;
                z = true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (z && (getActivity() instanceof AppCompatActivity) && (supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar()) != null) {
                supportActionBar.hide();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void showFullScreenSystemStatusbar() {
        if (this.mFullScreen == null || getActivity() == null || !this.mFullScreen.booleanValue() || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void transformUrl() {
        WeexPageContract.IRenderPresenter iRenderPresenter;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(FRAGMENT_ARG_URI);
            String string2 = arguments.getString(FRAGMENT_ARG_BUNDLE_URL);
            String string3 = arguments.getString(FRAGMENT_ARG_RENDER_URL);
            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                WeexPageContract.IRenderPresenter iRenderPresenter2 = this.mRenderPresenter;
                if (iRenderPresenter2 != null) {
                    iRenderPresenter2.transformUrl(string2, string3);
                }
            } else if (TextUtils.isEmpty(string) || (iRenderPresenter = this.mRenderPresenter) == null) {
            } else {
                iRenderPresenter.transformUrl(string, string);
            }
        }
    }

    public void addViewToRoot(View view) {
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            frameLayout.addView(view);
        }
    }

    protected WeexPageContract.IRenderPresenter createRenderPresenter(IWXRenderListener iWXRenderListener, WeexPageContract.IUTPresenter iUTPresenter, WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter, WeexPageContract.IProgressBar iProgressBar, WeexPageContract.IUrlValidate iUrlValidate) {
        return new RenderPresenter(getActivity(), this.mFtag, iWXRenderListener, iUTPresenter, iDynamicUrlPresenter, iProgressBar, getNavBarAdapter(), iUrlValidate);
    }

    public void destroyWeex() {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.destroySDKInstance();
        }
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }

    public void fireEvent(String str, Map<String, Object> map) {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.fireEvent(str, map);
        }
    }

    public void fireGlobalEvent(String str, Map<String, Object> map) {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter == null || iRenderPresenter.getWXSDKInstance() == null) {
            return;
        }
        this.mRenderPresenter.getWXSDKInstance().fireGlobalEventCallback(str, map);
    }

    public sz2 getNavBarAdapter() {
        return this.mNavBarAdapter;
    }

    public NestedContainer getNestedContainer(WXSDKInstance wXSDKInstance) {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            return iRenderPresenter.getNestedContainer(wXSDKInstance);
        }
        return null;
    }

    public String getOriginalRenderUrl() {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        return iRenderPresenter != null ? iRenderPresenter.getOriginalRenderUrl() : "";
    }

    public String getOriginalUrl() {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        return iRenderPresenter != null ? iRenderPresenter.getOriginalUrl() : "";
    }

    public String getRenderUrl() {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        return iRenderPresenter != null ? iRenderPresenter.getRenderUrl() : "";
    }

    public String getUrl() {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        return iRenderPresenter != null ? iRenderPresenter.getUrl() : "";
    }

    public WXSDKInstance getWXSDKInstance() {
        return this.mRenderPresenter.getWXSDKInstance();
    }

    @Deprecated
    public boolean isAtTop() {
        boolean z = false;
        try {
            boolean isScollViewOnTop = ((this.mRootView.getParent() instanceof FrameLayout) && (((FrameLayout) this.mRootView.getParent()).getChildAt(1) instanceof ViewGroup)) ? isScollViewOnTop((ViewGroup) ((FrameLayout) this.mRootView.getParent()).getChildAt(1)) : false;
            if (isScollViewOnTop) {
                return isScollViewOnTop;
            }
            try {
                FrameLayout frameLayout = this.mRootView;
                if (frameLayout == null || frameLayout.getChildCount() <= 0) {
                    return isScollViewOnTop;
                }
                View childAt = this.mRootView.getChildAt(0);
                return childAt instanceof ViewGroup ? isScollViewOnTop((ViewGroup) childAt) : isScollViewOnTop;
            } catch (Exception unused) {
                z = isScollViewOnTop;
                return z;
            }
        } catch (Exception unused2) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || getContext() == null) {
            return;
        }
        String string = arguments.getString(FRAGMENT_ARG_URI);
        String string2 = arguments.getString(FRAGMENT_ARG_BUNDLE_URL);
        String string3 = arguments.getString(FRAGMENT_ARG_RENDER_URL);
        String string4 = arguments.getString(FRAGMENT_ARG_TEMPLATE);
        HashMap hashMap = (HashMap) arguments.getSerializable(FRAGMENT_ARG_CUSTOM_OPT);
        String string5 = arguments.getString(FRAGMENT_ARG_INIT_DATA);
        if (this.mRenderPresenter != null && getContext() != null) {
            this.mRenderPresenter.onActivityCreate(this.mRootView, hashMap, string5, string4, string2, string3, string);
        }
        arguments.remove(FRAGMENT_ARG_TEMPLATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.onActivityResult(i, i2, intent);
        }
        Intent intent2 = intent == null ? new Intent() : new Intent(intent);
        intent2.setAction(WXModule.ACTION_ACTIVITY_RESULT);
        intent2.putExtra("requestCode", i);
        intent2.putExtra("resultCode", i2);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.mUTEnable) {
            if (this.mUTPresenter == null) {
                this.mUTPresenter = new d(getActivity());
            }
            this.mUTPresenter.skipPage();
        }
        if (this.mDyUrlEnable && this.mDynamicUrlPresenter == null) {
            this.mDynamicUrlPresenter = new c();
        }
        if (this.mProgressBarView == null) {
            this.mProgressBarView = new com.alibaba.aliweex.bundle.b();
        }
        if (this.mUrlValidate == null) {
            this.mUrlValidate = new e(getActivity());
        }
    }

    public boolean onBackPressed() {
        INavigationBarModuleAdapter.OnItemClickListener onItemClickListener = this.mOnBackPressedListener;
        if (onItemClickListener != null) {
            onItemClickListener.onClick(0);
            return true;
        }
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            return iRenderPresenter.onBackPressed();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        parseArgsFromActivity();
        registerBroadcastReceiver();
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.onCreateOptionsMenu(menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.mProgressBarView.createProgressBar(getContext()));
        ViewStub viewStub = new ViewStub(getContext());
        viewStub.setId(R$id.wx_fragment_error);
        viewStub.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewStub.setLayoutResource(R$layout.weex_content_error);
        viewStub.setVisibility(8);
        frameLayout.addView(viewStub);
        this.mRootView = frameLayout;
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.onActivityDestroy();
        }
        WeexPageContract.IErrorView iErrorView = this.mErrorView;
        if (iErrorView != null) {
            iErrorView.destroy();
        }
        if (WXEnvironment.isApkDebugable() && this.mRefreshReceiver != null) {
            getActivity().unregisterReceiver(this.mRefreshReceiver);
            this.mRefreshReceiver = null;
        }
        if (this.mReloadReceiver != null) {
            getActivity().unregisterReceiver(this.mReloadReceiver);
            this.mReloadReceiver = null;
        }
        WeexPageContract.IUTPresenter iUTPresenter = this.mUTPresenter;
        if (iUTPresenter != null) {
            iUTPresenter.destroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        getActivity().invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WeexPageContract.IUTPresenter iUTPresenter = this.mUTPresenter;
        if (iUTPresenter != null) {
            iUTPresenter.pageDisappear();
        }
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.onActivityPause();
        }
        if (this.mNoAnimated && getActivity() != null) {
            getActivity().overridePendingTransition(0, 0);
        }
        WXSDKEngine.setActivityNavBarSetter(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Intent intent = new Intent(WXModule.ACTION_REQUEST_PERMISSIONS_RESULT);
        intent.putExtra("requestCode", i);
        intent.putExtra("permissions", strArr);
        intent.putExtra(WXModule.GRANT_RESULTS, iArr);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showFullScreenSystemStatusbar();
        WeexPageContract.IUTPresenter iUTPresenter = this.mUTPresenter;
        if (iUTPresenter != null) {
            iUTPresenter.pageAppear(getUrl());
        }
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.onActivityResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.onActivityStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.onActivityStop();
        }
    }

    public boolean onSupportNavigateUp() {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            return iRenderPresenter.onSupportNavigateUp();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.mRenderPresenter == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("ListenerValue", this.mRenderListener == null ? "No" : "Yes");
            com.alibaba.aliweex.a.l().s("createWXRenderListener", hashMap);
            g gVar = new g(this.mRootView, this.mProgressBarView, this.mUTPresenter, this.mRenderListener, new a());
            this.mWXRenderListener = gVar;
            WeexPageContract.IRenderPresenter createRenderPresenter = createRenderPresenter(gVar, this.mUTPresenter, this.mDynamicUrlPresenter, this.mProgressBarView, this.mUrlValidate);
            this.mRenderPresenter = createRenderPresenter;
            if (this.mErrorView == null) {
                this.mErrorView = new com.alibaba.aliweex.bundle.a(createRenderPresenter);
            }
            this.mWXRenderListener.f(this.mErrorView);
            transformUrl();
            WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
            if (iRenderPresenter instanceof RenderPresenter) {
                ((RenderPresenter) iRenderPresenter).l(this.mRenderContainer, this.mIsHeron);
            } else {
                WXLogUtils.e(TAG, "  onViewCreated: heron RenderContainer  fail !!!");
            }
        }
    }

    protected void onWXException(WXSDKInstance wXSDKInstance, String str, String str2) {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.mDynamicUrlPresenter;
        if (iDynamicUrlPresenter != null) {
            iDynamicUrlPresenter.onWXException(wXSDKInstance, str, str2);
        }
    }

    protected void onWXViewCreated(WXSDKInstance wXSDKInstance, View view) {
        if (wXSDKInstance instanceof AliWXSDKInstance) {
            getNavBarAdapter();
        }
        WeexPageContract.IUrlValidate iUrlValidate = this.mUrlValidate;
        if (iUrlValidate != null) {
            iUrlValidate.onWXViewCreated(wXSDKInstance, view);
        }
    }

    public void reload() {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.reload();
        }
    }

    public void replace(String str, String str2) {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.replace(str, str2);
        }
    }

    public void setBackPressedListener(INavigationBarModuleAdapter.OnItemClickListener onItemClickListener) {
        this.mOnBackPressedListener = onItemClickListener;
    }

    public void setDynamicUrlEnable(boolean z) {
        this.mDyUrlEnable = z;
    }

    public void setErrorView(WeexPageContract.IErrorView iErrorView) {
        this.mErrorView = iErrorView;
    }

    public void setNavBarAdapter(sz2 sz2Var) {
    }

    public void setProgressBarView(WeexPageContract.IProgressBar iProgressBar) {
        this.mProgressBarView = iProgressBar;
    }

    public void setRenderContainer(WXAbstractRenderContainer wXAbstractRenderContainer, boolean z) {
        this.mRenderContainer = wXAbstractRenderContainer;
        this.mIsHeron = false;
    }

    public void setRenderListener(b bVar) {
        this.mRenderListener = bVar;
        g gVar = this.mWXRenderListener;
        if (gVar == null || gVar.a() != null) {
            return;
        }
        com.alibaba.aliweex.a.l().s("ReSetRenderListener", null);
        this.mWXRenderListener.g(bVar);
    }

    public void setUserTrackEnable(boolean z) {
        this.mUTEnable = z;
    }

    public void setUserTrackPresenter(WeexPageContract.IUTPresenter iUTPresenter) {
        this.mUTPresenter = iUTPresenter;
    }

    @Deprecated
    public void startRender(String str) {
        startRenderByTemplate(str, null, null);
    }

    @Deprecated
    protected void startRenderByTemplate(String str, Map<String, Object> map, String str2) {
        startRenderByTemplate(str, "", map, str2);
    }

    protected void startRenderByUrl(Map<String, Object> map, String str, String str2, String str3) {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.startRenderByUrl(map, str, str2, str3);
        }
    }

    @Deprecated
    public void startRenderWXByUrl(String str, String str2) {
        startRenderByUrl(null, null, str, str2);
    }

    public static Fragment newInstance(Context context, Class<? extends WeexPageFragment> cls, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_ARG_BUNDLE_URL, str);
        bundle.putString(FRAGMENT_ARG_RENDER_URL, str2);
        Fragment instantiate = Fragment.instantiate(context, cls.getName(), bundle);
        instantiate.setArguments(bundle);
        return instantiate;
    }

    public static Fragment newInstanceWithTemplate(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, HashMap<String, Object> hashMap, String str3, int i) {
        return installFragment(fragmentActivity, cls, str, str2, null, hashMap, str3, i, null, null);
    }

    public static Fragment newInstanceWithUrl(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, int i, Serializable serializable) {
        return installFragment(fragmentActivity, cls, null, str, str2, null, null, i, null, serializable);
    }

    @Deprecated
    public void startRender(String str, Map<String, Object> map, String str2) {
        startRenderByTemplate(str, map, str2);
    }

    protected void startRenderByTemplate(String str, String str2, Map<String, Object> map, String str3) {
        WeexPageContract.IRenderPresenter iRenderPresenter = this.mRenderPresenter;
        if (iRenderPresenter != null) {
            iRenderPresenter.startRenderByTemplate(str, str2, map, str3);
        }
    }

    @Deprecated
    public void startRenderWXByUrl(Map<String, Object> map, String str, String str2, String str3) {
        startRenderByUrl(map, str, str2, str3);
    }

    public static Fragment newInstanceWithTemplate(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, HashMap<String, Object> hashMap, String str3, int i, String str4) {
        return installFragment(fragmentActivity, cls, str, str2, null, hashMap, str3, i, str4, null);
    }

    public static Fragment newInstanceWithUrl(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, HashMap<String, Object> hashMap, String str3, int i) {
        return installFragment(fragmentActivity, cls, null, str, str2, hashMap, str3, i, null, null);
    }

    @Deprecated
    public static Fragment newInstanceWithTemplate(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, int i) {
        return installFragment(fragmentActivity, cls, str, null, null, null, null, i, null, null);
    }

    public static Fragment newInstanceWithUrl(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, HashMap<String, Object> hashMap, String str3, int i, String str4) {
        return installFragment(fragmentActivity, cls, null, str, str2, hashMap, str3, i, str4, null);
    }

    @Deprecated
    public static Fragment newInstanceWithTemplate(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, HashMap<String, Object> hashMap, String str2, int i) {
        return installFragment(fragmentActivity, cls, str, null, null, hashMap, str2, i, null, null);
    }

    public static Fragment newInstanceWithUrl(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, String str2, HashMap<String, Object> hashMap, String str3, int i, String str4, Serializable serializable) {
        return installFragment(fragmentActivity, cls, null, str, str2, hashMap, str3, i, str4, serializable);
    }

    @Deprecated
    public static Fragment newInstanceWithTemplate(FragmentActivity fragmentActivity, Class<? extends WeexPageFragment> cls, String str, HashMap<String, Object> hashMap, String str2, int i, String str3) {
        return installFragment(fragmentActivity, cls, str, null, null, hashMap, str2, i, str3, null);
    }
}
