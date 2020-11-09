package edu.geodani.persitence.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ECurrency {
   EURO(1, "EURO"),
   RON(2, "RON"),
   USD(3, "USD");

   private final int id;
   private final String name;

   ECurrency(int id, String name){
      this.id = id;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public String getName() { return name;}
}
