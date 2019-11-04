package com;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Serializable {
     private Integer id;
     private String name;
     private float avgValue;
     private transient String unvisible = "Hello Ilya";

     public Person(Integer id, String name, float avgValue) {
         this.id = id;
         this.name = name;
         this.avgValue = avgValue;
     }

     public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getAvgValue() {
            return avgValue;
        }

        public void setAvgValue(float avgValue) {
            this.avgValue = avgValue;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", avgValue=" + avgValue +
                    '}';
        }
 }
