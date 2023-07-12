package com.taobao.weex.devtools.inspector.protocol.module;

import com.taobao.weex.devtools.common.ListUtil;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.elements.Document;
import com.taobao.weex.devtools.inspector.elements.Origin;
import com.taobao.weex.devtools.inspector.elements.StyleAccumulator;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.taobao.weex.devtools.inspector.helper.ChromePeerManager;
import com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.json.ObjectMapper;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CSS implements ChromeDevtoolsDomain {
    private static final HashMap<String, String> sProperties;
    private final Document mDocument;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final ChromePeerManager mPeerManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CSSComputedStyleProperty {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private CSSComputedStyleProperty() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CSSProperty {
        @JsonProperty
        public Boolean disabled;
        @JsonProperty
        public Boolean implicit;
        @JsonProperty
        public Boolean important;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty
        public Boolean parsedOk;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public String text;
        @JsonProperty(required = true)
        public String value;

        private CSSProperty() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CSSRule {
        @JsonProperty
        public Origin origin;
        @JsonProperty(required = true)
        public SelectorList selectorList;
        @JsonProperty
        public CSSStyle style;
        @JsonProperty
        public String styleSheetId;

        private CSSRule() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CSSStyle {
        @JsonProperty(required = true)
        public List<CSSProperty> cssProperties;
        @JsonProperty
        public String cssText;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public List<ShorthandEntry> shorthandEntries;
        @JsonProperty
        public String styleSheetId;

        private CSSStyle() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetComputedStyleForNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;

        private GetComputedStyleForNodeRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetComputedStyleForNodeResult implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<CSSComputedStyleProperty> computedStyle;

        private GetComputedStyleForNodeResult() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetMatchedStylesForNodeRequest {
        @JsonProperty
        public Boolean excludeInherited;
        @JsonProperty
        public Boolean excludePseudo;
        @JsonProperty(required = true)
        public int nodeId;

        private GetMatchedStylesForNodeRequest() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GetMatchedStylesForNodeResult implements JsonRpcResult {
        @JsonProperty
        public List<InheritedStyleEntry> inherited;
        @JsonProperty
        public List<RuleMatch> matchedCSSRules;
        @JsonProperty
        public List<PseudoIdMatches> pseudoElements;

        private GetMatchedStylesForNodeResult() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class InheritedStyleEntry {
        @JsonProperty(required = true)
        public CSSStyle inlineStyle;
        @JsonProperty(required = true)
        public List<RuleMatch> matchedCSSRules;

        private InheritedStyleEntry() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
        protected synchronized void onFirstPeerRegistered() {
            CSS.this.mDocument.addRef();
        }

        @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
        protected synchronized void onLastPeerUnregistered() {
            CSS.this.mDocument.release();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class PseudoIdMatches {
        @JsonProperty(required = true)
        public List<RuleMatch> matches = new ArrayList();
        @JsonProperty(required = true)
        public int pseudoId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class RuleMatch {
        @JsonProperty
        public List<Integer> matchingSelectors;
        @JsonProperty
        public CSSRule rule;

        private RuleMatch() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Selector {
        @JsonProperty
        public SourceRange range;
        @JsonProperty(required = true)
        public String text;

        private Selector() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SelectorList {
        @JsonProperty
        public List<Selector> selectors;
        @JsonProperty
        public String text;

        private SelectorList() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ShorthandEntry {
        @JsonProperty
        public Boolean important;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private ShorthandEntry() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SourceRange {
        @JsonProperty(required = true)
        public int endColumn;
        @JsonProperty(required = true)
        public int endLine;
        @JsonProperty(required = true)
        public int startColumn;
        @JsonProperty(required = true)
        public int startLine;

        private SourceRange() {
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        sProperties = hashMap;
        hashMap.put("width", "");
        hashMap.put("height", "");
        hashMap.put(W3CStyleConstants.PADDING_LEFT, "");
        hashMap.put(W3CStyleConstants.PADDING_TOP, "");
        hashMap.put(W3CStyleConstants.PADDING_RIGHT, "");
        hashMap.put(W3CStyleConstants.PADDING_BOTTOM, "");
        hashMap.put(W3CStyleConstants.BORDER_LEFT_WIDTH, "");
        hashMap.put(W3CStyleConstants.BORDER_TOP_WIDTH, "");
        hashMap.put(W3CStyleConstants.BORDER_RIGHT_WIDTH, "");
        hashMap.put(W3CStyleConstants.BORDER_BOTTOM_WIDTH, "");
        hashMap.put(W3CStyleConstants.MARGIN_LEFT, "");
        hashMap.put(W3CStyleConstants.MARGIN_TOP, "");
        hashMap.put(W3CStyleConstants.MARGIN_RIGHT, "");
        hashMap.put(W3CStyleConstants.MARGIN_BOTTOM, "");
        hashMap.put("left", "");
        hashMap.put("top", "");
        hashMap.put("right", "");
        hashMap.put("bottom", "");
    }

    public CSS(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        ChromePeerManager chromePeerManager = new ChromePeerManager();
        this.mPeerManager = chromePeerManager;
        chromePeerManager.setListener(new PeerManagerListener());
    }

    private void addStyleProperty(List<CSSComputedStyleProperty> list, String str, String str2) {
        CSSComputedStyleProperty cSSComputedStyleProperty = new CSSComputedStyleProperty();
        cSSComputedStyleProperty.name = str;
        cSSComputedStyleProperty.value = str2;
        list.add(cSSComputedStyleProperty);
    }

    private void initMatch(RuleMatch ruleMatch, String str) {
        ruleMatch.matchingSelectors = ListUtil.newImmutableList(0);
        Selector selector = new Selector();
        selector.text = str;
        CSSRule cSSRule = new CSSRule();
        cSSRule.origin = Origin.REGULAR;
        SelectorList selectorList = new SelectorList();
        cSSRule.selectorList = selectorList;
        selectorList.selectors = ListUtil.newImmutableList(selector);
        CSSStyle cSSStyle = new CSSStyle();
        cSSRule.style = cSSStyle;
        cSSStyle.cssProperties = new ArrayList();
        ruleMatch.rule = cSSRule;
        cSSRule.style.shorthandEntries = Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mockStyleProperty(List<CSSComputedStyleProperty> list, HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            addStyleProperty(list, entry.getKey(), entry.getValue());
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getComputedStyleForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetComputedStyleForNodeRequest getComputedStyleForNodeRequest = (GetComputedStyleForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetComputedStyleForNodeRequest.class);
        final GetComputedStyleForNodeResult getComputedStyleForNodeResult = new GetComputedStyleForNodeResult();
        getComputedStyleForNodeResult.computedStyle = new ArrayList();
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.CSS.1
            @Override // java.lang.Runnable
            public void run() {
                Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getComputedStyleForNodeRequest.nodeId);
                if (elementForNodeId != null) {
                    CSS.this.mockStyleProperty(getComputedStyleForNodeResult.computedStyle, CSS.sProperties);
                    CSS.this.mDocument.getElementStyles(elementForNodeId, new StyleAccumulator() { // from class: com.taobao.weex.devtools.inspector.protocol.module.CSS.1.1
                        @Override // com.taobao.weex.devtools.inspector.elements.StyleAccumulator
                        public void store(String str, String str2, boolean z) {
                            if (z) {
                                return;
                            }
                            CSSComputedStyleProperty cSSComputedStyleProperty = new CSSComputedStyleProperty();
                            if (str.startsWith(W3CStyleConstants.V_PREFIX)) {
                                return;
                            }
                            cSSComputedStyleProperty.name = str;
                            cSSComputedStyleProperty.value = str2;
                            getComputedStyleForNodeResult.computedStyle.add(cSSComputedStyleProperty);
                        }
                    });
                    return;
                }
                LogUtil.e("Tried to get the style of an element that does not exist, using nodeid=" + getComputedStyleForNodeRequest.nodeId);
            }
        });
        return getComputedStyleForNodeResult;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getMatchedStylesForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetMatchedStylesForNodeRequest getMatchedStylesForNodeRequest = (GetMatchedStylesForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetMatchedStylesForNodeRequest.class);
        GetMatchedStylesForNodeResult getMatchedStylesForNodeResult = new GetMatchedStylesForNodeResult();
        ArrayList arrayList = new ArrayList();
        final RuleMatch ruleMatch = new RuleMatch();
        initMatch(ruleMatch, "local");
        arrayList.add(ruleMatch);
        final RuleMatch ruleMatch2 = new RuleMatch();
        if (!DOM.isNativeMode()) {
            initMatch(ruleMatch2, "virtual");
            arrayList.add(ruleMatch2);
        }
        getMatchedStylesForNodeResult.matchedCSSRules = arrayList;
        this.mDocument.postAndWait(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.CSS.2
            @Override // java.lang.Runnable
            public void run() {
                Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getMatchedStylesForNodeRequest.nodeId);
                if (elementForNodeId != null) {
                    CSS.this.mDocument.getElementStyles(elementForNodeId, new StyleAccumulator() { // from class: com.taobao.weex.devtools.inspector.protocol.module.CSS.2.1
                        @Override // com.taobao.weex.devtools.inspector.elements.StyleAccumulator
                        public void store(String str, String str2, boolean z) {
                            if (z) {
                                return;
                            }
                            CSSProperty cSSProperty = new CSSProperty();
                            if (!str.startsWith(W3CStyleConstants.V_PREFIX)) {
                                cSSProperty.name = str;
                                cSSProperty.value = str2;
                                ruleMatch.rule.style.cssProperties.add(cSSProperty);
                            } else if (DOM.isNativeMode()) {
                            } else {
                                CSSProperty cSSProperty2 = new CSSProperty();
                                cSSProperty2.name = str;
                                cSSProperty2.value = str2;
                                ruleMatch2.rule.style.cssProperties.add(cSSProperty2);
                            }
                        }
                    });
                    return;
                }
                LogUtil.w("Failed to get style of an element that does not exist, nodeid=" + getMatchedStylesForNodeRequest.nodeId);
            }
        });
        getMatchedStylesForNodeResult.inherited = Collections.emptyList();
        getMatchedStylesForNodeResult.pseudoElements = Collections.emptyList();
        return getMatchedStylesForNodeResult;
    }
}
