package lk.ijse.dep.app.dao;

import lk.ijse.dep.app.dao.custom.impl.ItemDAOImpl;
import lk.ijse.dep.app.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER, ORDER_DETAIL,QUERY;
    }

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            default:
                return null;
        }
    }

//    public CustomerDAO getCustomerDAO(){
//        return new CustomerDAOImpl();
//    }
//
//    public ItemDAO getItemDAO(){
//        return new ItemDAOImpl();
//    }

}
