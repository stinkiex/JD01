package com;

public class ComandLine {
    public static String fileOpen(){
        String []args=null;
        String arr="";
        if (args[0]!=null){
            for (int i=0; i<args.length;i++){
                arr=arr+args[i];
            }
        }
        return arr;
    }
}
