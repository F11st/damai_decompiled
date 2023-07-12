package com.youku.live.dago.widgetlib.ailproom;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpchat.ChatRoom;
import com.youku.live.dago.widgetlib.ailpchat.ChatRoomManager;
import com.youku.live.dago.widgetlib.ailpchat.ConnectState;
import com.youku.live.dago.widgetlib.ailpchat.IChatConnection;
import com.youku.live.dago.widgetlib.ailpchat.MessageDelegate;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dago.widgetlib.ailproom.callback.ResultCallback;
import com.youku.live.dago.widgetlib.ailproom.config.ILRoomConfiguration;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class InteractLiveManager extends AbsInteractLiveManager {
    private static transient /* synthetic */ IpChange $ipChange;
    LiveManager.LiveChangeListener mLivelistener;

    public InteractLiveManager(String str, String str2) {
        this.mRoomId = str;
        this.mSessionId = str2;
        this.mUniqueKey = str + str2;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void addMessageListener(MessageDelegate messageDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489697196")) {
            ipChange.ipc$dispatch("1489697196", new Object[]{this, messageDelegate});
            return;
        }
        AbsILRoom absILRoom = this.room;
        if (absILRoom != null) {
            ChatRoom chatRoom = absILRoom.chatRoom;
        }
        ChatRoomManager.mChatRoomMessageDelegates.get(this.mRoomId).add(messageDelegate);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void createRoom(String str, String str2, ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623758139")) {
            ipChange.ipc$dispatch("623758139", new Object[]{this, str, str2, iLRoomConfiguration, resultCallback});
            return;
        }
        ILRoom iLRoom = new ILRoom(str, str2);
        this.room = iLRoom;
        iLRoom.setImListener(this.mLivelistener);
        this.room.createRoom(resultCallback);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public String getRoomID() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086018787")) {
            return (String) ipChange.ipc$dispatch("1086018787", new Object[]{this});
        }
        return null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public ConnectState getRoomState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823160873")) {
            return (ConnectState) ipChange.ipc$dispatch("823160873", new Object[]{this});
        }
        return null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void joinRoom(String str, String str2, ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654643689")) {
            ipChange.ipc$dispatch("1654643689", new Object[]{this, str, str2, iLRoomConfiguration, resultCallback});
            return;
        }
        if (this.room == null) {
            ILRoom iLRoom = new ILRoom(str, str2);
            this.room = iLRoom;
            iLRoom.setImListener(this.mLivelistener);
        }
        this.room.joinRoom(iLRoomConfiguration, resultCallback);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void linkRoom(String str, ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748789480")) {
            ipChange.ipc$dispatch("-748789480", new Object[]{this, str, resultCallback});
            return;
        }
        AbsILRoom absILRoom = this.room;
        if (absILRoom == null) {
            return;
        }
        absILRoom.linkRoom(str);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void quitRoom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313783977")) {
            ipChange.ipc$dispatch("-313783977", new Object[]{this});
            return;
        }
        leave();
        AbsILRoom absILRoom = this.room;
        if (absILRoom == null) {
            return;
        }
        absILRoom.quitRoom();
        this.room = null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void quitRoomNative() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128534592")) {
            ipChange.ipc$dispatch("2128534592", new Object[]{this});
            return;
        }
        leave();
        AbsILRoom absILRoom = this.room;
        if (absILRoom == null) {
            return;
        }
        absILRoom.quitRoomNative();
        this.room = null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void sendMessage(Map<String, Object> map, ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "320319741")) {
            ipChange.ipc$dispatch("320319741", new Object[]{this, map, resultCallback});
            return;
        }
        AbsILRoom absILRoom = this.room;
        if (absILRoom == null) {
            return;
        }
        absILRoom.sendMessage(map, resultCallback);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void setChatRoomListener(IChatConnection.WeexMessageListener weexMessageListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043005092")) {
            ipChange.ipc$dispatch("-2043005092", new Object[]{this, weexMessageListener});
            return;
        }
        AbsILRoom absILRoom = this.room;
        if (absILRoom != null) {
            ChatRoom chatRoom = absILRoom.chatRoom;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void setLiveListener(LiveManager.LiveChangeListener liveChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080364537")) {
            ipChange.ipc$dispatch("1080364537", new Object[]{this, liveChangeListener});
        } else {
            this.mLivelistener = liveChangeListener;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void switchRoom(String str, ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591859587")) {
            ipChange.ipc$dispatch("-1591859587", new Object[]{this, str, iLRoomConfiguration, resultCallback});
            return;
        }
        AbsILRoom absILRoom = this.room;
        if (absILRoom == null) {
            return;
        }
        absILRoom.switchRoom(str);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsInteractLiveManager
    public void joinRoom(String str, String str2, ILRoomConfiguration iLRoomConfiguration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402766105")) {
            ipChange.ipc$dispatch("-402766105", new Object[]{this, str, str2, iLRoomConfiguration});
            return;
        }
        if (this.room == null) {
            ILRoom iLRoom = new ILRoom(str, str2);
            this.room = iLRoom;
            iLRoom.setImListener(this.mLivelistener);
        }
        this.room.joinRoom(iLRoomConfiguration);
    }
}
