package com.taomai.android.h5container.provider;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.taomai.android.h5container.api.TMNavigationBarPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0016"}, d2 = {"Lcom/taomai/android/h5container/provider/INavigationBarProvider;", "Lcom/taomai/android/h5container/provider/IContainerProvider;", "", "title", "Ltb/wt2;", "setWebTitle", "showWebTitle", "hideWebTitle", "showWebOptionMenu", "hideWebOptionMenu", "Lcom/alibaba/fastjson/JSONObject;", "menu", "Landroid/view/View$OnClickListener;", "listener", "setWebOptionMenu", "hideWebTitleBackBtn", "showWebTitleBackBtn", "enableHookBackBtn", "transparentTitle", TMNavigationBarPlugin.ACTION_SET_TRANSPARENT_TITLE, "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public interface INavigationBarProvider extends IContainerProvider {
    @NotNull
    public static final C7004a Companion = C7004a.a;
    @NotNull
    public static final String NAME = "NavigationBarProvider";

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.provider.INavigationBarProvider$a */
    /* loaded from: classes11.dex */
    public static final class C7004a {
        @NotNull
        public static final String NAME = "NavigationBarProvider";
        static final /* synthetic */ C7004a a = new C7004a();

        private C7004a() {
        }
    }

    void enableHookBackBtn();

    void hideWebOptionMenu();

    void hideWebTitle();

    void hideWebTitleBackBtn();

    void setTransparentTitle(@Nullable String str);

    void setWebOptionMenu(@Nullable JSONObject jSONObject, @NotNull View.OnClickListener onClickListener);

    void setWebTitle(@Nullable String str);

    void showWebOptionMenu();

    void showWebTitle();

    void showWebTitleBackBtn();
}
