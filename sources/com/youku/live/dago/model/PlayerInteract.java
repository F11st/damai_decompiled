package com.youku.live.dago.model;

import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.utils.ColorUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerInteract implements Serializable {
    public static final String ELEMENT_DEFAULT_ACTION = "onClick";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class AddController implements Serializable {
        public List<Controller> HLB;
        public List<Controller> HLT;
        public List<Controller> HMB;
        public List<Controller> HMT;
        public List<Controller> HRB;
        public List<Controller> HRRT;
        public List<Controller> HRT;
        public List<Controller> VRB;
        public List<Controller> VRRT;
        public List<Controller> VRS;
        public List<Controller> VRT;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Content implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String liveId;
        public String size;
        public String tipText;
        public Integer updateUserCount;
        public List updateUserList;
        public String faceUrl = "";
        public String data = "";
        public String text = "";
        public String backgroundColor = "";
        public String textColor = "";
        public int textColorInt = -1;
        public int backgroundColorInt = 0;
        public boolean isHide = false;
        public int width = 0;
        public int height = 0;
        public String num = "";
        public String anchorName = "";
        public String anchorAvatar = "";
        public String anchorFansCount = "";
        public boolean anchorIsFollow = false;
        public boolean showFollowBtn = true;
        public List<String> btnBg = new LinkedList();
        public String iconUrl = "";
        public OnAction onAction = new OnAction();

        public void setBackgroundColor(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-142307079")) {
                ipChange.ipc$dispatch("-142307079", new Object[]{this, str});
                return;
            }
            this.backgroundColor = str;
            this.backgroundColorInt = ColorUtil.parseColor(str, -1);
        }

        public void setTextColor(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "125165432")) {
                ipChange.ipc$dispatch("125165432", new Object[]{this, str});
                return;
            }
            this.textColor = str;
            this.textColorInt = ColorUtil.parseColor(str, -1);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class OnAction implements Serializable {
        public String clickAnchorInfo = "";
        public String clickFollowBtn = "";
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Ret implements Serializable {
        public String key = "";
        public String action = PlayerInteract.ELEMENT_DEFAULT_ACTION;
        public String state = "";
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class State implements Serializable {
        public String state = "";
        public Content content = new Content();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class UpdateControllerContent implements Serializable {
        public String key = "";
        public String state = "";
        public String tag = "";
        public List<State> states = new LinkedList();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Controller implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String area;
        public Content current;
        public String key;
        public ViewGroup.LayoutParams layoutParams;
        public Map<String, Content> mapstates;
        public Ret onClick;
        public Map<String, Object> onClickParams;
        public boolean onPortrait;
        public String state;
        public List<State> states;
        public String type;

        public Controller() {
            this.key = "";
            this.type = "";
            this.states = new LinkedList();
            this.area = "";
            this.state = "";
            this.mapstates = new HashMap();
            this.current = new Content();
            this.onClick = new Ret();
            this.onPortrait = true;
        }

        public void preprocess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1815543079")) {
                ipChange.ipc$dispatch("-1815543079", new Object[]{this});
                return;
            }
            this.mapstates = new HashMap();
            List<State> list = this.states;
            if (list != null) {
                for (State state : list) {
                    if (state != null) {
                        this.mapstates.put(state.state, state.content);
                    }
                }
                if (this.states.size() > 0) {
                    this.current = this.states.get(0).content;
                    this.state = this.states.get(0).state;
                }
            }
            if (this.current == null) {
                this.current = new Content();
            }
            if (this.state == null) {
                this.state = "";
            }
            Ret ret = new Ret();
            this.onClick = ret;
            ret.key = this.key;
            ret.action = PlayerInteract.ELEMENT_DEFAULT_ACTION;
            ret.state = this.state;
        }

        public Controller(Controller controller) {
            this.key = "";
            this.type = "";
            this.states = new LinkedList();
            this.area = "";
            this.state = "";
            this.mapstates = new HashMap();
            this.current = new Content();
            this.onClick = new Ret();
            this.onPortrait = true;
            if (controller == null) {
                return;
            }
            this.key = controller.key;
            this.type = controller.type;
            this.states = controller.states;
            this.mapstates = controller.mapstates;
            this.current = controller.current;
            this.onClick = controller.onClick;
        }
    }
}
