package me.sauerbier.worldrepair.healthchecks;

import me.sauerbier.worldrepair.nbt.NBTTagCompound;
import me.sauerbier.worldrepair.pipeline.Channel;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class ChunkHealth implements Channel<NBTTagCompound>{
    public void channelIn(NBTTagCompound nbtBase){

    }

    public String getTrigger(){
        return "level";
    }
}
