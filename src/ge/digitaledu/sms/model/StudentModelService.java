package ge.digitaledu.sms.model;

import ge.digitaledu.sms.model.entity.Student;

import java.sql.SQLException;

public class StudentModelService extends ModelController implements Model {
    private Class<Student> tableName;

    public StudentModelService(Class<Student> tableName) {
        this.tableName = tableName;
        try {
            databaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Object obj) {
        openConnection();

        Student student = (Student) obj;
        String insertStr = "" +
                "INSERT INTO `" + tableName.getSimpleName() + "` (id, firstname, lastname, birthdate, gender, lecture, status, pn) " +
                "VALUES ('" + student.getId() + "', '" + student.getFirstName() + "', '" + student.getLastName() + "', '" + student.getBirthDate() + "', '" + student.getGender().name() + "', '" + student.getStatus().name() + "', '" + student.getPn() + "')";

        try {
            statement.executeUpdate(insertStr);
            System.out.println("Successfully added to database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(int id) {
        String deleteStr = "DELETE FROM `" + tableName.getSimpleName() + "` WHERE id = " + id;
        String delAuto = "ALTER TABLE `" + tableName.getSimpleName() + "`AUTO_INCREMENT = " + id;

        openConnection();
        try {
            statement.executeUpdate(deleteStr);
            statement.executeUpdate(delAuto);
            System.out.println("Successfully deleted from database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
