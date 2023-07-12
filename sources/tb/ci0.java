package tb;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Node;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class ci0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ci0 INSTANCE = new ci0();

    private ci0() {
    }

    public final void a(@NotNull Node node) {
        JSONObject data;
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57262354")) {
            ipChange.ipc$dispatch("57262354", new Object[]{this, node});
            return;
        }
        b41.i(node, "itemNode");
        if (node.getType() != 7541 || (data = node.getData()) == null || (string = data.getString("cardType")) == null) {
            return;
        }
        int hashCode = string.hashCode();
        switch (hashCode) {
            case 49:
                if (string.equals("1")) {
                    node.setType(7544);
                    return;
                }
                return;
            case 50:
                if (string.equals("2")) {
                    node.setType(7545);
                    return;
                }
                return;
            case 51:
                if (string.equals("3")) {
                    node.setType(7546);
                    return;
                }
                return;
            case 52:
                if (string.equals("4")) {
                    node.setType(7547);
                    return;
                }
                return;
            case 53:
                if (string.equals("5")) {
                    node.setType(7548);
                    return;
                }
                return;
            case 54:
                if (string.equals("6")) {
                    node.setType(7549);
                    return;
                }
                return;
            case 55:
                if (string.equals("7")) {
                    node.setType(7550);
                    return;
                }
                return;
            case 56:
                if (string.equals("8")) {
                    node.setType(7551);
                    return;
                }
                return;
            case 57:
                if (string.equals("9")) {
                    node.setType(7552);
                    return;
                }
                return;
            default:
                switch (hashCode) {
                    case 1567:
                        if (string.equals("10")) {
                            JSONObject data2 = node.getData();
                            JSONObject jSONObject = data2 != null ? data2.getJSONObject("action") : null;
                            JSONObject data3 = node.getData();
                            node.setData(data3 != null ? data3.getJSONObject("contentCard") : null);
                            JSONObject data4 = node.getData();
                            if (data4 != null) {
                                data4.put("cardType", "10");
                            }
                            JSONObject data5 = node.getData();
                            if (data5 != null) {
                                data5.put("action", (Object) jSONObject);
                            }
                            node.setType(7553);
                            return;
                        }
                        return;
                    case 1568:
                        if (string.equals("11")) {
                            JSONObject data6 = node.getData();
                            JSONObject jSONObject2 = data6 != null ? data6.getJSONObject("action") : null;
                            JSONObject data7 = node.getData();
                            node.setData(data7 != null ? data7.getJSONObject("themeCard") : null);
                            JSONObject data8 = node.getData();
                            if (data8 != null) {
                                data8.put("cardType", "11");
                            }
                            JSONObject data9 = node.getData();
                            if (data9 != null) {
                                data9.put("action", (Object) jSONObject2);
                            }
                            node.setType(7554);
                            return;
                        }
                        return;
                    case 1569:
                        if (string.equals("12")) {
                            JSONObject data10 = node.getData();
                            node.setData(data10 != null ? data10.getJSONObject("voteCard") : null);
                            JSONObject data11 = node.getData();
                            if (data11 != null) {
                                data11.put("cardType", "12");
                            }
                            node.setType(7555);
                            return;
                        }
                        return;
                    case 1570:
                        if (string.equals("13")) {
                            JSONObject data12 = node.getData();
                            node.setData(data12 != null ? data12.getJSONObject("circleCard") : null);
                            JSONObject data13 = node.getData();
                            if (data13 != null) {
                                data13.put("cardType", "13");
                            }
                            node.setType(7556);
                            return;
                        }
                        return;
                    case 1571:
                        if (string.equals("14")) {
                            JSONObject data14 = node.getData();
                            JSONObject jSONObject3 = data14 != null ? data14.getJSONObject("action") : null;
                            JSONObject data15 = node.getData();
                            node.setData(data15 != null ? data15.getJSONObject("contentCard") : null);
                            JSONObject data16 = node.getData();
                            if (data16 != null) {
                                data16.put("cardType", "14");
                            }
                            JSONObject data17 = node.getData();
                            if (data17 != null) {
                                data17.put("action", (Object) jSONObject3);
                            }
                            node.setType(7557);
                            return;
                        }
                        return;
                    default:
                        return;
                }
        }
    }
}
