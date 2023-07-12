package tb;

import android.content.Context;
import android.util.Log;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.updatecenter.hotpatch.HotPatchManager;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qz0 {

    /* compiled from: Taobao */
    /* renamed from: tb.qz0$a */
    /* loaded from: classes11.dex */
    static class C9635a implements OrangeConfigListenerV1 {
        C9635a() {
        }

        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            Map<String, String> configs;
            Log.i("HotPatchOrangeReceiver", "onConfigUpdate");
            if (z || (configs = OrangeConfig.getInstance().getConfigs("android_hotpatch_configcenter")) == null) {
                return;
            }
            String str2 = configs.get("clean_patch");
            Log.i("HotPatchOrangeReceiver", "the clearPatch is " + str2);
            if (str2 != null && str2.equals("true")) {
                HotPatchManager.getInstance().cleanPatchs(true);
                HotPatchManager.getInstance().cleanDexPatch();
            }
            String str3 = configs.get("forbid_patch");
            if (str3 != null) {
                if (str3.equals("true")) {
                    HotPatchManager.getInstance().setUsedSupport(false);
                } else if (str3.equals("false")) {
                    HotPatchManager.getInstance().setUsedSupport(true);
                }
            }
        }
    }

    public static void a(Context context) {
        OrangeConfig.getInstance().registerListener(new String[]{"android_hotpatch_configcenter"}, new C9635a());
    }
}
