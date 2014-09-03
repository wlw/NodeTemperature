package com.bricksimple.glassthermal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import java.util.Set;

/**
 * Created by billwhitman on 8/26/14.
 */
public class BleInterfacing {

    BluetoothManager bluetoothManager = null;
    BluetoothAdapter mBluetoothAdapter = null;

    public void FindNodeDevice(Context applicationContext) {

        if(bluetoothManager == null) {
            bluetoothManager =
                    (BluetoothManager) applicationContext.getSystemService(Context.BLUETOOTH_SERVICE);
            mBluetoothAdapter = bluetoothManager.getAdapter();
            /* WLW
            if((mBluetoothAdapter == null) || ( mBluetoothAdapter.isEnabled() == false)) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
            */
        }

        Set<BluetoothDevice> pairedDevice = mBluetoothAdapter.getBondedDevices();
        for(BluetoothDevice device : pairedDevice) {
            NodeConstants.bluetoothDevice = device;
            Log.d("PAIRED DEVICE:", device.getAddress());
        }
        //boolean bRtn = mBluetoothAdapter.startLeScan(mLeScanCallback);
        //if(bRtn == false)
        //    Log.d("StartLeScan", "Did not start");
    }

    public BluetoothAdapter.LeScanCallback mLeScanCallback =
            new BluetoothAdapter.LeScanCallback() {
                @Override
                public void onLeScan(final BluetoothDevice device, final int rssi, byte[] scanRecord) {
                    String  name = device.getName();
                    String macAddress = device.getAddress();
                    //Log.d("DEVICE:", name);
                    if((name != null) && (name.startsWith("NODE"))) {
                        name = device.getName();
                        NodeConstants.bluetoothDevice = device;
                        mBluetoothAdapter.stopLeScan(mLeScanCallback);
                        /* WLW
                        try {
                            device.getClass().getMethod("createBond", (Class[])null).invoke(device, (Object[]) null);
                            device.getClass().getMethod("setPairingConfirmation", boolean.class).invoke(device, true);
                            device.getClass().getMethod("cancelPairingUserInput", boolean.class).invoke(device);
                        }
                        catch(Exception e) {
                            Log.e("PairDevice()", e.getMessage());
                        }
                        */
                        //NodeApplication.mDiscoveredDevices.add(device);
                    }
                    /* WLW
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String  name = device.getName();
                            String macAddress = device.getAddress();
                            boolean bNewDevice = true;
                            int     myNdx;
                            //myarrayAdapter.notifyDataSetChanged();
                            String id = device.toString();
                            if(IsThisMyDevice(name, macAddress)) {
                                Log.d("CANCELLING and DISCOVERY", "CANCEL");
                                if(mBluetoothAdapter.cancelDiscovery() == false)
                                    Log.d("ERROR ON CANCEL", "CANCEL DISCOVERY");
                                if(bNewDevice)  { // new device get battery level
                                    //Log.d("STARTING CONNECTION", "CONNECTGATT");
                                    CONSTANTS.bluetoothDevice = device;
                                    mBluetoothAdapter.stopLeScan(mLeScanCallback);  // temporary to stop scanning
                                    CONSTANTS.mBluetoothGatt = device.connectGatt(getApplicationContext(), false, mGattCallBacks);
                                    CONSTANTS.bluetoothConnected = true;
                                }
                            }
                        }

                    });
                    */
                }

            };

}
