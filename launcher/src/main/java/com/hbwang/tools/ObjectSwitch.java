package com.hbwang.tools;

public class ObjectSwitch {

    private static ObjectSwitch mObjectSwitch;

    private ObjectSwitch() {
    }

    public static ObjectSwitch getObjectSwitch() {
        if (mObjectSwitch == null) {
            mObjectSwitch = new ObjectSwitch();
        }
        return mObjectSwitch;
    }

    public Object Switch(Object obj) {
        return null;
    }

}
