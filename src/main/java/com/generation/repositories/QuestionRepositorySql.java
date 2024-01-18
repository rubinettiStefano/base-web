package com.generation.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.generation.entities.Question;

public class QuestionRepositorySql
{
    private Connection con;

    public QuestionRepositorySql()
    {
        try 
        {
            String versione = "com.mysql.cj.jdbc.Driver";
            Class.forName(versione);   
            String dbInformations = "jdbc:mysql://localhost:3306/questions?user=jaita&password=jaita107";
            con =  DriverManager.getConnection(dbInformations);


        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public List<Question> readAll() 
    {
        try
        {
            List<Question> res = new ArrayList<Question>();
            //Creo le query direttamente qui
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Question");

            while(rs.next())
                res.add(_rsToQuestion(rs));

            return res;
        }
        catch(SQLException e)
        {
            return null;
        }
    }

    private Question _rsToQuestion(ResultSet rs) throws SQLException 
    {
        Question res = new Question();
        res.setId(rs.getInt("id"));
        res.setContent(rs.getString("content"));
        res.setResolved(rs.getBoolean("resolved"));
        return res;
    }

    public Question readById(int id) 
    {
        try
        {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Question WHERE id="+id);

            if(rs.next())
                return _rsToQuestion(rs);
            
            return null;
        }
        catch(SQLException e)
        {
            return null;
        }
    }

    public void insert(Question n) 
    {
        try
        {
            Statement s = con.createStatement();
            String query =  "INSERT INTO Question (id,content,resolved) values ("+
                            n.getId() + "," +
                            "'"+n.getContent() + "'," +
                            n.isResolved() + 
                            ")";

            
            s.execute(query);
    
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Question n) 
    {
        try
        {
            Statement s = con.createStatement();
            String query =  "UPDATE  Question set content='"+n.getContent() + "',resolved=" +n.isResolved() + 
                            " WHERE id="+n.getId();

            s.execute(query);
    
        }
        catch(SQLException e)
        {
            return;
        }
    }

   

    public void delete(int id) 
    {
        try
        {
            Statement s = con.createStatement();
            String query =  "DELETE FROM Question where id="+id;

            s.execute(query);
    
        }
        catch(SQLException e)
        {
            return;
        }
    }

}
