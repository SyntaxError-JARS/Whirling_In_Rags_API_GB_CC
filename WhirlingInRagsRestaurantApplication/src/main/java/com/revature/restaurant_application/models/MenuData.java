package com.revature.restaurant_application.models;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class MenuData {

        @Id
        @Column(name = "item_name")
        private String menuItem;
        private int cost;
        private String protein;
        @Column(name = "is_substitutable")
        private boolean isSubstitutable;


        public MenuData(String menuItem, int cost, String protein, boolean isSubstitutable) {
            super();
            this.menuItem = menuItem;
            this.cost = cost;
            this.protein = protein;
            this.isSubstitutable = isSubstitutable;
        }

        public MenuData(){

        }


       // public boolean equals(Object o) {
      //      if (this == o) return true;
       //     if (!(o instanceof Pokemon)) return false;
       //     Pokemon pokemon = (Pokemon) o;
        //    return getHp() == pokemon.getHp() && getAtk() == pokemon.getAtk() && Objects.equals(getPokemonName(), pokemon.getPokemonName()) && Objects.equals(getElementType(), pokemon.getElementType()) && Objects.equals(getAbility1(), pokemon.getAbility1()) && Objects.equals(getAbility2(), pokemon.getAbility2());
       // }


       // public int hashCode() {
        //    return Objects.hash(getPokemonName(), getHp(), getAtk(), getElementType(), getAbility1(), getAbility2());
        //}

        public String getMenuItem() {
            return menuItem;
        }

        public void setMenuItem(String menuItem) {
            this.menuItem = menuItem;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getProtein() {
            return protein;
        }

        public void setProtein(String protein) {
            this.protein = protein;
        }

        public boolean getIsSubstitutable() {
            return isSubstitutable;
        }

        public void setIsSubstitutable(boolean isSubstitutable) {
            this.isSubstitutable = isSubstitutable;
        }

    @Override
    public String toString() {
        return "MenuData{" +
                "menuItem='" + menuItem + '\'' +
                ", cost=" + cost +
                ", protein=" + protein +
                ", isSubstitutable=" + isSubstitutable +
                '}';
    }
        }


