package com.youku.arch.v3.view.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ComponentConfigBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ComponentBean> components;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ComponentBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private ItemBean container;
        private LayoutBean layout;
        private String tag;
        private Integer type;
        private List<ItemBean> viewTypes;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public static class ItemBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange;
            private String layoutID;
            private String layoutIDOpt;
            private String model;
            private String modelOpt;
            private HashMap<String, Object> params;
            private String preRender;
            private String present;
            private String presentOpt;
            private String renderPluginFactory;
            private Integer type;
            private String view;
            private String viewHolder;
            private String viewOpt;

            public String getLayoutID() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1171151323") ? (String) ipChange.ipc$dispatch("-1171151323", new Object[]{this}) : this.layoutID;
            }

            public String getLayoutIDOpt() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1296296380") ? (String) ipChange.ipc$dispatch("-1296296380", new Object[]{this}) : this.layoutIDOpt;
            }

            public String getModel() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "2119825279") ? (String) ipChange.ipc$dispatch("2119825279", new Object[]{this}) : this.model;
            }

            public String getModelOpt() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1030811990") ? (String) ipChange.ipc$dispatch("-1030811990", new Object[]{this}) : this.modelOpt;
            }

            public HashMap<String, Object> getParams() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1643833827") ? (HashMap) ipChange.ipc$dispatch("-1643833827", new Object[]{this}) : this.params;
            }

            public String getPreRender() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2005679889") ? (String) ipChange.ipc$dispatch("-2005679889", new Object[]{this}) : this.preRender;
            }

            public String getPresent() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2140741295") ? (String) ipChange.ipc$dispatch("-2140741295", new Object[]{this}) : this.present;
            }

            public String getPresentOpt() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1598880664") ? (String) ipChange.ipc$dispatch("1598880664", new Object[]{this}) : this.presentOpt;
            }

            public String getRenderPluginFactory() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1324752247") ? (String) ipChange.ipc$dispatch("1324752247", new Object[]{this}) : this.renderPluginFactory;
            }

            public Integer getType() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1724406125") ? (Integer) ipChange.ipc$dispatch("1724406125", new Object[]{this}) : this.type;
            }

            public String getView() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2045009531") ? (String) ipChange.ipc$dispatch("-2045009531", new Object[]{this}) : this.view;
            }

            public String getViewHolder() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "2020886993") ? (String) ipChange.ipc$dispatch("2020886993", new Object[]{this}) : this.viewHolder;
            }

            public String getViewOpt() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1685577444") ? (String) ipChange.ipc$dispatch("1685577444", new Object[]{this}) : this.viewOpt;
            }

            public boolean isMVPArchitecture() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1335126550") ? ((Boolean) ipChange.ipc$dispatch("-1335126550", new Object[]{this})).booleanValue() : ((this.model == null || this.present == null || this.view == null) && (this.modelOpt == null || this.presentOpt == null || this.viewOpt == null || this.preRender == null)) ? false : true;
            }

            public void setLayoutID(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1828280487")) {
                    ipChange.ipc$dispatch("-1828280487", new Object[]{this, str});
                } else {
                    this.layoutID = str;
                }
            }

            public void setLayoutIDOpt(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "464533938")) {
                    ipChange.ipc$dispatch("464533938", new Object[]{this, str});
                } else {
                    this.layoutIDOpt = str;
                }
            }

            public void setModel(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-513525545")) {
                    ipChange.ipc$dispatch("-513525545", new Object[]{this, str});
                } else {
                    this.model = str;
                }
            }

            public void setModelOpt(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1772728460")) {
                    ipChange.ipc$dispatch("-1772728460", new Object[]{this, str});
                } else {
                    this.modelOpt = str;
                }
            }

            public void setParams(HashMap<String, Object> hashMap) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1910778693")) {
                    ipChange.ipc$dispatch("1910778693", new Object[]{this, hashMap});
                } else {
                    this.params = hashMap;
                }
            }

            public void setPreRender(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "283228007")) {
                    ipChange.ipc$dispatch("283228007", new Object[]{this, str});
                } else {
                    this.preRender = str;
                }
            }

            public void setPresent(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "740243013")) {
                    ipChange.ipc$dispatch("740243013", new Object[]{this, str});
                } else {
                    this.present = str;
                }
            }

            public void setPresentOpt(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "210776902")) {
                    ipChange.ipc$dispatch("210776902", new Object[]{this, str});
                } else {
                    this.presentOpt = str;
                }
            }

            public void setRenderPluginFactory(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-207663905")) {
                    ipChange.ipc$dispatch("-207663905", new Object[]{this, str});
                } else {
                    this.renderPluginFactory = str;
                }
            }

            public void setType(Integer num) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "409657085")) {
                    ipChange.ipc$dispatch("409657085", new Object[]{this, num});
                } else {
                    this.type = num;
                }
            }

            public void setView(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "736457209")) {
                    ipChange.ipc$dispatch("736457209", new Object[]{this, str});
                } else {
                    this.view = str;
                }
            }

            public void setViewHolder(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "408071213")) {
                    ipChange.ipc$dispatch("408071213", new Object[]{this, str});
                } else {
                    this.viewHolder = str;
                }
            }

            public void setViewOpt(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-902960366")) {
                    ipChange.ipc$dispatch("-902960366", new Object[]{this, str});
                } else {
                    this.viewOpt = str;
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public static class LayoutBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            public static final String MATCH_PARENT = "MATCH_PARENT";
            public static final String WRAP_CONTENT = "WRAP_CONTENT";
            private String adapterClass;
            private String innerAdapterClass;
            private String layoutID;
            private String layoutType;
            private HashMap<String, Object> params;
            private String viewHolder;
            private String width = WRAP_CONTENT;
            private String height = WRAP_CONTENT;

            public String getAdapterClass() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-739331936") ? (String) ipChange.ipc$dispatch("-739331936", new Object[]{this}) : this.adapterClass;
            }

            public String getHeight() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1793591390") ? (String) ipChange.ipc$dispatch("1793591390", new Object[]{this}) : this.height;
            }

            public String getInnerAdapterClass() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1660535486") ? (String) ipChange.ipc$dispatch("1660535486", new Object[]{this}) : this.innerAdapterClass;
            }

            public String getLayoutID() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1502358788") ? (String) ipChange.ipc$dispatch("-1502358788", new Object[]{this}) : this.layoutID;
            }

            public String getLayoutType() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1820808645") ? (String) ipChange.ipc$dispatch("-1820808645", new Object[]{this}) : this.layoutType;
            }

            public HashMap<String, Object> getParams() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-823233946") ? (HashMap) ipChange.ipc$dispatch("-823233946", new Object[]{this}) : this.params;
            }

            public String getViewHolder() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1558093032") ? (String) ipChange.ipc$dispatch("1558093032", new Object[]{this}) : this.viewHolder;
            }

            public String getWidth() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2036624347") ? (String) ipChange.ipc$dispatch("-2036624347", new Object[]{this}) : this.width;
            }

            public boolean isStandardViewHolder() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1643774505") ? ((Boolean) ipChange.ipc$dispatch("-1643774505", new Object[]{this})).booleanValue() : this.layoutID == null || this.viewHolder == null;
            }

            public void setAdapterClass(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1046572482")) {
                    ipChange.ipc$dispatch("-1046572482", new Object[]{this, str});
                } else {
                    this.adapterClass = str;
                }
            }

            public void setHeight(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1628333760")) {
                    ipChange.ipc$dispatch("-1628333760", new Object[]{this, str});
                } else {
                    this.height = str;
                }
            }

            public void setInnerAdapterClass(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "947987320")) {
                    ipChange.ipc$dispatch("947987320", new Object[]{this, str});
                } else {
                    this.innerAdapterClass = str;
                }
            }

            public void setLayoutID(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "789189986")) {
                    ipChange.ipc$dispatch("789189986", new Object[]{this, str});
                } else {
                    this.layoutID = str;
                }
            }

            public void setLayoutType(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1574590723")) {
                    ipChange.ipc$dispatch("1574590723", new Object[]{this, str});
                } else {
                    this.layoutType = str;
                }
            }

            public void setParams(HashMap<String, Object> hashMap) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1579571228")) {
                    ipChange.ipc$dispatch("1579571228", new Object[]{this, hashMap});
                } else {
                    this.params = hashMap;
                }
            }

            public void setViewHolder(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1053639690")) {
                    ipChange.ipc$dispatch("-1053639690", new Object[]{this, str});
                } else {
                    this.viewHolder = str;
                }
            }

            public void setWidth(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-514445071")) {
                    ipChange.ipc$dispatch("-514445071", new Object[]{this, str});
                } else {
                    this.width = str;
                }
            }
        }

        public ItemBean getContainer() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "54659884") ? (ItemBean) ipChange.ipc$dispatch("54659884", new Object[]{this}) : this.container;
        }

        public LayoutBean getLayout() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1626338538") ? (LayoutBean) ipChange.ipc$dispatch("1626338538", new Object[]{this}) : this.layout;
        }

        public String getTag() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1037073599") ? (String) ipChange.ipc$dispatch("1037073599", new Object[]{this}) : this.tag;
        }

        public Integer getType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1527320124") ? (Integer) ipChange.ipc$dispatch("1527320124", new Object[]{this}) : this.type;
        }

        public List<ItemBean> getViewTypes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1119944032") ? (List) ipChange.ipc$dispatch("1119944032", new Object[]{this}) : this.viewTypes;
        }

        public void setContainer(ItemBean itemBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1517507434")) {
                ipChange.ipc$dispatch("-1517507434", new Object[]{this, itemBean});
            } else {
                this.container = itemBean;
            }
        }

        public void setLayout(LayoutBean layoutBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1913031666")) {
                ipChange.ipc$dispatch("1913031666", new Object[]{this, layoutBean});
            } else {
                this.layout = layoutBean;
            }
        }

        public void setTag(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-791908713")) {
                ipChange.ipc$dispatch("-791908713", new Object[]{this, str});
            } else {
                this.tag = str;
            }
        }

        public void setType(Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1405041650")) {
                ipChange.ipc$dispatch("-1405041650", new Object[]{this, num});
            } else {
                this.type = num;
            }
        }

        public void setViewTypes(List<ItemBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-352180220")) {
                ipChange.ipc$dispatch("-352180220", new Object[]{this, list});
            } else {
                this.viewTypes = list;
            }
        }
    }

    public ComponentConfigBean() {
    }

    public List<ComponentBean> getComponents() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2034341211") ? (List) ipChange.ipc$dispatch("-2034341211", new Object[]{this}) : this.components;
    }

    public void setComponents(List<ComponentBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911816505")) {
            ipChange.ipc$dispatch("-1911816505", new Object[]{this, list});
        } else {
            this.components = list;
        }
    }

    public ComponentConfigBean(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = jSONObject.getJSONArray(Constants.COMPONENT);
        if (jSONArray2 == null || jSONArray2.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(jSONArray2.size());
        setComponents(arrayList);
        int i = 0;
        while (i < jSONArray2.size()) {
            JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
            ComponentBean componentBean = new ComponentBean();
            componentBean.setType(jSONObject2.getInteger("type"));
            componentBean.setTag(jSONObject2.getString("tag"));
            JSONObject jSONObject3 = jSONObject2.getJSONObject("container");
            if (jSONObject3 != null) {
                ComponentBean.ItemBean itemBean = new ComponentBean.ItemBean();
                itemBean.setType(jSONObject3.getInteger("type"));
                itemBean.setLayoutID(jSONObject3.getString("layoutID"));
                itemBean.setModel(jSONObject3.getString("model"));
                itemBean.setPresent(jSONObject3.getString("present"));
                itemBean.setView(jSONObject3.getString("view"));
                HashMap<String, Object> hashMap = new HashMap<>();
                itemBean.setParams(hashMap);
                JSONObject jSONObject4 = jSONObject3.getJSONObject("params");
                if (jSONObject4 != null && jSONObject4.size() > 0) {
                    hashMap.putAll(jSONObject4);
                }
                itemBean.setParams(new HashMap<>());
                componentBean.setContainer(itemBean);
            }
            Object obj = jSONObject2.get("viewTypes");
            if (obj == null) {
                jSONArray = jSONArray2;
                componentBean.setViewTypes(Collections.singletonList(componentBean.container));
            } else {
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject5 = (JSONObject) obj;
                    ComponentBean.ItemBean itemBean2 = new ComponentBean.ItemBean();
                    itemBean2.setType(jSONObject5.getInteger("type"));
                    itemBean2.setLayoutID(jSONObject5.getString("layoutID"));
                    itemBean2.setModel(jSONObject5.getString("model"));
                    itemBean2.setPresent(jSONObject5.getString("present"));
                    itemBean2.setView(jSONObject5.getString("view"));
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    itemBean2.setParams(hashMap2);
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("params");
                    if (jSONObject6 != null && jSONObject6.size() > 0) {
                        hashMap2.putAll(jSONObject6);
                    }
                    componentBean.setViewTypes(Collections.singletonList(itemBean2));
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray3 = (JSONArray) obj;
                    if (jSONArray3.size() > 0) {
                        ArrayList arrayList2 = new ArrayList(jSONArray3.size());
                        componentBean.setViewTypes(arrayList2);
                        int i2 = 0;
                        while (i2 < jSONArray3.size()) {
                            JSONObject jSONObject7 = jSONArray3.getJSONObject(i2);
                            JSONArray jSONArray4 = jSONArray2;
                            ComponentBean.ItemBean itemBean3 = new ComponentBean.ItemBean();
                            itemBean3.setType(jSONObject7.getInteger("type"));
                            itemBean3.setLayoutID(jSONObject7.getString("layoutID"));
                            itemBean3.setModel(jSONObject7.getString("model"));
                            itemBean3.setPresent(jSONObject7.getString("present"));
                            itemBean3.setView(jSONObject7.getString("view"));
                            HashMap<String, Object> hashMap3 = new HashMap<>();
                            itemBean3.setParams(hashMap3);
                            JSONObject jSONObject8 = jSONObject7.getJSONObject("params");
                            if (jSONObject8 != null && jSONObject8.size() > 0) {
                                hashMap3.putAll(jSONObject8);
                            }
                            arrayList2.add(itemBean3);
                            i2++;
                            jSONArray2 = jSONArray4;
                        }
                    }
                }
                jSONArray = jSONArray2;
            }
            ComponentBean.LayoutBean layoutBean = new ComponentBean.LayoutBean();
            JSONObject jSONObject9 = jSONObject2.getJSONObject("layout");
            if (jSONObject9 != null) {
                layoutBean.setLayoutType(jSONObject9.getString(Constants.LAYOUT_TYPE));
                layoutBean.setViewHolder(jSONObject9.getString("viewHolder"));
                layoutBean.setInnerAdapterClass(jSONObject9.getString("innerAdapterClass"));
                JSONObject jSONObject10 = jSONObject9.getJSONObject("params");
                HashMap<String, Object> hashMap4 = new HashMap<>();
                layoutBean.setParams(hashMap4);
                if (jSONObject10 != null && jSONObject10.size() > 0) {
                    hashMap4.putAll(jSONObject10);
                }
            }
            componentBean.setLayout(layoutBean);
            arrayList.add(componentBean);
            i++;
            jSONArray2 = jSONArray;
        }
    }
}
