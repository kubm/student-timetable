package com.kubacki.controllers;

import com.kubacki.domain.*;
import com.kubacki.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by KUBACM on 2017-07-15.
 */
@Controller
public class IndexController {


    private SubjectService subjectService;
    private LessonService lessonService;
    private LessonTypeService lessonTypeService;
    private HomeworkService homeworkService;
    private NoteService noteService;
    private TeacherService teacherService;

    @Autowired
    public void setSubjectService(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @Autowired
    public void setLessonService(LessonService lessonService){
        this.lessonService = lessonService;
    }

    @Autowired
    public void setLessonTypeService(LessonTypeService lessonTypeService){
        this.lessonTypeService = lessonTypeService;
    }

    @Autowired
    public void setHomeworkService(HomeworkService homeworkService){
        this.homeworkService = homeworkService;
    }

    @Autowired
    public void setNoteService(NoteService noteService){
        this.noteService = noteService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService){
        this.teacherService = teacherService;
    }


    @RequestMapping("/subjects")
    public String subjects(Model model){
        model.addAttribute("subjects", subjectService.listAll());
        model.addAttribute("lessons", lessonService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        model.addAttribute("teachers", teacherService.listAll());
        model.addAttribute("lesson", new Lesson());
        return "subjects";
    }

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("subjects", subjectService.listAll());
        model.addAttribute("lessons", lessonService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        model.addAttribute("homeworks", homeworkService.listAll());
        model.addAttribute("notes", noteService.listAll());
        model.addAttribute("teachers", teacherService.listAll());
        return "index";
    }

    @RequestMapping(value = "subject", method = RequestMethod.POST)
    public String saveSubject(Subject subject){
        subjectService.saveOrUpdate(subject);
        return "redirect:/";
    }

    @RequestMapping(value = "lesson", method = RequestMethod.POST)
    public String saveLesson(Lesson lesson){
        lessonService.saveOrUpdate(lesson);
        return "redirect:/subjects";
    }

    @RequestMapping(value = "homework", method = RequestMethod.POST)
    public String saveHomework(Homework homework){
        homeworkService.saveOrUpdate(homework);
        return "redirect:/";
    }

    @RequestMapping(value = "note", method = RequestMethod.POST)
    public String saveNote(Note note){
        noteService.saveOrUpdate(note);
        return "redirect:/";
    }

    @RequestMapping("lesson/delete/{id}")
    public String deleteLesson(@PathVariable Integer id){
        lessonService.delete(id);
        return "redirect:/subjects";
    }

}
