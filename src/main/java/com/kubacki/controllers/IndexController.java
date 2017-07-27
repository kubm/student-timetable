package com.kubacki.controllers;

import com.kubacki.domain.*;
import com.kubacki.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


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
    private LessonPrinterService lessonPrinterService;
    private RoomService roomService;

    @Autowired
    public void setRoomService(RoomService roomService){
        this.roomService = roomService;
    }

    @Autowired
    public void setLessonPrinterService(LessonPrinterService lessonPrinterService){
        this.lessonPrinterService = lessonPrinterService;
    }

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
        model.addAttribute("rooms", roomService.listAll());

        return "subjects";
    }

    @RequestMapping(value="/lessonsJSON",method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<LessonList> lessonsList(){
        return lessonPrinterService.findByQuery();
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

    @RequestMapping("lesson/edit/{id}")
    public String editLesson(@PathVariable Integer id, Model model){
        model.addAttribute("lesson", lessonService.getById(id));
        model.addAttribute("teachers", teacherService.listAll());
        model.addAttribute("rooms", roomService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        return "lessonform";
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

    @RequestMapping("subject/delete/{id}")
    public String deleteSubject(@PathVariable Integer id){
        subjectService.delete(id);
        return "redirect:/subjects";
    }



}
