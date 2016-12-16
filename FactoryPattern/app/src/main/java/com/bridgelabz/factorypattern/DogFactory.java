package com.bridgelabz.factorypattern;

/**
 * Created by bridgeit007 on 18/10/16.
 */

public class DogFactory {

    public static Dog getDog(String criteria){
            Sublasee obj= new Sublasee();

        if ( criteria.equals("small") )
            return obj.new Poodle();
        else if ( criteria.equals("big") )
            return obj.new Rottweiler();
        else if ( criteria.equals("working"))
            return obj.new SiberianHusky();

        return null;
    }
}
