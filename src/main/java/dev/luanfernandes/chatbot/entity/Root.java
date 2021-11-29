package dev.luanfernandes.chatbot.entity;

import lombok.Value;

import java.util.List;


@Value
public class Root {
    Coord coord;
    List<Weather> weather;
    String base;
    Main main;
    int visibility;
    Wind wind;
    Clouds clouds;
    int dt;
    Sys sys;
    int timezone;
    int id;
    String name;
    int cod;
}
