package com.ez08.eznet.interfacies.common_interfacies.server;


import com.ez08.eznet.core.protocol.IReaderProtocol;
import com.ez08.eznet.interfacies.common_interfacies.client.IDisConnectable;
import com.ez08.eznet.interfacies.common_interfacies.client.ISender;

import java.io.Serializable;

public interface IClient extends IDisConnectable, ISender<IClient>, Serializable {

    String getHostIp();

    String getHostName();

    String getUniqueTag();

    void setReaderProtocol(IReaderProtocol protocol);

    void addIOCallback(IClientIOCallback clientIOCallback);

    void removeIOCallback(IClientIOCallback clientIOCallback);

    void removeAllIOCallback();

}
