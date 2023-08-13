package com.eazybytes.controllers;

import com.eazybytes.model.Courses;
import com.eazybytes.model.EazyClass;
import com.eazybytes.model.Person;
import com.eazybytes.services.CoursesService;
import com.eazybytes.services.EazyClassService;
import com.eazybytes.services.PersonService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author VietDev
 * @date 11/08/2023
 * @role
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final EazyClassService eazyClassService;
    private final PersonService personService;
    private final CoursesService coursesService;

    @RequestMapping(value = "/displayClasses", method = {RequestMethod.GET})
    public ModelAndView displayClasses(@RequestParam(value = "error", required = false) String error) {
        String errorMessage = null;
        List<EazyClass> eazyClasses = eazyClassService.getAllClasses();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classes.html");
        modelAndView.addObject("eazyClass", new EazyClass());
        modelAndView.addObject("eazyClasses", eazyClasses);
        if (error != null) {
            errorMessage = "Duplicated class name !!!";
        }
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

    @RequestMapping(value = "/addNewClass", method = {RequestMethod.POST})
    public String addNewClass(Model model, @Valid @ModelAttribute EazyClass eazyClass, Errors errors) {
        if (errors.hasErrors()) {
            List<EazyClass> eazyClasses = eazyClassService.getAllClasses();
            model.addAttribute("eazyClasses", eazyClasses);
            return "classes.html";
        }
        EazyClass foundEazyClass = eazyClassService.findClassByName(eazyClass.getName());
        if (foundEazyClass != null) {
            return "redirect:/admin/displayClasses?error=true";
        }
        eazyClassService.save(eazyClass);
        return "redirect:/admin/displayClasses";
    }

    @RequestMapping(value = "/deleteClass", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteClass(@RequestParam Integer classId) {
        EazyClass eazyClass = eazyClassService.getClassById(classId);
        if (eazyClass != null) {
            for (Person person : eazyClass.getPersons()) {
                person.setEazyClass(null);
                personService.save(person);
            }
        }
        eazyClassService.delete(eazyClass);
        return "redirect:/admin/displayClasses";
    }

    @RequestMapping(value = "/displayStudents", method = {RequestMethod.GET})
    public ModelAndView displayStudents(@RequestParam Integer classId, HttpSession session,
                                        @RequestParam(value = "error", required = false) String error) {
        EazyClass eazyClass = eazyClassService.getClassById(classId);
        ModelAndView modelAndView = new ModelAndView("students.html");
        String errorMessage = null;
        if (eazyClass != null) {
            modelAndView.addObject("person", new Person());
            modelAndView.addObject("eazyClass", eazyClass);
            session.setAttribute("eazyClass", eazyClass);
        }
        if (error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public String addStudent(@ModelAttribute Person person, HttpSession session) {
        EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
        Person foundPerson = personService.findByEmail(person.getEmail());
        if (foundPerson == null || foundPerson.isAdmin()) {
            return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId() + "&error=true";
        }
        foundPerson.setEazyClass(eazyClass);
        personService.save(foundPerson);
        eazyClass.getPersons().add(foundPerson);
        session.setAttribute("eazyClass", eazyClass);
        return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId();
    }

    @RequestMapping(value = "/deleteStudent", method = {RequestMethod.GET})
    public String deleteStudent(@RequestParam Integer personId, HttpSession session) {
        EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
        Person foundPerson = personService.findById(personId);
        foundPerson.setEazyClass(null);
        personService.save(foundPerson);
        eazyClass.getPersons().remove(foundPerson);
        session.setAttribute("eazyClass", eazyClass);
        return "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId();
    }

    @RequestMapping(value = "/displayCourses", method = {RequestMethod.GET})
    public String displayCourses(Model model) {
        List<Courses> courses = coursesService.getAllCourses();
        model.addAttribute("course", new Courses());
        model.addAttribute("courses", courses);
        return "courses_secure.html";
    }

    @RequestMapping(value = "/addNewCourse", method = {RequestMethod.POST})
    public String addNewCourse(@ModelAttribute Courses course, Model model) {
        Courses foundCourse = coursesService.findByName(course.getName());
        if (foundCourse == null) {
            coursesService.save(course);
        }
        return "redirect:/admin/displayCourses";
    }

    @RequestMapping(value = "/viewStudents", method = {RequestMethod.GET})
    public String displayStudents(@RequestParam Integer id, Model model, HttpSession session,
                                  @RequestParam(required = false) String error) {
        Courses course = coursesService.findById(id);
        session.setAttribute("course", course);
        model.addAttribute("courses", course);
        model.addAttribute("person", new Person());
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Invalid Email entered!!";
            model.addAttribute("errorMessage", errorMessage);
        }
        return "course_students";
    }

    @RequestMapping(value = "/addStudentToCourse", method = {RequestMethod.POST})
    public String addStudentToCourse(@ModelAttribute Person person, HttpSession session) {
        Person foundPerson = personService.findByEmail(person.getEmail());
        Courses course = (Courses) session.getAttribute("course");
        if (foundPerson == null || foundPerson.isAdmin()) {
            return "redirect:/admin/viewStudents?id=" + course.getCourseId() + "&error=true";
        }
        foundPerson.getCourses().add(course);
        personService.save(foundPerson);
        course.getPersons().add(foundPerson);
        session.setAttribute("course", course);
        return "redirect:/admin/viewStudents?id=" + course.getCourseId();
    }

    @RequestMapping(value = "/deleteStudentFromCourse", method = {RequestMethod.GET})
    public String deleteStudentFromCourse(@RequestParam Integer personId, HttpSession session) {
        Person foundPerson = personService.findById(personId);
        Courses course = (Courses) session.getAttribute("course");
        foundPerson.getCourses().remove(course);
        personService.save(foundPerson);
        course.getPersons().remove(foundPerson);
        session.setAttribute("course", course);
        return "redirect:/admin/viewStudents?id=" + course.getCourseId();
    }
}

