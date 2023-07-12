package com.taobao.weex.devtools.inspector.protocol.module;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.ArrayListAccumulator;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.UncheckedCallable;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.elements.Document;
import com.taobao.weex.devtools.inspector.elements.DocumentView;
import com.taobao.weex.devtools.inspector.elements.ElementInfo;
import com.taobao.weex.devtools.inspector.elements.NodeDescriptor;
import com.taobao.weex.devtools.inspector.elements.NodeType;
import com.taobao.weex.devtools.inspector.elements.StyleAccumulator;
import com.taobao.weex.devtools.inspector.helper.ChromePeerManager;
import com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcException;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcError;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.inspector.protocol.module.Runtime;
import com.taobao.weex.devtools.inspector.screencast.ScreencastDispatcher;
import com.taobao.weex.devtools.json.ObjectMapper;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DOM implements ChromeDevtoolsDomain {
    private static boolean sNativeMode = true;
    private ChildNodeInsertedEvent mCachedChildNodeInsertedEvent;
    private ChildNodeRemovedEvent mCachedChildNodeRemovedEvent;
    private final Document mDocument;
    private final DocumentUpdateListener mListener;
    private final ChromePeerManager mPeerManager;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final Map<String, List<Integer>> mSearchResults = Collections.synchronizedMap(new HashMap());
    private final AtomicInteger mResultCounter = new AtomicInteger(0);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class AttributeModifiedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String value;

        private AttributeModifiedEvent() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class AttributeRemovedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;

        private AttributeRemovedEvent() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class BoxModel {
        @JsonProperty(required = true)
        public List<Double> border;
        @JsonProperty(required = true)
        public List<Double> content;
        @JsonProperty(required = true)
        public Integer height;
        @JsonProperty(required = true)
        public List<Double> margin;
        @JsonProperty(required = true)
        public List<Double> padding;
        @JsonProperty(required = true)
        public Integer width;

        private BoxModel() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ChildNodeInsertedEvent {
        @JsonProperty(required = true)
        public Node node;
        @JsonProperty(required = true)
        public int parentNodeId;
        @JsonProperty(required = true)
        public int previousNodeId;

        private ChildNodeInsertedEvent() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ChildNodeRemovedEvent {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public int parentNodeId;

        private ChildNodeRemovedEvent() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class DiscardSearchResultsRequest {
        @JsonProperty(required = true)
        public String searchId;

        private DiscardSearchResultsRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private final class DocumentUpdateListener implements Document.UpdateListener {
        private DocumentUpdateListener() {
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onAttributeModified(Object obj, String str, String str2) {
            AttributeModifiedEvent attributeModifiedEvent = new AttributeModifiedEvent();
            attributeModifiedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeModifiedEvent.name = str;
            attributeModifiedEvent.value = str2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.onAttributeModified", attributeModifiedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onAttributeRemoved(Object obj, String str) {
            AttributeRemovedEvent attributeRemovedEvent = new AttributeRemovedEvent();
            attributeRemovedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeRemovedEvent.name = str;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeRemoved", attributeRemovedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onChildNodeInserted(DocumentView documentView, Object obj, int i, int i2, Accumulator<Object> accumulator) {
            ChildNodeInsertedEvent acquireChildNodeInsertedEvent = DOM.this.acquireChildNodeInsertedEvent();
            acquireChildNodeInsertedEvent.parentNodeId = i;
            acquireChildNodeInsertedEvent.previousNodeId = i2;
            acquireChildNodeInsertedEvent.node = DOM.this.createNodeForElement(obj, documentView, accumulator);
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeInserted", acquireChildNodeInsertedEvent);
            DOM.this.releaseChildNodeInsertedEvent(acquireChildNodeInsertedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onChildNodeRemoved(int i, int i2) {
            ChildNodeRemovedEvent acquireChildNodeRemovedEvent = DOM.this.acquireChildNodeRemovedEvent();
            acquireChildNodeRemovedEvent.parentNodeId = i;
            acquireChildNodeRemovedEvent.nodeId = i2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeRemoved", acquireChildNodeRemovedEvent);
            DOM.this.releaseChildNodeRemovedEvent(acquireChildNodeRemovedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onInspectRequested(Object obj) {
            Integer nodeIdForElement = DOM.this.mDocument.getNodeIdForElement(obj);
            if (nodeIdForElement == null) {
                LogUtil.d("DocumentProvider.Listener.onInspectRequested() called for a non-mapped node: element=%s", obj);
                return;
            }
            InspectNodeRequestedEvent inspectNodeRequestedEvent = new InspectNodeRequestedEvent();
            inspectNodeRequestedEvent.nodeId = nodeIdForElement.intValue();
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.inspectNodeRequested", inspectNodeRequestedEvent);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetBoxModelRequest {
        @JsonProperty
        public Integer nodeId;

        private GetBoxModelRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class GetBoxModelResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public BoxModel model;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetDocumentResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Node root;

        private GetDocumentResponse() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetNodeForLocationRequest {
        @JsonProperty(required = true)
        public int x;
        @JsonProperty(required = true)
        public int y;

        private GetNodeForLocationRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetNodeForLocationResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Integer nodeId;

        private GetNodeForLocationResponse() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetSearchResultsRequest {
        @JsonProperty(required = true)
        public int fromIndex;
        @JsonProperty(required = true)
        public String searchId;
        @JsonProperty(required = true)
        public int toIndex;

        private GetSearchResultsRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetSearchResultsResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<Integer> nodeIds;

        private GetSearchResultsResponse() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class HighlightConfig {
        @JsonProperty
        public RGBAColor contentColor;

        private HighlightConfig() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class HighlightNodeRequest {
        @JsonProperty(required = true)
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Integer nodeId;
        @JsonProperty
        public String objectId;

        private HighlightNodeRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class InspectNodeRequestedEvent {
        @JsonProperty
        public int nodeId;

        private InspectNodeRequestedEvent() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Node implements JsonRpcResult {
        @JsonProperty
        public List<String> attributes;
        @JsonProperty
        public Integer childNodeCount;
        @JsonProperty
        public List<Node> children;
        @JsonProperty(required = true)
        public String localName;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String nodeName;
        @JsonProperty(required = true)
        public NodeType nodeType;
        @JsonProperty(required = true)
        public String nodeValue;

        private Node() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
        protected synchronized void onFirstPeerRegistered() {
            DOM.this.mDocument.addRef();
            DOM.this.mDocument.addUpdateListener(DOM.this.mListener);
        }

        @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
        protected synchronized void onLastPeerUnregistered() {
            DOM.this.mSearchResults.clear();
            DOM.this.mDocument.removeUpdateListener(DOM.this.mListener);
            DOM.this.mDocument.release();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class PerformSearchRequest {
        @JsonProperty
        public Boolean includeUserAgentShadowDOM;
        @JsonProperty(required = true)
        public String query;

        private PerformSearchRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class PerformSearchResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public int resultCount;
        @JsonProperty(required = true)
        public String searchId;

        private PerformSearchResponse() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class RGBAColor {
        @JsonProperty
        public Double a;
        @JsonProperty(required = true)
        public int b;
        @JsonProperty(required = true)
        public int g;
        @JsonProperty(required = true)
        public int r;

        private RGBAColor() {
        }

        public int getColor() {
            Double d = this.a;
            byte b = -1;
            if (d != null) {
                long round = Math.round(d.doubleValue() * 255.0d);
                if (round < 0) {
                    b = 0;
                } else if (round < 255) {
                    b = (byte) round;
                }
            }
            return Color.argb((int) b, this.r, this.g, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class ResolveNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty
        public String objectGroup;

        private ResolveNodeRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class ResolveNodeResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Runtime.RemoteObject object;

        private ResolveNodeResponse() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SetAttributesAsTextRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String text;

        private SetAttributesAsTextRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SetInspectModeEnabledRequest {
        @JsonProperty(required = true)
        public boolean enabled;
        @JsonProperty
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Boolean inspectShadowDOM;

        private SetInspectModeEnabledRequest() {
        }
    }

    public DOM(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        ChromePeerManager chromePeerManager = new ChromePeerManager();
        this.mPeerManager = chromePeerManager;
        chromePeerManager.setListener(new PeerManagerListener());
        this.mListener = new DocumentUpdateListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChildNodeInsertedEvent acquireChildNodeInsertedEvent() {
        ChildNodeInsertedEvent childNodeInsertedEvent = this.mCachedChildNodeInsertedEvent;
        if (childNodeInsertedEvent == null) {
            childNodeInsertedEvent = new ChildNodeInsertedEvent();
        }
        this.mCachedChildNodeInsertedEvent = null;
        return childNodeInsertedEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChildNodeRemovedEvent acquireChildNodeRemovedEvent() {
        ChildNodeRemovedEvent childNodeRemovedEvent = this.mCachedChildNodeRemovedEvent;
        if (childNodeRemovedEvent == null) {
            childNodeRemovedEvent = new ChildNodeRemovedEvent();
        }
        this.mCachedChildNodeRemovedEvent = null;
        return childNodeRemovedEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node createNodeForElement(Object obj, DocumentView documentView, @Nullable Accumulator<Object> accumulator) {
        List<Node> arrayList;
        if (accumulator != null) {
            accumulator.store(obj);
        }
        NodeDescriptor nodeDescriptor = this.mDocument.getNodeDescriptor(obj);
        Node node = new Node();
        node.nodeId = this.mDocument.getNodeIdForElement(obj).intValue();
        node.nodeType = nodeDescriptor.getNodeType(obj);
        node.nodeName = nodeDescriptor.getNodeName(obj);
        node.localName = nodeDescriptor.getLocalName(obj);
        node.nodeValue = nodeDescriptor.getNodeValue(obj);
        Document.AttributeListAccumulator attributeListAccumulator = new Document.AttributeListAccumulator();
        nodeDescriptor.getAttributes(obj, attributeListAccumulator);
        node.attributes = attributeListAccumulator;
        ElementInfo elementInfo = documentView.getElementInfo(obj);
        if (elementInfo.children.size() == 0) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList<>(elementInfo.children.size());
        }
        int size = elementInfo.children.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(createNodeForElement(elementInfo.children.get(i), documentView, accumulator));
        }
        node.children = arrayList;
        node.childNodeCount = Integer.valueOf(arrayList.size());
        return node;
    }

    public static boolean isNativeMode() {
        return sNativeMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseChildNodeInsertedEvent(ChildNodeInsertedEvent childNodeInsertedEvent) {
        childNodeInsertedEvent.parentNodeId = -1;
        childNodeInsertedEvent.previousNodeId = -1;
        childNodeInsertedEvent.node = null;
        if (this.mCachedChildNodeInsertedEvent == null) {
            this.mCachedChildNodeInsertedEvent = childNodeInsertedEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseChildNodeRemovedEvent(ChildNodeRemovedEvent childNodeRemovedEvent) {
        childNodeRemovedEvent.parentNodeId = -1;
        childNodeRemovedEvent.nodeId = -1;
        if (this.mCachedChildNodeRemovedEvent == null) {
            this.mCachedChildNodeRemovedEvent = childNodeRemovedEvent;
        }
    }

    public static void setNativeMode(boolean z) {
        sNativeMode = z;
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void discardSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        String str = ((DiscardSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, DiscardSearchResultsRequest.class)).searchId;
        if (str != null) {
            this.mSearchResults.remove(str);
        }
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.addPeer(jsonRpcPeer);
    }

    public int findViewByLocation(final int i, final int i2) {
        final ArrayListAccumulator arrayListAccumulator = new ArrayListAccumulator();
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.8
            @Override // java.lang.Runnable
            public void run() {
                DOM.this.mDocument.findMatchingElements(i, i2, arrayListAccumulator);
            }
        });
        if (arrayListAccumulator.size() > 0) {
            return ((Integer) arrayListAccumulator.get(arrayListAccumulator.size() - 1)).intValue();
        }
        return 0;
    }

    @ChromeDevtoolsMethod
    public GetBoxModelResponse getBoxModel(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetBoxModelResponse getBoxModelResponse = new GetBoxModelResponse();
        final BoxModel boxModel = new BoxModel();
        final GetBoxModelRequest getBoxModelRequest = (GetBoxModelRequest) this.mObjectMapper.convertValue(jSONObject, GetBoxModelRequest.class);
        if (getBoxModelRequest.nodeId == null) {
            return null;
        }
        getBoxModelResponse.model = boxModel;
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.9
            @Override // java.lang.Runnable
            public void run() {
                final Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(getBoxModelRequest.nodeId.intValue());
                if (elementForNodeId != null) {
                    DOM.this.mDocument.getElementStyles(elementForNodeId, new StyleAccumulator() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.9.1
                        @Override // com.taobao.weex.devtools.inspector.elements.StyleAccumulator
                        public void store(String str, String str2, boolean z) {
                            View hostView;
                            double d;
                            double d2;
                            double d3;
                            double d4;
                            double d5;
                            double d6;
                            double d7;
                            double d8;
                            double d9;
                            double d10;
                            double d11;
                            double d12;
                            int[] iArr;
                            ViewGroup.LayoutParams layoutParams;
                            BoxModel boxModel2;
                            BoxModel boxModel3;
                            if (DOM.isNativeMode()) {
                                Object obj = elementForNodeId;
                                if (obj instanceof View) {
                                    hostView = (View) obj;
                                }
                                hostView = null;
                            } else {
                                Object obj2 = elementForNodeId;
                                if (obj2 instanceof WXComponent) {
                                    hostView = ((WXComponent) obj2).getHostView();
                                }
                                hostView = null;
                            }
                            if (hostView == null || !hostView.isShown()) {
                                d = 0.0d;
                                d2 = 0.0d;
                                d3 = 0.0d;
                                d4 = 0.0d;
                                d5 = 0.0d;
                                d6 = 0.0d;
                                d7 = 0.0d;
                                d8 = 0.0d;
                                d9 = 0.0d;
                                d10 = 0.0d;
                                d11 = 0.0d;
                                d12 = 0.0d;
                            } else {
                                float f = ScreencastDispatcher.getsBitmapScale();
                                boxModel.width = Integer.valueOf(hostView.getWidth());
                                boxModel.height = Integer.valueOf(hostView.getHeight());
                                if (!DOM.isNativeMode()) {
                                    boxModel.width = Integer.valueOf((int) (((boxModel2.width.intValue() * FeatureFactory.PRIORITY_ABOVE_NORMAL) / WXViewUtils.getScreenWidth()) + 0.5d));
                                    boxModel.height = Integer.valueOf((int) (((boxModel3.height.intValue() * FeatureFactory.PRIORITY_ABOVE_NORMAL) / WXViewUtils.getScreenWidth()) + 0.5d));
                                }
                                hostView.getLocationOnScreen(new int[2]);
                                double d13 = iArr[0] * f;
                                double d14 = iArr[1] * f;
                                double width = (hostView.getWidth() * f) + d13;
                                double height = (hostView.getHeight() * f) + d14;
                                double paddingLeft = hostView.getPaddingLeft() * f;
                                double paddingTop = hostView.getPaddingTop() * f;
                                d9 = hostView.getPaddingRight() * f;
                                double paddingBottom = hostView.getPaddingBottom() * f;
                                if ((hostView instanceof ViewGroup) && (layoutParams = hostView.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                                    d10 = paddingBottom;
                                    d11 = marginLayoutParams.leftMargin * f;
                                    d12 = marginLayoutParams.topMargin * f;
                                    d = paddingTop;
                                    d8 = paddingLeft;
                                    d7 = height;
                                    d6 = width;
                                    d5 = d14;
                                    d4 = d13;
                                    d3 = marginLayoutParams.bottomMargin * f;
                                    d2 = marginLayoutParams.rightMargin * f;
                                } else {
                                    d10 = paddingBottom;
                                    d = paddingTop;
                                    d2 = 0.0d;
                                    d11 = 0.0d;
                                    d12 = 0.0d;
                                    d8 = paddingLeft;
                                    d7 = height;
                                    d6 = width;
                                    d5 = d14;
                                    d4 = d13;
                                    d3 = 0.0d;
                                }
                            }
                            ArrayList arrayList = new ArrayList(8);
                            double d15 = d4 + 0.0d;
                            arrayList.add(Double.valueOf(d15));
                            double d16 = d5 + 0.0d;
                            arrayList.add(Double.valueOf(d16));
                            double d17 = d6 - 0.0d;
                            arrayList.add(Double.valueOf(d17));
                            arrayList.add(Double.valueOf(d16));
                            arrayList.add(Double.valueOf(d17));
                            double d18 = d7 - 0.0d;
                            arrayList.add(Double.valueOf(d18));
                            arrayList.add(Double.valueOf(d15));
                            arrayList.add(Double.valueOf(d18));
                            boxModel.padding = arrayList;
                            ArrayList arrayList2 = new ArrayList(8);
                            double d19 = d15 + d8;
                            arrayList2.add(Double.valueOf(d19));
                            double d20 = d16 + d;
                            arrayList2.add(Double.valueOf(d20));
                            double d21 = d17 - d9;
                            arrayList2.add(Double.valueOf(d21));
                            arrayList2.add(Double.valueOf(d20));
                            arrayList2.add(Double.valueOf(d21));
                            double d22 = d18 - d10;
                            arrayList2.add(Double.valueOf(d22));
                            arrayList2.add(Double.valueOf(d19));
                            arrayList2.add(Double.valueOf(d22));
                            boxModel.content = arrayList2;
                            ArrayList arrayList3 = new ArrayList(8);
                            arrayList3.add(Double.valueOf(d4));
                            arrayList3.add(Double.valueOf(d5));
                            arrayList3.add(Double.valueOf(d6));
                            arrayList3.add(Double.valueOf(d5));
                            arrayList3.add(Double.valueOf(d6));
                            arrayList3.add(Double.valueOf(d7));
                            arrayList3.add(Double.valueOf(d4));
                            arrayList3.add(Double.valueOf(d7));
                            boxModel.border = arrayList3;
                            ArrayList arrayList4 = new ArrayList(8);
                            double d23 = d4 - d11;
                            arrayList4.add(Double.valueOf(d23));
                            double d24 = d5 - d12;
                            arrayList4.add(Double.valueOf(d24));
                            double d25 = d6 + d2;
                            arrayList4.add(Double.valueOf(d25));
                            arrayList4.add(Double.valueOf(d24));
                            arrayList4.add(Double.valueOf(d25));
                            double d26 = d7 + d3;
                            arrayList4.add(Double.valueOf(d26));
                            arrayList4.add(Double.valueOf(d23));
                            arrayList4.add(Double.valueOf(d26));
                            boxModel.margin = arrayList4;
                        }
                    });
                    return;
                }
                LogUtil.w("Failed to get style of an element that does not exist, nodeid=" + getBoxModelRequest.nodeId);
            }
        });
        return getBoxModelResponse;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDocument(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetDocumentResponse getDocumentResponse = new GetDocumentResponse();
        getDocumentResponse.root = (Node) this.mDocument.postAndWait(new UncheckedCallable<Node>() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.taobao.weex.devtools.common.UncheckedCallable
            public Node call() {
                Object rootElement = DOM.this.mDocument.getRootElement();
                DOM dom = DOM.this;
                return dom.createNodeForElement(rootElement, dom.mDocument.getDocumentView(), null);
            }
        });
        return getDocumentResponse;
    }

    @ChromeDevtoolsMethod
    public GetNodeForLocationResponse getNodeForLocation(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        int i;
        GetNodeForLocationResponse getNodeForLocationResponse = new GetNodeForLocationResponse();
        GetNodeForLocationRequest getNodeForLocationRequest = (GetNodeForLocationRequest) this.mObjectMapper.convertValue(jSONObject, GetNodeForLocationRequest.class);
        int i2 = getNodeForLocationRequest.x;
        if (i2 > 0 && (i = getNodeForLocationRequest.y) > 0) {
            getNodeForLocationResponse.nodeId = Integer.valueOf(findViewByLocation(i2, i));
        }
        return getNodeForLocationResponse;
    }

    @ChromeDevtoolsMethod
    public GetSearchResultsResponse getSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetSearchResultsRequest getSearchResultsRequest = (GetSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, GetSearchResultsRequest.class);
        String str = getSearchResultsRequest.searchId;
        if (str == null) {
            LogUtil.w("searchId may not be null");
            return null;
        }
        List<Integer> list = this.mSearchResults.get(str);
        if (list == null) {
            LogUtil.w("\"" + getSearchResultsRequest.searchId + "\" is not a valid reference to a search result");
            return null;
        }
        List<Integer> subList = list.subList(getSearchResultsRequest.fromIndex, getSearchResultsRequest.toIndex);
        GetSearchResultsResponse getSearchResultsResponse = new GetSearchResultsResponse();
        getSearchResultsResponse.nodeIds = subList;
        return getSearchResultsResponse;
    }

    @ChromeDevtoolsMethod
    public void hideHighlight(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.3
            @Override // java.lang.Runnable
            public void run() {
                DOM.this.mDocument.hideHighlight();
            }
        });
    }

    @ChromeDevtoolsMethod
    public void highlightNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final HighlightNodeRequest highlightNodeRequest = (HighlightNodeRequest) this.mObjectMapper.convertValue(jSONObject, HighlightNodeRequest.class);
        if (highlightNodeRequest.nodeId == null) {
            LogUtil.w("DOM.highlightNode was not given a nodeId; JS objectId is not supported");
            return;
        }
        final RGBAColor rGBAColor = highlightNodeRequest.highlightConfig.contentColor;
        if (rGBAColor == null) {
            LogUtil.w("DOM.highlightNode was not given a color to highlight with");
        } else {
            this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.2
                @Override // java.lang.Runnable
                public void run() {
                    Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(highlightNodeRequest.nodeId.intValue());
                    if (elementForNodeId != null) {
                        DOM.this.mDocument.highlightElement(elementForNodeId, rGBAColor.getColor());
                    }
                }
            });
        }
    }

    @ChromeDevtoolsMethod
    public PerformSearchResponse performSearch(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final PerformSearchRequest performSearchRequest = (PerformSearchRequest) this.mObjectMapper.convertValue(jSONObject, PerformSearchRequest.class);
        final ArrayListAccumulator arrayListAccumulator = new ArrayListAccumulator();
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.7
            @Override // java.lang.Runnable
            public void run() {
                DOM.this.mDocument.findMatchingElements(performSearchRequest.query, arrayListAccumulator);
            }
        });
        String valueOf = String.valueOf(this.mResultCounter.getAndIncrement());
        this.mSearchResults.put(valueOf, arrayListAccumulator);
        PerformSearchResponse performSearchResponse = new PerformSearchResponse();
        performSearchResponse.searchId = valueOf;
        performSearchResponse.resultCount = arrayListAccumulator.size();
        return performSearchResponse;
    }

    @ChromeDevtoolsMethod
    public ResolveNodeResponse resolveNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        final ResolveNodeRequest resolveNodeRequest = (ResolveNodeRequest) this.mObjectMapper.convertValue(jSONObject, ResolveNodeRequest.class);
        Object postAndWait = this.mDocument.postAndWait(new UncheckedCallable<Object>() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.4
            @Override // com.taobao.weex.devtools.common.UncheckedCallable
            public Object call() {
                return DOM.this.mDocument.getElementForNodeId(resolveNodeRequest.nodeId);
            }
        });
        if (postAndWait != null) {
            int mapObject = Runtime.mapObject(jsonRpcPeer, postAndWait);
            Runtime.RemoteObject remoteObject = new Runtime.RemoteObject();
            remoteObject.type = Runtime.ObjectType.OBJECT;
            remoteObject.subtype = Runtime.ObjectSubType.NODE;
            remoteObject.className = postAndWait.getClass().getName();
            remoteObject.value = null;
            remoteObject.description = null;
            remoteObject.objectId = String.valueOf(mapObject);
            ResolveNodeResponse resolveNodeResponse = new ResolveNodeResponse();
            resolveNodeResponse.object = remoteObject;
            return resolveNodeResponse;
        }
        JsonRpcError.ErrorCode errorCode = JsonRpcError.ErrorCode.INVALID_PARAMS;
        throw new JsonRpcException(new JsonRpcError(errorCode, "No known nodeId=" + resolveNodeRequest.nodeId, null));
    }

    @ChromeDevtoolsMethod
    public void setAttributesAsText(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetAttributesAsTextRequest setAttributesAsTextRequest = (SetAttributesAsTextRequest) this.mObjectMapper.convertValue(jSONObject, SetAttributesAsTextRequest.class);
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.5
            @Override // java.lang.Runnable
            public void run() {
                Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(setAttributesAsTextRequest.nodeId);
                if (elementForNodeId != null) {
                    DOM.this.mDocument.setAttributesAsText(elementForNodeId, setAttributesAsTextRequest.text);
                }
            }
        });
    }

    @ChromeDevtoolsMethod
    public void setInspectModeEnabled(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetInspectModeEnabledRequest setInspectModeEnabledRequest = (SetInspectModeEnabledRequest) this.mObjectMapper.convertValue(jSONObject, SetInspectModeEnabledRequest.class);
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.DOM.6
            @Override // java.lang.Runnable
            public void run() {
                DOM.this.mDocument.setInspectModeEnabled(setInspectModeEnabledRequest.enabled);
            }
        });
    }
}
