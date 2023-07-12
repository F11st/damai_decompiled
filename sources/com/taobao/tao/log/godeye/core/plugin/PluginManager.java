package com.taobao.tao.log.godeye.core.plugin;

import android.app.Application;
import android.util.Log;
import com.taobao.tao.log.godeye.core.control.Godeye;
import com.taobao.tao.log.godeye.core.plugin.runtime.BuildInPlugin;
import com.taobao.tao.log.godeye.core.plugin.runtime.Plugin;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PluginManager {
    private static final String PLUGINS_CONFIG_FILE_NAME = "godeye.plugin.cfg";
    private static final HashSet<String> initedPlugins = new HashSet<>();
    private static final String[] DEFAULT_PLUGIN_INITIALIZER = {"com.taobao.tao.log.godeye.methodtrace.MethodTraceInitializer"};
    private static boolean defaultPluginsInitialized = false;

    public static void loadDefaultPlugins() throws Exception {
        String[] strArr;
        if (defaultPluginsInitialized) {
            return;
        }
        boolean z = false;
        for (String str : DEFAULT_PLUGIN_INITIALIZER) {
            HashSet<String> hashSet = initedPlugins;
            if (!hashSet.contains(str)) {
                Plugin.PluginData pluginData = new Plugin.PluginData();
                pluginData.setMainClass(str);
                new BuildInPlugin(pluginData).execute();
                hashSet.add(str);
                z = true;
            }
        }
        if (z) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Godeye.sharedInstance().getApplication().getFilesDir(), PLUGINS_CONFIG_FILE_NAME + Godeye.sharedInstance().getAppVersion())));
            bufferedWriter.write("");
            Iterator<String> it = initedPlugins.iterator();
            while (it.hasNext()) {
                bufferedWriter.append((CharSequence) it.next()).append((CharSequence) StringUtils.LF);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        defaultPluginsInitialized = true;
    }

    public static void loadPlugin(Application application) throws Exception {
        File filesDir = application.getFilesDir();
        File file = new File(filesDir, PLUGINS_CONFIG_FILE_NAME + Godeye.sharedInstance().getAppVersion());
        if (file.exists()) {
            Iterator<Plugin.PluginData> it = parsePluginData(file).iterator();
            while (it.hasNext()) {
                Plugin.PluginData next = it.next();
                new BuildInPlugin(next).execute();
                initedPlugins.add(next.getMainClass());
            }
        }
    }

    private static ArrayList<Plugin.PluginData> parsePluginData(File file) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        ArrayList<Plugin.PluginData> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (!"".equals(readLine)) {
                    Log.e("tlog-debug", "parsePluginData line:" + readLine);
                    Plugin.PluginData pluginData = new Plugin.PluginData();
                    pluginData.setMainClass(readLine);
                    arrayList.add(pluginData);
                }
            } else {
                bufferedReader.close();
                return arrayList;
            }
        }
    }

    public static void removeAllPlugins(Application application) {
        File filesDir = application.getFilesDir();
        File file = new File(filesDir, PLUGINS_CONFIG_FILE_NAME + Godeye.sharedInstance().getAppVersion());
        if (file.exists()) {
            file.delete();
        }
        defaultPluginsInitialized = false;
    }
}
