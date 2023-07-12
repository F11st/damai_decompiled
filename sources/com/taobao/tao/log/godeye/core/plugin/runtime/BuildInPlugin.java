package com.taobao.tao.log.godeye.core.plugin.runtime;

import com.taobao.tao.log.godeye.core.plugin.runtime.Plugin;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BuildInPlugin extends Plugin {
    public BuildInPlugin(Plugin.PluginData pluginData) {
        super(pluginData);
    }

    @Override // com.taobao.tao.log.godeye.core.plugin.runtime.Plugin
    public void execute() throws Exception {
        executePluginMainClass(Class.forName(this.pluginData.getMainClass()));
    }
}
