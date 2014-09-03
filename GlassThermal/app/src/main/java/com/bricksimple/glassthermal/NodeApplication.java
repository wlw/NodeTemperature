package com.bricksimple.glassthermal;

import android.bluetooth.BluetoothDevice;
import android.app.Application;
import java.util.ArrayList;
import com.variable.framework.android.bluetooth.BluetoothService;
import com.variable.framework.node.NodeDevice;

/**
 * Created by billwhitman on 8/25/14.
 */
public class NodeApplication extends Application {

    private static BluetoothService mBluetoothService;
    //public  final ArrayList<BluetoothDevice> mDiscoveredDevices = new ArrayList<BluetoothDevice>();
    public static NodeDevice mActiveNode;

    public static final BluetoothService getService(){
        return mBluetoothService;
    }

    public static final BluetoothService setServiceAPI(BluetoothService api){
        mBluetoothService = api;
        return mBluetoothService;
    }

    public static void setActiveNode(NodeDevice node){ mActiveNode = node; }

    public static NodeDevice getActiveNode(){  return mActiveNode; }

}
