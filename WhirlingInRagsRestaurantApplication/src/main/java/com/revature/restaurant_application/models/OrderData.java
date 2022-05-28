package com.revature.restaurant_application.models;


import javax.persistence.*;




    @Entity
    @Table(name = "order_menu")
    public class OrderData {

        @Id
<<<<<<< HEAD
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="id")
=======
>>>>>>> cb3dc6719753870502237cc0b97e7f940aaae09e
        private int id;
        @Column(name = "menu_item")
        private String menuItem;
        private String comment;

        @Column(name = "is_favorite")
        private boolean isFavorite;
        @Column(name = "order_date")
        private String orderDate;
        @Column(name = "customer_username")
        private String username;



        public OrderData(int id, String menuItem, String comment, boolean isFavorite, String orderDate, String username) {
            super();
            this.id = id;
            this.menuItem = menuItem;
            this.comment = comment;
            this.isFavorite = isFavorite;
            this.orderDate = orderDate;
            this.username = username;
        }



        public OrderData() {

        }

        // Getters & Setters
        public int getId() {
            return id;
        }


        public void setId(int id) {
            this.id = id;
        }


        public String getMenuItem() {
            return menuItem;
        }

        public void setMenuItem(String menuItem) {
            this.menuItem = menuItem;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public boolean getIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "OrderData{" +
                    "id='" + id + '\'' +
                    ", menuitem='" + menuItem + '\'' +
                    ", comment='" + comment + '\'' +
                    ", isfavorite='" + isFavorite + '\'' +
                    ", orderdate='" + orderDate + '\'' +
                    ", username='" + username + '\'' +
                    '}';
        }


    }

