public class MAIN {
	public static void main(String[] args) {  
		
        LoginPageView lv = new LoginPageView();    
        
        //DASHBOARD
    	DashboardView dv = new DashboardView();	
    	
        //USER
    	UserView uv = new UserView();
    	UserModel um = new UserModel();
    	UserController uc = new UserController(uv, um);
    	
        //CATEGORY
    	CategoryView cv = new CategoryView();
    	CategoryModel cm = new CategoryModel();
    	CategoryController cc = new CategoryController(cv, cm);
    	
    	//PRODUCT
    	ProductView theView = new ProductView();
    	
        //TRANSACT
        TransactView tv = new TransactView();
        TransactModel tm = new TransactModel();
        TransactController tc = new TransactController(tv, tm);
             
        //ADMINLOGIN
        AdminLoginView frame = new AdminLoginView();
		AdminLoginModel model = new AdminLoginModel();
		AdminLoginController control = new AdminLoginController(frame, model);
		
		//CASHIER
		CashierLoginView clv = new CashierLoginView();
		CashierLoginModel clm = new CashierLoginModel();
		CashierLoginController clc = new CashierLoginController(clv, clm);
       
    	lv.setVisible(true);
    
    	
        
    	
    	
    	
    	
    	
	}

}
