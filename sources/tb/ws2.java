package tb;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.ut.DogCat;
import com.alibaba.pictures.ut.ExposureDog;
import com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ws2 implements UTHelperPopupCallback {
    @NotNull
    public static final C9881a Companion = new C9881a(null);
    @NotNull
    public static final String UT_CLOSE_KEY = "close";
    @NotNull
    public static final String UT_CONFIRM_KEY = "confirm";
    @NotNull
    public static final String UT_ITEM_KEY = "item";

    /* compiled from: Taobao */
    /* renamed from: tb.ws2$a */
    /* loaded from: classes8.dex */
    public static final class C9881a {
        private C9881a() {
        }

        public /* synthetic */ C9881a(k50 k50Var) {
            this();
        }
    }

    public ws2(@NotNull Activity activity) {
        b41.i(activity, "activity");
    }

    private final void a(HashMap<String, String> hashMap, TrackInfo trackInfo) {
        if (hashMap != null) {
            HashMap<String, String> args = trackInfo.getArgs();
            wt2 wt2Var = null;
            if (args != null) {
                b41.h(args, "args");
                HashMap<String, String> args2 = trackInfo.getArgs();
                if (args2 != null) {
                    args2.putAll(hashMap);
                    wt2Var = wt2.INSTANCE;
                }
            }
            if (wt2Var == null) {
                trackInfo.setArgs(hashMap);
            }
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback
    @JvmOverloads
    public void closeUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z) {
        Action action;
        TrackInfo trackInfo;
        if (map == null || !map.containsKey("close") || (action = (Action) yh0.INSTANCE.f(map.get("close"), Action.class)) == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        b41.h(trackInfo, "trackInfo");
        String clickEventName = trackInfo.getClickEventName();
        if (clickEventName != null) {
            b41.h(clickEventName, "clickEventName");
            a(hashMap, trackInfo);
            DogCat.INSTANCE.d().n(trackInfo.getSpmb()).r(trackInfo.getSpmc(), trackInfo.getSpmd()).m(z).o(trackInfo.getArgs()).j();
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback
    @JvmOverloads
    public void confirmUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z) {
        Action action;
        TrackInfo trackInfo;
        if (map == null || !map.containsKey("confirm") || (action = (Action) yh0.INSTANCE.f(map.get("confirm"), Action.class)) == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        b41.h(trackInfo, "trackInfo");
        String clickEventName = trackInfo.getClickEventName();
        if (clickEventName != null) {
            b41.h(clickEventName, "clickEventName");
            a(hashMap, trackInfo);
            DogCat.INSTANCE.d().n(trackInfo.getSpmb()).r(trackInfo.getSpmc(), trackInfo.getSpmd()).m(z).o(trackInfo.getArgs()).j();
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback
    @JvmOverloads
    public void exposureUt(long j, @Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z) {
        Action action;
        TrackInfo trackInfo;
        if (map == null || !map.containsKey("item") || (action = (Action) yh0.INSTANCE.f(map.get("item"), Action.class)) == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        b41.h(trackInfo, "trackInfo");
        String exposeEventName = trackInfo.getExposeEventName();
        if (exposeEventName != null) {
            b41.h(exposeEventName, "exposeEventName");
            a(hashMap, trackInfo);
            if (j > 500) {
                ExposureDog w = DogCat.INSTANCE.h().w(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd());
                HashMap<String, String> args = trackInfo.getArgs();
                if (args != null) {
                    b41.h(args, "args");
                    for (Map.Entry<String, String> entry : args.entrySet()) {
                        w.r(entry.getKey(), entry.getValue());
                    }
                }
                w.k();
            }
        }
        String clickEventName = trackInfo.getClickEventName();
        if (clickEventName != null) {
            b41.h(clickEventName, "clickEventName");
            DogCat.INSTANCE.d().n(trackInfo.getSpmb()).r(trackInfo.getSpmc(), trackInfo.getSpmd()).m(z).o(trackInfo.getArgs()).j();
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback
    @JvmOverloads
    public void itemUt(@Nullable View view, @Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z) {
        Action action;
        TrackInfo trackInfo;
        if (map == null || !map.containsKey("item") || (action = (Action) yh0.INSTANCE.f(map.get("item"), Action.class)) == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        b41.h(trackInfo, "trackInfo");
        a(hashMap, trackInfo);
        String exposeEventName = trackInfo.getExposeEventName();
        if (exposeEventName != null) {
            b41.h(exposeEventName, "exposeEventName");
            if (view != null) {
                DogCat.INSTANCE.i(view).q(trackInfo.getSpmb()).x(trackInfo.getSpmc(), trackInfo.getSpmd()).s(trackInfo.getArgs()).k();
            }
        }
        String clickEventName = trackInfo.getClickEventName();
        if (clickEventName != null) {
            b41.h(clickEventName, "clickEventName");
            DogCat.INSTANCE.d().n(trackInfo.getSpmb()).r(trackInfo.getSpmc(), trackInfo.getSpmd()).m(z).o(trackInfo.getArgs()).j();
        }
    }
}
