package com.example.documentsmanager;



import java.sql.*;

public class DbManager {
    public static int ID_RUBRIQUE=4;
    public static void main(String[] args) throws ClassNotFoundException {

        DbManager manager=new DbManager();
        try
        {
            Connection c= manager.getConnection();
            System.out.println("connexion réussie");
            manager.InsertDoc("testInsert","descInsert");

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }
    public void InsertDoc(String titre, String description) throws SQLException{
        try{
            Connection c=getConnection();
            PreparedStatement stm = c.prepareStatement("insert into Rubrique values (?, ?,?)");
            stm.setInt(1, DbManager.ID_RUBRIQUE);
            stm.setString(2, titre);
            stm.setString(3,description);
            stm.executeUpdate();
            DbManager.ID_RUBRIQUE++;
            System.out.println("Insertion  réussie");

        }
        catch (SQLException e) {
            e.getMessage();
            System.out.println("Insertion échouée");
            System.out.println(e.getMessage());


        }



    }

    public Connection getConnection() throws SQLException
    {
        String host = "localhost";
        //String driver= "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/docs?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        String userName = "florian";
        String password = "superflorianenlimousine";
        Connection con = DriverManager.getConnection(url, userName, password);
        return con;
    }
    public int getIndexFromTitle(String titre)
    {
        try {
            Connection c= this.getConnection();
            boolean foundIndex=false;//si on a trouvé un titre correspondant
            Statement stm=c.createStatement();
            ResultSet result = stm.executeQuery("SELECT numRubrique, titreRubrique FROM Rubrique");
            while(result.next()!=false)
            {
                int currentIndex=result.getInt(1);
                String currentTitre=result.getNString(2);
                if(currentTitre.equals(titre))
                {
                    foundIndex=true;
                    return currentIndex;
                }
            }
            if(foundIndex==false)
            {
                return -1;
            }

        }
        catch (SQLException e) {
            e.getMessage();
            return -1;
        }
        return 0;
    }
}
