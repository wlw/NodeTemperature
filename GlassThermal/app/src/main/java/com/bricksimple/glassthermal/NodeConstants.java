package com.bricksimple.glassthermal;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;

/**
 * Created by billwhitman on 8/26/14.
 */

public abstract class NodeConstants {
    public static final int             MESSAGE_THERMA_TEMPERATURE = 1;
    public static final String          FLOAT_VALUE_KEY = "FLOAT_READING_KEY";
    public static       BluetoothGatt   mBluetoothGatt = null;
    public static       BluetoothDevice bluetoothDevice = null;
    public static       int             bluetoothStatus;
    public static final int             BLE_SCANNING = 0;
    public static final int             BLE_CONNECTING = 1;
    public static final int             BLE_CONNECTED = 2;
    public static final int             BLE_FAILED = 3;
    public static       boolean         bleWaiting;
    public static       boolean         bRunning;
}
