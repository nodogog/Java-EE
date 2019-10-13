package ge.digitaledu.sms.controller;

import ge.digitaledu.sms.common.Gender;
import ge.digitaledu.sms.common.StudentStatus;
import ge.digitaledu.sms.model.Model;
import ge.digitaledu.sms.model.StudentModelService;
import ge.digitaledu.sms.model.entity.Student;
import ge.digitaledu.sms.utils.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentController extends MainController {

    @Override
    protected void request(HttpServletRequest request, HttpServletResponse response, Method method) {

        Model model = new StudentModelService(Student.class);

        if (method == Method.POST) {
            boolean edit = Boolean.valueOf(request.getParameter("edit"));
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String bDate = request.getParameter("birthdate");
            String gender = request.getParameter("gender");
            String status = request.getParameter("status");
            String privateNumber = request.getParameter("pn");

            Student student = new Student();

            student.setPn(privateNumber);
            student.setLastName(lastName);
            student.setFirstName(firstName);
            student.setBirthDate(bDate);
            student.setStatus(StudentStatus.valueOf(status));

            if (gender.equals("m")) {
                student.setGender(Gender.MALE);
            } else {
                student.setGender(Gender.FEMALE);
            }


            if (edit) {
                model.delete(Integer.parseInt(request.getParameter("id")));
            } else {
                model.save(student);
            }

            try {
                response.sendRedirect(request.getContextPath() + "/Students");
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
            response.sendRedirect(request.getContextPath() + "/Students");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
