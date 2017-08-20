package me.sauerbier.worldrepair;

import me.sauerbier.worldrepair.nbt.CompressedStreamTools;
import me.sauerbier.worldrepair.nbt.NBTTagCompound;
import me.sauerbier.worldrepair.nbt.NBTTagList;
import me.sauerbier.worldrepair.pipeline.NBTPipeline;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTInspector implements Analysable{

    private File world;
    private NBTPipeline pipeline = new NBTPipeline();
    private ArrayList<String> corrupted = new ArrayList<>();

    public void analyse(File file){
        this.world = file;
        File[] regions = world.listFiles();
        if (regions != null){
            for(int i = 0; i < regions.length; ++i){
                if(regions[i].getName().endsWith(".mca")){
                    System.out.println("analysing: " + regions[i].getAbsolutePath());
                    RegionFile regionfile = new RegionFile(regions[i]);

                    for(int x = 0; x < 32; ++x) {
                        for(int z = 0; z < 32; ++z) {
                            if (regionfile.isChunkSaved(x, z)) {
                                DataInputStream datainputstream = regionfile.getChunkDataInputStream(x, z);
                                if (datainputstream == null) {
                                    System.out.println("Failed to fetch input stream");
                                } else {
                                    NBTTagCompound nbttagcompound = null;
                                    try{
                                        nbttagcompound = CompressedStreamTools.read(datainputstream);
                                        datainputstream.close();
                                    } catch(IOException e){
                                        corrupted.add(MessageFormat.format("corrupted chunk ({0},{1}) found in file: {2}", x,z, regions[i].getName() ));
                                        continue;
                                    }
                                    NBTTagCompound level = nbttagcompound.getCompoundTag("Level");
                                    pipeline.push("level", level);
                                    NBTTagList entities = level.getTagList("Entities", 10);
                                    pipeline.push("entities", entities);
                                    NBTTagList sections = level.getTagList("Sections", 10);
                                    pipeline.push("sections", sections);
                                    NBTTagList tileEntities = level.getTagList("TileEntities", 10);
                                    pipeline.push("tileEntities", tileEntities);

                                    for(int j = 0; j < tileEntities.tagCount(); ++j) {
                                        pipeline.push("items",tileEntities.getCompoundTagAt(j).getTagList("Items", 10));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("#############FINISHED#############");
        System.out.println("# Result: " + (corrupted.size() > 0 ? corrupted.size() + " errors!" : "no errors found!"));

        if(corrupted.isEmpty()){
            System.out.println("##################################");
        }else{
            corrupted.forEach(s -> System.out.println("# " + s));
            System.out.println("##################################");
        }
    }


    public NBTPipeline getPipeline(){
        return pipeline;
    }
}
