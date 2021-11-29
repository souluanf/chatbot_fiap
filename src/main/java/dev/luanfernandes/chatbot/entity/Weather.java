package dev.luanfernandes.chatbot.entity;

import lombok.*;

@Value
public class Weather {
    int id;
    String main;
    String description;
    String icon;
}
