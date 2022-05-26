package com.revature.restaurant_application.services;

import com.revature.restaurant_application.daos.MenuDao;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;
import com.revature.restaurant_application.models.MenuData;

import java.io.IOException;
import java.util.ArrayList;

public class MenuServices {

   private MenuDao menuDao;

    public MenuServices(MenuDao menuDao){
        this.menuDao = menuDao;
    }

    public MenuData CreateMenuItem(MenuData newMenuData){

        if(!validateMenuItem(newMenuData)) {
            throw new InvalidRequestException("Menu input was not validated, either empty Strings or null values");
        }

        MenuData persistedMenuItem = menuDao.Create(newMenuData);
        if(persistedMenuItem == null) {
            throw new ResourcePersistenceException("Menu item was not persisted to the database");
        }
        return new MenuData();
        }

        public ArrayList<MenuData> readAll() throws IOException {
            ArrayList<MenuData> menuItem = menuDao.findAll();
            return menuItem;
        }

        public MenuData readByID(String menuItem){
            MenuData singleMenuItem = menuDao.findByID(menuItem);
            return singleMenuItem;
            }

        public MenuData update(MenuData updatedMenuItem){
            if(!menuDao.update((updatedMenuItem))){
                return null;
            }
            return updatedMenuItem;
            }

            public boolean delete(String menuItem){
            return menuDao.delete(menuItem);
            }

            public boolean validateMenuItem (MenuData newMenuData){
            if(newMenuData == null) return false;
            if(newMenuData.getMenuItem() == null || newMenuData.getMenuItem().trim().equals((""))) return false;
            if(newMenuData.getCost() == 0 ) return false;
            if(newMenuData.getProtein() == null || newMenuData.getProtein().trim().equals((""))) return false;
            if(newMenuData.getIsSubstitutable() == false ) return false;
            return true;
            }
    }



