package com.alient.gaiax.container.component;

import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.item.GaiaxItem;
import com.alient.onearch.adapter.parser.component.BasicComponentParser;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.ArchExceptionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016R\u001d\u0010\u000f\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/alient/gaiax/container/component/GaiaxComponent;", "Lcom/youku/arch/v3/core/component/GenericComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "Lcom/youku/arch/v3/core/Node;", "data", "Ltb/wt2;", "initProperties", "", "nodes", "createItems", "Lcom/alient/onearch/adapter/parser/component/BasicComponentParser;", "componentParser$delegate", "Lkotlin/Lazy;", "getComponentParser", "()Lcom/alient/onearch/adapter/parser/component/BasicComponentParser;", "componentParser", "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "node", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GaiaxComponent extends GenericComponent<ComponentValue> {
    @NotNull
    private final Lazy componentParser$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GaiaxComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        Lazy a;
        b41.i(iContext, Constants.PAGE_CONTEXT);
        b41.i(node, "node");
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<BasicComponentParser>() { // from class: com.alient.gaiax.container.component.GaiaxComponent$componentParser$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BasicComponentParser invoke() {
                return new BasicComponentParser();
            }
        });
        this.componentParser$delegate = a;
    }

    private final BasicComponentParser getComponentParser() {
        return (BasicComponentParser) this.componentParser$delegate.getValue();
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.IComponent
    public void createItems(@NotNull List<Node> list) {
        b41.i(list, "nodes");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.alient.gaiax.container.component.GaiaxComponent$createItems$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GaiaxItem gaiaxItem = new GaiaxItem(GaiaxComponent.this.getPageContext());
                gaiaxItem.initProperties(GaiaxComponent.this.getNode());
                gaiaxItem.setProperty(new ItemValue());
                gaiaxItem.getProperty().setType(GaiaxComponent.this.getType());
                gaiaxItem.getProperty().setRenders(GaiaxComponent.this.getProperty().getRenders());
                gaiaxItem.getProperty().setData(GaiaxComponent.this.getNode().getRawJson());
                gaiaxItem.setType(GaiaxComponent.this.getType());
                GaiaxComponent gaiaxComponent = GaiaxComponent.this;
                gaiaxComponent.addItem(gaiaxComponent.childItems.size(), (IItem<ItemValue>) gaiaxItem, false);
            }
        });
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.DomainObject
    public void initProperties(@NotNull Node node) {
        b41.i(node, "data");
        setProperty(getComponentParser().parseElement(node));
        setNode(node);
        setType(node.getType());
        List<Node> children = getProperty().getChildren();
        if (!(children == null || children.isEmpty())) {
            children = null;
        }
        if (children == null) {
            return;
        }
        ComponentValue property = getProperty();
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(property.getId()));
        hashMap.put("type", Integer.valueOf(property.getType()));
        JSONObject data = property.getData();
        Objects.requireNonNull(data, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        hashMap.put("data", data);
        JSONObject rawJson = property.getRawJson();
        Objects.requireNonNull(rawJson, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        hashMap.put("rawJson", rawJson);
        EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
        if (eventDispatcher == null) {
            return;
        }
        eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_CHILDREN_EMPTY, hashMap);
    }
}
