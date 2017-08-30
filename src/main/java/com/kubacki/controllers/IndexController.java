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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.Math.floor;


/**
 * Created by KUBACM on 2017-07-15.
 */
@Controller
public class IndexController {
    private Calendar c = Calendar.getInstance();
    private int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();


    private SubjectService subjectService;
    private LessonService lessonService;
    private LessonTypeService lessonTypeService;
    private HomeworkService homeworkService;
    private NoteService noteService;
    private TeacherService teacherService;
    private LessonPrinterService lessonPrinterService;
    private RoomService roomService;
    private ColourService colourService;
    private EvaluationService evaluationService;
    private EvalTypeService evalTypeService;
    private EventPrinterService eventPrinterService;

    @Autowired
    public void setEventPrinterService(EventPrinterService eventPrinterService) {
        this.eventPrinterService = eventPrinterService;
    }

    @Autowired
    public void setEvaluationService(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @Autowired
    public void setEvalTypeService(EvalTypeService evalTypeService) {
        this.evalTypeService = evalTypeService;
    }

    @Autowired
    public void setColourService(ColourService colourService) {
        this.colourService = colourService;
    }

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

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("todayLessons", lessonService.findByWeekDay(dayOfWeek));
        model.addAttribute("lessonsMonday",floor(lessonPrinterService.numOfMinutes(2)/5.4));//minuty/45/12*100
        model.addAttribute("lessonsTuesday", floor(lessonPrinterService.numOfMinutes(3)/5.4));
        model.addAttribute("lessonsWednesday",floor(lessonPrinterService.numOfMinutes(4)/5.4));
        model.addAttribute("lessonsThursday",floor(lessonPrinterService.numOfMinutes(5)/5.4));
        model.addAttribute("lessonsFriday",floor(lessonPrinterService.numOfMinutes(6)/5.4));
        model.addAttribute("notes", noteService.listTop5OrderedByDate());
        model.addAttribute("evals", evaluationService.listFirst4Evals());
        model.addAttribute("homeworks",homeworkService.listAll());
        model.addAttribute("homework", new Homework());
        model.addAttribute("lessons", lessonService.listAll());

        return "index";
    }

    @RequestMapping("/calendar")
    public String calendar(Model model)
    {
        return "calendar";
    }

    @RequestMapping("/subjects")
    public String subjects(Model model){

        model.addAttribute("subjects", subjectService.listAll());
        model.addAttribute("subject", new Subject());
        model.addAttribute("lessons", lessonService.findAllByOrderByWeekDayAsc());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        model.addAttribute("teachers", teacherService.listAll());
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("rooms", roomService.listAll());
        model.addAttribute("colours",colourService.listAll());

        return "subjects";
    }

    @RequestMapping("/evals")
    public String evaluations(Model model){
        model.addAttribute("evals", evaluationService.listAllOrderedByDate());
        model.addAttribute("evaluation",new Evaluation());
        model.addAttribute("evalTypes", evalTypeService.listAll());
        model.addAttribute("lessons", lessonService.findAllByOrderByWeekDayAsc());
        model.addAttribute("rooms", roomService.listAll());

        return "evals";
    }

    @RequestMapping("/notes/subject/{id}")
    public String notesByLesson(@PathVariable Integer id, Model model){
        model.addAttribute("notes", noteService.findByLesson(lessonService.getById(id)));
        model.addAttribute("today_date", dateFormat.format(date));
        model.addAttribute("note", new Note());
        model.addAttribute("lesson", lessonService.getById(id));
        model.addAttribute("lessons",lessonService.listAll());
        return "notes";
    }

    @RequestMapping("/rooms")
    public String rooms(Model model){
//        List<Room> rooms = roomService.findAll();
//        List<Room> roomsModified = new ArrayList<>();
//        rooms.forEach(room -> {
//            if (room.getRoomNumber() != "" && room.getBuilding()!=""){
//                roomsModified.add(room);
//            }
//        });
        model.addAttribute("rooms",roomService.listAll());
        model.addAttribute("room", new Room());
        return "rooms";
    }

    @RequestMapping("/teachers")
    public String teachers(Model model){
        model.addAttribute("teachers",teacherService.listAll());
        model.addAttribute("teacher",new Teacher());
        return "teachers";
    }

    //-------- JSONs ----------//
    @RequestMapping(value="/lessonsJSON",method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<LessonList> lessonsList(){
        return lessonPrinterService.findByQuery();
    }

    @RequestMapping(value="/eventsJSON", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    List<EventList> eventList(){
        return eventPrinterService.findByQuery();
    }

    //------- Dodawanie --------//
    @RequestMapping("/notes/new")
    public String addNewNote(Model model){
        model.addAttribute("note", new Note());
        model.addAttribute("lessons", lessonService.listAll());
        model.addAttribute("today_date", dateFormat.format(date));
        return "noteformnew";
    }
    @RequestMapping(value = "subject", method = RequestMethod.POST)
    public String saveSubject(Subject subject){
        subjectService.saveOrUpdate(subject);
        return "redirect:/subjects";
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
        return "redirect:/notes/subject/"+note.getLesson().getId();
    }

    @RequestMapping(value = "notenew", method = RequestMethod.POST)
    public String saveNoteNew(Note note){
        noteService.saveOrUpdate(note);
        return "redirect:/";
    }

    @RequestMapping(value = "evaluation", method = RequestMethod.POST)
    public String saveEval(Evaluation evaluation){
        evaluationService.saveOrUpdate(evaluation);
        return "redirect:/evals";
    }

    @RequestMapping(value = "room", method = RequestMethod.POST)
    public String saveRoom(Room room){
        roomService.saveOrUpdate(room);
        return "redirect:/rooms";
    }

    //--------- Edycja ----------//
    @RequestMapping("subject/edit/{id}")
    public String editSubject(@PathVariable Integer id, Model model){
        model.addAttribute("subject", subjectService.getById(id));
        model.addAttribute("colours",colourService.listAll());
        return "subjectform";
    }

    @RequestMapping("lesson/edit/{id}")
    public String editLesson(@PathVariable Integer id, Model model){
        model.addAttribute("lesson", lessonService.getById(id));
        model.addAttribute("teachers", teacherService.listAll());
        model.addAttribute("rooms", roomService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        return "lessonform";
    }

    @RequestMapping("evaluation/edit/{id}")
    public String editEvaluation(@PathVariable Integer id, Model model){
        model.addAttribute("evaluation", evaluationService.getById(id));
        model.addAttribute("evalTypes", evalTypeService.listAll());
        model.addAttribute("lessons", lessonService.listAll());
        model.addAttribute("teachers", teacherService.listAll());
        model.addAttribute("rooms", roomService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        return "evalform";
    }

    @RequestMapping("homework/edit/{id}")
    public String editHomework(@PathVariable Integer id, Model model){
        model.addAttribute("note",noteService.getById(id));
        model.addAttribute("lessons", lessonService.listAll());
        model.addAttribute("homework", homeworkService.getById(id));
        return "homeworkform";
    }

    @RequestMapping("note/edit/{id}")
    public String editNote(@PathVariable Integer id, Model model){
        model.addAttribute("note", noteService.getById(id));

        return "noteform";
    }

    @RequestMapping("room/edit/{id}")
    public String editRoom(@PathVariable Integer id, Model model){
        model.addAttribute("room", roomService.getById(id));
        return "roomform";
    }

    @RequestMapping("teacher/edit/{id}")
    public String editTeacher(@PathVariable Integer id, Model model){
        model.addAttribute("teacher", teacherService.getById(id));
        return "teacherform";
    }



    //------------- Usuwanie ---------//

    @RequestMapping("lesson/delete/{id}")
    public String deleteLesson(@PathVariable Integer id){
        List<Note> notes = noteService.findByLesson(lessonService.getById(id));
        notes.forEach(note -> noteService.delete(note.getId()));
        List<Evaluation> evaluations = evaluationService.listAllByLesson(lessonService.getById(id));
        evaluations.forEach(evaluation -> evaluationService.delete(evaluation.getId()));
        List<Homework> homeworks = homeworkService.findByLesson(lessonService.getById(id));
        homeworks.forEach(homework -> homeworkService.delete(homework.getId()));
        lessonService.delete(id);
        return "redirect:/subjects";
    }

    @RequestMapping("subject/delete/{id}")
    public String deleteSubject(@PathVariable Integer id){
        List<Lesson> lessons = lessonService.findBySubject(subjectService.getById(id));
        lessons.forEach(lesson -> lessonService.delete(lesson.getId()));
        subjectService.delete(id);
        return "redirect:/subjects";
    }


    @RequestMapping("evaluation/delete/{id}")
    public String deleteEval(@PathVariable Integer id){
        evaluationService.delete(id);
        return "redirect:/evals";
    }

    @RequestMapping("homework/delete/{id}")
    public String deleteHomework(@PathVariable Integer id) {
        homeworkService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("note/delete/{id}")
    public String deleteNote(@PathVariable Integer id){
        Integer lessonId = noteService.getById(id).getLesson().getId();
        noteService.delete(id);
        return "redirect:/notes/subject/"+lessonId;
    }

    @RequestMapping("note/delete-toindex/{id}")
    public String deleteNoteToIndex(@PathVariable Integer id){
        noteService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/room/delete/{id}")
    public String deleteRoom(@PathVariable Integer id){
        //Integer newid = 0;
        Integer newid;
        Integer tmp;
        if (roomService.getById(id+1)!=null){
            tmp = id+1;
        } else {
            tmp = id-1;
        }
        newid = tmp;
        List<Lesson> lessons = lessonService.findByRoom(roomService.getById(id));
        List<Evaluation> evaluations = evaluationService.findByRoom(roomService.getById(id));
        lessons.forEach(lesson -> lesson.setRoom(roomService.getById(newid)));
        evaluations.forEach(evaluation -> evaluation.setRoom(roomService.getById(newid)));
        roomService.delete(id);
        return "redirect:/rooms";
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Integer id){
        //Integer newid = 0;
        Integer newid;
        Integer tmp;
        if (teacherService.getById(id+1)!=null){
            tmp = id+1;
        } else if (teacherService.getById(id-1)!= null) {
            tmp = id-1;
        }
        else tmp=null;
        newid = tmp;
        List<Lesson> lessons = lessonService.findByTeacher(teacherService.getById(id));
        lessons.forEach(lesson -> lesson.setTeacher(teacherService.getById(newid)));
        teacherService.delete(id);
        return "redirect:/teachers";
    }



}
