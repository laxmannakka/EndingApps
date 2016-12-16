package com.bridgelabz.factorypattern;

import android.util.Log;

/**
 * Created by bridgeit007 on 18/10/16.
 */

public class Sublasee {

    class Poodle implements Dog
    {
        public void speak()
        {
            Log.i("laxman","The poodle says \"arf\"");
        }
    }

    class Rottweiler implements Dog
    {
        public void speak()
        {
            Log.i("laxman","The poodle says \"arf\"");
        }
    }

    class SiberianHusky implements Dog
    {
        public void speak()
        {
            Log.i("laxman","The poodle says \"arf\"");
        }
    }

}
