package com.kubacki.controllers;

import com.kubacki.domain.*;
import com.kubacki.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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

    @RequestMapping("/confirmation")
    public String confirmation(Model model){
        return "confirmation";
    }

    @RequestMapping("/")
    public String index(Model model)
    {
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        if(!lessonPrinterService.findByQuery(userId).isEmpty()){
            Integer lessonsMonday = lessonPrinterService.numOfMinutes(2,userId);
            Integer lessonsTuesday = lessonPrinterService.numOfMinutes(3,userId);
            Integer lessonsWednesday = lessonPrinterService.numOfMinutes(4,userId);
            Integer lessonsThursday = lessonPrinterService.numOfMinutes(5,userId);
            Integer lessonsFriday = lessonPrinterService.numOfMinutes(6,userId);

            if(lessonsMonday != null){
                model.addAttribute("lessonsMonday",floor(lessonsMonday/5.4));//minuty/45/12*100
            } else model.addAttribute("lessonsMonday",0);

            if (lessonsTuesday != null){
                model.addAttribute("lessonsTuesday",floor(lessonsTuesday/5.4));
            } else  model.addAttribute("lessonsTuesday", 0);

            if (lessonsWednesday != null){
                model.addAttribute("lessonsWednesday",floor(lessonsWednesday/5.4));
            } else model.addAttribute("lessonsWednesday",0);

            if (lessonsThursday != null){
                model.addAttribute("lessonsThursday",floor(lessonsThursday/5.4));
            } else model.addAttribute("lessonsThursday",0);

            if (lessonsFriday != null){
                model.addAttribute("lessonsFriday",floor(lessonsFriday/5.4));
            } else model.addAttribute("lessonsFriday",0);

        }else {
            model.addAttribute("lessonsMonday",0);//minuty/45/12*100
            model.addAttribute("lessonsTuesday", 0);
            model.addAttribute("lessonsWednesday",0);
            model.addAttribute("lessonsThursday",0);
            model.addAttribute("lessonsFriday",0);
        }

        model.addAttribute("todayLessons", lessonService.findByWeekDayAndSubject_User(dayOfWeek,currentUser));

        model.addAttribute("notes", noteService.findTop5ByLesson_Subject_UserOrderByDateDesc(currentUser));
        model.addAttribute("evals", evaluationService.findTop4ByLesson_Subject_UserOrderByDzienDesc(currentUser));
        model.addAttribute("homeworks",homeworkService.findByLesson_Subject_User(currentUser));
        model.addAttribute("homework", new Homework());
        model.addAttribute("lessons", lessonService.findBySubject_User(currentUser));
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        model.addAttribute("users",userService.listAll());
        model.addAttribute("roles",roleService.listAll());

        return "index";
    }

    @RequestMapping("/calendar")
    public String calendar(Model model)
    {
        return "calendar";
    }

    @RequestMapping("/subjects")
    public String subjects(Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("subjects", subjectService.findByUser(currentUser));
        model.addAttribute("subjectsAll",subjectService.listAll());
        model.addAttribute("subject", new Subject());
        model.addAttribute("lessons", lessonService.findAllBySubject_UserOrderByWeekDayAsc(currentUser));
        model.addAttribute("allLessons",lessonService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        model.addAttribute("teachers", teacherService.findByUser(currentUser));
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("rooms", roomService.findByUser(currentUser));
        model.addAttribute("colours",colourService.listAll());
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);

        return "subjects";
    }

    @RequestMapping("/evals")
    public String evaluations(Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("evals", evaluationService.findAllByLesson_Subject_UserOrderByDzienAsc(currentUser));
        model.addAttribute("evaluation",new Evaluation());
        model.addAttribute("evalTypes", evalTypeService.listAll());
        model.addAttribute("lessons", lessonService.findAllBySubject_UserOrderByWeekDayAsc(currentUser));
        model.addAttribute("rooms", roomService.findByUser(currentUser));
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "evals";
    }

    @RequestMapping("/notes/subject/{id}")
    public String notesByLesson(@PathVariable Integer id, Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("notes", noteService.findByLesson(lessonService.getById(id)));
        model.addAttribute("today_date", dateFormat.format(date));
        model.addAttribute("note", new Note());
        model.addAttribute("lesson", lessonService.getById(id));
        model.addAttribute("lessons",lessonService.findBySubject_User(currentUser));
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "notes";
    }

    @RequestMapping("/rooms")
    public String rooms(Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

//        List<Room> rooms = roomService.findAll();
//        List<Room> roomsModified = new ArrayList<>();
//        rooms.forEach(room -> {
//            if (room.getRoomNumber() != "" && room.getBuilding()!=""){
//                roomsModified.add(room);
//            }
//        });
        model.addAttribute("rooms",roomService.findByUser(currentUser));
        model.addAttribute("room", new Room());
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "rooms";
    }

    @RequestMapping("/teachers")
    public String teachers(Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("teachers",teacherService.findByUser(currentUser));
        model.addAttribute("teacher",new Teacher());
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "teachers";
    }

    //-------- JSONs ----------//
    @RequestMapping(value="/lessonsJSON",method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<LessonList> lessonsList(){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();

        return lessonPrinterService.findByQuery(userId);
    }

    @RequestMapping(value="/eventsJSON", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    List<EventList> eventList(){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();

        return eventPrinterService.findByQuery(userId);
    }

    //------- Dodawanie --------//

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registration(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register";
        }
        user.addRole(roleService.findAllByRole("USER").get(0));
//        List<Role> roles = roleService.findAllByRole("USER");
//        user.setRoles(roles);
        userService.saveOrUpdate(user);
        return "redirect:/confirmation";
    }

    @RequestMapping("/notes/new")
    public String addNewNote(Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("note", new Note());
        model.addAttribute("lessons", lessonService.findBySubject_User(currentUser));
        model.addAttribute("today_date", dateFormat.format(date));
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "noteformnew";
    }

    @RequestMapping("/user/new")
    public String addNewUser(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("roles", roleService.listAll());

        return "admin/userform";
    }

    @RequestMapping("lesson/new")
    public String addNewLesson(Model model){
        model.addAttribute("subjects", subjectService.listAll());
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("teachers", teacherService.listAll());
        model.addAttribute("allTeachers",teacherService.listAll());
        model.addAttribute("rooms", roomService.listAll());
        model.addAttribute("allRooms",roomService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        return "lessonform";
    }

    @RequestMapping("/subject/new")
    public String addNewSubject(Model model){
        model.addAttribute("subject", new Subject());
        model.addAttribute("colours",colourService.listAll());

        return "subjectform";
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

    @RequestMapping(value = "teacher", method = RequestMethod.POST)
    public String saveTeacher(Teacher teacher){
        teacherService.saveOrUpdate(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping(value = "room", method = RequestMethod.POST)
    public String saveRoom(Room room){
        roomService.saveOrUpdate(room);
        return "redirect:/rooms";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")@Valid User user, BindingResult bindingResult,Model model){
        model.addAttribute("roles",roleService.listAll());
        if (bindingResult.hasErrors()){
            return "admin/userform";
        }
        else {
            userService.saveOrUpdate(user);
            return "redirect:/";
        }
    }

    //--------- Edycja ----------//


    @RequestMapping("subject/edit/{id}")
    public String editSubject(@PathVariable Integer id, Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();

        model.addAttribute("userId", userId);
        model.addAttribute("subject", subjectService.getById(id));
        model.addAttribute("colours",colourService.listAll());
        return "subjectform";
    }

    @RequestMapping("lesson/edit/{id}")
    public String editLesson(@PathVariable Integer id, Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("lesson", lessonService.getById(id));
        model.addAttribute("teachers", teacherService.findByUser(currentUser));
        model.addAttribute("allTeachers",teacherService.listAll());
        model.addAttribute("rooms", roomService.findByUser(currentUser));
        model.addAttribute("allRooms",roomService.listAll());
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "lessonform";
    }

    @RequestMapping("evaluation/edit/{id}")
    public String editEvaluation(@PathVariable Integer id, Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("evaluation", evaluationService.getById(id));
        model.addAttribute("evalTypes", evalTypeService.listAll());
        model.addAttribute("lessons", lessonService.findBySubject_User(currentUser));
        model.addAttribute("teachers", teacherService.findByUser(currentUser));
        model.addAttribute("rooms", roomService.findByUser(currentUser));
        model.addAttribute("lessonTypes", lessonTypeService.listAll());
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "evalform";
    }

    @RequestMapping("homework/edit/{id}")
    public String editHomework(@PathVariable Integer id, Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();
        User currentUser = userService.getById(userId);

        model.addAttribute("note",noteService.getById(id));
        model.addAttribute("lessons", lessonService.findBySubject_User(currentUser));
        model.addAttribute("homework", homeworkService.getById(id));
        model.addAttribute("username",username);
        model.addAttribute("userId",userId);
        return "homeworkform";
    }

    @RequestMapping("note/edit/{id}")
    public String editNote(@PathVariable Integer id, Model model){
        model.addAttribute("note", noteService.getById(id));

        return "noteform";
    }

    @RequestMapping("user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model){
        model.addAttribute("user",userService.getById(id));
        model.addAttribute("roles",roleService.listAll());
//        model.addAttribute("version",userService.getById(id).getVersion()+1);
        return "admin/userform";
    }

    @RequestMapping("room/edit/{id}")
    public String editRoom(@PathVariable Integer id, Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();

        model.addAttribute("userId", userId);
        model.addAttribute("room", roomService.getById(id));
        return "roomform";
    }

    @RequestMapping("teacher/edit/{id}")
    public String editTeacher(@PathVariable Integer id, Model model){
        Object pri = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)pri).getUsername();
        Integer userId = userService.findByUsername(username).getId();

        model.addAttribute("userId", userId);
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

    @RequestMapping("user/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        User myUser = userService.getById(id);
        for (Subject s: myUser.getSubjects()){
            s.setUser(null);
        }
        for (Teacher t: myUser.getTeachers()){
            t.setUser(null);
        }
        for (Room r: myUser.getRooms()){
            r.setUser(null);
        }
        for (Role r: myUser.getRoles()){
            r.getUsers().remove(myUser);
        }

        userService.delete(id);
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

    //------------- Login ---------//

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
