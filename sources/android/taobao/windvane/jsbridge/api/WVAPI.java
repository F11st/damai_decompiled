package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.embed.EmbedViewDemo;
import android.taobao.windvane.embed.Empty;
import android.taobao.windvane.embed.WVEVManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVAPI {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class PluginName {
        public static final String API_BASE = "Base";
        public static final String API_BLUETOOTH = "WVBluetooth";
        public static final String API_CAMERA = "WVCamera";
        public static final String API_CONTACTS = "WVContacts";
        public static final String API_COOKIE = "WVCookie";
        public static final String API_FILE = "WVFile";
        public static final String API_IMAGE = "WVImage";
        public static final String API_LOCATION = "WVLocation";
        public static final String API_MOTION = "WVMotion";
        public static final String API_NATIVEDETECTOR = "WVNativeDetector";
        public static final String API_Network = "WVNetwork";
        public static final String API_Notification = "WVNotification";
        public static final String API_PREFETCH = "Prefetch";
        public static final String API_REPORTER = "WVReporter";
        public static final String API_SCREEN = "WVScreen";
        public static final String API_STANDARDEVENTCENTER = "WVStandardEventCenter";
        public static final String API_UI = "WVUI";
        public static final String API_UIACTIONSHEET = "WVUIActionSheet";
        public static final String API_UIDIALOG = "WVUIDialog";
        public static final String API_UITOAST = "WVUIToast";

        public PluginName() {
        }
    }

    public static void setup() {
        WVJsBridge.getInstance().init();
        WVPluginManager.registerPlugin(PluginName.API_BASE, (Class<? extends WVApiPlugin>) WVBase.class);
        WVPluginManager.registerPlugin(PluginName.API_LOCATION, (Class<? extends WVApiPlugin>) WVLocation.class);
        WVPluginManager.registerPlugin(PluginName.API_MOTION, (Class<? extends WVApiPlugin>) WVMotion.class);
        WVPluginManager.registerPlugin(PluginName.API_COOKIE, (Class<? extends WVApiPlugin>) WVCookie.class);
        WVPluginManager.registerPlugin(PluginName.API_CAMERA, (Class<? extends WVApiPlugin>) WVCamera.class);
        WVPluginManager.registerPlugin(PluginName.API_UI, (Class<? extends WVApiPlugin>) WVUI.class);
        WVPluginManager.registerPlugin(PluginName.API_Notification, (Class<? extends WVApiPlugin>) WVNotification.class);
        WVPluginManager.registerPlugin(PluginName.API_Network, (Class<? extends WVApiPlugin>) WVNetwork.class);
        WVPluginManager.registerPlugin(PluginName.API_UITOAST, (Class<? extends WVApiPlugin>) WVUIToast.class);
        WVPluginManager.registerPlugin(PluginName.API_UIDIALOG, (Class<? extends WVApiPlugin>) WVUIDialog.class);
        WVPluginManager.registerPlugin(PluginName.API_UIACTIONSHEET, (Class<? extends WVApiPlugin>) WVUIActionSheet.class);
        WVPluginManager.registerPlugin(PluginName.API_CONTACTS, (Class<? extends WVApiPlugin>) WVContacts.class);
        WVPluginManager.registerPlugin(PluginName.API_REPORTER, (Class<? extends WVApiPlugin>) WVReporter.class);
        WVPluginManager.registerPlugin(PluginName.API_STANDARDEVENTCENTER, (Class<? extends WVApiPlugin>) WVStandardEventCenter.class);
        WVPluginManager.registerPlugin(PluginName.API_FILE, (Class<? extends WVApiPlugin>) WVFile.class);
        WVPluginManager.registerPlugin(PluginName.API_SCREEN, (Class<? extends WVApiPlugin>) WVScreen.class);
        WVPluginManager.registerPlugin(PluginName.API_NATIVEDETECTOR, (Class<? extends WVApiPlugin>) WVNativeDetector.class, true);
        WVPluginManager.registerPlugin(PluginName.API_BLUETOOTH, (Class<? extends WVApiPlugin>) WVBluetooth.class, true);
        WVPluginManager.registerPlugin("WVBroadcast", (Class<? extends WVApiPlugin>) WVBroadcastChannel.class, true);
        WVPluginManager.registerPlugin(PluginName.API_PREFETCH, (Class<? extends WVApiPlugin>) WVPrefetch.class);
        WVPluginManager.registerPlugin(PluginName.API_IMAGE, (Class<? extends WVApiPlugin>) WVImage.class);
        WVEVManager.registerEmbedView("demo", EmbedViewDemo.class, true);
        WVEVManager.registerEmbedView(DXRecyclerLayout.LOAD_MORE_EMPTY, Empty.class, true);
    }
}
