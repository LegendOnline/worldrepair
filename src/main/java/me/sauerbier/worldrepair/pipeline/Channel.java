package me.sauerbier.worldrepair.pipeline;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public interface Channel<T>{

    void channelIn(T t);
    String getTrigger();

}
