package dev.luanfernandes.chatbot.entity;

import lombok.*;

@Value
public class Sys {
    int type;
    int id;
    String country;
    int sunrise;
    int sunset;
}
