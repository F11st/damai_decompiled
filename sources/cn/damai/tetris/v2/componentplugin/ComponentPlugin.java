package cn.damai.tetris.v2.componentplugin;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public abstract class ComponentPlugin implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final HashMap<String, Pair<ComponentPluginType, Class<? extends ComponentPlugin>>> PLUGIN_MAP = new HashMap<>();
    protected ComponentPageUi mComponentUi;
    protected ISection mSection;

    public ComponentPlugin(ComponentPageUi componentPageUi) {
        this.mComponentUi = componentPageUi;
    }

    public static Pair<ComponentPluginType, Class<? extends ComponentPlugin>> getPair(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "252089088") ? (Pair) ipChange.ipc$dispatch("252089088", new Object[]{str}) : PLUGIN_MAP.get(str);
    }

    @SuppressLint({"NewApi"})
    public static void registerPlugin(String str, ComponentPluginType componentPluginType, Class<? extends ComponentPlugin> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672837601")) {
            ipChange.ipc$dispatch("-672837601", new Object[]{str, componentPluginType, cls});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            PLUGIN_MAP.put(str, new Pair<>(componentPluginType, cls));
        }
    }

    public void bindSection(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62854797")) {
            ipChange.ipc$dispatch("-62854797", new Object[]{this, iSection});
            return;
        }
        this.mSection = iSection;
        onSectionBind(iSection);
    }

    public void onBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1908021431")) {
            ipChange.ipc$dispatch("1908021431", new Object[]{this, iSection, vBaseViewHolder});
        }
    }

    public abstract boolean onLoadMore();

    public abstract boolean onMessage(int i, Object obj);

    public abstract boolean onRefresh();

    public abstract void onSectionBind(ISection iSection);

    public void onSectionBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531099888")) {
            ipChange.ipc$dispatch("1531099888", new Object[]{this, iSection, vBaseViewHolder});
        } else if (iSection == this.mSection) {
            onBindViewHolder(iSection, vBaseViewHolder);
        }
    }

    public abstract void onSectionRemoved(@Nullable ISection iSection);
}
