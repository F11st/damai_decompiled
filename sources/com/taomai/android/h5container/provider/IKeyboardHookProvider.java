package com.taomai.android.h5container.provider;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lcom/taomai/android/h5container/provider/IKeyboardHookProvider;", "", "", "enableHook", "Ltb/wt2;", "setHookBackKey", "isBackHooked", "onBackPressed", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public interface IKeyboardHookProvider {
    @NotNull
    public static final a Companion = a.a;
    @NotNull
    public static final String NAME = "KeyboardHookProvider";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        @NotNull
        public static final String NAME = "KeyboardHookProvider";
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    boolean isBackHooked();

    boolean onBackPressed();

    void setHookBackKey(boolean z);
}
