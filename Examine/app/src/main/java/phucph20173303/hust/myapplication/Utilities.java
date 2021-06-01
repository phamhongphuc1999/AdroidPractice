package phucph20173303.hust.myapplication;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;

public class Utilities {
    public static String getMacAddress(){
        try{
            List<NetworkInterface> networkInterfaceList =
                    Collections.list(NetworkInterface.getNetworkInterfaces());
            String stringMac = "";
            for(NetworkInterface networkInterface : networkInterfaceList)
            {
                if(networkInterface.getName().equalsIgnoreCase("wlan0"))
                {
                    for(int i = 0 ;i <networkInterface.getHardwareAddress().length; i++){
                        String stringMacByte = Integer.toHexString(networkInterface.getHardwareAddress()[i]&
                                0xFF);
                        if(stringMacByte.length() == 1)
                        {
                            stringMacByte = "0" +stringMacByte;
                        }
                        stringMac = stringMac + stringMacByte.toUpperCase() + ":";
                    }
                    break;
                }
            }
            stringMac = stringMac.substring(0, stringMac.length() - 1);
            return stringMac;
        }catch (SocketException e)
        {
            e.printStackTrace();
        }
        return "0";
    }
}
