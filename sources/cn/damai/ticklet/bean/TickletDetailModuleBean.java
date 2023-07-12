package cn.damai.ticklet.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TickletDetailModuleBean implements Serializable {
    public static final String ADVERTE_MODULE = "ADVERTE_MODULE";
    public static final int ADVERTE_MODULE_TYPE = 3;
    public static final String BASE_MODULE = "BASE_MODULE";
    public static final int BASE_MODULE_TYPE = 0;
    public static final int DEFULT_TYPE = 5;
    public static final String GO_MODULE = "GO_MODULE";
    public static final int GO_MODULE_TYPE = 1;
    public static final String SCENE_MODULE = "SCENE_MODULE";
    public static final int SCENE_MODULE_TYPE = 2;
    public static final String SERVICE_MODULE = "SERVICE_MODULE";
    public static final int SERVICE_MODULE_TYPE = 4;
    private static final long serialVersionUID = 1;
    public String compSplit;
    public ArrayList<TickletDetailCompViewBean> compViewList;
    public String moduleKey;
}
