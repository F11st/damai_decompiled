package com.youku.live.dago.widgetlib.ailproom.adapter.userlist;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.net.NetworkProxy;
import com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.AILPMtopListener;
import com.youku.live.dago.widgetlib.util.FastJsonTools;
import com.youku.live.dago.widgetlib.util.Util;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.hn;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UserListView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String MTOP_API_ROOM_USER_LIST_URL = "mtop.youku.live.userlist.v2.get";
    private static final String MTOP_API_VERSION = "1.0";
    private static final String TAG = "UserListView";
    private UserListAdapter mAdapter;
    private String mMode;
    private RecyclerView mRecyclerView;
    private int mUserCount;
    private TextView mUserCountText;
    public IClickCallback onItemClick;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface IClickCallback {
        void onItemClick(UserListBean userListBean);
    }

    public UserListView(Context context, IClickCallback iClickCallback) {
        super(context);
        this.mMode = "normal";
        this.mUserCount = 0;
        this.onItemClick = iClickCallback;
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1317406509")) {
            ipChange.ipc$dispatch("-1317406509", new Object[]{this, context});
        } else if (this.mRecyclerView != null) {
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.dago_pgc_user_list_item_layout, (ViewGroup) this, true);
            this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.user_list_rv);
            this.mUserCountText = (TextView) inflate.findViewById(R.id.user_count_online);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setStackFromEnd(true);
            linearLayoutManager.setOrientation(0);
            this.mRecyclerView.setLayoutManager(linearLayoutManager);
            this.mRecyclerView.setItemAnimator(null);
            UserListAdapter userListAdapter = new UserListAdapter(context, this.onItemClick);
            this.mAdapter = userListAdapter;
            this.mRecyclerView.setAdapter(userListAdapter);
            this.mUserCountText.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1173862280")) {
                        ipChange2.ipc$dispatch("1173862280", new Object[]{this, view});
                        return;
                    }
                    IClickCallback iClickCallback = UserListView.this.onItemClick;
                    if (iClickCallback != null) {
                        iClickCallback.onItemClick(null);
                    }
                }
            });
        }
    }

    public void bubbleUserList(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124701200")) {
            ipChange.ipc$dispatch("-2124701200", new Object[]{this, map});
        } else if (map == null) {
        } else {
            try {
                List<UserListBean> deserializeList = FastJsonTools.deserializeList(new JSONObject(map).optJSONArray("data").toString(), UserListBean.class);
                UserListAdapter userListAdapter = this.mAdapter;
                if (userListAdapter != null) {
                    userListAdapter.clearUserList();
                    this.mAdapter.updateUserList(deserializeList);
                }
            } catch (Exception unused) {
                Log.d(TAG, "setBubbleUserList data error");
            }
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690957037")) {
            ipChange.ipc$dispatch("-690957037", new Object[]{this});
            return;
        }
        TextView textView = this.mUserCountText;
        if (textView != null) {
            this.mUserCount = 0;
            textView.setVisibility(0);
            this.mUserCountText.setText(Util.formatNumber(this.mUserCount));
        }
        UserListAdapter userListAdapter = this.mAdapter;
        if (userListAdapter != null) {
            userListAdapter.clearUserList();
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void reqUserList(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "769036451")) {
            ipChange.ipc$dispatch("769036451", new Object[]{this, str});
            return;
        }
        AILPMtopListener aILPMtopListener = new AILPMtopListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1937455781")) {
                    ipChange2.ipc$dispatch("-1937455781", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(UserListView.TAG, "on error, msg : " + mtopResponse.getRetMsg());
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-411517892")) {
                    ipChange2.ipc$dispatch("-411517892", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
                    return;
                }
                try {
                    if ("SUCCESS".equals(mtopResponse.getRetCode())) {
                        JSONObject dataJsonObject = mtopResponse.getDataJsonObject();
                        UserListView.this.mUserCount = dataJsonObject.optInt("userCount");
                        List<UserListBean> deserializeList = FastJsonTools.deserializeList(dataJsonObject.optJSONArray("result").toString(), UserListBean.class);
                        if (UserListView.this.mUserCountText != null) {
                            UserListView.this.mUserCountText.setVisibility(0);
                            UserListView.this.mUserCountText.setText(Util.formatNumber(UserListView.this.mUserCount));
                        }
                        if (UserListView.this.mAdapter != null) {
                            UserListView.this.mAdapter.clearUserList();
                            UserListView.this.mAdapter.updateUserList(deserializeList);
                            UserListView.this.mRecyclerView.scrollToPosition(0);
                        }
                    }
                } catch (Exception unused) {
                    Log.d(UserListView.TAG, "reqUserList data error");
                }
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1954210196")) {
                    ipChange2.ipc$dispatch("-1954210196", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(UserListView.TAG, "on System error, msg : " + mtopResponse.getRetMsg());
            }
        };
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str + "");
        hashMap.put("pagetIndex", "0");
        hashMap.put(Constants.Name.PAGE_SIZE, MessageService.MSG_DB_COMPLETE);
        NetworkProxy.request(MTOP_API_ROOM_USER_LIST_URL, "1.0", hashMap, true, aILPMtopListener);
    }

    public void setMode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748789125")) {
            ipChange.ipc$dispatch("748789125", new Object[]{this, str});
            return;
        }
        this.mMode = str;
        updateAttributes(str);
    }

    public void setOnItemClickListener(final IClickCallback iClickCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146367604")) {
            ipChange.ipc$dispatch("-2146367604", new Object[]{this, iClickCallback});
            return;
        }
        this.onItemClick = iClickCallback;
        UserListAdapter userListAdapter = this.mAdapter;
        if (userListAdapter != null) {
            userListAdapter.onItemClick = iClickCallback;
        }
        if (iClickCallback == null) {
            this.mUserCountText.setOnClickListener(null);
        } else {
            this.mUserCountText.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1101475722")) {
                        ipChange2.ipc$dispatch("1101475722", new Object[]{this, view});
                        return;
                    }
                    IClickCallback iClickCallback2 = iClickCallback;
                    if (iClickCallback2 != null) {
                        iClickCallback2.onItemClick(null);
                    }
                }
            });
        }
    }

    public void setUserCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833857797")) {
            ipChange.ipc$dispatch("-833857797", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mUserCount = i;
        updateAttributes(this.mMode);
    }

    public void updateAttributes(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113211348")) {
            ipChange.ipc$dispatch("2113211348", new Object[]{this, str});
        } else if (hn.SDK_TYPE.equals(str)) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            TextView textView = this.mUserCountText;
            if (textView != null) {
                textView.setVisibility(0);
                TextView textView2 = this.mUserCountText;
                textView2.setText("在线用户" + Util.formatNumber(this.mUserCount));
            }
        } else {
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
            UserListAdapter userListAdapter = this.mAdapter;
            if (userListAdapter != null) {
                userListAdapter.setMode(str);
            }
            TextView textView3 = this.mUserCountText;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.mUserCountText.setText(Util.formatNumber(this.mUserCount));
            }
        }
    }

    public void updateUserList(List<UserListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529654903")) {
            ipChange.ipc$dispatch("-1529654903", new Object[]{this, list});
        } else if (list == null) {
        } else {
            try {
                UserListAdapter userListAdapter = this.mAdapter;
                if (userListAdapter != null) {
                    userListAdapter.clearUserList();
                    this.mAdapter.updateUserList(list);
                    this.mRecyclerView.scrollToPosition(0);
                }
            } catch (Exception unused) {
                Log.d(TAG, "setBubbleUserList data error");
            }
        }
    }

    public UserListView(Context context) {
        super(context);
        this.mMode = "normal";
        this.mUserCount = 0;
        initView(context);
    }

    public void bubbleUserList(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095213594")) {
            ipChange.ipc$dispatch("-2095213594", new Object[]{this, list});
        } else if (list == null) {
        } else {
            try {
                List<UserListBean> deserializeList = FastJsonTools.deserializeList(new JSONArray((Collection) list).toString(), UserListBean.class);
                UserListAdapter userListAdapter = this.mAdapter;
                if (userListAdapter != null) {
                    userListAdapter.clearUserList();
                    this.mAdapter.updateUserList(deserializeList);
                    this.mRecyclerView.scrollToPosition(0);
                }
            } catch (Exception unused) {
                Log.d(TAG, "setBubbleUserList data error");
            }
        }
    }

    public UserListView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = "normal";
        this.mUserCount = 0;
        initView(context);
    }

    public UserListView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMode = "normal";
        this.mUserCount = 0;
        initView(context);
    }
}
