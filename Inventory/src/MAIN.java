

public class MAIN {

	public static void main(String[] args) {
		//USER
    	UserView uv = new UserView();
    	UserModel um = new UserModel();
    	UserController uc = new UserController(uv, um);
    	
        //CATEGORY
    	CategoryView cv = new CategoryView();
    	CategoryModel cm = new CategoryModel();
    	CategoryController cc= new CategoryController(cv, cm);
    	//PRODUCT
    	//ProductView theView = new ProductView();
    	//ProductModel theModel = new ProductModel();
    	//ProductController theController = new ProductController(theView, theModel);
    	
        //TRANSACT
        TransactView tv = new TransactView();
        TransactModel tm = new TransactModel();
        TransactController tc = new TransactController(tv, tm);
        
        //LOGINPAGE
        //CASHIERLOGIN
        CashierLoginView clv =  new CashierLoginView();
        CashierLoginModel clm =  new CashierLoginModel();
        CashierLoginController clc =  new CashierLoginController(clv, clm);
        //ADMINLOGIN
    	AdminLoginView av =  new AdminLoginView();
    	AdminLoginModel am =  new AdminLoginModel();
    	AdminLoginController ac =  new AdminLoginController(av, am);
        //DASHBOARD
    	clv.setVisible(true);
	}

}
