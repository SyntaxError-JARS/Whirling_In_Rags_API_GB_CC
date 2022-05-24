package com.revature.restaurant_application.services;

import com.revature.restaurant_application.daos.MenuDao;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.models.MenuData;

import java.io.IOException;
import java.util.ArrayList;

public class MenuServices {

 /*   private MenuDao menuDao;

    public MenuServices(MenuDao menuDao){
        this.menuDao = menuDao;
    }

    public MenuData CreateMenu(MenuData newMenuData){

        if(!validateMenu(newMenuData)) {
            throw new InvalidRequestException("Menu input was not validated, either empty Strings or null values");
        }

        MenuData persistedMenu = menuDao.Create(newMenuData);
        if(persistedMenu == null) {
            throw new ResourcePersistenceException("Menu item was not persisted to the database");
        }
        return new MenuData;
        }

        public ArrayList<MenuData> readAll() throws IOException {
        ArrayList<MenuData> menu = menuDao.findAll();
        return menu;

        public MenuData readByID(string menuItem){
            MenuData menu = menuDao.findByID(menuItem);
            return menu;
            }

        public MenuData update(MenuData updatedMenu){
            if(!menuDao.update((updatedMenu))){
                return null;
            }
            return updatedMenu;
            }

            public boolean delete(String menuItem){
            return menuDao.delete(menuItem);
            }

            public boolean validateMenu (MenuData newMenuData){
            if(newMenuData == null) return false;
            if(newMenuData.getMenuItem() == null || newMenuData.getMenuItem().trim().equals((""))) return false;
            if(newMenuData.getCost() == null || newMenuData.getCost().trim().equals((""))) return false;
            if(newMenuData.getProtein() == null || newMenuData.getProtein().trim().equals((""))) return false;
            if(newMenuData.getIsSubstitutable() == null || newMenuData.getIsSubstitutable().trim().equals((""))) return false;
            }
    }
*/
}

