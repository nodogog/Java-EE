package ge.digitaledu.sms.controller;

import ge.digitaledu.sms.model.LessonModelService;
import ge.digitaledu.sms.model.Model;
import ge.digitaledu.sms.model.entity.Lesson;
import ge.digitaledu.sms.utils.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LessonController extends MainController {

    Model model = new LessonModelService(Lesson.class);

    @Override
    protected void request(HttpServletRequest request, HttpServletResponse response, Method method) {

        if (method == Method.POST) {
            boolean edit = Boolean.valueOf(request.getParameter("edit"));
            String lessonName = request.getParameter("lessonName");
            double price = Double.parseDouble(request.getParameter("price"));
            String lectureName = request.getParameter("lectureName");
            int lessonCredit = Integer.parseInt(request.getParameter("lessonCredit"));

            Lesson lesson = new Lesson();
            lesson.setLectureName(lectureName);
            lesson.setLessonCredit(lessonCredit);
            lesson.setLessonName(lessonName);
            lesson.setPrice(price);

            if (edit) {
                model.delete(Integer.parseInt(request.getParameter("id")));
            } else {
                model.save(lesson);
            }

            try {
                response.sendRedirect(request.getContextPath() + "/Lesson");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (method == Method.GET) {
            String action = request.getParameter("action");
            if (action.equals("delete")) {
                deleteData(model, request, response, Integer.parseInt(request.getParameter("id")));
            }
        }
    }


    private void deleteData(Model model, HttpServletRequest request, HttpServletResponse response, int id) {
        try {
            model.delete(id);
            response.sendRedirect(request.getContextPath() + "/Lesson");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}