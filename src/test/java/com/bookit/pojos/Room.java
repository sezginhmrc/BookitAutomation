package com.bookit.pojos;

import java.util.Objects;


public class Room {

     int id;
     String name;
     String description;
     int capacity;
     boolean withTV;
     boolean withWhiteBoard;


    public Room(){

    }


    public Room(String name, String description, int capacity, boolean withTV, boolean withWhiteBoard) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.withTV = withTV;
        this.withWhiteBoard = withWhiteBoard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isWithTV() {
        return withTV;
    }

    public void setWithTV(boolean withTV) {
        this.withTV = withTV;
    }

    public boolean isWithWhiteBoard() {
        return withWhiteBoard;
    }

    public void setWithWhiteBoard(boolean withWhiteBoard) {
        this.withWhiteBoard = withWhiteBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return id == room.id &&
                capacity == room.capacity &&
                withTV == room.withTV &&
                withWhiteBoard == room.withWhiteBoard &&
                name.equals(room.name) &&
                description.equals(room.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, capacity, withTV, withWhiteBoard);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", withTV=" + withTV +
                ", withWhiteBoard=" + withWhiteBoard +
                '}';
    }

}
