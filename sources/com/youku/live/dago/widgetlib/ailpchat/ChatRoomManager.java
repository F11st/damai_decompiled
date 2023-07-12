package com.youku.live.dago.widgetlib.ailpchat;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpchat.IChatConnection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ChatRoomManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int sBizCode = 13;
    public static volatile ConcurrentMap<String, ConcurrentMap<String, ChatRoom>> mChatRoomManager = new ConcurrentHashMap();
    public static volatile ConcurrentMap<String, List<MessageDelegate>> mChatRoomMessageDelegates = new ConcurrentHashMap();
    public static volatile ConcurrentMap<String, List<IChatConnection.WeexMessageListener>> mChatRoomWeexListeners = new ConcurrentHashMap();
    public static volatile ConcurrentMap<String, List<IChatConnection.WeexMessageListener>> mRoomIdWeexListeners = new ConcurrentHashMap();
    public static volatile ConcurrentMap<String, Object> weexListenersUpdatedTopics = new ConcurrentHashMap();

    public static ChatRoom createChatRoomByName(String str, String str2, String str3, ChatRoomConfig chatRoomConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562342988")) {
            return (ChatRoom) ipChange.ipc$dispatch("562342988", new Object[]{str, str2, str3, chatRoomConfig});
        }
        String str4 = str + str2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (!mChatRoomManager.containsKey(str4)) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put(str3, new AILPChatRoom(chatRoomConfig));
                mChatRoomManager.put(str4, concurrentHashMap);
            } else if (mChatRoomManager.containsKey(str4) && (mChatRoomManager.get(str4) == null || (mChatRoomManager.get(str4) != null && !mChatRoomManager.get(str4).containsKey(str3)))) {
                ConcurrentMap<String, ChatRoom> concurrentMap = mChatRoomManager.get(str4);
                if (concurrentMap == null) {
                    concurrentMap = new ConcurrentHashMap<>();
                }
                concurrentMap.putIfAbsent(str3, new AILPChatRoom(chatRoomConfig));
                mChatRoomManager.replace(str4, concurrentMap);
            }
            if (mChatRoomManager.get(str4) != null) {
                return mChatRoomManager.get(str4).get(str3);
            }
        }
        return null;
    }

    public static ChatRoom getChatRoomByName(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397847156")) {
            return (ChatRoom) ipChange.ipc$dispatch("-1397847156", new Object[]{str, str2, str3});
        }
        String str4 = str + str2;
        if (hasChatRoom(str4, str3)) {
            return mChatRoomManager.get(str4).get(str3);
        }
        ChatRoomConfig chatRoomConfig = new ChatRoomConfig();
        chatRoomConfig.roomId = str;
        return createChatRoomByName(str, str2, str3, chatRoomConfig);
    }

    public static boolean hasChatRoom(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1764586840") ? ((Boolean) ipChange.ipc$dispatch("-1764586840", new Object[]{str, str2})).booleanValue() : mChatRoomManager.containsKey(str) && mChatRoomManager.get(str) != null && mChatRoomManager.get(str).containsKey(str2);
    }

    public static boolean hasLiveId(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "457578634") ? ((Boolean) ipChange.ipc$dispatch("457578634", new Object[]{str})).booleanValue() : mChatRoomManager.containsKey(str);
    }

    public static boolean removeChatRoomByLiveId(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "769427632")) {
            return ((Boolean) ipChange.ipc$dispatch("769427632", new Object[]{str, str2})).booleanValue();
        }
        String str3 = str + str2;
        if (hasLiveId(str3)) {
            ConcurrentMap<String, ChatRoom> concurrentMap = mChatRoomManager.get(str3);
            if (concurrentMap != null) {
                for (ChatRoom chatRoom : concurrentMap.values()) {
                    if (chatRoom != null) {
                        chatRoom.leave();
                    }
                }
            }
            mChatRoomManager.remove(str3);
            return true;
        }
        return false;
    }

    public static boolean removeChatRoomByName(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387628822")) {
            return ((Boolean) ipChange.ipc$dispatch("387628822", new Object[]{str, str2, str3})).booleanValue();
        }
        String str4 = str + str2;
        if (hasChatRoom(str4, str3)) {
            ChatRoom chatRoom = mChatRoomManager.get(str4).get(str3);
            if (chatRoom != null) {
                chatRoom.leave();
            }
            mChatRoomManager.get(str4).remove(str3);
            return true;
        }
        return false;
    }
}
