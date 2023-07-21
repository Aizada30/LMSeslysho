package model;

import java.util.ArrayList;
import java.util.List;

public class Group {
        private String name;
        private String descriptions;
        private long id;
        private List<Lesson> lessons = new ArrayList<>();
        private List<Student> students = new ArrayList<>();

        public Group(){

        }

        public Group(String name, String descriptions) {
            this.name = name;
            this.descriptions = descriptions;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescriptions() {
            return descriptions;
        }

        public void setDescriptions(String descriptions) {
            this.descriptions = descriptions;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public List<Lesson> getLessons() {
            return lessons;
        }

        public void setLessons(List<Lesson> lessons) {
            this.lessons = lessons;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        @Override
        public String toString() {
            return "\n          Group: " +
                    "\nId: " + id +
                    "\nName: " + name +
                    "\nDescriptions: " + descriptions +
                    "\n          Lessons: " + lessons +
                    "\n          Students=" + students;
        }
    }

