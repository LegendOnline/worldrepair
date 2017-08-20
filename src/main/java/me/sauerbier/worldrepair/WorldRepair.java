package me.sauerbier.worldrepair;

import me.sauerbier.worldrepair.healthchecks.ChunkHealth;

import java.io.File;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class WorldRepair{

    private NBTInspector inspector = new NBTInspector();

    public static void main(String[] args){
        if(args.length > 0){
            WorldRepair wr = new WorldRepair();

            wr.getInspector().getPipeline().subscribe(new ChunkHealth());

            wr.getInspector().analyse(new File(args[0]));
        }else{
            System.err.println("please provide a valid path to a world folder");
        }
    }

    public NBTInspector getInspector(){
        return inspector;
    }
}
