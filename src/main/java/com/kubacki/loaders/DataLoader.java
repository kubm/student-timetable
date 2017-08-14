package com.kubacki.loaders;

import com.kubacki.domain.*;
import com.kubacki.repositories.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private LessonRepository lessonRepository;
    private SubjectRepository subjectRepository;
    private LessonTypeRepository lessonTypeRepository;
    private HomeworkRepository homeworkRepository;
    private EvalTypeRepository evalTypeRepository;
    private TeacherRepository teacherRepository;
    private RoomRepository roomRepository;
    private ColourRepository colourRepository;
    private EvaluationRepository evaluationRepository;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Autowired
    public void setEvaluationRepository(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Autowired
    public void setColourRepository(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public void setEvalTypeRepository(EvalTypeRepository evalTypeRepository){
        this.evalTypeRepository = evalTypeRepository;
    }


    @Autowired
    public void setLessonRepository(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }

    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Autowired
    public void setLessonTypeRepository(LessonTypeRepository lessonTypeRepository){
        this.lessonTypeRepository = lessonTypeRepository;
    }

    @Autowired
    public void setHomeworkRepository(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        //--------- Kolory -------------//
        Colour pomegranate = new Colour();
        pomegranate.setName("pomegranate");
        colourRepository.save(pomegranate);

        Colour amaranth = new Colour();
        amaranth.setName("amaranth");
        colourRepository.save(amaranth);

        Colour seance = new Colour();
        seance.setName("seance");
        colourRepository.save(seance);

        Colour purpleheart = new Colour();
        purpleheart.setName("purpleheart");
        colourRepository.save(purpleheart);

        Colour sanmarino = new Colour();
        sanmarino.setName("sanmarino");
        colourRepository.save(sanmarino);

        Colour dodgerblue = new Colour();
        dodgerblue.setName("dodgerblue");
        colourRepository.save(dodgerblue);

        Colour seagull = new Colour();
        seagull.setName("seagull");
        colourRepository.save(seagull);

        Colour sushi = new Colour();
        sushi.setName("sushi");
        colourRepository.save(sushi);

        Colour amber = new Colour();
        amber.setName("amber");
        colourRepository.save(amber);

        Colour pizazz = new Colour();
        pizazz.setName("pizazz");
        colourRepository.save(pizazz);

        Colour deepOrange = new Colour();
        deepOrange.setName("deep-orange");
        colourRepository.save(deepOrange);

        Colour persiangreen = new Colour();
        persiangreen.setName("persiangreen");
        colourRepository.save(persiangreen);



        //--------- Sale ---------------//

        Room e1 = new Room();
        e1.setRoomNumber("E1");
        e1.setBuilding("A2");
        roomRepository.save(e1);

        Room e2 = new Room();
        e2.setBuilding("A2");
        e2.setRoomNumber("E2");
        roomRepository.save(e2);

        Room e5 = new Room();
        e5.setRoomNumber("E5");
        e5.setBuilding("A2");
        roomRepository.save(e5);

        Room e6 = new Room();
        e6.setRoomNumber("E6");
        e6.setBuilding("A2");
        roomRepository.save(e6);

        Room e101 = new Room();
        e101.setRoomNumber("E101");
        e101.setBuilding("A2");
        roomRepository.save(e101);

        Room e102 = new Room();
        e102.setRoomNumber("E102");
        e102.setBuilding("A2");
        roomRepository.save(e102);

        Room e105 = new Room();
        e105.setRoomNumber("E105");
        e105.setBuilding("A2");
        roomRepository.save(e105);

        Room e106 = new Room();
        e106.setRoomNumber("E106");
        e106.setBuilding("A2");
        roomRepository.save(e106);





        //--------- Wykładowcy ---------//
        Teacher mmarian = new Teacher();
        mmarian.setName("Marian");
        mmarian.setSurname("Marianowski");
        mmarian.setEmail("mmarian@p.lodz.pl");
        mmarian.setPhone("6543217");
        teacherRepository.save(mmarian);

        Teacher jkowalska = new Teacher();
        jkowalska.setName("Jadwiga");
        jkowalska.setSurname("Kowalska");
        jkowalska.setEmail("jkowalska@p.lodz.pl");
        jkowalska.setPhone("65432118");
        teacherRepository.save(jkowalska);

        Teacher apietrzak = new Teacher();
        apietrzak.setName("Alicja");
        apietrzak.setSurname("Pietrzak");
        apietrzak.setEmail("apietrzak@p.lodz.pl");
        apietrzak.setPhone("6543219");
        teacherRepository.save(apietrzak);

        Teacher pnowak = new Teacher();
        pnowak.setName("Patryk");
        pnowak.setSurname("Nowak");
        pnowak.setEmail("pnowak@p.lodz.pl");
        pnowak.setPhone("6543220");
        teacherRepository.save(pnowak);

        Teacher kwojcik = new Teacher();
        kwojcik.setName("Krzysztof");
        kwojcik.setSurname("Wójcik");
        kwojcik.setEmail("kwojcik@p.lodz.pl");
        kwojcik.setPhone("6543221");
        teacherRepository.save(kwojcik);

        Teacher jstepien = new Teacher();
        jstepien.setName("Józef");
        jstepien.setSurname("Stępień");
        jstepien.setEmail("jstepien@p.lodz.pl");
        jstepien.setPhone("6543222");
        teacherRepository.save(jstepien);

        Teacher hkwiecien = new Teacher();
        hkwiecien.setName("Hanna");
        hkwiecien.setSurname("Kwiecień");
        hkwiecien.setEmail("hkwiecien@p.lodz.pl");
        hkwiecien.setPhone("6543223");
        teacherRepository.save(hkwiecien);

        //----------- Typy Zajęć --------//
        LessonType lectures = new LessonType();
        lectures.setNazwa("wykłady");
        lessonTypeRepository.save(lectures);
        log.info("Saved lectures");

        LessonType cwiczenia = new LessonType();
        cwiczenia.setNazwa("ćwiczenia");
        lessonTypeRepository.save(cwiczenia);
        log.info("Saved cwiczenia");

        LessonType labs = new LessonType();
        labs.setNazwa("laboratoria");
        lessonTypeRepository.save(labs);
        log.info("Saved labs");

        //----------- Typy Zaliczeń --------//
        EvalType egzamin = new EvalType();
        egzamin.setNazwa("Egzamin");
        evalTypeRepository.save(egzamin);
        log.info("Saved egzamin");

        EvalType kolokwium = new EvalType();
        kolokwium.setNazwa("Kolokwium");
        evalTypeRepository.save(kolokwium);
        log.info("Saved kolokwium");

        //----------- Przedmioty ---------//
        Subject analiza = new Subject();
        analiza.setName("Analiza Matematyczna");
        analiza.setColour(pomegranate);
        subjectRepository.save(analiza);
        log.info("Saved Analiza Matematyczna");

        Subject algorytmy = new Subject();
        algorytmy.setName("Algorytmy i struktury danych");
        algorytmy.setColour(amaranth);
        subjectRepository.save(algorytmy);
        log.info("Saved Algorytmy");

        Subject fizyka = new Subject();
        fizyka.setName("Fizyka");
        fizyka.setColour(seance);
        subjectRepository.save(fizyka);
        log.info("Saved Fizyka");

        Subject dyskretna = new Subject();
        dyskretna.setName("Matematyka Dyskretna");
        dyskretna.setColour(sanmarino);
        subjectRepository.save(dyskretna);
        log.info("Saved Matematyka Dyskretna");

        Subject bhp = new Subject();
        bhp.setName("BHP");
        bhp.setColour(sushi);
        subjectRepository.save(bhp);
        log.info("Saved BHP");

        //--------- Zajęcia ----------//

        Lesson cwiczenia_a = new Lesson();
        cwiczenia_a.setSubject(analiza);
        try {
            cwiczenia_a.setStart_date(format.parse("2017-01-03"));
            cwiczenia_a.setEnd_date(format.parse("2017-06-20"));
            //cwiczenia_a.setMyWeekDay(format.parse("2017-01-03"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cwiczenia_a.setStart_hour("08:15");
        cwiczenia_a.setEnd_hour("09:45");
        cwiczenia_a.setLessonType(cwiczenia);
        cwiczenia_a.setTeacher(hkwiecien);
        cwiczenia_a.setRoom(e105);
        lessonRepository.save(cwiczenia_a);
        log.info("Saved cwiczenia analiza");

        Lesson wyklad_a = new Lesson();
        wyklad_a.setSubject(analiza);
        try {
            wyklad_a.setStart_date(format.parse("2017-01-02"));
            wyklad_a.setEnd_date(format.parse("2017-06-19"));
            //wyklad_a.setMyWeekDay(format.parse("2017-01-02"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        wyklad_a.setStart_hour("09:15");
        wyklad_a.setEnd_hour("10:45");
        wyklad_a.setLessonType(lectures);
        wyklad_a.setTeacher(apietrzak);
        wyklad_a.setRoom(e2);
        lessonRepository.save(wyklad_a);
        log.info("Saved wyklad analiza");

        Lesson cwiczenia_alg = new Lesson();
        cwiczenia_alg.setSubject(algorytmy);
        try {
            cwiczenia_alg.setStart_date(format.parse("2017-01-04"));
            cwiczenia_alg.setEnd_date(format.parse("2017-06-21"));
            //cwiczenia_alg.setMyWeekDay(format.parse("2017-01-04"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cwiczenia_alg.setStart_hour("08:15");
        cwiczenia_alg.setEnd_hour("09:45");
        cwiczenia_alg.setLessonType(cwiczenia);
        cwiczenia_alg.setTeacher(jkowalska);
        cwiczenia_alg.setRoom(e106);
        lessonRepository.save(cwiczenia_alg);
        log.info("Saved Cwiczenia Algorytmy");

        Lesson wyklad_alg = new Lesson();
        wyklad_alg.setSubject(algorytmy);
        wyklad_alg.setLessonType(lectures);
        try{
            wyklad_alg.setStart_date(format.parse("2017-01-05"));
            wyklad_alg.setEnd_date(format.parse("2017-06-22"));
           //wyklad_alg.setMyWeekDay(format.parse("2017-01-05"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        wyklad_alg.setStart_hour("12:15");
        wyklad_alg.setEnd_hour("13:45");
        wyklad_alg.setTeacher(jstepien);
        wyklad_alg.setRoom(e1);
        lessonRepository.save(wyklad_alg);
        log.info("Saved Wykład Algorytmy");

        Lesson lab_fizyka = new Lesson();
        lab_fizyka.setLessonType(labs);
        try{
            lab_fizyka.setStart_date(format.parse("2017-01-05"));
            lab_fizyka.setEnd_date(format.parse("2017-06-22"));
            //lab_fizyka.setMyWeekDay(format.parse("2017-01-05"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        lab_fizyka.setStart_hour("08:15");
        lab_fizyka.setEnd_hour("09:45");
        lab_fizyka.setSubject(fizyka);
        lab_fizyka.setTeacher(mmarian);
        lab_fizyka.setRoom(e101);
        lessonRepository.save(lab_fizyka);
        log.info("Saved Labs Fizyka");

        Lesson wyklad_dysk = new Lesson();
        wyklad_dysk.setSubject(dyskretna);
        try{
            wyklad_dysk.setStart_date(format.parse("2017-01-04"));
            wyklad_dysk.setEnd_date(format.parse("2017-06-21"));
            //wyklad_dysk.setMyWeekDay(format.parse("2017-01-04"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        wyklad_dysk.setStart_hour("09:15");
        wyklad_dysk.setEnd_hour("10:45");
        wyklad_dysk.setLessonType(lectures);
        wyklad_dysk.setTeacher(kwojcik);
        wyklad_dysk.setRoom(e1);
        lessonRepository.save(wyklad_dysk);
        log.info("Saved Wykład Dysrketna");

        Lesson cwiczenia_dysk = new Lesson();
        try{
            cwiczenia_dysk.setStart_date(format.parse("2017-01-05"));
            cwiczenia_dysk.setEnd_date(format.parse("2017-06-22"));
            //cwiczenia_dysk.setMyWeekDay(format.parse("2017-01-05"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        cwiczenia_dysk.setStart_hour("14:15");
        cwiczenia_dysk.setEnd_hour("15:45");
        cwiczenia_dysk.setSubject(dyskretna);
        cwiczenia_dysk.setLessonType(cwiczenia);
        cwiczenia_dysk.setTeacher(hkwiecien);
        cwiczenia_dysk.setRoom(e101);
        lessonRepository.save(cwiczenia_dysk);
        log.info("Saved cwiczenia dyskretna");

        Lesson wyklad_bhp = new Lesson();
        wyklad_bhp.setLessonType(lectures);
        wyklad_bhp.setSubject(bhp);
        try{
            wyklad_bhp.setStart_date(format.parse("2017-01-06"));
            wyklad_bhp.setEnd_date(format.parse("2017-06-23"));
            //wyklad_bhp.setMyWeekDay(format.parse("2017-01-06"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        wyklad_bhp.setStart_hour("08:15");
        wyklad_bhp.setEnd_hour("09:45");
        wyklad_bhp.setTeacher(pnowak);
        wyklad_bhp.setRoom(e102);
        lessonRepository.save(wyklad_bhp);
        log.info("Saved Wyklad BHP");

        //--------- Zaliczenia ----------//
        Evaluation analiza_eg = new Evaluation();
        analiza_eg.setEvaluationType(egzamin);
        analiza_eg.setLesson(wyklad_a);
        analiza_eg.setRoom(e1);
        try{
            analiza_eg.setDzien(format.parse("2017-09-04"));
        }catch (ParseException e){
            e.printStackTrace();
        }
        analiza_eg.setHour("08:15");
        evaluationRepository.save(analiza_eg);

        Evaluation algorytmy_kol = new Evaluation();
        algorytmy_kol.setEvaluationType(kolokwium);
        algorytmy_kol.setLesson(cwiczenia_alg);
        algorytmy_kol.setRoom(e101);
        try{
            algorytmy_kol.setDzien(format.parse("2017-09-05"));
        }catch (ParseException e){
            e.printStackTrace();
        }
        algorytmy_kol.setHour("08:15");
        evaluationRepository.save(algorytmy_kol);

        Evaluation dyskretna_egz = new Evaluation();
        dyskretna_egz.setEvaluationType(egzamin);
        dyskretna_egz.setLesson(wyklad_dysk);
        dyskretna_egz.setRoom(e2);
        try{
            dyskretna_egz.setDzien(format.parse("2017-09-06"));
        }catch (ParseException e){
            e.printStackTrace();
        }
        dyskretna_egz.setHour("10:15");
        evaluationRepository.save(dyskretna_egz);


    }
}
