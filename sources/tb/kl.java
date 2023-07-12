package tb;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVAPI;
import com.taomai.android.h5container.api.TMActionPlugin;
import com.taomai.android.h5container.api.TMCamera;
import com.taomai.android.h5container.api.TMClipBoardPlugin;
import com.taomai.android.h5container.api.TMCookie;
import com.taomai.android.h5container.api.TMImage;
import com.taomai.android.h5container.api.TMLocation;
import com.taomai.android.h5container.api.TMNavigationBarPlugin;
import com.taomai.android.h5container.api.TMNavigatorPlugin;
import com.taomai.android.h5container.api.TMNetworkPlugin;
import com.taomai.android.h5container.api.TMPhotoUploadPlugin;
import com.taomai.android.h5container.api.TMPromptPlugin;
import com.taomai.android.h5container.api.TMScreen;
import com.taomai.android.h5container.api.TMStoragePlugin;
import com.taomai.android.h5container.api.TMUTPlugin;
import com.taomai.android.h5container.api.TaoMaiClientInfoPlugin;
import com.taomai.android.h5container.api.TaoMaiFilePlugin;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class kl {
    @NotNull
    public static final String COMMON_BRIDGE_CLS_NAME = "TMBridge";
    @NotNull
    public static final kl INSTANCE = new kl();

    private kl() {
    }

    @JvmStatic
    public static final void a() {
        WVPluginManager.registerPlugin("TMClipBoard", (Class<? extends WVApiPlugin>) TMClipBoardPlugin.class);
        WVPluginManager.registerPlugin("TMNavigationBar", (Class<? extends WVApiPlugin>) TMNavigationBarPlugin.class);
        WVPluginManager.registerPlugin("TMNavigator", (Class<? extends WVApiPlugin>) TMNavigatorPlugin.class);
        WVPluginManager.registerPlugin("TMUT", (Class<? extends WVApiPlugin>) TMUTPlugin.class);
        WVPluginManager.registerPlugin(TMNetworkPlugin.BRIDGE_NAME, (Class<? extends WVApiPlugin>) TMNetworkPlugin.class);
        WVPluginManager.registerPlugin(TMPromptPlugin.BRIDGE_NAME, (Class<? extends WVApiPlugin>) TMPromptPlugin.class);
        WVPluginManager.registerPlugin("TMStorage", (Class<? extends WVApiPlugin>) TMStoragePlugin.class);
        WVPluginManager.registerPlugin(TaoMaiFilePlugin.BRIDGE_NAME, (Class<? extends WVApiPlugin>) TaoMaiFilePlugin.class);
        WVPluginManager.registerPlugin(WVAPI.PluginName.API_CAMERA, (Class<? extends WVApiPlugin>) TMCamera.class);
        WVPluginManager.registerPlugin(WVAPI.PluginName.API_COOKIE, (Class<? extends WVApiPlugin>) TMCookie.class);
        WVPluginManager.registerPlugin(TaoMaiClientInfoPlugin.BRIDGE_NAME, (Class<? extends WVApiPlugin>) TaoMaiClientInfoPlugin.class);
        WVPluginManager.registerPlugin(COMMON_BRIDGE_CLS_NAME, (Class<? extends WVApiPlugin>) TMActionPlugin.class);
        WVPluginManager.registerPlugin(TMPhotoUploadPlugin.BRIDGE_NAME, (Class<? extends WVApiPlugin>) TMPhotoUploadPlugin.class);
        WVPluginManager.registerPlugin(WVAPI.PluginName.API_LOCATION, (Class<? extends WVApiPlugin>) TMLocation.class);
        WVPluginManager.registerPlugin(WVAPI.PluginName.API_IMAGE, (Class<? extends WVApiPlugin>) TMImage.class);
        WVPluginManager.registerPlugin(WVAPI.PluginName.API_SCREEN, (Class<? extends WVApiPlugin>) TMScreen.class);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, "setTitle", "TMNavigationBar", "setTitle");
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, "showBackButton", "TMNavigationBar", "showBackButton");
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigationBarPlugin.ACTION_HIDE_BACK_BUTTON, "TMNavigationBar", TMNavigationBarPlugin.ACTION_HIDE_BACK_BUTTON);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigationBarPlugin.ACTION_SHOW_TITLE_BAR, "TMNavigationBar", TMNavigationBarPlugin.ACTION_SHOW_TITLE_BAR);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigationBarPlugin.ACTION_HIDE_TITLE_BAR, "TMNavigationBar", TMNavigationBarPlugin.ACTION_HIDE_TITLE_BAR);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigationBarPlugin.ACTION_SHOW_OPTION_MENU, "TMNavigationBar", TMNavigationBarPlugin.ACTION_SHOW_OPTION_MENU);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigationBarPlugin.ACTION_HIDE_OPTION_MENU, "TMNavigationBar", TMNavigationBarPlugin.ACTION_HIDE_OPTION_MENU);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigationBarPlugin.ACTION_SET_OPTION_MENU, "TMNavigationBar", TMNavigationBarPlugin.ACTION_SET_OPTION_MENU);
        WVPluginManager.registerAlias("WebAppInterface", TMNavigationBarPlugin.ACTION_ENABLE_HOOK_BACK, "TMNavigationBar", TMNavigationBarPlugin.ACTION_ENABLE_HOOK_BACK);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigationBarPlugin.ACTION_SET_TRANSPARENT_TITLE, "TMNavigationBar", TMNavigationBarPlugin.ACTION_SET_TRANSPARENT_TITLE);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, "pushWindow", "TMNavigator", "pushWindow");
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigatorPlugin.ACTION_POP_WINDOW, "TMNavigator", TMNavigatorPlugin.ACTION_POP_WINDOW);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, "back", "TMNavigator", "back");
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMNavigatorPlugin.ACTION_POP_TO, "TMNavigator", TMNavigatorPlugin.ACTION_POP_TO);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMClipBoardPlugin.ACTION_GET_CLIPBOARD, "TMClipBoard", TMClipBoardPlugin.ACTION_GET_CLIPBOARD);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMClipBoardPlugin.ACTION_SET_CLIPBOARD, "TMClipBoard", TMClipBoardPlugin.ACTION_SET_CLIPBOARD);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMStoragePlugin.ACTION_GET_SHARED_DATA, "TMStorage", TMStoragePlugin.ACTION_GET_SHARED_DATA);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMStoragePlugin.ACTION_SET_SHARED_DATA, "TMStorage", TMStoragePlugin.ACTION_SET_SHARED_DATA);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMStoragePlugin.ACTION_REMOVE_SHARED_DATA, "TMStorage", TMStoragePlugin.ACTION_REMOVE_SHARED_DATA);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMStoragePlugin.ACTION_GET_MEMORY_CACHE, "TMStorage", TMStoragePlugin.ACTION_GET_MEMORY_CACHE);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMStoragePlugin.ACTION_SET_MEMORY_CACHE, "TMStorage", TMStoragePlugin.ACTION_SET_MEMORY_CACHE);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMStoragePlugin.ACTION_REMOVE_MEMORY_CACHE, "TMStorage", TMStoragePlugin.ACTION_REMOVE_MEMORY_CACHE);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMUTPlugin.ACTION_USER_TRACK, "TMUT", TMUTPlugin.ACTION_USER_TRACK);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMPromptPlugin.ACTION_PROMPT, TMPromptPlugin.BRIDGE_NAME, TMPromptPlugin.ACTION_PROMPT);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TaoMaiFilePlugin.ACTION_FILE_READ, TaoMaiFilePlugin.BRIDGE_NAME, TaoMaiFilePlugin.ACTION_FILE_READ);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TaoMaiFilePlugin.ACTION_FILE_SAVE, TaoMaiFilePlugin.BRIDGE_NAME, TaoMaiFilePlugin.ACTION_FILE_SAVE);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TaoMaiFilePlugin.ACTION_FILE_DELETE, TaoMaiFilePlugin.BRIDGE_NAME, TaoMaiFilePlugin.ACTION_FILE_DELETE);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TaoMaiClientInfoPlugin.ACTION_STATUS_BAR_HEIGHT, TaoMaiClientInfoPlugin.BRIDGE_NAME, TaoMaiClientInfoPlugin.ACTION_STATUS_BAR_HEIGHT);
        WVPluginManager.registerAlias(COMMON_BRIDGE_CLS_NAME, TMPhotoUploadPlugin.ACTION_UPLOAD_PHOTO, TMPhotoUploadPlugin.BRIDGE_NAME, TMPhotoUploadPlugin.ACTION_UPLOAD_PHOTO);
    }
}
