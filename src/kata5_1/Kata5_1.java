package kata5_1;

public class Kata5_1 {

     public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\yuncai\\Documents\\NetBeansProjects\\kata5\\sqllite\\miercoles.db.db";
        DataBase database = new DataBase(url);
        database.open();

        database.select_PERSONAS();
        
        People people = new People("Santiago","Sanchez","Marketing");
        database.insert_PERSONAS(people);
 
        System.out.println(" * * * * * * * * *");
        
        database.select_PERSONAS();
        
        database.close();
    }
    
}
