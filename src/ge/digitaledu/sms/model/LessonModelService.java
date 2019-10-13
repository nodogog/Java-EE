package ge.digitaledu.sms.model;

import ge.digitaledu.sms.model.entity.Lesson;

import java.sql.SQLException;

public class LessonModelService extends ModelController implements Model {
    private Class<Lesson> tableName;

    public LessonModelService(Class<Lesson> tableName) {
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

        Lesson lesson = (Lesson) obj;
        String insertStr = "" +
                "INSERT INTO `" + tableName.getSimpleName() + "` (id, lessonName, price, lectureName, lessonCredit) " +
                "VALUES ('" + lesson.getId() + "', '" + lesson.getLessonName() + "', '" + lesson.getPrice() + "', '" + lesson.getLectureName() + "', '" + lesson.getLessonCredit() + "')";

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
