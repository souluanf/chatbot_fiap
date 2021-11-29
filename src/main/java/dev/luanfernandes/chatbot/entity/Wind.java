package dev.luanfernandes.chatbot.entity;

import lombok.*;

@Value
public class Wind {
    double speed;
    int deg;
    double gust;
}
