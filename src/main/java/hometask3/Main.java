package hometask3;

import hometask3.db.IDbExecutor;
import hometask3.db.MySqlDbExecutor;
import hometask3.tables.AbsTable;
import hometask3.tables.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDbExecutor iDbExecutor = new MySqlDbExecutor();
        AbsTable student = new Student();

        try{
            ResultSet tables = iDbExecutor.execute("show tables;", true);
            boolean isTableCreated = false;
            while (tables.next()){
                if(tables.getString(1).equals("students")){
                    isTableCreated = true;
                    break;
                }
            }

            if(isTableCreated){
                student.delete();
            }
            student.create();
            iDbExecutor.execute("INSERT INTO students values ('Ivan', 'Ivanov')", false);
            ResultSet students = iDbExecutor.execute("SELECT * FROM students", true);
            while(students.next()){
                System.out.println(students.getString(1));
                System.out.println(students.getString(2));
            }
        }finally {
            student.getiDbExecutor().close();
        }
    }
}
