package me.sauerbier.worldrepair.pipeline;

import me.sauerbier.worldrepair.nbt.NBTBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTPipeline implements Pipeline<NBTBase>{
    private ArrayList<Channel<NBTBase>> channels = new ArrayList<>();

    @Override
    public void push(final String channel, NBTBase nbt){
        channels.stream()
                .filter(c -> c.getTrigger().equalsIgnoreCase(channel))
                .forEach(c -> c.channelIn(nbt));
    }

    @Override
    public void subscribe(Channel channel){
        channels.add(channel);
    }

    @Override
    public void unsubscribe(Channel channel){
        channels.remove(channel);
    }

    @Override
    public List<Channel<NBTBase>> pipeline(){
        return channels;
    }
}
