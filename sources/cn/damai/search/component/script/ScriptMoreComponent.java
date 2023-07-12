package cn.damai.search.component.script;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.loader.BasePageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.util.IdGenerator;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import kotlin.collections.C8212k;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ScriptMoreComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @NotNull
    private JSONObject noMoreNodeData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptMoreComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        Object obj;
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(node, Constants.CONFIG);
        this.context = iContext;
        this.noMoreNodeData = new JSONObject();
        ConcurrentMap<String, Object> concurrentMap = iContext.getConcurrentMap();
        if (concurrentMap == null || (obj = concurrentMap.get("keyword")) == null) {
            return;
        }
        this.noMoreNodeData.put((JSONObject) "content", jn1.QUOTE + obj + "\"相关剧本杀只有这么多啦～");
    }

    private final Node createNoMoreNode(Node node, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517961960")) {
            return (Node) ipChange.ipc$dispatch("-517961960", new Object[]{this, node, jSONObject});
        }
        Node node2 = new Node();
        node2.setLevel(2);
        node2.setType(3);
        node2.setId(IdGenerator.getId());
        node2.setData(jSONObject);
        node2.setParent(node);
        node2.setChildren(new ArrayList());
        List<Node> children = node2.getChildren();
        b41.f(children);
        Node node3 = new Node();
        node3.setLevel(3);
        node3.setData(this.noMoreNodeData);
        node3.setParent(node2);
        node3.setType(3);
        node3.setId(IdGenerator.getId());
        children.add(node3);
        return node2;
    }

    private final void replaceOrRemove(int i) {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372293184")) {
            ipChange.ipc$dispatch("-372293184", new Object[]{this, Integer.valueOf(i)});
        } else if (!getModule().getContainer().getModules().isEmpty()) {
            final IModule iModule = (IModule) C8212k.b0(getModule().getContainer().getModules());
            if (!iModule.getComponents().isEmpty()) {
                IComponent iComponent = (IComponent) C8212k.b0(iModule.getComponents());
                JSONObject data = iComponent.getProperty().getData();
                if (data == null || (string = data.getString("componentId")) == null) {
                    return;
                }
                if (i == ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(string)) {
                    IContainer<ModelValue> pageContainer = getPageContext().getPageContainer();
                    PagingLoader pageLoader = pageContainer != null ? pageContainer.getPageLoader() : null;
                    if ((pageLoader instanceof BasePageLoader ? (BasePageLoader) pageLoader : null) != null) {
                        Node createNoMoreNode = createNoMoreNode(iModule.getProperty(), iComponent.getProperty().getData());
                        final IComponent<ComponentValue> createComponent = iModule.createComponent(new Config<>(getPageContext(), createNoMoreNode.getType(), createNoMoreNode, 0, false, 24, null));
                        getPageContext().runOnLoaderThread(new Function0<IComponent<ComponentValue>>() { // from class: cn.damai.search.component.script.ScriptMoreComponent$replaceOrRemove$1$1$1
                            private static transient /* synthetic */ IpChange $ipChange;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            @Nullable
                            public final IComponent<ComponentValue> invoke() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-697332622")) {
                                    return (IComponent) ipChange2.ipc$dispatch("-697332622", new Object[]{this});
                                }
                                IComponent<ComponentValue> iComponent2 = createComponent;
                                if (iComponent2 != null) {
                                    IModule<ModuleValue> iModule2 = iModule;
                                    iModule2.replaceComponent(iModule2.getComponents().size() - 1, iComponent2);
                                    return iComponent2;
                                }
                                return null;
                            }
                        });
                        return;
                    }
                    return;
                }
                getModule().removeComponent((IComponent<ComponentValue>) this, true);
            }
        }
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-613338853") ? (IContext) ipChange.ipc$dispatch("-613338853", new Object[]{this}) : this.context;
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        JSONObject data;
        String string;
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748332041")) {
            return ((Boolean) ipChange.ipc$dispatch("748332041", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        if (b41.d(str, "script_all_loaded") && (data = getProperty().getData()) != null && (string = data.getString("componentId")) != null) {
            Object obj = map != null ? map.get("componentId") : null;
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            if (num != null && (intValue = num.intValue()) == ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(string)) {
                replaceOrRemove(intValue);
                return true;
            }
        }
        return super.onMessage(str, map);
    }
}
